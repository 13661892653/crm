package com.xlh.crm.domain;

public class QxbChangerecord {
    private Integer id;

    private String qxbId;

    private String changeItem;

    private String changeDate;

    private String beforeContent;

    private String afterContent;

    private Integer enttime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQxbId() {
        return qxbId;
    }

    public void setQxbId(String qxbId) {
        this.qxbId = qxbId == null ? null : qxbId.trim();
    }

    public String getChangeItem() {
        return changeItem;
    }

    public void setChangeItem(String changeItem) {
        this.changeItem = changeItem == null ? null : changeItem.trim();
    }

    public String getChangeDate() {
        return changeDate;
    }

    public void setChangeDate(String changeDate) {
        this.changeDate = changeDate == null ? null : changeDate.trim();
    }

    public String getBeforeContent() {
        return beforeContent;
    }

    public void setBeforeContent(String beforeContent) {
        this.beforeContent = beforeContent == null ? null : beforeContent.trim();
    }

    public String getAfterContent() {
        return afterContent;
    }

    public void setAfterContent(String afterContent) {
        this.afterContent = afterContent == null ? null : afterContent.trim();
    }

    public Integer getEnttime() {
        return enttime;
    }

    public void setEnttime(Integer enttime) {
        this.enttime = enttime;
    }
}