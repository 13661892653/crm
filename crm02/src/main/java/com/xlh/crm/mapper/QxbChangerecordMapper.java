package com.xlh.crm.mapper;

import com.xlh.crm.domain.QxbChangerecord;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface QxbChangerecordMapper {
    @Delete({
        "delete from qxb_changerecord",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
    	"insert into qxb_changerecord (id, qxb_id, ",
    	"change_item, change_date, ",
    	"before_content, after_content, ",
    	"enttime)",
    	"values (#{id,jdbcType=INTEGER}, #{qxbId,jdbcType=VARCHAR}, ",
    	"#{changeItem,jdbcType=VARCHAR}, #{changeDate,jdbcType=VARCHAR}, ",
    	"#{beforeContent,jdbcType=VARCHAR}, #{afterContent,jdbcType=VARCHAR}, ",
    	"#{enttime,jdbcType=INTEGER})"
    })
    int insert(QxbChangerecord record);

    @InsertProvider(type=QxbChangerecordSqlProvider.class, method="insertSelective")
    int insertSelective(QxbChangerecord record);

    @Select({
        "select",
        "id, qxb_id, change_item, change_date, before_content, after_content, enttime",
        "from qxb_changerecord",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="qxb_id", property="qxbId", jdbcType=JdbcType.VARCHAR),
        @Result(column="change_item", property="changeItem", jdbcType=JdbcType.VARCHAR),
        @Result(column="change_date", property="changeDate", jdbcType=JdbcType.VARCHAR),
        @Result(column="before_content", property="beforeContent", jdbcType=JdbcType.VARCHAR),
        @Result(column="after_content", property="afterContent", jdbcType=JdbcType.VARCHAR),
        @Result(column="enttime", property="enttime", jdbcType=JdbcType.INTEGER)
    })
    QxbChangerecord selectByPrimaryKey(Integer id);

    @UpdateProvider(type=QxbChangerecordSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(QxbChangerecord record);

    @Update({
        "update qxb_changerecord",
        "set qxb_id = #{qxbId,jdbcType=VARCHAR},",
          "change_item = #{changeItem,jdbcType=VARCHAR},",
          "change_date = #{changeDate,jdbcType=VARCHAR},",
          "before_content = #{beforeContent,jdbcType=VARCHAR},",
          "after_content = #{afterContent,jdbcType=VARCHAR},",
          "enttime = #{enttime,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(QxbChangerecord record);
}