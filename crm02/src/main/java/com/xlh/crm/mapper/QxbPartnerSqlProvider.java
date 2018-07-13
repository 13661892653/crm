package com.xlh.crm.mapper;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import com.xlh.crm.domain.QxbPartner;

public class QxbPartnerSqlProvider {
    
    public String insertSelective(QxbPartner record) {
    	BEGIN();
    	INSERT_INTO("qxb_partner");
    	
    	if (record.getId() != null) {
    		VALUES("id", "#{id,jdbcType=INTEGER}");
    	}
    	
    	if (record.getQxbId() != null) {
    		VALUES("qxb_id", "#{qxbId,jdbcType=VARCHAR}");
    	}
    	
    	if (record.getStockType() != null) {
    		VALUES("stock_type", "#{stockType,jdbcType=VARCHAR}");
    	}
    	
    	if (record.getName() != null) {
    		VALUES("name", "#{name,jdbcType=VARCHAR}");
    	}
    	
    	if (record.getCategory() != null) {
    		VALUES("category", "#{category,jdbcType=VARCHAR}");
    	}
    	
    	if (record.getIdentifyType() != null) {
    		VALUES("identify_type", "#{identifyType,jdbcType=VARCHAR}");
    	}
    	
    	if (record.getIdentifyNo() != null) {
    		VALUES("identify_no", "#{identifyNo,jdbcType=VARCHAR}");
    	}
    	
    	if (record.getEnttime() != null) {
    		VALUES("enttime", "#{enttime,jdbcType=INTEGER}");
    	}
    	
    	return SQL();
    }

    public String updateByPrimaryKeySelective(QxbPartner record) {
        BEGIN();
        UPDATE("qxb_partner");
        
        if (record.getQxbId() != null) {
            SET("qxb_id = #{qxbId,jdbcType=VARCHAR}");
        }
        
        if (record.getStockType() != null) {
            SET("stock_type = #{stockType,jdbcType=VARCHAR}");
        }
        
        if (record.getName() != null) {
            SET("name = #{name,jdbcType=VARCHAR}");
        }
        
        if (record.getCategory() != null) {
            SET("category = #{category,jdbcType=VARCHAR}");
        }
        
        if (record.getIdentifyType() != null) {
            SET("identify_type = #{identifyType,jdbcType=VARCHAR}");
        }
        
        if (record.getIdentifyNo() != null) {
            SET("identify_no = #{identifyNo,jdbcType=VARCHAR}");
        }
        
        if (record.getEnttime() != null) {
            SET("enttime = #{enttime,jdbcType=INTEGER}");
        }
        
        WHERE("id = #{id,jdbcType=INTEGER}");
        
        return SQL();
    }
}