package com.xlh.crm.enums;

public enum GBusinessEnum {
    G("G","高企申报"),
    Z("Z","政府专项"),
    Q("Q","其他本地化服务"),
    ;
    private String code;
    private String cnExplain;

    GBusinessEnum(String code, String cnExplain) {
        this.code = code;
        this.cnExplain = cnExplain;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCnExplain() {
        return cnExplain;
    }

    public void setCnExplain(String cnExplain) {
        this.cnExplain = cnExplain;
    }
    public static String getExplainByCode(String code){
        for (GBusinessEnum values : values()) {
            if (values.getCode().equals(code)) {
                return values.getCnExplain();
            }
        }
        return "无";
    }
}
