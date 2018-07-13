package com.xlh.crm;

import com.alibaba.fastjson.JSON;
import com.xlh.crm.dto.mysql.CdmMongodbEnterpriseBaseInfo;
import com.xlh.crm.dto.mysql.FiExcelSheet;
import com.xlh.crm.dto.mysql.FiFileList;
import com.xlh.crm.mapper.CdmMongodbEnterpriseBaseInfoMapper;
import com.xlh.crm.mapper.FiExcelSheetMapper;
import com.xlh.crm.mapper.FiFileListMapper;
import org.apache.logging.log4j.util.Strings;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = crmApplication.class)
@WebAppConfiguration
public class InsertTest {
    @Autowired
    private CdmMongodbEnterpriseBaseInfoMapper cdmMongodbEnterpriseBaseInfoMapper;



    @Value("${finance.source.path}")
    private String filePath;

    private SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Autowired
    private FiFileListMapper fiFileListMapper;

    @Autowired
    private FiExcelSheetMapper fiExcelSheetMapper;
    @Test
    public void test(){
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        List<CdmMongodbEnterpriseBaseInfo> list=cdmMongodbEnterpriseBaseInfoMapper.selectAll();
        List<FiFileList> fiFileLists=new ArrayList<>();
        FiFileList recode=new FiFileList();
        for(int i=0;i<list.size();i++){
            recode=new FiFileList();
            recode.setStatus(0);
            recode.setFileName(list.get(i).getAssetDebtFile());
            recode.setEnterpriseName(list.get(i).getEnterpriseName());
            recode.setCreateTime(simpleDateFormat.format(new Date()));
            fiFileLists.add(recode);
            recode=new FiFileList();
            recode.setStatus(0);
            recode.setFileName(list.get(i).getCashFlowFile());
            recode.setEnterpriseName(list.get(i).getEnterpriseName());
            recode.setCreateTime(simpleDateFormat.format(new Date()));
            fiFileLists.add(recode);
            recode=new FiFileList();
            recode.setStatus(0);
            recode.setFileName(list.get(i).getProfitDistributionFile());
            recode.setEnterpriseName(list.get(i).getEnterpriseName());
            recode.setCreateTime(simpleDateFormat.format(new Date()));
            fiFileLists.add(recode);
        }
        list=cdmMongodbEnterpriseBaseInfoMapper.selectJoin();

        for(int i=0;i<list.size();i++){
            recode=new FiFileList();
            recode.setStatus(0);
            recode.setFileName(list.get(i).getProfitDistributionFile());
            recode.setEnterpriseName(list.get(i).getEnterpriseName());
            recode.setCreateTime(simpleDateFormat.format(new Date()));
            fiFileLists.add(recode);
        }
        for(int i=0;i<fiFileLists.size();i++){
            try{
                if(Strings.isEmpty(fiFileLists.get(i).getFileName())||fiFileLists.get(i).getFileName()==null||Strings.isEmpty(fiFileLists.get(i).getEnterpriseName())||fiFileLists.get(i).getEnterpriseName()==null){
                    continue;
                }
                fiFileListMapper.insert(fiFileLists.get(i));
                insertSheet(filePath,fiFileLists.get(i).getFileName(), fiFileLists.get(i).getId());
                System.out.println(fiFileLists.get(i).getFileName()+"__________________"+String.valueOf(i));
            }catch (Exception e){

            }
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
