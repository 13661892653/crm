package com.xlh.crm.dto.mysql;

import com.xlh.crm.dto.financeinputshow.JXNormalBalanceTableDto;
import com.xlh.crm.dto.financeinputshow.JXNormalProfitTableDto;

public class FiTmpExcelJxNormalProfitTable extends JXNormalProfitTableDto {
    private Integer fileId;
    private Integer sheetId;
    private Integer roleId;
    private String fileName;
    private String create_time;

    public Integer getFileId() {
        return fileId;
    }

    public void setFileId(Integer fileId) {
        this.fileId = fileId;
    }

    public Integer getSheetId() {
        return sheetId;
    }

    public void setSheetId(Integer sheetId) {
        this.sheetId = sheetId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }
}
