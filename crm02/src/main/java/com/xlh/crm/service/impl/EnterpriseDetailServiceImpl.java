package com.xlh.crm.service.impl;

import com.alibaba.fastjson.JSON;
import com.xlh.crm.common.CurrentTime;
import com.xlh.crm.data.OperationLogCode;
import com.xlh.crm.dto.*;
import com.xlh.crm.dto.mysql.*;
import com.xlh.crm.mapper.*;
import com.xlh.crm.service.EnterpriseDetailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/** 
* @author: ysl
* @email: 
* @version: 0.1
* @create time: 2017/06/16
* @description: 
*/
@Service
public class EnterpriseDetailServiceImpl implements EnterpriseDetailService {
	private static final Logger LOGGER = LoggerFactory.getLogger(EnterpriseDetailServiceImpl.class.getName());

	@Autowired
	private FiJxNormalBalanceTableMapper fiJxNormalBalanceTableMapper;

	@Autowired
	private FiJxNormalProfitTableMapper fiJxNormalProfitTableMapper;

	@Autowired
	private FiJxSmallBalanceTableMapper fiJxSmallBalanceTableMapper;

	@Autowired
	private FiJxSmallProfitTableMapper fiJxSmallProfitTableMapper;

	@Autowired
	private SessionServiceImpl sessionService;
    @Autowired
	EnterpriseDetailMapper enterpriseDetailMapper;

	@Autowired
	EnterpriseMapper enterpriseMapper;

	@Autowired
	CrmMapper crmMapper;
	private SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	//企业档案-基本信息
	@Override
	@Transactional
	public EnterpriseBaseInfoRespDTO enterpriseBaseInfoList(String regCreditNo) {
		EnterpriseBaseInfoRespDTO respDTO = enterpriseDetailMapper.getEnterpriseBaseInfoList(regCreditNo);
		return respDTO;
	}

	//企业档案-客户经理、收藏信息
	@Override
	@Transactional
	public EnterpriseShowDTO enterpriseFavorite(PageReqDTO req) {
		EnterpriseShowDTO respDTO = enterpriseDetailMapper.getEnterpriseFavorite(req);
		return respDTO;
	}

	//企业档案-主要人员
	@Override
	@Transactional
	public List<EnterpriseEmployeeRespDTO> enterpriseEmployeeList(String regCreditNo) {
		List<EnterpriseEmployeeRespDTO> respDTO = enterpriseDetailMapper.getEnterpriseEmployeeList(regCreditNo);
		return respDTO;
	}

	//企业档案-服务订单
	@Override
	@Transactional
	public List<OrderShowDTO> enterpriseOrderList(String regCreditNo) {
		List<OrderShowDTO> respDTO = enterpriseDetailMapper.getEnterpriseOrderList(regCreditNo);
		return respDTO;
	}

	//企业档案-触达信息
	@Override
	@Transactional
	public List<EnterpriseReachcsrRespDTO> enterpriseReachcsrList(String regCreditNo) {
		List<EnterpriseReachcsrRespDTO> respDTO = enterpriseDetailMapper.getEnterpriseReachcsrList(regCreditNo);
		return respDTO;
	}

	//企业档案-历史融资
	@Override
	@Transactional
	public List<EnterpriseFinancingRespDTO> enterpriseFinancingList(String regCreditNo) {
		List<EnterpriseFinancingRespDTO> respDTO = enterpriseDetailMapper.getEnterpriseFinancingList(regCreditNo);
		return respDTO;
	}

	//企业档案-股东信息
	@Override
	@Transactional
	public List<EnterprisePartnerRespDTO> enterprisePartnerList(String regCreditNo) {
		List<EnterprisePartnerRespDTO> respDTO = enterpriseDetailMapper.getEnterprisePartnerList(regCreditNo);
		return respDTO;
	}

