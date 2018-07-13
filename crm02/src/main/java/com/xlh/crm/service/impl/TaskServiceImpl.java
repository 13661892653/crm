package com.xlh.crm.service.impl;

import com.alibaba.fastjson.JSON;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.xlh.crm.common.CurrentTime;
import com.xlh.crm.dto.mysql.*;
import com.xlh.crm.dto.mysql.ods.*;
import com.xlh.crm.dto.score.TopicScore;
import com.xlh.crm.mapper.*;
import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.session.RowBounds;
import org.apache.logging.log4j.util.Strings;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import tk.mybatis.mapper.entity.Example;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class TaskServiceImpl {
    private Logger logger = LoggerFactory.getLogger(TaskServiceImpl.class);
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    @Autowired
    JedisPool jedisPool;
    @Autowired
    private ScoreServiceImpl scoreService;
    @Autowired
    private CdmMongodbEnterpriseBaseInfoMapper cdmMongodbEnterpriseBaseInfoMapper;
    @Autowired
    private FiFileListMapper fiFileListMapper;
    @Autowired
    private FiExcelSheetMapper fiExcelSheetMapper;
    @Value("${finance.source.path}")
    private String filePath;


    public boolean keepOneAppTaskRun(String key) {
        Jedis jedis = jedisPool.getResource();
        try {
            if (Strings.isEmpty(key)) {
                key = "hello";
            }
            long res = jedis.incr("crm-web-task-key-" + key);
            if (res % 2 == 1) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            logger.info("exception={}", e.getMessage());
            return false;
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    public void calculatorScore() {
        while (true) {
            String regCreditNo = scoreService.popRedis();
            if (regCreditNo == null || regCreditNo.equals("")) {
                break;
            }
            TopicScore topicScore = scoreService.getScoreObj(regCreditNo);
            int score = scoreService.getScore(topicScore);
            scoreService.updateScore(regCreditNo, score);
            logger.info("regCreditNo={} score={}  =====topicScore={}", regCreditNo, score, JSON.toJSONString(topicScore));
        }
    }

    /**
     * 检查是否有新的财务报表excel，有则加入到手动录入
     */
    public void addJxFinanceExcel() {
        List<CdmMongodbEnterpriseBaseInfo> list = cdmMongodbEnterpriseBaseInfoMapper.selectAll();
        List<FiFileList> fiFileLists = new ArrayList<>();
        FiFileList recode = new FiFileList();
        for (int i = 0; i < list.size(); i++) {
            recode = new FiFileList();
            recode.setStatus(0);
            recode.setFileName(list.get(i).getAssetDebtFile());
            recode.setEnterpriseName(list.get(i).getEnterpriseName());
            recode.setCreateTime(simpleDateFormat.format(new Date()));
            fiFileLists.add(recode);
            recode = new FiFileList();
            recode.setStatus(0);
            recode.setFileName(list.get(i).getCashFlowFile());
            recode.setEnterpriseName(list.get(i).getEnterpriseName());
            recode.setCreateTime(simpleDateFormat.format(new Date()));
            fiFileLists.add(recode);
            recode = new FiFileList();
            recode.setStatus(0);
            recode.setFileName(list.get(i).getProfitDistributionFile());
            recode.setEnterpriseName(list.get(i).getEnterpriseName());
            recode.setCreateTime(simpleDateFormat.format(new Date()));
            fiFileLists.add(recode);
        }
        list = cdmMongodbEnterpriseBaseInfoMapper.selectJoin();

        for (int i = 0; i < list.size(); i++) {
            recode = new FiFileList();
            recode.setStatus(0);
            recode.setFileName(list.get(i).getProfitDistributionFile());
            recode.setEnterpriseName(list.get(i).getEnterpriseName());
            recode.setCreateTime(simpleDateFormat.format(new Date()));
            fiFileLists.add(recode);
        }
        for (int i = 0; i < fiFileLists.size(); i++) {
            try {
                if (Strings.isEmpty(fiFileLists.get(i).getFileName()) || fiFileLists.get(i).getFileName() == null || Strings.isEmpty(fiFileLists.get(i).getEnterpriseName()) || fiFileLists.get(i).getEnterpriseName() == null) {
                    continue;
                }
                Example example = new Example(FiFileList.class);
                example.createCriteria().andEqualTo("fileName", fiFileLists.get(i).getFileName());
                if (!new File(filePath + fiFileLists.get(i).getFileName()).exists()) {
                    logger.info("file {} not exist", filePath + fiFileLists.get(i).getFileName());
                    continue;
                }
                if (fiFileListMapper.selectByExample(example).size() > 0) {
                    logger.info("file {} is in mysql", filePath + fiFileLists.get(i).getFileName());
                    continue;
                }
                fiFileListMapper.insert(fiFileLists.get(i));
                insertSheet(filePath, fiFileLists.get(i).getFileName(), fiFileLists.get(i).getId());
                logger.info(fiFileLists.get(i).getFileName() + "__________________" + String.valueOf(i));
            } catch (Exception e) {
                logger.info("exception={}", e.getMessage());
            }
        }
    }

    private void insertSheet(String filePath, String fileName, Integer fileId) {
        File file = new File(filePath + fileName);
        Workbook workbook = null;
        FileInputStream fis = null;
        StringBuffer sb = new StringBuffer();
        try {
            workbook = WorkbookFactory.create(file);
            Sheet sheet;
            for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
                FiExcelSheet fiExcelSheet = new FiExcelSheet();
                fiExcelSheet.setCreateTime(simpleDateFormat.format(new Date()));
                fiExcelSheet.setFileId(fileId);
                fiExcelSheet.setSheetNum(i);
                fiExcelSheet.setSheetName(workbook.getSheetAt(i).getSheetName());
                fiExcelSheet.setStatus(0);
                fiExcelSheetMapper.insert(fiExcelSheet);
            }

        } catch (Exception e) {
            logger.info("exception={}", e.getMessage());
        } finally {
            try {
                workbook.close();
            } catch (Exception e) {
                logger.info("exception={}", e.getMessage());
            }
        }

    }


    @Autowired
    private OdsXlhDataformatJxNormalBalanceTableMapper odsXlhDataformatJxNormalBalanceTableMapper;
    @Autowired
    private OdsXlhDataformatJxNormalProfitTableMapper odsXlhDataformatJxNormalProfitTableMapper;
    @Autowired
    private OdsXlhDataformatJxSmallBalanceTableMapper odsXlhDataformatJxSmallBalanceTableMapper;
    @Autowired
    private OdsXlhDataformatJxSmallProfitTableMapper odsXlhDataformatJxSmallProfitTableMapper;
    @Autowired
    private OdsXlhDataformatYpNormalBalanceTableMapper odsXlhDataformatYpNormalBalanceTableMapper;
    @Autowired
    private OdsXlhDataformatYpNormalProfitTableMapper odsXlhDataformatYpNormalProfitTableMapper;
    @Autowired
    private OdsXlhDataformatYpSmallBalanceTableMapper odsXlhDataformatYpSmallBalanceTableMapper;
    @Autowired
    private OdsXlhDataformatYpSmallProfitTableMapper odsXlhDataformatYpSmallProfitTableMapper;
    @Autowired
    private OdsXlhDataformatYpSmallCashTableMapper odsXlhDataformatYpSmallCashTableMapper;
    @Autowired
    private FiDynamicReportApiReqMapper fiDynamicReportApiReqMapper;
    @Autowired
    private FiDynamicReportStructMapper fiDynamicReportStructMapper;
    @Autowired
    private CdmEntDtoCorpInfoMapper cdmEntDtoCorpInfoMapper;
    @Autowired
    private FiTableSyncColumnMapper fiTableSyncColumnMapper;
    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    private EtlJobMonitorMapper etlJobMonitorMapper;
    @Autowired
    private CdmMongodbEnterpriseBaseInfoDetailDMapper cdmMongodbEnterpriseBaseInfoDetailDMapper;
    @Autowired
    private CrmReachcsrMapper crmReachcsrMapper;

    /**
     * 科技贷dataformat财务数据同步到crm
     */
    public void financeTableSync() throws IllegalAccessException {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        String todayStr=simpleDateFormat.format(new Date());
        Example etlExample=new Example(EtlJobMonitor.class);
        etlExample.createCriteria().andEqualTo("ds",todayStr).andEqualTo("flag","Y");
        List<EtlJobMonitor> list=etlJobMonitorMapper.selectByExample(etlExample);
        if (list.size()!=15){
            return;
        }
        etlJobMonitorMapper.updateTodayFlag(todayStr,"F");
        addReachcsr();
        //嘉兴小企业利润表
        FiDynamicReportStruct struct = fiDynamicReportStructMapper.selectByPrimaryKey(4);
        Example example = new Example(FiDynamicReportApiReq.class);
        example.createCriteria().andEqualTo("reportId", struct.getId());
        example.orderBy("recordId").desc();
        RowBounds rowBounds = new RowBounds(0, 1);
        List<FiDynamicReportApiReq> reqList_4 = fiDynamicReportApiReqMapper.selectByExampleAndRowBounds(example, rowBounds);
        int smallProfitId = 0;
        if (reqList_4.size() > 0) {
            smallProfitId = reqList_4.get(0).getRecordId();
        }
        example = new Example(OdsXlhDataformatJxSmallProfitTable.class);
        example.createCriteria().andGreaterThan("id", smallProfitId);
        List<OdsXlhDataformatJxSmallProfitTable> smallProfitTables = odsXlhDataformatJxSmallProfitTableMapper.selectByExample(example);
        for (OdsXlhDataformatJxSmallProfitTable record : smallProfitTables) {
            FiDynamicReportApiReq in = new FiDynamicReportApiReq();
            in.setStep(19);
            in.setUpdateTime(new Date());
            in.setReportTitle(struct.getReportTitle());
            in.setReportId(struct.getId());
            in.setReqJsonStr("{}");
            in.setFileName(record.getFileName());
            in.setEnterpriseName(record.getEnterpriseName().replace("编制单位:", ""));
            in.setInsertTime(new Date());
            in.setNeedCheck(struct.getNeedCheck());
            in.setRecordId(record.getId());
            in.setReportDate((StringUtils.trimToEmpty(record.getBeginTime()) + " " + StringUtils.trimToEmpty(record.getEndTime())).trim());
            fiDynamicReportApiReqMapper.insert(in);
        }


        //嘉兴小企业资产负债表
        struct = fiDynamicReportStructMapper.selectByPrimaryKey(6);
        example = new Example(FiDynamicReportApiReq.class);
        example.createCriteria().andEqualTo("reportId", struct.getId());
        example.orderBy("recordId").desc();
        rowBounds = new RowBounds(0, 1);
        List<FiDynamicReportApiReq> reqList_6 = fiDynamicReportApiReqMapper.selectByExampleAndRowBounds(example, rowBounds);
        int recordId = 0;
        if (reqList_6.size() > 0) {
            recordId = reqList_6.get(0).getRecordId();
        }
        example = new Example(OdsXlhDataformatJxSmallProfitTable.class);
        example.createCriteria().andGreaterThan("id", recordId);
        List<OdsXlhDataformatJxSmallBalanceTable> smallBalanceTables = odsXlhDataformatJxSmallBalanceTableMapper.selectByExample(example);
        for (OdsXlhDataformatJxSmallBalanceTable record : smallBalanceTables) {
            FiDynamicReportApiReq in = new FiDynamicReportApiReq();
            in.setStep(19);
            in.setUpdateTime(new Date());
            in.setReportTitle(struct.getReportTitle());
            in.setReportId(struct.getId());
            in.setReqJsonStr("{}");
            in.setFileName(record.getFileName());
            in.setEnterpriseName(record.getEnterpriseName().replace("编制单位:", ""));
            in.setInsertTime(new Date());
            in.setNeedCheck(struct.getNeedCheck());
            in.setRecordId(record.getId());
            in.setReportDate((StringUtils.trimToEmpty(record.getBeginTime()) + " " + StringUtils.trimToEmpty(record.getEndTime())).trim());
            fiDynamicReportApiReqMapper.insert(in);
        }

        //嘉兴一般企业利润表
        struct = fiDynamicReportStructMapper.selectByPrimaryKey(7);
        example = new Example(FiDynamicReportApiReq.class);
        example.createCriteria().andEqualTo("reportId", struct.getId());
        example.orderBy("recordId").desc();
        rowBounds = new RowBounds(0, 1);
        List<FiDynamicReportApiReq> reqList_7 = fiDynamicReportApiReqMapper.selectByExampleAndRowBounds(example, rowBounds);
        recordId = 0;
        if (reqList_7.size() > 0) {
            recordId = reqList_7.get(0).getRecordId();
        }
        example = new Example(OdsXlhDataformatJxSmallProfitTable.class);
        example.createCriteria().andGreaterThan("id", recordId);
        List<OdsXlhDataformatJxNormalProfitTable> normalProfitTables = odsXlhDataformatJxNormalProfitTableMapper.selectByExample(example);
        for (OdsXlhDataformatJxNormalProfitTable record : normalProfitTables) {
            FiDynamicReportApiReq in = new FiDynamicReportApiReq();
            in.setStep(19);
            in.setUpdateTime(new Date());
            in.setReportTitle(struct.getReportTitle());
            in.setReportId(struct.getId());
            in.setReqJsonStr("{}");
            in.setFileName(record.getFileName());
            in.setEnterpriseName(record.getEnterpriseName().replace("编制单位:", ""));
            in.setInsertTime(new Date());
            in.setNeedCheck(struct.getNeedCheck());
            in.setRecordId(record.getId());
            in.setReportDate((StringUtils.trimToEmpty(record.getBeginTime()) + " " + StringUtils.trimToEmpty(record.getEndTime())).trim());
            fiDynamicReportApiReqMapper.insert(in);
        }

        //嘉兴一般企业资产负债表
        struct = fiDynamicReportStructMapper.selectByPrimaryKey(8);
        example = new Example(FiDynamicReportApiReq.class);
        example.createCriteria().andEqualTo("reportId", struct.getId());
        example.orderBy("recordId").desc();
        rowBounds = new RowBounds(0, 1);
        List<FiDynamicReportApiReq> reqList_8 = fiDynamicReportApiReqMapper.selectByExampleAndRowBounds(example, rowBounds);
        recordId = 0;
        if (reqList_8.size() > 0) {
            recordId = reqList_8.get(0).getRecordId();
        }
        example = new Example(OdsXlhDataformatJxSmallProfitTable.class);
        example.createCriteria().andGreaterThan("id", recordId);
        List<OdsXlhDataformatJxNormalBalanceTable> normalBalanceTables = odsXlhDataformatJxNormalBalanceTableMapper.selectByExample(example);
        for (OdsXlhDataformatJxNormalBalanceTable record : normalBalanceTables) {
            FiDynamicReportApiReq in = new FiDynamicReportApiReq();
            in.setStep(19);
            in.setUpdateTime(new Date());
            in.setReportTitle(struct.getReportTitle());
            in.setReportId(struct.getId());
            in.setReqJsonStr("{}");
            in.setFileName(record.getFileName());
            in.setEnterpriseName(record.getEnterpriseName().replace("编制单位:", ""));
            in.setInsertTime(new Date());
            in.setNeedCheck(struct.getNeedCheck());
            in.setRecordId(record.getId());
            in.setReportDate((StringUtils.trimToEmpty(record.getBeginTime()) + " " + StringUtils.trimToEmpty(record.getEndTime())).trim());
            fiDynamicReportApiReqMapper.insert(in);
        }
        //杨浦小企业利润表
        struct = fiDynamicReportStructMapper.selectByPrimaryKey(9);
        example = new Example(FiDynamicReportApiReq.class);
        example.createCriteria().andEqualTo("reportId", struct.getId());
        example.orderBy("recordId").desc();
        rowBounds = new RowBounds(0, 1);
        List<FiDynamicReportApiReq> reqList_9 = fiDynamicReportApiReqMapper.selectByExampleAndRowBounds(example, rowBounds);
        recordId = 0;
        if (reqList_9.size() > 0) {
            recordId = reqList_9.get(0).getRecordId();
        }
        example = new Example(OdsXlhDataformatYpSmallProfitTable.class);
        example.createCriteria().andGreaterThan("id", recordId);
        List<OdsXlhDataformatYpSmallProfitTable> ypSmallProfitTables = odsXlhDataformatYpSmallProfitTableMapper.selectByExample(example);
        for (OdsXlhDataformatYpSmallProfitTable record : ypSmallProfitTables) {
            FiDynamicReportApiReq in = new FiDynamicReportApiReq();
            in.setStep(19);
            in.setUpdateTime(new Date());
            in.setReportTitle(struct.getReportTitle());
            in.setReportId(struct.getId());
            in.setReqJsonStr("{}");
            in.setFileName(record.getFileName());
            in.setEnterpriseName(record.getEnterpriseName().replace("编制单位:", ""));
            in.setInsertTime(new Date());
            in.setNeedCheck(struct.getNeedCheck());
            in.setRecordId(record.getId());
            in.setReportDate((StringUtils.trimToEmpty(record.getBeginTime()) + " " + StringUtils.trimToEmpty(record.getEndTime())).trim());
            fiDynamicReportApiReqMapper.insert(in);
        }
        //杨浦小企业资产负债表
        struct = fiDynamicReportStructMapper.selectByPrimaryKey(10);
        example = new Example(FiDynamicReportApiReq.class);
        example.createCriteria().andEqualTo("reportId", struct.getId());
        example.orderBy("recordId").desc();
        rowBounds = new RowBounds(0, 1);
        List<FiDynamicReportApiReq> reqList_10 = fiDynamicReportApiReqMapper.selectByExampleAndRowBounds(example, rowBounds);
        recordId = 0;
        if (reqList_10.size() > 0) {
            recordId = reqList_10.get(0).getRecordId();
        }
        example = new Example(OdsXlhDataformatYpSmallBalanceTable.class);
        example.createCriteria().andGreaterThan("id", recordId);
        List<OdsXlhDataformatYpSmallBalanceTable> ypSmallBalanceTables = odsXlhDataformatYpSmallBalanceTableMapper.selectByExample(example);
        for (OdsXlhDataformatYpSmallBalanceTable record : ypSmallBalanceTables) {
            FiDynamicReportApiReq in = new FiDynamicReportApiReq();
            in.setStep(19);
            in.setUpdateTime(new Date());
            in.setReportTitle(struct.getReportTitle());
            in.setReportId(struct.getId());
            in.setReqJsonStr("{}");
            in.setFileName(record.getFileName());
            in.setEnterpriseName(record.getEnterpriseName().replace("编制单位:", ""));
            in.setInsertTime(new Date());
            in.setNeedCheck(struct.getNeedCheck());
            in.setRecordId(record.getId());
            in.setReportDate((StringUtils.trimToEmpty(record.getBeginTime()) + " " + StringUtils.trimToEmpty(record.getEndTime())).trim());
            fiDynamicReportApiReqMapper.insert(in);
        }
        //杨浦小企业现金表
        struct = fiDynamicReportStructMapper.selectByPrimaryKey(11);
        example = new Example(FiDynamicReportApiReq.class);
        example.createCriteria().andEqualTo("reportId", struct.getId());
        example.orderBy("recordId").desc();
        rowBounds = new RowBounds(0, 1);
        List<FiDynamicReportApiReq> reqList_11 = fiDynamicReportApiReqMapper.selectByExampleAndRowBounds(example, rowBounds);
        recordId = 0;
        if (reqList_11.size() > 0) {
            recordId = reqList_11.get(0).getRecordId();
        }
        example = new Example(OdsXlhDataformatYpSmallCashTable.class);
        example.createCriteria().andGreaterThan("id", recordId);
        List<OdsXlhDataformatYpSmallCashTable> ypSmallCashTables = odsXlhDataformatYpSmallCashTableMapper.selectByExample(example);
        for (OdsXlhDataformatYpSmallCashTable record : ypSmallCashTables) {
            FiDynamicReportApiReq in = new FiDynamicReportApiReq();
            in.setStep(19);
            in.setUpdateTime(new Date());
            in.setReportTitle(struct.getReportTitle());
            in.setReportId(struct.getId());
            in.setReqJsonStr("{}");
            in.setFileName(record.getFileName());
            in.setEnterpriseName(record.getEnterpriseName().replace("编制单位:", ""));
            in.setInsertTime(new Date());
            in.setNeedCheck(struct.getNeedCheck());
            in.setRecordId(record.getId());
            in.setReportDate((StringUtils.trimToEmpty(record.getBeginTime()) + " " + StringUtils.trimToEmpty(record.getEndTime())).trim());
            fiDynamicReportApiReqMapper.insert(in);
        }
        //杨浦一般企业资产负债表
        struct = fiDynamicReportStructMapper.selectByPrimaryKey(12);
        example = new Example(FiDynamicReportApiReq.class);
        example.createCriteria().andEqualTo("reportId", struct.getId());
        example.orderBy("recordId").desc();
        rowBounds = new RowBounds(0, 1);
        List<FiDynamicReportApiReq> reqList_12 = fiDynamicReportApiReqMapper.selectByExampleAndRowBounds(example, rowBounds);
        recordId = 0;
        if (reqList_12.size() > 0) {
            recordId = reqList_12.get(0).getRecordId();
        }
        example = new Example(OdsXlhDataformatYpNormalBalanceTable.class);
        example.createCriteria().andGreaterThan("id", recordId);
        List<OdsXlhDataformatYpNormalBalanceTable> ypNormalBalanceTables = odsXlhDataformatYpNormalBalanceTableMapper.selectByExample(example);
        for (OdsXlhDataformatYpNormalBalanceTable record : ypNormalBalanceTables) {
            FiDynamicReportApiReq in = new FiDynamicReportApiReq();
            in.setStep(19);
            in.setUpdateTime(new Date());
            in.setReportTitle(struct.getReportTitle());
            in.setReportId(struct.getId());
            in.setReqJsonStr("{}");
            in.setFileName(record.getFileName());
            in.setEnterpriseName(record.getEnterpriseName().replace("编制单位:", ""));
            in.setInsertTime(new Date());
            in.setNeedCheck(struct.getNeedCheck());
            in.setRecordId(record.getId());
            in.setReportDate((StringUtils.trimToEmpty(record.getBeginTime()) + " " + StringUtils.trimToEmpty(record.getEndTime())).trim());
            fiDynamicReportApiReqMapper.insert(in);
        }

        //杨浦一般企业利润表
        struct = fiDynamicReportStructMapper.selectByPrimaryKey(13);
        example = new Example(FiDynamicReportApiReq.class);
        example.createCriteria().andEqualTo("reportId", struct.getId());
        example.orderBy("recordId").desc();
        rowBounds = new RowBounds(0, 1);
        List<FiDynamicReportApiReq> reqList_13 = fiDynamicReportApiReqMapper.selectByExampleAndRowBounds(example, rowBounds);
        recordId = 0;
        if (reqList_13.size() > 0) {
            recordId = reqList_13.get(0).getRecordId();
        }
        example = new Example(OdsXlhDataformatYpNormalProfitTable.class);
        example.createCriteria().andGreaterThan("id", recordId);
        List<OdsXlhDataformatYpNormalProfitTable> ypNormalProfitTables = odsXlhDataformatYpNormalProfitTableMapper.selectByExample(example);
        for (OdsXlhDataformatYpNormalProfitTable record : ypNormalProfitTables) {
            FiDynamicReportApiReq in = new FiDynamicReportApiReq();
            in.setStep(19);
            in.setUpdateTime(new Date());
            in.setReportTitle(struct.getReportTitle());
            in.setReportId(struct.getId());
            in.setReqJsonStr("{}");
            in.setFileName(record.getFileName());
            in.setEnterpriseName(record.getEnterpriseName().replace("编制单位:", ""));
            in.setInsertTime(new Date());
            in.setNeedCheck(struct.getNeedCheck());
            in.setRecordId(record.getId());
            in.setReportDate((StringUtils.trimToEmpty(record.getBeginTime()) + " " + StringUtils.trimToEmpty(record.getEndTime())).trim());
            fiDynamicReportApiReqMapper.insert(in);
        }
        addReportData();
    }

    public void addReportData() {
        Example example = new Example(FiDynamicReportApiReq.class);
        example.createCriteria().andEqualTo("step", 19);
        List<FiDynamicReportApiReq> reqList = fiDynamicReportApiReqMapper.selectByExample(example);
        for (FiDynamicReportApiReq record : reqList) {
            logger.info("更新creditNo record={}",JSON.toJSONString(record));
            try {
                example = new Example(CdmEntDtoCorpInfo.class);
                example.createCriteria().andEqualTo("enterpriseName", record.getEnterpriseName());
                List<CdmEntDtoCorpInfo> entDtoCorpInfos = cdmEntDtoCorpInfoMapper.selectByExample(example);
                if (entDtoCorpInfos.size() > 0) {
                    switch (record.getReportId()) {
                        case 4:
                            jxSmallProfitExchange(record);
                            break;
                        case 6:
                            jxSmallBalanceExchange(record);
                            break;
                        case 7:
                            jxNormalProfitExchange(record);
                            break;
                        case 8:
                            jxNormalBalanceExchange(record);
                            break;
                        case 9:
                            ypSmallProfitExchange(record);
                            break;
                        case 10:
                            ypSmallBalanceExchange(record);
                            break;
                        case 11:
                            ypSmallCashExchange(record);
                            break;
                        case 12:
                            ypNormalBalanceExchange(record);
                            break;
                        case 13:
                            ypNormalProfitExchange(record);
                            break;
                    }
                    record.setRegCreditNo(entDtoCorpInfos.get(0).getRegCreditNo());
                    record.setUpdateTime(new Date());
                    record.setStep(3);
                    fiDynamicReportApiReqMapper.updateByPrimaryKey(record);
                }
            }catch (Exception e){
                logger.info("异常={}",e.getMessage());
            }

        }
    }

    public void jxSmallProfitExchange(FiDynamicReportApiReq req) throws IllegalAccessException {
        OdsXlhDataformatJxSmallProfitTable odsXlhDataformatJxSmallProfitTable = odsXlhDataformatJxSmallProfitTableMapper.selectByPrimaryKey(req.getRecordId());
        Field[] fieldArray = OdsXlhDataformatJxSmallProfitTable.class.getDeclaredFields();
        Example example = new Example(FiTableSyncColumn.class);
        example.createCriteria().andEqualTo("className", OdsXlhDataformatJxSmallProfitTable.class.getName());
        List<FiTableSyncColumn> fiTableSyncColumns = fiTableSyncColumnMapper.selectByExample(example);
        Map<String, String> map = new HashMap<>();
        for (FiTableSyncColumn record : fiTableSyncColumns) {
            map.put(record.getFieldName(), record.getReportColumnName());
        }
        DBObject record = new BasicDBObject();
        record.put("reqId", req.getId());
        record.put("enterpriseName", odsXlhDataformatJxSmallProfitTable.getEnterpriseName());
        record.put("date", req.getReportDate());
        record.put("insertTime", new Date());
        for (Field f : fieldArray) {
            String name = f.getName();
            String columnName = map.get(name);
            if (columnName != null) {
                f.setAccessible(true);
                record.put(map.get(name), f.get(odsXlhDataformatJxSmallProfitTable));
            }
        }
        DBCollection dbCollection = mongoTemplate.getDb().getCollection("dynamic_report_" + String.valueOf(req.getReportId()));
        DBObject condition = new BasicDBObject();
        condition.put("reqId", req.getId());
        DBObject findRes = dbCollection.findOne(condition);
        if (findRes != null) {
            record.put("_id", findRes.get("_id"));
        }
        dbCollection.save(record);
    }

    public void jxSmallBalanceExchange(FiDynamicReportApiReq req) throws IllegalAccessException {
        OdsXlhDataformatJxSmallBalanceTable odsXlhDataformatJxSmallBalanceTable = odsXlhDataformatJxSmallBalanceTableMapper.selectByPrimaryKey(req.getRecordId());
        Field[] fieldArray = OdsXlhDataformatJxSmallBalanceTable.class.getDeclaredFields();
        Example example = new Example(FiTableSyncColumn.class);
        example.createCriteria().andEqualTo("className", OdsXlhDataformatJxSmallBalanceTable.class.getName());
        List<FiTableSyncColumn> fiTableSyncColumns = fiTableSyncColumnMapper.selectByExample(example);
        Map<String, String> map = new HashMap<>();
        for (FiTableSyncColumn record : fiTableSyncColumns) {
            map.put(record.getFieldName(), record.getReportColumnName());
        }
        DBObject record = new BasicDBObject();
        record.put("reqId", req.getId());
        record.put("enterpriseName", odsXlhDataformatJxSmallBalanceTable.getEnterpriseName());
        record.put("date", req.getReportDate());
        record.put("insertTime", new Date());
        for (Field f : fieldArray) {
            String name = f.getName();
            String columnName = map.get(name);
            if (columnName != null) {
                f.setAccessible(true);
                record.put(map.get(name), f.get(odsXlhDataformatJxSmallBalanceTable));
            }
        }
        DBCollection dbCollection = mongoTemplate.getDb().getCollection("dynamic_report_" + String.valueOf(req.getReportId()));
        DBObject condition = new BasicDBObject();
        condition.put("reqId", req.getId());
        DBObject findRes = dbCollection.findOne(condition);
        if (findRes != null) {
            record.put("_id", findRes.get("_id"));
        }
        dbCollection.save(record);
    }

    public void jxNormalBalanceExchange(FiDynamicReportApiReq req) throws IllegalAccessException {
        OdsXlhDataformatJxNormalBalanceTable odsXlhDataformatJxNormalBalanceTable = odsXlhDataformatJxNormalBalanceTableMapper.selectByPrimaryKey(req.getRecordId());
        Field[] fieldArray = OdsXlhDataformatJxNormalBalanceTable.class.getDeclaredFields();
        Example example = new Example(FiTableSyncColumn.class);
        example.createCriteria().andEqualTo("className", OdsXlhDataformatJxNormalBalanceTable.class.getName());
        List<FiTableSyncColumn> fiTableSyncColumns = fiTableSyncColumnMapper.selectByExample(example);
        Map<String, String> map = new HashMap<>();
        for (FiTableSyncColumn record : fiTableSyncColumns) {
            map.put(record.getFieldName(), record.getReportColumnName());
        }
        DBObject record = new BasicDBObject();
        record.put("reqId", req.getId());
        record.put("enterpriseName", odsXlhDataformatJxNormalBalanceTable.getEnterpriseName());
        record.put("date", req.getReportDate());
        record.put("insertTime", new Date());
        for (Field f : fieldArray) {
            String name = f.getName();
            String columnName = map.get(name);
            if (columnName != null) {
                f.setAccessible(true);
                record.put(map.get(name), f.get(odsXlhDataformatJxNormalBalanceTable));
            }
        }
        DBCollection dbCollection = mongoTemplate.getDb().getCollection("dynamic_report_" + String.valueOf(req.getReportId()));
        DBObject condition = new BasicDBObject();
        condition.put("reqId", req.getId());
        DBObject findRes = dbCollection.findOne(condition);
        if (findRes != null) {
            record.put("_id", findRes.get("_id"));
        }
        dbCollection.save(record);
    }

    public void jxNormalProfitExchange(FiDynamicReportApiReq req) throws IllegalAccessException {
        OdsXlhDataformatJxNormalProfitTable odsXlhDataformatJxNormalProfitTable = odsXlhDataformatJxNormalProfitTableMapper.selectByPrimaryKey(req.getRecordId());
        Field[] fieldArray = OdsXlhDataformatJxNormalProfitTable.class.getDeclaredFields();
        Example example = new Example(FiTableSyncColumn.class);
        example.createCriteria().andEqualTo("className", OdsXlhDataformatJxNormalProfitTable.class.getName());
        List<FiTableSyncColumn> fiTableSyncColumns = fiTableSyncColumnMapper.selectByExample(example);
        Map<String, String> map = new HashMap<>();
        for (FiTableSyncColumn record : fiTableSyncColumns) {
            map.put(record.getFieldName(), record.getReportColumnName());
        }
        DBObject record = new BasicDBObject();
        for (Field f : fieldArray) {
            String name = f.getName();
            String columnName = map.get(name);
            if (columnName != null) {
                f.setAccessible(true);
                record.put(map.get(name), f.get(odsXlhDataformatJxNormalProfitTable));
            }
        }
        record.put("reqId", req.getId());
        record.put("enterpriseName", odsXlhDataformatJxNormalProfitTable.getEnterpriseName());
        record.put("date", req.getReportDate());
        record.put("insertTime", new Date());
        DBCollection dbCollection = mongoTemplate.getDb().getCollection("dynamic_report_" + String.valueOf(req.getReportId()));
        DBObject condition = new BasicDBObject();
        condition.put("reqId", req.getId());
        DBObject findRes = dbCollection.findOne(condition);
        if (findRes != null) {
            record.put("_id", findRes.get("_id"));
        }
        dbCollection.save(record);
    }


    public void ypSmallProfitExchange(FiDynamicReportApiReq req) throws IllegalAccessException {
        OdsXlhDataformatYpSmallProfitTable odsXlhDataformatYpSmallProfitTable = odsXlhDataformatYpSmallProfitTableMapper.selectByPrimaryKey(req.getRecordId());
        Field[] fieldArray = OdsXlhDataformatYpSmallProfitTable.class.getDeclaredFields();
        Example example = new Example(FiTableSyncColumn.class);
        example.createCriteria().andEqualTo("className", OdsXlhDataformatYpSmallProfitTable.class.getName());
        List<FiTableSyncColumn> fiTableSyncColumns = fiTableSyncColumnMapper.selectByExample(example);
        Map<String, String> map = new HashMap<>();
        for (FiTableSyncColumn record : fiTableSyncColumns) {
            map.put(record.getFieldName(), record.getReportColumnName());
        }
        DBObject record = new BasicDBObject();
        record.put("reqId", req.getId());
        record.put("enterpriseName", odsXlhDataformatYpSmallProfitTable.getEnterpriseName());
        record.put("date", req.getReportDate());
        record.put("insertTime", new Date());
        for (Field f : fieldArray) {
            String name = f.getName();
            String columnName = map.get(name);
            if (columnName != null) {
                f.setAccessible(true);
                record.put(map.get(name), f.get(odsXlhDataformatYpSmallProfitTable));
            }
        }
        DBCollection dbCollection = mongoTemplate.getDb().getCollection("dynamic_report_" + String.valueOf(req.getReportId()));
        DBObject condition = new BasicDBObject();
        condition.put("reqId", req.getId());
        DBObject findRes = dbCollection.findOne(condition);
        if (findRes != null) {
            record.put("_id", findRes.get("_id"));
        }
        dbCollection.save(record);
    }

    public void ypSmallBalanceExchange(FiDynamicReportApiReq req) throws IllegalAccessException {
        OdsXlhDataformatYpSmallBalanceTable odsXlhDataformatYpSmallBalanceTable = odsXlhDataformatYpSmallBalanceTableMapper.selectByPrimaryKey(req.getRecordId());
        Field[] fieldArray = OdsXlhDataformatYpSmallBalanceTable.class.getDeclaredFields();
        Example example = new Example(FiTableSyncColumn.class);
        example.createCriteria().andEqualTo("className", OdsXlhDataformatYpSmallBalanceTable.class.getName());
        List<FiTableSyncColumn> fiTableSyncColumns = fiTableSyncColumnMapper.selectByExample(example);
        Map<String, String> map = new HashMap<>();
        for (FiTableSyncColumn record : fiTableSyncColumns) {
            map.put(record.getFieldName(), record.getReportColumnName());
        }
        DBObject record = new BasicDBObject();
        record.put("reqId", req.getId());
        record.put("enterpriseName", odsXlhDataformatYpSmallBalanceTable.getEnterpriseName());
        record.put("date", req.getReportDate());
        record.put("insertTime", new Date());
        for (Field f : fieldArray) {
            String name = f.getName();
            String columnName = map.get(name);
            if (columnName != null) {
                f.setAccessible(true);
                record.put(map.get(name), f.get(odsXlhDataformatYpSmallBalanceTable));
            }
        }
        DBCollection dbCollection = mongoTemplate.getDb().getCollection("dynamic_report_" + String.valueOf(req.getReportId()));
        DBObject condition = new BasicDBObject();
        condition.put("reqId", req.getId());
        DBObject findRes = dbCollection.findOne(condition);
        if (findRes != null) {
            record.put("_id", findRes.get("_id"));
        }
        dbCollection.save(record);
    }

    public void ypSmallCashExchange(FiDynamicReportApiReq req) throws IllegalAccessException {
        OdsXlhDataformatYpSmallCashTable odsXlhDataformatYpSmallCashTable = odsXlhDataformatYpSmallCashTableMapper.selectByPrimaryKey(req.getRecordId());
        Field[] fieldArray = OdsXlhDataformatYpSmallCashTable.class.getDeclaredFields();
        Example example = new Example(FiTableSyncColumn.class);
        example.createCriteria().andEqualTo("className", OdsXlhDataformatYpSmallCashTable.class.getName());
        List<FiTableSyncColumn> fiTableSyncColumns = fiTableSyncColumnMapper.selectByExample(example);
        Map<String, String> map = new HashMap<>();
        for (FiTableSyncColumn record : fiTableSyncColumns) {
            map.put(record.getFieldName(), record.getReportColumnName());
        }
        DBObject record = new BasicDBObject();
        record.put("reqId", req.getId());
        record.put("enterpriseName", odsXlhDataformatYpSmallCashTable.getEnterpriseName());
        record.put("date", req.getReportDate());
        record.put("insertTime", new Date());
        for (Field f : fieldArray) {
            String name = f.getName();
            String columnName = map.get(name);
            if (columnName != null) {
                f.setAccessible(true);
                record.put(map.get(name), f.get(odsXlhDataformatYpSmallCashTable));
            }
        }
        DBCollection dbCollection = mongoTemplate.getDb().getCollection("dynamic_report_" + String.valueOf(req.getReportId()));
        DBObject condition = new BasicDBObject();
        condition.put("reqId", req.getId());
        DBObject findRes = dbCollection.findOne(condition);
        if (findRes != null) {
            record.put("_id", findRes.get("_id"));
        }
        dbCollection.save(record);
    }

    public void ypNormalBalanceExchange(FiDynamicReportApiReq req) throws IllegalAccessException {
        OdsXlhDataformatYpNormalBalanceTable odsXlhDataformatYpNormalBalanceTable = odsXlhDataformatYpNormalBalanceTableMapper.selectByPrimaryKey(req.getRecordId());
        Field[] fieldArray = OdsXlhDataformatYpNormalBalanceTable.class.getDeclaredFields();
        Example example = new Example(FiTableSyncColumn.class);
        example.createCriteria().andEqualTo("className", OdsXlhDataformatYpNormalBalanceTable.class.getName());
        List<FiTableSyncColumn> fiTableSyncColumns = fiTableSyncColumnMapper.selectByExample(example);
        Map<String, String> map = new HashMap<>();
        for (FiTableSyncColumn record : fiTableSyncColumns) {
            map.put(record.getFieldName(), record.getReportColumnName());
        }
        DBObject record = new BasicDBObject();
        record.put("reqId", req.getId());
        record.put("enterpriseName", odsXlhDataformatYpNormalBalanceTable.getEnterpriseName());
        record.put("date", req.getReportDate());
        record.put("insertTime", new Date());
        for (Field f : fieldArray) {
            String name = f.getName();
            String columnName = map.get(name);
            if (columnName != null) {
                f.setAccessible(true);
                record.put(map.get(name), f.get(odsXlhDataformatYpNormalBalanceTable));
            }
        }
        DBCollection dbCollection = mongoTemplate.getDb().getCollection("dynamic_report_" + String.valueOf(req.getReportId()));
        DBObject condition = new BasicDBObject();
        condition.put("reqId", req.getId());
        DBObject findRes = dbCollection.findOne(condition);
        if (findRes != null) {
            record.put("_id", findRes.get("_id"));
        }
        dbCollection.save(record);
    }

    public void ypNormalProfitExchange(FiDynamicReportApiReq req) throws IllegalAccessException {
        OdsXlhDataformatYpNormalProfitTable odsXlhDataformatYpNormalProfitTable = odsXlhDataformatYpNormalProfitTableMapper.selectByPrimaryKey(req.getRecordId());
        Field[] fieldArray = OdsXlhDataformatYpNormalProfitTable.class.getDeclaredFields();
        Example example = new Example(FiTableSyncColumn.class);
        example.createCriteria().andEqualTo("className", OdsXlhDataformatYpNormalProfitTable.class.getName());
        List<FiTableSyncColumn> fiTableSyncColumns = fiTableSyncColumnMapper.selectByExample(example);
        Map<String, String> map = new HashMap<>();
        for (FiTableSyncColumn record : fiTableSyncColumns) {
            map.put(record.getFieldName(), record.getReportColumnName());
        }
        DBObject record = new BasicDBObject();
        for (Field f : fieldArray) {
            String name = f.getName();
            String columnName = map.get(name);
            if (columnName != null) {
                f.setAccessible(true);
                record.put(map.get(name), f.get(odsXlhDataformatYpNormalProfitTable));
            }
        }
        record.put("reqId", req.getId());
        record.put("enterpriseName", odsXlhDataformatYpNormalProfitTable.getEnterpriseName());
        record.put("date", req.getReportDate());
        record.put("insertTime", new Date());
        DBCollection dbCollection = mongoTemplate.getDb().getCollection("dynamic_report_" + String.valueOf(req.getReportId()));
        DBObject condition = new BasicDBObject();
        condition.put("reqId", req.getId());
        DBObject findRes = dbCollection.findOne(condition);
        if (findRes != null) {
            record.put("_id", findRes.get("_id"));
        }
        dbCollection.save(record);
    }

    public void addReachcsr(){
        Example example = new Example(CrmReachcsr.class);
        example.createCriteria().andEqualTo("bizLv1Id", "科技贷");
        example.orderBy("beginTime").desc();
        RowBounds rowBounds = new RowBounds(0, 1);
        List<CrmReachcsr> list = crmReachcsrMapper.selectByExampleAndRowBounds(example, rowBounds);
        String firstBeginTime="";
        if (list.size()>0){
            firstBeginTime=list.get(0).getBeginTime();
        }
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        String dsNow=simpleDateFormat.format(new Date());
        example=new Example(CdmMongodbEnterpriseBaseInfoDetailD.class);
        example.createCriteria().andGreaterThan("createTime",firstBeginTime).andEqualTo("ds",dsNow);
        List<CdmMongodbEnterpriseBaseInfoDetailD> cdmMongodbEnterpriseBaseInfoDetailDList = cdmMongodbEnterpriseBaseInfoDetailDMapper.selectByExample(example);
        for(CdmMongodbEnterpriseBaseInfoDetailD input : cdmMongodbEnterpriseBaseInfoDetailDList){
            try {
                CrmReachcsr record=new CrmReachcsr();
                long curtimes = System.currentTimeMillis();
                String rchNo = Long.toString(curtimes);
                record.setCustType("corpCust");
                record.setRchNo(rchNo);
                record.setBizLv1Id("科技贷");
                record.setRegCreditNo(input.getRegCreditNo());
                record.setCreditNo(input.getCreditNo());
                record.setRegNo(input.getRegNo());
                record.setEnterpriseName(input.getEnterpriseName());
                record.setRchMode("拜访");
                record.setWinCustChnl("政府");
                record.setBeginTime(input.getCreateTime());
                record.setContacts(input.getContactPerson());
                record.setContactsPhone(input.getContactPhone());
                record.setJobTitle("");
                record.setSalesLead("");
                record.setRchEmp(input.getDataSource()+"科技贷系统");
                record.setCompany(input.getArea());
                record.setInsertTime(CurrentTime.getCurrentTime());
                record.setUpdateTime(record.getInsertTime());
                crmReachcsrMapper.insert(record);
                Thread.sleep(5);
            } catch (Exception e) {
                logger.info("异常 ={}",e.getMessage());
            }

        }
    }
    public void ttttt() {
        Field[] fieldArray = OdsXlhDataformatJxSmallProfitTable.class.getDeclaredFields();
        for (Field f : fieldArray) {
            FiTableSyncColumn tableSyncColumn = new FiTableSyncColumn();
            tableSyncColumn.setClassName(OdsXlhDataformatJxSmallProfitTable.class.getName());
            tableSyncColumn.setFieldName(f.getName());
            try {
                fiTableSyncColumnMapper.insert(tableSyncColumn);
            } catch (Exception e) {
            }
        }

        fieldArray = OdsXlhDataformatJxSmallBalanceTable.class.getDeclaredFields();
        for (Field f : fieldArray) {
            FiTableSyncColumn tableSyncColumn = new FiTableSyncColumn();
            tableSyncColumn.setClassName(OdsXlhDataformatJxSmallBalanceTable.class.getName());
            tableSyncColumn.setFieldName(f.getName());
            try {
                fiTableSyncColumnMapper.insert(tableSyncColumn);
            } catch (Exception e) {
            }
        }

        fieldArray = OdsXlhDataformatJxNormalProfitTable.class.getDeclaredFields();
        for (Field f : fieldArray) {
            FiTableSyncColumn tableSyncColumn = new FiTableSyncColumn();
            tableSyncColumn.setClassName(OdsXlhDataformatJxNormalProfitTable.class.getName());
            tableSyncColumn.setFieldName(f.getName());
            try {
                fiTableSyncColumnMapper.insert(tableSyncColumn);
            } catch (Exception e) {
            }
        }
        fieldArray = OdsXlhDataformatJxNormalBalanceTable.class.getDeclaredFields();
        for (Field f : fieldArray) {
            FiTableSyncColumn tableSyncColumn = new FiTableSyncColumn();
            tableSyncColumn.setClassName(OdsXlhDataformatJxNormalBalanceTable.class.getName());
            tableSyncColumn.setFieldName(f.getName());
            try {
                fiTableSyncColumnMapper.insert(tableSyncColumn);
            } catch (Exception e) {
            }
        }

        fieldArray = OdsXlhDataformatYpSmallProfitTable.class.getDeclaredFields();
        for (Field f : fieldArray) {
            FiTableSyncColumn tableSyncColumn = new FiTableSyncColumn();
            tableSyncColumn.setClassName(OdsXlhDataformatYpSmallProfitTable.class.getName());
            tableSyncColumn.setFieldName(f.getName());
            try {
                fiTableSyncColumnMapper.insert(tableSyncColumn);
            } catch (Exception e) {
            }
        }

        fieldArray = OdsXlhDataformatYpSmallBalanceTable.class.getDeclaredFields();
        for (Field f : fieldArray) {
            FiTableSyncColumn tableSyncColumn = new FiTableSyncColumn();
            tableSyncColumn.setClassName(OdsXlhDataformatYpSmallBalanceTable.class.getName());
            tableSyncColumn.setFieldName(f.getName());
            try {
                fiTableSyncColumnMapper.insert(tableSyncColumn);
            } catch (Exception e) {
            }
        }

        fieldArray = OdsXlhDataformatYpSmallCashTable.class.getDeclaredFields();
        for (Field f : fieldArray) {
            FiTableSyncColumn tableSyncColumn = new FiTableSyncColumn();
            tableSyncColumn.setClassName(OdsXlhDataformatYpSmallCashTable.class.getName());
            tableSyncColumn.setFieldName(f.getName());
            try {
                fiTableSyncColumnMapper.insert(tableSyncColumn);
            } catch (Exception e) {
            }
        }
        fieldArray = OdsXlhDataformatYpNormalProfitTable.class.getDeclaredFields();
        for (Field f : fieldArray) {
            FiTableSyncColumn tableSyncColumn = new FiTableSyncColumn();
            tableSyncColumn.setClassName(OdsXlhDataformatYpNormalProfitTable.class.getName());
            tableSyncColumn.setFieldName(f.getName());
            try {
                fiTableSyncColumnMapper.insert(tableSyncColumn);
            } catch (Exception e) {
            }
        }
        fieldArray = OdsXlhDataformatYpNormalBalanceTable.class.getDeclaredFields();
        for (Field f : fieldArray) {
            FiTableSyncColumn tableSyncColumn = new FiTableSyncColumn();
            tableSyncColumn.setClassName(OdsXlhDataformatYpNormalBalanceTable.class.getName());
            tableSyncColumn.setFieldName(f.getName());
            try {
                fiTableSyncColumnMapper.insert(tableSyncColumn);
            } catch (Exception e) {
            }
        }
    }
}
