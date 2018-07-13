package com.xlh.crm.mapper;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import com.xlh.crm.common.CurrentTime;
import com.xlh.crm.dto.PageReqDTO;
import org.codehaus.plexus.util.StringUtils;

public class EnterpriseSqlProvider {

    //根据企业工商注册号或者社会统一信用代码查询企业信息
    public String selectByRegCreditNo(PageReqDTO req){
        StringBuffer sql = new StringBuffer();
        sql.append("select t1.reg_credit_no,t1.reg_no, t1.credit_no, t2.enterprise_name, t1.mat_comp_score, t1.is_have_finance,t2.industry_name,t1.cust_manager,t1.fav_user_list").append(" ");
        sql.append("from cdm_ent_dto_corp_info_ext t1").append(" ");
        sql.append("join cdm_ent_dto_corp_info t2").append(" ");
        sql.append("on t1.reg_credit_no = t2.reg_credit_no").append(" ");
        sql.append("where t1.reg_credit_no = '").append(req.getRegCreditNo()).append("' ");

        return sql.toString();
    }

    //获取用户收藏的企业
    public String getEnterpriseFavList(PageReqDTO reqdto){
        StringBuffer sql = new StringBuffer();
        sql.append("select t3.company,t1.fav_id,t1.reg_credit_no,t1.reg_no, t1.credit_no, t1.enterprise_name, t1.mat_comp_score, t1.is_have_finance,t1.industry_name,t2.cust_manager,t1.ent_type,t1.fav_user_list").append(" ");
        sql.append("from crm_ent_favorite t1").append(" ");
        sql.append("join cdm_ent_dto_corp_info_ext t2").append(" ");
        sql.append("on t1.reg_credit_no = t2.reg_credit_no").append(" ");
        sql.append("join dim_mbr_xlh_user_info t3 on t1.fav_user_id = t3.member_id ");
        sql.append("where t1.valid_flag = 'Y'").append(" ");
        if(!StringUtils.isEmpty(reqdto.getMemberType())&&reqdto.getMemberType().equals("90")&&!StringUtils.isEmpty(reqdto.getUserName())) {   //权限控制：分公司经理可以看到自己收藏的企业
            sql.append(" and t1.fav_user_list ='").append(reqdto.getUserName()).append("'");
        }
        if(!StringUtils.isEmpty(reqdto.getMemberType())&&(Integer.parseInt(reqdto.getMemberType()) > 90)&&!StringUtils.isEmpty(reqdto.getUserName())) {   //权限控制：一般人员可以看到自己收藏或者自己是客户经理的企业
            sql.append(" and (t1.fav_user_list ='").append(reqdto.getUserName()).append("'").append(" ");
            sql.append("     or t2.cust_manager ='").append(reqdto.getUserName()).append("')").append(" ");
        }
        sql.append("order by t1.fav_user_list desc,t1.enterprise_name desc").append(" ");
        sql.append(getLimitSql(reqdto.getPageIndex(), reqdto.getPageSize()));

        return sql.toString();
    }

    //企业收藏筛选后企业总数，用于分页
    public String getFavListCount(PageReqDTO reqdto){
        StringBuffer sql = new StringBuffer();
        sql.append("select count(t1.fav_id)").append(" ");
        sql.append("from crm_ent_favorite t1").append(" ");
        sql.append("where t1.valid_flag = 'Y'").append(" ");
        if(!StringUtils.isEmpty(reqdto.getMemberType())&&reqdto.getMemberType().equals("90")&&!StringUtils.isEmpty(reqdto.getUserName())) {   //权限控制：分公司经理可以看到自己收藏的企业
            sql.append(" and t1.fav_user_list ='").append(reqdto.getUserName()).append("'");
        }
        if(!StringUtils.isEmpty(reqdto.getMemberType())&&(Integer.parseInt(reqdto.getMemberType()) > 90)&&!StringUtils.isEmpty(reqdto.getUserName())) {   //权限控制：一般人员可以看到自己收藏或者自己是客户经理的企业
            sql.append(" and (t1.fav_user_list ='").append(reqdto.getUserName()).append("'");
            sql.append("     or t1.cust_manager ='").append(reqdto.getUserName()).append("')");
        }

        return sql.toString();
    }