	//企业档案-公司人员结构
	@Override
	@Transactional
	public EnterpriseEmpStrucRespDTO enterpriseEmpStrucList(String regCreditNo) {
		EnterpriseEmpStrucRespDTO respDTO = enterpriseDetailMapper.getEnterpriseEmpStrucList(regCreditNo);
		return respDTO;
	}

	//企业档案-核心团队
	@Override
	@Transactional
	public List<EnterpriseCoreTeamRespDTO> enterpriseCoreTeamList(String regCreditNo) {
		List<EnterpriseCoreTeamRespDTO> respDTO = enterpriseDetailMapper.getEnterpriseCoreTeamList(regCreditNo);
		return respDTO;
	}

	//企业档案-公司联系人
	@Override
	@Transactional
	public List<EnterpriseContactsRespDTO> enterpriseContactsList(String regCreditNo) {
		List<EnterpriseContactsRespDTO> respDTO = enterpriseDetailMapper.getEnterpriseContactsList(regCreditNo);
		return respDTO;
	}

	//企业档案-资质荣誉
	@Override
	@Transactional
	public List<EnterpriseHonorRespDTO> enterpriseHonorList(String regCreditNo) {
		List<EnterpriseHonorRespDTO> respDTO = enterpriseDetailMapper.getEnterpriseHonorList(regCreditNo);
		return respDTO;
	}

	//企业档案-市场发展情况
	@Override
	@Transactional
	public EnterpriseMarketDevRespDTO enterpriseMarketDevList(String regCreditNo) {
		EnterpriseMarketDevRespDTO respDTO = enterpriseDetailMapper.getEnterpriseMarketDevList(regCreditNo);
		return respDTO;
	}

	//企业档案-上市情况
	@Override
	@Transactional
	public EnterpriseIpoRespDTO enterpriseIpoList(String regCreditNo) {
		EnterpriseIpoRespDTO respDTO = enterpriseDetailMapper.getEnterpriseIpoList(regCreditNo);
		return respDTO;
	}

	//企业档案-归属载体
	@Override
	@Transactional
	public EnterpriseCarrierRespDTO enterpriseCarrierList(String regCreditNo) {
		EnterpriseCarrierRespDTO respDTO = enterpriseDetailMapper.getEnterpriseCarrierList(regCreditNo);
		return respDTO;
	}

	//企业档案-财务数据
	@Override
	@Transactional
	public List<EnterpriseFindataRespDTO> enterpriseFindataList(String regCreditNo) {
		List<EnterpriseFindataRespDTO> respDTO = enterpriseDetailMapper.getEnterpriseFindataList(regCreditNo);
		return respDTO;
	}

	//企业档案-项目数据
	@Override
	@Transactional
	public List<EnterpriseProjRespDTO> enterpriseProjList(String regCreditNo) {
		List<EnterpriseProjRespDTO> respDTO = enterpriseDetailMapper.getEnterpriseProjList(regCreditNo);
		return respDTO;
	}

	//添加收藏企业
	@Override
	@Transactional
	public Integer enterpriseAddFav(PageReqDTO reqDTO) {
		//获取添加企业的基础信息
		EnterpriseShowDTO enterpriseShowDTO = enterpriseMapper.selectByRegCreditNo(reqDTO);
		enterpriseShowDTO.setFavUserList(reqDTO.getUserName()); //收藏用户名
		enterpriseShowDTO.setFavUserId(reqDTO.getMemberId()); //收藏用户名
		enterpriseShowDTO.setUpdateTime(CurrentTime.getCurrentTime());//设置更新时间
		enterpriseShowDTO.setInsertTime(CurrentTime.getCurrentTime());//设置更新时间
		long curtimes = System.currentTimeMillis();//当前时间戳
		String favId = "V".concat(Long.toString(curtimes));
		enterpriseShowDTO.setFavId(favId);  //赋值收藏ID
		//入收藏夹表
		int flag = enterpriseDetailMapper.enterpriseAddFav(enterpriseShowDTO);
		return flag;
	}

