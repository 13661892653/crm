package com.xlh.crm.task;


import com.xlh.crm.service.impl.TaskServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class TaskCenter {
    public static final Logger logger = LogManager.getLogger(TaskCenter.class);
    @Autowired
    private TaskServiceImpl taskService;
    @Scheduled(fixedRate = 300*1000)
    public void calculatorScore() {
        logger.info("[定时任务] calculatorScore time = " + new Date());
        if(taskService.keepOneAppTaskRun("calculatorScore")){
            logger.info("[定时任务] calculatorScore 开始 = " + new Date());
            try{
                taskService.calculatorScore();
            }catch (Exception e){
                logger.info("exception={}",e.getMessage());
            }
        }
        logger.info("[定时任务] calculatorScore 结束 = " + new Date());
    }

//    @Scheduled(fixedRate = 24*3600*1000)
    public void addFinanceExcel() {
        logger.info("[定时任务] addFinanceExcel time = " + new Date());
        if(taskService.keepOneAppTaskRun("addFinanceExcel")){
            logger.info("[定时任务] addFinanceExcel 开始 = " + new Date());
            try{
                taskService.addJxFinanceExcel();
            }catch (Exception e){
                logger.info("exception={}",e.getMessage());
            }
        }
        logger.info("[定时任务] addFinanceExcel 结束 = " + new Date());
    }


    @Scheduled(fixedRate = 5*60*1000)
    public void financeTableSync() {
        logger.info("[定时任务] financeTableSync time = " + new Date());
        if(taskService.keepOneAppTaskRun("financeTableSync")){
            logger.info("[定时任务] financeTableSync 开始 = " + new Date());
            try{
                taskService.financeTableSync();
            }catch (Exception e){
                logger.info("exception={}",e.getMessage());
            }
        }
        logger.info("[定时任务] financeTableSync 结束 = " + new Date());
    }
}
