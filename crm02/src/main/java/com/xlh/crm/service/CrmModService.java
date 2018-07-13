package com.xlh.crm.service;

import com.xlh.crm.domain.EnterpriseTag;
import com.xlh.crm.domain.MemberBaseInfo;
import com.xlh.crm.domain.QxbCorpInfo;
import com.xlh.crm.dto.*;

import java.util.List;

/**
 * @author: ysl
 * @version: 0.1
 * @create time: 2017/03/16
 * @description:
 */
public interface CrmModService {
	MemberInfoDTO getMemberInfo(String userName);
	List<EnterpriseTag> queryEntTagFromDB();
	FavListRespDTO enterpriseFavList(PageReqDTO req);
	EntuptListRespDTO enterpriseUptList(PageReqDTO req);
	EnterpriseBankListRespDTO enterpriseBankList(PageReqDTO req);
	List<ProductShowDTO> productList(String company);
	List<MemberBaseInfo> companyUserList(String company);
	List<PartnerShowDTO> partnerList(String province,String company,String partnerType);
	PartnerBankListRespDTO partnerBankList(PageReqDTO req);
	int insertPartner(PartnerShowDTO form);
	EnterpriseBankListRespDTO enterpriseByFullName(PageReqDTO req);
	EnterpriseBankListRespDTO projectBankList(PageReqDTO req);
	EnterpriseBankListRespDTO invEventList(PageReqDTO req);
	OrderManageListRespDTO orderManageList(PageReqDTO req);
	OrderShowDTO orderSgl(String orderNo);
	EnterpriseBankListRespDTO getEntInitData(String name);
	int insertOrder(OrderShowDTO form);
	int updateOrder(OrderShowDTO form);
	ReachManageListRespDTO reachManageList(PageReqDTO req);
	ReachShowDTO reachSgl(String rchNo);
	String insertReach(ReachShowDTO form);
	int updateReach(ReachShowDTO form);
	ContractManageListRespDTO contractManageList(PageReqDTO req);
	ContractShowDTO contractSgl(String contractNo);
	int insertContract(ContractShowDTO form);
	int updateContract(ContractShowDTO form);
	ActManageListRespDTO actManageList(PageReqDTO req);
	int insertAct(ActShowDTO form);
	int uptCustManager(EnterpriseBaseInfoRespDTO form);
	int uptPassword(MemberInfoDTO form);
	UserListRespDTO getUserList(PageReqDTO req);
	MemberInfoDTO userSgl(String memberPhone);
	int updateUser(MemberInfoDTO form);
	int insertUser(MemberInfoDTO form);
	public QxbCorpInfo getEntInitDataApi(String name) throws Exception;
}
