package com.xlh.crm.mapper;

import com.xlh.crm.dto.ActShowDTO;
import com.xlh.crm.dto.ContractShowDTO;
import com.xlh.crm.dto.PageReqDTO;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface ActMapper {

	//信息LIST查询
	@Results({
			@Result(column="rec_id", property="recId", jdbcType=JdbcType.VARCHAR),
			@Result(column="biz_lv1_id", property="bizLv1Id", jdbcType=JdbcType.VARCHAR),
			@Result(column="biz_lv1_name", property="bizLv1Name", jdbcType=JdbcType.VARCHAR),
			@Result(column="act_no", property="actNo", jdbcType=JdbcType.VARCHAR),
			@Result(column="company", property="company", jdbcType=JdbcType.VARCHAR),
			@Result(column="act_name", property="actName", jdbcType=JdbcType.VARCHAR),
			@Result(column="begin_time", property="beginTime", jdbcType=JdbcType.VARCHAR),
			@Result(column="end_time", property="endTime", jdbcType=JdbcType.VARCHAR),
			@Result(column="act_location", property="actLocation", jdbcType=JdbcType.VARCHAR),
			@Result(column="us_role", property="usRole", jdbcType=JdbcType.VARCHAR),
			@Result(column="us_role_desc", property="usRoleDesc", jdbcType=JdbcType.VARCHAR),
			@Result(column="act_type", property="actType", jdbcType=JdbcType.VARCHAR),
			@Result(column="act_type_desc", property="actTypeDesc", jdbcType=JdbcType.VARCHAR),
			@Result(column="co_partner", property="coPartner", jdbcType=JdbcType.VARCHAR),
			@Result(column="act_fee", property="actFee", jdbcType=JdbcType.DOUBLE),
			@Result(column="join_persons", property="joinPersons", jdbcType=JdbcType.INTEGER),
			@Result(column="operator", property="operator", jdbcType=JdbcType.VARCHAR),
			@Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
			@Result(column="link_address", property="linkAddress", jdbcType=JdbcType.VARCHAR),
			@Result(column="update_time", property="updateTime", jdbcType=JdbcType.VARCHAR)
	})
	@SelectProvider(type=ActSqlProvider.class, method="getActList")
	List<ActShowDTO> getActList(PageReqDTO reqdto);

	//计算信息总记录数，用于分页
	@SelectProvider(type=ActSqlProvider.class, method="getActListCount")
	Integer getActListCount(PageReqDTO dto);

	//单个合同查询
	@Results({
			@Result(column="rec_id", property="recId", jdbcType=JdbcType.VARCHAR),
			@Result(column="biz_lv1_id", property="bizLv1Id", jdbcType=JdbcType.VARCHAR),
			@Result(column="biz_lv1_name", property="bizLv1Name", jdbcType=JdbcType.VARCHAR),
			@Result(column="act_no", property="actNo", jdbcType=JdbcType.VARCHAR),
			@Result(column="company", property="company", jdbcType=JdbcType.VARCHAR),
			@Result(column="act_name", property="actName", jdbcType=JdbcType.VARCHAR),
			@Result(column="begin_time", property="beginTime", jdbcType=JdbcType.VARCHAR),
			@Result(column="end_time", property="endTime", jdbcType=JdbcType.VARCHAR),
			@Result(column="act_location", property="actLocation", jdbcType=JdbcType.VARCHAR),
			@Result(column="us_role", property="usRole", jdbcType=JdbcType.VARCHAR),
			@Result(column="us_role_desc", property="usRoleDesc", jdbcType=JdbcType.VARCHAR),
			@Result(column="act_type", property="actType", jdbcType=JdbcType.VARCHAR),
			@Result(column="act_type_desc", property="actTypeDesc", jdbcType=JdbcType.VARCHAR),
			@Result(column="co_partner", property="coPartner", jdbcType=JdbcType.VARCHAR),
			@Result(column="act_fee", property="actFee", jdbcType=JdbcType.DOUBLE),
			@Result(column="join_persons", property="joinPersons", jdbcType=JdbcType.INTEGER),
			@Result(column="operator", property="operator", jdbcType=JdbcType.VARCHAR),
			@Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
			@Result(column="link_address", property="linkAddress", jdbcType=JdbcType.VARCHAR),
			@Result(column="update_time", property="updateTime", jdbcType=JdbcType.VARCHAR)
	})
	@SelectProvider(type=ActSqlProvider.class, method="getActByActNo")
	ActShowDTO getActByActNo(String actNo);

	//信息入库
	@Insert({
			"insert into crm_active (",
			"biz_lv1_id, ",
			"biz_lv1_name, ",
			"company, ",
			"act_no, ",
			"act_name, ",
			"begin_time, ",
			"end_time, ",
			"us_role, ",
			"act_type, ",
			"act_location, ",
			"co_partner, ",
			"act_fee, ",
			"join_persons, ",
			"operator, ",
			"remark, ",
			"excel_json, ",
			"image_json, ",
			"link_address, ",
			"update_time)",
			"values (",
			"#{bizLv1Id,jdbcType=VARCHAR}, ",
			"#{bizLv1Name,jdbcType=VARCHAR}, ",
			"#{company,jdbcType=VARCHAR}, ",
			"#{actNo,jdbcType=VARCHAR}, ",
			"#{actName,jdbcType=VARCHAR}, ",
			"#{beginTime,jdbcType=VARCHAR}, ",
			"#{endTime,jdbcType=VARCHAR}, ",
			"#{usRole,jdbcType=VARCHAR}, ",
			"#{actType,jdbcType=VARCHAR}, ",
			"#{actLocation,jdbcType=VARCHAR}, ",
			"#{coPartner,jdbcType=VARCHAR}, ",
			"#{actFee,jdbcType=DOUBLE}, ",
			"#{joinPersons,jdbcType=INTEGER}, ",
			"#{operator,jdbcType=VARCHAR}, ",
			"#{remark,jdbcType=VARCHAR}, ",
			"#{excelJson,jdbcType=VARCHAR}, ",
			"#{imageJson,jdbcType=VARCHAR}, ",
			"#{linkAddress,jdbcType=DOUBLE}, ",
			"#{updateTime,jdbcType=VARCHAR})"
	})
	@Options(useGeneratedKeys = true, keyProperty = "recId",keyColumn="rec_id")
	int insertAct(ActShowDTO record);

}