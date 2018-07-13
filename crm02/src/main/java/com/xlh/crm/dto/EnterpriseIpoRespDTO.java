package com.xlh.crm.dto;

/**
 * Created by ysl on 2017/5/26.
 */
public class EnterpriseIpoRespDTO {

    //企业档案-上市情况
    private String regCreditNo;

    private String creditNo;

    private String regNo;

    private String ipoStage;

    private String ipoDate;

    private String ipoSector;

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

    public String getIpoStage() {
        return ipoStage;
    }

    public void setIpoStage(String ipoStage) {
        this.ipoStage = ipoStage == null ? null : ipoStage.trim();
    }

    public String getIpoDate() {
        return ipoDate;
    }

    public void setIpoDate(String ipoDate) {
        this.ipoDate = ipoDate == null ? null : ipoDate.trim();
    }

    public String getIpoSector() {
        return ipoSector;
    }

    public void setIpoSector(String ipoSector) {
        this.ipoSector = ipoSector == null ? null : ipoSector.trim();
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime == null ? null : updateTime.trim();
    }
}
