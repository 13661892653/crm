package com.xlh.crm.dto;

import java.util.Date;

/**
 * Created by ysl on 2017/5/26.
 */
public class ReachShowDTO {

    //触达信息定义
    private String entType;  //企业分层类型

    private String custType;  //触达客户类型

    private String custName;  //客户名称

    private String govName;  //部委名称

    private String bizLv1Id;  //一级业务ID

    private String bizLv1Name;  //一级业务名称

    private String bizLv2Id;  //二级业务ID

    private String rchNo;

    private String regCreditNo;

    private String creditNo;

    private String regNo;

    private String enterpriseName;

    private String rchMode;   //触达方式

    private String winCustChnl;  //获客渠道

    private String beginTime;  //触达开始时间

    private String endTime;  //触达结束时间

    private String contacts;  //接触人

    private String jobTitle;  //接触人职位

    private String contactsPhone;  //接触人联系方式

    private String salesLead;  //潜在销售机会

    private String remark;  //触达结果记录

    private String rchEmp;  //触达人

    private String company;  //所属分公司

    private Integer reachcsrTimes;//总触达次数

    private String govLine;  //政府条线

    private String govLevel;  //政府级别

    private String govQzr;  //部委等级

    private String commTopic;  //沟通主题

    private String getEffect;  //推进情况及取得的效果

    private String resultTime;  //预计形成成果的时间

    private String cdnThings;  //需要总部协调事项

    private String insertTime; //创建时间
    private String updateTime;  //更新时间

    private Integer gqScore; //高企评分
    private String updateId;

    public String getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(String insertTime) {
        this.insertTime = insertTime;
    }

    public String getEntType() {
        return entType;
    }

    public void setEntType(String entType) {
        this.entType = entType == null ? null : entType.trim();
    }

    public String getCustType() {
        return custType;
    }

    public void setCustType(String custType) {
        this.custType = custType == null ? null : custType.trim();
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName == null ? null : custName.trim();
    }

    public String getGovName() {
        return govName;
    }

    public void setGovName(String govName) {
        this.govName = govName == null ? null : govName.trim();
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

    public String getBizLv2Id() {
        return bizLv2Id;
    }

    public void setBizLv2Id(String bizLv2Id) {
        this.bizLv2Id = bizLv2Id;
    }

    public String getRchNo() {
        return rchNo;
    }

    public void setRchNo(String rchNo) {
        this.rchNo = rchNo == null ? null : rchNo.trim();
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

    public Integer getReachcsrTimes() {
        return reachcsrTimes;
    }

    public void setReachcsrTimes(Integer reachcsrTimes) {
        this.reachcsrTimes = reachcsrTimes;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName == null ? null : enterpriseName.trim();
    }

    public String getRchMode() {
        return rchMode;
    }

    public void setRchMode(String rchMode) {
        this.rchMode = rchMode == null ? null : rchMode.trim();
    }

    public String getWinCustChnl() {
        return winCustChnl;
    }

    public void setWinCustChnl(String winCustChnl) {
        this.winCustChnl = winCustChnl == null ? null : winCustChnl.trim();
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

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts == null ? null : contacts.trim();
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle == null ? null : jobTitle.trim();
    }

    public String getContactsPhone() {
        return contactsPhone;
    }

    public void setContactsPhone(String contactsPhone) {
        this.contactsPhone = contactsPhone == null ? null : contactsPhone.trim();
    }

    public String getSalesLead() {
        return salesLead;
    }

    public void setSalesLead(String salesLead) {
        this.salesLead = salesLead == null ? null : salesLead.trim();
    }

    public String getRchEmp() {
        return rchEmp;
    }

    public void setRchEmp(String rchEmp) {
        this.rchEmp = rchEmp == null ? null : rchEmp.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company == null ? null : company.trim();
    }

    public String getGovLine() {
        return govLine;
    }

    public void setGovLine(String govLine) {
        if (govLine.trim().length() == 0) {
            this.govLine = govLine == null ? null : govLine.trim();
        } else {
            if (govLine.trim().substring(0, 2).equals("其他")) {
                //如果政府条线选的“其他”，截取填写的政府条线名称
                this.govLine = govLine.trim().substring(3, govLine.trim().length());
            } else if (!govLine.trim().substring(0, 2).equals("其他")) {
                //去掉多余的分号
                this.govLine = govLine.trim().replace(",", "");
            }
        }
    }

    public String getGovLevel() {
        return govLevel;
    }

    public void setGovLevel(String govLevel) {
        this.govLevel = govLevel == null ? null : govLevel.trim();
    }

    public String getGovQzr() {
        return govQzr;
    }

    public void setGovQzr(String govQzr) {
        this.govQzr = govQzr == null ? null : govQzr.trim();
    }

    public String getCommTopic() {
        return commTopic;
    }

    public void setCommTopic(String commTopic) {
        this.commTopic = commTopic == null ? null : commTopic.trim();
    }

    public String getGetEffect() {
        return getEffect;
    }

    public void setGetEffect(String getEffect) {
        this.getEffect = getEffect == null ? null : getEffect.trim();
    }

    public String getResultTime() {
        return resultTime;
    }

    public void setResultTime(String resultTime) {
        this.resultTime = resultTime == null ? null : resultTime.trim();
    }

    public String getCdnThings() {
        return cdnThings;
    }

    public void setCdnThings(String cdnThings) {
        this.cdnThings = cdnThings == null ? null : cdnThings.trim();
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime == null ? null : updateTime.trim();
    }

    public String getUpdateId() {
        return updateId;
    }

    public Integer getGqScore() {
        return gqScore;
    }

    public void setGqScore(Integer gqScore) {
        this.gqScore = gqScore;
    }

    public void setUpdateId(String updateId) {
        this.updateId = updateId;
    }
}
