package com.xlh.crm.interceptor.dynamicReport;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.codec.digest.DigestUtils;

import java.util.Map;

public class EmptySign implements DynamicReportSign {
    public JSONObject dealSgin(JSONObject input){
        return input;
    }
}
