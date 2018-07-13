package com.xlh.crm.mapper;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import com.xlh.crm.domain.QxbAbnormalItem;

public class QxbAbnormalItemSqlProvider {

    public String insertSelective(QxbAbnormalItem record) {
        BEGIN();
        INSERT_INTO("qxb_abnormal_item");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getDtoId() != null) {
            VALUES("dto_id", "#{dtoId,jdbcType=INTEGER}");
        }
        
        if (record.getQxbId() != null) {
            VALUES("qxb_id", "#{qxbId,jdbcType=VARCHAR}");
        }
        
        if (record.getInReason() != null) {
            VALUES("in_reason", "#{inReason,jdbcType=VARCHAR}");
        }
        
        if (record.getInDate() != null) {
            VALUES("in_date", "#{inDate,jdbcType=VARCHAR}");
        }
        
        if (record.getDepartment() != null) {
            VALUES("department", "#{department,jdbcType=VARCHAR}");
        }
        
        if (record.getOutReason() != null) {
            VALUES("out_reason", "#{outReason,jdbcType=VARCHAR}");
        }
        
        if (record.getOutDate() != null) {
            VALUES("out_date", "#{outDate,jdbcType=VARCHAR}");
        }
        
        if (record.getEnttime() != null) {
            VALUES("enttime", "#{enttime,jdbcType=INTEGER}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(QxbAbnormalItem record) {
        BEGIN();
        UPDATE("qxb_abnormal_item");
        
        if (record.getDtoId() != null) {
            SET("dto_id = #{dtoId,jdbcType=INTEGER}");
        }
        
        if (record.getQxbId() != null) {
            SET("qxb_id = #{qxbId,jdbcType=VARCHAR}");
        }
        
        if (record.getInReason() != null) {
            SET("in_reason = #{inReason,jdbcType=VARCHAR}");
        }
        
        if (record.getInDate() != null) {
            SET("in_date = #{inDate,jdbcType=VARCHAR}");
        }
        
        if (record.getDepartment() != null) {
            SET("department = #{department,jdbcType=VARCHAR}");
        }
        
        if (record.getOutReason() != null) {
            SET("out_reason = #{outReason,jdbcType=VARCHAR}");
        }
        
        if (record.getOutDate() != null) {
            SET("out_date = #{outDate,jdbcType=VARCHAR}");
        }
        
        if (record.getEnttime() != null) {
            SET("enttime = #{enttime,jdbcType=INTEGER}");
        }
        
        WHERE("id = #{id,jdbcType=INTEGER}");
        
        return SQL();
    }
}