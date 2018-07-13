package com.xlh.crm.mapper;

import com.xlh.crm.dto.ContractShowDTO;
import com.xlh.crm.dto.OrderShowDTO;
import com.xlh.crm.dto.PageReqDTO;
import com.xlh.crm.dto.ReachShowDTO;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface ContractMapper {

	//信息LIST查询
	@Results({
			@Result(column="rec_id", property="recId", jdbcType=JdbcType.VARCHAR),
			@Result(column="contract_type", property="contractType", jdbcType=JdbcType.VARCHAR),
			@Result(column="contract_no", property="contractNo", jdbcType=JdbcType.VARCHAR),
			@Result(column="contract_title", property="contractTitle", jdbcType=JdbcType.VARCHAR),
			@Result(column="contract_enterprise", property="contractEnterprise", jdbcType=JdbcType.VARCHAR),
			@Result(column="order_no", property="orderNo", jdbcType=JdbcType.VARCHAR),
			@Result(column="biz_lv1_id", property="bizLv1Id", jdbcType=JdbcType.VARCHAR),
			@Result(column="biz_lv1_name", property="bizLv1Name", jdbcType=JdbcType.VARCHAR),
			@Result(column="order_prod_id", property="orderProdId", jdbcType=JdbcType.VARCHAR),
			@Result(column="order_prod_name", property="orderProdName", jdbcType=JdbcType.VARCHAR),
			@Result(column="contract_date", property="contractDate", jdbcType=JdbcType.VARCHAR),
			@Result(column="contract_amt", property="contractAmt", jdbcType=JdbcType.VARCHAR),
			@Result(column="income", property="income", jdbcType=JdbcType.DOUBLE),
			@Result(column="income_unit", property="incomeUnit", jdbcType=JdbcType.VARCHAR),
			@Result(column="profit", property="profit", jdbcType=JdbcType.DOUBLE),
			@Result(column="profit_unit", property="profitUnit", jdbcType=JdbcType.VARCHAR),
			@Result(column="profit_rate", property="profitRate", jdbcType=JdbcType.VARCHAR),
			@Result(column="income_exp_date", property="incomeExpDate", jdbcType=JdbcType.VARCHAR),
			@Result(column="partner_id", property="partnerId", jdbcType=JdbcType.VARCHAR),
			@Result(column="partner_name", property="partnerName", jdbcType=JdbcType.VARCHAR),
			@Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
			@Result(column="link_address", property="linkAddress", jdbcType=JdbcType.VARCHAR),
			@Result(column="operator", property="operator", jdbcType=JdbcType.VARCHAR),
			@Result(column="company", property="company", jdbcType=JdbcType.VARCHAR),
			@Result(column="update_time", property="updateTime", jdbcType=JdbcType.VARCHAR)
	})
	@SelectProvider(type=ContractSqlProvider.class, method="getContractList")
	List<ContractShowDTO> getContractList(PageReqDTO reqdto);

	//计算信息总记录数，用于分页
	@SelectProvider(type=ContractSqlProvider.class, method="getContractListCount")
	Integer getContractListCount(PageReqDTO dto);

	//单个合同查询
	@Results({
			@Result(column="contract_type", property="contractType", jdbcType=JdbcType.VARCHAR),
			@Result(column="contract_no", property="contractNo", jdbcType=JdbcType.VARCHAR),
			@Result(column="contract_title", property="contractTitle", jdbcType=JdbcType.VARCHAR),
			@Result(column="contract_enterprise", property="contractEnterprise", jdbcType=JdbcType.VARCHAR),
			@Result(column="order_no", property="orderNo", jdbcType=JdbcType.VARCHAR),
			@Result(column="biz_lv1_id", property="bizLv1Id", jdbcType=JdbcType.VARCHAR),
			@Result(column="biz_lv1_name", property="bizLv1Name", jdbcType=JdbcType.VARCHAR),
			@Result(column="order_prod_id", property="orderProdId", jdbcType=JdbcType.VARCHAR),
			@Result(column="order_prod_name", property="orderProdName", jdbcType=JdbcType.VARCHAR),
			@Result(column="contract_date", property="contractDate", jdbcType=JdbcType.VARCHAR),
			@Result(column="contract_amt", property="contractAmt", jdbcType=JdbcType.VARCHAR),
			@Result(column="income", property="income", jdbcType=JdbcType.DOUBLE),
			@Result(column="income_unit", property="incomeUnit", jdbcType=JdbcType.VARCHAR),
			@Result(column="profit", property="profit", jdbcType=JdbcType.DOUBLE),
			@Result(column="profit_unit", property="profitUnit", jdbcType=JdbcType.VARCHAR),
			@Result(column="profit_rate", property="profitRate", jdbcType=JdbcType.VARCHAR),
			@Result(column="income_exp_date", property="incomeExpDate", jdbcType=JdbcType.VARCHAR),
			@Result(column="partner_id", property="partnerId", jdbcType=JdbcType.VARCHAR),
			@Result(column="partner_name", property="partnerName", jdbcType=JdbcType.VARCHAR),
			@Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
			@Result(column="link_address", property="linkAddress", jdbcType=JdbcType.VARCHAR),
			@Result(column="operator", property="operator", jdbcType=JdbcType.VARCHAR),
			@Result(column="company", property="company", jdbcType=JdbcType.VARCHAR),
			@Result(column="update_time", property="updateTime", jdbcType=JdbcType.VARCHAR)
	})
	@SelectProvider(type=ContractSqlProvider.class, method="getContractByContractNo")
	ContractShowDTO getContractByContractNo(String contractNo);

	//信息入库
	@Insert({
			"insert into crm_contract (",
			"contract_type, ",
			"contract_no, ",
			"contract_title, ",
			"contract_enterprise, ",
			"order_no, ",
			"biz_lv1_id, ",
			"biz_lv1_name, ",
			"order_prod_id, ",
			"order_prod_name, ",
			"contract_date, ",
			"contract_amt, ",
			"income, ",
			"income_unit, ",
			"profit, ",
			"profit_unit, ",
			"profit_rate, ",
			"income_exp_date, ",
			"partner_id, ",
			"partner_name, ",
			"remark, ",
			"link_address, ",
			"operator, ",
			"company, ",
			"update_time)",
			"values (",
			"#{contractType,jdbcType=VARCHAR}, ",
			"#{contractNo,jdbcType=VARCHAR}, ",
			"#{contractTitle,jdbcType=VARCHAR}, ",
			"#{contractEnterprise,jdbcType=VARCHAR}, ",
			"#{orderNo,jdbcType=VARCHAR}, ",
			"#{bizLv1Id,jdbcType=VARCHAR}, ",
			"#{bizLv1Name,jdbcType=VARCHAR}, ",
			"#{orderProdId,jdbcType=VARCHAR}, ",
			"#{orderProdName,jdbcType=VARCHAR}, ",
			"#{contractDate,jdbcType=VARCHAR}, ",
			"#{contractAmt,jdbcType=VARCHAR}, ",
			"#{income,jdbcType=DOUBLE}, ",
			"#{incomeUnit,jdbcType=VARCHAR}, ",
			"#{profit,jdbcType=DOUBLE}, ",
			"#{profitUnit,jdbcType=VARCHAR}, ",
			"#{profitRate,jdbcType=VARCHAR}, ",
			"#{incomeExpDate,jdbcType=VARCHAR}, ",
			"#{partnerId,jdbcType=VARCHAR}, ",
			"#{partnerName,jdbcType=VARCHAR}, ",
			"#{remark,jdbcType=VARCHAR}, ",
			"#{linkAddress,jdbcType=VARCHAR}, ",
			"#{operator,jdbcType=VARCHAR}, ",
			"#{company,jdbcType=VARCHAR}, ",
			"#{updateTime,jdbcType=VARCHAR})"
	})
	int insertContract(ContractShowDTO record);

	//更新合同
	@Update({
			"update crm_contract",
			"set contract_amt = #{contractAmt,jdbcType=VARCHAR},",
			"income = #{income,jdbcType=DOUBLE},",
			"profit = #{profit,jdbcType=DOUBLE},",
			"profit_rate = #{profitRate,jdbcType=VARCHAR},",
			"income_exp_date = #{incomeExpDate,jdbcType=VARCHAR},",
			"remark = #{remark,jdbcType=VARCHAR},",
			"update_time = #{updateTime,jdbcType=VARCHAR}",
			"where contract_no = #{contractNo,jdbcType=VARCHAR}"
	})
	int updateContract(ContractShowDTO form);
}