	//取消收藏企业
	@Override
	@Transactional
	public Integer enterpriseCelFav(PageReqDTO reqDTO) {
		int flag = enterpriseDetailMapper.enterpriseCelFav(reqDTO);
		return flag;
	}

	//企业档案-公司人员结构（编辑）
	@Override
	@Transactional
	public Integer enterpriseEmpStrucUpdate(EnterpriseEmpStrucRespDTO empStrucRespDTO) {
		empStrucRespDTO.setUpdateTime(CurrentTime.getCurrentTime());//设置更新时间
		int flag = enterpriseDetailMapper.enterpriseEmpStrucUpdate(empStrucRespDTO);
		if(flag>=1) //记录操作日志
		{
			OperationLogDTO operationLogDTO = new OperationLogDTO(); //操作日志信息
			operationLogDTO.setOperator(sessionService.getUser().getUserName());  //操作人
			operationLogDTO.setOperationTime(CurrentTime.getCurrentTime()); //设置操作事件
			operationLogDTO.setEventType(OperationLogCode.OPERATION_EDIT); //设置操作事件
			operationLogDTO.setModule(OperationLogCode.MODULE_ENT_DETAIL_GSRYJG); //设置业务模块
			operationLogDTO.setOperationDesc("reg_credit_no:".concat(empStrucRespDTO.getRegCreditNo())); //设置操作内容
			int optFlag = crmMapper.insertOperationLog(operationLogDTO);  //记录日志
		}
		return flag;
	}

	//企业档案-公司介绍（编辑）
	@Override
	@Transactional
	public Integer enterpriseBaseInfoUpdate(EnterpriseBaseInfoRespDTO baseInfoRespDTO) {
		LOGGER.info("start={}", JSON.toJSONString(baseInfoRespDTO));
		baseInfoRespDTO.setUpdateTime(CurrentTime.getCurrentTime());//设置更新时间
		int flag = enterpriseDetailMapper.enterpriseBaseInfoUpdate(baseInfoRespDTO);
		LOGGER.info("baseInfoRespDTO={},flag={}", JSON.toJSONString(baseInfoRespDTO),flag);
		if(flag>=1) //记录操作日志
		{
			OperationLogDTO operationLogDTO = new OperationLogDTO(); //操作日志信息
			operationLogDTO.setOperator(sessionService.getUser().getUserName());  //操作人
			operationLogDTO.setOperationTime(CurrentTime.getCurrentTime()); //设置操作事件
			operationLogDTO.setEventType(OperationLogCode.OPERATION_EDIT); //设置操作事件
			operationLogDTO.setModule(OperationLogCode.MODULE_ENT_DETAIL_GSJS); //设置业务模块
			operationLogDTO.setOperationDesc("reg_credit_no:".concat(baseInfoRespDTO.getRegCreditNo())); //设置操作内容
			LOGGER.info("operationLogDTO={}", JSON.toJSONString(operationLogDTO));
			int optFlag = crmMapper.insertOperationLog(operationLogDTO);  //记录日志
		}
		return flag;
	}

	//企业档案-市场发展（编辑）
	@Override
	@Transactional
	public Integer enterpriseMarketDevUpdate(EnterpriseMarketDevRespDTO marketDevRespDTO) {
		marketDevRespDTO.setUpdateTime(CurrentTime.getCurrentTime());//设置更新时间
		int flag = enterpriseDetailMapper.enterpriseMarketDevUpdate(marketDevRespDTO);
        LOGGER.info("marketDevRespDTO={},flag={}", JSON.toJSONString(marketDevRespDTO),flag);
		if(flag>=1) //记录操作日志
		{
			OperationLogDTO operationLogDTO = new OperationLogDTO(); //操作日志信息
			operationLogDTO.setOperator(sessionService.getUser().getUserName());  //操作人
			operationLogDTO.setOperationTime(CurrentTime.getCurrentTime()); //设置操作事件
			operationLogDTO.setEventType(OperationLogCode.OPERATION_EDIT); //设置操作事件
			operationLogDTO.setModule(OperationLogCode.MODULE_ENT_DETAIL_SCFZ); //设置业务模块
			operationLogDTO.setOperationDesc("reg_credit_no:".concat(marketDevRespDTO.getRegCreditNo())); //设置操作内容
            LOGGER.info("operationLogDTO={}", JSON.toJSONString(operationLogDTO));
			int optFlag = crmMapper.insertOperationLog(operationLogDTO);  //记录日志
		}
		return flag;
	}

