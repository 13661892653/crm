package com.xlh.crm.mapper;

import com.xlh.crm.dto.EnterpriseShowDTO;
import com.xlh.crm.dto.PageReqDTO;
import org.codehaus.plexus.util.StringUtils;

import static org.apache.ibatis.jdbc.SqlBuilder.*;

public class EnterpriseDetailSqlProvider {

    //企业档案-基本信息、客户经理
    public String getEnterpriseBaseInfoList(String regCreditNo){
        StringBuffer sql = new StringBuffer();
        sql.append("select t2.enterprise_name, t1.reg_credit_no,t1.credit_no, t1.reg_no" +
                ",t2.mgmt_status,t2.econ_kind,t2.legal_representative,t2.operate_date,t2.ent_address,t2.contact_telephone,t2.contact_email,t2.create_date" +
                ",t2.industry_type_code, t2.industry_type_name, t2.industry_code,t2.industry_name, t2.main_industry, t2.main_product" +
                ",t2.mgmt_scope,t2.register_money, t2.corp_info,t1.cust_manager,t1.audit_status,t1.tag_array,count(t1.reg_credit_no) as rec_cnt").append(" ");
        sql.append("from cdm_ent_dto_corp_info_ext t1").append(" ");
        sql.append("join cdm_ent_dto_corp_info t2").append(" ");
        sql.append("on (t1.reg_credit_no = t2.reg_credit_no)").append(" ");
        sql.append("where t1.valid_flag = 'Y'").append(" ");
        if(!StringUtils.isEmpty(regCreditNo)){
            sql.append("AND t1.reg_credit_no = '").append(regCreditNo).append("'");
        }

        return sql.toString();
    }

    //企业档案-收藏信息
    public String getEnterpriseFavorite(PageReqDTO reqDTO){
        StringBuffer sql = new StringBuffer();
        if(!StringUtils.isEmpty(reqDTO.getRegCreditNo())){
            sql.append("select t1.reg_credit_no,t1.credit_no,t1.reg_no,t1.fav_user_list").append(" ");
            sql.append("from crm_ent_favorite t1").append(" ");
            sql.append("where t1.reg_credit_no = '").append(reqDTO.getRegCreditNo()).append("'");
            sql.append("  and t1.fav_user_list = '").append(reqDTO.getUserName()).append("'").append(" ");
            sql.append("  and t1.valid_flag = 'Y'").append(" ");
            sql.append(" limit 1");
        }

        return sql.toString();
    }

    //企业档案-主要人员
    public String getEnterpriseEmployeeList(String regCreditNo){
        StringBuffer sql = new StringBuffer();
        sql.append("select t2.job_title, t2.name").append(" ");
        sql.append("from cdm_ent_dto_corp_info_ext t1").append(" ");
        sql.append("join cdm_ent_dto_emp t2").append(" ");
        sql.append("on (t1.reg_credit_no = t2.reg_credit_no)").append(" ");
        sql.append("where t1.valid_flag = 'Y'").append(" ");
        if(!StringUtils.isEmpty(regCreditNo)){
            sql.append("AND t1.reg_credit_no = '").append(regCreditNo).append("'");
        }

        return sql.toString();
    }

    //企业档案-服务订单
    public String getEnterpriseOrderList(String regCreditNo){
        StringBuffer sql = new StringBuffer();
        sql.append("select t1.order_no, t1.order_date,t1.order_memeber_name,t2.product_name as order_prod_name,t1.order_amt,t1.order_status,t1.is_self_biz,t1.partner_name,t1.progress").append(" ");
        sql.append("from crm_order t1").append(" ");
        sql.append("left outer join crm_product t2").append(" ");
        sql.append("on (t1.order_prod_id = t2.product_id)").append(" ");
        sql.append("where t1.reg_credit_no = '").append(regCreditNo).append("'");

        return sql.toString();
    }

