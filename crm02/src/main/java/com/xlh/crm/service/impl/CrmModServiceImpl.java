package com.xlh.crm.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.xlh.crm.common.CurrentTime;
import com.xlh.crm.data.*;
import com.xlh.crm.domain.*;
import com.xlh.crm.dto.*;
import com.xlh.crm.dto.EntuptListRespDTO;
import com.xlh.crm.dto.mysql.CrmEntFavoriteDTO;
import com.xlh.crm.enums.GBusinessEnum;
import com.xlh.crm.mapper.*;
import com.xlh.crm.service.CrmModService;

import com.xlh.crm.utils.HttpClientManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author: Jesse
 * @email:
 * @version: 0.1
 * @create time: 2017/03/16
 * @description:
 */
@Service
public class CrmModServiceImpl implements CrmModService {
	private static final Logger LOGGER = LoggerFactory.getLogger(CrmModServiceImpl.class.getName());
	private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	@Autowired
	private SessionServiceImpl sessionService;
	@Autowired
	EnterpriseMapper enterpriseMapper;

	@Autowired
	EnterpriseDetailMapper enterpriseDetailMapper;

	@Autowired
	OrderMapper orderMapper;

	@Autowired
	ReachMapper reachMapper;

	@Autowired
	PartnerMapper partnerMapper;

	@Autowired
	ContractMapper contractMapper;

	@Autowired
	ActMapper actMapper;

	@Autowired
	CrmMapper crmMapper;

	@Autowired
	QxbCorpInfoMapper qxbCorpInfoMapper;
	@Autowired
	QxbAbnormalItemMapper qxbAbnormalItemMapper;
	@Autowired
	QxbEmployeeMapper qxbEmployeeMapper;
	@Autowired
	QxbBranchMapper qxbBranchMapper;
	@Autowired
	QxbChangerecordMapper qxbChangerecordMapper;
	@Autowired
	QxbPartnerMapper qxbPartnerMapper;
	@Autowired
	QxbPartnerRealCapiMapper qxbPartnerRealCapiMapper;
	@Autowired
	QxbPartnerShouldCapiMapper qxbPartnerShouldCapiMapper;
	@Autowired
	QxbWebsiteMapper qxbWebsiteMapper;
	@Autowired
	private RepairServiceImpl repairService;

	//获取登录用户信息
	@Override
	public UserListRespDTO getUserList(PageReqDTO req) {
		UserListRespDTO respDTO = new UserListRespDTO();
		respDTO.setReqParams(req);

		List<MemberInfoDTO> dtos = crmMapper.getUserList(req);
		respDTO.setUserListContents(dtos);

		return respDTO;
	}

	//单个用户信息查询
	@Override
	@Transactional
	public MemberInfoDTO userSgl(String memberPhone) {
		MemberInfoDTO dtos = crmMapper.getUserInfo(memberPhone);
		return dtos;
	}

	//新增用户
	@Override
	public int insertUser(MemberInfoDTO form) {
		form.setMemberId(Integer.parseInt(form.getMemberPhone().trim().substring(1,10)));  //把手机号后10位设置为用户ID
		int insertFlag = 0;
		form.setAuditStatus(1);//新增用户都设置为审核通过的用户
		//根据用户类型设置账户角色描述
		if(form.getMemberType().equals("1")){
			form.setAccountRole("管理员");
		}
		else if(form.getMemberType().equals("2")){
			form.setAccountRole("高级用户（总部）");
		}
		else if(form.getMemberType().equals("10")){
			form.setAccountRole("一般用户（总部）");
		}
		else if(form.getMemberType().equals("90")){
			form.setAccountRole("分公司经理");
		}
		else if(form.getMemberType().equals("98")){
			form.setAccountRole("分公司企服顾问");
		}
		else if(form.getMemberType().equals("99")){
			form.setAccountRole("分公司运营经理");
		}
		insertFlag = crmMapper.insertUser(form);
		return insertFlag;
	}

	//修改用户信息
	@Override
	public int updateUser(MemberInfoDTO form) {
		form.setUpdateTime(CurrentTime.getCurrentTime());//设置更新时间
		//根据用户类型设置账户角色描述
		if(form.getMemberType().equals("1")){
			form.setAccountRole("管理员");
		}
		else if(form.getMemberType().equals("2")){
			form.setAccountRole("高级用户（总部）");
		}
		else if(form.getMemberType().equals("10")){
			form.setAccountRole("一般用户（总部）");
		}
		else if(form.getMemberType().equals("90")){
			form.setAccountRole("分公司经理");
		}
		else if(form.getMemberType().equals("98")){
			form.setAccountRole("分公司企服顾问");
		}
		else if(form.getMemberType().equals("99")){
			form.setAccountRole("分公司运营经理");
		}
		int updateFlag = 0;
		updateFlag = crmMapper.updateUser(form);
		return updateFlag;
	}

	//重置密码
	@Override
	public int uptPassword(MemberInfoDTO form) {
		int updateFlag = 0;
		updateFlag = crmMapper.uptPassword(form);
		return updateFlag;
	}

	//获取登录用户信息
	@Override
	public MemberInfoDTO getMemberInfo(String userName) {
		MemberInfoDTO memberInfoDTO = crmMapper.getMemberInfo(userName);
		return memberInfoDTO;
	}

	//获取企业标签
	@Override
	public List<EnterpriseTag> queryEntTagFromDB() {
		List<EnterpriseTag> entTagList = null;
		entTagList = enterpriseMapper.selectEntTag();  //获取企业标签列表
		return entTagList;
	}

	//企业收藏
	@Override
	@Transactional
	public FavListRespDTO enterpriseFavList(PageReqDTO req) {
		FavListRespDTO respDTO = new FavListRespDTO();
		respDTO.setReqParams(req);

		List<EnterpriseShowDTO> dtos = enterpriseMapper.getEnterpriseFavList(req);

		respDTO.setFavListContents(dtos);

		Integer totalCount = enterpriseMapper.getFavListCount(req);
		totalCount = totalCount == null ? 0 : totalCount;
		respDTO.setTotalPageCount((int)Math.ceil((double)totalCount / req.getPageSize()));
		respDTO.setTotalRecCount(totalCount);
		return respDTO;
	}

	//企业档案更新列表
	@Override
	@Transactional
	public EntuptListRespDTO enterpriseUptList(PageReqDTO req) {
		EntuptListRespDTO respDTO = new EntuptListRespDTO();
		respDTO.setReqParams(req);

		List<EnterpriseShowDTO> dtos = enterpriseMapper.getEnterpriseUptList(req);

		respDTO.setEntuptListContents(dtos);

		Integer totalCount = enterpriseMapper.getUptListCount(req);
		totalCount = totalCount == null ? 0 : totalCount;
		respDTO.setTotalPageCount((int)Math.ceil((double)totalCount / req.getPageSize()));
		respDTO.setTotalRecCount(totalCount);
		return respDTO;
	}

