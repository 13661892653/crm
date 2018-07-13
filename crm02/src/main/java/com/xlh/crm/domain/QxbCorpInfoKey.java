package com.xlh.crm.domain;

public class QxbCorpInfoKey {
    private Integer id;

    private String qxbId;

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
}