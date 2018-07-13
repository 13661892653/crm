package com.xlh.crm.domain;

public class QxbBranch {
    private Integer id;

    private Integer dtoId;

    private String qxbId;

    private String name;

    private Integer enttime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDtoId() {
        return dtoId;
    }

    public void setDtoId(Integer dtoId) {
        this.dtoId = dtoId;
    }

    public String getQxbId() {
        return qxbId;
    }

    public void setQxbId(String qxbId) {
        this.qxbId = qxbId == null ? null : qxbId.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getEnttime() {
        return enttime;
    }

    public void setEnttime(Integer enttime) {
        this.enttime = enttime;
    }
}