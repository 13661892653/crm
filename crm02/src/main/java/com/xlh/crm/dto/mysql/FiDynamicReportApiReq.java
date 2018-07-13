package com.xlh.crm.dto.mysql;

import javax.persistence.Id;
import java.util.Date;

public class FiDynamicReportApiReq {
    @Id
    private int id;
    private int reportId;
    private int recordId;
    private String reportTitle;
    private String fileName;
    private String enterpriseName;
    private String regCreditNo;
    private String reportDate;
    private int step;
    private int needCheck;
    private String reqJsonStr;
    private String remark;
    private Date insertTime;
    private Date updateTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public int getReportId() {
        return reportId;
    }

    public void setReportId(int reportId) {
        this.reportId = reportId;
    }

    public String getReportTitle() {
        return reportTitle;
    }

    public void setReportTitle(String reportTitle) {
        this.reportTitle = reportTitle;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public int getRecordId() {
        return recordId;
    }

    public void setRecordId(int recordId) {
        this.recordId = recordId;
    }

    public String getRegCreditNo() {
        return regCreditNo;
    }

    public void setRegCreditNo(String regCreditNo) {
        this.regCreditNo = regCreditNo;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }

    public int getNeedCheck() {
        return needCheck;
    }

    public void setNeedCheck(int needCheck) {
        this.needCheck = needCheck;
    }

    public String getReportDate() {
        return reportDate;
    }

    public void setReportDate(String reportDate) {
        this.reportDate = reportDate;
    }

    public String getReqJsonStr() {
        return reqJsonStr;
    }

    public void setReqJsonStr(String reqJsonStr) {
        this.reqJsonStr = reqJsonStr;
    }

    public Date getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
