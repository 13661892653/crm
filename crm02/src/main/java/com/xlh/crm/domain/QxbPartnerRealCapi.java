package com.xlh.crm.domain;

public class QxbPartnerRealCapi {
    private Integer id;

    private Integer partnerId;

    private String realCapi;

    private String realCapiDate;

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

    public String getRealCapi() {
        return realCapi;
    }

    public void setRealCapi(String realCapi) {
        this.realCapi = realCapi == null ? null : realCapi.trim();
    }

    public String getRealCapiDate() {
        return realCapiDate;
    }

    public void setRealCapiDate(String realCapiDate) {
        this.realCapiDate = realCapiDate == null ? null : realCapiDate.trim();
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