	//企业档案-上市情况（编辑）
	@Override
	@Transactional
	public Integer enterpriseIpoUpdate(EnterpriseIpoRespDTO ipoRespDTO) {
		ipoRespDTO.setUpdateTime(CurrentTime.getCurrentTime());//设置更新时间
		int flag = enterpriseDetailMapper.enterpriseIpoUpdate(ipoRespDTO);
        LOGGER.info("ipoRespDTO={},flag={}", JSON.toJSONString(ipoRespDTO),flag);
		if(flag>=1) //记录操作日志
		{
			OperationLogDTO operationLogDTO = new OperationLogDTO(); //操作日志信息
			operationLogDTO.setOperator(sessionService.getUser().getUserName());  //操作人
			operationLogDTO.setOperationTime(CurrentTime.getCurrentTime()); //设置操作事件
			operationLogDTO.setEventType(OperationLogCode.OPERATION_EDIT); //设置操作事件
			operationLogDTO.setModule(OperationLogCode.MODULE_ENT_DETAIL_SSQK); //设置业务模块
			operationLogDTO.setOperationDesc("reg_credit_no:".concat(ipoRespDTO.getRegCreditNo())); //设置操作内容
            LOGGER.info("operationLogDTO={}", JSON.toJSONString(operationLogDTO));
			int optFlag = crmMapper.insertOperationLog(operationLogDTO);  //记录日志
		}
		return flag;
	}

	//企业档案-归属载体（编辑）
	@Override
	@Transactional
	public Integer enterpriseCarrierUpdate(EnterpriseCarrierRespDTO carrierRespDTO) {
		carrierRespDTO.setUpdateTime(CurrentTime.getCurrentTime());//设置更新时间
		//如果载体名称是空，把载体类型也置为空
		if(carrierRespDTO.getCarrierName()==null||carrierRespDTO.getCarrierName().equals(""))
		{
			carrierRespDTO.setCarrierType(null);
			carrierRespDTO.setCarrierName(null);
		}
		int flag = enterpriseDetailMapper.enterpriseCarrierUpdate(carrierRespDTO);
        LOGGER.info("carrierRespDTO={},flag={}", JSON.toJSONString(carrierRespDTO),flag);
		if(flag>=1) //记录操作日志
		{
			OperationLogDTO operationLogDTO = new OperationLogDTO(); //操作日志信息
			operationLogDTO.setOperator(sessionService.getUser().getUserName());  //操作人
			operationLogDTO.setOperationTime(CurrentTime.getCurrentTime()); //设置操作事件
			operationLogDTO.setEventType(OperationLogCode.OPERATION_EDIT); //设置操作事件
			operationLogDTO.setModule(OperationLogCode.MODULE_ENT_DETAIL_GSZT); //设置业务模块
			operationLogDTO.setOperationDesc("reg_credit_no:".concat(carrierRespDTO.getRegCreditNo())); //设置操作内容
            LOGGER.info("operationLogDTO={}", JSON.toJSONString(operationLogDTO));
			int optFlag = crmMapper.insertOperationLog(operationLogDTO);  //记录日志
		}
		return flag;
	}

