package com.xlh.crm.mapper;

import com.xlh.crm.domain.QxbPartnerRealCapi;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface QxbPartnerRealCapiMapper {
    @Delete({
        "delete from qxb_partner_real_capi",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
    	"insert into qxb_partner_real_capi (id, partner_id, ",
    	"real_capi, real_capi_date, ",
    	"invest_type, enttime)",
    	"values (#{id,jdbcType=INTEGER}, #{partnerId,jdbcType=INTEGER}, ",
    	"#{realCapi,jdbcType=VARCHAR}, #{realCapiDate,jdbcType=VARCHAR}, ",
    	"#{investType,jdbcType=VARCHAR}, #{enttime,jdbcType=INTEGER})"
    })
    int insert(QxbPartnerRealCapi record);

    @InsertProvider(type=QxbPartnerRealCapiSqlProvider.class, method="insertSelective")
    int insertSelective(QxbPartnerRealCapi record);

    @Select({
        "select",
        "id, partner_id, real_capi, real_capi_date, invest_type, enttime",
        "from qxb_partner_real_capi",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="partner_id", property="partnerId", jdbcType=JdbcType.INTEGER),
        @Result(column="real_capi", property="realCapi", jdbcType=JdbcType.VARCHAR),
        @Result(column="real_capi_date", property="realCapiDate", jdbcType=JdbcType.VARCHAR),
        @Result(column="invest_type", property="investType", jdbcType=JdbcType.VARCHAR),
        @Result(column="enttime", property="enttime", jdbcType=JdbcType.INTEGER)
    })
    QxbPartnerRealCapi selectByPrimaryKey(Integer id);

    @UpdateProvider(type=QxbPartnerRealCapiSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(QxbPartnerRealCapi record);

    @Update({
        "update qxb_partner_real_capi",
        "set partner_id = #{partnerId,jdbcType=INTEGER},",
          "real_capi = #{realCapi,jdbcType=VARCHAR},",
          "real_capi_date = #{realCapiDate,jdbcType=VARCHAR},",
          "invest_type = #{investType,jdbcType=VARCHAR},",
          "enttime = #{enttime,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(QxbPartnerRealCapi record);
}