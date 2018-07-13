package com.xlh.crm.dto;

import java.util.List;

public class DataReportRespOrgDto {
    /*请求参数返回前端*/
    private PageReqDTO reqParams;

    private List<DataReportShowOrgDto> dataReportContents;

    //合计数据
    private DataReportShowOrgDto dataReportShowOrgDto;

    public DataReportShowOrgDto getDataReportShowOrgDto() {
        return dataReportShowOrgDto;
    }

    public void setDataReportShowOrgDto(DataReportShowOrgDto dataReportShowOrgDto) {
        this.dataReportShowOrgDto = dataReportShowOrgDto;
    }

    public PageReqDTO getReqParams() {
        return reqParams;
    }

    public void setReqParams(PageReqDTO reqParams) {
        this.reqParams = reqParams;
    }

    public List<DataReportShowOrgDto> getDataReportContents() {
        return dataReportContents;
    }

    public void setDataReportContents(List<DataReportShowOrgDto> dataReportContents) {
        this.dataReportContents = dataReportContents;
    }
}
