package com.xlh.crm.mapper;

import java.util.List;

import com.xlh.crm.domain.EnterpriseTag;
import com.xlh.crm.domain.MemberBaseInfo;
import com.xlh.crm.dto.*;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

public interface EnterpriseMapper {

	@Select({
			"select",
			"assets_type, assets_type_desc, assets_tag_code, assets_tag_desc, tag_level",
			"from dim_ent_enterprise_tag",
			"where valid_flag = 'Y'",
			"and assets_tag_code not in ('4001','4002','4003')",
			"order by assets_tag_code asc"
	})
	@Results({
			@Result(column="assets_type", property="assetsType", jdbcType=JdbcType.VARCHAR, id=true),
			@Result(column="assets_type_desc", property="assetsTypeDesc", jdbcType=JdbcType.VARCHAR),
			@Result(column="assets_tag_code", property="assetsTagCode", jdbcType=JdbcType.VARCHAR),
			@Result(column="assets_tag_desc", property="assetsTagDesc", jdbcType=JdbcType.VARCHAR),
			@Result(column="tag_level", property="tagLevel", jdbcType=JdbcType.VARCHAR)
	})
	List<EnterpriseTag> selectEntTag();

	@Select({
			"select",
			"max(t1.reg_credit_no) as reg_credit_no,max(t1.reg_no) as reg_no, max(t1.credit_no) as credit_no, max(t1.enterprise_name) as enterprise_name,max(t1.ent_address) as ent_address,count(1) as rec_cnt",
			"from (",
			"select reg_credit_no,reg_no, credit_no, enterprise_name,ent_address",
			"from cdm_ent_dto_corp_info",
			"where enterprise_name = #{corpName,jdbcType=VARCHAR}",
			"union all",
			"select concat(reg_no,credit_no) as reg_credit_no,reg_no,credit_no,name as enterprise_name,contact_address as ent_address",
			"from qxb_corp_info",
			"where name = #{corpName,jdbcType=VARCHAR}",
			") t1"
	})
	@Results({
			@Result(column="reg_credit_no", property="regCreditNo", jdbcType=JdbcType.VARCHAR),
			@Result(column="reg_no", property="regNo", jdbcType=JdbcType.VARCHAR),
			@Result(column="credit_no", property="creditNo", jdbcType=JdbcType.VARCHAR),
			@Result(column="enterprise_name", property="enterpriseName", jdbcType=JdbcType.VARCHAR),
			@Result(column="ent_address", property="entAddress", jdbcType=JdbcType.VARCHAR),
			@Result(column="rec_cnt", property="recCnt", jdbcType=JdbcType.VARCHAR)
	})
	EnterpriseShowDTO selectByFullName(String corpName);

	@Results({
			@Result(column="reg_credit_no", property="regCreditNo", jdbcType=JdbcType.VARCHAR),
			@Result(column="reg_no", property="regNo", jdbcType=JdbcType.VARCHAR),
			@Result(column="credit_no", property="creditNo", jdbcType=JdbcType.VARCHAR),
			@Result(column="enterprise_name", property="enterpriseName", jdbcType=JdbcType.VARCHAR),
			@Result(column="mat_comp_score", property="matCompScore", jdbcType=JdbcType.VARCHAR),
			@Result(column="is_have_finance", property="isHaveFinance", jdbcType=JdbcType.VARCHAR),
			@Result(column="industry_name", property="industryName", jdbcType=JdbcType.VARCHAR),
			@Result(column="cust_manager", property="custManager", jdbcType=JdbcType.VARCHAR),
			@Result(column="fav_user_list", property="favUserList", jdbcType=JdbcType.VARCHAR),
			@Result(column="rec_cnt", property="recCnt", jdbcType=JdbcType.VARCHAR)
	})
	@SelectProvider(type=EnterpriseSqlProvider.class, method="selectByRegCreditNo")
	EnterpriseShowDTO selectByRegCreditNo(PageReqDTO req);

