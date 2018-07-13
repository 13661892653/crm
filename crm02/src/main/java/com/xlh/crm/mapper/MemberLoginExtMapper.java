package com.xlh.crm.mapper;

import com.xlh.crm.domain.MemberBaseInfo;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

/**
 * Created by heyuan on 2017/3/15.
 */
public interface MemberLoginExtMapper {
    //按域登录名进行查找
    @Select({
            "select",
            "rec_id, member_id, member_pwd, member_type, member_phone, email, ",
            "account_role, member_status, update_time,audit_status, user_name,company,province",
            "from dim_mbr_xlh_user_info",
            "where domain_user_name = #{domainUserName,jdbcType=VARCHAR}"
    })
    @Results({
            @Result(column="rec_id", property="recId", jdbcType= JdbcType.INTEGER, id=true),
            @Result(column="member_id", property="memberId", jdbcType=JdbcType.INTEGER),
            @Result(column="member_pwd", property="memberPwd", jdbcType=JdbcType.VARCHAR),
            @Result(column="member_type", property="memberType", jdbcType=JdbcType.VARCHAR),
            @Result(column="member_phone", property="memberPhone", jdbcType=JdbcType.VARCHAR),
            @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
            @Result(column="account_role", property="accountRole", jdbcType=JdbcType.VARCHAR),
            @Result(column="member_status", property="memberStatus", jdbcType=JdbcType.VARCHAR),
            @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="audit_status", property="auditStatus", jdbcType=JdbcType.INTEGER),
            @Result(column="user_name", property="userName", jdbcType=JdbcType.VARCHAR),
            @Result(column="company", property="company", jdbcType=JdbcType.VARCHAR),
            @Result(column="province", property="province", jdbcType=JdbcType.VARCHAR)
    })
    MemberBaseInfo selectByDomainUserName(String domainUserName);

    //按登录名进行查找
    @Select({
            "select",
            "rec_id, member_id, member_pwd, member_type, member_phone, email, ",
            "account_role, member_status, update_time,audit_status, user_name,company,province",
            "from dim_mbr_xlh_user_info",
            "where member_phone = #{memberPhone,jdbcType=VARCHAR}",
            "and member_status = '1'"
    })
    @Results({
            @Result(column="rec_id", property="recId", jdbcType= JdbcType.INTEGER, id=true),
            @Result(column="member_id", property="memberId", jdbcType=JdbcType.INTEGER),
            @Result(column="member_pwd", property="memberPwd", jdbcType=JdbcType.VARCHAR),
            @Result(column="member_type", property="memberType", jdbcType=JdbcType.VARCHAR),
            @Result(column="member_phone", property="memberPhone", jdbcType=JdbcType.VARCHAR),
            @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
            @Result(column="account_role", property="accountRole", jdbcType=JdbcType.VARCHAR),
            @Result(column="member_status", property="memberStatus", jdbcType=JdbcType.VARCHAR),
            @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="audit_status", property="auditStatus", jdbcType=JdbcType.INTEGER),
            @Result(column="user_name", property="userName", jdbcType=JdbcType.VARCHAR),
            @Result(column="company", property="company", jdbcType=JdbcType.VARCHAR),
            @Result(column="province", property="province", jdbcType=JdbcType.VARCHAR)
    })
    MemberBaseInfo selectByMemberPhone(String memberPhone);
}
