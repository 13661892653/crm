package com.xlh.crm.dto.mysql;

import com.xlh.crm.dto.financeinputshow.JXSmallBalanceTableDto;

import javax.persistence.Id;

public class FiJxSmallBalanceTable extends JXSmallBalanceTableDto {
    @Id
    private Integer id;
    private String tableDate;
    private String reportType;
    private String tableStander;
    private String regCreditNo;
    private String regNo;
    private String createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTableDate() {
        return tableDate;
    }

    public void setTableDate(String tableDate) {
        this.tableDate = tableDate;
    }

    public String getReportType() {
        return reportType;
    }

    public void setReportType(String reportType) {
        this.reportType = reportType;
    }

    public String getTableStander() {
        return tableStander;
    }

    public void setTableStander(String tableStander) {
        this.tableStander = tableStander;
    }

    public String getRegCreditNo() {
        return regCreditNo;
    }

    public void setRegCreditNo(String regCreditNo) {
        this.regCreditNo = regCreditNo;
    }

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
