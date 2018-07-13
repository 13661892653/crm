package com.xlh.crm.domain;


public class EnterpriseTag {
    private String assetsType;

    private String assetsTypeDesc;

    private String assetsTagCode;

    private String assetsTagDesc;

    private String tagLevel;

    public String getAssetsType() {
        return assetsType;
    }

    public void setAssetsType(String assetsType) {
        this.assetsType = assetsType == null ? null : assetsType.trim();
    }

    public String getAssetsTypeDesc() {
        return assetsTypeDesc;
    }

    public void setAssetsTypeDesc(String assetsTypeDesc) {
        this.assetsTypeDesc = assetsTypeDesc == null ? null : assetsTypeDesc.trim();
    }

    public String getAssetsTagCode() {
        return assetsTagCode;
    }

    public void setAssetsTagCode(String assetsTagCode) {
        this.assetsTagCode = assetsTagCode == null ? null : assetsTagCode.trim();
    }

    public String getAssetsTagDesc() {
        return assetsTagDesc;
    }

    public void setAssetsTagDesc(String assetsTagDesc) {
        this.assetsTagDesc = assetsTagDesc == null ? null : assetsTagDesc.trim();
    }

    public String getTagLevel() {
        return tagLevel;
    }

    public void setTagLevel(String tagLevel) {
        this.tagLevel = tagLevel == null ? null : tagLevel.trim();
    }

}