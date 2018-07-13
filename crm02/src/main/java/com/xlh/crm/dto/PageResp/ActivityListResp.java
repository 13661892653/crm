package com.xlh.crm.dto.PageResp;

import com.xlh.crm.dto.ActShowDTO;
import com.xlh.crm.dto.PageReqDTO;
import com.xlh.crm.dto.mysql.CrmActive;

import java.util.List;

public class ActivityListResp {
    /*查询总记录数*/
    private int totalRecCount = 0;

    /*总页数,由计算得出*/
    private int totalPageCount = 0;

    /*活动列表*/
    private List<CrmActive> crmActives;

    public int getTotalRecCount() {
        return totalRecCount;
    }

    public void setTotalRecCount(int totalRecCount) {
        this.totalRecCount = totalRecCount;
    }

    public int getTotalPageCount() {
        return totalPageCount;
    }

    public void setTotalPageCount(int totalPageCount) {
        this.totalPageCount = totalPageCount;
    }


    public List<CrmActive> getCrmActives() {
        return crmActives;
    }

    public void setCrmActives(List<CrmActive> crmActives) {
        this.crmActives = crmActives;
    }
}
