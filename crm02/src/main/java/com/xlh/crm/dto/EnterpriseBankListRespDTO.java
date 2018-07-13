package com.xlh.crm.dto;

import java.util.List;

/**
 * Created by ysl on 2017/5/26.
 */
public class EnterpriseBankListRespDTO {

    /*查询总记录数*/
    private int totalRecCount = 0;

    /*总页数,由计算得出*/
    private int totalPageCount = 0;

    /*请求参数返回前端*/
    private PageReqDTO reqParams;

    /*企业数据库列表*/
    private List<EnterpriseShowDTO> entListContents;

    /*单个企业信息*/
    private EnterpriseShowDTO entSglContents;

    /*项目数据库列表*/
    private List<ProjectBankShowDTO> prjListContents;

    /*投融资数据库列表*/
    private List<InvEventShowDTO> invListContents;

    public int getTotalRecCount() {
        return totalRecCount;
    }

    public void setTotalRecCount(int totalRecCount) {
        this.totalRecCount = totalRecCount;
    }

    public int getTotalPageCount() {
        return totalPageCount;
    }

    public void setTotalPageCount(int totalPageCount) {
        this.totalPageCount = totalPageCount;
    }

    public PageReqDTO getReqParams() {
        return reqParams;
    }

    public void setReqParams(PageReqDTO reqParams) {
        this.reqParams = reqParams;
    }

    public List<EnterpriseShowDTO> getEntListContents() {
        return entListContents;
    }

    public void setEntListContents(List<EnterpriseShowDTO> entListContents) {
        this.entListContents = entListContents;
    }

    public EnterpriseShowDTO getEntSglContents() {
        return entSglContents;
    }

    public void setEntSglContents(EnterpriseShowDTO entSglContents) {
        this.entSglContents = entSglContents == null ? null:entSglContents;
    }

    public List<ProjectBankShowDTO> getPrjListContents() {
        return prjListContents;
    }

    public void setPrjListContents(List<ProjectBankShowDTO> prjListContents) {
        this.prjListContents = prjListContents;
    }

    public List<InvEventShowDTO> getInvListContents() {
        return invListContents;
    }

    public void setInvListContents(List<InvEventShowDTO> invListContents) {
        this.invListContents = invListContents;
    }


}
