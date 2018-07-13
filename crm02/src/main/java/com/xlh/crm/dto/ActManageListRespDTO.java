package com.xlh.crm.dto;

import java.util.List;

/**
 * Created by ysl on 2017/5/26.
 */
public class ActManageListRespDTO {

    /*查询总记录数*/
    private int totalRecCount = 0;

    /*总页数,由计算得出*/
    private int totalPageCount = 0;

    /*请求参数返回前端*/
    private PageReqDTO reqParams;

    /*活动列表*/
    private List<ActShowDTO> actListContents;

    /*单个活动信息*/
    private ActShowDTO actSglContents;

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

    public PageReqDTO getReqParams() {
        return reqParams;
    }

    public void setReqParams(PageReqDTO reqParams) {
        this.reqParams = reqParams;
    }

    public List<ActShowDTO> getActListContents() {
        return actListContents;
    }

    public void setActListContents(List<ActShowDTO> actListContents) {
        this.actListContents = actListContents;
    }

    public ActShowDTO getActSglContents() {
        return actSglContents;
    }

    public void setActSglContents(ActShowDTO actSglContents) {
        this.actSglContents = actSglContents;
    }

}