    //获取编辑档案的企业
    public String getEnterpriseUptList(PageReqDTO reqdto){
        StringBuffer sql = new StringBuffer();
        sql.append("select a.id,a.update_time,a.company,a.archives_editor,a.edit_module,a.reg_no,a.credit_no,a.reg_credit_no,a.enterprise_name").append(" ");
        sql.append("from (").append(" ");
        sql.append("select t1.id,t1.operation_time as update_time,t2.company,t1.operator as archives_editor,t1.module as edit_module, t3.reg_no,t3.credit_no, t3.reg_credit_no,t3.enterprise_name").append(" ");
        sql.append("from crm_operation_log t1").append(" ");
        sql.append("join dim_mbr_xlh_user_info t2").append(" ");
        sql.append("on t1.operator = t2.user_name").append(" ");
        sql.append("join cdm_ent_dto_corp_info t3").append(" ");
        sql.append("on replace(t1.operation_desc,'reg_credit_no:','') = t3.reg_credit_no").append(" ");
        sql.append("where t1.module like '%企业档案%' ").append(" ");
        if(!StringUtils.isEmpty(reqdto.getMemberType())&&reqdto.getMemberType().equals("90")&&!StringUtils.isEmpty(reqdto.getCompany())) {   //权限控制：分公司经理可以看到分公司的
            sql.append(" and t2.company ='").append(reqdto.getCompany()).append("'");
        }
        if(!StringUtils.isEmpty(reqdto.getMemberType())&&(Integer.parseInt(reqdto.getMemberType()) > 90)&&!StringUtils.isEmpty(reqdto.getUserName())) {   //权限控制：一般人员可以看到自己的
            sql.append(" and t1.operator ='").append(reqdto.getUserName()).append("'").append(" ");
        }
//        sql.append("group by t2.company,t1.operator,t1.module,t3.reg_no,t3.credit_no,t3.reg_credit_no,t3.enterprise_name").append(" ");
        sql.append(") a").append(" ");
        sql.append("order by a.update_time desc").append(" ");
        sql.append(getLimitSql(reqdto.getPageIndex(), reqdto.getPageSize()));

        return sql.toString();
    }

    //档案编辑企业总数，用于分页
    public String getUptListCount(PageReqDTO reqdto){
        StringBuffer sql = new StringBuffer();
        sql.append("select count(a.update_time)").append(" ");
        sql.append("from (").append(" ");
        sql.append("select t1.operation_time as update_time,t2.company,t1.operator as archives_editor,t1.module as edit_module, t3.reg_no,t3.credit_no, t3.reg_credit_no,t3.enterprise_name").append(" ");
        sql.append("from crm_operation_log t1").append(" ");
        sql.append("join dim_mbr_xlh_user_info t2").append(" ");
        sql.append("on t1.operator = t2.user_name").append(" ");
        sql.append("join cdm_ent_dto_corp_info t3").append(" ");
        sql.append("on replace(t1.operation_desc,'reg_credit_no:','') = t3.reg_credit_no").append(" ");
        sql.append("where t1.module like '%企业档案%' ").append(" ");
        if(!StringUtils.isEmpty(reqdto.getMemberType())&&reqdto.getMemberType().equals("90")&&!StringUtils.isEmpty(reqdto.getCompany())) {   //权限控制：分公司经理可以看到分公司的
            sql.append(" and t2.company ='").append(reqdto.getCompany()).append("'");
        }
        if(!StringUtils.isEmpty(reqdto.getMemberType())&&(Integer.parseInt(reqdto.getMemberType()) > 90)&&!StringUtils.isEmpty(reqdto.getUserName())) {   //权限控制：一般人员可以看到自己的
            sql.append(" and t1.operator ='").append(reqdto.getUserName()).append("'").append(" ");
        }
//        sql.append("group by t2.company,t1.operator,t1.module,t3.reg_no,t3.credit_no,t3.reg_credit_no,t3.enterprise_name").append(" ");
        sql.append(") a").append(" ");

        return sql.toString();
    }

