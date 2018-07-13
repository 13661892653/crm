package com.xlh.crm.enums;

import com.xlh.crm.interceptor.dynamicReport.DynamicReportSign;

public enum DynamicReportSignEnum {
    kejidai("kejidai","com.xlh.crm.interceptor.dynamicReport.KejidaiSign"),
    empty("empty","com.xlh.crm.interceptor.dynamicReport.EmptySign");
    private String name;
    private String classDo;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassDo() {
        return classDo;
    }

    public void setClassDo(String classDo) {
        this.classDo = classDo;
    }

    public static DynamicReportSign getInstanceByType(String type) throws Exception {
        for (DynamicReportSignEnum values : values()) {
            if (values.getName().contains(type)) {
                return (DynamicReportSign)Class.forName(values.getClassDo()).newInstance();
            }
        }
        throw new Exception("格式不正确");
    }
    private DynamicReportSignEnum(String name, String classDo){
        this.name=name;
        this.classDo=classDo;
    }
}
