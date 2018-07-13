package com.xlh.crm.domain;

import java.math.BigDecimal;
import java.util.Date;

public class DatabaseTable {

    //private String dbname;
    private String tableName;

    //public String getDbName() {
    //    return dbname;
    //}

    //public void setDbName(String dbname) {
    //    this.dbname = dbname == null ? null : dbname.trim();
    //}

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName == null ? null : tableName.trim();
    }
}