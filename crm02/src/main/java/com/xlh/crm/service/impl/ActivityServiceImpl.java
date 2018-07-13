package com.xlh.crm.service.impl;

import com.xlh.crm.dto.ActManageListRespDTO;
import com.xlh.crm.dto.ActShowDTO;
import com.xlh.crm.dto.PageReqDTO;
import com.xlh.crm.dto.PageResp.ActivityListResp;
import com.xlh.crm.dto.UserInfoDTO;
import com.xlh.crm.dto.mysql.CrmActive;
import com.xlh.crm.mapper.ActMapper;
import com.xlh.crm.mapper.CrmActiveMapper;
import org.apache.ibatis.session.RowBounds;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.codehaus.plexus.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class ActivityServiceImpl {

    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    @Autowired
    CrmActiveMapper crmActiveMapper;
    @Autowired
    SessionServiceImpl sessionService;
    /**
     * 解析参会人员excel
     * @param file
     * @return
     * @throws IOException
     * @throws InvalidFormatException
     */
    public List<Map<String,String>> dealExcel(File file) throws IOException, InvalidFormatException {
        DecimalFormat df = new DecimalFormat("#");
        Workbook workbook = WorkbookFactory.create(file);
        Sheet sheet=workbook.getSheetAt(0);
        List<Map<String,String>> result=new ArrayList<>();
        Row row=null;
        int rowNums=sheet.getLastRowNum();
        for(int i=1;i<=rowNums;i++){
            row=sheet.getRow(i);
            Map<String,String> map=new HashMap();
            map.put("company",row.getCell(0).getStringCellValue());
            map.put("name",row.getCell(1).getStringCellValue());
            try{
                map.put("mobile",df.format(row.getCell(2).getNumericCellValue()));
            }catch (Exception e){
                map.put("mobile",row.getCell(2).getStringCellValue());
            }
            result.add(map);
        }
        return result;
    }
    //活动列表
    @Transactional
    public ActivityListResp actManageList(PageReqDTO req) {
        UserInfoDTO userInfoDTO=sessionService.getUser();
        ActivityListResp respDTO = new ActivityListResp();

        Example example=new Example(CrmActive.class);
        Example.Criteria criteria = example.createCriteria();
        if(new Integer(userInfoDTO.getMemberType())>90){
            criteria.andEqualTo("operator",userInfoDTO.getUserName());
        }
        if(new Integer(userInfoDTO.getMemberType())==90){
            criteria.andEqualTo("company",userInfoDTO.getCompany());
        }
        if(!req.getTimeBegin().equals("all")){
            criteria.andGreaterThanOrEqualTo("beginTime",req.getTimeBegin());
        }
        if(!req.getTimeEnd().equals("all")){
            criteria.andLessThanOrEqualTo("beginTime",req.getTimeEnd());
        }
        example.orderBy(" updateTime").desc();
        RowBounds rowBounds=new RowBounds((req.getPageIndex()-1)*req.getPageSize(),req.getPageSize());
        List<CrmActive> crmActives=crmActiveMapper.selectByExampleAndRowBounds(example,rowBounds);
        for(CrmActive crmActive:crmActives){
            if("JB01".equals(crmActive.getUsRole())){
                crmActive.setUsRole("主办方");
            }else if("JB02".equals(crmActive.getUsRole())){
                crmActive.setUsRole("承办方");
            }else if("JB03".equals(crmActive.getUsRole())){
                crmActive.setUsRole("协办方");
            }
            if("AT01".equals(crmActive.getActType())){
                crmActive.setActType("培训");
            }else if("AT02".equals(crmActive.getActType())){
                crmActive.setActType("约咖");
            }else if("AT03".equals(crmActive.getActType())){
                crmActive.setActType("会销");
            }else if("AT04".equals(crmActive.getActType())){
                crmActive.setActType("大赛");
            }
        }
        respDTO.setCrmActives(crmActives);
        Integer totalCount = crmActiveMapper.selectCountByExample(example);
        totalCount = totalCount == null ? 0 : totalCount;
        respDTO.setTotalPageCount((int)Math.ceil((double)totalCount / req.getPageSize()));
        respDTO.setTotalRecCount(totalCount);
        return respDTO;
    }

    public HSSFWorkbook listExcel(PageReqDTO req){
        UserInfoDTO userInfoDTO=sessionService.getUser();
        Example example=new Example(CrmActive.class);
        Example.Criteria criteria = example.createCriteria();
        if(new Integer(userInfoDTO.getMemberType())>90){
            criteria.andEqualTo("operator",userInfoDTO.getUserName());
        }
        if(new Integer(userInfoDTO.getMemberType())==90){
            criteria.andEqualTo("company",userInfoDTO.getCompany());
        }
        if(!req.getTimeBegin().equals("all")){
            criteria.andGreaterThanOrEqualTo("beginTime",req.getTimeBegin());
        }
        if(!req.getTimeEnd().equals("all")){
            criteria.andLessThanOrEqualTo("beginTime",req.getTimeEnd());
        }
        example.orderBy(" updateTime").desc();
        List<CrmActive> crmActives=crmActiveMapper.selectByExample(example);
        for(CrmActive crmActive:crmActives){
            if("JB01".equals(crmActive.getUsRole())){
                crmActive.setUsRole("主办方");
            }else if("JB02".equals(crmActive.getUsRole())){
                crmActive.setUsRole("承办方");
            }else if("JB03".equals(crmActive.getUsRole())){
                crmActive.setUsRole("协办方");
            }
            if("AT01".equals(crmActive.getActType())){
                crmActive.setActType("培训");
            }else if("AT02".equals(crmActive.getActType())){
                crmActive.setActType("约咖");
            }else if("AT03".equals(crmActive.getActType())){
                crmActive.setActType("会销");
            }else if("AT04".equals(crmActive.getActType())){
                crmActive.setActType("大赛");
            }
        }

        HSSFWorkbook workbook = new HSSFWorkbook();
        Sheet sheet=workbook.createSheet();
        Row row=sheet.createRow(0);
        row.createCell(0).setCellValue("发起分公司");
        row.createCell(1).setCellValue("活动归类");
        row.createCell(2).setCellValue("活动名");
        row.createCell(3).setCellValue("活动开展时间");
        row.createCell(4).setCellValue("活动举办地点");
        row.createCell(5).setCellValue("我司角色");
        row.createCell(6).setCellValue("活动类型");
        row.createCell(7).setCellValue("参与人数");
        CrmActive crmActive;
        for(int i=0;i<crmActives.size();i++){
            crmActive=crmActives.get(i);
            row=sheet.createRow(i+1);
            row.createCell(0).setCellValue(crmActive.getCompany());
            row.createCell(1).setCellValue(crmActive.getBizLv1Id());
            row.createCell(2).setCellValue(crmActive.getActName());
            row.createCell(3).setCellValue(crmActive.getBeginTime()+"至"+crmActive.getEndTime());
            row.createCell(4).setCellValue(crmActive.getActLocation());
            row.createCell(5).setCellValue(crmActive.getUsRole());
            row.createCell(6).setCellValue(crmActive.getActType());
            row.createCell(7).setCellValue(crmActive.getJoinPersons());
        }
        return workbook;
    }
    public CrmActive actDetail(int recId){
        return crmActiveMapper.selectByPrimaryKey(recId);
    }

    public int save(CrmActive crmActive){
        UserInfoDTO userInfoDTO=sessionService.getUser();
        crmActive.setUpdateTime(simpleDateFormat.format(new Date()));
        crmActive.setCompany(userInfoDTO.getCompany());
        crmActive.setOperator(userInfoDTO.getUserName());
        if(crmActive.getRecId()>0){
            return crmActiveMapper.updateByPrimaryKey(crmActive);
        }else{
            String actNo = null;
            String curtimestr = null;
            curtimestr = Long.toString(System.currentTimeMillis());
            actNo = "A".concat(curtimestr.substring(curtimestr.length() - 6, curtimestr.length()));
            crmActive.setActNo(actNo);
            return crmActiveMapper.insert(crmActive);
        }
    }
}
