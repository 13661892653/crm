package com.xlh.crm.dto;


import java.util.List;

/**
 * Created by ysl on 2017/05/11.
 */
public class TableColumnShowDTO {

    //表名
    private String tableName;

    //字段名
    private String columnName;

    //字段类型
    private String columnType;

    //字段注释
    private String columnComment;

    //选择的维度字段List
    private List<String> seDimColumnList;

    //选择的指标字段List
    private List<String> seIdxColumnList;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getColumnType() {
        return columnType;
    }

    public void setColumnType(String columnType) {
        this.columnType = columnType;
    }

    public String getColumnComment() {
        return columnComment;
    }

    public void setColumnComment(String columnComment) {
        this.columnComment = columnComment;
    }

    public List<String> getSeDimColumnList() {
        return seDimColumnList;
    }

    public void setSeDimColumnList(List<String> seDimColumnList) {
        this.seDimColumnList = seDimColumnList;
    }

    public List<String> getSeIdxColumnList() {
        return seIdxColumnList;
    }

    public void setSeIdxColumnList(List<String> seIdxColumnList) {
        this.seIdxColumnList = seIdxColumnList;
    }
}
