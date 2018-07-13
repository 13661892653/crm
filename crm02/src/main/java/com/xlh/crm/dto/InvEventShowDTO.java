package com.xlh.crm.dto;

import java.util.Date;

/**
 * Created by ysl on 2017/5/26.
 */
public class InvEventShowDTO {

    //投融资事件数据库展示字段定义
    private String trDate;

    private String productName;

    private String enterpriseName;

    private String rounds;

    private String trAmt;

    private String industry;

    private String investment;

    private String area;

    private String mark;

    public String getTrDate() {
        return trDate;
    }

    public void setTrDate(String trDate) {
        this.trDate = trDate;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }

    public String getRounds() {
        return rounds;
    }

    public void setRounds(String rounds) {
        this.rounds = rounds;
    }

    public String getTrAmt() {
        return trAmt;
    }

    public void setTrAmt(String trAmt) {
        this.trAmt = trAmt;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getInvestment() {
        return investment;
    }

    public void setInvestment(String investment) {
        this.investment = investment;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }
}
