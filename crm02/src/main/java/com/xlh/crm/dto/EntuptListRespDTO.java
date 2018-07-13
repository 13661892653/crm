package com.xlh.crm.dto;

import com.xlh.crm.dto.EnterpriseShowDTO;
import com.xlh.crm.dto.InvEventShowDTO;
import com.xlh.crm.dto.PageReqDTO;
import com.xlh.crm.dto.ProjectBankShowDTO;

import java.util.List;

/**
 * Created by ysl on 2017/5/26.
 */
public class EntuptListRespDTO {

    /*查询总记录数*/
    private int totalRecCount = 0;

    /*总页数,由计算得出*/
    private int totalPageCount = 0;

    /*请求参数返回前端*/
    private PageReqDTO reqParams;

    /*列表*/
    private List<EnterpriseShowDTO> entuptListContents;

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

    public List<EnterpriseShowDTO> getEntuptListContents() {
        return entuptListContents;
    }

    public void setEntuptListContents(List<EnterpriseShowDTO> entuptListContents) {
        this.entuptListContents = entuptListContents;
    }

}
