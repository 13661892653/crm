package com.xlh.crm.dto;

/**
 * Created by ysl on 2017/5/26.
 */
public class EnterprisePartnerRespDTO {

    //企业档案-股东信息
    private String partnerName;

    private String partnerType;

    private String shouldCapi;

    private String shouldCapiDate;

    private double shouldCapiRate;  //认缴出资比例

    public String getPartnerName() {
        return partnerName;
    }

    public void setPartnerName(String partnerName) {
        this.partnerName = partnerName == null ? null : partnerName.trim();
    }

    public String getPartnerType() {
        return partnerType;
    }

    public void setPartnerType(String partnerType) {
        this.partnerType = partnerType == null ? null : partnerType.trim();
    }

    public String getShouldCapi() {
        return shouldCapi;
    }

    public void setShouldCapi(String shouldCapi) {
        this.shouldCapi = shouldCapi == null ? null : shouldCapi.trim();
    }

    public String getShouldCapiDate() {
        return shouldCapiDate;
    }

    public void setShouldCapiDate(String shouldCapiDate) {
        this.shouldCapiDate = shouldCapiDate == null ? null : shouldCapiDate.trim();
    }

    public Double getShouldCapiRate() {
        return shouldCapiRate;
    }

    public void setShouldCapiRate(Double shouldCapiRate) {
        this.shouldCapiRate = shouldCapiRate;
    }

}
