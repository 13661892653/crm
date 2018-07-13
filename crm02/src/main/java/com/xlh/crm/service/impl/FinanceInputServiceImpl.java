package com.xlh.crm.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.xlh.crm.common.CurrentTime;
import com.xlh.crm.dto.UserInfoDTO;
import com.xlh.crm.dto.dynamicReport.DynamicReport;
import com.xlh.crm.dto.financeinputshow.*;
import com.xlh.crm.dto.mysql.*;
import com.xlh.crm.enums.DynamicReportSignEnum;
import com.xlh.crm.interceptor.ExcelContext;
import com.xlh.crm.interceptor.NonTypeExcel.JxNormalProfitExpressionExcel;
import com.xlh.crm.interceptor.NonTypeExcel.JxSmallProfitExpressionExcel;
import com.xlh.crm.interceptor.dynamicReport.DynamicReportSign;
import com.xlh.crm.mapper.*;
import com.xlh.crm.service.EffectDataService;
import com.xlh.crm.service.FinanceInputService;
import com.xlh.crm.utils.BeanUtil;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import tk.mybatis.mapper.entity.Example;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class FinanceInputServiceImpl implements FinanceInputService {
    private Logger logger = LoggerFactory.getLogger(FinanceInputServiceImpl.class);

    @Autowired
    private SessionServiceImpl sessionService;
    @Autowired
    private FiFileListMapper fiFileListMapper;

    @Autowired
    private FiExcelSheetMapper fiExcelSheetMapper;

    @Autowired
    private FiTmpExcelJxNormalBalanceTableMapper fiTmpExcelJxNormalBalanceTableMapper;

    @Autowired
    private FiTmpExcelJxNormalProfitTableMapper fiTmpExcelJxNormalProfitTableMapper;

    @Autowired
    private FiTmpExcelJxSmallProfitTableMapper fiTmpExcelJxSmallProfitTableMapper;

    @Autowired
    private FiTmpExcelJxSmallBalanceTableMapper fiTmpExcelJxSmallBalanceTableMapper;

    @Autowired
    private EffectDataService effectDataService;
    @Autowired
    private FiDynamicReportApiReqMapper fiDynamicReportApiReqMapper;
    @Autowired
    private FiDynamicReportStructMapper fiDynamicReportStructMapper;
    @Autowired
    private MongoTemplate mongoTemplate;


    @Value("${finance.source.path}")
    private String filePath;

    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public List<FiFileList> getList() {
        Example example = new Example(FiFileList.class);
        example.createCriteria().andLessThan("status", 2);
        example.orderBy("wantFinancing").asc();
        example.orderBy("enterpriseName").desc();
        List<FiFileList> list = fiFileListMapper.selectByExample(example);
        return list;
//            return fiFileListMapper.selectAll();
    }

    public List<FiFileList> getCopyList() {
        Example example = new Example(FiFileList.class);
        example.createCriteria().andGreaterThan("status", 1).andLessThan("status", 4);//这里给出的条件查询为id>100
        example.orderBy("wantFinancing").asc();
        example.orderBy("enterpriseName").desc();
        List<FiFileList> list = fiFileListMapper.selectByExample(example);
        return list;
//            return fiFileListMapper.selectAll();
    }

    public ExcelFileDetail getFileDetail(FiFileList fiFileList) {
        ExcelFileDetail excelFileDetail = new ExcelFileDetail();
        FiFileList fiFileList1 = fiFileListMapper.selectByPrimaryKey(fiFileList.getId());
        FiExcelSheet condition = new FiExcelSheet();
        condition.setFileId(fiFileList1.getId());
        Example example = new Example(FiExcelSheet.class);
        example.createCriteria().andEqualTo("fileId", fiFileList.getId());//这里给出的条件查询为id>100
        List<FiExcelSheet> fiExcelSheetList = fiExcelSheetMapper.selectByExample(example);
        excelFileDetail.setFiFileList(fiFileList1);
        excelFileDetail.setFiExcelSheetList(fiExcelSheetList);
        return excelFileDetail;
    }

    public int updateSheet(FiExcelSheet fiExcelSheet) throws Exception {
        FiExcelSheet record = fiExcelSheetMapper.selectByPrimaryKey(fiExcelSheet.getId());
        if (record == null) {
            throw new Exception("未找到数据");
        }
        if (record.getStatus() != 0 && record.getStatus() != 2) {
            throw new Exception("锁定状态");
        }
        record.setSheetStander(fiExcelSheet.getSheetStander());
        record.setReportType(fiExcelSheet.getReportType());
        record.setTableName(fiExcelSheet.getTableName());
        record.setSheetDate(fiExcelSheet.getSheetDate());
        if (("wuxiao").equals(fiExcelSheet.getSheetType())) {
            if (new Integer(sessionService.getUser().getMemberType()) == 11) {
                record.setStatus(1);
            }
            if (new Integer(sessionService.getUser().getMemberType()) == 12) {
                record.setStatus(3);
            }
        }
        return fiExcelSheetMapper.updateByPrimaryKey(record);
    }

    public FiFileList updateFile(FiFileList fiFileList) throws Exception {
        FiFileList record = fiFileListMapper.selectByPrimaryKey(fiFileList.getId());
        if (record == null) {
            throw new Exception("未找到数据");
        }
        if (record.getStatus() != 0) {
            throw new Exception("锁定状态");
        }
        record.setRegCreditNo(fiFileList.getRegCreditNo());
        record.setCreditNo(fiFileList.getCreditNo());
        record.setRegNo(fiFileList.getRegNo());
        record.setEnterpriseName(fiFileList.getEnterpriseName());
        record.setStatus(1);
        fiFileListMapper.updateByPrimaryKey(record);
        return record;
    }

    public ExcelFileDetail tableEdit(Integer id) throws Exception {
        FiExcelSheet fiExcelSheet = fiExcelSheetMapper.selectByPrimaryKey(id);
        if (fiExcelSheet == null) {
            throw new Exception("未找到数据");
        }
        if (fiExcelSheet.getSheetType() == null || ("").equals(fiExcelSheet.getSheetType())) {
            throw new Exception("未选择表类型");
        }

        ExcelFileDetail excelFileDetail = new ExcelFileDetail();
        FiFileList fiFileList1 = fiFileListMapper.selectByPrimaryKey(fiExcelSheet.getFileId());
        excelFileDetail.setFiFileList(fiFileList1);
        List<FiExcelSheet> list = new ArrayList<>();
        list.add(fiExcelSheet);
        excelFileDetail.setFiExcelSheetList(list);
        return excelFileDetail;
    }

    public int tableEditDoJXNormalBalanceTableDto(Integer sheetId, JXNormalBalanceTableDto jxNormalBalanceTableDto) {
        FiTmpExcelJxNormalBalanceTable fiTmpExcelJxNormalBalanceTable = new FiTmpExcelJxNormalBalanceTable();
        BeanUtils.copyProperties(jxNormalBalanceTableDto, fiTmpExcelJxNormalBalanceTable);
        FiExcelSheet fiExcelSheet = fiExcelSheetMapper.selectByPrimaryKey(sheetId);
        FiFileList fiFileList = fiFileListMapper.selectByPrimaryKey(fiExcelSheet.getFileId());
        fiTmpExcelJxNormalBalanceTable.setCreate_time(simpleDateFormat.format(new Date()));
        fiTmpExcelJxNormalBalanceTable.setFileId(fiFileList.getId());
        fiTmpExcelJxNormalBalanceTable.setFileName(fiFileList.getFileName());
        fiTmpExcelJxNormalBalanceTable.setSheetId(fiExcelSheet.getId());
        fiTmpExcelJxNormalBalanceTable.setRoleId(new Integer(sessionService.getUser().getMemberType()));
        fiTmpExcelJxNormalBalanceTable.setCreditNo(fiFileList.getCreditNo());
        fiTmpExcelJxNormalBalanceTable.setEnterpriseName(fiFileList.getEnterpriseName());
        fiTmpExcelJxNormalBalanceTable.setBeginTime(fiExcelSheet.getSheetDate());

        Example example = new Example(FiTmpExcelJxNormalBalanceTable.class);
        example.createCriteria().andEqualTo("fileId", fiFileList.getId()).andEqualTo("sheetId", fiExcelSheet.getId()).andEqualTo("roleId", new Integer(sessionService.getUser().getMemberType()));//这里给出的条件查询为id>100
        List<FiTmpExcelJxNormalBalanceTable> list = fiTmpExcelJxNormalBalanceTableMapper.selectByExample(example);
        if (list.size() < 1) {
            fiTmpExcelJxNormalBalanceTableMapper.insert(fiTmpExcelJxNormalBalanceTable);
        } else {
            fiTmpExcelJxNormalBalanceTableMapper.updateByExample(fiTmpExcelJxNormalBalanceTable, example);
        }
        if (new Integer(sessionService.getUser().getMemberType()) == 11) {
            fiExcelSheet.setStatus(1);
        }
        if (new Integer(sessionService.getUser().getMemberType()) == 12) {
            fiExcelSheet.setStatus(3);
        }
        return fiExcelSheetMapper.updateByPrimaryKey(fiExcelSheet);
    }

    public FiTmpExcelJxNormalBalanceTable tableEditJXNormalBalanceTableDto(Integer sheetId) {
        FiExcelSheet fiExcelSheet = fiExcelSheetMapper.selectByPrimaryKey(sheetId);
        FiFileList fiFileList = fiFileListMapper.selectByPrimaryKey(fiExcelSheet.getFileId());
        Example example = new Example(FiTmpExcelJxNormalBalanceTable.class);
        example.createCriteria().andEqualTo("fileId", fiFileList.getId()).andEqualTo("sheetId", fiExcelSheet.getId()).andEqualTo("roleId", new Integer(sessionService.getUser().getMemberType()));//这里给出的条件查询为id>100
        List<FiTmpExcelJxNormalBalanceTable> list = fiTmpExcelJxNormalBalanceTableMapper.selectByExample(example);
        if (list.size() > 0) {
            return list.get(0);
        } else {

            FiTmpExcelJxNormalBalanceTable res = new FiTmpExcelJxNormalBalanceTable();
            res.setBeginTime(fiExcelSheet.getSheetDate());
            return res;
        }
    }

    public int tableEditDoJXNormalProfitTableDto(Integer sheetId, JXNormalProfitTableDto jxNormalProfitTableDto) {
        FiTmpExcelJxNormalProfitTable fiTmpExcelJxNormalProfitTable = new FiTmpExcelJxNormalProfitTable();
        BeanUtils.copyProperties(jxNormalProfitTableDto, fiTmpExcelJxNormalProfitTable);
        FiExcelSheet fiExcelSheet = fiExcelSheetMapper.selectByPrimaryKey(sheetId);
        FiFileList fiFileList = fiFileListMapper.selectByPrimaryKey(fiExcelSheet.getFileId());
        fiTmpExcelJxNormalProfitTable.setCreate_time(simpleDateFormat.format(new Date()));
        fiTmpExcelJxNormalProfitTable.setFileId(fiFileList.getId());
        fiTmpExcelJxNormalProfitTable.setFileName(fiFileList.getFileName());
        fiTmpExcelJxNormalProfitTable.setSheetId(fiExcelSheet.getId());
        fiTmpExcelJxNormalProfitTable.setRoleId(new Integer(sessionService.getUser().getMemberType()));
        fiTmpExcelJxNormalProfitTable.setCreditNo(fiFileList.getCreditNo());
        fiTmpExcelJxNormalProfitTable.setEnterpriseName(fiFileList.getEnterpriseName());
        fiTmpExcelJxNormalProfitTable.setBeginTime(fiExcelSheet.getSheetDate());

        Example example = new Example(FiTmpExcelJxNormalProfitTable.class);
        example.createCriteria().andEqualTo("fileId", fiFileList.getId()).andEqualTo("sheetId", fiExcelSheet.getId()).andEqualTo("roleId", new Integer(sessionService.getUser().getMemberType()));//这里给出的条件查询为id>100
        List<FiTmpExcelJxNormalProfitTable> list = fiTmpExcelJxNormalProfitTableMapper.selectByExample(example);
        if (list.size() < 1) {
            fiTmpExcelJxNormalProfitTableMapper.insert(fiTmpExcelJxNormalProfitTable);
        } else {
            fiTmpExcelJxNormalProfitTableMapper.updateByExample(fiTmpExcelJxNormalProfitTable, example);
        }
        if (new Integer(sessionService.getUser().getMemberType()) == 11) {
            fiExcelSheet.setStatus(1);
        }
        if (new Integer(sessionService.getUser().getMemberType()) == 12) {
            fiExcelSheet.setStatus(3);
        }
        return fiExcelSheetMapper.updateByPrimaryKey(fiExcelSheet);
    }

    public FiTmpExcelJxNormalProfitTable tableEditJXNormalProfitTableDto(Integer sheetId) {
        FiExcelSheet fiExcelSheet = fiExcelSheetMapper.selectByPrimaryKey(sheetId);
        FiFileList fiFileList = fiFileListMapper.selectByPrimaryKey(fiExcelSheet.getFileId());
        Example example = new Example(FiTmpExcelJxNormalProfitTable.class);
        example.createCriteria().andEqualTo("fileId", fiFileList.getId()).andEqualTo("sheetId", fiExcelSheet.getId()).andEqualTo("roleId", new Integer(sessionService.getUser().getMemberType()));//这里给出的条件查询为id>100
        List<FiTmpExcelJxNormalProfitTable> list = fiTmpExcelJxNormalProfitTableMapper.selectByExample(example);
        if (list.size() > 0) {
            return list.get(0);
        } else {
            ExcelContext excelContext = new ExcelContext();
            try {
                excelContext.resolveContent(filePath + fiFileList.getFileName(), fiExcelSheet.getSheetNum());
                JxNormalProfitExpressionExcel jxNormalProfitExpressionExcel = new JxNormalProfitExpressionExcel();
                FiTmpExcelJxNormalProfitTable res = jxNormalProfitExpressionExcel.interpret(excelContext.getContent());
                res.setBeginTime(fiExcelSheet.getSheetDate());
                return res;
            } catch (Exception e) {

                FiTmpExcelJxNormalProfitTable res = new FiTmpExcelJxNormalProfitTable();
                res.setBeginTime(fiExcelSheet.getSheetDate());
                return res;
            }
        }
    }


    public int tableEditDoJXSmallProfitTableDto(Integer sheetId, JXSmallProfitTableDto jxSmallProfitTableDto) {
        FiTmpExcelJxSmallProfitTable fiTmpExcelJxSmallProfitTablef = new FiTmpExcelJxSmallProfitTable();
        BeanUtils.copyProperties(jxSmallProfitTableDto, fiTmpExcelJxSmallProfitTablef);
        FiExcelSheet fiExcelSheet = fiExcelSheetMapper.selectByPrimaryKey(sheetId);
        FiFileList fiFileList = fiFileListMapper.selectByPrimaryKey(fiExcelSheet.getFileId());
        fiTmpExcelJxSmallProfitTablef.setCreate_time(simpleDateFormat.format(new Date()));
        fiTmpExcelJxSmallProfitTablef.setFileId(fiFileList.getId());
        fiTmpExcelJxSmallProfitTablef.setFileName(fiFileList.getFileName());
        fiTmpExcelJxSmallProfitTablef.setSheetId(fiExcelSheet.getId());
        fiTmpExcelJxSmallProfitTablef.setRoleId(new Integer(sessionService.getUser().getMemberType()));
        fiTmpExcelJxSmallProfitTablef.setCreditNo(fiFileList.getCreditNo());
        fiTmpExcelJxSmallProfitTablef.setEnterpriseName(fiFileList.getEnterpriseName());
        fiTmpExcelJxSmallProfitTablef.setBeginTime(fiExcelSheet.getSheetDate());

        Example example = new Example(FiTmpExcelJxSmallProfitTable.class);
        example.createCriteria().andEqualTo("fileId", fiFileList.getId()).andEqualTo("sheetId", fiExcelSheet.getId()).andEqualTo("roleId", new Integer(sessionService.getUser().getMemberType()));//这里给出的条件查询为id>100
        List<FiTmpExcelJxSmallProfitTable> list = fiTmpExcelJxSmallProfitTableMapper.selectByExample(example);
        if (list.size() < 1) {
            fiTmpExcelJxSmallProfitTableMapper.insert(fiTmpExcelJxSmallProfitTablef);
        } else {
            fiTmpExcelJxSmallProfitTableMapper.updateByExample(fiTmpExcelJxSmallProfitTablef, example);
        }
        if (new Integer(sessionService.getUser().getMemberType()) == 11) {
            fiExcelSheet.setStatus(1);
        }
        if (new Integer(sessionService.getUser().getMemberType()) == 12) {
            fiExcelSheet.setStatus(3);
        }
        return fiExcelSheetMapper.updateByPrimaryKey(fiExcelSheet);
    }

    public FiTmpExcelJxSmallProfitTable tableEditJXSmallProfitTableDto(Integer sheetId) {
        FiExcelSheet fiExcelSheet = fiExcelSheetMapper.selectByPrimaryKey(sheetId);
        FiFileList fiFileList = fiFileListMapper.selectByPrimaryKey(fiExcelSheet.getFileId());
        Example example = new Example(FiTmpExcelJxSmallProfitTable.class);
        example.createCriteria().andEqualTo("fileId", fiFileList.getId()).andEqualTo("sheetId", fiExcelSheet.getId()).andEqualTo("roleId", new Integer(sessionService.getUser().getMemberType()));//这里给出的条件查询为id>100
        List<FiTmpExcelJxSmallProfitTable> list = fiTmpExcelJxSmallProfitTableMapper.selectByExample(example);
        if (list.size() > 0) {
            return list.get(0);
        } else {
            ExcelContext excelContext = new ExcelContext();
            try {
                excelContext.resolveContent(filePath + fiFileList.getFileName(), fiExcelSheet.getSheetNum());
                JxSmallProfitExpressionExcel jxSmallProfitExpressionExcel = new JxSmallProfitExpressionExcel();
                FiTmpExcelJxSmallProfitTable res = jxSmallProfitExpressionExcel.interpret(excelContext.getContent());
                res.setBeginTime(fiExcelSheet.getSheetDate());
                return res;
            } catch (Exception e) {

                FiTmpExcelJxSmallProfitTable res = new FiTmpExcelJxSmallProfitTable();
                res.setBeginTime(fiExcelSheet.getSheetDate());
                return res;
            }
        }
    }

    public int tableEditDoJXSmallBalanceTableDto(Integer sheetId, JXSmallBalanceTableDto jxSmallBalanceTableDto) {
        FiTmpExcelJxSmallBalanceTable fiTmpExcelJxSmallBalanceTable = new FiTmpExcelJxSmallBalanceTable();
        BeanUtils.copyProperties(jxSmallBalanceTableDto, fiTmpExcelJxSmallBalanceTable);
        FiExcelSheet fiExcelSheet = fiExcelSheetMapper.selectByPrimaryKey(sheetId);
        FiFileList fiFileList = fiFileListMapper.selectByPrimaryKey(fiExcelSheet.getFileId());
        fiTmpExcelJxSmallBalanceTable.setCreate_time(simpleDateFormat.format(new Date()));
        fiTmpExcelJxSmallBalanceTable.setFileId(fiFileList.getId());
        fiTmpExcelJxSmallBalanceTable.setFileName(fiFileList.getFileName());
        fiTmpExcelJxSmallBalanceTable.setSheetId(fiExcelSheet.getId());
        fiTmpExcelJxSmallBalanceTable.setRoleId(new Integer(sessionService.getUser().getMemberType()));
        fiTmpExcelJxSmallBalanceTable.setCreditNo(fiFileList.getCreditNo());
        fiTmpExcelJxSmallBalanceTable.setEnterpriseName(fiFileList.getEnterpriseName());
        fiTmpExcelJxSmallBalanceTable.setBeginTime(fiExcelSheet.getSheetDate());

        Example example = new Example(FiTmpExcelJxSmallBalanceTable.class);
        example.createCriteria().andEqualTo("fileId", fiFileList.getId()).andEqualTo("sheetId", fiExcelSheet.getId()).andEqualTo("roleId", new Integer(sessionService.getUser().getMemberType()));//这里给出的条件查询为id>100
        List<FiTmpExcelJxSmallBalanceTable> list = fiTmpExcelJxSmallBalanceTableMapper.selectByExample(example);
        if (list.size() < 1) {
            fiTmpExcelJxSmallBalanceTableMapper.insert(fiTmpExcelJxSmallBalanceTable);
        } else {
            fiTmpExcelJxSmallBalanceTableMapper.updateByExample(fiTmpExcelJxSmallBalanceTable, example);
        }
        if (new Integer(sessionService.getUser().getMemberType()) == 11) {
            fiExcelSheet.setStatus(1);
        }
        if (new Integer(sessionService.getUser().getMemberType()) == 12) {
            fiExcelSheet.setStatus(3);
        }
        return fiExcelSheetMapper.updateByPrimaryKey(fiExcelSheet);
    }

    public FiTmpExcelJxSmallBalanceTable tableEditJXSmallBalanceTableDto(Integer sheetId) {
        FiExcelSheet fiExcelSheet = fiExcelSheetMapper.selectByPrimaryKey(sheetId);
        FiFileList fiFileList = fiFileListMapper.selectByPrimaryKey(fiExcelSheet.getFileId());
        Example example = new Example(FiTmpExcelJxSmallBalanceTable.class);
        example.createCriteria().andEqualTo("fileId", fiFileList.getId()).andEqualTo("sheetId", fiExcelSheet.getId()).andEqualTo("roleId", new Integer(sessionService.getUser().getMemberType()));//这里给出的条件查询为id>100
        List<FiTmpExcelJxSmallBalanceTable> list = fiTmpExcelJxSmallBalanceTableMapper.selectByExample(example);
        if (list.size() > 0) {
            return list.get(0);
        } else {
            FiTmpExcelJxSmallBalanceTable res = new FiTmpExcelJxSmallBalanceTable();
            res.setBeginTime(fiExcelSheet.getSheetDate());
            return res;
        }
    }

    public boolean detailCommit(Integer id) throws Exception {
        FiFileList fiFileList = fiFileListMapper.selectByPrimaryKey(id);
        if (fiFileList.getStatus() != 1) {
            throw new Exception("文件未校验");
        }
        Example example = new Example(FiExcelSheet.class);
        example.createCriteria().andEqualTo("fileId", id);//这里给出的条件查询为id>100
        List<FiExcelSheet> sheetList = fiExcelSheetMapper.selectByExample(example);
        for (int i = 0; i < sheetList.size(); i++) {
            if (sheetList.get(i).getStatus() != 1) {
                throw new Exception(sheetList.get(i).getSheetName() + "没有录入");
            }
        }
        fiFileList.setStatus(2);
        fiFileListMapper.updateByPrimaryKey(fiFileList);
        for (int i = 0; i < sheetList.size(); i++) {
            FiExcelSheet fiExcelSheet = sheetList.get(i);
            fiExcelSheet.setStatus(2);
            fiExcelSheetMapper.updateByPrimaryKey(fiExcelSheet);
        }
        return true;
    }

    public boolean detailCopyCommit(Integer id) throws Exception {
        FiFileList fiFileList = fiFileListMapper.selectByPrimaryKey(id);
        if (fiFileList.getStatus() != 2) {
            throw new Exception("文件未校验");
        }
        Example example = new Example(FiExcelSheet.class);
        example.createCriteria().andEqualTo("fileId", id);//这里给出的条件查询为id>100
        List<FiExcelSheet> sheetList = fiExcelSheetMapper.selectByExample(example);
        for (int i = 0; i < sheetList.size(); i++) {
            if (sheetList.get(i).getStatus() != 3) {
                throw new Exception(sheetList.get(i).getSheetName() + "没有录入");
            }
        }

        for (int i = 0; i < sheetList.size(); i++) {
            FiExcelSheet fiExcelSheet = sheetList.get(i);
            if ("JxSmallBalance".equals(fiExcelSheet.getSheetType())) {
                Example example2 = new Example(FiTmpExcelJxSmallBalanceTable.class);
                example2.createCriteria().andEqualTo("fileId", fiFileList.getId()).andEqualTo("sheetId", fiExcelSheet.getId());
                List<FiTmpExcelJxSmallBalanceTable> list = fiTmpExcelJxSmallBalanceTableMapper.selectByExample(example2);
                if (list.size() != 2) {
                    throw new Exception("没有找到2条数据");
                }
                List<Map<String, Object>> compareResult = compareTwoClass(list.get(0), list.get(1));
                if (compareResult.size() > 0) {
                    throw new Exception(JSON.toJSONString(compareResult));
                }
                FiJxSmallBalanceTable record = new FiJxSmallBalanceTable();
                BeanUtils.copyProperties(list.get(0), record);
                record.setRegNo(fiFileList.getRegNo());
                record.setRegCreditNo(fiFileList.getRegCreditNo());
                record.setCreateTime(simpleDateFormat.format(new Date()));
                record.setTableStander(fiExcelSheet.getSheetStander());
                record.setReportType(fiExcelSheet.getReportType());
                record.setTableDate(fiExcelSheet.getSheetDate());
                try {
                    effectDataService.insertJxSmallBalance(record);
                } catch (Exception e) {

                }
            } else if ("JxSmallProfit".equals(fiExcelSheet.getSheetType())) {

                Example example2 = new Example(FiTmpExcelJxSmallProfitTable.class);
                example2.createCriteria().andEqualTo("fileId", fiFileList.getId()).andEqualTo("sheetId", fiExcelSheet.getId());
                List<FiTmpExcelJxSmallProfitTable> list = fiTmpExcelJxSmallProfitTableMapper.selectByExample(example2);
                if (list.size() != 2) {
                    throw new Exception("没有找到2条数据");
                }
                List<Map<String, Object>> compareResult = compareTwoClass(list.get(0), list.get(1));
                if (compareResult.size() > 0) {
                    throw new Exception(JSON.toJSONString(compareResult));
                }
                FiJxSmallProfitTable record = new FiJxSmallProfitTable();
                BeanUtils.copyProperties(list.get(0), record);
                record.setRegNo(fiFileList.getRegNo());
                record.setRegCreditNo(fiFileList.getRegCreditNo());
                record.setCreateTime(simpleDateFormat.format(new Date()));
                record.setTableStander(fiExcelSheet.getSheetStander());
                record.setReportType(fiExcelSheet.getReportType());
                record.setTableDate(fiExcelSheet.getSheetDate());
                try {
                    effectDataService.insertJxSmallProfit(record);
                } catch (Exception e) {

                }
            } else if ("JxNormalBalance".equals(fiExcelSheet.getSheetType())) {

                Example example2 = new Example(FiTmpExcelJxNormalBalanceTable.class);
                example2.createCriteria().andEqualTo("fileId", fiFileList.getId()).andEqualTo("sheetId", fiExcelSheet.getId());
                List<FiTmpExcelJxNormalBalanceTable> list = fiTmpExcelJxNormalBalanceTableMapper.selectByExample(example2);
                if (list.size() != 2) {
                    throw new Exception("没有找到2条数据");
                }
                List<Map<String, Object>> compareResult = compareTwoClass(list.get(0), list.get(1));
                if (compareResult.size() > 0) {
                    throw new Exception(JSON.toJSONString(compareResult));
                }
                FiJxNormalBalanceTable record = new FiJxNormalBalanceTable();
                BeanUtils.copyProperties(list.get(0), record);
                record.setRegNo(fiFileList.getRegNo());
                record.setRegCreditNo(fiFileList.getRegCreditNo());
                record.setCreateTime(simpleDateFormat.format(new Date()));
                record.setTableStander(fiExcelSheet.getSheetStander());
                record.setReportType(fiExcelSheet.getReportType());
                record.setTableDate(fiExcelSheet.getSheetDate());
                try {
                    effectDataService.insertJxNormalBalance(record);
                } catch (Exception e) {

                }
            } else if ("JxNormalProfit".equals(fiExcelSheet.getSheetType())) {

                Example example2 = new Example(FiTmpExcelJxNormalProfitTable.class);
                example2.createCriteria().andEqualTo("fileId", fiFileList.getId()).andEqualTo("sheetId", fiExcelSheet.getId());
                List<FiTmpExcelJxNormalProfitTable> list = fiTmpExcelJxNormalProfitTableMapper.selectByExample(example2);
                if (list.size() != 2) {
                    throw new Exception("没有找到2条数据");
                }
                List<Map<String, Object>> compareResult = compareTwoClass(list.get(0), list.get(1));
                if (compareResult.size() > 0) {
                    throw new Exception(JSON.toJSONString(compareResult));
                }
                FiJxNormalProfitTable record = new FiJxNormalProfitTable();
                BeanUtils.copyProperties(list.get(0), record);
                record.setRegNo(fiFileList.getRegNo());
                record.setRegCreditNo(fiFileList.getRegCreditNo());
                record.setCreateTime(simpleDateFormat.format(new Date()));
                record.setTableStander(fiExcelSheet.getSheetStander());
                record.setReportType(fiExcelSheet.getReportType());
                record.setTableDate(fiExcelSheet.getSheetDate());
                try {
                    effectDataService.insertJxNormalProfit(record);
                } catch (Exception e) {

                }
            } else if ("wuxiao".equals(fiExcelSheet.getSheetType())) {

            } else {
                throw new Exception("未设置sheet类型");
            }
        }

        fiFileList.setStatus(4);
        fiFileListMapper.updateByPrimaryKey(fiFileList);
        for (int i = 0; i < sheetList.size(); i++) {
            FiExcelSheet fiExcelSheet = sheetList.get(i);
            fiExcelSheet.setStatus(4);
            fiExcelSheetMapper.updateByPrimaryKey(fiExcelSheet);
        }
        return true;
    }

    public boolean reject(Integer id, String remark) {
        FiFileList fiFileList = fiFileListMapper.selectByPrimaryKey(id);
        fiFileList.setRemark(remark);
        fiFileList.setStatus(0);
        fiFileListMapper.updateByPrimaryKey(fiFileList);

        Example example = new Example(FiExcelSheet.class);
        example.createCriteria().andEqualTo("fileId", id);//这里给出的条件查询为id>100
        List<FiExcelSheet> sheetList = fiExcelSheetMapper.selectByExample(example);
        for (int i = 0; i < sheetList.size(); i++) {
            FiExcelSheet fiExcelSheet = sheetList.get(i);
            fiExcelSheet.setStatus(0);
            fiExcelSheetMapper.updateByPrimaryKey(fiExcelSheet);
        }
        return true;
    }


    private List<Map<String, Object>> compareTwoClass(Object class1, Object class2) throws ClassNotFoundException, IllegalAccessException {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
//获取对象的class
        Class<?> clazz1 = class1.getClass().getSuperclass();
        Class<?> clazz2 = class2.getClass().getSuperclass();
//获取对象的属性列表
        Field[] field1 = clazz1.getDeclaredFields();
        Field[] field2 = clazz2.getDeclaredFields();
//遍历属性列表field1
        for (int i = 0; i < field1.length; i++) {
//遍历属性列表field2
            for (int j = 0; j < field2.length; j++) {
//如果field1[i]属性名与field2[j]属性名内容相同
                if (field1[i].getName().equals(field2[j].getName())) {
                    if (field1[i].getName().equals(field2[j].getName())) {
                        field1[i].setAccessible(true);
                        field2[j].setAccessible(true);
//如果field1[i]属性值与field2[j]属性值内容不相同
                        if (!compareTwo(field1[i].get(class1), field2[j].get(class2))) {
                            Map<String, Object> map2 = new HashMap<String, Object>();
                            map2.put("字段名", field1[i].getName());
                            map2.put("初录", field1[i].get(class1));
                            map2.put("复录", field2[j].get(class2));
                            list.add(map2);
                        }
                        break;
                    }
                }
            }
        }
        return list;
    }

    private boolean compareTwo(Object object1, Object object2) {

        if (object1 == null && object2 == null) {
            return true;
        }
        if (object1 == null && object2 != null) {
            return false;
        }
        if (object1.equals(object2)) {
            return true;
        }
        return false;
    }


    /**
     * 外部申请文件数据录入
     *
     * @param inputArr
     * @return
     * @throws Exception
     */
    public boolean dynamicReportDataApiReq(JSONArray inputArr) throws Exception {
        for (int i = 0; i < inputArr.size(); i++) {
            JSONObject jsonObject = inputArr.getJSONObject(i);
            String type = jsonObject.getString("type");
            if (type == null) {
                break;
            }
            String[] types = type.split(",");
            for (int j = 0; j < types.length; j++) {
                FiDynamicReportStruct struct = fiDynamicReportStructMapper.selectByPrimaryKey(new Integer(types[j]));
                if (struct == null) {
                    throw new Exception("type 字段错误，没有该报表");
                }
                FiDynamicReportApiReq fiDynamicReportApiReq = new FiDynamicReportApiReq();
                fiDynamicReportApiReq.setReportId(struct.getId());
                fiDynamicReportApiReq.setReportTitle(struct.getReportTitle());
                fiDynamicReportApiReq.setEnterpriseName(jsonObject.getString("enterpriseName"));
                fiDynamicReportApiReq.setFileName(jsonObject.getString("fileName"));
                fiDynamicReportApiReq.setInsertTime(new Date());
                fiDynamicReportApiReq.setNeedCheck(struct.getNeedCheck());
                fiDynamicReportApiReq.setStep(0);
                jsonObject.put("type", types[j]);
                fiDynamicReportApiReq.setReqJsonStr(JSON.toJSONString(jsonObject));
                fiDynamicReportApiReqMapper.insert(fiDynamicReportApiReq);
            }
        }
        return true;
    }

    public List<FiDynamicReportApiReq> dynamicReportFirstList() {
        Example example = new Example(FiDynamicReportApiReq.class);
        example.createCriteria().andEqualTo("step", 0);
        List<FiDynamicReportApiReq> list = fiDynamicReportApiReqMapper.selectByExample(example);
        return list;
    }


    public List<FiDynamicReportApiReq> dynamicReportSecondList() {
        Example example = new Example(FiDynamicReportApiReq.class);
        example.createCriteria().andEqualTo("step", 1);
        List<FiDynamicReportApiReq> list = fiDynamicReportApiReqMapper.selectByExample(example);
        return list;
    }


    /**
     * 请求Id与结构
     *
     * @param reqId
     * @return
     * @throws Exception
     */
    public DynamicReportReqShow findReqDetailStruct(int reqId) throws Exception {
        FiDynamicReportApiReq fiDynamicReportApiReq = fiDynamicReportApiReqMapper.selectByPrimaryKey(reqId);
        if (fiDynamicReportApiReq == null) {
            throw new Exception("数据错误");
        }
        DynamicReportReqShow result = new DynamicReportReqShow();
        result.setFiDynamicReportApiReq(fiDynamicReportApiReq);
        FiDynamicReportStruct fiDynamicReportStruct = fiDynamicReportStructMapper.selectByPrimaryKey(fiDynamicReportApiReq.getReportId());
        if (fiDynamicReportStruct == null) {
            throw new Exception("报表数据错误");
        }
        result.setFiDynamicReportStruct(fiDynamicReportStruct);
        return result;
    }

    /**
     * 保存动态报表数据
     *
     * @param data
     */
    public void saveDynamicReportData(JSONObject data) throws Exception {
        int reqId = data.getInteger("reqId");
        if (reqId < 1) {
            throw new Exception("请求id不正确");
        }
        UserInfoDTO userInfoDTO = sessionService.getUser();
        DynamicReportReqShow dynamicReportReqShow = this.findReqDetailStruct(reqId);
        if (dynamicReportReqShow.getFiDynamicReportApiReq().getStep() == 0) {
            if (!("11".equals(userInfoDTO.getMemberType()) || "1".equals(userInfoDTO.getMemberType()))) {
                throw new Exception("当前进度为初录，你权限不对");
            }
            chuluSave(dynamicReportReqShow, data);
            if (dynamicReportReqShow.getFiDynamicReportStruct().getNeedCheck() == 0) {
                dynamicReportReqShow.getFiDynamicReportApiReq().setStep(3);
            } else {
                dynamicReportReqShow.getFiDynamicReportApiReq().setStep(1);
            }
        } else if (dynamicReportReqShow.getFiDynamicReportApiReq().getStep() == 1) {
            if (!("12".equals(userInfoDTO.getMemberType()) || "1".equals(userInfoDTO.getMemberType()))) {
                throw new Exception("当前进度为复录，你权限不对");
            }
            fuluSave(dynamicReportReqShow, data);
            compareJsonObject(chuluFind(dynamicReportReqShow), fuluFind(dynamicReportReqShow));
            dynamicReportReqShow.getFiDynamicReportApiReq().setStep(3);
        } else {
            throw new Exception("当前进度不正确");
        }
        dynamicReportReqShow.getFiDynamicReportApiReq().setUpdateTime(new Date());
        fiDynamicReportApiReqMapper.updateByPrimaryKey(dynamicReportReqShow.getFiDynamicReportApiReq());
        if (dynamicReportReqShow.getFiDynamicReportApiReq().getStep() == 3){
            resultSave(dynamicReportReqShow,data);
        }
        //打接口
        if (dynamicReportReqShow.getFiDynamicReportApiReq().getStep() == 3 && !("").equals(dynamicReportReqShow.getFiDynamicReportStruct().getInterfaceUrl())) {
            logger.info("interface start post");
            JSONObject postData = new JSONObject();
            JSONObject datatmp = new JSONObject();
            datatmp.put("req", JSON.parseObject(dynamicReportReqShow.getFiDynamicReportApiReq().getReqJsonStr()));
            datatmp.put("resp", chuluFind(dynamicReportReqShow));
            postData.put("code", "200");
            postData.put("data", datatmp);
            postData.put("msg", "成功");
            CloseableHttpClient httpclient = HttpClientBuilder.create().build();
            HttpPost post = new HttpPost(dynamicReportReqShow.getFiDynamicReportStruct().getInterfaceUrl());
            JSONObject response = null;

            try {
                DynamicReportSign signTool= DynamicReportSignEnum.getInstanceByType(dynamicReportReqShow.getFiDynamicReportStruct().getSignClassName());
                postData=signTool.dealSgin(postData);
                StringEntity s = new StringEntity(JSON.toJSONString(postData),"UTF-8");
                s.setContentEncoding("UTF-8");
                s.setContentType("application/json");//发送json数据需要设置contentType
                post.setEntity(s);
                logger.info("post interface url={},postData={}", dynamicReportReqShow.getFiDynamicReportStruct().getInterfaceUrl(), JSON.toJSONString(postData));
                HttpResponse res = httpclient.execute(post);
                String result = EntityUtils.toString(res.getEntity());// 返回json格式：
                logger.info("post interface result={}", result);
            } catch (Exception e) {
                logger.info("post interface exception={}", e.getMessage());
            }
        }

    }

    //保存数据
    private void chuluSave(DynamicReportReqShow dynamicReportReqShow, JSONObject data) {
        DBCollection dbCollection = mongoTemplate.getDb().getCollection("dynamic_report_chulu_" + String.valueOf(dynamicReportReqShow.getFiDynamicReportStruct().getId()));
        DBObject condition = new BasicDBObject();
        condition.put("reqId", data.getLong("reqId"));
        DBObject record = dbCollection.findOne(condition);
        DBObject dbObject = (DBObject) com.mongodb.util.JSON.parse(JSON.toJSONString(data));
        if (record == null) {
            record = new BasicDBObject();
            record.put("insertTime", new Date());
        }
        for (String key : dbObject.keySet()) {
            record.put(key, dbObject.get(key));
        }
        record.put("updateTime", new Date());
        dbCollection.save(record);
    }

    private void fuluSave(DynamicReportReqShow dynamicReportReqShow, JSONObject data) {
        DBCollection dbCollection = mongoTemplate.getDb().getCollection("dynamic_report_fulu_" + String.valueOf(dynamicReportReqShow.getFiDynamicReportStruct().getId()));
        DBObject condition = new BasicDBObject();
        condition.put("reqId", data.getLong("reqId"));
        DBObject record = dbCollection.findOne(condition);
        DBObject dbObject = (DBObject) com.mongodb.util.JSON.parse(JSON.toJSONString(data));
        if (record == null) {
            record = new BasicDBObject();
            record.put("insertTime", new Date());
        }
        for (String key : dbObject.keySet()) {
            record.put(key, dbObject.get(key));
        }
        record.put("updateTime", new Date());
        dbCollection.save(record);
    }

    private void resultSave(DynamicReportReqShow dynamicReportReqShow, JSONObject data) {
        DBCollection dbCollection = mongoTemplate.getDb().getCollection("dynamic_report_" + String.valueOf(dynamicReportReqShow.getFiDynamicReportStruct().getId()));
        DBObject condition = new BasicDBObject();
        condition.put("reqId", data.getLong("reqId"));
        DBObject record = dbCollection.findOne(condition);
        DBObject dbObject = (DBObject) com.mongodb.util.JSON.parse(JSON.toJSONString(data));
        if (record == null) {
            record = new BasicDBObject();
            record.put("insertTime", new Date());
        }
        for (String key : dbObject.keySet()) {
            record.put(key, dbObject.get(key));
        }
        record.put("updateTime", new Date());
        dbCollection.save(record);
    }

    /**
     * 查询动态报表数据
     *
     * @param reqId
     * @return
     * @throws Exception
     */
    public JSONObject findDynamicReportData(int reqId) throws Exception {
        DynamicReportReqShow dynamicReportReqShow = this.findReqDetailStruct(reqId);
        if (dynamicReportReqShow.getFiDynamicReportApiReq().getStep() == 0) {
            return chuluFind(dynamicReportReqShow);
        } else if (dynamicReportReqShow.getFiDynamicReportApiReq().getStep() == 1) {
            return fuluFind(dynamicReportReqShow);
        } else if(dynamicReportReqShow.getFiDynamicReportApiReq().getStep()==3){
            return finishFind(dynamicReportReqShow);
        } else{
            throw new Exception("状态不对");
        }
    }

    //查询数据
    private JSONObject chuluFind(DynamicReportReqShow dynamicReportReqShow) {
        DBCollection dbCollection = mongoTemplate.getDb().getCollection("dynamic_report_chulu_" + String.valueOf(dynamicReportReqShow.getFiDynamicReportStruct().getId()));
        DBObject condition = new BasicDBObject();
        condition.put("reqId", dynamicReportReqShow.getFiDynamicReportApiReq().getId());
        DBObject record = dbCollection.findOne(condition);
        if (record == null) {
            return null;
        }
        record.put("_id", ((ObjectId) record.get("_id")).toString());
        JSONObject res = JSONObject.parseObject(JSON.toJSONString(record));
        return res;
    }
    private JSONObject finishFind(DynamicReportReqShow dynamicReportReqShow) {
        DBCollection dbCollection = mongoTemplate.getDb().getCollection("dynamic_report_" + String.valueOf(dynamicReportReqShow.getFiDynamicReportStruct().getId()));
        DBObject condition = new BasicDBObject();
        condition.put("reqId", dynamicReportReqShow.getFiDynamicReportApiReq().getId());
        DBObject record = dbCollection.findOne(condition);
        if (record == null) {
            return null;
        }
        record.put("_id", ((ObjectId) record.get("_id")).toString());
        JSONObject res = JSONObject.parseObject(JSON.toJSONString(record));
        return res;
    }

    private JSONObject fuluFind(DynamicReportReqShow dynamicReportReqShow) {
        DBCollection dbCollection = mongoTemplate.getDb().getCollection("dynamic_report_fulu_" + String.valueOf(dynamicReportReqShow.getFiDynamicReportStruct().getId()));
        DBObject condition = new BasicDBObject();
        condition.put("reqId", dynamicReportReqShow.getFiDynamicReportApiReq().getId());
        DBObject record = dbCollection.findOne(condition);
        if (record == null) {
            return null;
        }
        record.put("_id", ((ObjectId) record.get("_id")).toString());
        JSONObject res = JSONObject.parseObject(JSON.toJSONString(record));
        return res;
    }

    public boolean reportDataRevert(int reqId, String remark) throws Exception {
        UserInfoDTO userInfoDTO = sessionService.getUser();
        DynamicReportReqShow dynamicReportReqShow = this.findReqDetailStruct(reqId);
        if (dynamicReportReqShow.getFiDynamicReportApiReq().getStep() == 1) {
            if (!("12".equals(userInfoDTO.getMemberType()) || "1".equals(userInfoDTO.getMemberType()))) {
                throw new Exception("当前进度为初录，你权限不对");
            }
            dynamicReportReqShow.getFiDynamicReportApiReq().setRemark(remark);
            dynamicReportReqShow.getFiDynamicReportApiReq().setStep(0);
            dynamicReportReqShow.getFiDynamicReportApiReq().setUpdateTime(new Date());
            fiDynamicReportApiReqMapper.updateByPrimaryKey(dynamicReportReqShow.getFiDynamicReportApiReq());
            return true;
        }
        throw new Exception("状态不正确");
    }

    public boolean compareJsonObject(JSONObject jsonObject1, JSONObject jsonObject2) throws Exception {
        String msg = "";
        Set<String> keys = jsonObject1.keySet();
        for (String key : keys) {
            if (key.equals("_id") ||
                    key.equals("_id") ||
                    key.equals("insertTime") ||
                    key.equals("reqId") ||
                    key.equals("updateTime")
                    ) {
                continue;
            }
            if (jsonObject2.getString(key) == null) {
                msg += "初录= " + jsonObject1.getString(key) + " 复录空" + "\r\n";
            }
            if (!jsonObject2.getString(key).equals(jsonObject1.getString(key))) {
                msg += "初录= " + jsonObject1.getString(key) + " 复录= " + jsonObject2.getString(key) + "\r\n";
            }
        }
        if ("".equals(msg)) {
            return true;
        } else {
            throw new Exception(msg);
        }
    }

    /**
     * 无效请求
     *
     * @param reqId
     */
    public void wuxiao(int reqId) throws Exception {
        UserInfoDTO userInfoDTO = sessionService.getUser();
        DynamicReportReqShow dynamicReportReqShow = this.findReqDetailStruct(reqId);
        if (dynamicReportReqShow.getFiDynamicReportApiReq().getStep() == 0) {
            if (!("11".equals(userInfoDTO.getMemberType()) || "1".equals(userInfoDTO.getMemberType()))) {
                throw new Exception("当前进度为初录，你权限不对");
            }
            dynamicReportReqShow.getFiDynamicReportApiReq().setStep(9);
            dynamicReportReqShow.getFiDynamicReportApiReq().setUpdateTime(new Date());
            fiDynamicReportApiReqMapper.updateByPrimaryKey(dynamicReportReqShow.getFiDynamicReportApiReq());
            //打接口
            if (!("").equals(dynamicReportReqShow.getFiDynamicReportStruct().getInterfaceUrl())) {
                logger.info("wuxiao interface start post");
                JSONObject postData = new JSONObject();
                JSONObject datatmp = new JSONObject();
                datatmp.put("req", JSON.parseObject(dynamicReportReqShow.getFiDynamicReportApiReq().getReqJsonStr()));
                datatmp.put("resp", 0);
                postData.put("code", "500");
                postData.put("data", datatmp);
                postData.put("msg", "报表无效");
                CloseableHttpClient httpclient = HttpClientBuilder.create().build();
                HttpPost post = new HttpPost(dynamicReportReqShow.getFiDynamicReportStruct().getInterfaceUrl());
                JSONObject response = null;

                try {
                    DynamicReportSign signTool= DynamicReportSignEnum.getInstanceByType(dynamicReportReqShow.getFiDynamicReportStruct().getSignClassName());
                    postData=signTool.dealSgin(postData);
                    StringEntity s = new StringEntity(JSON.toJSONString(postData),"UTF-8");
                    s.setContentEncoding("UTF-8");
                    s.setContentType("application/json");//发送json数据需要设置contentType
                    post.setEntity(s);
                    logger.info("wuxiao post interface url={},postData={}", dynamicReportReqShow.getFiDynamicReportStruct().getInterfaceUrl(), JSON.toJSONString(postData));
                    HttpResponse res = httpclient.execute(post);
                    String result = EntityUtils.toString(res.getEntity());// 返回json格式：
                    logger.info("wuxiao post interface result={}", result);
                } catch (Exception e) {
                    logger.info("wuxiao post interface exception={}", e.getMessage());
                }
            }
        }

    }
}
