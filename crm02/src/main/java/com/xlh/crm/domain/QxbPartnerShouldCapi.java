package com.xlh.crm.domain;

public class QxbPartnerShouldCapi {
    private Integer id;

    private Integer partnerId;

    private String shoudCapi;

    private String shouldCapiDate;

    private String investType;

    private Integer enttime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(Integer partnerId) {
        this.partnerId = partnerId;
    }

    public String getShoudCapi() {
        return shoudCapi;
    }

    public void setShoudCapi(String shoudCapi) {
        this.shoudCapi = shoudCapi == null ? null : shoudCapi.trim();
    }

    public String getShouldCapiDate() {
        return shouldCapiDate;
    }

    public void setShouldCapiDate(String shouldCapiDate) {
        this.shouldCapiDate = shouldCapiDate == null ? null : shouldCapiDate.trim();
    }

    public String getInvestType() {
        return investType;
    }

    public void setInvestType(String investType) {
        this.investType = investType == null ? null : investType.trim();
    }

    public Integer getEnttime() {
        return enttime;
    }

    public void setEnttime(Integer enttime) {
        this.enttime = enttime;
    }
}