	//企业收藏列表
	@Results({
			@Result(column="fav_id", property="favId", jdbcType=JdbcType.VARCHAR),
			@Result(column="reg_credit_no", property="regCreditNo", jdbcType=JdbcType.VARCHAR),
			@Result(column="reg_no", property="regNo", jdbcType=JdbcType.VARCHAR),
			@Result(column="credit_no", property="creditNo", jdbcType=JdbcType.VARCHAR),
			@Result(column="enterprise_name", property="enterpriseName", jdbcType=JdbcType.VARCHAR),
			@Result(column="mat_comp_score", property="matCompScore", jdbcType=JdbcType.VARCHAR),
			@Result(column="is_have_finance", property="isHaveFinance", jdbcType=JdbcType.VARCHAR),
			@Result(column="industry_name", property="industryName", jdbcType=JdbcType.VARCHAR),
			@Result(column="cust_manager", property="custManager", jdbcType=JdbcType.VARCHAR),
			@Result(column="ent_type", property="entType", jdbcType=JdbcType.VARCHAR),
			@Result(column="fav_user_list", property="favUserList", jdbcType=JdbcType.VARCHAR),
			@Result(column="company", property="company", jdbcType=JdbcType.VARCHAR)
	})
	@SelectProvider(type=EnterpriseSqlProvider.class, method="getEnterpriseFavList")
	List<EnterpriseShowDTO> getEnterpriseFavList(PageReqDTO req);

	//计算企业收藏夹总记录数，用于分页
	@SelectProvider(type=EnterpriseSqlProvider.class, method="getFavListCount")
	Integer getFavListCount(PageReqDTO dto);

	//档案更新企业列表
	@Results({
			@Result(column="id", property="id", jdbcType=JdbcType.INTEGER),
			@Result(column="reg_credit_no", property="regCreditNo", jdbcType=JdbcType.VARCHAR),
			@Result(column="reg_no", property="regNo", jdbcType=JdbcType.VARCHAR),
			@Result(column="credit_no", property="creditNo", jdbcType=JdbcType.VARCHAR),
			@Result(column="reg_credit_no", property="regCreditNo", jdbcType=JdbcType.VARCHAR),
			@Result(column="enterprise_name", property="enterpriseName", jdbcType=JdbcType.VARCHAR),
			@Result(column="archives_editor", property="archivesEditor", jdbcType=JdbcType.VARCHAR),
			@Result(column="company", property="company", jdbcType=JdbcType.VARCHAR),
			@Result(column="edit_module", property="editModule", jdbcType=JdbcType.VARCHAR),
			@Result(column="update_time", property="updateTime", jdbcType=JdbcType.VARCHAR)
	})
	@SelectProvider(type=EnterpriseSqlProvider.class, method="getEnterpriseUptList")
	List<EnterpriseShowDTO> getEnterpriseUptList(PageReqDTO req);

	//计算档案更新企业总记录数，用于分页
	@SelectProvider(type=EnterpriseSqlProvider.class, method="getUptListCount")
	Integer getUptListCount(PageReqDTO dto);

	@Results({
			@Result(column="member_phone", property="memberPhone", jdbcType=JdbcType.VARCHAR),
			@Result(column="user_name", property="userName", jdbcType=JdbcType.VARCHAR),
			@Result(column="company", property="company", jdbcType=JdbcType.VARCHAR),
			@Result(column="member_id", property="memberId", jdbcType=JdbcType.INTEGER)
	})
	@SelectProvider(type=EnterpriseSqlProvider.class, method="getCompanyUserList")
	List<MemberBaseInfo> getCompanyUserList(String company);

