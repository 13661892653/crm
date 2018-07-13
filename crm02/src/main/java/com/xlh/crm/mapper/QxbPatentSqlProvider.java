package com.xlh.crm.mapper;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import com.xlh.crm.domain.QxbPatent;

public class QxbPatentSqlProvider {

    public String insertSelective(QxbPatent record) {
        BEGIN();
        INSERT_INTO("qxb_patent");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getQxbId() != null) {
            VALUES("qxb_id", "#{qxbId,jdbcType=VARCHAR}");
        }
        
        if (record.getPatentName() != null) {
            VALUES("patent_name", "#{patentName,jdbcType=VARCHAR}");
        }
        
        if (record.getTypeName() != null) {
            VALUES("type_name", "#{typeName,jdbcType=VARCHAR}");
        }
        
        if (record.getRequestDate() != null) {
            VALUES("request_date", "#{requestDate,jdbcType=VARCHAR}");
        }
        
        if (record.getRequestNum() != null) {
            VALUES("request_num", "#{requestNum,jdbcType=VARCHAR}");
        }
        
        if (record.getOuthorNum() != null) {
            VALUES("outhor_num", "#{outhorNum,jdbcType=VARCHAR}");
        }
        
        if (record.getDesigner() != null) {
            VALUES("designer", "#{designer,jdbcType=VARCHAR}");
        }
        
        if (record.getCategoryNum() != null) {
            VALUES("category_num", "#{categoryNum,jdbcType=VARCHAR}");
        }
        
        if (record.getBrief() != null) {
            VALUES("brief", "#{brief,jdbcType=VARCHAR}");
        }
        
        if (record.getOuthorDate() != null) {
            VALUES("outhor_date", "#{outhorDate,jdbcType=VARCHAR}");
        }
        
        if (record.getEnttime() != null) {
            VALUES("enttime", "#{enttime,jdbcType=INTEGER}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(QxbPatent record) {
        BEGIN();
        UPDATE("qxb_patent");
        
        if (record.getQxbId() != null) {
            SET("qxb_id = #{qxbId,jdbcType=VARCHAR}");
        }
        
        if (record.getPatentName() != null) {
            SET("patent_name = #{patentName,jdbcType=VARCHAR}");
        }
        
        if (record.getTypeName() != null) {
            SET("type_name = #{typeName,jdbcType=VARCHAR}");
        }
        
        if (record.getRequestDate() != null) {
            SET("request_date = #{requestDate,jdbcType=VARCHAR}");
        }
        
        if (record.getRequestNum() != null) {
            SET("request_num = #{requestNum,jdbcType=VARCHAR}");
        }
        
        if (record.getOuthorNum() != null) {
            SET("outhor_num = #{outhorNum,jdbcType=VARCHAR}");
        }
        
        if (record.getDesigner() != null) {
            SET("designer = #{designer,jdbcType=VARCHAR}");
        }
        
        if (record.getCategoryNum() != null) {
            SET("category_num = #{categoryNum,jdbcType=VARCHAR}");
        }
        
        if (record.getBrief() != null) {
            SET("brief = #{brief,jdbcType=VARCHAR}");
        }
        
        if (record.getOuthorDate() != null) {
            SET("outhor_date = #{outhorDate,jdbcType=VARCHAR}");
        }
        
        if (record.getEnttime() != null) {
            SET("enttime = #{enttime,jdbcType=INTEGER}");
        }
        
        WHERE("id = #{id,jdbcType=INTEGER}");
        
        return SQL();
    }
}