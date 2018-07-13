package com.xlh.crm.mapper;

import com.xlh.crm.common.CurrentTime;
import com.xlh.crm.dto.PageReqDTO;
import com.xlh.crm.dto.ReachShowDTO;
import org.codehaus.plexus.util.StringUtils;

import static org.apache.ibatis.jdbc.SqlBuilder.*;

public class ReachSqlProvider {

    //触达信息列表
    public String getReachList(PageReqDTO reqdto) {
        StringBuffer sql = new StringBuffer();
        sql.append("select t1.cust_type, " +
                "t1.rch_no, " +
                "t1.biz_lv1_id, " +
                "t1.biz_lv2_id, " +
                "t1.biz_lv1_name, " +
                "t1.reg_credit_no, " +
                "t1.credit_no, " +
                "t1.reg_no, " +
                "t1.enterprise_name, " +
                "t1.win_cust_chnl, " +
                "t1.rch_mode, " +
                "t1.begin_time, " +
                "t1.end_time, " +
                "t1.contacts, " +
                "t1.job_title, " +
                "t1.contacts_phone, " +
                "t1.sales_lead, " +
                "t1.gov_line," +
                "t1.gov_level," +
                "t1.gov_qzr," +
                "t1.comm_topic," +
                "t1.get_effect," +
                "t1.result_time," +
                "t1.cdn_things," +
                "t1.remark, " +
                "t1.rch_emp, " +
                "t1.company, " +
                "case when t2.reg_credit_no is null then '4002' else '4003' end as ent_type, " +
                "t1.update_time, " +
                "t5.gq_score, " +
                "t3.reachcsr_times").append(" ");
        sql.append("from crm_reachcsr t1").append(" ");
        sql.append("left join (select distinct reg_credit_no from crm_order) t2").append(" ");
        sql.append("on t1.reg_credit_no = t2.reg_credit_no").append(" ");
        sql.append("left join (select enterprise_name,count(*) as reachcsr_times  from crm_reachcsr group by enterprise_name ) t3").append(" ");
        sql.append("on t1.enterprise_name = t3.enterprise_name").append(" ");
        sql.append("left join cdm_ent_dto_high_tech t4 on t1.reg_credit_no=t4.reg_credit_no ");
        sql.append("left join cdm_ent_dto_corp_info t5 on t1.reg_credit_no=t5.reg_credit_no ");
        sql.append("left join cdm_ent_dto_corp_info_ext t6 on t1.reg_credit_no=t6.reg_credit_no ");
        sql.append("where t1.cust_type ='").append(reqdto.getCustType()).append("'").append(" ");
        if (!reqdto.getBizLv1Id().equals("all")) {
            String bizLv1Id = reqdto.getBizLv1Id();
            if (!StringUtils.isEmpty(bizLv1Id)) {
                sql.append("AND t1.biz_lv1_id ='").append(bizLv1Id).append("'").append(" ");
            }
        }
        if (!reqdto.getBizLv2Id().equals("all")) {
            String bizLv2Id = reqdto.getBizLv2Id();
            if (!StringUtils.isEmpty(bizLv2Id)) {
                sql.append("AND t1.biz_lv2_id ='").append(bizLv2Id).append("'").append(" ");
            }
        }
        if (!reqdto.getHasDemand().equals("all")) {
            if (!StringUtils.isEmpty(reqdto.getHasDemand())) {
                sql.append("AND t4.has_demand ='").append(reqdto.getHasDemand()).append("'").append(" ");
            }else{
                sql.append("and t4.has_demand is null ");
            }
        }
        if (!reqdto.getWinCustChnl().equals("all")) {
            String winCustChnl = reqdto.getWinCustChnl();
            if (!StringUtils.isEmpty(winCustChnl)) {
                sql.append("AND t1.win_cust_chnl ='").append(winCustChnl).append("'").append(" ");
            }
        }
        if (!reqdto.getEntType().equals("all")) {
            String entType = reqdto.getEntType();
            if (!StringUtils.isEmpty(entType) && entType.equals("4002")) {
                sql.append("AND t1.cust_type = 'corpCust'").append(" ");
                sql.append("AND t2.reg_credit_no is null ").append(" ");
            }
            if (!StringUtils.isEmpty(entType) && entType.equals("4003")) {
                sql.append("AND t1.cust_type = 'corpCust' ").append(" ");
                sql.append("AND t2.reg_credit_no is not null ").append(" ");
            }
        }
        if (!reqdto.getTimeBegin().equals("all")) {
            String rchTimeBegin = reqdto.getTimeBegin();
            String rchTimeEnd = reqdto.getTimeEnd();
            if (!StringUtils.isEmpty(rchTimeBegin)) {
                sql.append("AND SUBSTR(t1.begin_time,1,10) <= '").append(rchTimeEnd).append("'").append(" ");
                sql.append("AND SUBSTR(t1.begin_time,1,10) >= '").append(rchTimeBegin).append("'").append(" ");
            }
        }

        if(!reqdto.getAssetsTagCode().equals("all")){
            String assetsTagCode = reqdto.getAssetsTagCode();
            if(!StringUtils.isEmpty(assetsTagCode)){
                sql.append("AND t6.tag_array like '%").append(assetsTagCode).append("%'").append(" ");
                //sql.append("AND MATCH (t1.tag_array)AGAINST (").append(assetsTagCode).append(")").append(" ");
            }
        }
        if (!reqdto.getEmpName().equals("all")) {
            String empName = reqdto.getEmpName();
            if (!StringUtils.isEmpty(empName)) {
                sql.append("AND t1.rch_emp ='").append(empName).append("'").append(" ");
            }
        }
        if (!StringUtils.isEmpty(reqdto.getRegCreditNo())) {
            sql.append("AND t1.reg_credit_no = '").append(reqdto.getRegCreditNo()).append("'").append(" ");
        }
        if (!StringUtils.isEmpty(reqdto.getCorpName())) {
            sql.append("AND t1.enterprise_name like '%").append(reqdto.getCorpName()).append("%'").append(" ");
        }
        if (!StringUtils.isEmpty(reqdto.getMemberType()) && (Integer.parseInt(reqdto.getMemberType()) > 90) && !StringUtils.isEmpty(reqdto.getUserName())) { //权限控制：分公司一般员工只能看到自己的
            sql.append("and t1.rch_emp = '").append(reqdto.getUserName()).append("'").append(" ");
        }
        if (!StringUtils.isEmpty(reqdto.getMemberType()) && reqdto.getMemberType().equals("90") && !StringUtils.isEmpty(reqdto.getCompany())) { //权限控制：分公司经理只能看到本分公司的
            sql.append("and t1.company = '").append(reqdto.getCompany()).append("'").append(" ");
        }
        sql.append("order by t1.insert_time desc").append(" ");
        sql.append(getLimitSql(reqdto.getPageIndex(), reqdto.getPageSize()));

        return sql.toString();
    }

