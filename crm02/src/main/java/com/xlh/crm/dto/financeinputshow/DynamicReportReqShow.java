package com.xlh.crm.dto.financeinputshow;

import com.xlh.crm.dto.mysql.FiDynamicReportApiReq;
import com.xlh.crm.dto.mysql.FiDynamicReportStruct;

public class DynamicReportReqShow {
    private FiDynamicReportApiReq fiDynamicReportApiReq;
    private FiDynamicReportStruct fiDynamicReportStruct;

    public FiDynamicReportApiReq getFiDynamicReportApiReq() {
        return fiDynamicReportApiReq;
    }

    public void setFiDynamicReportApiReq(FiDynamicReportApiReq fiDynamicReportApiReq) {
        this.fiDynamicReportApiReq = fiDynamicReportApiReq;
    }

    public FiDynamicReportStruct getFiDynamicReportStruct() {
        return fiDynamicReportStruct;
    }

    public void setFiDynamicReportStruct(FiDynamicReportStruct fiDynamicReportStruct) {
        this.fiDynamicReportStruct = fiDynamicReportStruct;
    }
}