	//企业档案-核心团队（新增）
	@Override
	@Transactional
	public Integer enterpriseCoreTeamInsert(EnterpriseCoreTeamRespDTO coreTeamRespDTO) {
		coreTeamRespDTO.setUpdateTime(CurrentTime.getCurrentTime());//设置更新时间
		int flag = enterpriseDetailMapper.enterpriseCoreTeamInsert(coreTeamRespDTO);
        LOGGER.info("coreTeamRespDTO={},flag={}", JSON.toJSONString(coreTeamRespDTO),flag);
		if(flag>=1) //记录操作日志
		{
			OperationLogDTO operationLogDTO = new OperationLogDTO(); //操作日志信息
			operationLogDTO.setOperator(sessionService.getUser().getUserName());  //操作人
			operationLogDTO.setOperationTime(CurrentTime.getCurrentTime()); //设置操作事件
			operationLogDTO.setEventType(OperationLogCode.OPERATION_INSERT); //设置操作事件
			operationLogDTO.setModule(OperationLogCode.MODULE_ENT_DETAIL_HXTD); //设置业务模块
			operationLogDTO.setOperationDesc("reg_credit_no:".concat(coreTeamRespDTO.getRegCreditNo())); //设置操作内容
            LOGGER.info("operationLogDTO={}", JSON.toJSONString(operationLogDTO));
			int optFlag = crmMapper.insertOperationLog(operationLogDTO);  //记录日志
		}
		return flag;
	}

	//企业档案-核心团队（删除）
	@Override
	@Transactional
	public Integer enterpriseCoreTeamDelete(EnterpriseCoreTeamRespDTO coreTeamRespDTO) {
		int flag = enterpriseDetailMapper.enterpriseCoreTeamDelete(coreTeamRespDTO);
        LOGGER.info("coreTeamRespDTO={},flag={}", JSON.toJSONString(coreTeamRespDTO),flag);
		if(flag>=1) //记录操作日志
		{
			OperationLogDTO operationLogDTO = new OperationLogDTO(); //操作日志信息
			operationLogDTO.setOperator(sessionService.getUser().getUserName());  //操作人
			operationLogDTO.setOperationTime(CurrentTime.getCurrentTime()); //设置操作事件
			operationLogDTO.setEventType(OperationLogCode.OPERATION_DELETE); //设置操作事件
			operationLogDTO.setModule(OperationLogCode.MODULE_ENT_DETAIL_HXTD); //设置业务模块
			operationLogDTO.setOperationDesc("reg_credit_no:".concat(coreTeamRespDTO.getRegCreditNo())); //设置操作内容
            LOGGER.info("operationLogDTO={}", JSON.toJSONString(operationLogDTO));
			int optFlag = crmMapper.insertOperationLog(operationLogDTO);  //记录日志
		}
		return flag;
	}

	//企业档案-公司联系人（新增）
	@Override
	@Transactional
	public Integer enterpriseContactsInsert(EnterpriseContactsRespDTO contactsRespDTO) {
		contactsRespDTO.setUpdateTime(CurrentTime.getCurrentTime());//设置更新时间
		int flag = enterpriseDetailMapper.enterpriseContactsInsert(contactsRespDTO);
        LOGGER.info("contactsRespDTO={},flag={}", JSON.toJSONString(contactsRespDTO),flag);
		if(flag>=1) //记录操作日志
		{
			OperationLogDTO operationLogDTO = new OperationLogDTO(); //操作日志信息
			operationLogDTO.setOperator(sessionService.getUser().getUserName());  //操作人
			operationLogDTO.setOperationTime(CurrentTime.getCurrentTime()); //设置操作事件
			operationLogDTO.setEventType(OperationLogCode.OPERATION_INSERT); //设置操作事件
			operationLogDTO.setModule(OperationLogCode.MODULE_ENT_DETAIL_GSLXR); //设置业务模块
			operationLogDTO.setOperationDesc("reg_credit_no:".concat(contactsRespDTO.getRegCreditNo())); //设置操作内容
            LOGGER.info("operationLogDTO={}", JSON.toJSONString(operationLogDTO));
			int optFlag = crmMapper.insertOperationLog(operationLogDTO);  //记录日志
		}
		return flag;
	}

