package com.xlh.crm.dto.score;

import java.math.BigDecimal;

public class TopicScore {
    private String enterpriseName="";  //企业名称
    private BigDecimal registerMoney=new BigDecimal(0);       //注册资本
    private BigDecimal createYears=new BigDecimal(0);      //注册成立年份
    private String mainIndustry="";        //企业所属行业领域
    private int intellectual_property_num=0;      //知识产权数量
    private BigDecimal income2017=new BigDecimal(0);      //销售收入2017
    private BigDecimal income2016=new BigDecimal(0);      //销售收入2016
    private BigDecimal income2015=new BigDecimal(0);      //销售收入2015
    private BigDecimal netAssets2017=new BigDecimal(0);      //净资产收入2017
    private BigDecimal netAssets2016=new BigDecimal(0);      //净资产收入2016
    private BigDecimal netAssets2015=new BigDecimal(0);      //净资产收入2015
    private BigDecimal researchFee2017=new BigDecimal(0);     //研发费用
    private BigDecimal researchFee2016=new BigDecimal(0);
    private BigDecimal researchFee2015=new BigDecimal(0);
    private int totalEmployeeNum=0;       //总人数
    private int researchEmployeeNum=0;    //研发人员数

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }


    public BigDecimal getRegisterMoney() {
        return registerMoney;
    }

    public void setRegisterMoney(BigDecimal registerMoney) {
        this.registerMoney = registerMoney;
    }

    public BigDecimal getCreateYears() {
        return createYears;
    }

    public void setCreateYears(BigDecimal createYears) {
        this.createYears = createYears;
    }

    public String getMainIndustry() {
        return mainIndustry;
    }

    public void setMainIndustry(String mainIndustry) {
        this.mainIndustry = mainIndustry;
    }

    public int getIntellectual_property_num() {
        return intellectual_property_num;
    }

    public void setIntellectual_property_num(int intellectual_property_num) {
        this.intellectual_property_num = intellectual_property_num;
    }

    public BigDecimal getIncome2017() {
        return income2017;
    }

    public void setIncome2017(BigDecimal income2017) {
        this.income2017 = income2017;
    }

    public BigDecimal getIncome2016() {
        return income2016;
    }

    public void setIncome2016(BigDecimal income2016) {
        this.income2016 = income2016;
    }

    public BigDecimal getIncome2015() {
        return income2015;
    }

    public void setIncome2015(BigDecimal income2015) {
        this.income2015 = income2015;
    }

    public BigDecimal getNetAssets2017() {
        return netAssets2017;
    }

    public void setNetAssets2017(BigDecimal netAssets2017) {
        this.netAssets2017 = netAssets2017;
    }

    public BigDecimal getNetAssets2016() {
        return netAssets2016;
    }

    public void setNetAssets2016(BigDecimal netAssets2016) {
        this.netAssets2016 = netAssets2016;
    }

    public BigDecimal getNetAssets2015() {
        return netAssets2015;
    }

    public void setNetAssets2015(BigDecimal netAssets2015) {
        this.netAssets2015 = netAssets2015;
    }

    public BigDecimal getResearchFee2017() {
        return researchFee2017;
    }

    public void setResearchFee2017(BigDecimal researchFee2017) {
        this.researchFee2017 = researchFee2017;
    }

    public BigDecimal getResearchFee2016() {
        return researchFee2016;
    }

    public void setResearchFee2016(BigDecimal researchFee2016) {
        this.researchFee2016 = researchFee2016;
    }

    public BigDecimal getResearchFee2015() {
        return researchFee2015;
    }

    public void setResearchFee2015(BigDecimal researchFee2015) {
        this.researchFee2015 = researchFee2015;
    }

    public int getTotalEmployeeNum() {
        return totalEmployeeNum;
    }

    public void setTotalEmployeeNum(int totalEmployeeNum) {
        this.totalEmployeeNum = totalEmployeeNum;
    }

    public int getResearchEmployeeNum() {
        return researchEmployeeNum;
    }

    public void setResearchEmployeeNum(int researchEmployeeNum) {
        this.researchEmployeeNum = researchEmployeeNum;
    }
}
