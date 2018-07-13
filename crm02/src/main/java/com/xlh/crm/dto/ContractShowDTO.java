package com.xlh.crm.dto;

/**
 * Created by ysl on 2017/5/26.
 */
public class ContractShowDTO {

    //合同信息
    private String recId;  //记录ID

    private String contractType;  //合同类型

    private String contractNo;  //合同编号

    private String contractTitle;  //合同标题

    private String contractEnterprise;  //合同主体

    private String orderNo;  //订单编号

    private String bizLv1Id;  //一级业务ID

    private String bizLv1Name;  //一级业务名称

    private String orderProdId;  //产品ID

    private String orderProdName;  //产品名称

    private String contractDate;  //合同签订日期

    private String contractAmt;  //合同金额

    private Double income;  //到账收入

    private String incomeUnit;  //到账收入单位（万人民币）

    private Double profit;  //利润

    private String profitUnit;   //利润单位（万人民币）

    private String profitRate;   //利润率

    private String incomeExpDate;   //预计到账日期

    private String partnerId;  //合作伙伴ID

    private String partnerName;  //合作伙伴名称

    private String remark;  //备注

    private String linkAddress;  //合同附件链接地址

    private String operator;  //操作人

    private String company;  //所属分公司

    private String updateTime;  //更新时间

    public String getRecId() {
        return recId;
    }

    public void setRecId(String recId) {
        this.recId = recId;
    }

    public String getContractType() {
        return contractType;
    }

    public void setContractType(String contractType) {
        this.contractType = contractType == null ? null : contractType.trim();
    }

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo == null ? null : contractNo.trim();
    }

    public String getContractTitle() {
        return contractTitle;
    }

    public void setContractTitle(String contractTitle) {
        this.contractTitle = contractTitle == null ? null : contractTitle.trim();
    }

    public String getContractEnterprise() {
        return contractEnterprise;
    }

    public void setContractEnterprise(String contractEnterprise) {
        this.contractEnterprise = contractEnterprise == null ? null : contractEnterprise.trim();
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    public String getBizLv1Id() {
        return bizLv1Id;
    }

    public void setBizLv1Id(String bizLv1Id) {
        this.bizLv1Id = bizLv1Id == null ? null : bizLv1Id.trim();
    }

    public String getBizLv1Name() {
        return bizLv1Name;
    }

    public void setBizLv1Name(String bizLv1Name) {
        this.bizLv1Name = bizLv1Name == null ? null : bizLv1Name.trim();
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

    public String getContractDate() {
        return contractDate;
    }

    public void setContractDate(String contractDate) {
        this.contractDate = contractDate == null ? null : contractDate.trim();
    }

    public String getContractAmt() {
        return contractAmt;
    }

    public void setContractAmt(String contractAmt) {
        this.contractAmt = contractAmt == null ? null : contractAmt.trim();
    }

    public Double getIncome() {
        return income;
    }

    public void setIncome(Double income) {
        this.income = income;
    }

    public String getIncomeUnit() {
        return incomeUnit;
    }

    public void setIncomeUnit(String incomeUnit) {
        this.incomeUnit = incomeUnit == null ? null : incomeUnit.trim();
    }

    public Double getProfit() {
        return profit;
    }

    public void setProfit(Double profit) {
        this.profit = profit;
    }

    public String getProfitUnit() {
        return profitUnit;
    }

    public void setProfitUnit(String profitUnit) {
        this.profitUnit = profitUnit == null ? null : profitUnit.trim();
    }

    public String getProfitRate() {
        return profitRate;
    }

    public void setProfitRate(String profitRate) {
        this.profitRate = profitRate == null ? null : profitRate.trim();
    }

    public String getIncomeExpDate() {
        return incomeExpDate;
    }

    public void setIncomeExpDate(String incomeExpDate) {
        this.incomeExpDate = incomeExpDate == null ? null : incomeExpDate.trim();
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getLinkAddress() {
        return linkAddress;
    }

    public void setLinkAddress(String linkAddress) {
        this.linkAddress = linkAddress == null ? null : linkAddress.trim();
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company == null ? null : company.trim();
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime == null ? null : updateTime.trim();
    }

}
