package com.xlh.crm.mapper;

import com.xlh.crm.domain.QxbBranch;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface QxbBranchMapper {
    @Delete({
        "delete from qxb_branch",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
    	"insert into qxb_branch(id, dto_id, ",
    	"qxb_id, name, enttime)",
    	"values (#{id,jdbcType=INTEGER}, #{dtoId,jdbcType=INTEGER}, ",
    	"#{qxbId,jdbcType=VARCHAR}, #{name,jdbcType=VARCHAR}, #{enttime,jdbcType=INTEGER})"
    })
    int insert(QxbBranch record);

    @InsertProvider(type=QxbBranchSqlProvider.class, method="insertSelective")
    int insertSelective(QxbBranch record);

    @Select({
        "select",
        "id, dto_id, qxb_id, name, enttime",
        "from qxb_branch",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="dto_id", property="dtoId", jdbcType=JdbcType.INTEGER),
        @Result(column="qxb_id", property="qxbId", jdbcType=JdbcType.VARCHAR),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="enttime", property="enttime", jdbcType=JdbcType.INTEGER)
    })
    QxbBranch selectByPrimaryKey(Integer id);

    @UpdateProvider(type=QxbBranchSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(QxbBranch record);

    @Update({
        "update qxb_branch",
        "set dto_id = #{dtoId,jdbcType=INTEGER},",
          "qxb_id = #{qxbId,jdbcType=VARCHAR},",
          "name = #{name,jdbcType=VARCHAR},",
          "enttime = #{enttime,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(QxbBranch record);
}