	//修改客户经理
	@Override
	@Transactional
	public int uptCustManager(EnterpriseBaseInfoRespDTO form) {
		String[] regCreditNos=form.getRegCreditNo().split(",");
		int uptFlag = 0;
		for(int i=0;i<regCreditNos.length;i++){
			form.setRegCreditNo(regCreditNos[i]);
			form.setCompany(sessionService.getUser().getCompany()); //设置登录人所在分公司
			form.setUpdateTime(CurrentTime.getCurrentTime());//设置更新时间
			form.setFavUserList(sessionService.getUser().getCompany());//设置分公司
			uptFlag= enterpriseMapper.uptCustManager(form);
			CrmEntFavoriteDTO crmEntFavoriteDTO=new CrmEntFavoriteDTO();
			crmEntFavoriteDTO.setRegCreditNo(form.getRegCreditNo());
			crmEntFavoriteDTO.setUpdateTime(CurrentTime.getCurrentTime());
			crmEntFavoriteDTO.setCustManager(form.getUserName());
			crmEntFavoriteDTO.setCustManagerId(form.getMemberId());
			if(crmEntFavoriteDTO.getCustManagerId()!=null){
				crmEntFavoriteDTO.setCustManagerUpdateTime(CurrentTime.getCurrentTime());
			}
			enterpriseDetailMapper.enterpriceCustUpdate(crmEntFavoriteDTO);
		}
		return uptFlag;
	}

	//企业数据库
	@Override
	@Transactional
	public EnterpriseBankListRespDTO enterpriseBankList(PageReqDTO req) {
		EnterpriseBankListRespDTO respDTO = new EnterpriseBankListRespDTO();
		respDTO.setReqParams(req);

		List<EnterpriseShowDTO> dtos = enterpriseMapper.getEnterpriseBankList(req);
		respDTO.setEntListContents(dtos);

		Integer totalCount = enterpriseMapper.getEnterpriseBankListCount(req);
		totalCount = totalCount == null ? 0 : totalCount;
		respDTO.setTotalPageCount((int)Math.ceil((double)totalCount / req.getPageSize()));
		respDTO.setTotalRecCount(totalCount);
		return respDTO;
	}

	//获取当前用户所在公司的所有用户
	@Override
	@Transactional
	public List<MemberBaseInfo> companyUserList(String company) {
		List<MemberBaseInfo> dtos = enterpriseMapper.getCompanyUserList(company);
		return dtos;
	}

	//获取适用当前用户所在区域的商品（本地+全国）
	@Override
	@Transactional
	public List<ProductShowDTO> productList(String company) {
		List<ProductShowDTO> dtos = enterpriseMapper.getProductList(company);
		return dtos;
	}

	//获取当前用户所在公司的所有服务商（本地+全国）
	@Override
	@Transactional
	public List<PartnerShowDTO> partnerList(String province,String company,String partnerType) {
		List<PartnerShowDTO> dtos = partnerMapper.getPartnerList(province,company,partnerType);
		return dtos;
	}

	//获取合作伙伴列表
	@Override
	@Transactional
	public PartnerBankListRespDTO partnerBankList(PageReqDTO req) {
		PartnerBankListRespDTO respDTO = new PartnerBankListRespDTO();
		respDTO.setReqParams(req);

		List<PartnerShowDTO> dtos = partnerMapper.getPartnerBankList(req);
		respDTO.setPartnerListContents(dtos);

		Integer totalCount = partnerMapper.getPartnerBankListCount(req);
		totalCount = totalCount == null ? 0 : totalCount;
		respDTO.setTotalPageCount((int)Math.ceil((double)totalCount / req.getPageSize()));
		respDTO.setTotalRecCount(totalCount);
		return respDTO;
	}

    //根据企业全名查询
    @Override
    @Transactional
    public EnterpriseBankListRespDTO enterpriseByFullName(PageReqDTO req) {
		EnterpriseBankListRespDTO respDTO = new EnterpriseBankListRespDTO();
        respDTO.setReqParams(req); //请求参数

        EnterpriseShowDTO dtos = enterpriseMapper.selectByFullName(req.getCorpName());
        dtos.setEnterpriseName(req.getCorpName());
        respDTO.setEntSglContents(dtos); //返回企业信息

        return respDTO;
    }

	//订单查询
	@Override
	@Transactional
	public OrderManageListRespDTO orderManageList(PageReqDTO req) {
		OrderManageListRespDTO respDTO = new OrderManageListRespDTO();
		respDTO.setReqParams(req);

		List<OrderShowDTO> dtos = orderMapper.getOrderList(req);
		respDTO.setOrdListContents(dtos);

		Integer totalCount = orderMapper.getOrderListCount(req);
		totalCount = totalCount == null ? 0 : totalCount;
		respDTO.setTotalPageCount((int)Math.ceil((double)totalCount / req.getPageSize()));
		respDTO.setTotalRecCount(totalCount);
		return respDTO;
	}

	//单个订单查询
	@Override
	@Transactional
	public OrderShowDTO orderSgl(String orderNo) {
		OrderShowDTO dtos = orderMapper.getOrderByOrderNo(orderNo);
		return dtos;
	}

	//订单入库
	@Override
	@Transactional
	public int insertOrder(OrderShowDTO form) {

		String userName = sessionService.getUser().getUserName();  //获取用户名
		String company = sessionService.getUser().getCompany();  //获取用户名
		long curtimes = System.currentTimeMillis();//当前时间戳
		String orderNo = null;
		orderNo = Long.toString(curtimes);
		form.setOrderNo(orderNo);  //赋值订单号，时间戳作为订单号
		form.setOrderAmt(form.getOrderPrice()*form.getOrderNum()); //赋值订单总金额
		form.setRegCreditNo(form.getRegNo().concat(form.getCreditNo()));  //赋值工商注册号和社会统一信用代码的组合
		form.setOrderMemeberName(userName);  //赋值下单用户
		form.setCompany(company);  //赋值所属分公司
		form.setUpdateTime(CurrentTime.getCurrentTime());   //赋值数据更新时间
		if(form.getMerchandiser() != null) //如果有设置跟单人
		{
			form.setAssignMerchandiserDate(CurrentTime.getCurrentTime());   //赋值分配跟单时间
		}

		int insertFlag = 0;
		insertFlag= orderMapper.insertOrder(form);

		return insertFlag;
	}

