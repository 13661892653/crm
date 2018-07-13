package com.xlh.crm.dto;


import java.util.List;

/**
 * Created by ysl on 2017/05/11.
 */
public class CreateChartCondDTO {

    //选择的维度字段List
    private List<String> seDimColumnList;

    //选择的指标字段List
    private List<String> seIdxColumnList;

    //创建图形页面设置的条件集合
    private String createChartSetCond;

    public List<String> getSeDimColumnList() {
        return seDimColumnList;
    }

    public void setSeDimColumnList(List<String> seDimColumnList) {
        this.seDimColumnList = seDimColumnList;
    }

    public List<String> getSeIdxColumnList() {
        return seIdxColumnList;
    }

    public void setSeIdxColumnList(List<String> seIdxColumnList) {
        this.seIdxColumnList = seIdxColumnList;
    }

    public String getCreateChartSetCond() {
        return createChartSetCond;
    }

    public void setCreateChartSetCond(String createChartSetCond) {
        this.createChartSetCond = createChartSetCond;
    }
}
