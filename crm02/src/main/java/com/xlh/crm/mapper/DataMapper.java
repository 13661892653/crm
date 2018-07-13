package com.xlh.crm.mapper;

import com.xlh.crm.dto.*;
import com.xlh.crm.dto.mysql.BranchPersonReach;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

/**
 * Created by ysl on 2017/05/12.
 */
public interface DataMapper {

    // 获取Dashboard指标
    @Results({
            @Result(column="mon_ac_contr_amt", property="monAcContrAmt", jdbcType=JdbcType.DOUBLE),
            @Result(column="mon_ac_ord_cnt", property="monAcOrdCnt", jdbcType=JdbcType.INTEGER),
            @Result(column="mon_ac_ord_amt", property="monAcOrdAmt", jdbcType=JdbcType.DOUBLE),
            @Result(column="mon_rch_ent_cnt", property="monRchEntCnt", jdbcType=JdbcType.INTEGER),
            @Result(column="mon_upt_ent_cnt", property="monUptEntCnt", jdbcType=JdbcType.INTEGER),
            @Result(column="ent_total_cnt", property="entTotalCnt", jdbcType=JdbcType.INTEGER)
    })
    @SelectProvider(type=DataSqlProvider.class, method="getDashboardIndex")
    DashboardIndexShowDTO getDashboardIndex(ChartReqDTO req);

    // 获取报表数据A
    @Results({
            @Result(column="dt", property="dt", jdbcType= JdbcType.VARCHAR),
            @Result(column="company", property="company", jdbcType= JdbcType.VARCHAR),
            @Result(column="emp_cnt", property="empCnt", jdbcType=JdbcType.INTEGER),
            @Result(column="g_cust_cnt", property="gCustCnt", jdbcType=JdbcType.INTEGER),
            @Result(column="t_cust_cnt", property="tCustCnt", jdbcType=JdbcType.INTEGER),
            @Result(column="f_cust_cnt", property="fCustCnt", jdbcType=JdbcType.INTEGER),
            @Result(column="cust_cnt", property="custCnt", jdbcType=JdbcType.INTEGER),
            @Result(column="emp_avg", property="empAvg", jdbcType=JdbcType.DOUBLE)
    })
    @SelectProvider(type=DataSqlProvider.class, method="getDataReportA")
    List<DataReportShowDTO> getDataReportA(PageReqDTO req);

    // 获取报表数据B
    @Results({
            @Result(column="dt", property="dt", jdbcType= JdbcType.VARCHAR),
            @Result(column="company", property="company", jdbcType= JdbcType.VARCHAR),
            @Result(column="vst_cust_cnt", property="vstCustCnt", jdbcType=JdbcType.INTEGER),
            @Result(column="vst_cust_rate", property="vstCustRate", jdbcType=JdbcType.DOUBLE),
            @Result(column="g_vst_cust_cnt", property="gVstCustCnt", jdbcType=JdbcType.INTEGER),
            @Result(column="g_vst_cust_rate", property="gVstCustRate", jdbcType=JdbcType.DOUBLE),
            @Result(column="t_vst_cust_cnt", property="tVstCustCnt", jdbcType=JdbcType.INTEGER),
            @Result(column="t_vst_cust_rate", property="tVstCustRate", jdbcType=JdbcType.DOUBLE),
            @Result(column="f_vst_cust_cnt", property="fVstCustCnt", jdbcType=JdbcType.INTEGER),
            @Result(column="f_vst_cust_rate", property="fVstCustRate", jdbcType=JdbcType.DOUBLE)
    })
    @SelectProvider(type=DataSqlProvider.class, method="getDataReportB")
    List<DataReportShowDTO> getDataReportB(PageReqDTO req);

    // 获取报表数据C
    @Results({
            @Result(column="dt", property="dt", jdbcType= JdbcType.VARCHAR),
            @Result(column="company", property="company", jdbcType= JdbcType.VARCHAR),
            @Result(column="employee", property="employee", jdbcType= JdbcType.VARCHAR),
            @Result(column="g_cust_cnt", property="gCustCnt", jdbcType=JdbcType.INTEGER),
            @Result(column="t_cust_cnt", property="tCustCnt", jdbcType=JdbcType.INTEGER),
            @Result(column="f_cust_cnt", property="fCustCnt", jdbcType=JdbcType.INTEGER),
            @Result(column="cust_cnt", property="custCnt", jdbcType=JdbcType.INTEGER)
    })
    @SelectProvider(type=DataSqlProvider.class, method="getDataReportC")
    List<DataReportShowDTO> getDataReportC(PageReqDTO req);

