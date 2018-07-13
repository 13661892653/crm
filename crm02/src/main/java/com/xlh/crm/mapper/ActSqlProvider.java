package com.xlh.crm.mapper;

import com.xlh.crm.dto.PageReqDTO;
import org.codehaus.plexus.util.StringUtils;

public class ActSqlProvider {

    //信息列表
    public String getActList(PageReqDTO reqdto){
        StringBuffer sql = new StringBuffer();
        sql.append("select t1.rec_id," +
                "t1.biz_lv1_id," +
                "t1.biz_lv1_name," +
                "t1.company," +
                "t1.act_no," +
                "t1.act_name," +
                "t1.begin_time," +
                "t1.end_time," +
                "t1.act_location," +
                "t1.us_role," +
                "case when t1.us_role = 'JB01' then '主办方'" +
                "     when t1.us_role = 'JB02' then '承办方'" +
                "     when t1.us_role = 'JB03' then '协办方'" +
                " end as us_role_desc," +
                "t1.act_type," +
                "case when t1.act_type = 'AT01' then '培训'" +
                "     when t1.act_type = 'AT02' then '约咖'" +
                "     when t1.act_type = 'AT03' then '会销'" +
                "     when t1.act_type = 'AT04' then '大赛'" +
                " end as act_type_desc," +
                "t1.co_partner," +
                "t1.act_fee," +
                "t1.join_persons," +
                "t1.operator," +
                "t1.remark," +
                "t1.link_address," +
                "t1.update_time").append(" ");
        sql.append("from crm_active t1").append(" ");
        sql.append("where 1=1").append(" ");
        if(!StringUtils.isEmpty(reqdto.getMemberType())&&(Integer.parseInt(reqdto.getMemberType()) > 90)&&!StringUtils.isEmpty(reqdto.getUserName())){ //权限控制：如果是分公司一般用户，只能看到自己的活动信息
            sql.append("and t1.operator ='").append(reqdto.getUserName()).append("'").append(" ");
        }
        if(!StringUtils.isEmpty(reqdto.getMemberType())&&reqdto.getMemberType().equals("90")&&!StringUtils.isEmpty(reqdto.getCompany())){ //权限控制：如果是分公司经理，只能看到本公司
            sql.append("and t1.company = '").append(reqdto.getCompany()).append("'").append(" ");
        }
        sql.append("order by t1.update_time desc").append(" ");
        sql.append(getLimitSql(reqdto.getPageIndex(), reqdto.getPageSize()));

        return sql.toString();
    }

    //信息总数，用于分页
    public String getActListCount(PageReqDTO reqdto){
        StringBuffer sql = new StringBuffer();
        sql.append("select count(t1.act_no) ").append(" ");
        sql.append("from crm_active t1").append(" ");
        sql.append("where 1=1").append(" ");
        if(!StringUtils.isEmpty(reqdto.getMemberType())&&(Integer.parseInt(reqdto.getMemberType()) > 90)&&!StringUtils.isEmpty(reqdto.getUserName())){ //权限控制：如果是分公司一般用户，只能看到自己的活动信息
            sql.append("and t1.operator ='").append(reqdto.getUserName()).append("'").append(" ");
        }
        if(!StringUtils.isEmpty(reqdto.getMemberType())&&reqdto.getMemberType().equals("90")&&!StringUtils.isEmpty(reqdto.getCompany())){ //权限控制：如果是分公司经理，只能看到本公司
            sql.append("and t1.company = '").append(reqdto.getCompany()).append("'").append(" ");
        }

        return sql.toString();
    }

    private  String getLimitSql(Integer index, Integer pageSize){
        return "LIMIT " + (index - 1) * pageSize + "," + pageSize;
    }

    //单个活动查询
    public String getActByActNo(String actNo){
        StringBuffer sql = new StringBuffer();
        sql.append("select t1.rec_id," +
                "t1.biz_lv1_id," +
                "t1.biz_lv1_name," +
                "t1.company," +
                "t1.act_no," +
                "t1.act_name," +
                "t1.begin_time," +
                "t1.end_time," +
                "t1.act_location," +
                "t1.us_role," +
                "t1.act_type," +
                "t1.co_partner," +
                "t1.act_fee," +
                "t1.join_persons," +
                "t1.operator," +
                "t1.remark," +
                "t1.link_address," +
                "t1.update_time").append(" ");
        sql.append("from crm_active t1").append(" ");
        sql.append("where t1.act_no = '").append(actNo).append("'");

        return sql.toString();
    }
}