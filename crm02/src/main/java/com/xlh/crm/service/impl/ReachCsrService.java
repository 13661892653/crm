package com.xlh.crm.service.impl;

import com.xlh.crm.common.CurrentTime;
import com.xlh.crm.dto.OperationLogDTO;
import com.xlh.crm.dto.ReachShowDTO;
import com.xlh.crm.dto.UserInfoDTO;
import com.xlh.crm.dto.mysql.CrmReachcsr;
import com.xlh.crm.mapper.CrmMapper;
import com.xlh.crm.mapper.CrmReachcsrMapper;
import com.xlh.crm.mapper.ReachMapper;
import com.xlh.crm.utils.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class ReachCsrService {
    @Autowired
    private CrmReachcsrMapper crmReachcsrMapper;
    @Autowired
    private ReachMapper reachMapper;
    @Autowired
    private CrmMapper crmMapper;
    @Autowired
    private SessionServiceImpl sessionService;
    public CrmReachcsr findReachByRchNo(String rchNo){
        Example example= new Example(CrmReachcsr.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("rchNo",rchNo);
        List<CrmReachcsr> list=crmReachcsrMapper.selectByExample(example);
        if(list.size()>0){
            return list.get(0);
        }else{
            return new CrmReachcsr();
        }
    }
    public boolean checkUpdateId(CrmReachcsr crmReachcsr){
        ReachShowDTO condition=new ReachShowDTO();
        condition.setUpdateId(crmReachcsr.getUpdateId());
        List<ReachShowDTO> list=reachMapper.selectExistUpdateId(condition);
        if(list.size()>0){
            return false;
        }
        OperationLogDTO logDTO=crmMapper.selectLogById(condition.getUpdateId());
        if(logDTO==null){
            return false;
        }
        UserInfoDTO userInfoDTO=sessionService.getUser();
        if(!userInfoDTO.getInfo().getUserName().equals(logDTO.getOperator())){
            return false;
        }
        return true;
    }
    public CrmReachcsr saveReachcsr(CrmReachcsr crmReachcsr){
        crmReachcsr.setRegCreditNo(crmReachcsr.getRegNo()+crmReachcsr.getCreditNo());
        crmReachcsr.setUpdateTime(CurrentTime.getCurrentTime()); //设置更新时间
        if(crmReachcsr.getRchNo()==null||"".equals(crmReachcsr.getRchNo())){
            long curtimes = System.currentTimeMillis();//当前时间戳
            crmReachcsr.setRchNo(Long.toString(curtimes));
            crmReachcsr.setInsertTime(CurrentTime.getCurrentTime());
            crmReachcsrMapper.insert(crmReachcsr);
        }else{
            Example example=new Example(CrmReachcsr.class);
            example.createCriteria().andEqualTo("rchNo",crmReachcsr.getRchNo());
            List<CrmReachcsr> records=crmReachcsrMapper.selectByExample(example);
            if(records.size()!=1){
                return crmReachcsr;
            }
            CrmReachcsr record=records.get(0);
            crmReachcsr.setInsertTime(record.getInsertTime());
            crmReachcsrMapper.updateByExample(crmReachcsr,example);
        }
        return crmReachcsr;
    }
}
