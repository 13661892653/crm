package com.xlh.crm.mapper;

import com.xlh.crm.dto.ChartReqDTO;
import com.xlh.crm.dto.PageReqDTO;
import org.codehaus.plexus.util.StringUtils;

import java.util.List;

import static org.apache.ibatis.jdbc.SqlBuilder.*;

public class DataSqlProvider {

    //获取Dashboard指标
    public String getDashboardIndex(ChartReqDTO req) {
        StringBuffer sql = new StringBuffer();
        sql.append("select").append(" ");
        sql.append("sum(case when index_id = 10004 then index_value else 0 end) as mon_ac_contr_amt,").append(" ");
        sql.append("sum(case when index_id = 10006 then index_value else 0 end) as mon_ac_ord_cnt,").append(" ");
        sql.append("sum(case when index_id = 10008 then index_value else 0 end) as mon_ac_ord_amt,").append(" ");
        sql.append("sum(case when index_id = 10010 then index_value else 0 end) as mon_rch_ent_cnt,").append(" ");
        sql.append("sum(case when index_id = 10002 then index_value else 0 end) as mon_upt_ent_cnt,").append(" ");
        sql.append("sum(case when index_id = 10011 then index_value else 0 end) as ent_total_cnt").append(" ");
        sql.append("from crm_dashboard_index").append(" ");
        if (!StringUtils.isEmpty(req.getLastDate())) {
            sql.append("where ds = '").append(req.getLastDate().substring(0, 7)).append("'").append(" ");
        }

        return sql.toString();
    }

    //获取图形条件
    public String getChartCondition(ChartReqDTO req, String chartId) {
        StringBuffer sql = new StringBuffer();
        sql.append("select chart_id, create_member_id,setting_conditions").append(" ");
        sql.append("from dim_chr_conditions").append(" ");
        sql.append("where valid_flag = 'Y'").append(" ");
        if (!StringUtils.isEmpty(chartId)) {
            sql.append("AND chart_id in (").append(chartId).append(")").append(" ");
            //sql.append("AND substring(chart_id,1,1) = '").append(type).append("'").append(" ");
        }
        sql.append("order by chart_id asc");

        return sql.toString();
    }

    //获取图形数据
    public String getChartData(String chartId) {

        StringBuffer sql = new StringBuffer();
        sql.append("select chart_id, chart_data,count(1) as rec_cnt").append(" ");
        sql.append("from dim_chr_data").append(" ");
        sql.append("where valid_flag = 'Y'").append(" ");
        if (!StringUtils.isEmpty(chartId)) {
            sql.append("AND chart_id in('").append(chartId).append("')").append(" ");
            sql.append("limit 1 ");
        }

        return sql.toString();
    }

    //获取报表A数据
    public String getDataReportA(PageReqDTO req) {
        StringBuffer sql = new StringBuffer();
        String timeBegin = req.getTimeBegin();
        String timeEnd = req.getTimeEnd();
        sql.append("select company, ifnull(emp_cnt,1) as emp_cnt, g_cust_cnt, t_cust_cnt, f_cust_cnt, cust_cnt, ifnull(emp_avg,0) as emp_avg").append(" ");
        sql.append("  from (").append(" ");
        sql.append("select t1.branch_name as company,").append(" ");
        sql.append("count(distinct t2.rch_emp) as emp_cnt,").append(" ");
        sql.append("count(case when t2.biz_lv1_id = 'G' then t2.reg_credit_no else null end) as g_cust_cnt,").append(" ");
        sql.append("count(case when t2.biz_lv1_id = 'T' then t2.reg_credit_no else null end) as t_cust_cnt,").append(" ");
        sql.append("count(case when t2.biz_lv1_id = 'F' then t2.reg_credit_no else null end) as f_cust_cnt,").append(" ");
        sql.append("count(t2.reg_credit_no) as cust_cnt,").append(" ");
        sql.append("round(count(t2.reg_credit_no)/count(distinct t2.rch_emp),1) as emp_avg").append(" ");
        sql.append("from dim_branch t1 ").append(" ");
        sql.append("left outer join view_rpt_reachcsr t2").append(" ");
        sql.append("on t1.branch_name = t2.company").append(" ");
        if (!StringUtils.isEmpty(req.getTimeBegin()) && !StringUtils.isEmpty(req.getTimeEnd())) {
            sql.append("and substr(t2.begin_time,1,10) >= '").append(timeBegin).append("'").append(" ");
            sql.append("and substr(t2.begin_time,1,10) <= '").append(timeEnd).append("'").append(" ");
        }
        sql.append("where t1.branch_name!='北美'").append(" ");
        if (!req.getRegionCode().equals("all")) {
            String regionCode = req.getRegionCode();
            if (!StringUtils.isEmpty(regionCode)) {
                sql.append("AND t1.branch_name = '").append(regionCode).append("'").append(" ");
            }
        }
        sql.append("group by t1.branch_name").append(" ");
        sql.append(") t").append(" ");
        sql.append("order by emp_avg desc,company desc");

        return sql.toString();
    }

