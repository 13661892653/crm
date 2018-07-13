package com.xlh.crm.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ycp on 2017/3/15.
 */

public class JacksonUtil {

    private static final Logger LOG = LoggerFactory.getLogger(JacksonUtil.class);
    private static final ObjectMapper MAPPER = new ObjectMapper();
    private static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public JacksonUtil() {
    }

    public static <T> String beanToJson(T bean) {
        try {
            return MAPPER.writeValueAsString(bean);
        } catch (JsonProcessingException var2) {
            LOG.error("JavaBean ===> JSON ERROR : {}", var2.getMessage());
            return null;
        }
    }


    public static <T> Map<String, Object> beanToMap(T bean) {
        return json2Map(beanToJson(bean));
    }

    public static <T> T jsonToObj(String json, Class<T> clazz) {
        try {
            JsonNode e = MAPPER.readTree(json);
            return MAPPER.treeToValue(e, clazz);
        } catch (IOException var4) {
            LOG.error("JSON ==> {} ERROR : {}", clazz.getClass().getName(), var4.getMessage());
            return null;
        }
    }

    public static <T> T mapToObj(Map map, Class<T> clazz) {
            String e = beanToJson(map);
            return jsonToObj(e, clazz);
    }



    public static Map<String, Object> json2Map(String json) {
        return (Map)jsonToObj(json, HashMap.class);
    }


    public static ObjectMapper getMapper() {
        return MAPPER;
    }

    static {
        MAPPER.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        MAPPER.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        MAPPER.setDateFormat(SIMPLE_DATE_FORMAT);
    }
}