    //企业库列表
    public String getEnterpriseBankList(PageReqDTO reqdto){
        StringBuffer sql = new StringBuffer();
        sql.append("select t1.mat_comp_score,t1.reg_credit_no,t1.reg_no, t1.credit_no, t1.is_have_finance,t1.tag_array" +
                   ",t2.enterprise_name,t2.gq_score,t2.industry_code,t2.industry_name,t2.mgmt_status, t2.corp_info,t2.ent_address").append(" ");
        sql.append("from cdm_ent_dto_corp_info_ext t1").append(" ");
        sql.append("join (select gq_score,reg_credit_no,enterprise_name,industry_code,industry_name,mgmt_status,corp_info,ent_address").append(" ");
        sql.append("from cdm_ent_dto_corp_info ").append(" ");
        sql.append("where 1 = 1 ").append(" ");
        if(!reqdto.getRegionCode().equals("all")){
            String regionCode = reqdto.getRegionCode();
            if(!StringUtils.isEmpty(regionCode)){
                sql.append("AND belong_city = '").append(regionCode).append("'").append(" ");
            }
        }
        if(!reqdto.getIndustryName().equals("all")){
            String industryName = reqdto.getIndustryName();
            if(!StringUtils.isEmpty(industryName)){
                sql.append("AND industry_name ='").append(industryName).append("'").append(" ");
            }
        }
        if(!StringUtils.isEmpty(reqdto.getCorpName())){
            sql.append("AND enterprise_name like '%").append(reqdto.getCorpName()).append("%'").append(" ");
        }
        if(!reqdto.getBeginScore().equals("all")){
            String beginScore = reqdto.getBeginScore();
            if(!StringUtils.isEmpty(beginScore)){
                sql.append("AND gq_score>=").append(beginScore).append(" ");
            }
        }
        if(!reqdto.getEndScore().equals("all")){
            String endScore = reqdto.getEndScore();
            if(!StringUtils.isEmpty(endScore)){
                sql.append("AND gq_score<=").append(endScore).append(" ");
            }
        }
        sql.append(") t2").append(" ");
        sql.append("on (t1.reg_credit_no = t2.reg_credit_no)").append(" ");
        sql.append("where t1.valid_flag = 'Y'").append(" ");
        if(!reqdto.getAssetsFlag().equals("all")){
            String assetsFlag = reqdto.getAssetsFlag();
            if(!StringUtils.isEmpty(assetsFlag)){
                sql.append("AND t1.assets_category_code ='").append(assetsFlag).append("'").append(" ");
            }
        }

        if(!reqdto.getIsHaveFinance().equals("all")){
            String isHaveFinance = reqdto.getIsHaveFinance();
            if(!StringUtils.isEmpty(isHaveFinance)){
                sql.append("AND coalesce(t1.is_have_finance,'N') ='").append(isHaveFinance).append("'").append(" ");
            }
        }
        if(!reqdto.getIsSetEntSrv().equals("all")){
            String isSetEntSrv = reqdto.getIsSetEntSrv();
            if(!StringUtils.isEmpty(isSetEntSrv)&&isSetEntSrv.equals("Y")){
                sql.append("AND length(coalesce(t1.cust_manager,'')) > 0").append(" ");
            }
            else{
                sql.append("AND length(coalesce(t1.cust_manager,'')) = 0").append(" ");
            }
        }
        if(!reqdto.getAssetsLevel().equals("all")){
            String assetsLevel = reqdto.getAssetsLevel();
            if(!StringUtils.isEmpty(assetsLevel)){
                sql.append("AND coalesce(t1.assets_level,'99999') ='").append(assetsLevel).append("'").append(" ");
            }
        }
        if(!reqdto.getAssetsTagCode().equals("all")){
            String assetsTagCode = reqdto.getAssetsTagCode();
            if(!StringUtils.isEmpty(assetsTagCode)){
                sql.append("AND t1.tag_array like '%").append(assetsTagCode).append("%'").append(" ");
                //sql.append("AND MATCH (t1.tag_array)AGAINST (").append(assetsTagCode).append(")").append(" ");
            }
        }
        if(!reqdto.getEntType().equals("all")){
            String entType = reqdto.getEntType();
            if(!StringUtils.isEmpty(entType)&&entType.equals("basic")){   //基础企业为未触达、未下单企业
                sql.append("AND t1.tag_array not like '%4002%'").append(" ");
                sql.append("AND t1.tag_array not like '%4003%'").append(" ");
            }
            if(!StringUtils.isEmpty(entType)&&entType.equals("4002")){   //4002目标企业为已触达企业
                sql.append("AND t1.tag_array like '%4002%'").append(" ");
                sql.append("AND t1.tag_array not like '%4003%'").append(" ");
                //sql.append("AND MATCH (t1.tag_array)AGAINST ('4002')").append(" ");
            }
            if(!StringUtils.isEmpty(entType)&&entType.equals("4003")){   //4003核心企业为已下单企业
                sql.append("AND t1.tag_array like '%4003%'").append(" ");
                //sql.append("AND MATCH (t1.tag_array)AGAINST ('4003')").append(" ");
            }
        }
        //sql.append("order by t1.mat_comp_score desc").append(" ");
        //sql.append("order by t1.mat_comp_score desc,if(t2.mgmt_status like '%在营%',1,t2.mgmt_status) asc,t2.create_date asc,t2.register_money desc").append(" ");
        sql.append(getLimitSql(reqdto.getPageIndex(), reqdto.getPageSize()));

        return sql.toString();
    }

