package com.xlh.crm.dto;

import java.util.List;

/**
 * Created by ysl on 2017/5/26.
 */
public class OrderManageListRespDTO {

    /*查询总记录数*/
    private int totalRecCount = 0;

    /*总页数,由计算得出*/
    private int totalPageCount = 0;

    /*请求参数返回前端*/
    private PageReqDTO reqParams;

    /*订单列表*/
    private List<OrderShowDTO> ordListContents;

    /*单个订单信息*/
    private OrderShowDTO ordSglContents;

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

    public List<OrderShowDTO> getOrdListContents() {
        return ordListContents;
    }

    public void setOrdListContents(List<OrderShowDTO> ordListContents) {
        this.ordListContents = ordListContents;
    }

    public OrderShowDTO getOrdSglContents() {
        return ordSglContents;
    }

    public void setOrdSglContents(OrderShowDTO ordSglContents) {
        this.ordSglContents = ordSglContents;
    }

}