    //获取报表B数据
    public String getDataReportB(PageReqDTO req) {
        StringBuffer sql = new StringBuffer();
        String timeBegin = req.getTimeBegin();
        String timeEnd = req.getTimeEnd();
        sql.append("select company,").append(" ");
        sql.append("ifnull(vst_cust_cnt,0) as vst_cust_cnt, round(case when cust_cnt = 0 then 0 else vst_cust_cnt/cust_cnt end,4) as vst_cust_rate,").append(" ");
        sql.append("ifnull(g_vst_cust_cnt,0) as g_vst_cust_cnt, round(case when g_cust_cnt = 0 then 0 else g_vst_cust_cnt/g_cust_cnt end,4) as g_vst_cust_rate,").append(" ");
        sql.append("ifnull(t_vst_cust_cnt,0) as t_vst_cust_cnt, round(case when t_cust_cnt = 0 then 0 else t_vst_cust_cnt/t_cust_cnt end,4) as t_vst_cust_rate,").append(" ");
        sql.append("ifnull(f_vst_cust_cnt,0) as f_vst_cust_cnt, round(case when f_cust_cnt = 0 then 0 else f_vst_cust_cnt/f_cust_cnt end,4) as f_vst_cust_rate").append(" ");
        sql.append("  from (").append(" ");
        sql.append("select t1.branch_name as company,").append(" ");
        sql.append("count(case when t2.rch_mode = '拜访' then t2.reg_credit_no else null end) as vst_cust_cnt,").append(" ");
        sql.append("count(t2.reg_credit_no) as cust_cnt,").append(" ");
        sql.append("count(case when t2.biz_lv1_id = 'G' and t2.rch_mode = '拜访' then reg_credit_no else null end) as g_vst_cust_cnt,").append(" ");
        sql.append("count(case when t2.biz_lv1_id = 'G' then t2.reg_credit_no else null end) as g_cust_cnt,").append(" ");
        sql.append("count(case when t2.biz_lv1_id = 'T' and t2.rch_mode = '拜访' then reg_credit_no else null end) as t_vst_cust_cnt,").append(" ");
        sql.append("count(case when t2.biz_lv1_id = 'T' then t2.reg_credit_no else null end) as t_cust_cnt,").append(" ");
        sql.append("count(case when t2.biz_lv1_id = 'F' and t2.rch_mode = '拜访' then reg_credit_no else null end) as f_vst_cust_cnt,").append(" ");
        sql.append("count(case when t2.biz_lv1_id = 'F' then t2.reg_credit_no else null end) as f_cust_cnt").append(" ");
        sql.append("from dim_branch t1 ").append(" ");
        sql.append("left outer join view_rpt_reachcsr t2").append(" ");
        sql.append("on t1.branch_name = t2.company").append(" ");
        if (!StringUtils.isEmpty(req.getTimeBegin()) && !StringUtils.isEmpty(req.getTimeEnd())) {
            sql.append("and substr(t2.begin_time,1,10) >= '").append(timeBegin).append("'").append(" ");
            sql.append("and substr(t2.begin_time,1,10) <= '").append(timeEnd).append("'").append(" ");
        }
        sql.append("where t1.branch_name!='北美'").append(" ");
        if (!req.getRegionCode().equals("all")) {
            String regionCode = req.getRegionCode();
            if (!StringUtils.isEmpty(regionCode)) {
                sql.append("AND t1.branch_name = '").append(regionCode).append("'").append(" ");
            }
        }
        sql.append("group by t1.branch_name").append(" ");
        sql.append(") t").append(" ");
        sql.append("order by vst_cust_cnt desc, company desc");

        return sql.toString();
    }

