package com.xlh.crm.dto;

import java.util.Date;

/**
 * Created by ysl on 2017/5/26.
 */
public class EnterpriseShowDTO {

    //企业数据库展示字段定义
    private Integer id=null;

    private String regCreditNo = null;

    private String regNo = null;

    private String creditNo = null;

    private String enterpriseName = null;

    private int matCompScore;

    private String areaProvince;

    private String areaCity;

    private String industryTypeCode;

    private String industryTypeName;

    private String industryCode;

    private String industryName;

    private String mainIndustry;

    private Date createDate;

    private String registerMoney;

    private String mgmtStatus;

    private String corpInfo;

    private String contactFixedPhone;

    private String contactMobiPhone;

    private String legalRepresentative;

    private String entAddress = null;

    private String contactPerson;

    private String assetsCategoryCode;

    private String assetsCategory;

    private String assetsLevel;

    private String assetsSourceCode;

    private String assetsSourceDesc;

    private Integer hotIndex;

    private String tagArray;

    private String validFlag;

    private String eventId;

    private String isHaveFinance;

    private String dataSourceCode;

    private String dataSourceDesc;

    private String initFlag;

    private Integer custManagerId;
    private String custManager;
    private String custManagerUpdateTime;

    private Integer favUserId;
    private String favUserList;

    private String favId;     //收藏记录ID：企业收藏夹用

    private String entType;   //企业类型：企业收藏夹用

    private String company;

    private String archivesEditor;  //档案编辑人

    private String editModule;      //档案编辑模块

    private int gqScore;
    private String insertTime;
    private String updateTime;

    private int recCnt = 0;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCustManagerUpdateTime() {
        return custManagerUpdateTime;
    }

    public void setCustManagerUpdateTime(String custManagerUpdateTime) {
        this.custManagerUpdateTime = custManagerUpdateTime;
    }

    public Integer getCustManagerId() {
        return custManagerId;
    }

    public void setCustManagerId(Integer custManagerId) {
        this.custManagerId = custManagerId;
    }

    public Integer getFavUserId() {
        return favUserId;
    }

    public void setFavUserId(Integer favUserId) {
        this.favUserId = favUserId;
    }

    public String getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(String insertTime) {
        this.insertTime = insertTime;
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

    public int getMatCompScore() {
        return matCompScore;
    }

    public void setMatCompScore(int matCompScore) {
        this.matCompScore = matCompScore;
    }

    public String getAreaProvince() {
        return areaProvince;
    }

    public void setAreaProvince(String areaProvince) {
        this.areaProvince = areaProvince == null ? null : areaProvince.trim();
    }

    public String getAreaCity() {
        return areaCity;
    }

    public void setAreaCity(String areaCity) {
        this.areaCity = areaCity == null ? null : areaCity.trim();
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

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
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

    public String getContactFixedPhone() {
        return contactFixedPhone;
    }

    public void setContactFixedPhone(String contactFixedPhone) {
        this.contactFixedPhone = contactFixedPhone == null ? null : contactFixedPhone.trim();
    }

    public String getContactMobiPhone() {
        return contactMobiPhone;
    }

    public void setContactMobiPhone(String contactMobiPhone) {
        this.contactMobiPhone = contactMobiPhone == null ? null : contactMobiPhone.trim();
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

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson == null ? null : contactPerson.trim();
    }

    public String getAssetsCategoryCode() {
        return assetsCategoryCode;
    }

    public void setAssetsCategoryCode(String assetsCategoryCode) {
        this.assetsCategoryCode = assetsCategoryCode == null ? null : assetsCategoryCode.trim();
    }

    public String getAssetsCategory() {
        return assetsCategory;
    }

    public void setAssetsCategory(String assetsCategory) {
        this.assetsCategory = assetsCategory == null ? null : assetsCategory.trim();
    }

    public String getAssetsLevel() {
        return assetsLevel;
    }

    public void setAssetsLevel(String assetsLevel) {
        this.assetsLevel = assetsLevel == null ? null : assetsLevel.trim();
    }

    public String getAssetsSourceCode() {
        return assetsSourceCode;
    }

    public void setAssetsSourceCode(String assetsSourceCode) {
        this.assetsSourceCode = assetsSourceCode == null ? null : assetsSourceCode.trim();
    }

    public String getAssetsSourceDesc() {
        return assetsSourceDesc;
    }

    public void setAssetsSourceDesc(String assetsSourceDesc) {
        this.assetsSourceDesc = assetsSourceDesc == null ? null : assetsSourceDesc.trim();
    }

    public Integer getHotIndex() {
        return hotIndex;
    }

    public void setHotIndex(Integer hotIndex) {
        this.hotIndex = hotIndex;
    }

    public String getTagArray() {
        return tagArray;
    }

    public void setTagArray(String tagArray) {
        this.tagArray = tagArray == null ? null : tagArray.trim();
    }

    public String getValidFlag() {
        return validFlag;
    }

    public void setValidFlag(String validFlag) {
        this.validFlag = validFlag == null ? null : validFlag.trim();
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId == null ? null : eventId.trim();
    }

    public String getIsHaveFinance() {
        return isHaveFinance;
    }

    public void setIsHaveFinance(String isHaveFinance) {
        this.isHaveFinance = isHaveFinance == null ? null : isHaveFinance.trim();
    }

    public String getDataSourceCode() {
        return dataSourceCode;
    }

    public void setDataSourceCode(String dataSourceCode) {
        this.dataSourceCode = dataSourceCode == null ? null : dataSourceCode.trim();
    }

    public String getDataSourceDesc() {
        return dataSourceDesc;
    }

    public void setDataSourceDesc(String dataSourceDesc) {
        this.dataSourceDesc = dataSourceDesc == null ? null : dataSourceDesc.trim();
    }

    public String getInitFlag() {
        return initFlag;
    }

    public void setInitFlag(String initFlag) {
        this.initFlag = initFlag == null ? null : initFlag.trim();
    }

    public String getCustManager() {
        return custManager;
    }

    public void setCustManager(String custManager) {
        this.custManager = custManager == null ? null : custManager.trim();
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

    public String getEntType() {
        return entType;
    }

    public void setEntType(String entType) {
        this.entType = entType == null ? null : entType.trim();
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company == null ? null : company.trim();
    }

    public String getArchivesEditor() {
        return archivesEditor;
    }

    public void setArchivesEditor(String archivesEditor) {
        this.archivesEditor = archivesEditor == null ? null : archivesEditor.trim();
    }

    public String getEditModule() {
        return editModule;
    }

    public void setEditModule(String editModule) {
        this.editModule = editModule == null ? null : editModule.trim();
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

    public int getGqScore() {
        return gqScore;
    }

    public void setGqScore(int gqScore) {
        this.gqScore = gqScore;
    }

    public void setRecCnt(Integer recCnt) {
        this.recCnt = recCnt;
    }
}
