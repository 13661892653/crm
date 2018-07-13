package com.xlh.crm.dto;

/**
 * Created by ysl on 2017/5/26.
 */
public class EnterpriseProjRespDTO {

    //企业档案-企业项目数据

    private String recId;

    private String enterpriseName;

    private String regCreditNo;

    private String creditNo;

    private String regNo;

    private String projectName;

    private String projectDesc;

    private String isCompProject;

    private String compName;

    private String industry;

    private String commentPerson;

    private String commentRemark;

    private String bpYear;

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

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName == null ? null : projectName.trim();
    }

    public String getProjectDesc() {
        return projectDesc;
    }

    public void setProjectDesc(String projectDesc) {
        this.projectDesc = projectDesc == null ? null : projectDesc.trim();
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry == null ? null : industry.trim();
    }

    public String getIsCompProject() {
        return isCompProject;
    }

    public void setIsCompProject(String isCompProject) {
        this.isCompProject = isCompProject == null ? null : isCompProject.trim();
    }

    public String getCompName() {
        return compName;
    }

    public void setCompName(String compName) {
        this.compName = compName == null ? null : compName.trim();
    }

    public String getCommentPerson() {
        return commentPerson;
    }

    public void setCommentPerson(String commentPerson) {
        this.commentPerson = commentPerson == null ? null : commentPerson.trim();
    }

    public String getCommentRemark() {
        return commentRemark;
    }

    public void setCommentRemark(String commentRemark) {
        this.commentRemark = commentRemark == null ? null : commentRemark.trim();
    }

    public String getBpYear() {
        return bpYear;
    }

    public void setBpYear(String bpYear) {
        this.bpYear = bpYear == null ? null : bpYear.trim();
    }

}
