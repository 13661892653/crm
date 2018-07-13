package com.xlh.crm.mapper;

import com.xlh.crm.domain.EnterpriseTag;
import com.xlh.crm.dto.*;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface OrderMapper {

	//校验订单
	@Select({
			"select",
			"t1.order_type,t1.order_no,t1.enterprise_name,t1.reg_credit_no,t1.reg_no, t1.credit_no,t1.order_prod_id,t1.order_prod_name,t1.partner_id,t1.partner_name,count(1) as rec_cnt",
			"from crm_order t1",
			"where t1.order_no = #{orderNo,jdbcType=VARCHAR} limit 1"
	})
	@Results({
			@Result(column="order_type", property="orderType", jdbcType=JdbcType.VARCHAR),
			@Result(column="order_no", property="orderNo", jdbcType=JdbcType.VARCHAR),
			@Result(column="enterprise_name", property="enterpriseName", jdbcType=JdbcType.VARCHAR),
			@Result(column="reg_credit_no", property="regCreditNo", jdbcType=JdbcType.VARCHAR),
			@Result(column="reg_no", property="regNo", jdbcType=JdbcType.VARCHAR),
			@Result(column="credit_no", property="creditNo", jdbcType=JdbcType.VARCHAR),
			@Result(column="order_prod_id", property="orderProdId", jdbcType=JdbcType.VARCHAR),
			@Result(column="order_prod_name", property="orderProdName", jdbcType=JdbcType.VARCHAR),
			@Result(column="partner_id", property="partnerId", jdbcType=JdbcType.VARCHAR),
			@Result(column="partner_name", property="partnerName", jdbcType=JdbcType.VARCHAR),
			@Result(column="rec_cnt", property="recCnt", jdbcType=JdbcType.VARCHAR)
	})
	OrderShowDTO selectByOrderNo(String corpName);

	//订单LIST查询
	@Results({
			@Result(column="order_type", property="orderType", jdbcType=JdbcType.VARCHAR),
			@Result(column="order_no", property="orderNo", jdbcType=JdbcType.VARCHAR),
			@Result(column="order_date", property="orderDate", jdbcType=JdbcType.VARCHAR),
			@Result(column="order_memeber_name", property="orderMemeberName", jdbcType=JdbcType.VARCHAR),
			@Result(column="enterprise_name", property="enterpriseName", jdbcType=JdbcType.VARCHAR),
			@Result(column="biz_lv1_name", property="bizLv1Name", jdbcType=JdbcType.VARCHAR),
			@Result(column="biz_lv2_name", property="bizLv2Name", jdbcType=JdbcType.VARCHAR),
			@Result(column="biz_lv3_name", property="bizLv3Name", jdbcType=JdbcType.VARCHAR),
			@Result(column="order_prod_id", property="orderProdId", jdbcType=JdbcType.VARCHAR),
			@Result(column="order_prod_name", property="orderProdName", jdbcType=JdbcType.VARCHAR),
			@Result(column="order_num", property="orderNum", jdbcType=JdbcType.INTEGER),
			@Result(column="order_price", property="orderPrice", jdbcType=JdbcType.DOUBLE),
			@Result(column="order_amt", property="orderAmt", jdbcType=JdbcType.DOUBLE),
			@Result(column="pay_mode", property="payMode", jdbcType=JdbcType.VARCHAR),
			@Result(column="pay_status", property="payStatus", jdbcType=JdbcType.VARCHAR),
			@Result(column="order_status", property="orderStatus", jdbcType=JdbcType.VARCHAR),
			@Result(column="is_self_biz", property="isSelfBiz", jdbcType=JdbcType.VARCHAR),
			@Result(column="partner_id", property="partnerId", jdbcType=JdbcType.VARCHAR),
			@Result(column="partner_name", property="partnerName", jdbcType=JdbcType.VARCHAR),
			@Result(column="docking_time", property="dockingTime", jdbcType=JdbcType.VARCHAR),
			@Result(column="progress", property="progress", jdbcType=JdbcType.VARCHAR),
			@Result(column="close_time", property="closeTime", jdbcType=JdbcType.VARCHAR),
			@Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
			@Result(column="merchandiser", property="merchandiser", jdbcType=JdbcType.VARCHAR),
			@Result(column="company", property="company", jdbcType=JdbcType.VARCHAR),
			@Result(column="assign_merchandiser_date", property="assignMerchandiserDate", jdbcType=JdbcType.VARCHAR),
			@Result(column="update_time", property="updateTime", jdbcType=JdbcType.VARCHAR)
	})
	@SelectProvider(type=OrderSqlProvider.class, method="getOrderList")
	List<OrderShowDTO> getOrderList(PageReqDTO reqdto);

	//计算筛选后订单总记录数，用于分页
	@SelectProvider(type=OrderSqlProvider.class, method="getOrderListCount")
	Integer getOrderListCount(PageReqDTO dto);

	//单个订单查询
	@Results({
			@Result(column="order_type", property="orderType", jdbcType=JdbcType.VARCHAR),
			@Result(column="order_no", property="orderNo", jdbcType=JdbcType.VARCHAR),
			@Result(column="order_date", property="orderDate", jdbcType=JdbcType.VARCHAR),
			@Result(column="order_memeber_name", property="orderMemeberName", jdbcType=JdbcType.VARCHAR),
			@Result(column="credit_no", property="creditNo", jdbcType=JdbcType.VARCHAR),
			@Result(column="reg_no", property="regNo", jdbcType=JdbcType.VARCHAR),
			@Result(column="reg_credit_no", property="regCreditNo", jdbcType=JdbcType.VARCHAR),
			@Result(column="enterprise_name", property="enterpriseName", jdbcType=JdbcType.VARCHAR),
			@Result(column="biz_lv1_name", property="bizLv1Name", jdbcType=JdbcType.VARCHAR),
			@Result(column="biz_lv2_name", property="bizLv2Name", jdbcType=JdbcType.VARCHAR),
			@Result(column="biz_lv3_name", property="bizLv3Name", jdbcType=JdbcType.VARCHAR),
			@Result(column="order_prod_id", property="orderProdId", jdbcType=JdbcType.VARCHAR),
			@Result(column="order_prod_name", property="orderProdName", jdbcType=JdbcType.VARCHAR),
			@Result(column="order_num", property="orderNum", jdbcType=JdbcType.INTEGER),
			@Result(column="order_price", property="orderPrice", jdbcType=JdbcType.DOUBLE),
			@Result(column="order_amt", property="orderAmt", jdbcType=JdbcType.DOUBLE),
			@Result(column="pay_mode", property="payMode", jdbcType=JdbcType.VARCHAR),
			@Result(column="pay_status", property="payStatus", jdbcType=JdbcType.VARCHAR),
			@Result(column="order_status", property="orderStatus", jdbcType=JdbcType.VARCHAR),
			@Result(column="is_self_biz", property="isSelfBiz", jdbcType=JdbcType.VARCHAR),
			@Result(column="partner_id", property="partnerId", jdbcType=JdbcType.VARCHAR),
			@Result(column="partner_name", property="partnerName", jdbcType=JdbcType.VARCHAR),
			@Result(column="docking_time", property="dockingTime", jdbcType=JdbcType.VARCHAR),
			@Result(column="progress", property="progress", jdbcType=JdbcType.VARCHAR),
			@Result(column="close_time", property="closeTime", jdbcType=JdbcType.VARCHAR),
			@Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
			@Result(column="merchandiser", property="merchandiser", jdbcType=JdbcType.VARCHAR),
			@Result(column="company", property="company", jdbcType=JdbcType.VARCHAR),
			@Result(column="assign_merchandiser_date", property="assignMerchandiserDate", jdbcType=JdbcType.VARCHAR),
			@Result(column="update_time", property="updateTime", jdbcType=JdbcType.VARCHAR)
	})
	@SelectProvider(type=OrderSqlProvider.class, method="getOrderByOrderNo")
	OrderShowDTO getOrderByOrderNo(String orderNo);

	//订单入库
	@InsertProvider(type=OrderSqlProvider.class, method="insertOrder")
	@Options(useGeneratedKeys = true, keyProperty = "orderNo", keyColumn = "order_no")
	int insertOrder(OrderShowDTO record);

	//更新订单
	@Update({
			"update crm_order",
			"set pay_mode = #{payMode,jdbcType=VARCHAR},",
			"pay_status = #{payStatus,jdbcType=VARCHAR},",
			"order_status = #{orderStatus,jdbcType=VARCHAR},",
			"docking_time = #{dockingTime,jdbcType=VARCHAR},",
			"progress = #{progress,jdbcType=VARCHAR},",
			"close_time = #{closeTime,jdbcType=VARCHAR},",
			"remark = #{remark,jdbcType=VARCHAR},",
			"merchandiser = #{merchandiser,jdbcType=VARCHAR},",
			"assign_merchandiser_date = #{assignMerchandiserDate,jdbcType=VARCHAR},",
			"update_time = #{updateTime,jdbcType=VARCHAR}",
			"where order_no = #{orderNo,jdbcType=VARCHAR}"
	})
	int updateOrder(OrderShowDTO form);
}