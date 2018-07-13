package com.xlh.crm.dto;

import java.util.Date;

/**
 * Created by ysl on 2017/5/26.
 */
public class EnterpriseFinancingRespDTO {

    //企业档案-历史融资
    private Date financingDate;

    private String financingAmount;

    private String financingCurrency;

    private String financingStage;

    private String investors;

    public Date getFinancingDate() {
        return financingDate;
    }

    public void setFinancingDate(Date financingDate) {
        this.financingDate = financingDate;
    }

    public String getFinancingAmount() {
        return financingAmount;
    }

    public void setFinancingAmount(String financingAmount) {
        this.financingAmount = financingAmount == null ? null : financingAmount.trim();
    }

    public String getFinancingCurrency() {
        return financingCurrency;
    }

    public void setFinancingCurrency(String financingCurrency) {
        this.financingCurrency = financingCurrency == null ? null : financingCurrency.trim();
    }

    public String getFinancingStage() {
        return financingStage;
    }

    public void setFinancingStage(String financingStage) {
        this.financingStage = financingStage == null ? null : financingStage.trim();
    }

    public String getInvestors() {
        return investors;
    }

    public void setInvestors(String investors) {
        this.investors = investors == null ? null : investors.trim();
    }

}
