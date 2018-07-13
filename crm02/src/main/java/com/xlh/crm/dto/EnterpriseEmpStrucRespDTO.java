package com.xlh.crm.dto;

/**
 * Created by ysl on 2017/5/26.
 */
public class EnterpriseEmpStrucRespDTO {

    //企业档案-公司人员结构
    private String regNo;

    private String creditNo;

    private String regCreditNo;

    private String staffNumber;

    private String collegeRate;

    private String undergraduateRate;

    private String masterRate;

    private String rdNumber;

    private String updateTime;  //更新时间

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

    public String getRegCreditNo() {
        return regCreditNo;
    }

    public void setRegCreditNo(String regCreditNo) {
        this.regCreditNo = regCreditNo == null ? null : regCreditNo.trim();
    }

    public String getStaffNumber() {
        return staffNumber;
    }

    public void setStaffNumber(String staffNumber) {
        this.staffNumber = staffNumber == null ? null : staffNumber.trim();
    }

    public String getCollegeRate() {
        return collegeRate;
    }

    public void setCollegeRate(String collegeRate) {
        this.collegeRate = collegeRate == null ? null : collegeRate.trim();
    }

    public String getUndergraduateRate() {
        return undergraduateRate;
    }

    public void setUndergraduateRate(String undergraduateRate) {
        this.undergraduateRate = undergraduateRate == null ? null : undergraduateRate.trim();
    }

    public String getMasterRate() {
        return masterRate;
    }

    public void setMasterRate(String masterRate) {
        this.masterRate = masterRate == null ? null : masterRate.trim();
    }

    public String getRdNumber() {
        return rdNumber;
    }

    public void setRdNumber(String rdNumber) {
        this.rdNumber = rdNumber == null ? null : rdNumber.trim();
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime == null ? null : updateTime.trim();
    }
}
