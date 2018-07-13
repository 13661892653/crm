package com.xlh.crm.service;


import com.xlh.crm.dto.*;
import com.xlh.crm.dto.mysql.BranchPersonReachShowResp;

import java.util.List;

/**
 * Created by ysl on 2017/05/10.
 */
public interface DataService {

    //获取Dashboard指标
    DashboardIndexShowDTO getDashboardIndex(ChartReqDTO req);

    //获取选择的指标字段
    ChartListRespDTO getChartCondition(ChartReqDTO req,String chartId);

    //获取报表数据A
    DataReportRespDTO getDataReportA(PageReqDTO req);

    //获取报表数据B
    DataReportRespDTO getDataReportB(PageReqDTO req);

    //获取报表数据C
    DataReportRespDTO getDataReportC(PageReqDTO req);

    //获取报表数据D
    DataReportRespDTO getDataReportD(PageReqDTO req);

    //获取报表数据E
    DataReportRespOrgDto getDataReportE(PageReqDTO req);

    //个人分配及触达企业数
    List<BranchPersonReachShowResp> getDataReportF(PageReqDTO req);

    //非实时：柱状图
    String getGenChartData(ChartListRespDTO chartListRespDTO);

    //非实时：堆积柱状图
    String getStkChartData(ChartListRespDTO chartListRespDTO);

    //实时数据
    String getRtChartData1(ChartListRespDTO chartListRespDTO);

    //实时数据
    String getRtChartData2(ChartListRespDTO chartListRespDTO);

    //实时数据
    String getRtChartData3(ChartListRespDTO chartListRespDTO);
}
