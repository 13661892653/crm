package com.xlh.crm.mapper;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import com.xlh.crm.domain.QxbPartnerShouldCapi;

public class QxbPartnerShouldCapiSqlProvider {

    public String insertSelective(QxbPartnerShouldCapi record) {
        BEGIN();
        INSERT_INTO("qxb_partner_should_capi");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getPartnerId() != null) {
            VALUES("partner_id", "#{partnerId,jdbcType=INTEGER}");
        }
        
        if (record.getShoudCapi() != null) {
            VALUES("shoud_capi", "#{shoudCapi,jdbcType=VARCHAR}");
        }
        
        if (record.getShouldCapiDate() != null) {
            VALUES("should_capi_date", "#{shouldCapiDate,jdbcType=VARCHAR}");
        }
        
        if (record.getInvestType() != null) {
            VALUES("invest_type", "#{investType,jdbcType=VARCHAR}");
        }
        
        if (record.getEnttime() != null) {
            VALUES("enttime", "#{enttime,jdbcType=INTEGER}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(QxbPartnerShouldCapi record) {
        BEGIN();
        UPDATE("qxb_partner_should_capi");
        
        if (record.getPartnerId() != null) {
            SET("partner_id = #{partnerId,jdbcType=INTEGER}");
        }
        
        if (record.getShoudCapi() != null) {
            SET("shoud_capi = #{shoudCapi,jdbcType=VARCHAR}");
        }
        
        if (record.getShouldCapiDate() != null) {
            SET("should_capi_date = #{shouldCapiDate,jdbcType=VARCHAR}");
        }
        
        if (record.getInvestType() != null) {
            SET("invest_type = #{investType,jdbcType=VARCHAR}");
        }
        
        if (record.getEnttime() != null) {
            SET("enttime = #{enttime,jdbcType=INTEGER}");
        }
        
        WHERE("id = #{id,jdbcType=INTEGER}");
        
        return SQL();
    }
}