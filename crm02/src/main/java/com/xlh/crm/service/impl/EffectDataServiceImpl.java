package com.xlh.crm.service.impl;

import com.alibaba.fastjson.JSON;
import com.xlh.crm.dto.mysql.*;
import com.xlh.crm.mapper.FiJxNormalBalanceTableMapper;
import com.xlh.crm.mapper.FiJxNormalProfitTableMapper;
import com.xlh.crm.mapper.FiJxSmallBalanceTableMapper;
import com.xlh.crm.mapper.FiJxSmallProfitTableMapper;
import com.xlh.crm.service.EffectDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class EffectDataServiceImpl implements EffectDataService {
    private Logger logger = LoggerFactory.getLogger(EffectDataServiceImpl.class);
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM");
    @Autowired
    private FiJxNormalBalanceTableMapper fiJxNormalBalanceTableMapper;

    @Autowired
    private FiJxNormalProfitTableMapper fiJxNormalProfitTableMapper;

    @Autowired
    private FiJxSmallBalanceTableMapper fiJxSmallBalanceTableMapper;

    @Autowired
    private FiJxSmallProfitTableMapper fiJxSmallProfitTableMapper;


    public FiJxNormalBalanceTable selectJxNormalBalance(Integer id) throws Exception {
        logger.info("Start id={}",id);
        FiJxNormalBalanceTable record = fiJxNormalBalanceTableMapper.selectByPrimaryKey(id);
        if (record==null) {
            logger.info("数据不存在fiJxNormalBalanceTable={}", JSON.toJSONString(record));
            throw new Exception("数据不存在");
        }
        return record;
    }
    public FiJxNormalProfitTable selectJxNormalProfit(Integer id) throws Exception {
        logger.info("Start id={}",id);
        FiJxNormalProfitTable record = fiJxNormalProfitTableMapper.selectByPrimaryKey(id);
        if (record==null) {
            logger.info("数据不存在fiJxNormalBalanceTable={}", JSON.toJSONString(record));
            throw new Exception("数据不存在");
        }
        return record;
    }

    public FiJxSmallProfitTable selectJxSmallProfit(Integer id) throws Exception {

        logger.info("Start id={}",id);
        FiJxSmallProfitTable record = fiJxSmallProfitTableMapper.selectByPrimaryKey(id);
        if (record==null) {
            logger.info("数据不存在fiJxNormalBalanceTable={}", JSON.toJSONString(record));
            throw new Exception("数据不存在");
        }
        return record;
    }

    public FiJxSmallBalanceTable selectJxSmallBalance(Integer id) throws Exception {
        logger.info("Start id={}",id);
        FiJxSmallBalanceTable record = fiJxSmallBalanceTableMapper.selectByPrimaryKey(id);
        if (record==null) {
            logger.info("数据不存在fiJxNormalBalanceTable={}", JSON.toJSONString(record));
            throw new Exception("数据不存在");
        }
        return record;
    }









    public int insertJxNormalBalance(FiJxNormalBalanceTable fiJxNormalBalanceTable) throws Exception {
        logger.info("Start fiJxNormalBalanceTable={}",fiJxNormalBalanceTable);
        fiJxNormalBalanceTable.setTableDate(formatDate(fiJxNormalBalanceTable.getTableDate()));
        Example example = new Example(FiJxNormalBalanceTable.class);
        example.createCriteria().andEqualTo("tableDate", fiJxNormalBalanceTable.getTableDate()).andEqualTo("reportType", fiJxNormalBalanceTable.getReportType())
                .andEqualTo("tableStander", fiJxNormalBalanceTable.getTableStander()).andEqualTo("regCreditNo",fiJxNormalBalanceTable.getRegCreditNo());
        List<FiJxNormalBalanceTable> list = fiJxNormalBalanceTableMapper.selectByExample(example);
        if (list.size() > 0) {
            logger.info("数据已存在fiJxNormalBalanceTable={}", JSON.toJSONString(fiJxNormalBalanceTable));
            throw new Exception("数据已存在");
        }
        return fiJxNormalBalanceTableMapper.insert(fiJxNormalBalanceTable);
    }
    public int insertJxNormalProfit(FiJxNormalProfitTable fiJxNormalProfitTable) throws Exception {
        logger.info("Start fiJxNormalProfitTable={}",fiJxNormalProfitTable);
        fiJxNormalProfitTable.setTableDate(formatDate(fiJxNormalProfitTable.getTableDate()));
        Example example = new Example(FiJxNormalProfitTable.class);
        example.createCriteria().andEqualTo("tableDate", fiJxNormalProfitTable.getTableDate()).andEqualTo("reportType", fiJxNormalProfitTable.getReportType())
                .andEqualTo("tableStander", fiJxNormalProfitTable.getTableStander()).andEqualTo("regCreditNo",fiJxNormalProfitTable.getRegCreditNo());
        List<FiJxNormalProfitTable> list = fiJxNormalProfitTableMapper.selectByExample(example);
        if (list.size() > 0) {
            logger.info("fiJxNormalProfitTable={}", JSON.toJSONString(fiJxNormalProfitTable));
            throw new Exception("数据已存在");
        }
        return fiJxNormalProfitTableMapper.insert(fiJxNormalProfitTable);
    }

    public int insertJxSmallProfit(FiJxSmallProfitTable fiJxSmallProfitTable) throws Exception {
        logger.info("Start fiJxSmallProfitTable={}",fiJxSmallProfitTable);
        fiJxSmallProfitTable.setTableDate(formatDate(fiJxSmallProfitTable.getTableDate()));
        Example example = new Example(FiJxSmallProfitTable.class);
        example.createCriteria().andEqualTo("tableDate", fiJxSmallProfitTable.getTableDate()).andEqualTo("reportType", fiJxSmallProfitTable.getReportType())
                .andEqualTo("tableStander", fiJxSmallProfitTable.getTableStander()).andEqualTo("regCreditNo",fiJxSmallProfitTable.getRegCreditNo());
        List<FiJxSmallProfitTable> list = fiJxSmallProfitTableMapper.selectByExample(example);
        if (list.size() > 0) {
            logger.info("fiJxSmallProfitTable={}", JSON.toJSONString(fiJxSmallProfitTable));
            throw new Exception("数据已存在");
        }
        return fiJxSmallProfitTableMapper.insert(fiJxSmallProfitTable);
    }

    public int insertJxSmallBalance(FiJxSmallBalanceTable fiJxSmallBalanceTable) throws Exception {
        logger.info("Start fiJxSmallBalanceTable={}",fiJxSmallBalanceTable);
        fiJxSmallBalanceTable.setTableDate(formatDate(fiJxSmallBalanceTable.getTableDate()));
        Example example = new Example(FiJxSmallBalanceTable.class);
        example.createCriteria().andEqualTo("tableDate", fiJxSmallBalanceTable.getTableDate()).andEqualTo("reportType", fiJxSmallBalanceTable.getReportType())
                .andEqualTo("tableStander", fiJxSmallBalanceTable.getTableStander()).andEqualTo("regCreditNo",fiJxSmallBalanceTable.getRegCreditNo());
        List<FiJxSmallBalanceTable> list = fiJxSmallBalanceTableMapper.selectByExample(example);
        if (list.size() > 0) {
            logger.info("fiJxSmallProfitTable={}", JSON.toJSONString(fiJxSmallBalanceTable));
            throw new Exception("数据已存在");
        }
        return fiJxSmallBalanceTableMapper.insert(fiJxSmallBalanceTable);
    }

    private String formatDate(String inputDate) throws Exception {
        String pattern="(\\d{4}-\\d{1,2})";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(inputDate);
        if (m.find()) {
            return m.group(1);
        }
        throw new Exception("报表日期不正确");
    }
}
