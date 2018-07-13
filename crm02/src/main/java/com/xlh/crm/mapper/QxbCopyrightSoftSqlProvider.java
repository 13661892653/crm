package com.xlh.crm.mapper;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import com.xlh.crm.domain.QxbCopyrightSoft;

public class QxbCopyrightSoftSqlProvider {

    public String insertSelective(QxbCopyrightSoft record) {
        BEGIN();
        INSERT_INTO("qxb_copyright_soft");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getQxbId() != null) {
            VALUES("qxb_id", "#{qxbId,jdbcType=VARCHAR}");
        }
        
        if (record.getZid() != null) {
            VALUES("zid", "#{zid,jdbcType=VARCHAR}");
        }
        
        if (record.getNumber() != null) {
            VALUES("number", "#{number,jdbcType=VARCHAR}");
        }
        
        if (record.getCompany() != null) {
            VALUES("company", "#{company,jdbcType=VARCHAR}");
        }
        
        if (record.getVersion() != null) {
            VALUES("version", "#{version,jdbcType=VARCHAR}");
        }
        
        if (record.getType() != null) {
            VALUES("type", "#{type,jdbcType=VARCHAR}");
        }
        
        if (record.getName() != null) {
            VALUES("name", "#{name,jdbcType=VARCHAR}");
        }
        
        if (record.getTypeName() != null) {
            VALUES("type_name", "#{typeName,jdbcType=VARCHAR}");
        }
        
        if (record.getSuccessDate() != null) {
            VALUES("success_date", "#{successDate,jdbcType=VARCHAR}");
        }
        
        if (record.getApprovalDate() != null) {
            VALUES("approval_date", "#{approvalDate,jdbcType=VARCHAR}");
        }
        
        if (record.getShortName() != null) {
            VALUES("short_name", "#{shortName,jdbcType=VARCHAR}");
        }
        
        if (record.getLastUpdatedTime() != null) {
            VALUES("last_updated_time", "#{lastUpdatedTime,jdbcType=VARCHAR}");
        }
        
        if (record.getTypeNum() != null) {
            VALUES("type_num", "#{typeNum,jdbcType=VARCHAR}");
        }
        
        if (record.getFirstDate() != null) {
            VALUES("first_date", "#{firstDate,jdbcType=VARCHAR}");
        }
        
        if (record.getEnttime() != null) {
            VALUES("enttime", "#{enttime,jdbcType=INTEGER}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(QxbCopyrightSoft record) {
        BEGIN();
        UPDATE("qxb_copyright_soft");
        
        if (record.getQxbId() != null) {
            SET("qxb_id = #{qxbId,jdbcType=VARCHAR}");
        }
        
        if (record.getZid() != null) {
            SET("zid = #{zid,jdbcType=VARCHAR}");
        }
        
        if (record.getNumber() != null) {
            SET("number = #{number,jdbcType=VARCHAR}");
        }
        
        if (record.getCompany() != null) {
            SET("company = #{company,jdbcType=VARCHAR}");
        }
        
        if (record.getVersion() != null) {
            SET("version = #{version,jdbcType=VARCHAR}");
        }
        
        if (record.getType() != null) {
            SET("type = #{type,jdbcType=VARCHAR}");
        }
        
        if (record.getName() != null) {
            SET("name = #{name,jdbcType=VARCHAR}");
        }
        
        if (record.getTypeName() != null) {
            SET("type_name = #{typeName,jdbcType=VARCHAR}");
        }
        
        if (record.getSuccessDate() != null) {
            SET("success_date = #{successDate,jdbcType=VARCHAR}");
        }
        
        if (record.getApprovalDate() != null) {
            SET("approval_date = #{approvalDate,jdbcType=VARCHAR}");
        }
        
        if (record.getShortName() != null) {
            SET("short_name = #{shortName,jdbcType=VARCHAR}");
        }
        
        if (record.getLastUpdatedTime() != null) {
            SET("last_updated_time = #{lastUpdatedTime,jdbcType=VARCHAR}");
        }
        
        if (record.getTypeNum() != null) {
            SET("type_num = #{typeNum,jdbcType=VARCHAR}");
        }
        
        if (record.getFirstDate() != null) {
            SET("first_date = #{firstDate,jdbcType=VARCHAR}");
        }
        
        if (record.getEnttime() != null) {
            SET("enttime = #{enttime,jdbcType=INTEGER}");
        }
        
        WHERE("id = #{id,jdbcType=INTEGER}");
        
        return SQL();
    }
}