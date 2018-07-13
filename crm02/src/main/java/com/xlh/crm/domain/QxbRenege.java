package com.xlh.crm.domain;

public class QxbRenege {
    private Integer id;

    private String qxbId;

    private String court;

    private String operName;

    private String province;

    private String docNumber;

    private String date;

    private String caseNumber;

    private String exDepartment;

    private String finalDuty;

    private String executionStatus;

    private String executionDesc;

    private String publishDate;

    private String number;

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

    public String getCourt() {
        return court;
    }

    public void setCourt(String court) {
        this.court = court == null ? null : court.trim();
    }

    public String getOperName() {
        return operName;
    }

    public void setOperName(String operName) {
        this.operName = operName == null ? null : operName.trim();
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getDocNumber() {
        return docNumber;
    }

    public void setDocNumber(String docNumber) {
        this.docNumber = docNumber == null ? null : docNumber.trim();
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date == null ? null : date.trim();
    }

    public String getCaseNumber() {
        return caseNumber;
    }

    public void setCaseNumber(String caseNumber) {
        this.caseNumber = caseNumber == null ? null : caseNumber.trim();
    }

    public String getExDepartment() {
        return exDepartment;
    }

    public void setExDepartment(String exDepartment) {
        this.exDepartment = exDepartment == null ? null : exDepartment.trim();
    }

    public String getFinalDuty() {
        return finalDuty;
    }

    public void setFinalDuty(String finalDuty) {
        this.finalDuty = finalDuty == null ? null : finalDuty.trim();
    }

    public String getExecutionStatus() {
        return executionStatus;
    }

    public void setExecutionStatus(String executionStatus) {
        this.executionStatus = executionStatus == null ? null : executionStatus.trim();
    }

    public String getExecutionDesc() {
        return executionDesc;
    }

    public void setExecutionDesc(String executionDesc) {
        this.executionDesc = executionDesc == null ? null : executionDesc.trim();
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate == null ? null : publishDate.trim();
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number == null ? null : number.trim();
    }

    public Integer getEnttime() {
        return enttime;
    }

    public void setEnttime(Integer enttime) {
        this.enttime = enttime;
    }
}