    //触达信息总数，用于分页
    public String getReachListCount(PageReqDTO reqdto) {
        StringBuffer sql = new StringBuffer();
        sql.append("select count(t1.rch_no) ").append(" ");
        sql.append("from crm_reachcsr t1").append(" ");
        sql.append("left join (select distinct reg_credit_no from crm_order) t2").append(" ");
        sql.append("on t1.reg_credit_no = t2.reg_credit_no").append(" ");
        sql.append("left join cdm_ent_dto_high_tech t4 on t1.reg_credit_no=t4.reg_credit_no ");
        sql.append("left join cdm_ent_dto_corp_info_ext t6 on t1.reg_credit_no=t6.reg_credit_no ");
        sql.append("where t1.cust_type ='").append(reqdto.getCustType()).append("'").append(" ");
        if (!reqdto.getBizLv1Id().equals("all")) {
            String bizLv1Id = reqdto.getBizLv1Id();
            if (!StringUtils.isEmpty(bizLv1Id)) {
                sql.append("AND t1.biz_lv1_id ='").append(bizLv1Id).append("'").append(" ");
            }
        }

        if(!reqdto.getAssetsTagCode().equals("all")){
            String assetsTagCode = reqdto.getAssetsTagCode();
            if(!StringUtils.isEmpty(assetsTagCode)){
                sql.append("AND t6.tag_array like '%").append(assetsTagCode).append("%'").append(" ");
                //sql.append("AND MATCH (t1.tag_array)AGAINST (").append(assetsTagCode).append(")").append(" ");
            }
        }
        if (!reqdto.getHasDemand().equals("all")) {
            if (!StringUtils.isEmpty(reqdto.getHasDemand())) {
                sql.append("AND t4.has_demand ='").append(reqdto.getHasDemand()).append("'").append(" ");
            }else{
                sql.append("and t4.has_demand is null ");
            }
        }
        if (!reqdto.getBizLv2Id().equals("all")) {
            String bizLv2Id = reqdto.getBizLv2Id();
            if (!StringUtils.isEmpty(bizLv2Id)) {
                sql.append("AND t1.biz_lv2_id ='").append(bizLv2Id).append("'").append(" ");
            }
        }
        if (!reqdto.getWinCustChnl().equals("all")) {
            String winCustChnl = reqdto.getWinCustChnl();
            if (!StringUtils.isEmpty(winCustChnl)) {
                sql.append("AND t1.win_cust_chnl ='").append(winCustChnl).append("'").append(" ");
            }
        }
        if (!reqdto.getEntType().equals("all")) {
            String entType = reqdto.getEntType();
            if (!StringUtils.isEmpty(entType) && entType.equals("4002")) {
                sql.append("AND t1.cust_type = 'corpCust'").append(" ");
                sql.append("AND t2.reg_credit_no is null").append(" ");
            }
            if (!StringUtils.isEmpty(entType) && entType.equals("4003")) {
                sql.append("AND t1.cust_type = 'corpCust'").append(" ");
                sql.append("AND t2.reg_credit_no is not null").append(" ");
            }
        }
        if (!reqdto.getTimeBegin().equals("all")) {
            String rchTimeBegin = reqdto.getTimeBegin();
            String rchTimeEnd = reqdto.getTimeEnd();
            if (!StringUtils.isEmpty(rchTimeBegin)) {
                sql.append("AND SUBSTR(t1.begin_time,1,10) <= '").append(rchTimeEnd).append("'").append(" ");
                sql.append("AND SUBSTR(t1.begin_time,1,10) >= '").append(rchTimeBegin).append("'").append(" ");
            }
        }
        if (!reqdto.getEmpName().equals("all")) {
            String empName = reqdto.getEmpName();
            if (!StringUtils.isEmpty(empName)) {
                sql.append("AND t1.rch_emp ='").append(empName).append("'").append(" ");
            }
        }
        if (!StringUtils.isEmpty(reqdto.getRegCreditNo())) {
            sql.append("AND t1.reg_credit_no = '").append(reqdto.getRegCreditNo()).append("'").append(" ");
        }
        if (!StringUtils.isEmpty(reqdto.getCorpName())) {
            sql.append("AND t1.enterprise_name like '%").append(reqdto.getCorpName()).append("%'").append(" ");
        }
        if (!StringUtils.isEmpty(reqdto.getMemberType()) && (Integer.parseInt(reqdto.getMemberType()) > 90) && !StringUtils.isEmpty(reqdto.getUserName())) { //权限控制：分公司一般员工只能看到自己的
            sql.append("and t1.rch_emp = '").append(reqdto.getUserName()).append("'").append(" ");
        }
        if (!StringUtils.isEmpty(reqdto.getMemberType()) && reqdto.getMemberType().equals("90") && !StringUtils.isEmpty(reqdto.getCompany())) { //权限控制：分公司经理只能看到本分公司的
            sql.append("and t1.company = '").append(reqdto.getCompany()).append("'").append(" ");
        }

        return sql.toString();
    }

