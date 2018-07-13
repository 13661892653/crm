package com.xlh.crm.service.impl;

import com.xlh.crm.dto.EmbedDTO;
import com.xlh.crm.service.EmbedService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by ycp on 2017/3/28.
 */
@Service
public class EmbedServiceImpl implements EmbedService{

    private static final Logger LOGGER = LoggerFactory.getLogger("EMBED");


    @Override
    public void writeLog(EmbedDTO dto) {
        String line = getLogLine(dto);
        Lock lock = new ReentrantLock();
        lock.lock();
        try{
            LOGGER.info(line);
        }  finally {
            lock.unlock();
        }
    }

    private  String getLogLine(EmbedDTO dto){
        StringBuilder sb = new StringBuilder();
        sb.append("[" + dto.getDate() + "]").append(" ");
        sb.append("[" +dto.getPage() + "]").append(" ");
        sb.append(dto.getContentId()).append(" ");
        sb.append("[" + dto.getContent() + "]").append(" ");
        sb.append(dto.getMemberId()).append(" ");
        sb.append("[" + dto.getUserName() + "]").append(" ");

        return  sb.toString();
    }

}
