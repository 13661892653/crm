package com.xlh.crm.dto;

import java.util.Date;

/**
 * Created by ysl on 2017/5/26.
 */
public class EnterpriseReachcsrRespDTO {

    //企业档案-触达信息
    private String rchNo;   //触达信息编号

    private String rchMode;   //触达方式

    private String rchEmp;   //触达人

    private String beginTime;   //开始时间

    private String endTime;     //结束时间

    private String winCustChnl;   //获客渠道

    private String contacts;   //接触人

    private String salesLead;   //潜在销售机会

    private String contactsPhone;   //联系方式

    private String remark;

    public String getRchNo() {
        return rchNo;
    }

    public void setRchNo(String rchNo) {
        this.rchNo = rchNo == null ? null : rchNo.trim();
    }

    public String getRchMode() {
        return rchMode;
    }

    public void setRchMode(String rchMode) {
        this.rchMode = rchMode == null ? null : rchMode.trim();
    }

    public String getWinCustChnl() {
        return winCustChnl;
    }

    public void setWinCustChnl(String winCustChnl) {
        this.winCustChnl = winCustChnl == null ? null : winCustChnl.trim();
    }

    public String getRchEmp() {
        return rchEmp;
    }

    public void setRchEmp(String rchEmp) {
        this.rchEmp = rchEmp == null ? null : rchEmp.trim();
    }

    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime == null ? null : beginTime.trim();
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime == null ? null : endTime.trim();
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts == null ? null : contacts.trim();
    }

    public String getContactsPhone() {
        return contactsPhone;
    }

    public void setContactsPhone(String contactsPhone) {
        this.contactsPhone = contactsPhone == null ? null : contactsPhone.trim();
    }

    public String getSalesLead() {
        return salesLead;
    }

    public void setSalesLead(String salesLead) {
        this.salesLead = salesLead == null ? null : salesLead.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}