    private String getLimitSql(Integer index, Integer pageSize) {
        return "LIMIT " + (index - 1) * pageSize + "," + pageSize;
    }

    //单个触达信息查询
    public String getReachByRchNo(String rchNo) {
        StringBuffer sql = new StringBuffer();
        sql.append("select t1.cust_type, " +
                "t1.rch_no," +
                "t1.company," +
                "t1.rch_emp," +
                "t1.biz_lv1_id," +
                "t1.biz_lv2_id," +
                "t1.enterprise_name," +
                "t1.win_cust_chnl," +
                "t1.rch_mode," +
                "t1.begin_time," +
                "t1.end_time," +
                "t1.contacts," +
                "t1.job_title," +
                "t1.contacts_phone," +
                "t1.sales_lead," +
                "t1.gov_line," +
                "t1.gov_level," +
                "t1.gov_qzr," +
                "t1.comm_topic," +
                "t1.get_effect," +
                "t1.result_time," +
                "t1.cdn_things," +
                "t1.remark," +
                "t1.update_time").append(" ");
        sql.append("from crm_reachcsr t1").append(" ");
        sql.append("where t1.rch_no = '").append(rchNo).append("'");

        return sql.toString();
    }

    //新增触达信息入库
    public String insertReach(ReachShowDTO record) {
        BEGIN();
        INSERT_INTO("crm_reachcsr");

        if (record.getCustType() != null) {
            VALUES("cust_type", "#{custType,jdbcType=VARCHAR}");
        }

        if (record.getRchNo() != null) {
            VALUES("rch_no", "#{rchNo,jdbcType=VARCHAR}");
        }

        if (record.getBizLv1Id() != null) {
            VALUES("biz_lv1_id", "#{bizLv1Id,jdbcType=VARCHAR}");
        }

        if (record.getBizLv1Name() != null) {
            VALUES("biz_lv1_name", "#{bizLv1Name,jdbcType=VARCHAR}");
        }
        if (record.getBizLv2Id() != null) {
            VALUES("biz_lv2_id", "#{bizLv2Id,jdbcType=VARCHAR}");
        }
        if (record.getRegCreditNo() != null) {
            VALUES("reg_credit_no", "#{regCreditNo,jdbcType=VARCHAR}");
        }

        if (record.getCreditNo() != null) {
            VALUES("credit_no", "#{creditNo,jdbcType=VARCHAR}");
        }

        if (record.getRegNo() != null) {
            VALUES("reg_no", "#{regNo,jdbcType=VARCHAR}");
        }

        //非企业触达，取custName入enterprise_name
        if (!record.getCustName().equals("")) {
            VALUES("enterprise_name", "#{custName,jdbcType=VARCHAR}");
        }
        //企业触达，去enterprise_name入enterprise_name
        if (!record.getEnterpriseName().equals("")) {
            VALUES("enterprise_name", "#{enterpriseName,jdbcType=VARCHAR}");
        }
        //拜访政府，去enterprise_name入enterprise_name
        if (!record.getGovName().equals("")) {
            VALUES("enterprise_name", "#{govName,jdbcType=VARCHAR}");
        }

        if (record.getWinCustChnl() != null) {
            VALUES("win_cust_chnl", "#{winCustChnl,jdbcType=VARCHAR}");
        }

        if (record.getRchMode() != null) {
            VALUES("rch_mode", "#{rchMode,jdbcType=VARCHAR}");
        }

        if (record.getBeginTime() != null) {
            VALUES("begin_time", "#{beginTime,jdbcType=VARCHAR}");
        }

        if (record.getEndTime() != null) {
            VALUES("end_time", "#{endTime,jdbcType=VARCHAR}");
        }

        if (record.getContacts() != null) {
            VALUES("contacts", "#{contacts,jdbcType=VARCHAR}");
        }

        if (record.getJobTitle() != null) {
            VALUES("job_title", "#{jobTitle,jdbcType=VARCHAR}");
        }

        if (record.getContactsPhone() != null) {
            VALUES("contacts_phone", "#{contactsPhone,jdbcType=VARCHAR}");
        }

        if (record.getSalesLead() != null) {
            VALUES("sales_lead", "#{salesLead,jdbcType=VARCHAR}");
        }

        if (record.getGovLine() != null) {
            VALUES("gov_line", "#{govLine,jdbcType=VARCHAR}");
        }

        if (record.getGovLevel() != null) {
            VALUES("gov_level", "#{govLevel,jdbcType=VARCHAR}");
        }

        if (record.getGovQzr() != null) {
            VALUES("gov_qzr", "#{govQzr,jdbcType=VARCHAR}");
        }

        if (record.getCommTopic() != null) {
            VALUES("comm_topic", "#{commTopic,jdbcType=VARCHAR}");
        }

        if (record.getGetEffect() != null) {
            VALUES("get_effect", "#{getEffect,jdbcType=VARCHAR}");
        }

        if (record.getResultTime() != null) {
            VALUES("result_time", "#{resultTime,jdbcType=VARCHAR}");
        }

        if (record.getCdnThings() != null) {
            VALUES("cdn_things", "#{cdnThings,jdbcType=VARCHAR}");
        }

        if (record.getRemark() != null) {
            VALUES("remark", "#{remark,jdbcType=VARCHAR}");
        }

        if (record.getRchEmp() != null) {
            VALUES("rch_emp", "#{rchEmp,jdbcType=VARCHAR}");
        }

        if (record.getCompany() != null) {
            VALUES("company", "#{company,jdbcType=VARCHAR}");
        }
        if (record.getCompany() != null) {
            VALUES("update_id", "#{updateId,jdbcType=VARCHAR}");
        }
        if (record.getInsertTime() != null) {
            VALUES("insert_time", "#{insertTime,jdbcType=VARCHAR}");
        }
        if (record.getUpdateTime() != null) {
            VALUES("update_time", "#{updateTime,jdbcType=VARCHAR}");
        }

        return SQL();
    }

