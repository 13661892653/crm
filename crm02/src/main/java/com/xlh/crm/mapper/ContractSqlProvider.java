package com.xlh.crm.mapper;

import com.xlh.crm.dto.PageReqDTO;

public class ContractSqlProvider {

    //信息列表
    public String getContractList(PageReqDTO reqdto){
        StringBuffer sql = new StringBuffer();
        sql.append("select t1.rec_id," +
                "t1.contract_type," +
                "t1.contract_no," +
                "t1.contract_title," +
                "t1.contract_enterprise," +
                "t1.order_no," +
                "t1.biz_lv1_id," +
                "t1.biz_lv1_name," +
                "t1.order_prod_id," +
                "t2.product_name as order_prod_name," +
                "t1.contract_date," +
                "t1.contract_amt," +
                "t1.income," +
                "t1.income_unit," +
                "t1.profit," +
                "t1.profit_unit," +
                "t1.profit_rate," +
                "t1.income_exp_date," +
                "t1.partner_id," +
                "t3.partner_name," +
                "t1.remark," +
                "t1.link_address," +
                "t1.operator," +
                "t1.company," +
                "t1.update_time").append(" ");
        sql.append("from crm_contract t1").append(" ");
        sql.append("left outer join crm_product t2").append(" ");
        sql.append("on t1.order_prod_id = t2.product_id").append(" ");
        sql.append("left outer join crm_partner t3").append(" ");
        sql.append("on t1.partner_id = t3.partner_id").append(" ");
        sql.append("order by t1.contract_date desc").append(" ");
        sql.append(getLimitSql(reqdto.getPageIndex(), reqdto.getPageSize()));

        return sql.toString();
    }

    //信息总数，用于分页
    public String getContractListCount(PageReqDTO reqdto){
        StringBuffer sql = new StringBuffer();
        sql.append("select count(t1.contract_no) ").append(" ");
        sql.append("from crm_contract t1").append(" ");
        sql.append("left outer join crm_product t2").append(" ");
        sql.append("on t1.order_prod_id = t2.product_id").append(" ");
        sql.append("left outer join crm_partner t3").append(" ");
        sql.append("on t1.partner_id = t3.partner_id").append(" ");

        return sql.toString();
    }

    private  String getLimitSql(Integer index, Integer pageSize){
        return "LIMIT " + (index - 1) * pageSize + "," + pageSize;
    }

    //单个合同查询
    public String getContractByContractNo(String contractNo){
        StringBuffer sql = new StringBuffer();
        sql.append("select t1.contract_type," +
                "t1.contract_no," +
                "t1.contract_title," +
                "t1.contract_enterprise," +
                "t1.order_no," +
                "t1.biz_lv1_id," +
                "t1.biz_lv1_name," +
                "t1.order_prod_id," +
                "t2.product_name as order_prod_name," +
                "t1.contract_date," +
                "t1.contract_amt," +
                "t1.income," +
                "t1.income_unit," +
                "t1.profit," +
                "t1.profit_unit," +
                "t1.profit_rate," +
                "t1.income_exp_date," +
                "t1.partner_id," +
                "t3.partner_name," +
                "t1.remark," +
                "t1.link_address," +
                "t1.operator," +
                "t1.company," +
                "t1.update_time").append(" ");
        sql.append("from crm_contract t1").append(" ");
        sql.append("left outer join crm_product t2").append(" ");
        sql.append("on t1.order_prod_id = t2.product_id").append(" ");
        sql.append("left outer join crm_partner t3").append(" ");
        sql.append("on t1.partner_id = t3.partner_id").append(" ");
        sql.append("where t1.contract_no = '").append(contractNo).append("'");

        return sql.toString();
    }
}