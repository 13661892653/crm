package com.xlh.crm.domain.api;

import java.util.Date;

public class EquityPledge {
    private Integer id;

    private String regNo;

    private String number;

    private String pledgor;

    private String pledgorIdentifyType;

    private String pledgorIdentifyNo;

    private String pledgorAmount;

    private String pledgorUnit;

    private String pledgorCurrency;

    private String pawnee;

    private String pawneeIdentifyType;

    private String pawneeIdentifyNo;

    private String status;

    private String date;

    private String remark;

    private String changeItemsSeqNo;

    private String changeItemsChangeDate;

    private String changeItemsChangeContent;

    private String seqNo;

    private Date enttime;

    private String sqlNo;

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

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number == null ? null : number.trim();
    }

    public String getPledgor() {
        return pledgor;
    }

    public void setPledgor(String pledgor) {
        this.pledgor = pledgor == null ? null : pledgor.trim();
    }

    public String getPledgorIdentifyType() {
        return pledgorIdentifyType;
    }

    public void setPledgorIdentifyType(String pledgorIdentifyType) {
        this.pledgorIdentifyType = pledgorIdentifyType == null ? null : pledgorIdentifyType.trim();
    }

    public String getPledgorIdentifyNo() {
        return pledgorIdentifyNo;
    }

    public void setPledgorIdentifyNo(String pledgorIdentifyNo) {
        this.pledgorIdentifyNo = pledgorIdentifyNo == null ? null : pledgorIdentifyNo.trim();
    }

    public String getPledgorAmount() {
        return pledgorAmount;
    }

    public void setPledgorAmount(String pledgorAmount) {
        this.pledgorAmount = pledgorAmount == null ? null : pledgorAmount.trim();
    }

    public String getPledgorUnit() {
        return pledgorUnit;
    }

    public void setPledgorUnit(String pledgorUnit) {
        this.pledgorUnit = pledgorUnit == null ? null : pledgorUnit.trim();
    }

    public String getPledgorCurrency() {
        return pledgorCurrency;
    }

    public void setPledgorCurrency(String pledgorCurrency) {
        this.pledgorCurrency = pledgorCurrency == null ? null : pledgorCurrency.trim();
    }

    public String getPawnee() {
        return pawnee;
    }

    public void setPawnee(String pawnee) {
        this.pawnee = pawnee == null ? null : pawnee.trim();
    }

    public String getPawneeIdentifyType() {
        return pawneeIdentifyType;
    }

    public void setPawneeIdentifyType(String pawneeIdentifyType) {
        this.pawneeIdentifyType = pawneeIdentifyType == null ? null : pawneeIdentifyType.trim();
    }

    public String getPawneeIdentifyNo() {
        return pawneeIdentifyNo;
    }

    public void setPawneeIdentifyNo(String pawneeIdentifyNo) {
        this.pawneeIdentifyNo = pawneeIdentifyNo == null ? null : pawneeIdentifyNo.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date == null ? null : date.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getChangeItemsSeqNo() {
        return changeItemsSeqNo;
    }

    public void setChangeItemsSeqNo(String changeItemsSeqNo) {
        this.changeItemsSeqNo = changeItemsSeqNo == null ? null : changeItemsSeqNo.trim();
    }

    public String getChangeItemsChangeDate() {
        return changeItemsChangeDate;
    }

    public void setChangeItemsChangeDate(String changeItemsChangeDate) {
        this.changeItemsChangeDate = changeItemsChangeDate == null ? null : changeItemsChangeDate.trim();
    }

    public String getChangeItemsChangeContent() {
        return changeItemsChangeContent;
    }

    public void setChangeItemsChangeContent(String changeItemsChangeContent) {
        this.changeItemsChangeContent = changeItemsChangeContent == null ? null : changeItemsChangeContent.trim();
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

    public String getSqlNo() {
        return sqlNo;
    }

    public void setSqlNo(String sqlNo) {
        this.sqlNo = sqlNo == null ? null : sqlNo.trim();
    }
}