    //获取报表C数据
    public String getDataReportC(PageReqDTO req) {
        StringBuffer sql = new StringBuffer();
        String timeBegin = req.getTimeBegin();
        String timeEnd = req.getTimeEnd();
        sql.append("select t1.branch_name as company,").append(" ");
        sql.append("ifnull(t2.rch_emp,'') as employee,").append(" ");
        sql.append("count(case when t2.biz_lv1_id = 'G' then t2.reg_credit_no else null end) as g_cust_cnt,").append(" ");
        sql.append("count(case when t2.biz_lv1_id = 'T' then t2.reg_credit_no else null end) as t_cust_cnt,").append(" ");
        sql.append("count(case when t2.biz_lv1_id = 'F' then t2.reg_credit_no else null end) as f_cust_cnt,").append(" ");
        sql.append("count(t2.reg_credit_no) as cust_cnt").append(" ");
        sql.append("from dim_branch t1 ").append(" ");
        sql.append("left outer join view_rpt_reachcsr t2").append(" ");
        sql.append("on t1.branch_name = t2.company").append(" ");
        if (!StringUtils.isEmpty(req.getTimeBegin()) && !StringUtils.isEmpty(req.getTimeEnd())) {
            sql.append("and substr(t2.begin_time,1,10) >= '").append(timeBegin).append("'").append(" ");
            sql.append("and substr(t2.begin_time,1,10) <= '").append(timeEnd).append("'").append(" ");
        }
        sql.append("where t1.branch_name!='北美'").append(" ");
        if (!req.getRegionCode().equals("all")) {
            String regionCode = req.getRegionCode();
            if (!StringUtils.isEmpty(regionCode)) {
                sql.append("AND t1.branch_name = '").append(regionCode).append("'").append(" ");
            }
        }
        sql.append("group by t1.branch_name,ifnull(t2.rch_emp,'')").append(" ");
        sql.append("order by cust_cnt desc,company desc");

        return sql.toString();
    }

    //获取报表D数据
    public String getDataReportD(PageReqDTO req) {
        StringBuffer sql = new StringBuffer();
        String timeBegin = req.getTimeBegin();
        String timeEnd = req.getTimeEnd();
        sql.append("select company,employee,login_day_cnt").append(" ");
        sql.append("from (").append(" ");
        sql.append("select t2.company,").append(" ");
        sql.append("t1.operator as employee,").append(" ");
        sql.append("count(distinct substr(t1.operation_time,1,10)) as login_day_cnt").append(" ");
        sql.append("from crm_operation_log t1").append(" ");
        sql.append("join dim_mbr_xlh_user_info t2").append(" ");
        sql.append("  on t1.operator = t2.user_name").append(" ");
        sql.append("where t1.event_type = 'LOGIN'").append(" ");
        sql.append("and t2.company <> '总部'").append(" ");
        if (!req.getRegionCode().equals("all")) {
            String regionCode = req.getRegionCode();
            if (!StringUtils.isEmpty(regionCode)) {
                sql.append("AND t2.company = '").append(regionCode).append("'").append(" ");
            }
        }
        if (!StringUtils.isEmpty(req.getTimeBegin()) && !StringUtils.isEmpty(req.getTimeEnd())) {
            sql.append("and substr(t1.operation_time,1,10) >= '").append(timeBegin).append("'").append(" ");
            sql.append("and substr(t1.operation_time,1,10) <= '").append(timeEnd).append("'").append(" ");
        }
        sql.append("group by t2.company,t1.operator").append(" ");
        sql.append(") a").append(" ");
        sql.append("order by a.login_day_cnt desc,a.company desc");

        return sql.toString();
    }