    //企业档案-触达信息（显示最近的4条）
    public String getEnterpriseReachcsrList(String regCreditNo){
        StringBuffer sql = new StringBuffer();
        sql.append("select t1.rch_no, t1.rch_mode,t1.rch_emp,t1.begin_time,t1.end_time,t1.contacts,t1.contacts_phone,t1.win_cust_chnl,t1.sales_lead,t1.remark").append(" ");
        sql.append("from crm_reachcsr t1").append(" ");
        if(!StringUtils.isEmpty(regCreditNo)){
            sql.append("where t1.reg_credit_no = '").append(regCreditNo).append("'");
        }
        sql.append("order by begin_time desc limit 4");

        return sql.toString();
    }

    //企业档案-历史融资
    public String getEnterpriseFinancingList(String regCreditNo){
        StringBuffer sql = new StringBuffer();
        sql.append("select t2.financing_date, t2.financing_amount,t2.financing_currency,t2.financing_stage,t2.investors").append(" ");
        sql.append("from cdm_ent_dto_corp_info_ext t1").append(" ");
        sql.append("join cdm_ent_dto_financing t2").append(" ");
        sql.append("on (t1.reg_credit_no = t2.reg_credit_no)").append(" ");
        sql.append("where t1.valid_flag = 'Y'").append(" ");
        if(!StringUtils.isEmpty(regCreditNo)){
            sql.append("AND t1.reg_credit_no = '").append(regCreditNo).append("'");
        }

        return sql.toString();
    }

    //企业档案-主要人员
    public String getEnterprisePartnerList(String regCreditNo){
        StringBuffer sql = new StringBuffer();
        sql.append("select t2.partner_name, t2.partner_type,t2.should_capi,t2.should_capi_date").append(" ");
        sql.append("from cdm_ent_dto_corp_info_ext t1").append(" ");
        sql.append("join cdm_ent_dto_partner t2").append(" ");
        sql.append("on (t1.reg_credit_no = t2.reg_credit_no)").append(" ");
        sql.append("where t1.valid_flag = 'Y'").append(" ");
        if(!StringUtils.isEmpty(regCreditNo)){
            sql.append("AND t1.reg_credit_no = '").append(regCreditNo).append("'");
        }

        return sql.toString();
    }
    //企业档案-公司人员构成
    public String getEnterpriseEmpStrucList(String regCreditNo){
        StringBuffer sql = new StringBuffer();
        sql.append("select t2.credit_no,t2.reg_no,t2.reg_credit_no,t2.staff_number, t2.college_rate,t2.undergraduate_rate, t2.master_rate,t2.rd_number").append(" ");
        sql.append("from cdm_ent_dto_corp_info_ext t1").append(" ");
        sql.append("join cdm_ent_dto_emp_struc t2").append(" ");
        sql.append("on (t1.reg_credit_no = t2.reg_credit_no)").append(" ");
        sql.append("where t1.valid_flag = 'Y'").append(" ");
        if(!StringUtils.isEmpty(regCreditNo)){
            sql.append("AND t1.reg_credit_no = '").append(regCreditNo).append("'");
        }

        return sql.toString();
    }

    //企业档案-核心团队
    public String getEnterpriseCoreTeamList(String regCreditNo){
        StringBuffer sql = new StringBuffer();
        sql.append("select t2.rec_id,t2.name, t2.sex,t2.job_title, t2.education,t2.resume").append(" ");
        sql.append("from cdm_ent_dto_corp_info_ext t1").append(" ");
        sql.append("join cdm_ent_dto_core_team t2").append(" ");
        sql.append("on (t1.reg_credit_no = t2.reg_credit_no)").append(" ");
        sql.append("where t1.valid_flag = 'Y'").append(" ");
        if(!StringUtils.isEmpty(regCreditNo)){
            sql.append("AND t1.reg_credit_no = '").append(regCreditNo).append("'");
        }

        return sql.toString();
    }

    //企业档案-公司联系人
    public String getEnterpriseContactsList(String regCreditNo){
        StringBuffer sql = new StringBuffer();
        sql.append("select t2.rec_id,t2.name, t2.job_title, t2.contact_mobi_phone,t2.contact_fixed_phone,t2.email").append(" ");
        sql.append("from cdm_ent_dto_corp_info_ext t1").append(" ");
        sql.append("join cdm_ent_dto_contacts t2").append(" ");
        sql.append("on (t1.reg_credit_no = t2.reg_credit_no)").append(" ");
        sql.append("where t1.valid_flag = 'Y'").append(" ");
        if(!StringUtils.isEmpty(regCreditNo)){
            sql.append("AND t1.reg_credit_no = '").append(regCreditNo).append("'");
        }

        return sql.toString();
    }

