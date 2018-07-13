package com.xlh.crm.domain.api;

import java.util.Date;

public class Mortgage {
    private Integer id;

    private String regNo;

    private String num;

    private String date;

    private String status;

    private String department;

    private String amount;

    private String type;

    private String period;

    private String scope;

    private String remarks;

    private String debitType;

    private String debitCurrency;

    private String debitAmount;

    private String debitScope;

    private String debitPeriod;

    private String debitRemarks;

    private String closeDate;

    private String closeReason;

    private String seqNo;

    private Date enttime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo == null ? null : regNo.trim();
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num == null ? null : num.trim();
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date == null ? null : date.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department == null ? null : department.trim();
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount == null ? null : amount.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period == null ? null : period.trim();
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope == null ? null : scope.trim();
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    public String getDebitType() {
        return debitType;
    }

    public void setDebitType(String debitType) {
        this.debitType = debitType == null ? null : debitType.trim();
    }

    public String getDebitCurrency() {
        return debitCurrency;
    }

    public void setDebitCurrency(String debitCurrency) {
        this.debitCurrency = debitCurrency == null ? null : debitCurrency.trim();
    }

    public String getDebitAmount() {
        return debitAmount;
    }

    public void setDebitAmount(String debitAmount) {
        this.debitAmount = debitAmount == null ? null : debitAmount.trim();
    }

    public String getDebitScope() {
        return debitScope;
    }

    public void setDebitScope(String debitScope) {
        this.debitScope = debitScope == null ? null : debitScope.trim();
    }

    public String getDebitPeriod() {
        return debitPeriod;
    }

    public void setDebitPeriod(String debitPeriod) {
        this.debitPeriod = debitPeriod == null ? null : debitPeriod.trim();
    }

    public String getDebitRemarks() {
        return debitRemarks;
    }

    public void setDebitRemarks(String debitRemarks) {
        this.debitRemarks = debitRemarks == null ? null : debitRemarks.trim();
    }

    public String getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(String closeDate) {
        this.closeDate = closeDate == null ? null : closeDate.trim();
    }

    public String getCloseReason() {
        return closeReason;
    }

    public void setCloseReason(String closeReason) {
        this.closeReason = closeReason == null ? null : closeReason.trim();
    }

    public String getSeqNo() {
        return seqNo;
    }

    public void setSeqNo(String seqNo) {
        this.seqNo = seqNo == null ? null : seqNo.trim();
    }

    public Date getEnttime() {
        return enttime;
    }

    public void setEnttime(Date enttime) {
        this.enttime = enttime;
    }
}