	//修改订单
	@Override
	@Transactional
	public int updateOrder(OrderShowDTO form) {

		form.setRegCreditNo(form.getRegNo().concat(form.getCreditNo()));  //赋值工商注册号和社会统一信用代码的组合

		OrderShowDTO preorder = orderSgl(form.getOrderNo());//查询订单更新前的记录
		String preMrchandiser = preorder.getMerchandiser(); //更新前的跟单人
		String preAssignMerchandiserDate = preorder.getAssignMerchandiserDate(); //更新前的分配跟单时间
		if((form.getMerchandiser() != null)&&!form.getMerchandiser().equals(preMrchandiser)) //如果跟单人有修改
		{
			form.setAssignMerchandiserDate(CurrentTime.getCurrentTime());   //赋值跟单人修改时间
		}
		else{
			form.setAssignMerchandiserDate(preAssignMerchandiserDate);   //赋值跟单时间
		}

		form.setUpdateTime(CurrentTime.getCurrentTime());   //赋值数据更新时间

		int updateFlag = 2;
		updateFlag= orderMapper.updateOrder(form);

		return updateFlag;
	}

	//触达查询
	@Override
	@Transactional
	public ReachManageListRespDTO reachManageList(PageReqDTO req){

		ReachManageListRespDTO respDTO = new ReachManageListRespDTO();
		respDTO.setReqParams(req);

		List<ReachShowDTO> dtos = reachMapper.getReachList(req);
		for(int i=0;i<dtos.size();i++){
			dtos.get(i).setBizLv2Id(GBusinessEnum.getExplainByCode(dtos.get(i).getBizLv2Id()));
		}
		respDTO.setRchListContents(dtos);

		Integer totalCount = reachMapper.getReachListCount(req);
		totalCount = totalCount == null ? 0 : totalCount;
		respDTO.setTotalPageCount((int)Math.ceil((double)totalCount / req.getPageSize()));
		respDTO.setTotalRecCount(totalCount);
		return respDTO;
	}

	//单个触达信息查询
	@Override
	@Transactional
	public ReachShowDTO reachSgl(String rchNo) {
		ReachShowDTO dtos = reachMapper.getReachByRchNo(rchNo);
		return dtos;
	}

	//新增触达信息入库
	@Override
	@Transactional
	public String insertReach(ReachShowDTO form) {

		if("corpCust".equals(form.getCustType())){
			List<ReachShowDTO> list=reachMapper.selectExistUpdateId(form);
			if(list.size()>0){
				return form.getUpdateId()+" 此ID已经被使用过，新增失败";
			}
			OperationLogDTO logDTO=crmMapper.selectLogById(form.getUpdateId());
			if(logDTO==null){
				return "该Id不存在";
			}
			UserInfoDTO userInfoDTO=sessionService.getUser();
			if(!userInfoDTO.getInfo().getUserName().equals(logDTO.getOperator())){
				return "该ID 不属于你";
			}
		}

		long curtimes = System.currentTimeMillis();//当前时间戳

		String rchNo = null;
		rchNo = Long.toString(curtimes);
		form.setRchNo(rchNo);  //赋值触达信息号，时间戳作为触达信息号

		String userName = sessionService.getUser().getUserName();  //获取用户名
		String company = sessionService.getUser().getCompany();  //获取分公司
		form.setRegCreditNo(form.getRegNo().concat(form.getCreditNo()));  //赋值工商注册号和社会统一信用代码的组合
		form.setRchEmp(userName);  //赋值触达人
		form.setCompany(company);  //赋值所属分公司
		form.setUpdateTime(CurrentTime.getCurrentTime()); //设置更新时间
		form.setInsertTime(CurrentTime.getCurrentTime());

		int insertFlag = 0;
		insertFlag= reachMapper.insertReach(form);
		if(insertFlag==1){
			return "新增成功";
		}else{
			return "新增失败";
		}
	}

	//修改触达信息入库
	@Override
	@Transactional
	public int updateReach(ReachShowDTO form) {

		form.setUpdateTime(CurrentTime.getCurrentTime()); //设置更新时间

		int updateFlag = 0;
		updateFlag= reachMapper.updateReach(form);
		return updateFlag;
	}

	//单个合同查询
	@Override
	@Transactional
	public ContractShowDTO contractSgl(String contractNo) {
		ContractShowDTO dtos = contractMapper.getContractByContractNo(contractNo);
		return dtos;
	}

	//合同查询列表
	@Override
	@Transactional
	public ContractManageListRespDTO contractManageList(PageReqDTO req) {

		ContractManageListRespDTO respDTO = new ContractManageListRespDTO();
		respDTO.setReqParams(req);

		List<ContractShowDTO> dtos = contractMapper.getContractList(req);
		respDTO.setContractListContents(dtos);

		Integer totalCount = contractMapper.getContractListCount(req);
		totalCount = totalCount == null ? 0 : totalCount;
		respDTO.setTotalPageCount((int)Math.ceil((double)totalCount / req.getPageSize()));
		respDTO.setTotalRecCount(totalCount);
		return respDTO;
	}

	//新增合同信息入库
	@Override
	@Transactional
	public int insertContract(ContractShowDTO form) {

		String userName = sessionService.getUser().getUserName();  //获取用户名
		String company = sessionService.getUser().getCompany();  //获取分公司

		long curtimes = System.currentTimeMillis();//当前时间戳

		String contractNo = null;
		String curtimesStr = Long.toString(curtimes);
		contractNo = "HT".concat(curtimesStr.substring(curtimesStr.length() - 6, curtimesStr.length()));

		//设置业务版块
		if(form.getBizLv1Id().equals("G"))
		{
			form.setBizLv1Name("G");
		}
		else if(form.getBizLv1Id().equals("T"))
		{
			form.setBizLv1Name("T");
		}
		else if(form.getBizLv1Id().equals("F"))
		{
			form.setBizLv1Name("F");
		}

		form.setIncomeUnit("万人民币");
		form.setProfitUnit("万人民币");
		form.setContractNo(contractNo);  //赋值合同编号
		form.setOperator(userName);  //赋值操作人
		form.setCompany(company);  //赋值所属分公司
		form.setUpdateTime(CurrentTime.getCurrentTime()); //设置更新时间

		int insertFlag = 0;

		//如果是订单合同，先校验订单号
		if(form.getContractType().equals("CONT01")&&form.getOrderNo().length()>=0){
			OrderShowDTO orderShowDTO = orderMapper.selectByOrderNo(form.getOrderNo());
			if(orderShowDTO.getRecCnt()>0)  //如果订单号存在，执行插入合同信息
			{
				form.setOrderProdId(orderShowDTO.getOrderProdId());   //如果订单号存在，赋值给合同里订单对应的产品ID
				form.setOrderProdName(orderShowDTO.getOrderProdName()); //如果订单号存在，赋值给合同里订单对应的产品名称
				form.setOrderProdName(orderShowDTO.getOrderProdName()); //如果订单号存在，赋值给合同里订单对应的产品名称
				form.setPartnerId(orderShowDTO.getPartnerId()); //如果订单号存在，赋值给合同里订单对应的合作伙伴ID
				form.setPartnerName(orderShowDTO.getPartnerName()); //如果订单号存在，赋值给合同里订单对应的合作伙伴名称
				insertFlag= contractMapper.insertContract(form);
			}
			else
			{
				insertFlag = 0;
			}
		}
		else{
			insertFlag= contractMapper.insertContract(form);
		}

		return insertFlag;
	}

