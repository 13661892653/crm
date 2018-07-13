package com.xlh.crm.dto.financeinputshow;

import com.xlh.crm.dto.mysql.FiExcelSheet;
import com.xlh.crm.dto.mysql.FiFileList;

import java.util.List;

public class ExcelFileDetail extends FiExcelSheet {
    private FiFileList fiFileList;
    private List<FiExcelSheet> fiExcelSheetList;

    public FiFileList getFiFileList() {
        return fiFileList;
    }

    public void setFiFileList(FiFileList fiFileList) {
        this.fiFileList = fiFileList;
    }

    public List<FiExcelSheet> getFiExcelSheetList() {
        return fiExcelSheetList;
    }

    public void setFiExcelSheetList(List<FiExcelSheet> fiExcelSheetList) {
        this.fiExcelSheetList = fiExcelSheetList;
    }
}
