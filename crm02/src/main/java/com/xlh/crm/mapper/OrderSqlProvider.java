package com.xlh.crm.mapper;

import com.xlh.crm.dto.OrderShowDTO;
import com.xlh.crm.dto.PageReqDTO;
import org.codehaus.plexus.util.StringUtils;

import static org.apache.ibatis.jdbc.SqlBuilder.*;

public class OrderSqlProvider {

    //订单列表
    public String getOrderList(PageReqDTO reqdto){
        StringBuffer sql = new StringBuffer();
        sql.append("select t1.order_type,t1.order_no,t1.order_date, t1.order_memeber_name, t1.enterprise_name, t2.biz_lv1_name,t2.biz_lv2_name,t2.biz_lv3_name,t1.order_prod_id, t2.product_name as order_prod_name,t1.order_num" +
                ", t1.order_price,t1.order_amt,t1.pay_mode, t1.pay_status, t1.order_status,t1.is_self_biz,t1.partner_id,t3.partner_name,t1.docking_time,t1.progress,t1.close_time" +
                ", t1.remark,t1.merchandiser, t1.company, t1.assign_merchandiser_date,t1.update_time").append(" ");
        sql.append("from crm_order t1").append(" ");
        sql.append("join crm_product t2").append(" ");
        sql.append("on t1.order_prod_id = t2.product_id").append(" ");
        sql.append("left outer join crm_partner t3").append(" ");
        sql.append("on t1.partner_id = t3.partner_id").append(" ");
        sql.append("where 1=1").append(" ");
        if(!StringUtils.isEmpty(reqdto.getRegCreditNo())){ //查询某个企业的订单
            sql.append("and t1.reg_credit_no = '").append(reqdto.getRegCreditNo()).append("'");
        }
        if(!StringUtils.isEmpty(reqdto.getMemberType())&&(Integer.parseInt(reqdto.getMemberType()) > 90)&&!StringUtils.isEmpty(reqdto.getUserName())){ //权限控制：如果是一般用户，只能看到自己的订单信息
            sql.append("and (t1.order_memeber_name ='").append(reqdto.getUserName()).append("'").append(" ");
            sql.append("or t1.merchandiser ='").append(reqdto.getUserName()).append("')").append(" ");
        }
        if(!StringUtils.isEmpty(reqdto.getMemberType())&&reqdto.getMemberType().equals("90")&&!StringUtils.isEmpty(reqdto.getCompany())){ //权限控制：如果是分公司经理，只能看到本公司
            sql.append("and t1.company = '").append(reqdto.getCompany()).append("'").append(" ");
        }
        sql.append("order by t1.order_date desc,t1.order_no desc").append(" ");
        sql.append(getLimitSql(reqdto.getPageIndex(), reqdto.getPageSize()));

        return sql.toString();
    }

    //订单总数，用于分页
    public String getOrderListCount(PageReqDTO reqdto){
        StringBuffer sql = new StringBuffer();
        sql.append("select count(t1.order_no) ").append(" ");
        sql.append("from crm_order t1").append(" ");
        sql.append("where 1=1").append(" ");
        if(!StringUtils.isEmpty(reqdto.getRegCreditNo())){ //查询某个企业的订单
            sql.append("and t1.reg_credit_no = '").append(reqdto.getRegCreditNo()).append("'");
        }
        if(!StringUtils.isEmpty(reqdto.getMemberType())&&(Integer.parseInt(reqdto.getMemberType()) > 90)&&!StringUtils.isEmpty(reqdto.getUserName())){ //权限控制：如果是一般用户，只能看到自己的订单信息
            sql.append("and (t1.order_memeber_name ='").append(reqdto.getUserName()).append("'").append(" ");
            sql.append("or t1.merchandiser ='").append(reqdto.getUserName()).append("')").append(" ");
        }
        if(!StringUtils.isEmpty(reqdto.getMemberType())&&reqdto.getMemberType().equals("90")&&!StringUtils.isEmpty(reqdto.getCompany())){ //权限控制：如果是分公司经理，只能看到本公司
            sql.append("and t1.company = '").append(reqdto.getCompany()).append("'").append(" ");
        }

        return sql.toString();
    }

    private  String getLimitSql(Integer index, Integer pageSize){
        return "LIMIT " + (index - 1) * pageSize + "," + pageSize;
    }

