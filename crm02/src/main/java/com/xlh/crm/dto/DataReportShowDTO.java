package com.xlh.crm.dto;

/**
 * Created by ysl on 2017/6/2.
 */
public class DataReportShowDTO {

    private String dt;            //数据日期

    private String company;       //分公司

    private String employee;      //员工姓名

    private Integer empCnt;       //人数

    private Double empAvg;        //人均客户数

    private Integer custCnt;      //总客户数

    private Integer vstCustCnt;   //上门拜访客户数

    private Double vstCustRate;   //上门拜访客户数占比

    private Integer gCustCnt;      //G客户数

    private Integer gVstCustCnt;   //上门拜访G客户数

    private Double gVstCustRate;   //上门拜访G客户数占比

    private Integer tCustCnt;      //T客户数

    private Integer tVstCustCnt;   //上门拜访T客户数

    private Double tVstCustRate;   //上门拜访T客户数占比

    private Integer fCustCnt;      //F客户数

    private Integer fVstCustCnt;   //上门拜访F客户数

    private Double fVstCustRate;   //上门拜访F客户数占比

    private Integer loginDayCnt;    //CRM系统登录天数

    public String getDt() {
        return dt;
    }

    public void setDt(String dt) {
        this.dt = dt;
    }

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Integer getEmpCnt() {
        return empCnt;
    }

    public void setEmpCnt(Integer empCnt) {
        this.empCnt = empCnt;
    }

    public Double getEmpAvg() {
        return empAvg;
    }

    public void setEmpAvg(Double empAvg) {
        this.empAvg = empAvg;
    }

    public Integer getCustCnt() {return custCnt;}

    public void setCustCnt(Integer custCnt) {
        this.custCnt = custCnt;
    }

    public Integer getVstCustCnt() {return vstCustCnt;}

    public void setVstCustCnt(Integer vstCustCnt) {
        this.vstCustCnt = vstCustCnt;
    }

    public Double getVstCustRate() {return vstCustRate;}

    public void setVstCustRate(Double vstCustRate) {
        this.vstCustRate = vstCustRate;
    }

    public Integer getgCustCnt() {return gCustCnt;}

    public void setgCustCnt(Integer gCustCnt) {
        this.gCustCnt = gCustCnt;
    }

    public Integer getgVstCustCnt() {return gVstCustCnt;}

    public void setgVstCustCnt(Integer gVstCustCnt) {
        this.gVstCustCnt = gVstCustCnt;
    }

    public Double getgVstCustRate() {return gVstCustRate;}

    public void setgVstCustRate(Double gVstCustRate) {
        this.gVstCustRate = gVstCustRate;
    }

    public Integer gettCustCnt() {return tCustCnt;}

    public void settCustCnt(Integer tCustCnt) {
        this.tCustCnt = tCustCnt;
    }

    public Integer gettVstCustCnt() {return tVstCustCnt;}

    public void settVstCustCnt(Integer tVstCustCnt) {
        this.tVstCustCnt = tVstCustCnt;
    }

    public Double gettVstCustRate() {return tVstCustRate;}

    public void settVstCustRate(Double tVstCustRate) {
        this.tVstCustRate = tVstCustRate;
    }

    public Integer getfCustCnt() {return fCustCnt;}

    public void setfCustCnt(Integer fCustCnt) {
        this.fCustCnt = fCustCnt;
    }

    public Integer getfVstCustCnt() {return fVstCustCnt;}

    public void setfVstCustCnt(Integer fVstCustCnt) {
        this.fVstCustCnt = fVstCustCnt;
    }

    public Double getfVstCustRate() {return fVstCustRate;}

    public void setfVstCustRate(Double fVstCustRate) {
        this.fVstCustRate = fVstCustRate;
    }

    public Integer getLoginDayCnt() {return loginDayCnt;}

    public void setLoginDayCnt(Integer loginDayCnt) {
        this.loginDayCnt = loginDayCnt;
    }
}
