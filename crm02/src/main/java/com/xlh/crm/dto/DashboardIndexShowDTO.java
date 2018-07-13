package com.xlh.crm.dto;

/**
 * Created by ysl on 2017/6/2.
 */
public class DashboardIndexShowDTO {

    private Double monAcContrAmt = 0.0;    //当月累计合同金额

    private int monAcOrdCnt = 0;    //当月累计订单数

    private Double monAcOrdAmt = 0.0;    //当月累计订单金额

    private int monRchCnt = 0;    //当月触达次数

    private int monRchEntCnt = 0;    //当月触达企业数

    private int monVstEntCnt = 0;    //当月拜访企业数

    private int monUptEntCnt = 0;    //当月更新企业数

    private int entTotalCnt = 0;    //截止目前收录企业数

    private int recCnt = 0;  //返回记录数

    public Double getMonAcContrAmt() {
        return monAcContrAmt;
    }

    public void setMonAcContrAmt(Double monAcContrAmt) {
        this.monAcContrAmt = monAcContrAmt;
    }

    public Integer getMonAcOrdCnt() {
        return monAcOrdCnt;
    }

    public void setMonAcOrdCnt(Integer monAcOrdCnt) {
        this.monAcOrdCnt = monAcOrdCnt;
    }

    public Double getMonAcOrdAmt() {
        return monAcOrdAmt;
    }

    public void setMonAcOrdAmt(Double monAcOrdAmt) {
        this.monAcOrdAmt = monAcOrdAmt;
    }

    public Integer getMonRchCnt() {
        return monRchCnt;
    }

    public void setMonRchCnt(Integer monRchCnt) {
        this.monRchCnt = monRchCnt;
    }

    public Integer getMonRchEntCnt() {
        return monRchEntCnt;
    }

    public void setMonRchEntCnt(Integer monRchEntCnt) {
        this.monRchEntCnt = monRchEntCnt;
    }

    public Integer getMonVstEntCnt() {
        return monVstEntCnt;
    }

    public void setMonVstEntCnt(Integer monVstEntCnt) {
        this.monVstEntCnt = monVstEntCnt;
    }

    public Integer getMonUptEntCnt() {
        return monUptEntCnt;
    }

    public void setMonUptEntCnt(Integer monUptEntCnt) {
        this.monUptEntCnt = monUptEntCnt;
    }

    public Integer getEntTotalCnt() {
        return entTotalCnt;
    }

    public void setEntTotalCnt(Integer entTotalCnt) {
        this.entTotalCnt = entTotalCnt;
    }

    public Integer getRecCnt() {
        return recCnt;
    }

    public void setRecCnt(Integer recCnt) {
        this.recCnt = recCnt;
    }

}
