package com.xlh.crm.mapper;

import com.xlh.crm.dto.OrderShowDTO;
import com.xlh.crm.dto.PageReqDTO;
import com.xlh.crm.dto.ReachShowDTO;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface ReachMapper {

	//触达信息LIST查询
	@Results({
			@Result(column="ent_type", property="entType", jdbcType=JdbcType.VARCHAR),
			@Result(column="cust_type", property="custType", jdbcType=JdbcType.VARCHAR),
			@Result(column="rch_no", property="rchNo", jdbcType=JdbcType.VARCHAR),
			@Result(column="biz_lv1_id", property="bizLv1Id", jdbcType=JdbcType.VARCHAR),
			@Result(column="biz_lv2_id", property="bizLv2Id", jdbcType=JdbcType.VARCHAR),
			@Result(column="biz_lv1_name", property="bizLv1Name", jdbcType=JdbcType.VARCHAR),
			@Result(column="reg_credit_no", property="regCreditNo", jdbcType=JdbcType.VARCHAR),
			@Result(column="credit_no", property="creditNo", jdbcType=JdbcType.VARCHAR),
			@Result(column="reg_no", property="regNo", jdbcType=JdbcType.VARCHAR),
			@Result(column="enterprise_name", property="enterpriseName", jdbcType=JdbcType.VARCHAR),
			@Result(column="rch_mode", property="rchMode", jdbcType=JdbcType.VARCHAR),
			@Result(column="win_cust_chnl", property="winCustChnl", jdbcType=JdbcType.VARCHAR),
			@Result(column="begin_time", property="beginTime", jdbcType=JdbcType.VARCHAR),
			@Result(column="end_time", property="endTime", jdbcType=JdbcType.VARCHAR),
			@Result(column="contacts", property="contacts", jdbcType=JdbcType.VARCHAR),
			@Result(column="job_title", property="jobTitle", jdbcType=JdbcType.VARCHAR),
			@Result(column="contacts_phone", property="contactsPhone", jdbcType=JdbcType.VARCHAR),
			@Result(column="sales_lead", property="salesLead", jdbcType=JdbcType.VARCHAR),
			@Result(column="gov_line", property="govLine", jdbcType=JdbcType.VARCHAR),
			@Result(column="gov_level", property="govLevel", jdbcType=JdbcType.VARCHAR),
			@Result(column="gov_qzr", property="govQzr", jdbcType=JdbcType.VARCHAR),
			@Result(column="comm_topic", property="commTopic", jdbcType=JdbcType.VARCHAR),
			@Result(column="get_effect", property="getEffect", jdbcType=JdbcType.VARCHAR),
			@Result(column="result_time", property="resultTime", jdbcType=JdbcType.VARCHAR),
			@Result(column="cdn_things", property="cdnThings", jdbcType=JdbcType.VARCHAR),
			@Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
			@Result(column="rch_emp", property="rchEmp", jdbcType=JdbcType.VARCHAR),
			@Result(column="company", property="company", jdbcType=JdbcType.VARCHAR),
			@Result(column="reachcsr_times", property="reachcsrTimes", jdbcType=JdbcType.INTEGER),
			@Result(column="update_time", property="updateTime", jdbcType=JdbcType.VARCHAR),
			@Result(column="gq_score", property="gqScore", jdbcType=JdbcType.INTEGER)
	})
	@SelectProvider(type=ReachSqlProvider.class, method="getReachList")
	List<ReachShowDTO> getReachList(PageReqDTO reqdto);

	//计算筛选后触达信息总记录数，用于分页
	@SelectProvider(type=ReachSqlProvider.class, method="getReachListCount")
	Integer getReachListCount(PageReqDTO dto);

	//单个触达信息查询
	@Results({
			@Result(column="ent_type", property="entType", jdbcType=JdbcType.VARCHAR),
			@Result(column="cust_type", property="custType", jdbcType=JdbcType.VARCHAR),
			@Result(column="rch_no", property="rchNo", jdbcType=JdbcType.VARCHAR),
			@Result(column="company", property="company", jdbcType=JdbcType.VARCHAR),
			@Result(column="rch_emp", property="rchEmp", jdbcType=JdbcType.VARCHAR),
			@Result(column="biz_lv1_id", property="bizLv1Id", jdbcType=JdbcType.VARCHAR),
			@Result(column="biz_lv2_id", property="bizLv2Id", jdbcType=JdbcType.VARCHAR),
			@Result(column="enterprise_name", property="enterpriseName", jdbcType=JdbcType.VARCHAR),
			@Result(column="win_cust_chnl", property="winCustChnl", jdbcType=JdbcType.VARCHAR),
			@Result(column="rch_mode", property="rchMode", jdbcType=JdbcType.VARCHAR),
			@Result(column="begin_time", property="beginTime", jdbcType=JdbcType.VARCHAR),
			@Result(column="end_time", property="endTime", jdbcType=JdbcType.VARCHAR),
			@Result(column="contacts", property="contacts", jdbcType=JdbcType.VARCHAR),
			@Result(column="job_title", property="jobTitle", jdbcType=JdbcType.VARCHAR),
			@Result(column="contacts_phone", property="contactsPhone", jdbcType=JdbcType.VARCHAR),
			@Result(column="sales_lead", property="salesLead", jdbcType=JdbcType.VARCHAR),
			@Result(column="gov_line", property="govLine", jdbcType=JdbcType.VARCHAR),
			@Result(column="gov_level", property="govLevel", jdbcType=JdbcType.VARCHAR),
			@Result(column="gov_qzr", property="govQzr", jdbcType=JdbcType.VARCHAR),
			@Result(column="comm_topic", property="commTopic", jdbcType=JdbcType.VARCHAR),
			@Result(column="get_effect", property="getEffect", jdbcType=JdbcType.VARCHAR),
			@Result(column="result_time", property="resultTime", jdbcType=JdbcType.VARCHAR),
			@Result(column="cdn_things", property="cdnThings", jdbcType=JdbcType.VARCHAR),
			@Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
			@Result(column="update_time", property="updateTime", jdbcType=JdbcType.VARCHAR)
	})
	@SelectProvider(type=ReachSqlProvider.class, method="getReachByRchNo")
	ReachShowDTO getReachByRchNo(String rchNo);

	//触达信息入库
	@InsertProvider(type=ReachSqlProvider.class, method="insertReach")
	@Options(useGeneratedKeys = true, keyProperty = "rchNo", keyColumn = "rch_no")
	int insertReach(ReachShowDTO record);

	//更新触达
	@UpdateProvider(type=ReachSqlProvider.class, method="updateReach")
	int updateReach(ReachShowDTO form);

	@Select("select * from crm_reachcsr where update_id=#{updateId,jdbcType=VARCHAR}")
	List<ReachShowDTO> selectExistUpdateId(ReachShowDTO reachShowDTO);

}