package com.xlh.crm.dto;

import java.util.Date;

/**
 * Created by ysl on 2017/5/26.
 */
public class EnterpriseBaseInfoRespDTO {

    //企业档案-基本信息
    private int auditStatus = 0;

    private String custManager;

    private String enterpriseName;

    private String regCreditNo;

    private String creditNo;

    private String regNo;

    private String mgmtStatus;

    private String econKind;

    private String legalRepresentative;

    private String operateDate;

    private String contactTelephone;

    private String contactEmail;

    private String entAddress;

    private String createDate;

    private String industryTypeCode;

    private String industryTypeName;

    private String industryCode;

    private String industryName;

    private String mainIndustry;

    private String mainProduct;     //主要产品（服务）

    private String mgmtScope;

    private String registerMoney;

    private String corpInfo;

    private String tagArray;

    private String favUserList;

    private String favId;   //收藏记录ID

    private String memberPhone;  //企业收藏页面用到，废弃

    private String userName;  //企业收藏页面用分配客户经理
    private Integer memberId; //客户经理会员id

    private String company;  //企业收藏页面用到

    private int recCnt = 0;

    private String updateTime;  //更新时间

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public int getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(int auditStatus) {
        this.auditStatus = auditStatus;
    }

    public String getCustManager() {
        return custManager;
    }

    public void setCustManager(String custManager) {
        this.custManager = custManager == null ? null : custManager.trim();
    }

    public String getRegCreditNo() {
        return regCreditNo;
    }

    public void setRegCreditNo(String regCreditNo) {
        this.regCreditNo = regCreditNo == null ? null : regCreditNo.trim();
    }

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo == null ? null : regNo.trim();
    }

    public String getCreditNo() {
        return creditNo;
    }

    public void setCreditNo(String creditNo) {
        this.creditNo = creditNo == null ? null : creditNo.trim();
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName == null ? null : enterpriseName.trim();
    }

    public String getEconKind() {
        return econKind;
    }

    public void setEconKind(String econKind) {
        this.econKind = econKind == null ? null : econKind.trim();
    }

    public String getOperateDate() {
        return operateDate;
    }

    public void setOperateDate(String operateDate) {
        this.operateDate = operateDate == null ? null : operateDate.trim();
    }

    public String getIndustryTypeCode() {
        return industryTypeCode;
    }

    public void setIndustryTypeCode(String industryTypeCode) {
        this.industryTypeCode = industryTypeCode == null ? null : industryTypeCode.trim();
    }

    public String getIndustryTypeName() {
        return industryTypeName;
    }

    public void setIndustryTypeName(String industryTypeName) {
        this.industryTypeName = industryTypeName == null ? null : industryTypeName.trim();
    }

    public String getIndustryCode() {
        return industryCode;
    }

    public void setIndustryCode(String industryCode) {
        this.industryCode = industryCode == null ? null : industryCode.trim();
    }

    public String getIndustryName() {
        return industryName;
    }

    public void setIndustryName(String industryName) {
        this.industryName = industryName == null ? null : industryName.trim();
    }

    public String getMainIndustry() {
        return mainIndustry;
    }

    public void setMainIndustry(String mainIndustry) {
        this.mainIndustry = mainIndustry == null ? null : mainIndustry.trim();
    }

    public String getMainProduct() {
        return mainProduct;
    }

    public void setMainProduct(String mainProduct) {
        this.mainProduct = mainProduct;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getRegisterMoney() {
        return registerMoney;
    }

    public void setRegisterMoney(String registerMoney) {
        this.registerMoney = registerMoney == null ? null : registerMoney.trim();
    }

    public String getMgmtStatus() {
        return mgmtStatus;
    }

    public void setMgmtStatus(String mgmtStatus) {
        this.mgmtStatus = mgmtStatus == null ? null : mgmtStatus.trim();
    }

    public String getCorpInfo() {
        return corpInfo;
    }

    public void setCorpInfo(String corpInfo) {
        this.corpInfo = corpInfo == null ? null : corpInfo.trim();
    }

    public String getMgmtScope() {
        return mgmtScope;
    }

    public void setMgmtScope(String mgmtScope) {
        this.mgmtScope = mgmtScope == null ? null : mgmtScope.trim();
    }

    public String getLegalRepresentative() {
        return legalRepresentative;
    }

    public void setLegalRepresentative(String legalRepresentative) {
        this.legalRepresentative = legalRepresentative == null ? null : legalRepresentative.trim();
    }

    public String getEntAddress() {
        return entAddress;
    }

    public void setEntAddress(String entAddress) {
        this.entAddress = entAddress == null ? null : entAddress.trim();
    }

    public String getContactTelephone() {
        return contactTelephone;
    }

    public void setContactTelephone(String contactTelephone) {
        this.contactTelephone = contactTelephone == null ? null : contactTelephone.trim();
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail == null ? null : contactEmail.trim();
    }

    public String getTagArray() {
        return tagArray;
    }

    public void setTagArray(String tagArray) {
        this.tagArray = tagArray == null ? null : tagArray.trim();
    }

    public String getFavUserList() {
        return favUserList;
    }

    public void setFavUserList(String favUserList) {
        this.favUserList = favUserList == null ? null : favUserList.trim();
    }

    public String getFavId() {
        return favId;
    }

    public void setFavId(String favId) {
        this.favId = favId == null ? null : favId.trim();
    }

    public String getMemberPhone() {
        return memberPhone;
    }

    public void setMemberPhone(String memberPhone) {
        this.memberPhone = memberPhone == null ? null : memberPhone.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
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

    public Integer getRecCnt() {
        return recCnt;
    }

    public void setRecCnt(Integer recCnt) {
        this.recCnt = recCnt;
    }
}