    //企业档案-荣誉
    public String getEnterpriseHonorList(String regCreditNo){
        StringBuffer sql = new StringBuffer();
        sql.append("select t2.rec_id,t2.qualification, t2.honor").append(" ");
        sql.append("from cdm_ent_dto_corp_info_ext t1").append(" ");
        sql.append("join cdm_ent_dto_honor t2").append(" ");
        sql.append("on (t1.reg_credit_no = t2.reg_credit_no)").append(" ");
        sql.append("where t1.valid_flag = 'Y'").append(" ");
        if(!StringUtils.isEmpty(regCreditNo)){
            sql.append("AND t1.reg_credit_no = '").append(regCreditNo).append("'");
        }

        return sql.toString();
    }

    //企业档案-市场发展情况
    public String getEnterpriseMarketDevList(String regCreditNo){
        StringBuffer sql = new StringBuffer();
        sql.append("select t2.dev_stage, t2.market_rate,t2.business_pattern,t2.core_competence,t2.five_customer,t2.five_supplier," +
                "t2.major_competitors,t2.prod_biz_submit,t2.cur_req_info,t2.info_suggestions").append(" ");
        sql.append("from cdm_ent_dto_corp_info_ext t1").append(" ");
        sql.append("join cdm_ent_dto_market_dev t2").append(" ");
        sql.append("on (t1.reg_credit_no = t2.reg_credit_no)").append(" ");
        sql.append("where t1.valid_flag = 'Y'").append(" ");
        if(!StringUtils.isEmpty(regCreditNo)){
            sql.append("AND t1.reg_credit_no = '").append(regCreditNo).append("'");
        }

        return sql.toString();
    }

    //企业档案-上市情况
    public String getEnterpriseIpoList(String regCreditNo){
        StringBuffer sql = new StringBuffer();
        sql.append("select t2.ipo_stage, t2.ipo_date,t2.ipo_sector").append(" ");
        sql.append("from cdm_ent_dto_corp_info_ext t1").append(" ");
        sql.append("join cdm_ent_dto_ipo t2").append(" ");
        sql.append("on (t1.reg_credit_no = t2.reg_credit_no)").append(" ");
        sql.append("where t1.valid_flag = 'Y'").append(" ");
        if(!StringUtils.isEmpty(regCreditNo)){
            sql.append("AND t1.reg_credit_no = '").append(regCreditNo).append("'");
        }

        return sql.toString();
    }

    //企业档案-归属载体
    public String getEnterpriseCarrierList(String regCreditNo){
        StringBuffer sql = new StringBuffer();
        sql.append("select t2.carrier_type, t2.carrier_name").append(" ");
        sql.append("from cdm_ent_dto_corp_info_ext t1").append(" ");
        sql.append("join cdm_ent_dto_carrier t2").append(" ");
        sql.append("on (t1.reg_credit_no = t2.reg_credit_no)").append(" ");
        sql.append("where t1.valid_flag = 'Y'").append(" ");
        if(!StringUtils.isEmpty(regCreditNo)){
            sql.append("AND t1.reg_credit_no = '").append(regCreditNo).append("'");
        }

        return sql.toString();
    }

    //企业档案-财务数据
    public String getEnterpriseFindataList(String regCreditNo){
        StringBuffer sql = new StringBuffer();
        sql.append("select t2.rec_id,t2.fin_year, t2.R2007,t2.R2009,t2.F1006,t2.R2016,t2.fin_source_type,t2.fin_source_desc").append(" ");
        sql.append("from cdm_ent_dto_corp_info_ext t1").append(" ");
        sql.append("join cdm_ent_dto_finance_recent t2").append(" ");
        sql.append("on (t1.reg_credit_no = t2.reg_credit_no)").append(" ");
        sql.append("where t1.valid_flag = 'Y'").append(" ");
        if(!StringUtils.isEmpty(regCreditNo)){
            sql.append("AND t1.reg_credit_no = '").append(regCreditNo).append("'");
        }
        sql.append("order by t2.fin_year desc").append(" ");

        return sql.toString();
    }

