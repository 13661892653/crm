package com.xlh.crm.dto;

/**
 * Created by ysl on 2017/6/2.
 */
public class ChartShowDTO {

    private Integer createMemberId;

    private String chartId;

    private String chartData;

    private String settingConditions;

    private int recCnt = 0;  //返回记录数

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

    public String getChartData() {
        return chartData;
    }

    public void setChartData(String chartData) {
        this.chartData = chartData;
    }

    public String getSettingConditions() {
        return settingConditions;
    }

    public void setSettingConditions(String settingConditions) {
        this.settingConditions = settingConditions;
    }

    public Integer getRecCnt() {
        return recCnt;
    }

    public void setRecCnt(Integer recCnt) {
        this.recCnt = recCnt;
    }

}
