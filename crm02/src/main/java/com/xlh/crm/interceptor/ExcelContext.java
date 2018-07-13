package com.xlh.crm.interceptor;

import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.math.BigDecimal;
import java.net.URL;

public class ExcelContext extends Context {
    @Override
    public void resolveContent(String filePath) throws Exception {
        File file = new File(filePath);
        Workbook workbook = null;
        FileInputStream fis = null;
        StringBuffer sb = new StringBuffer();
        try {
            workbook = WorkbookFactory.create(file);
            Sheet sheet;
            sheet = workbook.getSheetAt(workbook.getNumberOfSheets() - 1);
            int rows = sheet.getLastRowNum();
            for (int r = 0; r <= rows; r++) {
                Row row = sheet.getRow(r);
                int cells = row.getLastCellNum();
                for (int c = 0; c < cells; c++) {
                    String str = getCellValue(row.getCell(c));
                    sb.append(str);
                    sb.append("  ");
                }
                sb.append("\n");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                workbook.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        content = sb.toString();
    }


    public void resolveContent(String filePath,Integer sheetNum) throws Exception {
        File file = new File(filePath);
        Workbook workbook = null;
        FileInputStream fis = null;
        StringBuffer sb = new StringBuffer();
        try {
            workbook = WorkbookFactory.create(file);
            Sheet sheet;
            sheet = workbook.getSheetAt(sheetNum);
            int rows = sheet.getLastRowNum();
            for (int r = 0; r <= rows; r++) {
                Row row = sheet.getRow(r);
                int cells = row.getLastCellNum();
                for (int c = 0; c < cells; c++) {
                    String str = getCellValue(row.getCell(c));
                    sb.append(str);
                    sb.append("  ");
                }
                sb.append("\n");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                workbook.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        content = sb.toString();
    }

    @Override
    public void resolveContent(URL url) throws Exception {

    }

    public static String getCellValue(Cell cell) {
        int cellType = cell.getCellType();
        String cellValue = "";
        switch (cellType) {
            case 0:
                cellValue = new BigDecimal(cell.getNumericCellValue()).setScale(2, BigDecimal.ROUND_HALF_UP).toString();
                break;
            case 1:
                cellValue = cell.getStringCellValue();
                break;

            case 2:
                try {
                    cellValue = cell.getStringCellValue();
                } catch (IllegalStateException e) {
                    cellValue = String.valueOf(cell.getNumericCellValue());
                }
                break;
//            case 3:
//                cellValue = String.valueOf(cell.getBooleanCellValue());
//                break;
            default:
                cellValue = cell.getStringCellValue();
        }

        return cellValue.trim().replace(" ", "").replace("　", "").replace(" ", "");
    }
}
