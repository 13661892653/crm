package com.xlh.crm.mapper;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import com.xlh.crm.domain.QxbChangerecord;

public class QxbChangerecordSqlProvider {

    public String insertSelective(QxbChangerecord record) {
        BEGIN();
        INSERT_INTO("qxb_changerecord");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getQxbId() != null) {
            VALUES("qxb_id", "#{qxbId,jdbcType=VARCHAR}");
        }
        
        if (record.getChangeItem() != null) {
            VALUES("change_item", "#{changeItem,jdbcType=VARCHAR}");
        }
        
        if (record.getChangeDate() != null) {
            VALUES("change_date", "#{changeDate,jdbcType=VARCHAR}");
        }
        
        if (record.getBeforeContent() != null) {
            VALUES("before_content", "#{beforeContent,jdbcType=VARCHAR}");
        }
        
        if (record.getAfterContent() != null) {
            VALUES("after_content", "#{afterContent,jdbcType=VARCHAR}");
        }
        
        if (record.getEnttime() != null) {
            VALUES("enttime", "#{enttime,jdbcType=INTEGER}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(QxbChangerecord record) {
        BEGIN();
        UPDATE("qxb_changerecord");
        
        if (record.getQxbId() != null) {
            SET("qxb_id = #{qxbId,jdbcType=VARCHAR}");
        }
        
        if (record.getChangeItem() != null) {
            SET("change_item = #{changeItem,jdbcType=VARCHAR}");
        }
        
        if (record.getChangeDate() != null) {
            SET("change_date = #{changeDate,jdbcType=VARCHAR}");
        }
        
        if (record.getBeforeContent() != null) {
            SET("before_content = #{beforeContent,jdbcType=VARCHAR}");
        }
        
        if (record.getAfterContent() != null) {
            SET("after_content = #{afterContent,jdbcType=VARCHAR}");
        }
        
        if (record.getEnttime() != null) {
            SET("enttime = #{enttime,jdbcType=INTEGER}");
        }
        
        WHERE("id = #{id,jdbcType=INTEGER}");
        
        return SQL();
    }
}