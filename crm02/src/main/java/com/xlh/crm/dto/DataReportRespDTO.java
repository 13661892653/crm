package com.xlh.crm.dto;

import java.util.List;

/**
 * Created by ysl on 2017/5/26.
 */
public class DataReportRespDTO {

    /*请求参数返回前端*/
    private PageReqDTO reqParams;

    /*企业数据库列表*/
    private List<DataReportShowDTO> dataReportContents;

    public PageReqDTO getReqParams() {
        return reqParams;
    }

    public void setReqParams(PageReqDTO reqParams) {
        this.reqParams = reqParams;
    }

    public List<DataReportShowDTO> getDataReportContents() {
        return dataReportContents;
    }

    public void setDataReportContents(List<DataReportShowDTO> dataReportContents) {
        this.dataReportContents = dataReportContents;
    }

}
