package com.xlh.crm;


import com.alibaba.fastjson.JSON;
import com.xlh.crm.dto.mysql.FiExcelSheet;
import com.xlh.crm.dto.mysql.FiFileList;
import com.xlh.crm.mapper.FiExcelSheetMapper;
import com.xlh.crm.mapper.FiFileListMapper;
import com.xlh.crm.utils.FileOperate;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = crmApplication.class)
@WebAppConfiguration
public class FileTest {
    @Value("${finance.source.path}")
    private String filePath;

    private SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Autowired
    private FiFileListMapper fiFileListMapper;

    @Autowired
    private FiExcelSheetMapper fiExcelSheetMapper;

    @Test
    public void test1() throws IOException {
//        FiExcelSheet record=new FiExcelSheet();
//        record.setId(1);
//        List<FiExcelSheet> fiExcelSheetList=fiExcelSheetMapper.selectAll();
//        FiExcelSheet fiExcelSheet=fiExcelSheetMapper.selectByPrimaryKey(1);
        String [] files=FileOperate.readfile(filePath);
        for(int i=0;i<files.length;i++){
            FiFileList fiFileList=new FiFileList();
            fiFileList.setCreateTime(simpleDateFormat.format(new Date()));
            fiFileList.setFileName(files[i]);
            fiFileList.setStatus(0);
            Integer fileId=fiFileListMapper.insert(fiFileList);
            System.out.println(JSON.toJSONString(fiFileList));
            insertSheet(filePath,files[i],fiFileList.getId());
        }
    }

    private void insertSheet(String filePath,String fileName,Integer fileId){
        File file = new File(filePath+fileName);
        Workbook workbook = null;
        FileInputStream fis = null;
        StringBuffer sb = new StringBuffer();
        try {
            workbook = WorkbookFactory.create(file);
            Sheet sheet;
            System.out.println(workbook.getNumberOfSheets());
            for(int i=0;i<workbook.getNumberOfSheets();i++){
                FiExcelSheet fiExcelSheet=new FiExcelSheet();
                fiExcelSheet.setCreateTime(simpleDateFormat.format(new Date()));
                fiExcelSheet.setFileId(fileId);
                fiExcelSheet.setSheetNum(i);
                fiExcelSheet.setSheetName(workbook.getSheetAt(i).getSheetName());
                fiExcelSheet.setStatus(0);
                fiExcelSheetMapper.insert(fiExcelSheet);
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

    }
}
