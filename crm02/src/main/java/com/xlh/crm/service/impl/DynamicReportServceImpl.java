package com.xlh.crm.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.xlh.crm.common.CurrentTime;
import com.xlh.crm.dto.dynamicReport.DynamicReport;
import com.xlh.crm.dto.mysql.FiDynamicReportApiReq;
import com.xlh.crm.dto.mysql.FiDynamicReportColumn;
import com.xlh.crm.dto.mysql.FiDynamicReportStruct;
import com.xlh.crm.mapper.FiDynamicReportApiReqMapper;
import com.xlh.crm.mapper.FiDynamicReportColumnMapper;
import com.xlh.crm.mapper.FiDynamicReportStructMapper;
import com.xlh.crm.utils.BeanUtil;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

@Service
public class DynamicReportServceImpl {


    @Autowired
    private JedisPool jedisPool;
    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    private FiDynamicReportColumnMapper fiDynamicReportColumnMapper;
    @Autowired
    private FiDynamicReportStructMapper fiDynamicReportStructMapper;
    @Autowired
    private FiDynamicReportApiReqMapper fiDynamicReportApiReqMapper;


    /**
     * 保存报表  只能新增 不能编辑 删除
     *
     * @param dynamicReport
     * @return
     * @throws Exception
     */
    public FiDynamicReportStruct saveDynamicReportTable(DynamicReport dynamicReport) throws Exception {
        FiDynamicReportStruct fiDynamicReportStruct=new FiDynamicReportStruct();
        dynamicReport.setInterfaceUrl(dynamicReport.getInterfaceUrl().trim());
        if(dynamicReport.getId()==0){
            BeanUtil.copyBeanProperties(dynamicReport,fiDynamicReportStruct);
            fiDynamicReportStruct.setInsertTime(CurrentTime.getCurrentTime());
            fiDynamicReportStruct.setUpdateTime(fiDynamicReportStruct.getInsertTime());
            fiDynamicReportStructMapper.insert(fiDynamicReportStruct);
            dynamicReport.setId(fiDynamicReportStruct.getId());
        }else{
            fiDynamicReportStruct= fiDynamicReportStructMapper.selectByPrimaryKey(dynamicReport.getId());
            fiDynamicReportStruct.setInterfaceUrl(dynamicReport.getInterfaceUrl());
            fiDynamicReportStruct.setReportTitle(dynamicReport.getReportTitle());
            fiDynamicReportStruct.setSignClassName(dynamicReport.getSignClassName());
            fiDynamicReportStruct.setNeedCheck(dynamicReport.getNeedCheck());
            fiDynamicReportStruct.setUpdateTime(CurrentTime.getCurrentTime());
            fiDynamicReportStructMapper.updateByPrimaryKey(fiDynamicReportStruct);
        }
        fiDynamicReportStruct= fiDynamicReportStructMapper.selectByPrimaryKey(dynamicReport.getId());
        if(fiDynamicReportStruct==null){
            throw new Exception("保存失败");
        }
        Example example=new Example(FiDynamicReportColumn.class);
        example.createCriteria().andEqualTo("reportId",fiDynamicReportStruct.getId());
        List<FiDynamicReportColumn> columns=fiDynamicReportColumnMapper.selectByExample(example);
        FiDynamicReportColumn tmp;
        boolean exist;
        for(FiDynamicReportColumn fiDynamicReportColumn : dynamicReport.getFiDynamicReportColumnList()){
            if(fiDynamicReportColumn.getRow()<=fiDynamicReportStruct.getReportRow()&&fiDynamicReportColumn.getCol()<=fiDynamicReportStruct.getReportCol()){
                exist=false;
                for(int i=0;i<columns.size();i++){
                    tmp=columns.get(i);
                    if(tmp.getCol()==fiDynamicReportColumn.getCol()&&tmp.getRow()==fiDynamicReportColumn.getRow()){
                        exist=true;
                        break;
                    }
                }
                if(!exist){
                    if("str".equals(fiDynamicReportColumn.getType())){
                        if(fiDynamicReportColumn.getContent()==null){
//                            break;
                        }
                    }else  if("input".equals(fiDynamicReportColumn.getType())){
                        fiDynamicReportColumn.setContent(newColumnKey());
                    }else {
                        continue;
                    }
                    fiDynamicReportColumn.setReportId(fiDynamicReportStruct.getId());
                    fiDynamicReportColumn.setInsertTime(CurrentTime.getCurrentTime());
                    fiDynamicReportColumn.setUpdateTime(fiDynamicReportColumn.getInsertTime());
                    fiDynamicReportColumnMapper.insert(fiDynamicReportColumn);
                }
            }
        }
        return fiDynamicReportStruct;
    }


    /**
     * 获取新的字段
     *
     * @return
     */
    private String newColumnKey() throws Exception {
        Jedis jedis = jedisPool.getResource();
        long res = jedis.incr("dynamicReportColumnKey");
        jedis.close();
        if(res==0){
            throw new Exception("columnkey获取失败");
        }
        return "columnKey" + String.valueOf(res);
    }

    /**
     * 返回报表结构
     *
     * @param reportId
     * @return
     */
    public DynamicReport findReportStruct(int reportId) throws Exception {
        DynamicReport result = new DynamicReport();
        FiDynamicReportStruct fiDynamicReportStruct= fiDynamicReportStructMapper.selectByPrimaryKey(reportId);
        if(fiDynamicReportStruct==null){
            throw new Exception("未找到报表");
        }
        Example example=new Example(FiDynamicReportColumn.class);
        example.createCriteria().andEqualTo("reportId",reportId);
        List<FiDynamicReportColumn> list=fiDynamicReportColumnMapper.selectByExample(example);
        BeanUtil.copyBeanProperties(fiDynamicReportStruct,result);
        result.setFiDynamicReportColumnList(list);
        return result;
    }

    public List<FiDynamicReportStruct> reportStructList(){
        return fiDynamicReportStructMapper.selectAll();
    }





    public JSONArray findDynamicReportDataList(int reportId) {
        DBCollection dbCollection = mongoTemplate.getDb().getCollection("dynamic_report_" + String.valueOf(reportId));
        DBCursor record = dbCollection.find();
        JSONArray res = JSONArray.parseArray(JSON.toJSONString(record));
        return res;
    }



}
