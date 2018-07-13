package com.xlh.crm.dto.mysql;

public class BranchPersonReach {
    private String company;
    private String favUserList;
    private Integer favUserId;
    private String custManager;
    private Integer weekDist;
    private Integer weekReac;

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getFavUserList() {
        return favUserList;
    }

    public void setFavUserList(String favUserList) {
        this.favUserList = favUserList;
    }

    public Integer getFavUserId() {
        return favUserId;
    }

    public void setFavUserId(Integer favUserId) {
        this.favUserId = favUserId;
    }

    public String getCustManager() {
        return custManager;
    }

    public void setCustManager(String custManager) {
        this.custManager = custManager;
    }

    public Integer getWeekDist() {
        return weekDist;
    }

    public void setWeekDist(Integer weekDist) {
        this.weekDist = weekDist;
    }

    public Integer getWeekReac() {
        return weekReac;
    }

    public void setWeekReac(Integer weekReac) {
        this.weekReac = weekReac;
    }
}
