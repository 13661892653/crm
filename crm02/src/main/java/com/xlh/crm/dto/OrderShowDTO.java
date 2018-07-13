package com.xlh.crm.dto;

import java.security.Timestamp;
import java.util.Date;

/**
 * Created by ysl on 2017/5/26.
 */
public class OrderShowDTO {

    //订单信息定义
    private String orderType;  //订单类型

    private String orderNo;  //订单号

    private String orderDate;  //下单日期

    private String orderMemeberName;  //下单人

    private String enterpriseName;  //下单企业

    private String custName;  //下单客户名称

    private String creditNo;  //下单企业社会统一信用代码

    private String regNo;  //下单企业工商注册号

    private String regCreditNo;  //下单企业工商注册号、统一信用代码

    private String bizLv1Name;  //商品所属一级业务类目

    private String bizLv2Name;  //商品所属二级业务类目

    private String bizLv3Name;  //商品所属三级业务类目

    private String orderProdId;  //采购商品ID

    private String orderProdName;  //采购商品名

    private Integer orderNum;  //订单数量

    private Double orderPrice;  //订单单价

    private Double orderAmt;  //订单总额

    private String payMode;  //支付方式

    private String payStatus;  //支付状态

    private String orderStatus;  //订单状态

    private String isSelfBiz;    //是否自营订单

    private String partnerId;    //平台服务商ID

    private String partnerName;    //平台服务商名称

    private String dockingTime;    //服务商对接时间

    private String progress;    //完成进度

    private String closeTime;    //完成时间

    private String remark;  //备注

    private String merchandiser;  //跟单人

    private String company;  //所属分公司

    private String assignMerchandiserDate;  //分配跟单日期

    private String updateTime;  //更新时间

    private int recCnt = 0;

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType == null ? null : orderType.trim();
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderMemeberName() {
        return orderMemeberName;
    }

    public void setOrderMemeberName(String orderMemeberName) {
        this.orderMemeberName = orderMemeberName == null ? null : orderMemeberName.trim();
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName == null ? null : enterpriseName.trim();
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName == null ? null : custName.trim();
    }

    public String getCreditNo() {
        return creditNo;
    }

    public void setCreditNo(String creditNo) {
        this.creditNo = creditNo == null ? null : creditNo.trim();
    }

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo == null ? null : regNo.trim();
    }

    public String getRegCreditNo() {
        return regCreditNo;
    }

    public void setRegCreditNo(String regCreditNo) {
        this.regCreditNo = regCreditNo == null ? null : regCreditNo.trim();
    }

    public String getBizLv1Name() {
        return bizLv1Name;
    }

    public void setBizLv1Name(String bizLv1Name) {
        this.bizLv1Name = bizLv1Name == null ? null : bizLv1Name.trim();
    }

    public String getBizLv2Name() {
        return bizLv2Name;
    }

    public void setBizLv2Name(String bizLv2Name) {
        this.bizLv2Name = bizLv2Name == null ? null : bizLv2Name.trim();
    }

    public String getBizLv3Name() {
        return bizLv3Name;
    }

    public void setBizLv3Name(String bizLv3Name) {
        this.bizLv3Name = bizLv3Name == null ? null : bizLv3Name.trim();
    }

    public String getOrderProdId() {
        return orderProdId;
    }

    public void setOrderProdId(String orderProdId) {
        this.orderProdId = orderProdId == null ? null : orderProdId.trim();
    }

    public String getOrderProdName() {
        return orderProdName;
    }

    public void setOrderProdName(String orderProdName) {
        this.orderProdName = orderProdName == null ? null : orderProdName.trim();
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public Double getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(Double orderPrice) {
        this.orderPrice = orderPrice;
    }

    public Double getOrderAmt() {
        return orderAmt;
    }

    public void setOrderAmt(Double orderAmt) {
        this.orderAmt = orderAmt;
    }

    public String getPayMode() {
        return payMode;
    }

    public void setPayMode(String payMode) {
        this.payMode = payMode == null ? null : payMode.trim();
    }

    public String getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(String payStatus) {
        this.payStatus = payStatus == null ? null : payStatus.trim();
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus == null ? null : orderStatus.trim();
    }

    public String getIsSelfBiz() {
        return isSelfBiz;
    }

    public void setIsSelfBiz(String isSelfBiz) {
        this.isSelfBiz = isSelfBiz == null ? null : isSelfBiz.trim();
    }

    public String getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId == null ? null : partnerId.trim();
    }

    public String getPartnerName() {
        return partnerName;
    }

    public void setPartnerName(String partnerName) {
        this.partnerName = partnerName == null ? null : partnerName.trim();
    }

    public String getDockingTime() {
        return dockingTime;
    }

    public void setDockingTime(String dockingTime) {
        this.dockingTime = dockingTime == null ? null : dockingTime.trim();
    }

    public String getProgress() {
        return progress;
    }

    public void setProgress(String progress) {
        this.progress = progress == null ? null : progress.trim();
    }

    public String getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(String closeTime) {
        this.closeTime = closeTime == null ? null : closeTime.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getMerchandiser() {
        return merchandiser;
    }

    public void setMerchandiser(String merchandiser) {
        this.merchandiser = merchandiser == null ? null : merchandiser.trim();
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company == null ? null : company.trim();
    }

    public String getAssignMerchandiserDate() {
        return assignMerchandiserDate;
    }

    public void setAssignMerchandiserDate(String assignMerchandiserDate) {
        this.assignMerchandiserDate = assignMerchandiserDate;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime == null ? null : updateTime.trim();
    }

    public Integer getRecCnt() {
        return recCnt;
    }

    public void setRecCnt(Integer recCnt) {
        this.recCnt = recCnt;
    }
}
