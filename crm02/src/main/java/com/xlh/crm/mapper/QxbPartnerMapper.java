package com.xlh.crm.mapper;

import com.xlh.crm.domain.QxbPartner;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface QxbPartnerMapper {
    @Delete({
        "delete from qxb_partner",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into qxb_partner (id, qxb_id, ",
        "stock_type, name, ",
        "category, identify_type, ",
        "identify_no, enttime)",
        "values (#{id,jdbcType=INTEGER}, #{qxbId,jdbcType=VARCHAR}, ",
        "#{stockType,jdbcType=VARCHAR}, #{name,jdbcType=VARCHAR}, ",
        "#{category,jdbcType=VARCHAR}, #{identifyType,jdbcType=VARCHAR}, ",
        "#{identifyNo,jdbcType=VARCHAR}, #{enttime,jdbcType=INTEGER})"
    })
    int insert(QxbPartner record);
    
    @InsertProvider(type=QxbPartnerSqlProvider.class, method="insertSelective")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int insertSelective(QxbPartner record);

    @Select({
        "select",
        "id, qxb_id, stock_type, name, category, identify_type, identify_no, enttime",
        "from qxb_partner",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="qxb_id", property="qxbId", jdbcType=JdbcType.VARCHAR),
        @Result(column="stock_type", property="stockType", jdbcType=JdbcType.VARCHAR),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="category", property="category", jdbcType=JdbcType.VARCHAR),
        @Result(column="identify_type", property="identifyType", jdbcType=JdbcType.VARCHAR),
        @Result(column="identify_no", property="identifyNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="enttime", property="enttime", jdbcType=JdbcType.INTEGER)
    })
    QxbPartner selectByPrimaryKey(Integer id);

    @UpdateProvider(type=QxbPartnerSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(QxbPartner record);

    @Update({
        "update qxb_partner",
        "set qxb_id = #{qxbId,jdbcType=VARCHAR},",
          "stock_type = #{stockType,jdbcType=VARCHAR},",
          "name = #{name,jdbcType=VARCHAR},",
          "category = #{category,jdbcType=VARCHAR},",
          "identify_type = #{identifyType,jdbcType=VARCHAR},",
          "identify_no = #{identifyNo,jdbcType=VARCHAR},",
          "enttime = #{enttime,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(QxbPartner record);
}