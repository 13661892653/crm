package com.xlh.crm.mapper;

import com.xlh.crm.dto.PageReqDTO;
import org.codehaus.plexus.util.StringUtils;

public class PartnerSqlProvider {

    public String getPartnerList(String province,String company,String partnerType){
        StringBuffer sql = new StringBuffer();
        sql.append("select t1.company," +
                "t1.partner_id,t1.partner_name,t1.srv_area," +
                "t1.category,t1.contact_person,t1.contact_phone").append(" ");
        sql.append("from crm_partner t1").append(" ");
        sql.append("where valid_flag = 'Y'").append(" ");
        if(!StringUtils.isEmpty(province)&&!StringUtils.isEmpty(company)){
            sql.append("AND (t1.srv_area like '%全国%' ");
            sql.append("or t1.srv_area like '%").append(province).append("%'");
            sql.append("or t1.srv_area like '%").append(company).append("%')").append(" ");
        }
        if(!StringUtils.isEmpty(partnerType)){
            sql.append("AND t1.partner_type ='").append(partnerType).append("'").append(" ");
        }

        return sql.toString();
    }

    public String getPartnerBankList(PageReqDTO req){
        StringBuffer sql = new StringBuffer();
        sql.append("select t1.rec_id,t1.company,t1.partner_lv_id,t1.partner_lv_desc,t1.partner_type,t1.credit_no,t1.reg_no," +
                "t1.partner_id,t1.partner_name,t1.ent_address,t1.office_address,t1.srv_area,t1.biz_scope,t1.fee_point," +
                "t1.valid_flag,t1.remark,t1.join_time,t1.rescind_time,t1.contract_no,t1.category,t1.contact_person,t1.contact_phone,t1.email,t1.bank_account").append(" ");
        sql.append("from crm_partner t1").append(" ");
        sql.append("where valid_flag = 'Y'").append(" ");
        if(!StringUtils.isEmpty(req.getCorpName())){
            sql.append("AND t1.partner_name like '%").append(req.getCorpName()).append("%'").append(" ");
        }
        if(!StringUtils.isEmpty(req.getCompany())){
            sql.append("AND (t1.srv_area like '%全国%' ");
            sql.append("or t1.srv_area like '%").append(req.getProvince()).append("%'");
            sql.append("or t1.srv_area like '%").append(req.getCompany()).append("%')").append(" ");
        }
        sql.append("order by t1.company desc").append(" ");
        sql.append(getLimitSql(req.getPageIndex(), req.getPageSize()));

        return sql.toString();
    }

    //计算总数，用于分页
    public String getPartnerBankListCount(PageReqDTO req){
        StringBuffer sql = new StringBuffer();
        sql.append("select count(t1.partner_id)").append(" ");
        sql.append("from crm_partner t1").append(" ");
        sql.append("where valid_flag = 'Y'").append(" ");
        if(!StringUtils.isEmpty(req.getCorpName())){
            sql.append("AND t1.partner_name like '%").append(req.getCorpName()).append("%'").append(" ");
        }
        if(!StringUtils.isEmpty(req.getCompany())){
            sql.append("AND (t1.srv_area like '%全国%' ");
            sql.append("or t1.srv_area like '%").append(req.getProvince()).append("%'");
            sql.append("or t1.srv_area like '%").append(req.getCompany()).append("%')").append(" ");
        }

        return sql.toString();
    }

    private  String getLimitSql(Integer index, Integer pageSize){
        return "LIMIT " + (index - 1) * pageSize + "," + pageSize;
    }
}