    //企业档案-项目数据
    public String getEnterpriseProjList(String regCreditNo){
        StringBuffer sql = new StringBuffer();
        sql.append("select t2.project_name,t2.project_desc, t2.industry,t2.comment_person,t2.comment_remark,t2.bp_year").append(" ");
        sql.append("from cdm_ent_dto_corp_info_ext t1").append(" ");
        sql.append("join cdm_ent_dto_project t2").append(" ");
        sql.append("on (t1.reg_credit_no = t2.reg_credit_no)").append(" ");
        sql.append("where t1.valid_flag = 'Y'").append(" ");
        if(!StringUtils.isEmpty(regCreditNo)){
            sql.append("AND t1.reg_credit_no = '").append(regCreditNo).append("'");
        }
        sql.append("order by t2.create_date desc").append(" ");

        return sql.toString();
    }

    //添加收藏企业
    public String enterpriseAddFav(EnterpriseShowDTO enterpriseShowDTO) {
        BEGIN();
        INSERT_INTO("crm_ent_favorite");

        if (enterpriseShowDTO.getFavId() != null) {
            VALUES("fav_id", "#{favId,jdbcType=VARCHAR}");
        }
        if (enterpriseShowDTO.getRegNo() != null) {
            VALUES("reg_no", "#{regNo,jdbcType=VARCHAR}");
        }
        if (enterpriseShowDTO.getCreditNo() != null) {
            VALUES("credit_no", "#{creditNo,jdbcType=VARCHAR}");
        }
        if (enterpriseShowDTO.getRegCreditNo() != null) {
            VALUES("reg_credit_no", "#{regCreditNo,jdbcType=VARCHAR}");
        }
        if (enterpriseShowDTO.getEnterpriseName() != null) {
            VALUES("enterprise_name", "#{enterpriseName,jdbcType=VARCHAR}");
        }
        if (enterpriseShowDTO.getIndustryName() != null) {
            VALUES("industry_name", "#{industryName,jdbcType=VARCHAR}");
        }
        if (enterpriseShowDTO.getMainIndustry() != null) {
            VALUES("main_industry", "#{mainIndustry,jdbcType=VARCHAR}");
        }
        if (enterpriseShowDTO.getFavUserId() != null) {
            VALUES("fav_user_id", "#{favUserId,jdbcType=INTEGER}");
        }
        if (enterpriseShowDTO.getFavUserList() != null) {
            VALUES("fav_user_list", "#{favUserList,jdbcType=VARCHAR}");
        }
        if (enterpriseShowDTO.getEntType() != null) {
            VALUES("ent_type", "#{entType,jdbcType=VARCHAR}");
        }
        if (1==1) {
            VALUES("mat_comp_score", "#{matCompScore,jdbcType=INTEGER}");
        }
        if (enterpriseShowDTO.getIsHaveFinance() != null) {
            VALUES("is_have_finance", "#{isHaveFinance,jdbcType=VARCHAR}");
        }
        if (1==1) {
            VALUES("valid_flag", "'Y'");
        }
        if (enterpriseShowDTO.getUpdateTime() != null) {
            VALUES("update_time", "#{updateTime,jdbcType=VARCHAR}");
        }
        if (enterpriseShowDTO.getInsertTime() != null) {
            VALUES("insert_time", "#{insertTime,jdbcType=VARCHAR}");
        }

        return SQL();
    }

    //取消收藏企业
    public String enterpriseCelFav(PageReqDTO reqDTO) {
        StringBuffer sql = new StringBuffer();
        if(!StringUtils.isEmpty(reqDTO.getRegCreditNo())){
            sql.append("delete from crm_ent_favorite").append(" ");
            sql.append("where reg_credit_no = '").append(reqDTO.getRegCreditNo()).append("'");
            sql.append(" and fav_user_list = '").append(reqDTO.getUserName()).append("'");
        }

        return sql.toString();
    }
}
