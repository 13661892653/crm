package com.xlh.crm.enums;

import java.util.HashMap;
import java.util.Map;

public enum  FinanceTableColumnNameEnum {
    Normal("Normal","一般企业"),
    JxNormal("JxNormal","一般企业"),
    Small("Small","小企业"),
    JxSmall("JxSmall","小企业"),
    tax("tax","纳税报表"),
    in("in","内表"),
    audit("audit","审计报表"),
    Profit("Profit","利润表"),
    Balance("Balance","资产负债表"),
            ;
    private String code;
    private String cnExplain;

    FinanceTableColumnNameEnum(String code, String cnExplain) {
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
        for (FinanceTableColumnNameEnum values : values()) {
            if (values.getCode().equals(code)) {
                return values.getCnExplain();
            }
        }
        return "无";
    }
    public static Map<String,String> getMap(){
        Map<String,String> map=new HashMap<>();
        for (FinanceTableColumnNameEnum values : values()) {
            map.put(values.getCode(),values.getCnExplain());
        }
        return map;
    }
}