	//修改合同
	@Override
	@Transactional
	public int updateContract(ContractShowDTO form) {

		form.setUpdateTime(CurrentTime.getCurrentTime());   //赋值数据更新时间

		int updateFlag = 2;
		updateFlag= contractMapper.updateContract(form);

		return updateFlag;
	}

	//活动列表
	@Override
	@Transactional
	public ActManageListRespDTO actManageList(PageReqDTO req) {

		ActManageListRespDTO respDTO = new ActManageListRespDTO();
		respDTO.setReqParams(req);

		List<ActShowDTO> dtos = actMapper.getActList(req);
		respDTO.setActListContents(dtos);

		Integer totalCount = actMapper.getActListCount(req);
		totalCount = totalCount == null ? 0 : totalCount;
		respDTO.setTotalPageCount((int)Math.ceil((double)totalCount / req.getPageSize()));
		respDTO.setTotalRecCount(totalCount);
		return respDTO;
	}

	//新增活动入库
	@Override
	@Transactional
	public int insertAct(ActShowDTO form) {

		String userName = sessionService.getUser().getUserName();  //获取用户名
		String company = sessionService.getUser().getCompany();  //获取分公司名称
		long curtimes = System.currentTimeMillis();//当前时间戳

		String curtimestr = null;
		curtimestr = Long.toString(curtimes);
		String actNo = null;
		actNo = "A".concat(curtimestr.substring(curtimestr.length() - 6, curtimestr.length()));

		form.setActNo(actNo); //设置活动编号
		form.setOperator(userName); //设置活动操作人
		form.setCompany(company); //设置活动发起分公司
		form.setUpdateTime(simpleDateFormat.format(new Date()));
		int insertFlag = 0;

		insertFlag= actMapper.insertAct(form);

		return insertFlag;
	}

	//新增合作伙伴
	@Override
	@Transactional
	public int insertPartner(PartnerShowDTO form) {

		long curtimes = System.currentTimeMillis();//当前时间戳

		String curtimestr = null;
		curtimestr = Long.toString(curtimes);
		String partnerid = null;
		String partnerType = null;
		if(form.getPartnerType().equals("1")) //如果是平台服务商
		{
			partnerType = "F";
		}
		else
		{
			partnerType = "C";
		}
		partnerid = partnerType.concat(curtimestr.substring(curtimestr.length() - 6, curtimestr.length()));

		form.setPartnerId(partnerid); //设置合作伙伴编号

		//设置合作伙伴等级描述
		String partnerlvdesc = null;
		if(form.getPartnerLvId().equals("L1"))
		{
			partnerlvdesc = "一级合作伙伴";
		}
		else if (form.getPartnerLvId().equals("L2"))
		{
			partnerlvdesc = "二级合作伙伴";
		}
		else if (form.getPartnerLvId().equals("L3"))
		{
			partnerlvdesc = "三级合作伙伴";
		}
		form.setPartnerLvDesc(partnerlvdesc);
		form.setValidFlag("Y");
		form.setUpdateTime(CurrentTime.getCurrentTime()); //设置更新时间

		int insertFlag = 2;
		insertFlag= partnerMapper.insertPartner(form);
		return insertFlag;
	}

	//项目数据库
	@Override
	@Transactional
	public EnterpriseBankListRespDTO projectBankList(PageReqDTO req) {
		EnterpriseBankListRespDTO respDTO = new EnterpriseBankListRespDTO();
		respDTO.setReqParams(req);

		List<ProjectBankShowDTO> dtos = enterpriseMapper.getProjectBankList(req);
		respDTO.setPrjListContents(dtos);

		//Integer totalCorpCount = enterpriseMapper.countMemberMonitorCorps(req.getMemberId());
		//totalCorpCount = totalCorpCount == null ? 0 : totalCorpCount;
		//respDTO.setTotalCorpCount(totalCorpCount);

		//Integer totalCount = enterpriseMapper.getCorpMonitorListCount(req);
		//totalCount = totalCount == null ? 0 : totalCount;
		//respDTO.setTotalPageCount((int)Math.ceil((double)totalCount / req.getPageSize()));
		return respDTO;
	}

	//投融资事件数据库
	@Override
	@Transactional
	public EnterpriseBankListRespDTO invEventList(PageReqDTO req) {
		EnterpriseBankListRespDTO respDTO = new EnterpriseBankListRespDTO();
		respDTO.setReqParams(req);

		List<InvEventShowDTO> dtos = enterpriseMapper.getInvEventList(req);
		respDTO.setInvListContents(dtos);

		//Integer totalCorpCount = enterpriseMapper.countMemberMonitorCorps(req.getMemberId());
		//totalCorpCount = totalCorpCount == null ? 0 : totalCorpCount;
		//respDTO.setTotalCorpCount(totalCorpCount);

		Integer totalCount = enterpriseMapper.getInvEventListCount(req);
		totalCount = totalCount == null ? 0 : totalCount;
		respDTO.setTotalPageCount((int)Math.ceil((double)totalCount / req.getPageSize()));
		respDTO.setTotalRecCount(totalCount);
		return respDTO;
	}

	private String getNonNullStr(String src) {
		return null == src ? "":src;
	}