    //单个订单查询
    public String getOrderByOrderNo(String orderNo){
        StringBuffer sql = new StringBuffer();
        sql.append("select t1.order_type,t1.order_no,t1.order_date, t1.order_memeber_name,t1.credit_no, t1.reg_no, t1.reg_credit_no, t1.enterprise_name, t2.biz_lv1_name,t2.biz_lv2_name,t2.biz_lv3_name,t1.order_prod_id, t2.product_name as order_prod_name,t1.order_num" +
                ", t1.order_price,t1.order_amt,t1.pay_mode, t1.pay_status, t1.order_status,t1.is_self_biz,t1.partner_id,t3.partner_name,t3.partner_name,t1.docking_time,t1.progress,t1.close_time" +
                ", t1.remark,t1.merchandiser,t1.company, t1.assign_merchandiser_date").append(" ");
        sql.append("from crm_order t1").append(" ");
        sql.append("join crm_product t2").append(" ");
        sql.append("on t1.order_prod_id = t2.product_id").append(" ");
        sql.append("left outer join crm_partner t3").append(" ");
        sql.append("on t1.partner_id = t3.partner_id").append(" ");
        sql.append("where t1.order_no = '").append(orderNo).append("'");

        return sql.toString();
    }

    public String insertOrder(OrderShowDTO record) {
        BEGIN();
        INSERT_INTO("crm_order");

        if (record.getOrderType() != null) {
            VALUES("order_type", "#{orderType,jdbcType=VARCHAR}");
        }

        if (record.getOrderNo() != null) {
            VALUES("order_no", "#{orderNo,jdbcType=VARCHAR}");
        }

        if (record.getOrderDate() != null) {
            VALUES("order_date", "#{orderDate,jdbcType=VARCHAR}");
        }

        if (record.getOrderMemeberName() != null) {
            VALUES("order_memeber_name", "#{orderMemeberName,jdbcType=VARCHAR}");
        }

        if (record.getRegNo() != null) {
            VALUES("reg_no", "#{regNo,jdbcType=VARCHAR}");
        }

        if (record.getCreditNo() != null) {
            VALUES("credit_no", "#{creditNo,jdbcType=VARCHAR}");
        }

        if (record.getRegCreditNo() != null) {
            VALUES("reg_credit_no", "#{regCreditNo,jdbcType=VARCHAR}");
        }

        //非企业订单，取custName入enterprise_name
        if (record.getEnterpriseName().equals("")) {
            VALUES("enterprise_name", "#{custName,jdbcType=VARCHAR}");
        }
        //企业订单，去enterprise_name入enterprise_name
        if (record.getCustName().equals("")) {
            VALUES("enterprise_name", "#{enterpriseName,jdbcType=VARCHAR}");
        }

        if (record.getOrderProdId() != null) {
            VALUES("order_prod_id", "#{orderProdId,jdbcType=VARCHAR}");
        }

        if (record.getOrderProdName() != null) {
            VALUES("order_prod_name", "#{orderProdName,jdbcType=VARCHAR}");
        }

        if (record.getOrderNum() != null) {
            VALUES("order_num", "#{orderNum,jdbcType=INTEGER}");
        }

        if (record.getOrderPrice() != null) {
            VALUES("order_price", "#{orderPrice,jdbcType=DOUBLE}");
        }

        if (record.getOrderAmt() != null) {
            VALUES("order_amt", "#{orderAmt,jdbcType=DOUBLE}");
        }

        if (record.getPayMode() != null) {
            VALUES("pay_mode", "#{payMode,jdbcType=VARCHAR}");
        }

        if (record.getPayStatus() != null) {
            VALUES("pay_status", "#{payStatus,jdbcType=VARCHAR}");
        }

        if (record.getOrderStatus() != null) {
            VALUES("order_status", "#{orderStatus,jdbcType=VARCHAR}");
        }

        if (record.getIsSelfBiz() != null) {
            VALUES("is_self_biz", "#{isSelfBiz,jdbcType=VARCHAR}");
        }

        if (record.getPartnerId() != null) {
            VALUES("partner_id", "#{partnerId,jdbcType=VARCHAR}");
        }

        if (record.getPartnerName() != null) {
            VALUES("partner_name", "#{partnerName,jdbcType=VARCHAR}");
        }

        if (record.getDockingTime() != null) {
            VALUES("docking_time", "#{dockingTime,jdbcType=VARCHAR}");
        }

        if (record.getProgress() != null) {
            VALUES("progress", "#{progress,jdbcType=VARCHAR}");
        }

        if (record.getCloseTime() != null) {
            VALUES("close_time", "#{closeTime,jdbcType=VARCHAR}");
        }

        if (record.getRemark() != null) {
            VALUES("remark", "#{remark,jdbcType=VARCHAR}");
        }

        if (record.getMerchandiser() != null) {
            VALUES("merchandiser", "#{merchandiser,jdbcType=VARCHAR}");
        }

        if (record.getCompany() != null) {
            VALUES("company", "#{company,jdbcType=VARCHAR}");
        }

        if (record.getAssignMerchandiserDate() != null) {
            VALUES("assign_merchandiser_date", "#{assignMerchandiserDate,jdbcType=VARCHAR}");
        }

        if (record.getUpdateTime() != null) {
            VALUES("update_time", "#{updateTime,jdbcType=VARCHAR}");
        }

        return SQL();
    }

}