package com.xlh.crm.dto.mysql;

import javax.persistence.Id;

public class FiExcelSheet {
    @Id
    private Integer id;
    private Integer fileId;
    private Integer sheetNum;
    private String sheetName;
    private String sheetStander;
    private String reportType;
    private String tableName;
    private String sheetDate;
    private Integer status;
    private String createTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFileId() {
        return fileId;
    }

    public void setFileId(Integer fileId) {
        this.fileId = fileId;
    }

    public Integer getSheetNum() {
        return sheetNum;
    }

    public void setSheetNum(Integer sheetNum) {
        this.sheetNum = sheetNum;
    }

    public String getSheetName() {
        return sheetName;
    }

    public void setSheetName(String sheetName) {
        this.sheetName = sheetName;
    }

    public String getSheetStander() {
        return sheetStander;
    }

    public void setSheetStander(String sheetStander) {
        this.sheetStander = sheetStander;
    }

    public String getReportType() {
        return reportType;
    }

    public void setReportType(String reportType) {
        this.reportType = reportType;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getSheetDate() {
        return sheetDate;
    }

    public void setSheetDate(String sheetDate) {
        this.sheetDate = sheetDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getSheetType(){
        if("wuxiao".equals(sheetStander)){
            return "wuxiao";
        }
        return "Jx"+sheetStander+tableName;
    }
}
