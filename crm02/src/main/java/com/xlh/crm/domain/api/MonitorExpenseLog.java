package com.xlh.crm.domain.api;

import java.util.Date;

public class MonitorExpenseLog {
    private Integer taskId;

    private String regNo;

    private Integer memberId;

    private Integer monitorPlanId;

    private Date taskDate;

    private Date updateTime;

    private Integer isDel;

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo == null ? null : regNo.trim();
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public Integer getMonitorPlanId() {
        return monitorPlanId;
    }

    public void setMonitorPlanId(Integer monitorPlanId) {
        this.monitorPlanId = monitorPlanId;
    }

    public Date getTaskDate() {
        return taskDate;
    }

    public void setTaskDate(Date taskDate) {
        this.taskDate = taskDate;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }
}