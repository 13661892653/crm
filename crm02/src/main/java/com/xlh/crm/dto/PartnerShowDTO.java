package com.xlh.crm.dto;

import com.xlh.crm.common.CurrentTime;

/**
 * Created by ysl on 2017/5/26.
 */
public class PartnerShowDTO {

    //平台合作伙伴信息
    private String recId;  //记录ID

    private String company;  //归属分公司

    private String partnerLvId;  //合作伙伴等级ID

    private String partnerLvDesc;  //合作伙伴等级描述

    private String partnerType;  //合作伙伴类型

    private String creditNo;  //企业社会统一信用代码

    private String regNo;  //企业工商注册号

    private String partnerId;  //合作伙伴ID

    private String partnerName;  //合作伙伴名称

    private String entAddress;  //企业地址（工商注册）

    private String officeAddress;  //企业办公地址

    private String srvArea;  //服务区域

    private String bizScope;  //业务范围

    private String feePoint;  //扣点

    private String validFlag;  //是否有效

    private String remark;   //备注

    private String joinTime;   //入网时间

    private String rescindTime;   //离网时间

    private String contractNo;  //合同编号

    private String category;  //品类

    private String contactPerson;  //联系人

    private String contactPhone;  //电话

    private String email;  //邮箱

    private String bankAccount;  //银行账户

    private String updateTime;  //更新时间

    public String getRecId() {
        return recId;
    }

    public void setRecId(String recId) {
        this.recId = recId;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company == null ? null : company.trim();
    }

    public String getPartnerLvId() {
        return partnerLvId;
    }

    public void setPartnerLvId(String partnerLvId) {
        this.partnerLvId = partnerLvId == null ? null : partnerLvId.trim();
    }

    public String getPartnerLvDesc() {
        return partnerLvDesc;
    }

    public void setPartnerLvDesc(String partnerLvDesc) {
        this.partnerLvDesc = partnerLvDesc == null ? null : partnerLvDesc.trim();
    }

    public String getPartnerType() {
        return partnerType;
    }

    public void setPartnerType(String partnerType) {
        this.partnerType = partnerType == null ? null : partnerType.trim();
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

    public String getEntAddress() {
        return entAddress;
    }

    public void setEntAddress(String entAddress) {
        this.entAddress = entAddress == null ? null : entAddress.trim();
    }

    public String getOfficeAddress() {
        return officeAddress;
    }

    public void setCurAddress(String officeAddress) {
        this.officeAddress = officeAddress == null ? null : officeAddress.trim();
    }

    public String getSrvArea() {
        return srvArea;
    }

    public void setSrvArea(String srvArea) {
        this.srvArea = srvArea == null ? null : srvArea.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getBizScope() {
        return bizScope;
    }

    public void setBizScope(String bizScope) {
        this.bizScope = bizScope == null ? null : bizScope.trim();
    }

    public String getFeePoint() {
        return feePoint;
    }

    public void setFeePoint(String feePoint) {
        this.feePoint = feePoint == null ? null : feePoint.trim();
    }

    public String getValidFlag() {
        return validFlag;
    }

    public void setValidFlag(String validFlag) {
        this.validFlag = validFlag == null ? null : validFlag.trim();
    }

    public String getJoinTime() {
        return joinTime;
    }

    public void setJoinTime(String joinTime) {
        this.joinTime = joinTime == null ? null : joinTime.trim();
    }

    public String getRescindTime() {
        return rescindTime;
    }

    public void setRescindTime(String rescindTime) {
        this.rescindTime = rescindTime == null ? null : rescindTime.trim();
    }

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo == null ? null : contractNo.trim();
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category == null ? null : category.trim();
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson == null ? null : contactPerson.trim();
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone == null ? null : contactPhone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount == null ? null : bankAccount.trim();
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime == null ? null : updateTime.trim();
    }

}
