package com.xlh.crm.dto;

import java.util.List;

/**
 * Created by ysl on 2017/5/26.
 */
public class ReachManageListRespDTO {

    /*查询总记录数*/
    private int totalRecCount = 0;

    /*总页数,由计算得出*/
    private int totalPageCount = 0;

    /*请求参数返回前端*/
    private PageReqDTO reqParams;

    /*触达信息列表*/
    private List<ReachShowDTO> rchListContents;

    /*单条触达信息*/
    private ReachShowDTO rchSglContents;

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

    public List<ReachShowDTO> getRchListContents() {
        return rchListContents;
    }

    public void setRchListContents(List<ReachShowDTO> rchListContents) {
        this.rchListContents = rchListContents;
    }

    public ReachShowDTO getRchSglContents() {
        return rchSglContents;
    }

    public void setRchSglContents(ReachShowDTO rchSglContents) {
        this.rchSglContents = rchSglContents;
    }

}
