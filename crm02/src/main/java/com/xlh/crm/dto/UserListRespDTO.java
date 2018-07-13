package com.xlh.crm.dto;

import java.util.List;

/**
 * Created by ysl on 2017/5/26.
 */
public class UserListRespDTO {

    /*查询总记录数*/
    private int totalRecCount = 0;

    /*总页数,由计算得出*/
    private int totalPageCount = 0;

    /*请求参数返回前端*/
    private PageReqDTO reqParams;

    /*企业数据库列表*/
    private List<MemberInfoDTO> userListContents;

    /*单个企业信息*/
    private MemberInfoDTO userSglContents;

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

    public List<MemberInfoDTO> getUserListContents() {
        return userListContents;
    }

    public void setUserListContents(List<MemberInfoDTO> userListContents) {
        this.userListContents = userListContents;
    }

    public MemberInfoDTO getUserSglContents() {
        return userSglContents;
    }

    public void setUserSglContents(MemberInfoDTO userSglContents) {
        this.userSglContents = userSglContents;
    }

}
