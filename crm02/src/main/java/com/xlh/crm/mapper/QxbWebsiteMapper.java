package com.xlh.crm.mapper;

import com.xlh.crm.domain.QxbWebsite;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface QxbWebsiteMapper {
    @Delete({
        "delete from qxb_website",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
    	"insert into qxb_website (id, qxb_id, ",
    	"web_name, web_type, ",
    	"web_url, source, ",
    	"seq_no, date, enttime)",
    	"values (#{id,jdbcType=INTEGER}, #{qxbId,jdbcType=VARCHAR}, ",
    	"#{webName,jdbcType=VARCHAR}, #{webType,jdbcType=VARCHAR}, ",
    	"#{webUrl,jdbcType=VARCHAR}, #{source,jdbcType=VARCHAR}, ",
    	"#{seqNo,jdbcType=VARCHAR}, #{date,jdbcType=VARCHAR}, #{enttime,jdbcType=INTEGER})"
    })
    int insert(QxbWebsite record);

    @InsertProvider(type=QxbWebsiteSqlProvider.class, method="insertSelective")
    int insertSelective(QxbWebsite record);

    @Select({
        "select",
        "id, qxb_id, web_name, web_type, web_url, source, seq_no, date, enttime",
        "from qxb_website",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="qxb_id", property="qxbId", jdbcType=JdbcType.VARCHAR),
        @Result(column="web_name", property="webName", jdbcType=JdbcType.VARCHAR),
        @Result(column="web_type", property="webType", jdbcType=JdbcType.VARCHAR),
        @Result(column="web_url", property="webUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="source", property="source", jdbcType=JdbcType.VARCHAR),
        @Result(column="seq_no", property="seqNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="date", property="date", jdbcType=JdbcType.VARCHAR),
        @Result(column="enttime", property="enttime", jdbcType=JdbcType.INTEGER)
    })
    QxbWebsite selectByPrimaryKey(Integer id);

    @UpdateProvider(type=QxbWebsiteSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(QxbWebsite record);

    @Update({
        "update qxb_website",
        "set qxb_id = #{qxbId,jdbcType=VARCHAR},",
          "web_name = #{webName,jdbcType=VARCHAR},",
          "web_type = #{webType,jdbcType=VARCHAR},",
          "web_url = #{webUrl,jdbcType=VARCHAR},",
          "source = #{source,jdbcType=VARCHAR},",
          "seq_no = #{seqNo,jdbcType=VARCHAR},",
          "date = #{date,jdbcType=VARCHAR},",
          "enttime = #{enttime,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(QxbWebsite record);
}