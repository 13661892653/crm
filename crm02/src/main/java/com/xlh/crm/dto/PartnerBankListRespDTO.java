package com.xlh.crm.dto;

import java.util.List;

/**
 * Created by ysl on 2017/5/26.
 */
public class PartnerBankListRespDTO {

    /*查询总记录数*/
    private int totalRecCount = 0;

    /*总页数,由计算得出*/
    private int totalPageCount = 0;

    /*请求参数返回前端*/
    private PageReqDTO reqParams;

    /*列表*/
    private List<PartnerShowDTO> partnerListContents;

    /*单个信息*/
    private PartnerShowDTO partnerSglContents;

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

    public List<PartnerShowDTO> getPartnerListContents() {
        return partnerListContents;
    }

    public void setPartnerListContents(List<PartnerShowDTO> partnerListContents) {
        this.partnerListContents = partnerListContents;
    }

    public PartnerShowDTO getPartnerSglContents() {
        return partnerSglContents;
    }

    public void setPartnerSglContents(PartnerShowDTO partnerSglContents) {
        this.partnerSglContents = partnerSglContents;
    }

}