    // 获取报表数据D
    @Results({
            @Result(column="dt", property="dt", jdbcType= JdbcType.VARCHAR),
            @Result(column="company", property="company", jdbcType= JdbcType.VARCHAR),
            @Result(column="employee", property="employee", jdbcType= JdbcType.VARCHAR),
            @Result(column="login_day_cnt", property="loginDayCnt", jdbcType=JdbcType.INTEGER)
    })
    @SelectProvider(type=DataSqlProvider.class, method="getDataReportD")
    List<DataReportShowDTO> getDataReportD(PageReqDTO req);

    // 获取报表数据E
    @Results({
            @Result(column="branch_name", property="branchName", jdbcType= JdbcType.VARCHAR),
            @Result(column="qt_count", property="qtCount", jdbcType= JdbcType.INTEGER),
            @Result(column="rcb_count", property="rcbCount", jdbcType= JdbcType.INTEGER),
            @Result(column="jxw_count", property="jxwCount", jdbcType= JdbcType.INTEGER),
            @Result(column="kjb_count", property="kjbCount", jdbcType=JdbcType.INTEGER),
            @Result(column="jrb_count", property="jrbCount", jdbcType=JdbcType.INTEGER),
            @Result(column="rmzf_count", property="rmzfCount", jdbcType=JdbcType.INTEGER),
            @Result(column="fgw_count", property="fgwCount", jdbcType=JdbcType.INTEGER)
    })
    @SelectProvider(type=DataSqlProvider.class, method="getDataReportE")
    List<DataReportShowOrgDto> getDataReportE(PageReqDTO req);

    // 个人分配及触达企业数
    @Results({
            @Result(column="company", property="company", jdbcType= JdbcType.VARCHAR),
            @Result(column="fav_user_list", property="favUserList", jdbcType= JdbcType.VARCHAR),
            @Result(column="fav_user_id", property="favUserId", jdbcType= JdbcType.INTEGER),
            @Result(column="cust_manager", property="custManager", jdbcType= JdbcType.VARCHAR),
            @Result(column="week_dist", property="weekDist", jdbcType=JdbcType.INTEGER),
            @Result(column="week_reac", property="weekReac", jdbcType=JdbcType.INTEGER),
            @Result(column="rmzf_count", property="rmzfCount", jdbcType=JdbcType.INTEGER),
            @Result(column="fgw_count", property="fgwCount", jdbcType=JdbcType.INTEGER)
    })
    @SelectProvider(type=DataSqlProvider.class, method="getDataReportF")
    List<BranchPersonReach> getDataReportF(PageReqDTO req);

    @Results({
            @Result(column="branch_name", property="branchName", jdbcType= JdbcType.VARCHAR),
            @Result(column="qt_count", property="qtCount", jdbcType= JdbcType.INTEGER),
            @Result(column="rcb_count", property="rcbCount", jdbcType= JdbcType.INTEGER),
            @Result(column="jxw_count", property="jxwCount", jdbcType= JdbcType.INTEGER),
            @Result(column="kjb_count", property="kjbCount", jdbcType=JdbcType.INTEGER),
            @Result(column="jrb_count", property="jrbCount", jdbcType=JdbcType.INTEGER)
    })
    @SelectProvider(type=DataSqlProvider.class, method="getDataReportESum")
    DataReportShowOrgDto getDataReportESum (PageReqDTO req);

    // 获取图形ID
    @Results({
            @Result(column="chart_id", property="chartId", jdbcType=JdbcType.VARCHAR),
            @Result(column="create_member_id", property="createMemberId", jdbcType=JdbcType.VARCHAR),
            @Result(column="setting_conditions", property="settingConditions", jdbcType=JdbcType.VARCHAR)
    })
    @SelectProvider(type=DataSqlProvider.class, method="getChartCondition")
    List<ChartShowDTO> getChartCondition(ChartReqDTO req,String type);

    // 获取图形数据
    @Results({
            @Result(column="chart_id", property="chartId", jdbcType=JdbcType.VARCHAR),
            @Result(column="chart_data", property="chartData", jdbcType=JdbcType.VARCHAR),
            @Result(column="rec_cnt", property="recCnt", jdbcType=JdbcType.INTEGER)
    })
    @SelectProvider(type=DataSqlProvider.class, method="getChartData")
    ChartShowDTO getChartData(String chartId);

}