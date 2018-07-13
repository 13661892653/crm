package com.xlh.crm.mapper;

import com.xlh.crm.domain.QxbEmployee;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface QxbEmployeeMapper {
    @Delete({
        "delete from qxb_employee",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
    	"insert into qxb_employee(id, qxb_id, ",
    	"name, job_title, ",
    	"enttime)",
    	"values (#{id,jdbcType=INTEGER}, #{qxbId,jdbcType=VARCHAR}, ",
    	"#{name,jdbcType=VARCHAR}, #{jobTitle,jdbcType=VARCHAR}, ",
    	"#{enttime,jdbcType=INTEGER})"
    })
    int insert(QxbEmployee record);

    @InsertProvider(type=QxbEmployeeSqlProvider.class, method="insertSelective")
    int insertSelective(QxbEmployee record);

    @Select({
        "select",
        "id, qxb_id, name, job_title, enttime",
        "from qxb_employee",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="qxb_id", property="qxbId", jdbcType=JdbcType.VARCHAR),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="job_title", property="jobTitle", jdbcType=JdbcType.VARCHAR),
        @Result(column="enttime", property="enttime", jdbcType=JdbcType.INTEGER)
    })
    QxbEmployee selectByPrimaryKey(Integer id);

    @UpdateProvider(type=QxbEmployeeSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(QxbEmployee record);

    @Update({
        "update qxb_employee",
        "set qxb_id = #{qxbId,jdbcType=VARCHAR},",
          "name = #{name,jdbcType=VARCHAR},",
          "job_title = #{jobTitle,jdbcType=VARCHAR},",
          "enttime = #{enttime,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(QxbEmployee record);
}