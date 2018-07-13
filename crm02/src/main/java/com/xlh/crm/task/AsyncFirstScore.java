package com.xlh.crm.task;

import com.alibaba.fastjson.JSON;
import com.xlh.crm.dto.EnterpriseBankListRespDTO;
import com.xlh.crm.dto.EnterpriseShowDTO;
import com.xlh.crm.dto.PageReqDTO;
import com.xlh.crm.service.CrmModService;
import com.xlh.crm.service.impl.ScoreServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@EnableAsync
public class AsyncFirstScore {
    private static Logger logger = LoggerFactory.getLogger(AsyncFirstScore.class);

    @Autowired
    CrmModService crmModService;
    @Autowired
    private ScoreServiceImpl scoreService;

    @Async()
    public void startUp(){
        logger.info("startUp start ");
        PageReqDTO req=new PageReqDTO();
        req.setPageIndex(1);
        req.setPageSize(100);
        EnterpriseBankListRespDTO result;
        List<String> stringList;
        while(true){
            stringList=new ArrayList<>();
            result = crmModService.enterpriseBankList(req);
            if(result.getEntListContents().size()==0){
                break;
            }
            for(EnterpriseShowDTO dto:result.getEntListContents()){
                stringList.add(dto.getRegCreditNo());
            }
            logger.info("insertRedis stringList={}", JSON.toJSONString(stringList));
            scoreService.insertRedis(stringList);
            req.setPageIndex(req.getPageIndex()+1);
        }
        logger.info("startUp finish");

    }

}
