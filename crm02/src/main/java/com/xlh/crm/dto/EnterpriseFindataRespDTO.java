package com.xlh.crm.dto;

/**
 * Created by ysl on 2017/5/26.
 */
public class EnterpriseFindataRespDTO {

    //企业档案-财务数据

    private String recId;

    private String enterpriseName;

    private String regCreditNo;

    private String creditNo;

    private String regNo;

    private String finYear;  //财年

    private Double operatingIncome;   //R2007营业收入

    private Double netProfit;          //R2009净利润

    private Double totalAssets;        //F1006总资产


    private Double netAssets;        //F2016净资产


    private String amtUnit;            //单位

    private String finSourceType;      //财税数据来源

    private String finSourceDesc;      //财税数据来源描述

    private String updateTime;  //更新时间

    public String getRecId() {
        return recId;
    }

    public void setRecId(String recId) {
        this.recId = recId;
    }

    public String getRegCreditNo() {
        return regCreditNo;
    }

    public void setRegCreditNo(String regCreditNo) {
        this.regCreditNo = regCreditNo == null ? null : regCreditNo.trim();
    }

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo == null ? null : regNo.trim();
    }

    public String getCreditNo() {
        return creditNo;
    }

    public void setCreditNo(String creditNo) {
        this.creditNo = creditNo == null ? null : creditNo.trim();
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName == null ? null : enterpriseName.trim();
    }

    public Double getNetAssets() {
        return netAssets;
    }

    public void setNetAssets(Double netAssets) {
        this.netAssets = netAssets;
    }

    public String getFinYear() {
        return finYear;
    }

    public void setFinYear(String finYear) {
        this.finYear = finYear == null ? null : finYear.trim();
    }

    public Double getOperatingIncome() {
        return operatingIncome;
    }

    public void setOperatingIncome(Double operatingIncome) {
        this.operatingIncome = operatingIncome;
    }

    public Double getNetProfit() {
        return netProfit;
    }

    public void setNetProfit(Double netProfit) {
        this.netProfit = netProfit;
    }

    public Double getTotalAssets() {
        return totalAssets;
    }

    public void setTotalAssets(Double totalAssets) {
        this.totalAssets = totalAssets;
    }

    public String getAmtUnit() {
        return amtUnit;
    }

    public void setAmtUnit(String amtUnit) {
        this.amtUnit = amtUnit == null ? null : amtUnit.trim();
    }

    public String getFinSourceType() {
        return finSourceType;
    }

    public void setFinSourceType(String finSourceType) {
        this.finSourceType = finSourceType == null ? null : finSourceType.trim();
    }

    public String getFinSourceDesc() {
        return finSourceDesc;
    }

    public void setFinSourceDesc(String finSourceDesc) {
        this.finSourceDesc = finSourceDesc == null ? null : finSourceDesc.trim();
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime == null ? null : updateTime.trim();
    }
}
