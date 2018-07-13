package com.xlh.crm.mapper;

import com.xlh.crm.dto.mysql.CdmEntDtoCorpInfo;
import com.xlh.crm.utils.MyMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

public interface CdmEntDtoCorpInfoMapper extends MyMapper<CdmEntDtoCorpInfo> {

    @Update({"update cdm_ent_dto_corp_info set " +
            "reg_credit_no=#{regCreditNo,jdbcType=VARCHAR}," +
            "reg_no=#{regNo,jdbcType=VARCHAR}," +
            "credit_no=#{creditNo,jdbcType=VARCHAR} " +
            "where reg_credit_no=#{regCreditNoOld,jdbcType=VARCHAR}"})
    public int updateRegCreditNoCdmEntDtoCorpInfo(@Param("regNo")String regNo,@Param("creditNo")String creditNo,@Param("regCreditNo")String regCreditNo,@Param("regCreditNoOld")String regCreditNoOld);
    @Update({"update cdm_ent_dto_carrier set " +
            "reg_credit_no=#{regCreditNo,jdbcType=VARCHAR}," +
            "reg_no=#{regNo,jdbcType=VARCHAR}," +
            "credit_no=#{creditNo,jdbcType=VARCHAR} " +
            "where reg_credit_no=#{regCreditNoOld,jdbcType=VARCHAR}"})
    public int updateRegCreditNocdm_ent_dto_carrier(@Param("regNo")String regNo,@Param("creditNo")String creditNo,@Param("regCreditNo")String regCreditNo,@Param("regCreditNoOld")String regCreditNoOld);
    @Update({"update cdm_ent_dto_contacts set " +
            "reg_credit_no=#{regCreditNo,jdbcType=VARCHAR}," +
            "reg_no=#{regNo,jdbcType=VARCHAR}," +
            "credit_no=#{creditNo,jdbcType=VARCHAR} " +
            "where reg_credit_no=#{regCreditNoOld,jdbcType=VARCHAR}"})
    public int updateRegCreditNocdm_ent_dto_contacts(@Param("regNo")String regNo,@Param("creditNo")String creditNo,@Param("regCreditNo")String regCreditNo,@Param("regCreditNoOld")String regCreditNoOld);
    @Update({"update cdm_ent_dto_core_team set " +
            "reg_credit_no=#{regCreditNo,jdbcType=VARCHAR}," +
            "reg_no=#{regNo,jdbcType=VARCHAR}," +
            "credit_no=#{creditNo,jdbcType=VARCHAR} " +
            "where reg_credit_no=#{regCreditNoOld,jdbcType=VARCHAR}"})
    public int updateRegCreditNocdm_ent_dto_core_team(@Param("regNo")String regNo,@Param("creditNo")String creditNo,@Param("regCreditNo")String regCreditNo,@Param("regCreditNoOld")String regCreditNoOld);
    @Update({"update cdm_ent_dto_corp_info_ext set " +
            "reg_credit_no=#{regCreditNo,jdbcType=VARCHAR}," +
            "reg_no=#{regNo,jdbcType=VARCHAR}," +
            "credit_no=#{creditNo,jdbcType=VARCHAR} " +
            "where reg_credit_no=#{regCreditNoOld,jdbcType=VARCHAR}"})
    public int updateRegCreditNocdm_ent_dto_corp_info_ext(@Param("regNo")String regNo,@Param("creditNo")String creditNo,@Param("regCreditNo")String regCreditNo,@Param("regCreditNoOld")String regCreditNoOld);
    @Update({"update cdm_ent_dto_emp set " +
            "reg_credit_no=#{regCreditNo,jdbcType=VARCHAR}," +
            "reg_no=#{regNo,jdbcType=VARCHAR}," +
            "credit_no=#{creditNo,jdbcType=VARCHAR} " +
            "where reg_credit_no=#{regCreditNoOld,jdbcType=VARCHAR}"})
    public int updateRegCreditNocdm_ent_dto_emp(@Param("regNo")String regNo,@Param("creditNo")String creditNo,@Param("regCreditNo")String regCreditNo,@Param("regCreditNoOld")String regCreditNoOld);
    @Update({"update cdm_ent_dto_emp_struc set " +
            "reg_credit_no=#{regCreditNo,jdbcType=VARCHAR}," +
            "reg_no=#{regNo,jdbcType=VARCHAR}," +
            "credit_no=#{creditNo,jdbcType=VARCHAR} " +
            "where reg_credit_no=#{regCreditNoOld,jdbcType=VARCHAR}"})
    public int updateRegCreditNocdm_ent_dto_emp_struc(@Param("regNo")String regNo,@Param("creditNo")String creditNo,@Param("regCreditNo")String regCreditNo,@Param("regCreditNoOld")String regCreditNoOld);
    @Update({"update cdm_ent_dto_finance_recent set " +
            "reg_credit_no=#{regCreditNo,jdbcType=VARCHAR}," +
            "reg_no=#{regNo,jdbcType=VARCHAR}," +
            "credit_no=#{creditNo,jdbcType=VARCHAR} " +
            "where reg_credit_no=#{regCreditNoOld,jdbcType=VARCHAR}"})
    public int updateRegCreditNocdm_ent_dto_finance_recent(@Param("regNo")String regNo,@Param("creditNo")String creditNo,@Param("regCreditNo")String regCreditNo,@Param("regCreditNoOld")String regCreditNoOld);
    @Update({"update cdm_ent_dto_financing set " +
            "reg_credit_no=#{regCreditNo,jdbcType=VARCHAR}," +
            "reg_no=#{regNo,jdbcType=VARCHAR}," +
            "credit_no=#{creditNo,jdbcType=VARCHAR} " +
            "where reg_credit_no=#{regCreditNoOld,jdbcType=VARCHAR}"})
    public int updateRegCreditNocdm_ent_dto_financing(@Param("regNo")String regNo,@Param("creditNo")String creditNo,@Param("regCreditNo")String regCreditNo,@Param("regCreditNoOld")String regCreditNoOld);
    @Update({"update cdm_ent_dto_high_tech set " +
            "reg_credit_no=#{regCreditNo,jdbcType=VARCHAR}," +
            "reg_no=#{regNo,jdbcType=VARCHAR}," +
            "credit_no=#{creditNo,jdbcType=VARCHAR} " +
            "where reg_credit_no=#{regCreditNoOld,jdbcType=VARCHAR}"})
    public int updateRegCreditNocdm_ent_dto_high_tech(@Param("regNo")String regNo,@Param("creditNo")String creditNo,@Param("regCreditNo")String regCreditNo,@Param("regCreditNoOld")String regCreditNoOld);
    @Update({"update cdm_ent_dto_honor set " +
            "reg_credit_no=#{regCreditNo,jdbcType=VARCHAR}," +
            "reg_no=#{regNo,jdbcType=VARCHAR}," +
            "credit_no=#{creditNo,jdbcType=VARCHAR} " +
            "where reg_credit_no=#{regCreditNoOld,jdbcType=VARCHAR}"})
    public int updateRegCreditNocdm_ent_dto_honor(@Param("regNo")String regNo,@Param("creditNo")String creditNo,@Param("regCreditNo")String regCreditNo,@Param("regCreditNoOld")String regCreditNoOld);
    @Update({"update cdm_ent_dto_inv_info set " +
            "reg_credit_no=#{regCreditNo,jdbcType=VARCHAR}," +
            "reg_no=#{regNo,jdbcType=VARCHAR}," +
            "credit_no=#{creditNo,jdbcType=VARCHAR} " +
            "where reg_credit_no=#{regCreditNoOld,jdbcType=VARCHAR}"})
    public int updateRegCreditNocdm_ent_dto_inv_info(@Param("regNo")String regNo,@Param("creditNo")String creditNo,@Param("regCreditNo")String regCreditNo,@Param("regCreditNoOld")String regCreditNoOld);
    @Update({"update cdm_ent_dto_ipo set " +
            "reg_credit_no=#{regCreditNo,jdbcType=VARCHAR}," +
            "reg_no=#{regNo,jdbcType=VARCHAR}," +
            "credit_no=#{creditNo,jdbcType=VARCHAR} " +
            "where reg_credit_no=#{regCreditNoOld,jdbcType=VARCHAR}"})
    public int updateRegCreditNocdm_ent_dto_ipo(@Param("regNo")String regNo,@Param("creditNo")String creditNo,@Param("regCreditNo")String regCreditNo,@Param("regCreditNoOld")String regCreditNoOld);
    @Update({"update cdm_ent_dto_market_dev set " +
            "reg_credit_no=#{regCreditNo,jdbcType=VARCHAR}," +
            "reg_no=#{regNo,jdbcType=VARCHAR}," +
            "credit_no=#{creditNo,jdbcType=VARCHAR} " +
            "where reg_credit_no=#{regCreditNoOld,jdbcType=VARCHAR}"})
    public int updateRegCreditNocdm_ent_dto_market_dev(@Param("regNo")String regNo,@Param("creditNo")String creditNo,@Param("regCreditNo")String regCreditNo,@Param("regCreditNoOld")String regCreditNoOld);
    @Update({"update cdm_ent_dto_market_follow set " +
            "reg_credit_no=#{regCreditNo,jdbcType=VARCHAR}," +
            "reg_no=#{regNo,jdbcType=VARCHAR}," +
            "credit_no=#{creditNo,jdbcType=VARCHAR} " +
            "where reg_credit_no=#{regCreditNoOld,jdbcType=VARCHAR}"})
    public int updateRegCreditNocdm_ent_dto_market_follow(@Param("regNo")String regNo,@Param("creditNo")String creditNo,@Param("regCreditNo")String regCreditNo,@Param("regCreditNoOld")String regCreditNoOld);
    @Update({"update cdm_ent_dto_partner set " +
            "reg_credit_no=#{regCreditNo,jdbcType=VARCHAR}," +
            "reg_no=#{regNo,jdbcType=VARCHAR}," +
            "credit_no=#{creditNo,jdbcType=VARCHAR} " +
            "where reg_credit_no=#{regCreditNoOld,jdbcType=VARCHAR}"})
    public int updateRegCreditNocdm_ent_dto_partner(@Param("regNo")String regNo,@Param("creditNo")String creditNo,@Param("regCreditNo")String regCreditNo,@Param("regCreditNoOld")String regCreditNoOld);
    @Update({"update cdm_ent_dto_project set " +
            "reg_credit_no=#{regCreditNo,jdbcType=VARCHAR}," +
            "reg_no=#{regNo,jdbcType=VARCHAR}," +
            "credit_no=#{creditNo,jdbcType=VARCHAR} " +
            "where reg_credit_no=#{regCreditNoOld,jdbcType=VARCHAR}"})
    public int updateRegCreditNocdm_ent_dto_project(@Param("regNo")String regNo,@Param("creditNo")String creditNo,@Param("regCreditNo")String regCreditNo,@Param("regCreditNoOld")String regCreditNoOld);
    @Update({"update crm_ent_favorite set " +
            "reg_credit_no=#{regCreditNo,jdbcType=VARCHAR}," +
            "reg_no=#{regNo,jdbcType=VARCHAR}," +
            "credit_no=#{creditNo,jdbcType=VARCHAR} " +
            "where reg_credit_no=#{regCreditNoOld,jdbcType=VARCHAR}"})
    public int updateRegCreditNocrm_ent_favorite(@Param("regNo")String regNo,@Param("creditNo")String creditNo,@Param("regCreditNo")String regCreditNo,@Param("regCreditNoOld")String regCreditNoOld);
    @Update({"update crm_ent_init set " +
            "reg_credit_no=#{regCreditNo,jdbcType=VARCHAR}," +
            "reg_no=#{regNo,jdbcType=VARCHAR}," +
            "credit_no=#{creditNo,jdbcType=VARCHAR} " +
            "where reg_credit_no=#{regCreditNoOld,jdbcType=VARCHAR}"})
    public int updateRegCreditNocrm_ent_init(@Param("regNo")String regNo,@Param("creditNo")String creditNo,@Param("regCreditNo")String regCreditNo,@Param("regCreditNoOld")String regCreditNoOld);
    @Update({"update crm_order set " +
            "reg_credit_no=#{regCreditNo,jdbcType=VARCHAR}," +
            "reg_no=#{regNo,jdbcType=VARCHAR}," +
            "credit_no=#{creditNo,jdbcType=VARCHAR} " +
            "where reg_credit_no=#{regCreditNoOld,jdbcType=VARCHAR}"})
    public int updateRegCreditNocrm_order(@Param("regNo")String regNo,@Param("creditNo")String creditNo,@Param("regCreditNo")String regCreditNo,@Param("regCreditNoOld")String regCreditNoOld);
    @Update({"update crm_reachcsr set " +
            "reg_credit_no=#{regCreditNo,jdbcType=VARCHAR}," +
            "reg_no=#{regNo,jdbcType=VARCHAR}," +
            "credit_no=#{creditNo,jdbcType=VARCHAR} " +
            "where reg_credit_no=#{regCreditNoOld,jdbcType=VARCHAR}"})
    public int updateRegCreditNocrm_reachcsr(@Param("regNo")String regNo,@Param("creditNo")String creditNo,@Param("regCreditNo")String regCreditNo,@Param("regCreditNoOld")String regCreditNoOld);
    @Update({"update crm_operation_log set " +
            "operation_desc=#{regCreditNo,jdbcType=VARCHAR}," +
            "where operation_desc=#{regCreditNoOld,jdbcType=VARCHAR}"})
    public int updateRegCreditNocrm_operation_log(@Param("regCreditNo")String regCreditNo,@Param("regCreditNoOld")String regCreditNoOld);
}
