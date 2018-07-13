package com.xlh.crm.dto;

import javax.persistence.Id;

/**
 * Created by ysl on 2017/5/26.
 */
public class ActShowDTO {

    //活动信息
    private String recId;  //记录ID

    private String bizLv1Id;  //一级业务ID

    private String bizLv1Name;  //一级业务名称

    private String actNo;  //活动编号

    private String company;  //活动发起分公司

    private String actName;  //活动名

    private String beginTime;  //开始时间

    private String endTime;  //结束时间

    private String usRole;  //我司角色

    private String usRoleDesc;  //我司角色描述

    private String actType;  //活动类型

    private String actTypeDesc;  //活动类型描述

    private String coPartner;  //合作方

    private Double actFee;  //活动费用

    private Integer joinPersons;  //参与人数

    private String operator;  //操作人

    private String actLocation;  //活动举办地点

    private String remark;  //备注

    private String linkAddress;  //活动资料链接地址

    private String excelJson;  //参会人员信息

    private String imageJson;   //图片信息

    private String updateTime;  //更新时间

    public String getRecId() {
        return recId;
    }

    public void setRecId(String recId) {
        this.recId = recId;
    }

    public String getBizLv1Id() {
        return bizLv1Id;
    }

    public void setBizLv1Id(String bizLv1Id) {
        this.bizLv1Id = bizLv1Id == null ? null : bizLv1Id.trim();
    }

    public String getBizLv1Name() {
        return bizLv1Name;
    }

    public void setBizLv1Name(String bizLv1Name) {
        this.bizLv1Name = bizLv1Name == null ? null : bizLv1Name.trim();
    }

    public String getActNo() {
        return actNo;
    }

    public void setActNo(String actNo) {
        this.actNo = actNo == null ? null : actNo.trim();
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company == null ? null : company.trim();
    }

    public String getActName() {
        return actName;
    }

    public void setActName(String actName) {
        this.actName = actName == null ? null : actName.trim();
    }

    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime == null ? null : beginTime.trim();
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime == null ? null : endTime.trim();
    }

    public String getUsRole() {
        return usRole;
    }

    public void setUsRole(String usRole) {
        this.usRole = usRole == null ? null : usRole.trim();
    }

    public String getUsRoleDesc() {
        return usRoleDesc;
    }

    public void setUsRoleDesc(String usRoleDesc) {
        this.usRoleDesc = usRoleDesc == null ? null : usRoleDesc.trim();
    }

    public String getActType() {
        return actType;
    }

    public void setActType(String actType) {
        this.actType = actType == null ? null : actType.trim();
    }

    public String getActTypeDesc() {
        return actTypeDesc;
    }

    public void setActTypeDesc(String actTypeDesc) {
        this.actTypeDesc = actTypeDesc == null ? null : actTypeDesc.trim();
    }

    public String getCoPartner() {
        return coPartner;
    }

    public void setCoPartner(String coPartner) {
        this.coPartner = coPartner == null ? null : coPartner.trim();
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }

    public String getActLocation() {
        return actLocation;
    }

    public void setActLocation(String actLocation) {
        this.actLocation = actLocation == null ? null : actLocation.trim();
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

    public String getLinkAddress() {
        return linkAddress;
    }

    public void setLinkAddress(String linkAddress) {
        this.linkAddress = linkAddress == null ? null : linkAddress.trim();
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime == null ? null : updateTime.trim();
    }

}
