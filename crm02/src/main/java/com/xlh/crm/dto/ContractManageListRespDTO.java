package com.xlh.crm.dto;

import java.util.List;

/**
 * Created by ysl on 2017/5/26.
 */
public class ContractManageListRespDTO {

    /*查询总记录数*/
    private int totalRecCount = 0;

    /*总页数,由计算得出*/
    private int totalPageCount = 0;

    /*请求参数返回前端*/
    private PageReqDTO reqParams;

    /*触达信息列表*/
    private List<ContractShowDTO> contractListContents;

    /*单条触达信息*/
    private ContractShowDTO contractSglContents;

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

    public List<ContractShowDTO> getContractListContents() {
        return contractListContents;
    }

    public void setContractListContents(List<ContractShowDTO> contractListContents) {
        this.contractListContents = contractListContents;
    }

    public ContractShowDTO getContractSglContents() {
        return contractSglContents;
    }

    public void setContractSglContents(ContractShowDTO contractSglContents) {
        this.contractSglContents = contractSglContents;
    }

}
