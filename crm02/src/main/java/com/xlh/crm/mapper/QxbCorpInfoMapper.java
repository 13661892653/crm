package com.xlh.crm.mapper;

import com.xlh.crm.domain.QxbCorpInfo;
import com.xlh.crm.domain.QxbCorpInfoKey;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface QxbCorpInfoMapper {
    @Delete({
        "delete from qxb_corp_info",
        "where id = #{id,jdbcType=INTEGER}",
          "and qxb_id = #{qxbId,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(QxbCorpInfoKey key);

    @Insert({
        "insert into qxb_corp_info(id, qxb_id, ",
        "dto_id, name, econ_kind, ",
        "regist_capi, address, ",
        "reg_no, scope, term_start, ",
        "term_end, belong_org, ",
        "oper_name, check_date, ",
        "start_date, end_date, ",
        "status, org_no, credit_no, ",
        "province, city, ",
        "domains, contact_address, ",
        "contact_telephone, contact_email, ",
        "has_finance, enttime)",
        "values (#{id,jdbcType=INTEGER}, #{qxbId,jdbcType=VARCHAR}, ",
        "#{dtoId,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, #{econKind,jdbcType=VARCHAR}, ",
        "#{registCapi,jdbcType=VARCHAR}, #{address,jdbcType=VARCHAR}, ",
        "#{regNo,jdbcType=VARCHAR}, #{scope,jdbcType=VARCHAR}, #{termStart,jdbcType=VARCHAR}, ",
        "#{termEnd,jdbcType=VARCHAR}, #{belongOrg,jdbcType=VARCHAR}, ",
        "#{operName,jdbcType=VARCHAR}, #{checkDate,jdbcType=VARCHAR}, ",
        "#{startDate,jdbcType=VARCHAR}, #{endDate,jdbcType=VARCHAR}, ",
        "#{status,jdbcType=VARCHAR}, #{orgNo,jdbcType=VARCHAR}, #{creditNo,jdbcType=VARCHAR}, ",
        "#{province,jdbcType=VARCHAR}, #{city,jdbcType=VARCHAR}, ",
        "#{domains,jdbcType=VARCHAR}, #{contactAddress,jdbcType=VARCHAR}, ",
        "#{contactTelephone,jdbcType=VARCHAR}, #{contactEmail,jdbcType=VARCHAR}, ",
        "#{hasFinance,jdbcType=TINYINT}, #{enttime,jdbcType=INTEGER})"
    })
    int insert(QxbCorpInfo record);

    //启信宝库同步企业信息库
    @Insert(
            "replace into cdm_ent_dto_corp_info(\n" +
                    "  reg_credit_no\n" +
                    "  ,enterprise_name\n" +
                    "  ,credit_no\n" +
                    "  ,reg_no\n" +
                    "  ,org_no\n" +
                    "  ,econ_kind\n" +
                    "  ,legal_representative\n" +
                    "  ,register_money\n" +
                    "  ,mgmt_status\n" +
                    "  ,create_date\n" +
                    "  ,operate_date\n" +
                    "  ,publication_date\n" +
                    "  ,area_province\n" +
                    "  ,area_city\n" +
                    "  ,reg_organ\n" +
                    "  ,ent_address\n" +
                    "  ,contact_telephone\n" +
                    "  ,contact_email\n" +
                    "  ,mgmt_scope\n" +
                    "  ,industry_name\n" +
                    ")\n" +
                    "select \n" +
                    "  trim(concat(ifnull(reg_no,''),ifnull(credit_no,''))) reg_credit_no\n" +
                    "  ,name\n" +
                    "  ,credit_no\n" +
                    "  ,reg_no\n" +
                    "  ,org_no\n" +
                    "  ,econ_kind\n" +
                    "  ,oper_name\n" +
                    "  ,regist_capi\n" +
                    "  ,status\n" +
                    "  ,case when start_date='-' then null else start_date end start_date\n" +
                    "  ,concat(term_start,'|',term_end)\n" +
                    "  ,check_date\n" +
                    "  ,province\n" +
                    "  ,city\n" +
                    "  ,belong_org\n" +
                    "  ,address\n" +
                    "  ,contact_telephone\n" +
                    "  ,contact_email\n" +
                    "  ,`scope`\n" +
                    "  ,domains\n" +
                    "from qxb_corp_info\n" +
                    "where reg_no=#{regNo,jdbcType=VARCHAR} and credit_no=#{creditNo,jdbcType=VARCHAR}"
    )
    int replaceInto(QxbCorpInfo record);

    @Insert("insert into cdm_ent_dto_corp_info_ext (reg_credit_no,valid_flag) " +
            "values(trim(concat(#{regNo,jdbcType=VARCHAR},#{creditNo,jdbcType=VARCHAR})),'Y')"
    )
    int insertExt(QxbCorpInfo qxbCorpInfo);

    @InsertProvider(type=QxbCorpInfoSqlProvider.class, method="insertSelective")
    int insertSelective(QxbCorpInfo record);

    @Select({
        "select",
        "id, qxb_id, dto_id, name, econ_kind, regist_capi, address, reg_no, scope, term_start, ",
        "term_end, belong_org, oper_name, check_date, start_date, end_date, status, org_no, ",
        "credit_no, province, city, domains, contact_address, contact_telephone, contact_email, ",
        "has_finance, enttime",
        "from qxb_corp_info",
        "where id = #{id,jdbcType=INTEGER}",
          "and qxb_id = #{qxbId,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="qxb_id", property="qxbId", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="dto_id", property="dtoId", jdbcType=JdbcType.INTEGER),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="econ_kind", property="econKind", jdbcType=JdbcType.VARCHAR),
        @Result(column="regist_capi", property="registCapi", jdbcType=JdbcType.VARCHAR),
        @Result(column="address", property="address", jdbcType=JdbcType.VARCHAR),
        @Result(column="reg_no", property="regNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="scope", property="scope", jdbcType=JdbcType.VARCHAR),
        @Result(column="term_start", property="termStart", jdbcType=JdbcType.VARCHAR),
        @Result(column="term_end", property="termEnd", jdbcType=JdbcType.VARCHAR),
        @Result(column="belong_org", property="belongOrg", jdbcType=JdbcType.VARCHAR),
        @Result(column="oper_name", property="operName", jdbcType=JdbcType.VARCHAR),
        @Result(column="check_date", property="checkDate", jdbcType=JdbcType.VARCHAR),
        @Result(column="start_date", property="startDate", jdbcType=JdbcType.VARCHAR),
        @Result(column="end_date", property="endDate", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR),
        @Result(column="org_no", property="orgNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="credit_no", property="creditNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="province", property="province", jdbcType=JdbcType.VARCHAR),
        @Result(column="city", property="city", jdbcType=JdbcType.VARCHAR),
        @Result(column="domains", property="domains", jdbcType=JdbcType.VARCHAR),
        @Result(column="contact_address", property="contactAddress", jdbcType=JdbcType.VARCHAR),
        @Result(column="contact_telephone", property="contactTelephone", jdbcType=JdbcType.VARCHAR),
        @Result(column="contact_email", property="contactEmail", jdbcType=JdbcType.VARCHAR),
        @Result(column="has_finance", property="hasFinance", jdbcType=JdbcType.TINYINT),
        @Result(column="enttime", property="enttime", jdbcType=JdbcType.INTEGER)
    })
    QxbCorpInfo selectByPrimaryKey(QxbCorpInfoKey key);

    @Select({
            "select",
            "id, qxb_id, dto_id, name, econ_kind, regist_capi, address, reg_no, scope, term_start, ",
            "term_end, belong_org, oper_name, check_date, start_date, end_date, status, org_no, ",
            "credit_no, province, city, domains, contact_address, contact_telephone, contact_email, ",
            "has_finance, enttime",
            "from qxb_corp_info",
            "where name = #{name,jdbcType=VARCHAR}"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="qxb_id", property="qxbId", jdbcType=JdbcType.VARCHAR, id=true),
            @Result(column="dto_id", property="dtoId", jdbcType=JdbcType.INTEGER),
            @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
            @Result(column="econ_kind", property="econKind", jdbcType=JdbcType.VARCHAR),
            @Result(column="regist_capi", property="registCapi", jdbcType=JdbcType.VARCHAR),
            @Result(column="address", property="address", jdbcType=JdbcType.VARCHAR),
            @Result(column="reg_no", property="regNo", jdbcType=JdbcType.VARCHAR),
            @Result(column="scope", property="scope", jdbcType=JdbcType.VARCHAR),
            @Result(column="term_start", property="termStart", jdbcType=JdbcType.VARCHAR),
            @Result(column="term_end", property="termEnd", jdbcType=JdbcType.VARCHAR),
            @Result(column="belong_org", property="belongOrg", jdbcType=JdbcType.VARCHAR),
            @Result(column="oper_name", property="operName", jdbcType=JdbcType.VARCHAR),
            @Result(column="check_date", property="checkDate", jdbcType=JdbcType.VARCHAR),
            @Result(column="start_date", property="startDate", jdbcType=JdbcType.VARCHAR),
            @Result(column="end_date", property="endDate", jdbcType=JdbcType.VARCHAR),
            @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR),
            @Result(column="org_no", property="orgNo", jdbcType=JdbcType.VARCHAR),
            @Result(column="credit_no", property="creditNo", jdbcType=JdbcType.VARCHAR),
            @Result(column="province", property="province", jdbcType=JdbcType.VARCHAR),
            @Result(column="city", property="city", jdbcType=JdbcType.VARCHAR),
            @Result(column="domains", property="domains", jdbcType=JdbcType.VARCHAR),
            @Result(column="contact_address", property="contactAddress", jdbcType=JdbcType.VARCHAR),
            @Result(column="contact_telephone", property="contactTelephone", jdbcType=JdbcType.VARCHAR),
            @Result(column="contact_email", property="contactEmail", jdbcType=JdbcType.VARCHAR),
            @Result(column="has_finance", property="hasFinance", jdbcType=JdbcType.TINYINT),
            @Result(column="enttime", property="enttime", jdbcType=JdbcType.INTEGER)
    })
    QxbCorpInfo selectByFullName(String fullName);

    @UpdateProvider(type=QxbCorpInfoSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(QxbCorpInfo record);

    @Update({
        "update qxb_corp_info",
        "set dto_id = #{dtoId,jdbcType=INTEGER},",
          "name = #{name,jdbcType=VARCHAR},",
          "econ_kind = #{econKind,jdbcType=VARCHAR},",
          "regist_capi = #{registCapi,jdbcType=VARCHAR},",
          "address = #{address,jdbcType=VARCHAR},",
          "reg_no = #{regNo,jdbcType=VARCHAR},",
          "scope = #{scope,jdbcType=VARCHAR},",
          "term_start = #{termStart,jdbcType=VARCHAR},",
          "term_end = #{termEnd,jdbcType=VARCHAR},",
          "belong_org = #{belongOrg,jdbcType=VARCHAR},",
          "oper_name = #{operName,jdbcType=VARCHAR},",
          "check_date = #{checkDate,jdbcType=VARCHAR},",
          "start_date = #{startDate,jdbcType=VARCHAR},",
          "end_date = #{endDate,jdbcType=VARCHAR},",
          "status = #{status,jdbcType=VARCHAR},",
          "org_no = #{orgNo,jdbcType=VARCHAR},",
          "credit_no = #{creditNo,jdbcType=VARCHAR},",
          "province = #{province,jdbcType=VARCHAR},",
          "city = #{city,jdbcType=VARCHAR},",
          "domains = #{domains,jdbcType=VARCHAR},",
          "contact_address = #{contactAddress,jdbcType=VARCHAR},",
          "contact_telephone = #{contactTelephone,jdbcType=VARCHAR},",
          "contact_email = #{contactEmail,jdbcType=VARCHAR},",
          "has_finance = #{hasFinance,jdbcType=TINYINT},",
          "enttime = #{enttime,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}",
          "and qxb_id = #{qxbId,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(QxbCorpInfo record);
}