package com.xlh.crm.mapper;

import com.xlh.crm.domain.QxbPartnerShouldCapi;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface QxbPartnerShouldCapiMapper {
    @Delete({
        "delete from qxb_partner_should_capi",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
    	"insert into qxb_partner_should_capi (id, partner_id, ",
    	"shoud_capi, should_capi_date, ",
    	"invest_type, enttime)",
    	"values (#{id,jdbcType=INTEGER}, #{partnerId,jdbcType=INTEGER}, ",
    	"#{shoudCapi,jdbcType=VARCHAR}, #{shouldCapiDate,jdbcType=VARCHAR}, ",
    	"#{investType,jdbcType=VARCHAR}, #{enttime,jdbcType=INTEGER})"
    })
    int insert(QxbPartnerShouldCapi record);

    @InsertProvider(type=QxbPartnerShouldCapiSqlProvider.class, method="insertSelective")
    int insertSelective(QxbPartnerShouldCapi record);

    @Select({
        "select",
        "id, partner_id, shoud_capi, should_capi_date, invest_type, enttime",
        "from qxb_partner_should_capi",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="partner_id", property="partnerId", jdbcType=JdbcType.INTEGER),
        @Result(column="shoud_capi", property="shoudCapi", jdbcType=JdbcType.VARCHAR),
        @Result(column="should_capi_date", property="shouldCapiDate", jdbcType=JdbcType.VARCHAR),
        @Result(column="invest_type", property="investType", jdbcType=JdbcType.VARCHAR),
        @Result(column="enttime", property="enttime", jdbcType=JdbcType.INTEGER)
    })
    QxbPartnerShouldCapi selectByPrimaryKey(Integer id);

    @UpdateProvider(type=QxbPartnerShouldCapiSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(QxbPartnerShouldCapi record);

    @Update({
        "update qxb_partner_should_capi",
        "set partner_id = #{partnerId,jdbcType=INTEGER},",
          "shoud_capi = #{shoudCapi,jdbcType=VARCHAR},",
          "should_capi_date = #{shouldCapiDate,jdbcType=VARCHAR},",
          "invest_type = #{investType,jdbcType=VARCHAR},",
          "enttime = #{enttime,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(QxbPartnerShouldCapi record);
}