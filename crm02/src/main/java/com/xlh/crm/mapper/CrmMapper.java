package com.xlh.crm.mapper;

import com.xlh.crm.dto.MemberInfoDTO;
import com.xlh.crm.dto.OperationLogDTO;
import com.xlh.crm.dto.PageReqDTO;
import com.xlh.crm.dto.UserListRespDTO;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface CrmMapper {

	//获取登录用户信息
	@Select({
			"select member_id, member_type, member_phone,province,account_role,company,user_name,email,audit_status",
			"from dim_mbr_xlh_user_info",
			"where user_name = #{userName,jdbcType=VARCHAR}"
	})
	@Results({
			@Result(column="member_id", property="memberId", jdbcType= JdbcType.VARCHAR),
			@Result(column="member_type", property="memberType", jdbcType=JdbcType.VARCHAR),
			@Result(column="member_phone", property="memberPhone", jdbcType=JdbcType.VARCHAR),
			@Result(column="province", property="province", jdbcType=JdbcType.VARCHAR),
			@Result(column="account_role", property="accountRole", jdbcType=JdbcType.VARCHAR),
			@Result(column="company", property="company", jdbcType=JdbcType.VARCHAR),
			@Result(column="user_name", property="userName", jdbcType=JdbcType.VARCHAR),
			@Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
			@Result(column="audit_status", property="auditStatus", jdbcType=JdbcType.VARCHAR)
	})
	MemberInfoDTO getMemberInfo(String userName);

	//记录系统操作日志
	@Insert({
			"insert into crm_operation_log (",
			"operation_time, operator, ",
			"event_type, module, ",
			"operation_desc)",
			"values (#{operationTime,jdbcType=VARCHAR}, #{operator,jdbcType=VARCHAR}, ",
			"#{eventType,jdbcType=VARCHAR}, #{module,jdbcType=VARCHAR}, ",
			"#{operationDesc,jdbcType=VARCHAR})"
	})
	int insertOperationLog(OperationLogDTO record);

	//重置密码
	@Update({
			"update dim_mbr_xlh_user_info "+
					"set member_pwd = #{memberPwd,jdbcType=VARCHAR} "+
					" where member_phone = #{memberPhone,jdbcType=VARCHAR}"
	})
	int uptPassword(MemberInfoDTO form);

	//获取用户列表
	@Select({
			"select",
			"rec_id, member_id, member_pwd, member_type, member_phone, email, province, ",
			"account_role, member_status, update_time,audit_status, user_name,company",
			"from dim_mbr_xlh_user_info",
			"order by cast(member_type as SIGNED) asc,province asc,company asc"
	})
	@Results({
			@Result(column="rec_id", property="recId", jdbcType= JdbcType.INTEGER, id=true),
			@Result(column="member_id", property="memberId", jdbcType=JdbcType.INTEGER),
			@Result(column="member_pwd", property="memberPwd", jdbcType=JdbcType.VARCHAR),
			@Result(column="member_type", property="memberType", jdbcType=JdbcType.VARCHAR),
			@Result(column="member_phone", property="memberPhone", jdbcType=JdbcType.VARCHAR),
			@Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
			@Result(column="province", property="province", jdbcType=JdbcType.VARCHAR),
			@Result(column="account_role", property="accountRole", jdbcType=JdbcType.VARCHAR),
			@Result(column="member_status", property="memberStatus", jdbcType=JdbcType.VARCHAR),
			@Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
			@Result(column="audit_status", property="auditStatus", jdbcType=JdbcType.INTEGER),
			@Result(column="user_name", property="userName", jdbcType=JdbcType.VARCHAR),
			@Result(column="company", property="company", jdbcType=JdbcType.VARCHAR)
	})
	List<MemberInfoDTO> getUserList(PageReqDTO req);

	//获取单个用户信息
	@Select({
			"select",
			"rec_id, member_id, member_pwd, member_type, member_phone, email, province, ",
			"account_role, member_status, update_time,audit_status, user_name,company",
			"from dim_mbr_xlh_user_info",
			"where member_phone = #{memberPhone,jdbcType=VARCHAR}"
	})
	@Results({
			@Result(column="rec_id", property="recId", jdbcType= JdbcType.INTEGER, id=true),
			@Result(column="member_id", property="memberId", jdbcType=JdbcType.INTEGER),
			@Result(column="member_pwd", property="memberPwd", jdbcType=JdbcType.VARCHAR),
			@Result(column="member_type", property="memberType", jdbcType=JdbcType.VARCHAR),
			@Result(column="member_phone", property="memberPhone", jdbcType=JdbcType.VARCHAR),
			@Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
			@Result(column="province", property="province", jdbcType=JdbcType.VARCHAR),
			@Result(column="account_role", property="accountRole", jdbcType=JdbcType.VARCHAR),
			@Result(column="member_status", property="memberStatus", jdbcType=JdbcType.VARCHAR),
			@Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
			@Result(column="audit_status", property="auditStatus", jdbcType=JdbcType.INTEGER),
			@Result(column="user_name", property="userName", jdbcType=JdbcType.VARCHAR),
			@Result(column="company", property="company", jdbcType=JdbcType.VARCHAR)
	})
	MemberInfoDTO getUserInfo(String memberPhone);

	//新增用户信息
	@Insert({
			"replace into dim_mbr_xlh_user_info (",
			"member_id, ",
			"member_phone, ",
			"member_pwd, ",
			"user_name, ",
			"province, ",
			"company, ",
			"email, ",
			"account_role, ",
			"member_status, ",
			"audit_status, ",
			"member_type, ",
			"update_time)",
			"values (",
			"#{memberId,jdbcType=VARCHAR},",
			"#{memberPhone,jdbcType=VARCHAR},",
			"#{memberPwd,jdbcType=VARCHAR},",
			"#{userName,jdbcType=VARCHAR}, ",
			"#{province,jdbcType=VARCHAR}, ",
			"#{company,jdbcType=VARCHAR}, ",
			"#{email,jdbcType=VARCHAR}, ",
			"#{accountRole,jdbcType=VARCHAR}, ",
			"#{memberStatus,jdbcType=VARCHAR}, ",
			"#{auditStatus,jdbcType=INTEGER}, ",
			"#{memberType,jdbcType=VARCHAR}, ",
			"#{updateTime,jdbcType=VARCHAR})"
	})
	int insertUser(MemberInfoDTO form);

	//更新用户信息
	@Update({
			"update dim_mbr_xlh_user_info",
			"set province = #{province,jdbcType=VARCHAR},",
			"company = #{company,jdbcType=VARCHAR},",
			"email = #{email,jdbcType=VARCHAR},",
			"account_role = #{accountRole,jdbcType=VARCHAR},",
			"member_status = #{memberStatus,jdbcType=VARCHAR},",
			"member_type = #{memberType,jdbcType=VARCHAR},",
			"update_time = #{updateTime,jdbcType=VARCHAR}",
			"where member_phone = #{memberPhone,jdbcType=VARCHAR}"
	})
	int updateUser(MemberInfoDTO form);

	@Select("select * from crm_operation_log where id=#{updateId,jdbcType=INTEGER} and module like '%企业档案%' ")
	@Results({
			@Result(column="id", property="id", jdbcType= JdbcType.INTEGER),
			@Result(column="operation_time", property="operationTime", jdbcType=JdbcType.VARCHAR),
			@Result(column="operator", property="operator", jdbcType=JdbcType.VARCHAR),
			@Result(column="event_type", property="eventType", jdbcType=JdbcType.VARCHAR),
			@Result(column="module", property="module", jdbcType=JdbcType.VARCHAR),
			@Result(column="operation_desc", property="operationDesc", jdbcType=JdbcType.VARCHAR),

	})
	OperationLogDTO selectLogById(String updateId);

}