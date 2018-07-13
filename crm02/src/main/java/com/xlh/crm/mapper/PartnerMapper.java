package com.xlh.crm.mapper;

import com.xlh.crm.dto.PageReqDTO;
import com.xlh.crm.dto.PartnerShowDTO;
import com.xlh.crm.dto.ReachShowDTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface PartnerMapper {

	@Results({
			@Result(column="company", property="company", jdbcType=JdbcType.VARCHAR),
			@Result(column="partner_id", property="partnerId", jdbcType=JdbcType.VARCHAR),
			@Result(column="partner_name", property="partnerName", jdbcType=JdbcType.VARCHAR),
			@Result(column="srv_area", property="srvArea", jdbcType=JdbcType.VARCHAR),
			@Result(column="category", property="category", jdbcType=JdbcType.VARCHAR),
			@Result(column="contact_person", property="contactPerson", jdbcType=JdbcType.VARCHAR),
			@Result(column="contact_phone", property="contactPhone", jdbcType=JdbcType.VARCHAR)
	})
	@SelectProvider(type=PartnerSqlProvider.class, method="getPartnerList")
	List<PartnerShowDTO> getPartnerList(String province,String company, String partnerType);

	@Results({
			@Result(column="rec_id", property="recId", jdbcType=JdbcType.VARCHAR),
			@Result(column="company", property="company", jdbcType=JdbcType.VARCHAR),
			@Result(column="partner_lv_id", property="partnerLvId", jdbcType=JdbcType.VARCHAR),
			@Result(column="partner_lv_desc", property="partnerLvDesc", jdbcType=JdbcType.VARCHAR),
			@Result(column="partner_type", property="partnerType", jdbcType=JdbcType.VARCHAR),
			@Result(column="credit_no", property="creditNo", jdbcType=JdbcType.VARCHAR),
			@Result(column="reg_no", property="regNo", jdbcType=JdbcType.VARCHAR),
			@Result(column="partner_id", property="partnerId", jdbcType=JdbcType.VARCHAR),
			@Result(column="partner_name", property="partnerName", jdbcType=JdbcType.VARCHAR),
			@Result(column="ent_address", property="entAddress", jdbcType=JdbcType.VARCHAR),
			@Result(column="office_address", property="officeAddress", jdbcType=JdbcType.VARCHAR),
			@Result(column="srv_area", property="srvArea", jdbcType=JdbcType.VARCHAR),
			@Result(column="biz_scope", property="bizScope", jdbcType=JdbcType.VARCHAR),
			@Result(column="fee_point", property="feePoint", jdbcType=JdbcType.VARCHAR),
			@Result(column="valid_flag", property="validFlag", jdbcType=JdbcType.VARCHAR),
			@Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
			@Result(column="join_time", property="joinTime", jdbcType=JdbcType.VARCHAR),
			@Result(column="rescind_time", property="rescindTime", jdbcType=JdbcType.VARCHAR),
			@Result(column="contract_no", property="contractNo", jdbcType=JdbcType.VARCHAR),
			@Result(column="category", property="category", jdbcType=JdbcType.VARCHAR),
			@Result(column="contact_person", property="contactPerson", jdbcType=JdbcType.VARCHAR),
			@Result(column="contact_phone", property="contactPhone", jdbcType=JdbcType.VARCHAR),
			@Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
			@Result(column="bank_account", property="bankAccount", jdbcType=JdbcType.VARCHAR)
	})
	@SelectProvider(type=PartnerSqlProvider.class, method="getPartnerBankList")
	List<PartnerShowDTO> getPartnerBankList(PageReqDTO req);

	//计算筛选后总记录数，用于分页
	@SelectProvider(type=PartnerSqlProvider.class, method="getPartnerBankListCount")
	Integer getPartnerBankListCount(PageReqDTO dto);

	//新增合作伙伴
	@Insert({
			"insert into crm_partner (",
			"company, partner_lv_id, partner_lv_desc, ",
			"partner_type, credit_no,reg_no,partner_id, ",
			"partner_name, ent_address,office_address,srv_area, ",
			"biz_scope, fee_point, valid_flag,",
			"remark, join_time,rescind_time,contract_no,",
			"category,contact_person,contact_phone,email,bank_account,update_time)",
			"values (#{company,jdbcType=VARCHAR}, #{partnerLvId,jdbcType=VARCHAR}, #{partnerLvDesc,jdbcType=DATE}, ",
			"#{partnerType,jdbcType=VARCHAR}, #{creditNo,jdbcType=VARCHAR}, #{regNo,jdbcType=VARCHAR}, #{partnerId,jdbcType=VARCHAR}, ",
			"#{partnerName,jdbcType=VARCHAR}, #{entAddress,jdbcType=VARCHAR}, #{officeAddress,jdbcType=VARCHAR}, #{srvArea,jdbcType=VARCHAR}, ",
			"#{bizScope,jdbcType=VARCHAR}, #{feePoint,jdbcType=VARCHAR}, ",
			"#{validFlag,jdbcType=VARCHAR},#{remark,jdbcType=VARCHAR}, #{joinTime,jdbcType=VARCHAR}, ",
			"#{rescindTime,jdbcType=VARCHAR},#{contractNo,jdbcType=VARCHAR}, #{category,jdbcType=VARCHAR}, ",
			"#{contactPerson,jdbcType=VARCHAR},#{contactPhone,jdbcType=VARCHAR}, #{email,jdbcType=VARCHAR}, #{bankAccount,jdbcType=VARCHAR}, #{updateTime,jdbcType=VARCHAR})",
	})
	int insertPartner(PartnerShowDTO record);
}