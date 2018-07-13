package com.xlh.crm.dto;

/**
 * Created by ysl on 2017/5/26.
 */
public class EnterpriseContactsRespDTO {

    //企业档案-公司联系人
    private String recId;

    private String enterpriseName;

    private String regCreditNo;

    private String creditNo;

    private String regNo;

    private String name;

    private String jobTitle;

    private String contactMobiPhone;

    private String contactFixedPhone;

    private String email;

    private String updateTime;  //更新时间

    public String getRecId() {
        return recId;
    }

    public void setRecId(String recId) {
        this.recId = recId;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle == null ? null : jobTitle.trim();
    }

    public String getContactMobiPhone() {
        return contactMobiPhone;
    }

    public void setContactMobiPhone(String contactMobiPhone) {
        this.contactMobiPhone = contactMobiPhone == null ? null : contactMobiPhone.trim();
    }

    public String getContactFixedPhone() {
        return contactFixedPhone;
    }

    public void setContactFixedPhone(String contactFixedPhone) {
        this.contactFixedPhone = contactFixedPhone == null ? null : contactFixedPhone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime == null ? null : updateTime.trim();
    }
}