    //获取报表E数据
    public String getDataReportE(PageReqDTO req) {
        StringBuffer sql = new StringBuffer();
        String timeBegin = req.getTimeBegin();
        String timeEnd = req.getTimeEnd();
        sql.append("SELECT branch_name,");
        sql.append("sum(case when gov_line='其它' then 1 else 0 end) as qt_count,");
        sql.append("sum(case when gov_line='人才办(组织部)' then 1 else 0 end) as rcb_count,");
        sql.append("sum(case when gov_line='经信委' then 1 else 0 end) as jxw_count,");
        sql.append("sum(case when gov_line='科技局(科委)' then 1 else 0 end) as kjb_count,");
        sql.append("sum(case when gov_line='金融办' then 1 else 0 end) as jrb_count,").append(" ");
        sql.append("sum(case when gov_line='人民政府' then 1 else 0 end) as rmzf_count,").append(" ");
        sql.append("sum(case when gov_line='发改委' then 1 else 0 end) as fgw_count").append(" ");

        sql.append("from view_rpt_gov_reachcsr WHERE 1=1 ");

        if (!StringUtils.isEmpty(req.getTimeBegin()) && !StringUtils.isEmpty(req.getTimeEnd())) {
            sql.append("and begin_time BETWEEN '" + req.getTimeBegin() + "' and '" + req.getTimeEnd() + "'");
        }
        sql.append("and branch_name!='北美'").append(" ");
        if (!("all").equals(req.getRegionCode())) {
            String regionCode = req.getRegionCode();
            if (!StringUtils.isEmpty(regionCode)) {
                sql.append("and branch_name = '").append(regionCode).append("'").append(" ");
            }
        }
        sql.append(" GROUP BY branch_name ");
        return sql.toString();
    }


    //个人分配及触达企业数
    public String getDataReportF(PageReqDTO req) {
        StringBuffer sql = new StringBuffer();
        String timeBegin = req.getTimeBegin();
        String timeEnd = req.getTimeEnd();
        sql.append("select res.*,mbr.company from ( ");
        sql.append("select * from ( ");
        sql.append("select count(*) as week_dist,fav_user_list,fav_user_id,cust_manager from crm_ent_favorite ");
        sql.append("where LENGTH(cust_manager)>0 and cust_manager_update_time  between'" + req.getTimeBegin() + "' and '" + req.getTimeEnd() + "' GROUP BY fav_user_list,cust_manager ) t1 ");
        sql.append("LEFT JOIN (select count(DISTINCT enterprise_name) as week_reac,rch_emp from crm_reachcsr where insert_time between'" + req.getTimeBegin() + "' and '" + req.getTimeEnd() + "' GROUP BY rch_emp ) t2 on t1.cust_manager=t2.rch_emp) res ");
        sql.append("LEFT JOIN dim_mbr_xlh_user_info mbr on res.fav_user_id=mbr.member_id ");

        sql.append("ORDER BY mbr.company ASC");
        return sql.toString();
    }


    //获取报表E数据合计
    public String getDataReportESum(PageReqDTO req) {
        StringBuffer sql = new StringBuffer();
        String timeBegin = req.getTimeBegin();
        String timeEnd = req.getTimeEnd();
        sql.append("SELECT branch_name,");
        sql.append("sum(case when gov_line='其它' then 1 else 0 end) as qt_count,");
        sql.append("sum(case when gov_line='人才办(组织部)' then 1 else 0 end) as rcb_count,");
        sql.append("sum(case when gov_line='经信委' then 1 else 0 end) as jxw_count,");
        sql.append("sum(case when gov_line='科技局(科委)' then 1 else 0 end) as kjb_count,");
        sql.append("sum(case when gov_line='金融办' then 1 else 0 end) as jrb_count").append(" ");

        sql.append("from view_rpt_gov_reachcsr WHERE 1=1 ");

        if (!StringUtils.isEmpty(req.getTimeBegin()) && !StringUtils.isEmpty(req.getTimeEnd())) {
            sql.append("and begin_time BETWEEN '" + req.getTimeBegin() + "' and '" + req.getTimeEnd() + "'");
        }
        sql.append("and branch_name!='北美'").append(" ");
        if (!("all").equals(req.getRegionCode())) {
            String regionCode = req.getRegionCode();
            if (!StringUtils.isEmpty(regionCode)) {
                sql.append("and branch_name = '").append(regionCode).append("'").append(" ");
            }
        }
        return sql.toString();
    }

    //函数：把List字符串转换成带单引号的字符串
    private String listTransStr(List<String> listPar) {
        StringBuffer strBuf = new StringBuffer();
        String retStr = null;
        for (int i = 0; i < listPar.size(); i++) {
            strBuf.append(",'").append(listPar.get(i)).append("'");
        }
        retStr = strBuf.toString();
        return retStr.substring(1, retStr.length()); //返回时去掉第一个单引号
    }

}