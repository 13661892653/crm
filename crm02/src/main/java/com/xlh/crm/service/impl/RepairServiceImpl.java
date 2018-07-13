package com.xlh.crm.service.impl;

import com.alibaba.fastjson.JSON;
import com.xlh.crm.domain.QxbCorpInfo;
import com.xlh.crm.dto.mysql.CdmEntDtoCorpInfo;
import com.xlh.crm.mapper.CdmEntDtoCorpInfoMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;


@Service
public class RepairServiceImpl {
    private static Logger logger= LoggerFactory.getLogger(RepairServiceImpl.class);
    @Autowired
    private CdmEntDtoCorpInfoMapper cdmEntDtoCorpInfoMapper;

    public void repairRegCreditNo(QxbCorpInfo qxbCorpInfo){
        logger.info("start repaire qxbCorpInfo={}", JSON.toJSONString(qxbCorpInfo));
        Example example=new Example(CdmEntDtoCorpInfo.class);
        example.createCriteria().andEqualTo("enterpriseName",qxbCorpInfo.getName());
        List<CdmEntDtoCorpInfo> cdmEntDtoCorpInfoList=cdmEntDtoCorpInfoMapper.selectByExample(example);
        if(cdmEntDtoCorpInfoList.size()==1){
            if(!cdmEntDtoCorpInfoList.get(0).getRegCreditNo().equals(qxbCorpInfo.getRegNo()+qxbCorpInfo.getCreditNo())){
                logger.info("begin update qxbCorpInfo={}",JSON.toJSONString(qxbCorpInfo));
                String regNo=qxbCorpInfo.getRegNo();
                String creditNo=qxbCorpInfo.getCreditNo();
                String regCreditNo=regNo+creditNo;
                String regCredigNoOld=cdmEntDtoCorpInfoList.get(0).getRegCreditNo();
                cdmEntDtoCorpInfoMapper.updateRegCreditNoCdmEntDtoCorpInfo(regNo,creditNo,regCreditNo,regCredigNoOld);
                cdmEntDtoCorpInfoMapper.updateRegCreditNocdm_ent_dto_carrier(regNo,creditNo,regCreditNo,regCredigNoOld);
                cdmEntDtoCorpInfoMapper.updateRegCreditNocdm_ent_dto_contacts(regNo,creditNo,regCreditNo,regCredigNoOld);
                cdmEntDtoCorpInfoMapper.updateRegCreditNocdm_ent_dto_core_team(regNo,creditNo,regCreditNo,regCredigNoOld);
                cdmEntDtoCorpInfoMapper.updateRegCreditNocdm_ent_dto_corp_info_ext(regNo,creditNo,regCreditNo,regCredigNoOld);
                cdmEntDtoCorpInfoMapper.updateRegCreditNocdm_ent_dto_emp(regNo,creditNo,regCreditNo,regCredigNoOld);
                cdmEntDtoCorpInfoMapper.updateRegCreditNocdm_ent_dto_emp_struc(regNo,creditNo,regCreditNo,regCredigNoOld);
                cdmEntDtoCorpInfoMapper.updateRegCreditNocdm_ent_dto_finance_recent(regNo,creditNo,regCreditNo,regCredigNoOld);
                cdmEntDtoCorpInfoMapper.updateRegCreditNocdm_ent_dto_financing(regNo,creditNo,regCreditNo,regCredigNoOld);
                cdmEntDtoCorpInfoMapper.updateRegCreditNocdm_ent_dto_high_tech(regNo,creditNo,regCreditNo,regCredigNoOld);
                cdmEntDtoCorpInfoMapper.updateRegCreditNocdm_ent_dto_honor(regNo,creditNo,regCreditNo,regCredigNoOld);
                cdmEntDtoCorpInfoMapper.updateRegCreditNocdm_ent_dto_inv_info(regNo,creditNo,regCreditNo,regCredigNoOld);
                cdmEntDtoCorpInfoMapper.updateRegCreditNocdm_ent_dto_ipo(regNo,creditNo,regCreditNo,regCredigNoOld);
                cdmEntDtoCorpInfoMapper.updateRegCreditNocdm_ent_dto_market_dev(regNo,creditNo,regCreditNo,regCredigNoOld);
                cdmEntDtoCorpInfoMapper.updateRegCreditNocdm_ent_dto_market_follow(regNo,creditNo,regCreditNo,regCredigNoOld);
                cdmEntDtoCorpInfoMapper.updateRegCreditNocdm_ent_dto_partner(regNo,creditNo,regCreditNo,regCredigNoOld);
                cdmEntDtoCorpInfoMapper.updateRegCreditNocdm_ent_dto_project(regNo,creditNo,regCreditNo,regCredigNoOld);
                cdmEntDtoCorpInfoMapper.updateRegCreditNocrm_ent_favorite(regNo,creditNo,regCreditNo,regCredigNoOld);
                cdmEntDtoCorpInfoMapper.updateRegCreditNocrm_ent_init(regNo,creditNo,regCreditNo,regCredigNoOld);
                cdmEntDtoCorpInfoMapper.updateRegCreditNocrm_order(regNo,creditNo,regCreditNo,regCredigNoOld);
                cdmEntDtoCorpInfoMapper.updateRegCreditNocrm_reachcsr(regNo,creditNo,regCreditNo,regCredigNoOld);
                cdmEntDtoCorpInfoMapper.updateRegCreditNocrm_operation_log("reg_credit_no:"+regCreditNo,"reg_credit_no:"+regCredigNoOld);
            }
        }
        logger.info("end repaire ");
    }
}
