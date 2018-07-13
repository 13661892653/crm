package com.xlh.crm.mapper;

import com.xlh.crm.domain.QxbAbnormalItem;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface QxbAbnormalItemMapper {
    @Delete({
        "delete from qxb_abnormal_item",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
    	"insert into qxb_abnormal_item(id, dto_id, ",
    	"qxb_id, in_reason, ",
    	"in_date, department, ",
    	"out_reason, out_date, ",
    	"enttime)",
    	"values (#{id,jdbcType=INTEGER}, #{dtoId,jdbcType=INTEGER}, ",
    	"#{qxbId,jdbcType=VARCHAR}, #{inReason,jdbcType=VARCHAR}, ",
    	"#{inDate,jdbcType=VARCHAR}, #{department,jdbcType=VARCHAR}, ",
    	"#{outReason,jdbcType=VARCHAR}, #{outDate,jdbcType=VARCHAR}, ",
    	"#{enttime,jdbcType=INTEGER})"
    })
    int insert(QxbAbnormalItem record);

    @InsertProvider(type=QxbAbnormalItemSqlProvider.class, method="insertSelective")
    int insertSelective(QxbAbnormalItem record);

    @Select({
        "select",
        "id, dto_id, qxb_id, in_reason, in_date, department, out_reason, out_date, enttime",
        "from qxb_abnormal_item",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="dto_id", property="dtoId", jdbcType=JdbcType.INTEGER),
        @Result(column="qxb_id", property="qxbId", jdbcType=JdbcType.VARCHAR),
        @Result(column="in_reason", property="inReason", jdbcType=JdbcType.VARCHAR),
        @Result(column="in_date", property="inDate", jdbcType=JdbcType.VARCHAR),
        @Result(column="department", property="department", jdbcType=JdbcType.VARCHAR),
        @Result(column="out_reason", property="outReason", jdbcType=JdbcType.VARCHAR),
        @Result(column="out_date", property="outDate", jdbcType=JdbcType.VARCHAR),
        @Result(column="enttime", property="enttime", jdbcType=JdbcType.INTEGER)
    })
    QxbAbnormalItem selectByPrimaryKey(Integer id);

    @UpdateProvider(type=QxbAbnormalItemSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(QxbAbnormalItem record);

    @Update({
        "update qxb_abnormal_item",
        "set dto_id = #{dtoId,jdbcType=INTEGER},",
          "qxb_id = #{qxbId,jdbcType=VARCHAR},",
          "in_reason = #{inReason,jdbcType=VARCHAR},",
          "in_date = #{inDate,jdbcType=VARCHAR},",
          "department = #{department,jdbcType=VARCHAR},",
          "out_reason = #{outReason,jdbcType=VARCHAR},",
          "out_date = #{outDate,jdbcType=VARCHAR},",
          "enttime = #{enttime,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(QxbAbnormalItem record);
}