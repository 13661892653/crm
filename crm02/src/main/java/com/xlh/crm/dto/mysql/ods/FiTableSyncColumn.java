package com.xlh.crm.dto.mysql.ods;

import javax.persistence.Id;

public class FiTableSyncColumn {
    @Id
    private int id;
    private String className;
    private String fieldName;
    private String reportColumnName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getReportColumnName() {
        return reportColumnName;
    }

    public void setReportColumnName(String reportColumnName) {
        this.reportColumnName = reportColumnName;
    }
}
