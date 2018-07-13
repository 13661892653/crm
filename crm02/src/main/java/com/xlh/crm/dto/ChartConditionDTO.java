package com.xlh.crm.dto;

import java.util.List;

/**
 * Created by ysl on 2017/6/2.
 */
public class ChartConditionDTO {
    private Integer createrMemberId;

    private String chartId;

    private String settingConditions;

    public Integer getCreaterMemberId() {
        return createrMemberId;
    }

    public void setCreaterMemberId(Integer createrMemberId) {
        this.createrMemberId = createrMemberId;
    }

    public String getChartId() {
        return chartId;
    }

    public void setChartId(String chartId) {
        this.chartId = chartId;
    }

    public String getSettingConditions() {
        return settingConditions;
    }

    public void setSettingConditions(String settingConditions) {
        this.settingConditions = settingConditions;
    }
}