	//企业档案-公司联系人（删除）
	@Override
	@Transactional
	public Integer enterpriseContactsDelete(EnterpriseContactsRespDTO contactsRespDTO) {
		int flag = enterpriseDetailMapper.enterpriseContactsDelete(contactsRespDTO);
		if(flag>=1) //记录操作日志
		{
			OperationLogDTO operationLogDTO = new OperationLogDTO(); //操作日志信息
			operationLogDTO.setOperator(sessionService.getUser().getUserName());  //操作人
			operationLogDTO.setOperationTime(CurrentTime.getCurrentTime()); //设置操作事件
			operationLogDTO.setEventType(OperationLogCode.OPERATION_DELETE); //设置操作事件
			operationLogDTO.setModule(OperationLogCode.MODULE_ENT_DETAIL_GSLXR); //设置业务模块
			operationLogDTO.setOperationDesc("reg_credit_no:".concat(contactsRespDTO.getRegCreditNo())); //设置操作内容
			int optFlag = crmMapper.insertOperationLog(operationLogDTO);  //记录日志
		}
		return flag;
	}

	//企业档案-资质荣誉（新增）
	@Override
	@Transactional
	public Integer enterpriseHonorInsert(EnterpriseHonorRespDTO honorRespDTO) {
		honorRespDTO.setUpdateTime(CurrentTime.getCurrentTime());//设置更新时间
		int flag = enterpriseDetailMapper.enterpriseHonorInsert(honorRespDTO);
        LOGGER.info("honorRespDTO={},flag={}", JSON.toJSONString(honorRespDTO),flag);
		if(flag>=1) //记录操作日志
		{
			OperationLogDTO operationLogDTO = new OperationLogDTO(); //操作日志信息
			operationLogDTO.setOperator(sessionService.getUser().getUserName());  //操作人
			operationLogDTO.setOperationTime(CurrentTime.getCurrentTime()); //设置操作事件
			operationLogDTO.setEventType(OperationLogCode.OPERATION_INSERT); //设置操作事件
			operationLogDTO.setModule(OperationLogCode.MODULE_ENT_DETAIL_ZZRY); //设置业务模块
			operationLogDTO.setOperationDesc("reg_credit_no:".concat(honorRespDTO.getRegCreditNo())); //设置操作内容
            LOGGER.info("operationLogDTO={}", JSON.toJSONString(operationLogDTO));
			int optFlag = crmMapper.insertOperationLog(operationLogDTO);  //记录日志
		}
		return flag;
	}

	//企业档案-资质荣誉（删除）
	@Override
	@Transactional
	public Integer enterpriseHonorDelete(EnterpriseHonorRespDTO honorRespDTO) {
		int flag = enterpriseDetailMapper.enterpriseHonorDelete(honorRespDTO);
		if(flag>=1) //记录操作日志
		{
			OperationLogDTO operationLogDTO = new OperationLogDTO(); //操作日志信息
			operationLogDTO.setOperator(sessionService.getUser().getUserName());  //操作人
			operationLogDTO.setOperationTime(CurrentTime.getCurrentTime()); //设置操作事件
			operationLogDTO.setEventType(OperationLogCode.OPERATION_DELETE); //设置操作事件
			operationLogDTO.setModule(OperationLogCode.MODULE_ENT_DETAIL_ZZRY); //设置业务模块
			operationLogDTO.setOperationDesc("reg_credit_no:".concat(honorRespDTO.getRegCreditNo())); //设置操作内容
			int optFlag = crmMapper.insertOperationLog(operationLogDTO);  //记录日志
		}
		return flag;
	}

