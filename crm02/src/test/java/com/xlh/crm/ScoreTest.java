package com.xlh.crm;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xlh.crm.dto.score.TopicScore;
import com.xlh.crm.interceptor.dynamicReport.KejidaiSign;
import com.xlh.crm.service.impl.ScoreServiceImpl;
import org.apache.http.entity.StringEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = crmApplication.class)
//@WebAppConfiguration
public class ScoreTest {
    @Autowired
    private ScoreServiceImpl scoreService;
    @Test
    public void test(){
        TopicScore topicScore=scoreService.getScoreObj("330300000081307");
        int score=scoreService.getScore(topicScore);
        System.out.println(score);
    }

    @Test
    public void test2(){
        KejidaiSign kejidaiSign=new KejidaiSign();
        String aaa="{\"msg\":\"成功\",\"code\":\"200\",\"data\":{\"resp\":{\"date\":\"2018-02\",\"updateTime\":1519722984711,\"reqId\":3,\"insertTime\":1519722984711,\"columnKey58\":\" 森么\",\"columnKey59\":\" 森么\",\"columnKey65\":\" 森么\",\"columnKey66\":\" 森么\",\"columnKey63\":\" 森么\",\"columnKey64\":\" 森么\",\"columnKey61\":\" 森么\",\"_id\":\"5a9521e8502df811ac731bc2\",\"columnKey62\":\" 森么\",\"enterpriseName\":\"asd\",\"columnKey60\":\" 森么\"},\"req\":{\"fileName\":\"/uploadfile/techloan/smart/finance/1_1519468384.png\",\"year\":2016,\"type\":\"1\",\"enterpriseName\":\"上海以梦网络科技有限公司\",\"loanId\":\"5a913f488866989454ce662f\"}}}";
        JSONObject bbb= JSONObject.parseObject(aaa);
        JSONObject jsonObject=kejidaiSign.dealSgin(bbb);
        StringEntity s = new StringEntity(JSON.toJSONString(jsonObject),"UTF-8");
        System.out.println(s);
    }
}