    //企业库筛选后企业总数，用于分页
    public String getEnterpriseBankListCount(PageReqDTO reqdto){
        StringBuffer sql = new StringBuffer();
        sql.append("select count(t1.reg_credit_no) ").append(" ");
        sql.append("from cdm_ent_dto_corp_info_ext t1").append(" ");
        sql.append("join (select reg_credit_no,enterprise_name,industry_code,industry_name,mgmt_status,corp_info,ent_address").append(" ");
        sql.append("from cdm_ent_dto_corp_info ").append(" ");
        sql.append("where 1 = 1 ").append(" ");
        if(!reqdto.getRegionCode().equals("all")){
            String regionCode = reqdto.getRegionCode();
            if(!StringUtils.isEmpty(regionCode)){
                sql.append("AND belong_city = '").append(regionCode).append("'").append(" ");
            }
        }
        if(!reqdto.getIndustryName().equals("all")){
            String industryName = reqdto.getIndustryName();
            if(!StringUtils.isEmpty(industryName)){
                sql.append("AND industry_name ='").append(industryName).append("'").append(" ");
            }
        }
        if(!StringUtils.isEmpty(reqdto.getCorpName())){
            sql.append("AND enterprise_name like '%").append(reqdto.getCorpName()).append("%'").append(" ");
        }
        if(!reqdto.getBeginScore().equals("all")){
            String beginScore = reqdto.getBeginScore();
            if(!StringUtils.isEmpty(beginScore)){
                sql.append("AND gq_score>=").append(beginScore).append(" ");
            }
        }
        if(!reqdto.getEndScore().equals("all")){
            String endScore = reqdto.getEndScore();
            if(!StringUtils.isEmpty(endScore)){
                sql.append("AND gq_score<=").append(endScore).append(" ");
            }
        }
        sql.append(") t2").append(" ");
        sql.append("on (t1.reg_credit_no = t2.reg_credit_no)").append(" ");
        sql.append("where t1.valid_flag = 'Y'").append(" ");
        if(!reqdto.getAssetsFlag().equals("all")){
            String assetsFlag = reqdto.getAssetsFlag();
            if(!StringUtils.isEmpty(assetsFlag)){
                sql.append("AND t1.assets_category_code ='").append(assetsFlag).append("'").append(" ");
            }
        }
        if(!reqdto.getIsHaveFinance().equals("all")){
            String isHaveFinance = reqdto.getIsHaveFinance();
            if(!StringUtils.isEmpty(isHaveFinance)){
                sql.append("AND coalesce(t1.is_have_finance,'N') ='").append(isHaveFinance).append("'").append(" ");
            }
        }
        if(!reqdto.getIsSetEntSrv().equals("all")){
            String isSetEntSrv = reqdto.getIsSetEntSrv();
            if(!StringUtils.isEmpty(isSetEntSrv)&&isSetEntSrv.equals("Y")){
                sql.append("AND length(coalesce(t1.cust_manager,'')) > 0").append(" ");
            }
            else{
                sql.append("AND length(coalesce(t1.cust_manager,'')) = 0").append(" ");
            }
        }
        if(!reqdto.getAssetsLevel().equals("all")){
            String assetsLevel = reqdto.getAssetsLevel();
            if(!StringUtils.isEmpty(assetsLevel)){
                sql.append("AND coalesce(t1.assets_level,'99999') ='").append(assetsLevel).append("'").append(" ");
            }
        }
        if(!reqdto.getAssetsTagCode().equals("all")){
            String assetsTagCode = reqdto.getAssetsTagCode();
            if(!StringUtils.isEmpty(assetsTagCode)){
                sql.append("AND t1.tag_array like '%").append(assetsTagCode).append("%'").append(" ");
                //sql.append("AND MATCH (t1.tag_array)AGAINST (").append(assetsTagCode).append(")").append(" ");
            }
        }
        if(!reqdto.getEntType().equals("all")){
            String entType = reqdto.getEntType();
            if(!StringUtils.isEmpty(entType)&&entType.equals("basic")){   //基础企业为未触达、未下单企业
                sql.append("AND t1.tag_array not like '%4002%'").append(" ");
                sql.append("AND t1.tag_array not like '%4003%'").append(" ");
            }
            if(!StringUtils.isEmpty(entType)&&entType.equals("4002")){   //4002目标企业为已触达企业
                sql.append("AND t1.tag_array like '%4002%'").append(" ");
                sql.append("AND t1.tag_array not like '%4003%'").append(" ");
                //sql.append("AND MATCH (t1.tag_array)AGAINST ('4002')").append(" ");
            }
            if(!StringUtils.isEmpty(entType)&&entType.equals("4003")){   //4003核心企业为已下单企业
                sql.append("AND t1.tag_array like '%4003%'").append(" ");
                //sql.append("AND MATCH (t1.tag_array)AGAINST ('4003')").append(" ");
            }
        }

        return sql.toString();
    }