	//
	public EnterpriseBankListRespDTO getEntInitData(String name) {
        EnterpriseBankListRespDTO enterpriseBankListRespDTO = new EnterpriseBankListRespDTO();
        EnterpriseShowDTO enterpriseShowDTO = new EnterpriseShowDTO();
        PageReqDTO reqDTO = new PageReqDTO();
        reqDTO.setCorpName(name);
		//请求参数：企业名和appkey
		HttpClientManager.Param[] params1 = new HttpClientManager.Param[]{
				new HttpClientManager.Param("keyword", name)
				, new HttpClientManager.Param("appkey", QxbAppKey.CORP_INFO)
		};

		//根据企业全名或者注册号精确查询，只会返回一条数据
		QXBAPIResponseDTO responseDTO1 =
				QxbApiResponseDTOTransverter.toCorpMonitorResponse(QXBAPIRequestURL.GET_DETAIL_AND_CONTRACT_BY_NAME, params1);

		if (responseDTO1.getStatus() == 200) {
			JSONObject data = responseDTO1.getData();
			String qxbId = getNonNullStr(data.getString("reg_no")).concat(getNonNullStr(data.getString("credit_no"))); //拼接reg_no和credit_no代替qxb_id确定唯一一个企业

			//qxb_corp_info
			QxbCorpInfo qxbCorpInfo = new QxbCorpInfo();
			qxbCorpInfo.setDtoId(0);
			qxbCorpInfo.setQxbId(qxbId);
			qxbCorpInfo.setName(getNonNullStr(data.getString("name")));
			enterpriseShowDTO.setEnterpriseName(getNonNullStr(data.getString("name")));//保存企业名称
			qxbCorpInfo.setEconKind(getNonNullStr(data.getString("econ_kind")));
			qxbCorpInfo.setRegistCapi(getNonNullStr(data.getString("regist_capi")));
			qxbCorpInfo.setAddress(getNonNullStr(data.getString("address")));
			enterpriseShowDTO.setEntAddress(getNonNullStr(data.getString("address")));//保存企业地址
			qxbCorpInfo.setRegNo(getNonNullStr(data.getString("reg_no")));
			enterpriseShowDTO.setRegNo(getNonNullStr(data.getString("reg_no")));//保存企业工商注册号
			qxbCorpInfo.setScope(getNonNullStr(data.getString("scope")));
			qxbCorpInfo.setTermStart(getNonNullStr(data.getString("term_start")));
			qxbCorpInfo.setTermEnd(getNonNullStr(data.getString("term_end")));
			qxbCorpInfo.setBelongOrg(getNonNullStr(data.getString("belong_org")));
			qxbCorpInfo.setOperName(getNonNullStr(data.getString("oper_name")));
			qxbCorpInfo.setCheckDate(getNonNullStr(data.getString("check_date")));
			qxbCorpInfo.setStartDate(getNonNullStr(data.getString("start_date")));
			qxbCorpInfo.setEndDate(getNonNullStr(data.getString("end_date")));
			qxbCorpInfo.setStatus(getNonNullStr(data.getString("status")));
			qxbCorpInfo.setOrgNo(getNonNullStr(data.getString("org_no")));
			qxbCorpInfo.setCreditNo(getNonNullStr(data.getString("credit_no")));
			enterpriseShowDTO.setCreditNo(getNonNullStr(data.getString("credit_no")));//保存企业信用代码
			qxbCorpInfo.setProvince(getNonNullStr(data.getString("province")));
			qxbCorpInfo.setCity(getNonNullStr(data.getString("city")));
			StringBuffer domains = new StringBuffer();
			try{
				JSONArray domainArray = data.getJSONArray("domains");
				if (null != domainArray) {
					String[] domainStrArray = domainArray.toArray(new String[]{});
					for (int i = 0; i < domainStrArray.length; i++) {
						domains.append(domainStrArray[i]);
						if (i < domainStrArray.length - 1)
							domains.append(",");
					}
				}
			}catch (Exception e){

			}

			qxbCorpInfo.setDomains(getNonNullStr(domains.toString()));
			JSONObject contactObject = data.getJSONObject("contact");
			if (null != contactObject) {
				qxbCorpInfo.setContactAddress(getNonNullStr(contactObject.getString("address")));
				qxbCorpInfo.setContactTelephone(getNonNullStr(contactObject.getString("telephone")));
				qxbCorpInfo.setContactEmail(getNonNullStr(contactObject.getString("email")));
			} else {
				qxbCorpInfo.setContactAddress("");
				qxbCorpInfo.setContactTelephone("");
				qxbCorpInfo.setContactEmail("");
			}
			//TODO
			qxbCorpInfo.setHasFinance(new Byte("1"));
			qxbCorpInfo.setEnttime(CurrentTime.getSecondTimestamp());
			qxbCorpInfoMapper.insert(qxbCorpInfo);
			try{
				qxbCorpInfoMapper.replaceInto(qxbCorpInfo);
				qxbCorpInfoMapper.insertExt(qxbCorpInfo);
			}catch (Exception e){
				LOGGER.info("exception= {}",e.getMessage());
			}

			//qxb_abnormal_item
			JSONArray abnormalItemsJsonArray = data.getJSONArray("abnormal_items");
			if (null != abnormalItemsJsonArray) {
				JSONObject[] abnormalItems = abnormalItemsJsonArray.toArray(new JSONObject[]{});
				for (JSONObject abnormal : abnormalItems) {
					QxbAbnormalItem qxbAbnormalItem = new QxbAbnormalItem();
					qxbAbnormalItem.setQxbId(qxbId);
					qxbAbnormalItem.setDtoId(0);
					qxbAbnormalItem.setInReason(getNonNullStr(abnormal.getString("in_reason")));
					qxbAbnormalItem.setInDate(getNonNullStr(abnormal.getString("in_date")));
					qxbAbnormalItem.setDepartment(getNonNullStr(data.getString("belong_org")));
					qxbAbnormalItem.setOutReason(getNonNullStr(abnormal.getString("out_reason")));
					qxbAbnormalItem.setOutDate(getNonNullStr(abnormal.getString("out_date")));
					qxbAbnormalItem.setEnttime(CurrentTime.getSecondTimestamp());
					qxbAbnormalItemMapper.insert(qxbAbnormalItem);
				}
			}

			//qxb_employee
			JSONArray employeesJsonArray = data.getJSONArray("employees");
			if (null != employeesJsonArray) {
				JSONObject[] jsonObjectAry = employeesJsonArray.toArray(new JSONObject[]{});
				for (JSONObject employee : jsonObjectAry) {
					QxbEmployee qxbEmployee =  new QxbEmployee();
					qxbEmployee.setQxbId(qxbId);
					qxbEmployee.setName(getNonNullStr(employee.getString("name")));
					qxbEmployee.setJobTitle(getNonNullStr(employee.getString("job_title")));
					qxbEmployee.setEnttime(CurrentTime.getSecondTimestamp());
					qxbEmployeeMapper.insert(qxbEmployee);
				}
			}

			//qxb_branch
			JSONArray branchesJsonArray = data.getJSONArray("branches");
			if (null != branchesJsonArray) {
				JSONObject[] branches = branchesJsonArray.toArray(new JSONObject[]{});
				for (JSONObject branch : branches) {
					QxbBranch qxbBranch = new QxbBranch();
					qxbBranch.setQxbId(qxbId);
					qxbBranch.setDtoId(0);
					qxbBranch.setName(getNonNullStr(branch.getString("name")));
					qxbBranch.setEnttime(CurrentTime.getSecondTimestamp());
					qxbBranchMapper.insert(qxbBranch);
				}
			}

			//qxb_changerecord
			JSONArray changeRecordJsonArray = data.getJSONArray("changerecords");
			if (null != changeRecordJsonArray) {
				JSONObject[] changeRecords = changeRecordJsonArray.toArray(new JSONObject[]{});
				for (JSONObject changeRecord : changeRecords) {
					QxbChangerecord qxbChangerecord = new QxbChangerecord();
					qxbChangerecord.setQxbId(qxbId);
					qxbChangerecord.setChangeItem(getNonNullStr(changeRecord.getString("change_item")));
					qxbChangerecord.setChangeDate(getNonNullStr(changeRecord.getString("change_date")));
					qxbChangerecord.setBeforeContent(getNonNullStr(changeRecord.getString("before_content")));
					qxbChangerecord.setAfterContent(getNonNullStr(changeRecord.getString("after_content")));
					qxbChangerecord.setEnttime(CurrentTime.getSecondTimestamp());
					qxbChangerecordMapper.insert(qxbChangerecord);
				}
			}

			//qxb_partner
			JSONArray partnerJsonArray = data.getJSONArray("partners");
			if (null != partnerJsonArray) {
				JSONObject[] partners = partnerJsonArray.toArray(new JSONObject[]{});
				for (JSONObject partner : partners) {
					QxbPartner qxbPartner = new QxbPartner();
					qxbPartner.setQxbId(qxbId);
					qxbPartner.setStockType(getNonNullStr(partner.getString("stock_type")));
					String partnerName = partner.getString("name");
					if (null != partnerName && partnerName.length() >= 50) {
						partnerName = partnerName.substring(0, 49);
					}
					qxbPartner.setName(getNonNullStr(partnerName));
					//TODO
					qxbPartner.setCategory("");
					qxbPartner.setIdentifyType(getNonNullStr(partner.getString("identify_type")));
					qxbPartner.setIdentifyNo(getNonNullStr(partner.getString("identify_no")));
					qxbPartner.setEnttime(CurrentTime.getSecondTimestamp());
					qxbPartnerMapper.insertSelective(qxbPartner);
					int partnerId = qxbPartner.getId();

					//qxb_partner_real_capi
					JSONArray realCapiItemsArray = partner.getJSONArray("real_capi_items");
					if (null != realCapiItemsArray) {
						JSONObject[] realCapiItems = realCapiItemsArray.toArray(new JSONObject[]{});
						for (JSONObject realCapiItem : realCapiItems) {
							QxbPartnerRealCapi qxbPartnerRealCapi = new QxbPartnerRealCapi();
							qxbPartnerRealCapi.setPartnerId(partnerId);
							qxbPartnerRealCapi.setRealCapi(getNonNullStr(realCapiItem.getString("real_capi")));
							qxbPartnerRealCapi.setRealCapiDate(getNonNullStr(realCapiItem.getString("real_capi_date")));
							qxbPartnerRealCapi.setInvestType(getNonNullStr(realCapiItem.getString("invest_type")));
							qxbPartnerRealCapi.setEnttime(CurrentTime.getSecondTimestamp());
							qxbPartnerRealCapiMapper.insert(qxbPartnerRealCapi);
						}
					}

					//qxb_partner_should_capi
					JSONArray shouldCapiItemsArray = partner.getJSONArray("should_capi_items");
					if (null != shouldCapiItemsArray) {
						JSONObject[] shouldCapiItems = shouldCapiItemsArray.toArray(new JSONObject[]{});
						for (JSONObject shouldCapiItem : shouldCapiItems) {
							QxbPartnerShouldCapi qxbPartnerShouldCapi = new QxbPartnerShouldCapi();
							qxbPartnerShouldCapi.setPartnerId(partnerId);
							qxbPartnerShouldCapi.setShoudCapi(getNonNullStr(shouldCapiItem.getString("shoud_capi")));
							qxbPartnerShouldCapi.setShouldCapiDate(getNonNullStr(shouldCapiItem.getString("should_capi_date")));
							qxbPartnerShouldCapi.setInvestType(getNonNullStr(shouldCapiItem.getString("invest_type")));
							qxbPartnerShouldCapi.setEnttime(CurrentTime.getSecondTimestamp());
							qxbPartnerShouldCapiMapper.insert(qxbPartnerShouldCapi);
						}
					}
				}
			}

			//qxb_website
			JSONArray websitesJsonArray = data.getJSONArray("websites");
			if (null != websitesJsonArray) {
				JSONObject[] websites = websitesJsonArray.toArray(new JSONObject[]{});
				for (JSONObject website : websites) {
					QxbWebsite qxbWebsite = new QxbWebsite();
					qxbWebsite.setQxbId(qxbId);
					qxbWebsite.setWebName(getNonNullStr(website.getString("web_name")));
					qxbWebsite.setWebType(getNonNullStr(website.getString("web_type")));
					qxbWebsite.setWebUrl(getNonNullStr(website.getString("web_url")));
					qxbWebsite.setSource(getNonNullStr(website.getString("source")));
					qxbWebsite.setSeqNo(getNonNullStr(website.getString("seq_no")));
					qxbWebsite.setDate(getNonNullStr(website.getString("date")));
					qxbWebsite.setEnttime(CurrentTime.getSecondTimestamp());
					qxbWebsiteMapper.insert(qxbWebsite);
				}
			}
			enterpriseBankListRespDTO.setReqParams(reqDTO);
			enterpriseBankListRespDTO.setEntSglContents(enterpriseShowDTO);
			return enterpriseBankListRespDTO;
		}
		else{
			//如果查询无结果
			enterpriseShowDTO.setRegNo("xxxxxxyyyyyyzzzzzz");   //任意设置一个而不存在的值，用于CrmController判断
			enterpriseShowDTO.setCreditNo("xxxxxxyyyyyyzzzzzz");   //任意设置一个而不存在的值，用于CrmController判断
			enterpriseBankListRespDTO.setReqParams(reqDTO);  //设置返回参数
			enterpriseBankListRespDTO.setEntSglContents(enterpriseShowDTO);
			return enterpriseBankListRespDTO;
		}
	}




