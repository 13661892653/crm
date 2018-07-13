package com.xlh.crm.domain;

public class QxbPatent {
    private Integer id;

    private String qxbId;

    private String patentName;

    private String typeName;

    private String requestDate;

    private String requestNum;

    private String outhorNum;

    private String designer;

    private String categoryNum;

    private String brief;

    private String outhorDate;

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

    public String getPatentName() {
        return patentName;
    }

    public void setPatentName(String patentName) {
        this.patentName = patentName == null ? null : patentName.trim();
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName == null ? null : typeName.trim();
    }

    public String getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(String requestDate) {
        this.requestDate = requestDate == null ? null : requestDate.trim();
    }

    public String getRequestNum() {
        return requestNum;
    }

    public void setRequestNum(String requestNum) {
        this.requestNum = requestNum == null ? null : requestNum.trim();
    }

    public String getOuthorNum() {
        return outhorNum;
    }

    public void setOuthorNum(String outhorNum) {
        this.outhorNum = outhorNum == null ? null : outhorNum.trim();
    }

    public String getDesigner() {
        return designer;
    }

    public void setDesigner(String designer) {
        this.designer = designer == null ? null : designer.trim();
    }

    public String getCategoryNum() {
        return categoryNum;
    }

    public void setCategoryNum(String categoryNum) {
        this.categoryNum = categoryNum == null ? null : categoryNum.trim();
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief == null ? null : brief.trim();
    }

    public String getOuthorDate() {
        return outhorDate;
    }

    public void setOuthorDate(String outhorDate) {
        this.outhorDate = outhorDate == null ? null : outhorDate.trim();
    }

    public Integer getEnttime() {
        return enttime;
    }

    public void setEnttime(Integer enttime) {
        this.enttime = enttime;
    }
}