    public String getProjectBankList(PageReqDTO reqdto){
        StringBuffer sql = new StringBuffer();
        sql.append("select t1.reg_no, t1.credit_no, t1.enterprise_name, t2.mat_comp_rate, t2.area_province," +
                "t2.area_city,t2.industry_type_code, t2.industry_type_name, t2.industry_code, " +
                "t2.industry_name, t2.create_date,t2.register_money, t2.mgmt_status, t2.corp_info, " +
                "t2.contact_fixed_phone, t2.contact_mobi_phone,t2.legal_representative, t2.ent_address," +
                "t2.contact_person, t1.assets_category_code,t1. assets_category,t1.assets_level, " +
                "t1.assets_source_code, t1.assets_source_desc, t1.hot_index, t1.tag_array, t1.valid_flag, t1.event_id ").append(" ");
        sql.append("from cdm_ent_dto_corp_info_ext t1").append(" ");
        sql.append("join cdm_ent_dto_corp_info t2").append(" ");
        sql.append("on (t1.reg_credit_no = t2.reg_credit_no)").append(" ");
        sql.append("where t1.valid_flag = 'Y'").append(" ");
        sql.append("AND t2.assets_category_code ='c05'").append(" ");   //限定融资及并购项目数据
        if(!reqdto.getRegionCode().equals("all")){
            String regionCode = reqdto.getRegionCode();
            if(!StringUtils.isEmpty(regionCode)){
                sql.append("AND (belong_city = '").append(regionCode).append("'").append(" ");
            }
        }
        sql.append("order by t1.update_time desc").append(" ");

        return sql.toString();
    }