	public QxbCorpInfo getEntInitDataApi(String name) throws Exception {
		LOGGER.info("getEntInitDataApi start name={}",name);
		name=name.trim();
		if(name.length()<5){
			throw new Exception("搜索关键字错误");
		}
		QxbCorpInfo qxbCorpInfo=qxbCorpInfoMapper.selectByFullName(name);
		if(qxbCorpInfo!=null){
			LOGGER.info("getEntInitDataApi end name={} qxbCorpInfo!=null",name);
			return qxbCorpInfo;
		}

		EnterpriseBankListRespDTO enterpriseBankListRespDTO = new EnterpriseBankListRespDTO();
		EnterpriseShowDTO enterpriseShowDTO = new EnterpriseShowDTO();
		PageReqDTO reqDTO = new PageReqDTO();
		reqDTO.setCorpName(name);
		//请求参数：企业名和appkey
		HttpClientManager.Param[] params1 = new HttpClientManager.Param[]{
				new HttpClientManager.Param("keyword", name)
				, new HttpClientManager.Param("appkey", QxbAppKey.CORP_INFO)
		};

		//根据企业全名或者注册号精确查询，只会返回一条数据
		QXBAPIResponseDTO responseDTO1 =
				QxbApiResponseDTOTransverter.toCorpMonitorResponse(QXBAPIRequestURL.GET_DETAIL_AND_CONTRACT_BY_NAME, params1);

		if (responseDTO1.getStatus() == 200) {
			JSONObject data = responseDTO1.getData();
			String qxbId = getNonNullStr(data.getString("reg_no")).concat(getNonNullStr(data.getString("credit_no"))); //拼接reg_no和credit_no代替qxb_id确定唯一一个企业

			//qxb_corp_info
			qxbCorpInfo = new QxbCorpInfo();
			qxbCorpInfo.setDtoId(0);
			qxbCorpInfo.setQxbId(qxbId);
			qxbCorpInfo.setName(getNonNullStr(data.getString("name")));
			enterpriseShowDTO.setEnterpriseName(getNonNullStr(data.getString("name")));//保存企业名称
			qxbCorpInfo.setEconKind(getNonNullStr(data.getString("econ_kind")));
			qxbCorpInfo.setRegistCapi(getNonNullStr(data.getString("regist_capi")));
			qxbCorpInfo.setAddress(getNonNullStr(data.getString("address")));
			enterpriseShowDTO.setEntAddress(getNonNullStr(data.getString("address")));//保存企业地址
			qxbCorpInfo.setRegNo(getNonNullStr(data.getString("reg_no")));
			enterpriseShowDTO.setRegNo(getNonNullStr(data.getString("reg_no")));//保存企业工商注册号
			qxbCorpInfo.setScope(getNonNullStr(data.getString("scope")));
			qxbCorpInfo.setTermStart(getNonNullStr(data.getString("term_start")));
			qxbCorpInfo.setTermEnd(getNonNullStr(data.getString("term_end")));
			qxbCorpInfo.setBelongOrg(getNonNullStr(data.getString("belong_org")));
			qxbCorpInfo.setOperName(getNonNullStr(data.getString("oper_name")));
			qxbCorpInfo.setCheckDate(getNonNullStr(data.getString("check_date")));
			qxbCorpInfo.setStartDate(getNonNullStr(data.getString("start_date")));
			qxbCorpInfo.setEndDate(getNonNullStr(data.getString("end_date")));
			qxbCorpInfo.setStatus(getNonNullStr(data.getString("status")));
			qxbCorpInfo.setOrgNo(getNonNullStr(data.getString("org_no")));
			qxbCorpInfo.setCreditNo(getNonNullStr(data.getString("credit_no")));
			enterpriseShowDTO.setCreditNo(getNonNullStr(data.getString("credit_no")));//保存企业信用代码
			qxbCorpInfo.setProvince(getNonNullStr(data.getString("province")));
			qxbCorpInfo.setCity(getNonNullStr(data.getString("city")));
			StringBuffer domains = new StringBuffer();
			try{
				JSONArray domainArray = data.getJSONArray("domains");
				if (null != domainArray) {
					String[] domainStrArray = domainArray.toArray(new String[]{});
					for (int i = 0; i < domainStrArray.length; i++) {
						domains.append(domainStrArray[i]);
						if (i < domainStrArray.length - 1)
							domains.append(",");
					}
				}
			}catch (Exception e){

			}
			qxbCorpInfo.setDomains(getNonNullStr(domains.toString()));
			JSONObject contactObject = data.getJSONObject("contact");
			if (null != contactObject) {
				qxbCorpInfo.setContactAddress(getNonNullStr(contactObject.getString("address")));
				qxbCorpInfo.setContactTelephone(getNonNullStr(contactObject.getString("telephone")));
				qxbCorpInfo.setContactEmail(getNonNullStr(contactObject.getString("email")));
			} else {
				qxbCorpInfo.setContactAddress("");
				qxbCorpInfo.setContactTelephone("");
				qxbCorpInfo.setContactEmail("");
			}
			//TODO
			qxbCorpInfo.setHasFinance(new Byte("1"));
			qxbCorpInfo.setEnttime(CurrentTime.getSecondTimestamp());
			qxbCorpInfoMapper.insert(qxbCorpInfo);
			try{
				repairService.repairRegCreditNo(qxbCorpInfo);
				qxbCorpInfoMapper.replaceInto(qxbCorpInfo);
				qxbCorpInfoMapper.insertExt(qxbCorpInfo);
			}catch (Exception e){
				LOGGER.info("exception= {}",e.getMessage());
			}

			//qxb_abnormal_item
			JSONArray abnormalItemsJsonArray = data.getJSONArray("abnormal_items");
			if (null != abnormalItemsJsonArray) {
				JSONObject[] abnormalItems = abnormalItemsJsonArray.toArray(new JSONObject[]{});
				for (JSONObject abnormal : abnormalItems) {
					QxbAbnormalItem qxbAbnormalItem = new QxbAbnormalItem();
					qxbAbnormalItem.setQxbId(qxbId);
					qxbAbnormalItem.setDtoId(0);
					qxbAbnormalItem.setInReason(getNonNullStr(abnormal.getString("in_reason")));
					qxbAbnormalItem.setInDate(getNonNullStr(abnormal.getString("in_date")));
					qxbAbnormalItem.setDepartment(getNonNullStr(data.getString("belong_org")));
					qxbAbnormalItem.setOutReason(getNonNullStr(abnormal.getString("out_reason")));
					qxbAbnormalItem.setOutDate(getNonNullStr(abnormal.getString("out_date")));
					qxbAbnormalItem.setEnttime(CurrentTime.getSecondTimestamp());
					qxbAbnormalItemMapper.insert(qxbAbnormalItem);
				}
			}

			//qxb_employee
			JSONArray employeesJsonArray = data.getJSONArray("employees");
			if (null != employeesJsonArray) {
				JSONObject[] jsonObjectAry = employeesJsonArray.toArray(new JSONObject[]{});
				for (JSONObject employee : jsonObjectAry) {
					QxbEmployee qxbEmployee =  new QxbEmployee();
					qxbEmployee.setQxbId(qxbId);
					qxbEmployee.setName(getNonNullStr(employee.getString("name")));
					qxbEmployee.setJobTitle(getNonNullStr(employee.getString("job_title")));
					qxbEmployee.setEnttime(CurrentTime.getSecondTimestamp());
					qxbEmployeeMapper.insert(qxbEmployee);
				}
			}

			//qxb_branch
			JSONArray branchesJsonArray = data.getJSONArray("branches");
			if (null != branchesJsonArray) {
				JSONObject[] branches = branchesJsonArray.toArray(new JSONObject[]{});
				for (JSONObject branch : branches) {
					QxbBranch qxbBranch = new QxbBranch();
					qxbBranch.setQxbId(qxbId);
					qxbBranch.setDtoId(0);
					qxbBranch.setName(getNonNullStr(branch.getString("name")));
					qxbBranch.setEnttime(CurrentTime.getSecondTimestamp());
					qxbBranchMapper.insert(qxbBranch);
				}
			}

			//qxb_changerecord
			JSONArray changeRecordJsonArray = data.getJSONArray("changerecords");
			if (null != changeRecordJsonArray) {
				JSONObject[] changeRecords = changeRecordJsonArray.toArray(new JSONObject[]{});
				for (JSONObject changeRecord : changeRecords) {
					QxbChangerecord qxbChangerecord = new QxbChangerecord();
					qxbChangerecord.setQxbId(qxbId);
					qxbChangerecord.setChangeItem(getNonNullStr(changeRecord.getString("change_item")));
					qxbChangerecord.setChangeDate(getNonNullStr(changeRecord.getString("change_date")));
					qxbChangerecord.setBeforeContent(getNonNullStr(changeRecord.getString("before_content")));
					qxbChangerecord.setAfterContent(getNonNullStr(changeRecord.getString("after_content")));
					qxbChangerecord.setEnttime(CurrentTime.getSecondTimestamp());
					qxbChangerecordMapper.insert(qxbChangerecord);
				}
			}

			//qxb_partner
			JSONArray partnerJsonArray = data.getJSONArray("partners");
			if (null != partnerJsonArray) {
				JSONObject[] partners = partnerJsonArray.toArray(new JSONObject[]{});
				for (JSONObject partner : partners) {
					QxbPartner qxbPartner = new QxbPartner();
					qxbPartner.setQxbId(qxbId);
					qxbPartner.setStockType(getNonNullStr(partner.getString("stock_type")));
					String partnerName = partner.getString("name");
					if (null != partnerName && partnerName.length() >= 50) {
						partnerName = partnerName.substring(0, 49);
					}
					qxbPartner.setName(getNonNullStr(partnerName));
					//TODO
					qxbPartner.setCategory("");
					qxbPartner.setIdentifyType(getNonNullStr(partner.getString("identify_type")));
					qxbPartner.setIdentifyNo(getNonNullStr(partner.getString("identify_no")));
					qxbPartner.setEnttime(CurrentTime.getSecondTimestamp());
					qxbPartnerMapper.insertSelective(qxbPartner);
					int partnerId = qxbPartner.getId();

					//qxb_partner_real_capi
					JSONArray realCapiItemsArray = partner.getJSONArray("real_capi_items");
					if (null != realCapiItemsArray) {
						JSONObject[] realCapiItems = realCapiItemsArray.toArray(new JSONObject[]{});
						for (JSONObject realCapiItem : realCapiItems) {
							QxbPartnerRealCapi qxbPartnerRealCapi = new QxbPartnerRealCapi();
							qxbPartnerRealCapi.setPartnerId(partnerId);
							qxbPartnerRealCapi.setRealCapi(getNonNullStr(realCapiItem.getString("real_capi")));
							qxbPartnerRealCapi.setRealCapiDate(getNonNullStr(realCapiItem.getString("real_capi_date")));
							qxbPartnerRealCapi.setInvestType(getNonNullStr(realCapiItem.getString("invest_type")));
							qxbPartnerRealCapi.setEnttime(CurrentTime.getSecondTimestamp());
							qxbPartnerRealCapiMapper.insert(qxbPartnerRealCapi);
						}
					}

					//qxb_partner_should_capi
					JSONArray shouldCapiItemsArray = partner.getJSONArray("should_capi_items");
					if (null != shouldCapiItemsArray) {
						JSONObject[] shouldCapiItems = shouldCapiItemsArray.toArray(new JSONObject[]{});
						for (JSONObject shouldCapiItem : shouldCapiItems) {
							QxbPartnerShouldCapi qxbPartnerShouldCapi = new QxbPartnerShouldCapi();
							qxbPartnerShouldCapi.setPartnerId(partnerId);
							qxbPartnerShouldCapi.setShoudCapi(getNonNullStr(shouldCapiItem.getString("shoud_capi")));
							qxbPartnerShouldCapi.setShouldCapiDate(getNonNullStr(shouldCapiItem.getString("should_capi_date")));
							qxbPartnerShouldCapi.setInvestType(getNonNullStr(shouldCapiItem.getString("invest_type")));
							qxbPartnerShouldCapi.setEnttime(CurrentTime.getSecondTimestamp());
							qxbPartnerShouldCapiMapper.insert(qxbPartnerShouldCapi);
						}
					}
				}
			}

			//qxb_website
			JSONArray websitesJsonArray = data.getJSONArray("websites");
			if (null != websitesJsonArray) {
				JSONObject[] websites = websitesJsonArray.toArray(new JSONObject[]{});
				for (JSONObject website : websites) {
					QxbWebsite qxbWebsite = new QxbWebsite();
					qxbWebsite.setQxbId(qxbId);
					qxbWebsite.setWebName(getNonNullStr(website.getString("web_name")));
					qxbWebsite.setWebType(getNonNullStr(website.getString("web_type")));
					qxbWebsite.setWebUrl(getNonNullStr(website.getString("web_url")));
					qxbWebsite.setSource(getNonNullStr(website.getString("source")));
					qxbWebsite.setSeqNo(getNonNullStr(website.getString("seq_no")));
					qxbWebsite.setDate(getNonNullStr(website.getString("date")));
					qxbWebsite.setEnttime(CurrentTime.getSecondTimestamp());
					qxbWebsiteMapper.insert(qxbWebsite);
				}
			}
			enterpriseBankListRespDTO.setReqParams(reqDTO);
			enterpriseBankListRespDTO.setEntSglContents(enterpriseShowDTO);
			LOGGER.info("getEntInitDataApi end name={}",name);
			return qxbCorpInfo;
		}
		else{
			throw new Exception(responseDTO1.getMessage());
		}
	}
}