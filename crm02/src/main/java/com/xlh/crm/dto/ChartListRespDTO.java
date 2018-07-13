package com.xlh.crm.dto;

import java.util.List;

/**
 * Created by ysl on 2017/5/26.
 */
public class ChartListRespDTO {

    /*查询总记录数*/
    private int totalRecCount = 0;

    /*总页数,由计算得出*/
    private int totalPageCount = 0;

    /*请求参数返回前端*/
    private ChartReqDTO reqParams;

    /*信息列表*/
    private List<ChartShowDTO> chartListContents;

    /*单条信息*/
    private ChartShowDTO chartSglContents;

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

    public ChartReqDTO getReqParams() {
        return reqParams;
    }

    public void setReqParams(ChartReqDTO reqParams) {
        this.reqParams = reqParams;
    }

    public List<ChartShowDTO> getChartListContents() {
        return chartListContents;
    }

    public void setChartListContents(List<ChartShowDTO> chartListContents) {
        this.chartListContents = chartListContents;
    }

    public ChartShowDTO getChartSglContents() {
        return chartSglContents;
    }

    public void setChartSglContents(ChartShowDTO chartSglContents) {
        this.chartSglContents = chartSglContents;
    }

}
