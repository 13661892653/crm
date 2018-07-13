package com.xlh.crm.domain.api;

import java.util.Date;

public class MonFlag {
    private Date dt;

    private String flag;

    public Date getDt() {
        return dt;
    }

    public void setDt(Date dt) {
        this.dt = dt;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag == null ? null : flag.trim();
    }
}