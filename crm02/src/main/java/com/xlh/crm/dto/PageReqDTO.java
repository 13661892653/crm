package com.xlh.crm.dto;

import java.util.Date;

/**
 * Created by ysl on 2017/5/26.
 */
public class PageReqDTO {

    private Integer memberId;

    private String memberPhone;

    private String userName;   //用户名

    private String memberType;  //会员类型

    private String company;  //所在公司

    private String province;  //所在省份

    //请求参数：资产类别
    private String assetsFlag = "all";  //默认是全部

    //请求参数：地区
    private String regionCode = "all";  //默认是全部

    //请求参数：是否有财税数据
    private String isHaveFinance = "all";  //默认是全部

    //请求参数：资产等级
    private String assetsLevel = "all";  //默认是全部

    //请求参数：企业标签
    private String assetsTagCode = "all";  //默认是全部

    //请求参数：行业
    private String industryName = "all";  //默认是全部

    //请求参数：业务分类
    private String bizLv1Id = "all";  //默认是全部

    private String bizLv2Id = "all";  //默认是全部

    private String hasDemand ="all";

    //请求参数：获客渠道
    private String winCustChnl = "all";  //默认是全部

    //请求参数：开始时间
    private String timeBegin = "all";  //默认是全部

    //请求参数：结束时间
    private String timeEnd = "all";  //默认是全部

    //高企评分
    private String beginScore="all";
    private String endScore="all";
    //请求参数：员工姓名
    private String empName = "all";  //默认是全部

    //请求参数：是否分配企服人员
    private String isSetEntSrv = "all";  //默认是全部

    //请求参数：客户类型
    private String custType = "corpCust";  //默认是企业

    //请求参数：企业名
    private String corpName;

    //请求参数：融资开始时间
    private String invTimeBegin = "all";  //默认是全部

    //请求参数：融资开始时间
    private String invTimeEnd = "all";  //默认是全部

    //请求参数：企业分层标识，一星、二星、三星
    private String entType = "all";  //默认是全部

    //请求参数：企业工商注册号、社会统一信用代码
    private String regCreditNo;

    //请求参数：企业工商注册号
    private String regNo;

    //请求参数：企业社会统一信用代码
    private String creditNo;

    private Integer currentPage = 0;

    //page setting
    private Integer pageIndex = 1;

    private Integer pageSize = 20;

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public String getMemberPhone() {
        return memberPhone;
    }

    public void setMemberPhone(String memberPhone) {
        this.memberPhone = memberPhone;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMemberType() {
        return memberType;
    }

    public void setMemberType(String memberType) {
        this.memberType = memberType;
    }

    public String getCompany() { return company; }

    public String getHasDemand() {
        return hasDemand;
    }

    public void setHasDemand(String hasDemand) {
        this.hasDemand = hasDemand;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getProvince() { return province; }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getBeginScore() {
        return beginScore;
    }

    public void setBeginScore(String beginScore) {
        this.beginScore = beginScore;
    }

    public String getEndScore() {
        return endScore;
    }

    public void setEndScore(String endScore) {
        this.endScore = endScore;
    }

    public String getAssetsFlag() {
        return assetsFlag;
    }

    public void setAssetsFlag(String assetsFlag) {
        this.assetsFlag = assetsFlag;
    }

    public String getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

    public String getIsHaveFinance() {
        return isHaveFinance;
    }

    public void setIsHaveFinance(String isHaveFinance) {
        this.isHaveFinance = isHaveFinance;
    }

    public String getAssetsLevel() {
        return assetsLevel;
    }

    public void setAssetsLevel(String assetsLevel) {
        this.assetsLevel = assetsLevel;
    }

    public String getAssetsTagCode() {
        return assetsTagCode;
    }

    public void setAssetsTagCode(String assetsTagCode) {
        this.assetsTagCode = assetsTagCode;
    }

    public String getWinCustChnl() {
        return winCustChnl;
    }

    public void setWinCustChnl(String winCustChnl) {
        this.winCustChnl = winCustChnl;
    }

    public String getTimeBegin() {
        return timeBegin;
    }

    public void setTimeBegin(String timeBegin) {
        this.timeBegin = timeBegin;
    }

    public String getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(String timeEnd) {
        this.timeEnd = timeEnd;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getIsSetEntSrv() {
        return isSetEntSrv;
    }

    public void setIsSetEntSrv(String isSetEntSrv) {
        this.isSetEntSrv = isSetEntSrv;
    }

    public String getCustType() {
        return custType;
    }

    public void setCustType(String custType) {
        this.custType = custType;
    }

    public String getBizLv1Id() {
        return bizLv1Id;
    }

    public void setBizLv1Id(String bizLv1Id) {
        this.bizLv1Id = bizLv1Id;
    }

    public String getBizLv2Id() {
        return bizLv2Id;
    }

    public void setBizLv2Id(String bizLv2Id) {
        this.bizLv2Id = bizLv2Id;
    }

    public String getIndustryName() {
        return industryName;
    }

    public void setIndustryName(String industryName) {
        this.industryName = industryName;
    }

    public String getCorpName() {
        return corpName;
    }

    public void setCorpName(String corpName) {
        this.corpName = corpName;
    }

    public String getInvTimeBegin() {
        return invTimeBegin;
    }

    public void setInvTimeBegin(String invTimeBegin) {
        this.invTimeBegin = invTimeBegin;
    }

    public String getInvTimeEnd() {
        return invTimeEnd;
    }

    public void setInvTimeEnd(String invTimeEnd) {
        this.invTimeEnd = invTimeEnd;
    }

    public String getEntType() {
        return entType;
    }

    public void setEntType(String entType) {
        this.entType = entType;
    }

    public String getRegCreditNo() {
        return regCreditNo;
    }

    public void setRegCreditNo(String regCreditNo) {
        this.regCreditNo = regCreditNo;
    }

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    public String getCreditNo() {
        return creditNo;
    }

    public void setCreditNo(String creditNo) {
        this.creditNo = creditNo;
    }

    public Integer getPageIndex() {
        return pageIndex == null ? 1 : pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }
}
