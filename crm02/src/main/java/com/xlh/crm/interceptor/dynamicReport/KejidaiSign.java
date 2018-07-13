package com.xlh.crm.interceptor.dynamicReport;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.codec.digest.DigestUtils;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class KejidaiSign implements DynamicReportSign{

    public JSONObject dealSgin(JSONObject input){
        input.put("_api_key","testapikey");
        Map<String, Object> res=sortJsonObject(input);
        String result=qm(res);
        result+="testapisec";
        byte[] bytes = null;
        String sign=DigestUtils.md5Hex(result);
        input.put("_sign",sign);
        return input;
    }

    public  String qm(Map<String, Object> map){
        String str="";
        for(String  key :map.keySet()){
            if(map.get(key) instanceof Map){
                str+=qm((Map<String, Object>)map.get(key));
            }else{
                str+=key+"="+String.valueOf(map.get(key));
            }
        }
        return str;
    }

    public  Map<String, Object> sortJsonObject(JSONObject obj) {
        Map map = new TreeMap();
        Set<String> it = obj.keySet();
        for (String key :it){
            Object value = obj.get(key);
            if (value instanceof JSONObject) {
                // System.out.println(value + " is JSONObject");
                map.put(key, sortJsonObject((JSONObject)value));
            } else if (value instanceof JSONArray) {
                // System.out.println(value + " is JSONArray");
//                map.put(key, sortJsonArray(JSONArray.fromObject(value)));
            } else {
                map.put(key, value);
            }
        }
        return map;
    }
}