	//企业档案-财务数据（新增）
	@Override
	@Transactional
	public Integer enterpriseFindataInsert(EnterpriseFindataRespDTO findataRespDTO) {
		findataRespDTO.setUpdateTime(CurrentTime.getCurrentTime());//设置更新时间
		int flag = enterpriseDetailMapper.enterpriseFindataInsert(findataRespDTO);
        LOGGER.info("findataRespDTO={},flag={}", JSON.toJSONString(findataRespDTO),flag);
		if(flag>=1) //记录操作日志
		{
			OperationLogDTO operationLogDTO = new OperationLogDTO(); //操作日志信息
			operationLogDTO.setOperator(sessionService.getUser().getUserName());  //操作人
			operationLogDTO.setOperationTime(CurrentTime.getCurrentTime()); //设置操作事件
			operationLogDTO.setEventType(OperationLogCode.OPERATION_INSERT); //设置操作事件
			operationLogDTO.setModule(OperationLogCode.MODULE_ENT_DETAIL_FINDATA); //设置业务模块
			operationLogDTO.setOperationDesc("reg_credit_no:".concat(findataRespDTO.getRegCreditNo())); //设置操作内容
            LOGGER.info("operationLogDTO={}", JSON.toJSONString(operationLogDTO));
			int optFlag = crmMapper.insertOperationLog(operationLogDTO);  //记录日志
		}
		return flag;
	}

	//企业档案-财务数据（删除）
	@Override
	@Transactional
	public Integer enterpriseFindataDelete(EnterpriseFindataRespDTO findataRespDTO) {
		int flag = enterpriseDetailMapper.enterpriseFindataDelete(findataRespDTO);
		if(flag>=1) //记录操作日志
		{
			OperationLogDTO operationLogDTO = new OperationLogDTO(); //操作日志信息
			operationLogDTO.setOperator(sessionService.getUser().getUserName());  //操作人
			operationLogDTO.setOperationTime(CurrentTime.getCurrentTime()); //设置操作事件
			operationLogDTO.setEventType(OperationLogCode.OPERATION_DELETE); //设置操作事件
			operationLogDTO.setModule(OperationLogCode.MODULE_ENT_DETAIL_FINDATA); //设置业务模块
			operationLogDTO.setOperationDesc("reg_credit_no:".concat(findataRespDTO.getRegCreditNo())); //设置操作内容
			int optFlag = crmMapper.insertOperationLog(operationLogDTO);  //记录日志
		}
		return flag;
	}


	public CdmEntDtoHighTech selectOneHighTech(String regCreditNo){
		CdmEntDtoHighTech record=new CdmEntDtoHighTech();
		record.setReg_credit_no(regCreditNo);
		record= enterpriseDetailMapper.enterpriseSelectHighTech(record);
		if(record==null){
			record=new CdmEntDtoHighTech();
		}
		return record;
	}
	/**
	 * 核心高新企业插入更新
	 * @param cdmEntDtoHighTech
	 * @return
	 */
	public int updateHighTech(CdmEntDtoHighTech cdmEntDtoHighTech){
		int flag;
		OperationLogDTO operationLogDTO = new OperationLogDTO(); //操作日志信息
		CdmEntDtoHighTech record=enterpriseDetailMapper.enterpriseSelectHighTech(cdmEntDtoHighTech);
		cdmEntDtoHighTech.setInsert_time(simpleDateFormat.format(new Date()));
		cdmEntDtoHighTech.setUpdate_time(simpleDateFormat.format(new Date()));
		if(record==null){
			flag =enterpriseDetailMapper.enterpriseInsertHighTech(cdmEntDtoHighTech);
            LOGGER.info("cdmEntDtoHighTech={},flag={}", JSON.toJSONString(cdmEntDtoHighTech),flag);
			operationLogDTO.setEventType(OperationLogCode.OPERATION_INSERT); //设置操作事件
		}else{
			flag =enterpriseDetailMapper.enterpriseUpdateHighTech(cdmEntDtoHighTech);
            LOGGER.info("cdmEntDtoHighTech={},flag={}", JSON.toJSONString(cdmEntDtoHighTech),flag);
			operationLogDTO.setEventType(OperationLogCode.OPERATION_UPDATE); //设置操作事件
		}
		if(flag>=1) //记录操作日志
		{
			operationLogDTO.setOperator(sessionService.getUser().getUserName());  //操作人
			operationLogDTO.setOperationTime(CurrentTime.getCurrentTime()); //设置操作事件
			operationLogDTO.setModule(OperationLogCode.MODULE_ENT_DETAIL_HIGH_TECH); //设置业务模块
			operationLogDTO.setOperationDesc("reg_credit_no:".concat(cdmEntDtoHighTech.getReg_credit_no())); //设置操作内容
            LOGGER.info("operationLogDTO={}", JSON.toJSONString(operationLogDTO));
			int optFlag = crmMapper.insertOperationLog(operationLogDTO);  //记录日志
		}
		return flag;
	}

