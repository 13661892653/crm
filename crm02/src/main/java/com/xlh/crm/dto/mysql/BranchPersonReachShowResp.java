package com.xlh.crm.dto.mysql;

import java.util.ArrayList;
import java.util.List;

public class BranchPersonReachShowResp {
    private String company;
    private String favUserList;
    private Integer distNum;
    private Integer rowSpan;
    private List<BranchPersonReach> branchPersonReachList;

    public Integer getRowSpan() {
        return rowSpan;
    }

    public void setRowSpan(Integer rowSpan) {
        this.rowSpan = rowSpan;
    }

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

    public Integer getDistNum() {
        return distNum;
    }

    public void setDistNum(Integer distNum) {
        this.distNum = distNum;
    }

    public List<BranchPersonReach> getBranchPersonReachList() {
        return branchPersonReachList;
    }

    public void setBranchPersonReachList(List<BranchPersonReach> branchPersonReachList) {
        this.branchPersonReachList = branchPersonReachList;
    }

    public void addBranchPersonReachList(BranchPersonReach branchPersonReach){
        if(branchPersonReachList==null){
            branchPersonReachList=new ArrayList<>();
        }
        branchPersonReachList.add(branchPersonReach);
    }
}
