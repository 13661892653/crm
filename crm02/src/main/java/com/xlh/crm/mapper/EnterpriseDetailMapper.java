package com.xlh.crm.mapper;

import com.xlh.crm.dto.*;
import com.xlh.crm.dto.mysql.CdmEntDtoHighTech;
import com.xlh.crm.dto.mysql.CrmEntFavoriteDTO;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface EnterpriseDetailMapper {

	//企业档案-基本信息
	@Results({
			@Result(column="audit_status", property="auditStatus", jdbcType=JdbcType.INTEGER),
			@Result(column="cust_manager", property="custManager", jdbcType=JdbcType.VARCHAR),
			@Result(column="enterprise_name", property="enterpriseName", jdbcType=JdbcType.VARCHAR),
			@Result(column="reg_credit_no", property="regCreditNo", jdbcType=JdbcType.VARCHAR, id=true),
			@Result(column="credit_no", property="creditNo", jdbcType=JdbcType.VARCHAR),
			@Result(column="reg_no", property="regNo", jdbcType=JdbcType.VARCHAR, id=true),
			@Result(column="mgmt_status", property="mgmtStatus", jdbcType=JdbcType.VARCHAR),
			@Result(column="econ_kind", property="econKind", jdbcType=JdbcType.VARCHAR),
			@Result(column="legal_representative", property="legalRepresentative", jdbcType=JdbcType.VARCHAR),
			@Result(column="operate_date", property="operateDate", jdbcType=JdbcType.VARCHAR),
			@Result(column="ent_address", property="entAddress", jdbcType=JdbcType.VARCHAR),
			@Result(column="contact_telephone", property="contactTelephone", jdbcType=JdbcType.VARCHAR),
			@Result(column="contact_email", property="contactEmail", jdbcType=JdbcType.VARCHAR),
			@Result(column="create_date", property="createDate", jdbcType=JdbcType.VARCHAR),
			@Result(column="industry_type_code", property="industryTypeCode", jdbcType=JdbcType.VARCHAR),
			@Result(column="industry_type_name", property="industryTypeName", jdbcType=JdbcType.VARCHAR),
			@Result(column="industry_code", property="industryCode", jdbcType=JdbcType.VARCHAR),
			@Result(column="industry_name", property="industryName", jdbcType=JdbcType.VARCHAR),
			@Result(column="main_industry", property="mainIndustry", jdbcType=JdbcType.VARCHAR),
			@Result(column="main_product", property="mainProduct", jdbcType=JdbcType.VARCHAR),
			@Result(column="mgmt_scope", property="mgmtScope", jdbcType=JdbcType.VARCHAR),
			@Result(column="register_money", property="registerMoney", jdbcType=JdbcType.VARCHAR),
			@Result(column="corp_info", property="corpInfo", jdbcType=JdbcType.VARCHAR),
			@Result(column="tag_array", property="tagArray", jdbcType=JdbcType.VARCHAR),
			@Result(column="fav_user_list", property="favUserList", jdbcType=JdbcType.VARCHAR),
			@Result(column="rec_cnt", property="recCnt", jdbcType=JdbcType.VARCHAR)
	})
	@SelectProvider(type=EnterpriseDetailSqlProvider.class, method="getEnterpriseBaseInfoList")
	EnterpriseBaseInfoRespDTO getEnterpriseBaseInfoList(String regCreditNo);

	//企业档案-客户经理、收藏信息
	@Results({
			@Result(column="reg_credit_no", property="regCreditNo", jdbcType=JdbcType.VARCHAR),
			@Result(column="credit_no", property="creditNo", jdbcType=JdbcType.VARCHAR),
			@Result(column="reg_no", property="regNo", jdbcType=JdbcType.VARCHAR),
			@Result(column="cust_manager", property="custManager", jdbcType=JdbcType.VARCHAR),
			@Result(column="fav_user_list", property="favUserList", jdbcType=JdbcType.VARCHAR)
	})
	@SelectProvider(type=EnterpriseDetailSqlProvider.class, method="getEnterpriseFavorite")
	EnterpriseShowDTO getEnterpriseFavorite(PageReqDTO req);

	//企业档案-主要人员
	@Results({
			@Result(column="job_title", property="jobTitle", jdbcType=JdbcType.VARCHAR),
			@Result(column="name", property="name", jdbcType=JdbcType.VARCHAR)
	})
	@SelectProvider(type=EnterpriseDetailSqlProvider.class, method="getEnterpriseEmployeeList")
	List<EnterpriseEmployeeRespDTO> getEnterpriseEmployeeList(String regCreditNo);

	//企业档案-服务订单
	@Results({
			@Result(column="order_no", property="orderNo", jdbcType=JdbcType.VARCHAR),
			@Result(column="order_date", property="orderDate", jdbcType=JdbcType.DATE),
			@Result(column="order_memeber_name", property="orderMemeberName", jdbcType=JdbcType.VARCHAR),
			@Result(column="order_prod_name", property="orderProdName", jdbcType=JdbcType.VARCHAR),
			@Result(column="order_amt", property="orderAmt", jdbcType=JdbcType.VARCHAR),
			@Result(column="order_status", property="orderStatus", jdbcType=JdbcType.VARCHAR),
			@Result(column="is_self_biz", property="isSelfBiz", jdbcType=JdbcType.INTEGER),
			@Result(column="partner_name", property="partnerName", jdbcType=JdbcType.VARCHAR),
			@Result(column="progress", property="progress", jdbcType=JdbcType.VARCHAR)
	})
	@SelectProvider(type=EnterpriseDetailSqlProvider.class, method="getEnterpriseOrderList")
	List<OrderShowDTO> getEnterpriseOrderList(String regCreditNo);

	//企业档案-触达信息
	@Results({
			@Result(column="rch_no", property="rchNo", jdbcType=JdbcType.VARCHAR),
			@Result(column="rch_mode", property="rchMode", jdbcType=JdbcType.VARCHAR),
			@Result(column="rch_emp", property="rchEmp", jdbcType=JdbcType.VARCHAR),
			@Result(column="begin_time", property="beginTime", jdbcType=JdbcType.VARCHAR),
			@Result(column="end_time", property="endTime", jdbcType=JdbcType.VARCHAR),
			@Result(column="contacts", property="contacts", jdbcType=JdbcType.VARCHAR),
			@Result(column="contacts_phone", property="contactsPhone", jdbcType=JdbcType.VARCHAR),
			@Result(column="win_cust_chnl", property="winCustChnl", jdbcType=JdbcType.VARCHAR),
			@Result(column="sales_lead", property="salesLead", jdbcType=JdbcType.VARCHAR),
			@Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR)
	})
	@SelectProvider(type=EnterpriseDetailSqlProvider.class, method="getEnterpriseReachcsrList")
	List<EnterpriseReachcsrRespDTO> getEnterpriseReachcsrList(String regCreditNo);

	//企业档案-历史融资
	@Results({
			@Result(column="financing_date", property="financingDate", jdbcType=JdbcType.DATE),
			@Result(column="financing_amount", property="financingAmount", jdbcType=JdbcType.VARCHAR),
			@Result(column="financing_currency", property="financingCurrency", jdbcType=JdbcType.VARCHAR),
			@Result(column="financing_stage", property="financingStage", jdbcType=JdbcType.VARCHAR),
			@Result(column="investors", property="investors", jdbcType=JdbcType.VARCHAR)
	})
	@SelectProvider(type=EnterpriseDetailSqlProvider.class, method="getEnterpriseFinancingList")
	List<EnterpriseFinancingRespDTO> getEnterpriseFinancingList(String regCreditNo);

	//企业档案-股东信息
	@Results({
			@Result(column="partner_name", property="partnerName", jdbcType=JdbcType.VARCHAR),
			@Result(column="partner_type", property="partnerType", jdbcType=JdbcType.VARCHAR),
			@Result(column="should_capi", property="shouldCapi", jdbcType=JdbcType.VARCHAR),
			@Result(column="should_capi_date", property="shouldCapiDate", jdbcType=JdbcType.VARCHAR)
	})
	@SelectProvider(type=EnterpriseDetailSqlProvider.class, method="getEnterprisePartnerList")
	List<EnterprisePartnerRespDTO> getEnterprisePartnerList(String regCreditNo);

	//企业档案-公司人员构成
	@Results({
			@Result(column="credit_no", property="creditNo", jdbcType=JdbcType.VARCHAR),
			@Result(column="reg_no", property="regNo", jdbcType=JdbcType.VARCHAR),
			@Result(column="reg_credit_no", property="regCreditNo", jdbcType=JdbcType.VARCHAR),
			@Result(column="staff_number", property="staffNumber", jdbcType=JdbcType.VARCHAR),
			@Result(column="college_rate", property="collegeRate", jdbcType=JdbcType.VARCHAR),
			@Result(column="undergraduate_rate", property="undergraduateRate", jdbcType=JdbcType.VARCHAR),
			@Result(column="master_rate", property="masterRate", jdbcType=JdbcType.VARCHAR),
			@Result(column="rd_number", property="rdNumber", jdbcType=JdbcType.VARCHAR)
	})
	@SelectProvider(type=EnterpriseDetailSqlProvider.class, method="getEnterpriseEmpStrucList")
	EnterpriseEmpStrucRespDTO getEnterpriseEmpStrucList(String regCreditNo);

	//企业档案-核心团队
	@Results({
			@Result(column="rec_id", property="recId", jdbcType=JdbcType.INTEGER),
			@Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
			@Result(column="sex", property="sex", jdbcType=JdbcType.VARCHAR),
			@Result(column="job_title", property="jobTitle", jdbcType=JdbcType.VARCHAR),
			@Result(column="education", property="education", jdbcType=JdbcType.VARCHAR),
			@Result(column="resume", property="resume", jdbcType=JdbcType.VARCHAR)
	})
	@SelectProvider(type=EnterpriseDetailSqlProvider.class, method="getEnterpriseCoreTeamList")
	List<EnterpriseCoreTeamRespDTO> getEnterpriseCoreTeamList(String regCreditNo);

	//企业档案-公司联系人
	@Results({
			@Result(column="rec_id", property="recId", jdbcType=JdbcType.INTEGER),
			@Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
			@Result(column="job_title", property="jobTitle", jdbcType=JdbcType.VARCHAR),
			@Result(column="contact_mobi_phone", property="contactMobiPhone", jdbcType=JdbcType.VARCHAR),
			@Result(column="contact_fixed_phone", property="contactFixedPhone", jdbcType=JdbcType.VARCHAR),
			@Result(column="email", property="email", jdbcType=JdbcType.VARCHAR)
	})
	@SelectProvider(type=EnterpriseDetailSqlProvider.class, method="getEnterpriseContactsList")
	List<EnterpriseContactsRespDTO> getEnterpriseContactsList(String regCreditNo);

	//企业档案-荣誉
	@Results({
			@Result(column="rec_id", property="recId", jdbcType=JdbcType.INTEGER),
			@Result(column="qualification", property="qualification", jdbcType=JdbcType.VARCHAR),
			@Result(column="honor", property="honor", jdbcType=JdbcType.VARCHAR)
	})
	@SelectProvider(type=EnterpriseDetailSqlProvider.class, method="getEnterpriseHonorList")
	List<EnterpriseHonorRespDTO> getEnterpriseHonorList(String regCreditNo);

	//企业档案-市场发展情况
	@Results({
			@Result(column="dev_stage", property="devStage", jdbcType=JdbcType.VARCHAR),
			@Result(column="market_rate", property="marketRate", jdbcType=JdbcType.VARCHAR),
			@Result(column="business_pattern", property="businessPattern", jdbcType=JdbcType.VARCHAR),
			@Result(column="core_competence", property="coreCompetence", jdbcType=JdbcType.VARCHAR),
			@Result(column="five_customer", property="fiveCustomer", jdbcType=JdbcType.VARCHAR),
			@Result(column="five_supplier", property="fiveSupplier", jdbcType=JdbcType.VARCHAR),
			@Result(column="major_competitors", property="majorCompetitors", jdbcType=JdbcType.VARCHAR),
			@Result(column="prod_biz_submit", property="prodBizSubmit", jdbcType=JdbcType.VARCHAR),
			@Result(column="cur_req_info", property="curReqInfo", jdbcType=JdbcType.VARCHAR),
			@Result(column="info_suggestions", property="infoSuggestions", jdbcType=JdbcType.VARCHAR)
	})
	@SelectProvider(type=EnterpriseDetailSqlProvider.class, method="getEnterpriseMarketDevList")
	EnterpriseMarketDevRespDTO getEnterpriseMarketDevList(String regCreditNo);

	//企业档案-上市情况
	@Results({
			@Result(column="ipo_stage", property="ipoStage", jdbcType=JdbcType.VARCHAR),
			@Result(column="ipo_date", property="ipoDate", jdbcType=JdbcType.VARCHAR),
			@Result(column="ipo_sector", property="ipoSector", jdbcType=JdbcType.VARCHAR)
	})
	@SelectProvider(type=EnterpriseDetailSqlProvider.class, method="getEnterpriseIpoList")
	EnterpriseIpoRespDTO getEnterpriseIpoList(String regCreditNo);

	//企业档案-归属载体
	@Results({
			@Result(column="carrier_type", property="carrierType", jdbcType=JdbcType.VARCHAR),
			@Result(column="carrier_name", property="carrierName", jdbcType=JdbcType.VARCHAR)
	})
	@SelectProvider(type=EnterpriseDetailSqlProvider.class, method="getEnterpriseCarrierList")
	EnterpriseCarrierRespDTO getEnterpriseCarrierList(String regCreditNo);

	//企业档案-财务数据
	@Results({
			@Result(column="rec_id", property="recId", jdbcType=JdbcType.INTEGER),
			@Result(column="fin_year", property="finYear", jdbcType=JdbcType.VARCHAR),
			@Result(column="R2007", property="operatingIncome", jdbcType=JdbcType.DOUBLE),
			@Result(column="R2009", property="netProfit", jdbcType=JdbcType.DOUBLE),
			@Result(column="R2009", property="netProfit", jdbcType=JdbcType.DOUBLE),
			@Result(column="F1006", property="totalAssets", jdbcType=JdbcType.DOUBLE),
			@Result(column="R2016", property="netAssets", jdbcType=JdbcType.DOUBLE),
			@Result(column="fin_source_type", property="finSourceType", jdbcType=JdbcType.VARCHAR),
			@Result(column="fin_source_desc", property="finSourceDesc", jdbcType=JdbcType.VARCHAR)
	})
	@SelectProvider(type=EnterpriseDetailSqlProvider.class, method="getEnterpriseFindataList")
	List<EnterpriseFindataRespDTO> getEnterpriseFindataList(String regCreditNo);

	//企业档案-项目数据
	@Results({
			@Result(column="project_name", property="projectName", jdbcType=JdbcType.VARCHAR),
			@Result(column="project_desc", property="projectDesc", jdbcType=JdbcType.VARCHAR),
			@Result(column="industry", property="industry", jdbcType=JdbcType.VARCHAR),
			@Result(column="comment_person", property="commentPerson", jdbcType=JdbcType.VARCHAR),
			@Result(column="comment_remark", property="commentRemark", jdbcType=JdbcType.VARCHAR),
			@Result(column="bp_year", property="bpYear", jdbcType=JdbcType.VARCHAR)
	})
	@SelectProvider(type=EnterpriseDetailSqlProvider.class, method="getEnterpriseProjList")
	List<EnterpriseProjRespDTO> getEnterpriseProjList(String regCreditNo);

	//添加收藏企业
	@InsertProvider(type=EnterpriseDetailSqlProvider.class, method="enterpriseAddFav")
	@Options(useGeneratedKeys = true, keyProperty = "regCreditNo", keyColumn = "reg_credit_no")
	int enterpriseAddFav(EnterpriseShowDTO enterpriseShowDTO);

	//变更客户经理
	@Update({
			"update  crm_ent_favorite set cust_manager_id=#{custManagerId,jdbcType=INTEGER},"+
					"cust_manager=#{custManager,jdbcType=VARCHAR},"+
					"update_time=#{updateTime,jdbcType=VARCHAR}, "+
					"cust_manager_update_time=#{custManagerUpdateTime,jdbcType=VARCHAR} "+
					" where reg_credit_no=#{regCreditNo,jdbcType=VARCHAR}"
	})
	int enterpriceCustUpdate(CrmEntFavoriteDTO crmEntFavoriteDTO);
	//取消收藏企业
	@DeleteProvider(type=EnterpriseDetailSqlProvider.class, method="enterpriseCelFav")
	int enterpriseCelFav(PageReqDTO reqDTO);

	//企业档案-公司人员构成（编辑）
	@Update({
			"replace into cdm_ent_dto_emp_struc(" +
					"credit_no" +
					",reg_no" +
					",reg_credit_no" +
					",staff_number" +
					",college_rate" +
					",undergraduate_rate" +
					",master_rate" +
					",rd_number" +
					",update_time)",
			"values(#{creditNo,jdbcType=VARCHAR}" +
					",#{regNo,jdbcType=VARCHAR}" +
					",#{regCreditNo,jdbcType=VARCHAR}" +
					",#{staffNumber,jdbcType=VARCHAR}" +
					",#{collegeRate,jdbcType=VARCHAR}" +
					",#{undergraduateRate,jdbcType=VARCHAR}" +
					",#{masterRate,jdbcType=VARCHAR}" +
					",#{rdNumber,jdbcType=VARCHAR}" +
					",#{updateTime,jdbcType=VARCHAR})"
	})
	int enterpriseEmpStrucUpdate(EnterpriseEmpStrucRespDTO empStrucRespDTO);

	//企业档案-公司介绍（编辑）
	@Update({
			"update cdm_ent_dto_corp_info "+
			"set corp_info = #{corpInfo,jdbcType=VARCHAR} "+
					",main_industry = #{mainIndustry,jdbcType=VARCHAR} "+
					",main_product = #{mainProduct,jdbcType=VARCHAR} "+
					",update_time = #{updateTime,jdbcType=VARCHAR}" +
			" where reg_credit_no = #{regCreditNo,jdbcType=VARCHAR}"
	})
	int enterpriseBaseInfoUpdate(EnterpriseBaseInfoRespDTO baseInfoRespDTO);

	//企业档案-市场发展（编辑）
	@Update({
			"replace into cdm_ent_dto_market_dev("+
					"credit_no" +
					",reg_no" +
					",reg_credit_no" +
					",prod_biz_submit" +
					",cur_req_info" +
					",info_suggestions" +
					",dev_stage" +
					",business_pattern" +
					",core_competence" +
					",five_customer" +
					",five_supplier" +
					",major_competitors" +
					",market_rate" +
					",update_time)",
			"values(#{creditNo,jdbcType=VARCHAR} " +
					" ,#{regNo,jdbcType=VARCHAR} "+
					" ,#{regCreditNo,jdbcType=VARCHAR} "+
					" ,#{prodBizSubmit,jdbcType=VARCHAR} "+
					" ,#{curReqInfo,jdbcType=VARCHAR} "+
					" ,#{infoSuggestions,jdbcType=VARCHAR} "+
					" ,#{devStage,jdbcType=VARCHAR} "+
					" ,#{businessPattern,jdbcType=VARCHAR} "+
					" ,#{coreCompetence,jdbcType=VARCHAR} "+
					" ,#{fiveCustomer,jdbcType=VARCHAR} "+
					" ,#{fiveSupplier,jdbcType=VARCHAR} "+
					" ,#{majorCompetitors,jdbcType=VARCHAR} "+
					" ,#{marketRate,jdbcType=VARCHAR}" +
					" ,#{updateTime,jdbcType=VARCHAR}) "
	})
	int enterpriseMarketDevUpdate(EnterpriseMarketDevRespDTO marketDevRespDTO);

	//企业档案-上市情况（编辑）
	@Update({
			"replace into cdm_ent_dto_ipo("+
					"credit_no" +
					",reg_no" +
					",reg_credit_no" +
					",ipo_stage" +
					",ipo_date" +
					",ipo_sector" +
					",update_time)",
			"values(#{creditNo,jdbcType=VARCHAR} " +
					" ,#{regNo,jdbcType=VARCHAR} "+
					" ,#{regCreditNo,jdbcType=VARCHAR} "+
					" ,#{ipoStage,jdbcType=VARCHAR} "+
					" ,#{ipoDate,jdbcType=VARCHAR} "+
					" ,#{ipoSector,jdbcType=VARCHAR}" +
					" ,#{updateTime,jdbcType=VARCHAR}) "
	})
	int enterpriseIpoUpdate(EnterpriseIpoRespDTO ipoRespDTO);

	//企业档案-归属载体（编辑）
	@Update({
			"replace into cdm_ent_dto_carrier("+
					"credit_no" +
					",reg_no" +
					",reg_credit_no" +
					",carrier_type" +
					",carrier_name" +
					",update_time)",
			"values(#{creditNo,jdbcType=VARCHAR} " +
					" ,#{regNo,jdbcType=VARCHAR} "+
					" ,#{regCreditNo,jdbcType=VARCHAR} "+
					" ,#{carrierType,jdbcType=VARCHAR} "+
					" ,#{carrierName,jdbcType=VARCHAR}" +
					" ,#{updateTime,jdbcType=VARCHAR}) "
	})
	int enterpriseCarrierUpdate(EnterpriseCarrierRespDTO carrierRespDTO);

	//企业档案-核心团队（新增）
	@Insert({
			"insert into cdm_ent_dto_core_team (",
			"credit_no, reg_no, ",
			"reg_credit_no, name, ",
			"sex, job_title, ",
			"education, resume, update_time)",
			"values (#{creditNo,jdbcType=VARCHAR}, #{regNo,jdbcType=DATE}, ",
			"#{regCreditNo,jdbcType=VARCHAR}, #{name,jdbcType=VARCHAR}, ",
			"#{sex,jdbcType=VARCHAR}, #{jobTitle,jdbcType=VARCHAR}, ",
			"#{education,jdbcType=VARCHAR}, #{resume,jdbcType=VARCHAR}, #{updateTime,jdbcType=VARCHAR})"
	})
	int enterpriseCoreTeamInsert(EnterpriseCoreTeamRespDTO coreTeamRespDTO);

	//企业档案-核心团队（删除）
	@Insert({
			"delete from cdm_ent_dto_core_team ",
			" where reg_credit_no = #{regCreditNo,jdbcType=VARCHAR}",
			"   and rec_id = #{recId,jdbcType=VARCHAR}"
	})
	int enterpriseCoreTeamDelete(EnterpriseCoreTeamRespDTO coreTeamRespDTO);

	//企业档案-公司联系人（新增）
	@Insert({
			"insert into cdm_ent_dto_contacts (",
			"credit_no, reg_no, ",
			"reg_credit_no, name, ",
			"job_title, contact_mobi_phone, ",
			"contact_fixed_phone, email, update_time)",
			"values (#{creditNo,jdbcType=VARCHAR}, #{regNo,jdbcType=VARCHAR}, ",
			"#{regCreditNo,jdbcType=VARCHAR}, #{name,jdbcType=VARCHAR}, ",
			"#{jobTitle,jdbcType=VARCHAR}, #{contactMobiPhone,jdbcType=VARCHAR}, ",
			"#{contactFixedPhone,jdbcType=VARCHAR}, #{email,jdbcType=VARCHAR}, #{updateTime,jdbcType=VARCHAR})"
	})
	int enterpriseContactsInsert(EnterpriseContactsRespDTO contactsRespDTO);

	//企业档案-公司联系人（删除）
	@Insert({
			"delete from cdm_ent_dto_contacts ",
			" where reg_credit_no = #{regCreditNo,jdbcType=VARCHAR}",
			"   and name = #{name,jdbcType=VARCHAR}"
	})
	int enterpriseContactsDelete(EnterpriseContactsRespDTO contactsRespDTO);

	//企业档案-资质荣誉（新增）
	@Insert({
			"insert into cdm_ent_dto_honor (",
			"credit_no, reg_no, ",
			"reg_credit_no, qualification, ",
			"honor, update_time)",
			"values (#{creditNo,jdbcType=VARCHAR}, #{regNo,jdbcType=VARCHAR}, ",
			"#{regCreditNo,jdbcType=VARCHAR}, #{qualification,jdbcType=VARCHAR}, ",
			"#{honor,jdbcType=VARCHAR}, #{updateTime,jdbcType=VARCHAR})"
	})
	int enterpriseHonorInsert(EnterpriseHonorRespDTO honorRespDTO);

	//企业档案-资质荣誉（删除）
	@Insert({
			"delete from cdm_ent_dto_honor ",
			" where reg_credit_no = #{regCreditNo,jdbcType=VARCHAR}",
			"   and rec_id = #{recId,jdbcType=VARCHAR}"
	})
	int enterpriseHonorDelete(EnterpriseHonorRespDTO honorRespDTO);

	//企业档案-财务数据（新增）
	@Insert({
			"insert into cdm_ent_dto_finance_recent (",
			"enterprise_name, ",
			"credit_no, reg_no, ",
			"reg_credit_no, fin_year, ",
			"R2007, R2009, F1006,R2016, amt_unit, fin_source_type, fin_source_desc, update_time)",
			"values (#{enterpriseName,jdbcType=VARCHAR}, #{creditNo,jdbcType=VARCHAR}, #{regNo,jdbcType=VARCHAR}, ",
			"#{regCreditNo,jdbcType=VARCHAR}, #{finYear,jdbcType=VARCHAR}, #{operatingIncome,jdbcType=VARCHAR}, #{netProfit,jdbcType=VARCHAR}, ",
			"#{totalAssets,jdbcType=VARCHAR},#{netAssets,jdbcType=VARCHAR}, #{amtUnit,jdbcType=VARCHAR}, #{finSourceType,jdbcType=VARCHAR}, #{finSourceDesc,jdbcType=VARCHAR}, #{updateTime,jdbcType=VARCHAR})"
	})
	int enterpriseFindataInsert(EnterpriseFindataRespDTO findataRespDTO);

	//企业档案-财务数据（删除）
	@Insert({
			"delete from cdm_ent_dto_finance_recent ",
			" where reg_credit_no = #{regCreditNo,jdbcType=VARCHAR}",
			"   and rec_id = #{recId,jdbcType=VARCHAR}"
	})
	int enterpriseFindataDelete(EnterpriseFindataRespDTO findataRespDTO);


	//政府专项（高企）业务核心指标概况
	@Insert({
			"insert into cdm_ent_dto_high_tech (credit_no,reg_no,reg_credit_no,is_high_tech,identify_time,is_applying," +
					"apply_type,has_apply_will,has_intellectual_property,intellectual_property_num,research_rate,income_scale,hisdeclare_scale," +
					"independent_imputation,apply_fee_deduction,tax_type,income_change,has_demand,check_gov_special,check_high_tech,policy_name,other_info,insert_time,update_time) " +
					"VALUES(#{credit_no,jdbcType=VARCHAR}, #{reg_no,jdbcType=VARCHAR},#{reg_credit_no,jdbcType=VARCHAR},#{is_high_tech,jdbcType=INTEGER},#{identify_time,jdbcType=VARCHAR},#{is_applying,jdbcType=INTEGER}," +
					"#{apply_type,jdbcType=INTEGER},#{has_apply_will,jdbcType=INTEGER},#{has_intellectual_property,jdbcType=INTEGER},#{intellectual_property_num,jdbcType=INTEGER},#{research_rate,jdbcType=VARCHAR},#{income_scale,jdbcType=VARCHAR},#{hisdeclare_scale,jdbcType=VARCHAR}," +
					"#{independent_imputation,jdbcType=INTEGER},#{apply_fee_deduction,jdbcType=INTEGER},#{tax_type,jdbcType=INTEGER},#{income_change,jdbcType=INTEGER},#{has_demand,jdbcType=INTEGER},#{check_gov_special,jdbcType=INTEGER},#{check_high_tech,jdbcType=INTEGER}" +
					",#{policy_name,jdbcType=VARCHAR},#{other_info,jdbcType=VARCHAR},#{insert_time,jdbcType=VARCHAR},#{update_time,jdbcType=VARCHAR});"
	})
	int enterpriseInsertHighTech(CdmEntDtoHighTech cdmEntDtoHighTech);

	@Update({
			"update cdm_ent_dto_high_tech set credit_no=#{credit_no,jdbcType=VARCHAR}," +
					"reg_no=#{reg_no,jdbcType=VARCHAR}," +
					"is_high_tech=#{is_high_tech,jdbcType=INTEGER}," +
					"identify_time=#{identify_time,jdbcType=VARCHAR}," +
					"is_applying=#{is_applying,jdbcType=INTEGER}," +
					"apply_type=#{apply_type,jdbcType=INTEGER}," +
					"has_apply_will=#{has_apply_will,jdbcType=INTEGER}," +
					"has_intellectual_property=#{has_intellectual_property,jdbcType=INTEGER}," +
					"intellectual_property_num=#{intellectual_property_num,jdbcType=INTEGER}," +
					"research_rate=#{research_rate,jdbcType=VARCHAR}," +
					"income_scale=#{income_scale,jdbcType=VARCHAR}," +
					"hisdeclare_scale=#{hisdeclare_scale,jdbcType=VARCHAR}," +
					"independent_imputation=#{independent_imputation,jdbcType=INTEGER}," +
					"apply_fee_deduction=#{apply_fee_deduction,jdbcType=INTEGER}," +
					"tax_type=#{tax_type,jdbcType=INTEGER}," +
					"income_change=#{income_change,jdbcType=INTEGER}," +
					"has_demand=#{has_demand,jdbcType=INTEGER}," +
					"check_gov_special=#{check_gov_special,jdbcType=INTEGER}," +
					"check_high_tech=#{check_high_tech,jdbcType=INTEGER}," +
					"policy_name=#{policy_name,jdbcType=VARCHAR}," +
					"other_info=#{other_info,jdbcType=VARCHAR}," +
					"update_time=#{update_time,jdbcType=VARCHAR} where  reg_credit_no=#{reg_credit_no,jdbcType=VARCHAR}"
	})
	int enterpriseUpdateHighTech(CdmEntDtoHighTech cdmEntDtoHighTech);

	@Select({
			"select * from cdm_ent_dto_high_tech where reg_credit_no=#{reg_credit_no,jdbcType=VARCHAR}"
	})
	CdmEntDtoHighTech enterpriseSelectHighTech(CdmEntDtoHighTech cdmEntDtoHighTech);


	@Update({
			"update cdm_ent_dto_corp_info set gq_score=#{gqScore,jdbcType=INTEGER} where reg_credit_no=#{regCreditNo,jdbcType=VARCHAR}"
	})
	int updateGqScore(EnterpriseShowDTO enterpriseShowDTO);
}