package com.xlh.crm.dto;

/**
 * Created by ysl on 2017/5/26.
 */
public class ProductShowDTO {

    //商品信息
    private String recId;  //记录ID

    private String bizLv1Id;  //产品归属一级业务类目ID

    private String bizLv1Name;  //产品归属一级业务类目描述

    private String bizLv2Id;  //产品归属二级业务类目ID

    private String bizLv2Name;  //产品归属二级业务类目描述

    private String bizLv3Id;  //产品归属三级业务类目ID

    private String bizLv3Name;  //产品归属三级业务类目描述

    private String productId;  //商品ID

    private String productName;  //商品名称

    private String price;  //价格

    private String validFlag;  //是否有效

    private String remark;   //备注

    private String updateTime;  //更新时间


    public String getRecId() {
        return recId;
    }

    public void setRecId(String recId) {
        this.recId = recId;
    }

    public String getBizLv1Id() {
        return bizLv1Id;
    }

    public void setBizLv1Id(String bizLv1Id) {
        this.bizLv1Id = bizLv1Id == null ? null : bizLv1Id.trim();
    }

    public String getBizLv1Name() {
        return bizLv1Name;
    }

    public void setBizLv1Name(String bizLv1Name) {
        this.bizLv1Name = bizLv1Name == null ? null : bizLv1Name.trim();
    }

    public String getBizLv2Id() {
        return bizLv2Id;
    }

    public void setBizLv2Id(String bizLv2Id) {
        this.bizLv2Id = bizLv2Id == null ? null : bizLv2Id.trim();
    }

    public String getBizLv2Name() {
        return bizLv2Name;
    }

    public void setBizLv2Name(String bizLv2Name) {
        this.bizLv2Name = bizLv2Name == null ? null : bizLv2Name.trim();
    }

    public String getBizLv3Id() {
        return bizLv3Id;
    }

    public void setBizLv3Id(String bizLv3Id) {
        this.bizLv3Id = bizLv3Id == null ? null : bizLv3Id.trim();
    }

    public String getBizLv3Name() {
        return bizLv3Name;
    }

    public void setBizLv3Name(String bizLv3Name) {
        this.bizLv3Name = bizLv3Name == null ? null : bizLv3Name.trim();
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId == null ? null : productId.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price == null ? null : price.trim();
    }

    public String getValidFlag() {
        return validFlag;
    }

    public void setValidFlag(String validFlag) {
        this.validFlag = validFlag == null ? null : validFlag.trim();
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime == null ? null : updateTime.trim();
    }

}