	/**
	 * 企业财务报表
	 * @param regCreditNo
	 * @return
	 */
	public List<EnterpriseFinanceTableShowDto> selectFinanceTableInfo(String regCreditNo){
		List<EnterpriseFinanceTableShowDto> result=new ArrayList<>();

		Example example = new Example(FiJxSmallProfitTable.class);
		example.createCriteria().andEqualTo("regCreditNo",regCreditNo);
		List<FiJxSmallProfitTable> fiJxSmallProfitTables = fiJxSmallProfitTableMapper.selectByExample(example);
		for(int i=0;i<fiJxSmallProfitTables.size();i++){
			EnterpriseFinanceTableShowDto tmp=new EnterpriseFinanceTableShowDto();
			BeanUtils.copyProperties(fiJxSmallProfitTables.get(i), tmp);
			tmp.setTableName("Profit");
			tmp.setTableStander("Jx"+tmp.getTableStander());
			result.add(tmp);
		}

		example = new Example(FiJxSmallBalanceTable.class);
		example.createCriteria().andEqualTo("regCreditNo",regCreditNo);
		List<FiJxSmallBalanceTable> fiJxSmallBalanceTables = fiJxSmallBalanceTableMapper.selectByExample(example);
		for(int i=0;i<fiJxSmallBalanceTables.size();i++){
			EnterpriseFinanceTableShowDto tmp=new EnterpriseFinanceTableShowDto();
			BeanUtils.copyProperties(fiJxSmallBalanceTables.get(i), tmp);
			tmp.setTableName("Balance");
			tmp.setTableStander("Jx"+tmp.getTableStander());
			result.add(tmp);
		}


		example = new Example(FiJxNormalProfitTable.class);
		example.createCriteria().andEqualTo("regCreditNo",regCreditNo);
		List<FiJxNormalProfitTable> fiJxNormalProfitTables = fiJxNormalProfitTableMapper.selectByExample(example);
		for(int i=0;i<fiJxNormalProfitTables.size();i++){
			EnterpriseFinanceTableShowDto tmp=new EnterpriseFinanceTableShowDto();
			BeanUtils.copyProperties(fiJxNormalProfitTables.get(i), tmp);
			tmp.setTableName("Profit");
			tmp.setTableStander("Jx"+tmp.getTableStander());
			result.add(tmp);
		}


		example = new Example(FiJxNormalBalanceTable.class);
		example.createCriteria().andEqualTo("regCreditNo",regCreditNo);
		List<FiJxNormalBalanceTable> fiJxNormalBalanceTables = fiJxNormalBalanceTableMapper.selectByExample(example);
		for(int i=0;i<fiJxNormalBalanceTables.size();i++){
			EnterpriseFinanceTableShowDto tmp=new EnterpriseFinanceTableShowDto();
			BeanUtils.copyProperties(fiJxNormalBalanceTables.get(i), tmp);
			tmp.setTableName("Balance");
			tmp.setTableStander("Jx"+tmp.getTableStander());
			result.add(tmp);
		}
		return result;
	}
}