	@Results({
			@Result(column="rec_id", property="recId", jdbcType=JdbcType.VARCHAR),
			@Result(column="biz_lv1_id", property="bizLv1Id", jdbcType=JdbcType.VARCHAR),
			@Result(column="biz_lv1_name", property="bizLv1Name", jdbcType=JdbcType.VARCHAR),
			@Result(column="biz_lv2_id", property="bizLv2Id", jdbcType=JdbcType.VARCHAR),
			@Result(column="biz_lv2_name", property="bizLv2Name", jdbcType=JdbcType.VARCHAR),
			@Result(column="biz_lv3_id", property="bizLv3Id", jdbcType=JdbcType.VARCHAR),
			@Result(column="biz_lv3_name", property="bizLv3Name", jdbcType=JdbcType.VARCHAR),
			@Result(column="product_id", property="productId", jdbcType=JdbcType.VARCHAR),
			@Result(column="product_name", property="productName", jdbcType=JdbcType.VARCHAR),
			@Result(column="price", property="price", jdbcType=JdbcType.VARCHAR),
			@Result(column="valid_flag", property="validFlag", jdbcType=JdbcType.VARCHAR),
			@Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR)
	})
	@SelectProvider(type=EnterpriseSqlProvider.class, method="getProductList")
	List<ProductShowDTO> getProductList(String company);

	@Results({
			@Result(column="reg_credit_no", property="regCreditNo", jdbcType=JdbcType.VARCHAR, id=true),
			@Result(column="reg_no", property="regNo", jdbcType=JdbcType.VARCHAR, id=true),
			@Result(column="credit_no", property="creditNo", jdbcType=JdbcType.VARCHAR),
			@Result(column="enterprise_name", property="enterpriseName", jdbcType=JdbcType.VARCHAR),
			@Result(column="mat_comp_score", property="matCompScore", jdbcType=JdbcType.INTEGER),
			@Result(column="is_have_finance", property="isHaveFinance", jdbcType=JdbcType.VARCHAR),
			@Result(column="area_province", property="areaProvince", jdbcType=JdbcType.VARCHAR),
			@Result(column="area_city", property="areaCity", jdbcType=JdbcType.VARCHAR),
			@Result(column="industry_type_code", property="industryTypeCode", jdbcType=JdbcType.VARCHAR),
			@Result(column="industry_type_name", property="industryTypeName", jdbcType=JdbcType.VARCHAR),
			@Result(column="industry_code", property="industryCode", jdbcType=JdbcType.VARCHAR),
			@Result(column="industry_name", property="industryName", jdbcType=JdbcType.VARCHAR),
			@Result(column="create_date", property="createDate", jdbcType=JdbcType.DATE),
			@Result(column="register_money", property="registerMoney", jdbcType=JdbcType.VARCHAR),
			@Result(column="mgmt_status", property="mgmtStatus", jdbcType=JdbcType.VARCHAR),
			@Result(column="corp_info", property="corpInfo", jdbcType=JdbcType.VARCHAR),
			@Result(column="legal_representative", property="legalRepresentative", jdbcType=JdbcType.VARCHAR),
			@Result(column="ent_address", property="entAddress", jdbcType=JdbcType.VARCHAR),
			@Result(column="assets_category_code", property="assetsCategoryCode", jdbcType=JdbcType.VARCHAR),
			@Result(column="assets_category", property="assetsCategory", jdbcType=JdbcType.VARCHAR),
			@Result(column="assets_level", property="assetsLevel", jdbcType=JdbcType.VARCHAR),
			@Result(column="assets_source_code", property="assetsSourceCode", jdbcType=JdbcType.VARCHAR),
			@Result(column="assets_source_desc", property="assetsSourceDesc", jdbcType=JdbcType.VARCHAR),
			@Result(column="hot_index", property="hotIndex", jdbcType=JdbcType.INTEGER),
			@Result(column="tag_array", property="tagArray", jdbcType=JdbcType.VARCHAR),
			@Result(column="valid_flag", property="validFlag", jdbcType=JdbcType.VARCHAR),
			@Result(column="event_id", property="eventId", jdbcType=JdbcType.VARCHAR),
			@Result(column="is_have_finance", property="isHaveFinance", jdbcType=JdbcType.VARCHAR),
			@Result(column="gq_score", property="gqScore", jdbcType=JdbcType.INTEGER)
	})
	@SelectProvider(type=EnterpriseSqlProvider.class, method="getEnterpriseBankList")
	List<EnterpriseShowDTO> getEnterpriseBankList(PageReqDTO reqdto);

	//计算筛选后企业库总记录数，用于分页
	@SelectProvider(type=EnterpriseSqlProvider.class, method="getEnterpriseBankListCount")
	Integer getEnterpriseBankListCount(PageReqDTO dto);

	@Results({
			@Result(column="reg_no", property="regNo", jdbcType=JdbcType.VARCHAR, id=true),
			@Result(column="credit_no", property="creditNo", jdbcType=JdbcType.VARCHAR),
			@Result(column="enterprise_name", property="enterpriseName", jdbcType=JdbcType.VARCHAR),
			@Result(column="mat_comp_rate", property="matCompRate", jdbcType=JdbcType.DOUBLE),
			@Result(column="area_province", property="areaProvince", jdbcType=JdbcType.VARCHAR),
			@Result(column="area_city", property="areaCity", jdbcType=JdbcType.VARCHAR),
			@Result(column="industry_type_code", property="industryTypeCode", jdbcType=JdbcType.VARCHAR),
			@Result(column="industry_type_name", property="industryTypeName", jdbcType=JdbcType.VARCHAR),
			@Result(column="industry_code", property="industryCode", jdbcType=JdbcType.VARCHAR),
			@Result(column="industry_name", property="industryName", jdbcType=JdbcType.VARCHAR),
			@Result(column="create_date", property="createDate", jdbcType=JdbcType.DATE),
			@Result(column="register_money", property="registerMoney", jdbcType=JdbcType.VARCHAR),
			@Result(column="mgmt_status", property="mgmtStatus", jdbcType=JdbcType.VARCHAR),
			@Result(column="corp_info", property="corpInfo", jdbcType=JdbcType.VARCHAR),
			@Result(column="contact_fixed_phone", property="contactFixedPhone", jdbcType=JdbcType.VARCHAR),
			@Result(column="contact_mobi_phone", property="contactMobiPhone", jdbcType=JdbcType.VARCHAR),
			@Result(column="legal_representative", property="legalRepresentative", jdbcType=JdbcType.VARCHAR),
			@Result(column="ent_address", property="entAddress", jdbcType=JdbcType.VARCHAR),
			@Result(column="contact_person", property="contactPerson", jdbcType=JdbcType.VARCHAR),
			@Result(column="assets_category_code", property="assetsCategoryCode", jdbcType=JdbcType.VARCHAR),
			@Result(column="assets_category", property="assetsCategory", jdbcType=JdbcType.VARCHAR),
			@Result(column="assets_level", property="assetsLevel", jdbcType=JdbcType.VARCHAR),
			@Result(column="assets_source_code", property="assetsSourceCode", jdbcType=JdbcType.VARCHAR),
			@Result(column="assets_source_desc", property="assetsSourceDesc", jdbcType=JdbcType.VARCHAR),
			@Result(column="hot_index", property="hotIndex", jdbcType=JdbcType.INTEGER),
			@Result(column="tag_array", property="tagArray", jdbcType=JdbcType.VARCHAR),
			@Result(column="valid_flag", property="validFlag", jdbcType=JdbcType.VARCHAR),
			@Result(column="event_id", property="eventId", jdbcType=JdbcType.VARCHAR)
	})
	@SelectProvider(type=EnterpriseSqlProvider.class, method="getProjectBankList")
	List<ProjectBankShowDTO> getProjectBankList(PageReqDTO reqdto);

	@Results({
			@Result(column="tr_date", property="trDate", jdbcType=JdbcType.VARCHAR),
			@Result(column="product_name", property="productName", jdbcType=JdbcType.VARCHAR),
			@Result(column="enterprise_name", property="enterpriseName", jdbcType=JdbcType.VARCHAR),
			@Result(column="rounds", property="rounds", jdbcType=JdbcType.VARCHAR),
			@Result(column="tr_amt", property="trAmt", jdbcType=JdbcType.VARCHAR),
			@Result(column="industry", property="industry", jdbcType=JdbcType.VARCHAR),
			@Result(column="investment", property="investment", jdbcType=JdbcType.VARCHAR),
			@Result(column="area", property="area", jdbcType=JdbcType.VARCHAR),
			@Result(column="mark", property="mark", jdbcType=JdbcType.VARCHAR),
	})
	@SelectProvider(type=EnterpriseSqlProvider.class, method="getInvEventList")
	List<InvEventShowDTO> getInvEventList(PageReqDTO reqdto);

	//计算筛选后投融资事件总记录数，用于分页
	@SelectProvider(type=EnterpriseSqlProvider.class, method="getInvEventListCount")
	Integer getInvEventListCount(PageReqDTO dto);

	//修改客户经理
	@Update({
			"update cdm_ent_dto_corp_info_ext "+
					"set cust_manager = #{userName,jdbcType=VARCHAR} "+
					",update_time = #{updateTime,jdbcType=VARCHAR}" +
					" where reg_credit_no = #{regCreditNo,jdbcType=VARCHAR}"
	})
	int uptCustManager(EnterpriseBaseInfoRespDTO form);


}