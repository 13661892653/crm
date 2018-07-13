package com.xlh.crm.domain;

public class QxbOwingTax {
    private Integer id;

    private String qxbId;

    private String taxpayerType;

    private String taxpayerNum;

    private String operName;

    private String operIdNum;

    private String address;

    private String overdueType;

    private String overdueAmount;

    private String currOverdueAmount;

    private String area;

    private String overduePeriod;

    private String pubDate;

    private String pubDepartment;

    private Integer enttime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQxbId() {
        return qxbId;
    }

    public void setQxbId(String qxbId) {
        this.qxbId = qxbId == null ? null : qxbId.trim();
    }

    public String getTaxpayerType() {
        return taxpayerType;
    }

    public void setTaxpayerType(String taxpayerType) {
        this.taxpayerType = taxpayerType == null ? null : taxpayerType.trim();
    }

    public String getTaxpayerNum() {
        return taxpayerNum;
    }

    public void setTaxpayerNum(String taxpayerNum) {
        this.taxpayerNum = taxpayerNum == null ? null : taxpayerNum.trim();
    }

    public String getOperName() {
        return operName;
    }

    public void setOperName(String operName) {
        this.operName = operName == null ? null : operName.trim();
    }

    public String getOperIdNum() {
        return operIdNum;
    }

    public void setOperIdNum(String operIdNum) {
        this.operIdNum = operIdNum == null ? null : operIdNum.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getOverdueType() {
        return overdueType;
    }

    public void setOverdueType(String overdueType) {
        this.overdueType = overdueType == null ? null : overdueType.trim();
    }

    public String getOverdueAmount() {
        return overdueAmount;
    }

    public void setOverdueAmount(String overdueAmount) {
        this.overdueAmount = overdueAmount == null ? null : overdueAmount.trim();
    }

    public String getCurrOverdueAmount() {
        return currOverdueAmount;
    }

    public void setCurrOverdueAmount(String currOverdueAmount) {
        this.currOverdueAmount = currOverdueAmount == null ? null : currOverdueAmount.trim();
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }

    public String getOverduePeriod() {
        return overduePeriod;
    }

    public void setOverduePeriod(String overduePeriod) {
        this.overduePeriod = overduePeriod == null ? null : overduePeriod.trim();
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate == null ? null : pubDate.trim();
    }

    public String getPubDepartment() {
        return pubDepartment;
    }

    public void setPubDepartment(String pubDepartment) {
        this.pubDepartment = pubDepartment == null ? null : pubDepartment.trim();
    }

    public Integer getEnttime() {
        return enttime;
    }

    public void setEnttime(Integer enttime) {
        this.enttime = enttime;
    }
}