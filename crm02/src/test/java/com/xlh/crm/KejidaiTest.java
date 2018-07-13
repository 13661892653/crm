//package com.xlh.crm;
//
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONObject;
//import com.mongodb.BasicDBObject;
//import com.mongodb.DBCollection;
//import com.mongodb.DBObject;
//import com.xlh.crm.dto.dataformat.mysql.JxNormalBalanceTable;
//import com.xlh.crm.mapper.JxNormalBalanceMapper;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.data.mongodb.core.MongoTemplate;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.context.web.WebAppConfiguration;
//
//import java.lang.reflect.Field;
//import java.util.Date;
//import java.util.List;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = crmApplication.class)
//@WebAppConfiguration
//public class KejidaiTest {
//
//    @Autowired
//    private MongoTemplate mongoTemplate;
//    @Autowired
//    private JxNormalBalanceMapper jxNormalBalanceMapper;
//    @Test
//    public void insertMongo() throws IllegalAccessException, InstantiationException, ClassNotFoundException {
//        List<JxNormalBalanceTable> list=jxNormalBalanceMapper.selectAll();
//        for(JxNormalBalanceTable jxNormalBalanceTable :list){
//            JSONObject jsonObject=getNormalBalanceJSON(jxNormalBalanceTable);
//            insert(jsonObject);
//        }
//    }
//    public void insert(JSONObject data){
//        DBCollection dbCollection = mongoTemplate.getDb().getCollection("dynamic_report_test");
//        DBObject dbObject = (DBObject) com.mongodb.util.JSON.parse(JSON.toJSONString(data));
//        dbCollection.save(dbObject);
//    }
//    public JSONObject getNormalBalanceJSON(JxNormalBalanceTable jxNormalBalanceTable) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
//        JSONObject result=new JSONObject();
//        Class<?> clazz = null;
//        clazz = Class.forName("com.xlh.crm.dto.dataformat.mysql.JxNormalBalanceTable");
////        Object p1 = clazz.newInstance();
//        Field personNameField = null;
//        for(;clazz != Object.class;clazz= clazz.getSuperclass()){
//            try {
//                Field[] fieldArray = clazz.getDeclaredFields();
//                for(Field f : fieldArray){
//                    if (f.getType().getName().equals("java.lang.String")){
//                        f.setAccessible(true);
//                        result.put(f.getName(),f.get(jxNormalBalanceTable));
//                    }
//                }
//            } catch (Exception e) {
//                System.out.println(e.getMessage());
//            }
//        }
//        return result;
//    }
//}
