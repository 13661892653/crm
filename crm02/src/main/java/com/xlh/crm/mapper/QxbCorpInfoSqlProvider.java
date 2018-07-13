package com.xlh.crm.mapper;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import com.xlh.crm.domain.QxbCorpInfo;

public class QxbCorpInfoSqlProvider {

    public String insertSelective(QxbCorpInfo record) {
        BEGIN();
        INSERT_INTO("qxb_corp_info");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getQxbId() != null) {
            VALUES("qxb_id", "#{qxbId,jdbcType=VARCHAR}");
        }
        
        if (record.getDtoId() != null) {
            VALUES("dto_id", "#{dtoId,jdbcType=INTEGER}");
        }
        
        if (record.getName() != null) {
            VALUES("name", "#{name,jdbcType=VARCHAR}");
        }
        
        if (record.getEconKind() != null) {
            VALUES("econ_kind", "#{econKind,jdbcType=VARCHAR}");
        }
        
        if (record.getRegistCapi() != null) {
            VALUES("regist_capi", "#{registCapi,jdbcType=VARCHAR}");
        }
        
        if (record.getAddress() != null) {
            VALUES("address", "#{address,jdbcType=VARCHAR}");
        }
        
        if (record.getRegNo() != null) {
            VALUES("reg_no", "#{regNo,jdbcType=VARCHAR}");
        }
        
        if (record.getScope() != null) {
            VALUES("scope", "#{scope,jdbcType=VARCHAR}");
        }
        
        if (record.getTermStart() != null) {
            VALUES("term_start", "#{termStart,jdbcType=VARCHAR}");
        }
        
        if (record.getTermEnd() != null) {
            VALUES("term_end", "#{termEnd,jdbcType=VARCHAR}");
        }
        
        if (record.getBelongOrg() != null) {
            VALUES("belong_org", "#{belongOrg,jdbcType=VARCHAR}");
        }
        
        if (record.getOperName() != null) {
            VALUES("oper_name", "#{operName,jdbcType=VARCHAR}");
        }
        
        if (record.getCheckDate() != null) {
            VALUES("check_date", "#{checkDate,jdbcType=VARCHAR}");
        }
        
        if (record.getStartDate() != null) {
            VALUES("start_date", "#{startDate,jdbcType=VARCHAR}");
        }
        
        if (record.getEndDate() != null) {
            VALUES("end_date", "#{endDate,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            VALUES("status", "#{status,jdbcType=VARCHAR}");
        }
        
        if (record.getOrgNo() != null) {
            VALUES("org_no", "#{orgNo,jdbcType=VARCHAR}");
        }
        
        if (record.getCreditNo() != null) {
            VALUES("credit_no", "#{creditNo,jdbcType=VARCHAR}");
        }
        
        if (record.getProvince() != null) {
            VALUES("province", "#{province,jdbcType=VARCHAR}");
        }
        
        if (record.getCity() != null) {
            VALUES("city", "#{city,jdbcType=VARCHAR}");
        }
        
        if (record.getDomains() != null) {
            VALUES("domains", "#{domains,jdbcType=VARCHAR}");
        }
        
        if (record.getContactAddress() != null) {
            VALUES("contact_address", "#{contactAddress,jdbcType=VARCHAR}");
        }
        
        if (record.getContactTelephone() != null) {
            VALUES("contact_telephone", "#{contactTelephone,jdbcType=VARCHAR}");
        }
        
        if (record.getContactEmail() != null) {
            VALUES("contact_email", "#{contactEmail,jdbcType=VARCHAR}");
        }
        
        if (record.getHasFinance() != null) {
            VALUES("has_finance", "#{hasFinance,jdbcType=TINYINT}");
        }
        
        if (record.getEnttime() != null) {
            VALUES("enttime", "#{enttime,jdbcType=INTEGER}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(QxbCorpInfo record) {
        BEGIN();
        UPDATE("qxb_corp_info");
        
        if (record.getDtoId() != null) {
            SET("dto_id = #{dtoId,jdbcType=INTEGER}");
        }
        
        if (record.getName() != null) {
            SET("name = #{name,jdbcType=VARCHAR}");
        }
        
        if (record.getEconKind() != null) {
            SET("econ_kind = #{econKind,jdbcType=VARCHAR}");
        }
        
        if (record.getRegistCapi() != null) {
            SET("regist_capi = #{registCapi,jdbcType=VARCHAR}");
        }
        
        if (record.getAddress() != null) {
            SET("address = #{address,jdbcType=VARCHAR}");
        }
        
        if (record.getRegNo() != null) {
            SET("reg_no = #{regNo,jdbcType=VARCHAR}");
        }
        
        if (record.getScope() != null) {
            SET("scope = #{scope,jdbcType=VARCHAR}");
        }
        
        if (record.getTermStart() != null) {
            SET("term_start = #{termStart,jdbcType=VARCHAR}");
        }
        
        if (record.getTermEnd() != null) {
            SET("term_end = #{termEnd,jdbcType=VARCHAR}");
        }
        
        if (record.getBelongOrg() != null) {
            SET("belong_org = #{belongOrg,jdbcType=VARCHAR}");
        }
        
        if (record.getOperName() != null) {
            SET("oper_name = #{operName,jdbcType=VARCHAR}");
        }
        
        if (record.getCheckDate() != null) {
            SET("check_date = #{checkDate,jdbcType=VARCHAR}");
        }
        
        if (record.getStartDate() != null) {
            SET("start_date = #{startDate,jdbcType=VARCHAR}");
        }
        
        if (record.getEndDate() != null) {
            SET("end_date = #{endDate,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            SET("status = #{status,jdbcType=VARCHAR}");
        }
        
        if (record.getOrgNo() != null) {
            SET("org_no = #{orgNo,jdbcType=VARCHAR}");
        }
        
        if (record.getCreditNo() != null) {
            SET("credit_no = #{creditNo,jdbcType=VARCHAR}");
        }
        
        if (record.getProvince() != null) {
            SET("province = #{province,jdbcType=VARCHAR}");
        }
        
        if (record.getCity() != null) {
            SET("city = #{city,jdbcType=VARCHAR}");
        }
        
        if (record.getDomains() != null) {
            SET("domains = #{domains,jdbcType=VARCHAR}");
        }
        
        if (record.getContactAddress() != null) {
            SET("contact_address = #{contactAddress,jdbcType=VARCHAR}");
        }
        
        if (record.getContactTelephone() != null) {
            SET("contact_telephone = #{contactTelephone,jdbcType=VARCHAR}");
        }
        
        if (record.getContactEmail() != null) {
            SET("contact_email = #{contactEmail,jdbcType=VARCHAR}");
        }
        
        if (record.getHasFinance() != null) {
            SET("has_finance = #{hasFinance,jdbcType=TINYINT}");
        }
        
        if (record.getEnttime() != null) {
            SET("enttime = #{enttime,jdbcType=INTEGER}");
        }
        
        WHERE("id = #{id,jdbcType=INTEGER}");
        WHERE("qxb_id = #{qxbId,jdbcType=VARCHAR}");
        
        return SQL();
    }
}