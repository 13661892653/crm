package com.xlh.crm.mapper;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import com.xlh.crm.domain.QxbWebsite;

public class QxbWebsiteSqlProvider {

    public String insertSelective(QxbWebsite record) {
        BEGIN();
        INSERT_INTO("qxb_website");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getQxbId() != null) {
            VALUES("qxb_id", "#{qxbId,jdbcType=VARCHAR}");
        }
        
        if (record.getWebName() != null) {
            VALUES("web_name", "#{webName,jdbcType=VARCHAR}");
        }
        
        if (record.getWebType() != null) {
            VALUES("web_type", "#{webType,jdbcType=VARCHAR}");
        }
        
        if (record.getWebUrl() != null) {
            VALUES("web_url", "#{webUrl,jdbcType=VARCHAR}");
        }
        
        if (record.getSource() != null) {
            VALUES("source", "#{source,jdbcType=VARCHAR}");
        }
        
        if (record.getSeqNo() != null) {
            VALUES("seq_no", "#{seqNo,jdbcType=VARCHAR}");
        }
        
        if (record.getDate() != null) {
            VALUES("date", "#{date,jdbcType=VARCHAR}");
        }
        
        if (record.getEnttime() != null) {
            VALUES("enttime", "#{enttime,jdbcType=INTEGER}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(QxbWebsite record) {
        BEGIN();
        UPDATE("qxb_website");
        
        if (record.getQxbId() != null) {
            SET("qxb_id = #{qxbId,jdbcType=VARCHAR}");
        }
        
        if (record.getWebName() != null) {
            SET("web_name = #{webName,jdbcType=VARCHAR}");
        }
        
        if (record.getWebType() != null) {
            SET("web_type = #{webType,jdbcType=VARCHAR}");
        }
        
        if (record.getWebUrl() != null) {
            SET("web_url = #{webUrl,jdbcType=VARCHAR}");
        }
        
        if (record.getSource() != null) {
            SET("source = #{source,jdbcType=VARCHAR}");
        }
        
        if (record.getSeqNo() != null) {
            SET("seq_no = #{seqNo,jdbcType=VARCHAR}");
        }
        
        if (record.getDate() != null) {
            SET("date = #{date,jdbcType=VARCHAR}");
        }
        
        if (record.getEnttime() != null) {
            SET("enttime = #{enttime,jdbcType=INTEGER}");
        }
        
        WHERE("id = #{id,jdbcType=INTEGER}");
        
        return SQL();
    }
}