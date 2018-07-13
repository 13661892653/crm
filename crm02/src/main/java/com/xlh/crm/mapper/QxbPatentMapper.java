package com.xlh.crm.mapper;

import com.xlh.crm.domain.QxbPatent;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface QxbPatentMapper {
    @Delete({
        "delete from qxb_patent",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into qxb_patent (id, qxb_id, ",
        "patent_name, type_name, ",
        "request_date, request_num, ",
        "outhor_num, designer, ",
        "category_num, brief, ",
        "outhor_date, enttime)",
        "values (#{id,jdbcType=INTEGER}, #{qxbId,jdbcType=VARCHAR}, ",
        "#{patentName,jdbcType=VARCHAR}, #{typeName,jdbcType=VARCHAR}, ",
        "#{requestDate,jdbcType=VARCHAR}, #{requestNum,jdbcType=VARCHAR}, ",
        "#{outhorNum,jdbcType=VARCHAR}, #{designer,jdbcType=VARCHAR}, ",
        "#{categoryNum,jdbcType=VARCHAR}, #{brief,jdbcType=VARCHAR}, ",
        "#{outhorDate,jdbcType=VARCHAR}, #{enttime,jdbcType=INTEGER})"
    })
    int insert(QxbPatent record);
    
    @Insert({
    	"insert into qxb_patent2 (id, qxb_id, ",
    	"patent_name, type_name, ",
    	"request_date, request_num, ",
    	"outhor_num, designer, ",
    	"category_num, brief, ",
    	"outhor_date, enttime)",
    	"values (#{id,jdbcType=INTEGER}, #{qxbId,jdbcType=VARCHAR}, ",
    	"#{patentName,jdbcType=VARCHAR}, #{typeName,jdbcType=VARCHAR}, ",
    	"#{requestDate,jdbcType=VARCHAR}, #{requestNum,jdbcType=VARCHAR}, ",
    	"#{outhorNum,jdbcType=VARCHAR}, #{designer,jdbcType=VARCHAR}, ",
    	"#{categoryNum,jdbcType=VARCHAR}, #{brief,jdbcType=VARCHAR}, ",
    	"#{outhorDate,jdbcType=VARCHAR}, #{enttime,jdbcType=INTEGER})"
    })
    int insert2(QxbPatent record);

    @InsertProvider(type=QxbPatentSqlProvider.class, method="insertSelective")
    int insertSelective(QxbPatent record);

    @Select({
        "select",
        "id, qxb_id, patent_name, type_name, request_date, request_num, outhor_num, designer, ",
        "category_num, brief, outhor_date, enttime",
        "from qxb_patent",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="qxb_id", property="qxbId", jdbcType=JdbcType.VARCHAR),
        @Result(column="patent_name", property="patentName", jdbcType=JdbcType.VARCHAR),
        @Result(column="type_name", property="typeName", jdbcType=JdbcType.VARCHAR),
        @Result(column="request_date", property="requestDate", jdbcType=JdbcType.VARCHAR),
        @Result(column="request_num", property="requestNum", jdbcType=JdbcType.VARCHAR),
        @Result(column="outhor_num", property="outhorNum", jdbcType=JdbcType.VARCHAR),
        @Result(column="designer", property="designer", jdbcType=JdbcType.VARCHAR),
        @Result(column="category_num", property="categoryNum", jdbcType=JdbcType.VARCHAR),
        @Result(column="brief", property="brief", jdbcType=JdbcType.VARCHAR),
        @Result(column="outhor_date", property="outhorDate", jdbcType=JdbcType.VARCHAR),
        @Result(column="enttime", property="enttime", jdbcType=JdbcType.INTEGER)
    })
    QxbPatent selectByPrimaryKey(Integer id);

    @UpdateProvider(type=QxbPatentSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(QxbPatent record);

    @Update({
        "update qxb_patent",
        "set qxb_id = #{qxbId,jdbcType=VARCHAR},",
          "patent_name = #{patentName,jdbcType=VARCHAR},",
          "type_name = #{typeName,jdbcType=VARCHAR},",
          "request_date = #{requestDate,jdbcType=VARCHAR},",
          "request_num = #{requestNum,jdbcType=VARCHAR},",
          "outhor_num = #{outhorNum,jdbcType=VARCHAR},",
          "designer = #{designer,jdbcType=VARCHAR},",
          "category_num = #{categoryNum,jdbcType=VARCHAR},",
          "brief = #{brief,jdbcType=VARCHAR},",
          "outhor_date = #{outhorDate,jdbcType=VARCHAR},",
          "enttime = #{enttime,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(QxbPatent record);
}