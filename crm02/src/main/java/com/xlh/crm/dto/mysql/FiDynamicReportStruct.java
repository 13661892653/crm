package com.xlh.crm.dto.mysql;

import javax.persistence.Id;

public class FiDynamicReportStruct {
    @Id
    private int id;
    private String reportTitle;
    private String interfaceUrl;
    private int needCheck;
    private int reportRow;
    private int reportCol;
    private String signClassName;
    private String insertTime;
    private String updateTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReportTitle() {
        return reportTitle;
    }

    public void setReportTitle(String reportTitle) {
        this.reportTitle = reportTitle;
    }

    public int getReportRow() {
        return reportRow;
    }

    public String getInterfaceUrl() {
        return interfaceUrl;
    }

    public void setInterfaceUrl(String interfaceUrl) {
        this.interfaceUrl = interfaceUrl;
    }

    public int getNeedCheck() {
        return needCheck;
    }

    public void setNeedCheck(int needCheck) {
        this.needCheck = needCheck;
    }

    public void setReportRow(int reportRow) {
        this.reportRow = reportRow;
    }

    public int getReportCol() {
        return reportCol;
    }

    public void setReportCol(int reportCol) {
        this.reportCol = reportCol;
    }

    public String getSignClassName() {
        return signClassName;
    }

    public void setSignClassName(String signClassName) {
        this.signClassName = signClassName;
    }

    public String getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(String insertTime) {
        this.insertTime = insertTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }
}
