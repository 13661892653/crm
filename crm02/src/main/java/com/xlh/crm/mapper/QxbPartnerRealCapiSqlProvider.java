package com.xlh.crm.mapper;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import com.xlh.crm.domain.QxbPartnerRealCapi;

public class QxbPartnerRealCapiSqlProvider {

    public String insertSelective(QxbPartnerRealCapi record) {
        BEGIN();
        INSERT_INTO("qxb_partner_real_capi");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getPartnerId() != null) {
            VALUES("partner_id", "#{partnerId,jdbcType=INTEGER}");
        }
        
        if (record.getRealCapi() != null) {
            VALUES("real_capi", "#{realCapi,jdbcType=VARCHAR}");
        }
        
        if (record.getRealCapiDate() != null) {
            VALUES("real_capi_date", "#{realCapiDate,jdbcType=VARCHAR}");
        }
        
        if (record.getInvestType() != null) {
            VALUES("invest_type", "#{investType,jdbcType=VARCHAR}");
        }
        
        if (record.getEnttime() != null) {
            VALUES("enttime", "#{enttime,jdbcType=INTEGER}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(QxbPartnerRealCapi record) {
        BEGIN();
        UPDATE("qxb_partner_real_capi");
        
        if (record.getPartnerId() != null) {
            SET("partner_id = #{partnerId,jdbcType=INTEGER}");
        }
        
        if (record.getRealCapi() != null) {
            SET("real_capi = #{realCapi,jdbcType=VARCHAR}");
        }
        
        if (record.getRealCapiDate() != null) {
            SET("real_capi_date = #{realCapiDate,jdbcType=VARCHAR}");
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