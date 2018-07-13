package com.xlh.crm.dto.dynamicReport;

import com.xlh.crm.dto.mysql.FiDynamicReportColumn;
import com.xlh.crm.dto.mysql.FiDynamicReportStruct;

import java.util.List;

public class DynamicReport {
    private int id;
    private String reportTitle;
    private String interfaceUrl;
    private int needCheck;
    private int reportRow;
    private int reportCol;
    private String signClassName;
    private List<FiDynamicReportColumn> fiDynamicReportColumnList;

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

    public String getSignClassName() {
        return signClassName;
    }

    public void setSignClassName(String signClassName) {
        this.signClassName = signClassName;
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

    public List<FiDynamicReportColumn> getFiDynamicReportColumnList() {
        return fiDynamicReportColumnList;
    }

    public void setFiDynamicReportColumnList(List<FiDynamicReportColumn> fiDynamicReportColumnList) {
        this.fiDynamicReportColumnList = fiDynamicReportColumnList;
    }
}