    //更新触达信息
    public String updateReach(ReachShowDTO record) {
        BEGIN();
        UPDATE("crm_reachcsr");

        if (record.getContacts() != null) {
            SET("contacts = #{contacts,jdbcType=VARCHAR}");
        }
        if (record.getJobTitle() != null) {
            SET("job_title = #{jobTitle,jdbcType=VARCHAR}");
        }
        if (record.getContactsPhone() != null) {
            SET("contacts_phone = #{contactsPhone,jdbcType=VARCHAR}");
        }
        if (record.getSalesLead() != null) {
            SET("sales_lead = #{salesLead,jdbcType=VARCHAR}");
        }
        if (record.getBeginTime() != null) {
            SET("begin_time = #{beginTime,jdbcType=VARCHAR}");
        }
        if (record.getRemark() != null) {
            SET("remark = #{remark,jdbcType=VARCHAR}");
        }
        if (record.getCommTopic() != null) {
            SET("comm_topic = #{commTopic,jdbcType=VARCHAR}");
        }
        if (record.getGetEffect() != null) {
            SET("get_effect = #{getEffect,jdbcType=VARCHAR}");
        }
        if (record.getResultTime() != null) {
            SET("result_time = #{resultTime,jdbcType=VARCHAR}");
        }
        if (record.getResultTime() != null) {
            SET("result_time = #{resultTime,jdbcType=VARCHAR}");
        }
        if (record.getCdnThings() != null) {
            SET("cdn_things = #{cdnThings,jdbcType=VARCHAR}");
        }
        if (record.getUpdateTime() != null) {
            SET("update_time = #{updateTime,jdbcType=VARCHAR}");
        }
        WHERE("rch_no = #{rchNo,jdbcType=VARCHAR}");

        return SQL();
    }
}