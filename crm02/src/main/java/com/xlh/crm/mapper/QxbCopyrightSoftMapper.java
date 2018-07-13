package com.xlh.crm.mapper;

import com.xlh.crm.domain.QxbCopyrightSoft;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface QxbCopyrightSoftMapper {
    @Delete({
        "delete from qxb_copyright_soft",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into qxb_copyright_soft (id, qxb_id, ",
        "zid, number, company, ",
        "version, type, name, ",
        "type_name, success_date, ",
        "approval_date, short_name, ",
        "last_updated_time, type_num, ",
        "first_date, enttime)",
        "values (#{id,jdbcType=INTEGER}, #{qxbId,jdbcType=VARCHAR}, ",
        "#{zid,jdbcType=VARCHAR}, #{number,jdbcType=VARCHAR}, #{company,jdbcType=VARCHAR}, ",
        "#{version,jdbcType=VARCHAR}, #{type,jdbcType=VARCHAR}, #{name,jdbcType=VARCHAR}, ",
        "#{typeName,jdbcType=VARCHAR}, #{successDate,jdbcType=VARCHAR}, ",
        "#{approvalDate,jdbcType=VARCHAR}, #{shortName,jdbcType=VARCHAR}, ",
        "#{lastUpdatedTime,jdbcType=VARCHAR}, #{typeNum,jdbcType=VARCHAR}, ",
        "#{firstDate,jdbcType=VARCHAR}, #{enttime,jdbcType=INTEGER})"
    })
    int insert(QxbCopyrightSoft record);
    
    @Insert({
    	"insert into qxb_copyright_soft2 (id, qxb_id, ",
    	"zid, number, company, ",
    	"version, type, name, ",
    	"type_name, success_date, ",
    	"approval_date, short_name, ",
    	"last_updated_time, type_num, ",
    	"first_date, enttime)",
    	"values (#{id,jdbcType=INTEGER}, #{qxbId,jdbcType=VARCHAR}, ",
    	"#{zid,jdbcType=VARCHAR}, #{number,jdbcType=VARCHAR}, #{company,jdbcType=VARCHAR}, ",
    	"#{version,jdbcType=VARCHAR}, #{type,jdbcType=VARCHAR}, #{name,jdbcType=VARCHAR}, ",
    	"#{typeName,jdbcType=VARCHAR}, #{successDate,jdbcType=VARCHAR}, ",
    	"#{approvalDate,jdbcType=VARCHAR}, #{shortName,jdbcType=VARCHAR}, ",
    	"#{lastUpdatedTime,jdbcType=VARCHAR}, #{typeNum,jdbcType=VARCHAR}, ",
    	"#{firstDate,jdbcType=VARCHAR}, #{enttime,jdbcType=INTEGER})"
    })
    int insert2(QxbCopyrightSoft record);

    @InsertProvider(type=QxbCopyrightSoftSqlProvider.class, method="insertSelective")
    int insertSelective(QxbCopyrightSoft record);

    @Select({
        "select",
        "id, qxb_id, zid, number, company, version, type, name, type_name, success_date, ",
        "approval_date, short_name, last_updated_time, type_num, first_date, enttime",
        "from qxb_copyright_soft",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="qxb_id", property="qxbId", jdbcType=JdbcType.VARCHAR),
        @Result(column="zid", property="zid", jdbcType=JdbcType.VARCHAR),
        @Result(column="number", property="number", jdbcType=JdbcType.VARCHAR),
        @Result(column="company", property="company", jdbcType=JdbcType.VARCHAR),
        @Result(column="version", property="version", jdbcType=JdbcType.VARCHAR),
        @Result(column="type", property="type", jdbcType=JdbcType.VARCHAR),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="type_name", property="typeName", jdbcType=JdbcType.VARCHAR),
        @Result(column="success_date", property="successDate", jdbcType=JdbcType.VARCHAR),
        @Result(column="approval_date", property="approvalDate", jdbcType=JdbcType.VARCHAR),
        @Result(column="short_name", property="shortName", jdbcType=JdbcType.VARCHAR),
        @Result(column="last_updated_time", property="lastUpdatedTime", jdbcType=JdbcType.VARCHAR),
        @Result(column="type_num", property="typeNum", jdbcType=JdbcType.VARCHAR),
        @Result(column="first_date", property="firstDate", jdbcType=JdbcType.VARCHAR),
        @Result(column="enttime", property="enttime", jdbcType=JdbcType.INTEGER)
    })
    QxbCopyrightSoft selectByPrimaryKey(Integer id);

    @UpdateProvider(type=QxbCopyrightSoftSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(QxbCopyrightSoft record);

    @Update({
        "update qxb_copyright_soft",
        "set qxb_id = #{qxbId,jdbcType=VARCHAR},",
          "zid = #{zid,jdbcType=VARCHAR},",
          "number = #{number,jdbcType=VARCHAR},",
          "company = #{company,jdbcType=VARCHAR},",
          "version = #{version,jdbcType=VARCHAR},",
          "type = #{type,jdbcType=VARCHAR},",
          "name = #{name,jdbcType=VARCHAR},",
          "type_name = #{typeName,jdbcType=VARCHAR},",
          "success_date = #{successDate,jdbcType=VARCHAR},",
          "approval_date = #{approvalDate,jdbcType=VARCHAR},",
          "short_name = #{shortName,jdbcType=VARCHAR},",
          "last_updated_time = #{lastUpdatedTime,jdbcType=VARCHAR},",
          "type_num = #{typeNum,jdbcType=VARCHAR},",
          "first_date = #{firstDate,jdbcType=VARCHAR},",
          "enttime = #{enttime,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(QxbCopyrightSoft record);
}