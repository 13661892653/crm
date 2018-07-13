package com.xlh.crm.dto;

import java.util.Date;

/**
 * Created by ysl on 2017/5/26.
 */
public class EnterpriseMarketFollowRespDTO {

    //企业档案-营销跟进
    private String followPerson;

    private Date followDate;

    private String bizTypeLv1Desc;

    private String bizTypeLv2Desc;

    private String followContent;

    private String progress;

    private String followStatus;

    private String remarks;

    public String getFollowPerson() {
        return followPerson;
    }

    public void setFollowPerson(String followPerson) {
        this.followPerson = followPerson == null ? null : followPerson.trim();
    }

    public Date getFollowDate() {
        return followDate;
    }

    public void setFollowDate(Date followDate) {
        this.followDate = followDate;
    }

    public String getBizTypeLv1Desc() {
        return bizTypeLv1Desc;
    }

    public void setBizTypeLv1Desc(String bizTypeLv1Desc) {
        this.bizTypeLv1Desc = bizTypeLv1Desc == null ? null : bizTypeLv1Desc.trim();
    }

    public String getBizTypeLv2Desc() {
        return bizTypeLv2Desc;
    }

    public void setBizTypeLv2Desc(String bizTypeLv2Desc) {
        this.bizTypeLv2Desc = bizTypeLv2Desc == null ? null : bizTypeLv1Desc.trim();
    }

    public String getFollowContent() {
        return followContent;
    }

    public void setFollowContent(String followContent) {
        this.followContent = followContent == null ? null : followContent.trim();
    }

    public String getProgress() {
        return progress;
    }

    public void setProgress(String progress) {
        this.progress = progress == null ? null : progress.trim();
    }

    public String getFollowStatus() {
        return followStatus;
    }

    public void getFollowStatus(String followStatus) {
        this.followStatus = followStatus == null ? null : followStatus.trim();
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }
}