    public String getInvEventList(PageReqDTO reqdto){
        StringBuffer sql = new StringBuffer();
        sql.append("select tr_date, product_name, enterprise_name, rounds, tr_amt" +
                ", industry,investment, area, mark ").append(" ");
        sql.append("from cdm_inv_china_investment_event").append(" ");
        sql.append("where 1 = 1").append(" ");
        if(!reqdto.getInvTimeBegin().equals("all")&&!reqdto.getInvTimeEnd().equals("all")){
            String invTimeBegin = reqdto.getInvTimeBegin();
            String invTimeEnd = reqdto.getInvTimeEnd();
            if(!StringUtils.isEmpty(reqdto.getInvTimeBegin()) && !StringUtils.isEmpty(reqdto.getInvTimeEnd())){
                sql.append("and tr_date >= DATE('").append(invTimeBegin).append("')").append(" ");
                sql.append("and tr_date <= DATE('").append(invTimeEnd).append("')").append(" ");
            }
        }
        if(!reqdto.getRegionCode().equals("all")){
            String regionCode = reqdto.getRegionCode();
            if(!StringUtils.isEmpty(regionCode)){
                sql.append("AND area in ('").append(regionCode).append("')").append(" ");
            }
        }
        sql.append("order by tr_date desc").append(" ");
        sql.append(getLimitSql(reqdto.getPageIndex(), reqdto.getPageSize()));

        return sql.toString();
    }


    public String getInvEventListCount(PageReqDTO reqdto){
        StringBuffer sql = new StringBuffer();
        sql.append("select count(product_name) ").append(" ");
        sql.append("from cdm_inv_china_investment_event").append(" ");
        sql.append("where 1 = 1").append(" ");
        if(!reqdto.getInvTimeBegin().equals("all")&&!reqdto.getInvTimeEnd().equals("all")){
            String invTimeBegin = reqdto.getInvTimeBegin();
            String invTimeEnd = reqdto.getInvTimeEnd();
            if(!StringUtils.isEmpty(reqdto.getInvTimeBegin()) && !StringUtils.isEmpty(reqdto.getInvTimeEnd())){
                sql.append("and tr_date >= DATE('").append(invTimeBegin).append("')").append(" ");
                sql.append("and tr_date <= DATE('").append(invTimeEnd).append("')").append(" ");
            }
        }
        if(!reqdto.getRegionCode().equals("all")){
            String regionCode = reqdto.getRegionCode();
            if(!StringUtils.isEmpty(regionCode)){
                sql.append("AND area in ('").append(regionCode).append("')").append(" ");
            }
        }

        return sql.toString();
    }

    public String getCompanyUserList(String company){
        StringBuffer sql = new StringBuffer();
        sql.append("select t1.member_id,t1.member_phone,t1.user_name,t1.company").append(" ");
        sql.append("from dim_mbr_xlh_user_info t1").append(" ");
        sql.append("where t1.company in ('").append(company).append("')").append(" ");

        return sql.toString();
    }

    //产品列表
    public String getProductList(String company){
        StringBuffer sql = new StringBuffer();
        sql.append("select t1.rec_id,t1.biz_lv1_id,t1.biz_lv1_name,t1.biz_lv2_id,t1.biz_lv2_name,t1.biz_lv3_id,t1.biz_lv3_name,t1.product_id,t1.product_name,t1.price,t1.valid_flag,t1.remark").append(" ");
        sql.append("from crm_product t1").append(" ");
        sql.append("where valid_flag = 'Y'").append(" ");
        sql.append("AND (t1.product_area like '%全国%' ");
        sql.append("or t1.product_area like '%").append(company).append("%')").append(" ");
        sql.append("order by biz_lv1_id asc,product_id asc");

        return sql.toString();
    }

    private  String getLimitSql(Integer index, Integer pageSize){
        return "LIMIT " + (index - 1) * pageSize + "," + pageSize;
    }

}