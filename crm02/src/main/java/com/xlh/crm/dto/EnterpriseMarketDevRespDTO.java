package com.xlh.crm.dto;

/**
 * Created by ysl on 2017/5/26.
 */
public class EnterpriseMarketDevRespDTO {

    //企业档案-市场发展情况

    private String regCreditNo;

    private String creditNo;

    private String regNo;

    private String devStage;

    private String marketRate;

    private String businessPattern;

    private String coreCompetence;

    private String fiveCustomer;

    private String fiveSupplier;

    private String majorCompetitors;

    private String prodBizSubmit;

    private String curReqInfo;

    private String infoSuggestions;

    private String updateTime;  //更新时间

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


    public String getDevStage() {
        return devStage;
    }

    public void setDevStage(String devStage) {
        this.devStage = devStage == null ? null : devStage.trim();
    }

    public String getMarketRate() {
        return marketRate;
    }

    public void setMarketRate(String marketRate) {
        this.marketRate = marketRate == null ? null : marketRate.trim();
    }

    public String getBusinessPattern() {
        return businessPattern;
    }

    public void setBusinessPattern(String businessPattern) {
        this.businessPattern = businessPattern == null ? null : businessPattern.trim();
    }

    public String getCoreCompetence() {
        return coreCompetence;
    }

    public void setCoreCompetence(String coreCompetence) {
        this.coreCompetence = coreCompetence == null ? null : coreCompetence.trim();
    }

    public String getFiveCustomer() {
        return fiveCustomer;
    }

    public void setFiveCustomer(String fiveCustomer) {
        this.fiveCustomer = fiveCustomer == null ? null : fiveCustomer.trim();
    }

    public String getFiveSupplier() {
        return fiveSupplier;
    }

    public void setFiveSupplier(String fiveSupplier) {
        this.fiveSupplier = fiveSupplier == null ? null : fiveSupplier.trim();
    }

    public String getMajorCompetitors() {
        return majorCompetitors;
    }

    public void setMajorCompetitors(String majorCompetitors) {
        this.majorCompetitors = majorCompetitors == null ? null : majorCompetitors.trim();
    }

    public String getProdBizSubmit() {
        return prodBizSubmit;
    }

    public void setProdBizSubmit(String prodBizSubmit) {
        this.prodBizSubmit = prodBizSubmit == null ? null : prodBizSubmit.trim();
    }

    public String getCurReqInfo() {
        return curReqInfo;
    }

    public void setCurReqInfo(String curReqInfo) {
        this.curReqInfo = curReqInfo == null ? null : curReqInfo.trim();
    }

    public String getInfoSuggestions() {
        return infoSuggestions;
    }

    public void setInfoSuggestions(String infoSuggestions) {
        this.infoSuggestions = infoSuggestions == null ? null : infoSuggestions.trim();
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime == null ? null : updateTime.trim();
    }
}
