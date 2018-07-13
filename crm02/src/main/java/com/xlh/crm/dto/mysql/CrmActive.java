package com.xlh.crm.dto.mysql;

import javax.persistence.Id;

public class CrmActive {
    //活动信息
    @Id
    private int recId;  //记录ID

    private String bizLv1Id="";  //一级业务ID

    private String bizLv1Name="";  //一级业务名称

    private String actNo="";  //活动编号

    private String company="";  //活动发起分公司

    private String actName="";  //活动名

    private String beginTime="";  //开始时间

    private String endTime="";  //结束时间

    private String usRole="";  //我司角色


    private String actType="";  //活动类型


    private String coPartner="";  //合作方

    private Double actFee=new Double(0);  //活动费用

    private Integer joinPersons=0;  //参与人数

    private String operator="";  //操作人

    private String actLocation="";  //活动举办地点

    private String remark="";  //备注

    private String linkAddress="";  //活动资料链接地址

    private String excelJson="[]";  //参会人员信息

    private String imageJson="[]";   //图片信息

    private String updateTime="";  //更新时间


    public int getRecId() {
        return recId;
    }

    public void setRecId(int recId) {
        this.recId = recId;
    }

    public String getBizLv1Id() {
        return bizLv1Id;
    }

    public void setBizLv1Id(String bizLv1Id) {
        this.bizLv1Id = bizLv1Id;
    }

    public String getBizLv1Name() {
        return bizLv1Name;
    }

    public void setBizLv1Name(String bizLv1Name) {
        this.bizLv1Name = bizLv1Name;
    }

    public String getActNo() {
        return actNo;
    }

    public void setActNo(String actNo) {
        this.actNo = actNo;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getActName() {
        return actName;
    }

    public void setActName(String actName) {
        this.actName = actName;
    }

    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getUsRole() {
        return usRole;
    }

    public void setUsRole(String usRole) {
        this.usRole = usRole;
    }


    public String getActType() {
        return actType;
    }

    public void setActType(String actType) {
        this.actType = actType;
    }



    public String getCoPartner() {
        return coPartner;
    }

    public void setCoPartner(String coPartner) {
        this.coPartner = coPartner;
    }

    public Double getActFee() {
        return actFee;
    }

    public void setActFee(Double actFee) {
        this.actFee = actFee;
    }

    public Integer getJoinPersons() {
        return joinPersons;
    }

    public void setJoinPersons(Integer joinPersons) {
        this.joinPersons = joinPersons;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getActLocation() {
        return actLocation;
    }

    public void setActLocation(String actLocation) {
        this.actLocation = actLocation;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getLinkAddress() {
        return linkAddress;
    }

    public void setLinkAddress(String linkAddress) {
        this.linkAddress = linkAddress;
    }

    public String getExcelJson() {
        return excelJson;
    }

    public void setExcelJson(String excelJson) {
        this.excelJson = excelJson;
    }

    public String getImageJson() {
        return imageJson;
    }

    public void setImageJson(String imageJson) {
        this.imageJson = imageJson;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }
}
