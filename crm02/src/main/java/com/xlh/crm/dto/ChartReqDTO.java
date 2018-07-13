package com.xlh.crm.dto;

import java.util.Date;
import java.util.List;

/**
 * Created by ysl on 2017/6/2.
 */
public class ChartReqDTO {

    private Integer createMemberId;

    private String chartId;

    private String lastDate;

    private String insertDate;

    public Integer getCreateMemberId() {
        return createMemberId;
    }

    public void setCreateMemberId(Integer createMemberId) {
        this.createMemberId = createMemberId;
    }

    public String getChartId() {
        return chartId;
    }

    public void setChartId(String chartId) {
        this.chartId = chartId;
    }

    public String getLastDate() {
        return lastDate;
    }

    public void setLastDate(String lastDate) {
        this.lastDate = lastDate;
    }

    public String getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(String insertDate) {
        this.insertDate = insertDate;
    }
}
