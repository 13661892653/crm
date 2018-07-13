package com.xlh.crm.dto;

import java.util.Date;

/**
 * Created by ysl on 2017/5/26.
 */
public class EnterpriseOrderRespDTO {

    //企业档案-服务订单
    private String orderId;

    private Date orderDate;

    private String bizTypeLv1Desc;

    private String bizTypeLv2Desc;

    private String prdName;

    private String price;

    private int orderNumber;

    private String orderStatus;

    private String servicePerson;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
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

    public String getPrdName() {
        return prdName;
    }

    public void setPrdName(String prdName) {
        this.prdName = prdName == null ? null : prdName.trim();
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price == null ? null : price.trim();
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus == null ? null : orderStatus.trim();
    }

    public String getServicePerson() {
        return servicePerson;
    }

    public void setServicePerson(String servicePerson) {
        this.servicePerson = servicePerson == null ? null : servicePerson.trim();
    }
}
