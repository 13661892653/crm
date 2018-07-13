package com.xlh.crm.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.squareup.okhttp.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.concurrent.TimeUnit;


/**
 * Created by wwz on 2016/11/30.
 */
public class HttpClientManager {

    private static final Logger LOGGER = LogManager.getLogger(HttpClientManager.class.getName());

    private static HttpClientManager instance;
    private OkHttpClient httpClient;

    private HttpClientManager() {
        httpClient = new OkHttpClient();
        httpClient.setConnectTimeout(200, TimeUnit.SECONDS);
        httpClient.setWriteTimeout(200, TimeUnit.SECONDS);
        httpClient.setReadTimeout(200, TimeUnit.SECONDS);
    }

    public static HttpClientManager getInstance() {
        if (instance == null) {
            synchronized (HttpClientManager.class) {
                if (instance == null) {
                    instance = new HttpClientManager();
                }
            }
        }
        return instance;
    }

    /**
     * 同步的Get请求
     *
     * @param url
     * @return Response
     */
    private Response _getSync(String url) throws IOException {
        final Request request = new Request.Builder()
                .url(url)
                .build();
        Call call = httpClient.newCall(request);
        Response response = call.execute();
        return response;
    }

    /**
     * 同步的Get请求
     *
     * @param url
     * @return body字符串
     * @throws IOException
     */
    private String _getSyncAsString(String url) throws IOException {
        Response response = _getSync(url);
        return response.body().string();
    }

    /**
     * 同步的Post请求
     *
     * @param url
     * @param params
     * @return
     * @throws IOException
     */
    private Response _post(String url, Param... params) throws IOException {
        Request request = buildPostRequest(url, params);
        Response response = httpClient.newCall(request).execute();
        return response;
    }

    /**
     * 同步的Post请求
     *
     * @param url
     * @param params
     * @return body字符串
     * @throws IOException
     */
    private String _postAsString(String url, Param... params) throws IOException {
        Response response = _post(url, params);
        return response.body().string();
    }

    /**
     * 构造PostRequest，默认添加Content-Type
     *
     * @param url
     * @param params
     * @return
     */
    private Request buildPostRequest(String url, Param[] params) {
        return buildPostRequest(url, params, null);
    }

    /**
     * 构造PostRequest
     *
     * @param url
     * @param params       请求参数
     * @param headerParams header参数
     * @return
     */
    private Request buildPostRequest(String url, Param[] params, HeaderParam[] headerParams) {
        if (params == null) {
            params = new Param[0];
        }

        JSONObject jsonObject = new JSONObject();
        for (Param param : params) {
            jsonObject.put(param.key, param.value);
        }
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), jsonObject.toJSONString());

        if (headerParams == null) {
            headerParams = new HeaderParam[0];
        }
        Headers.Builder headerBuilder = new Headers.Builder();
        for (HeaderParam headerParam : headerParams) {
            headerBuilder.add(headerParam.key, headerParam.value);
        }
        Headers headers = headerBuilder.build();

        return new Request.Builder()
                .url(url)
                .headers(headers)
                .post(requestBody)
                .build();
    }


    //******对外暴露的方法*******

    public static Response getSync(String url) throws IOException {
        LOGGER.info("getSync url={} ",url);
        return getInstance()._getSync(url);
    }

    public static String getSyncAsString(String url) throws IOException {
        LOGGER.info("getSyncAsString url={}",url);
        String resp=  getInstance()._getSyncAsString(url);
        LOGGER.info("getSyncAsString resp={}",resp);
        return resp;
    }

    public static Response post(String url, Param... params) throws IOException {
        LOGGER.info("post url={}  params={}",url, JSON.toJSONString(params));
        return getInstance()._post(url, params);
    }

    public static String postAsString(String url, Param... params) throws IOException {
        LOGGER.info("postAsString url={}  params={}",url, JSON.toJSONString(params));
        String resp= getInstance()._postAsString(url, params);
        LOGGER.info("postAsString resp={}",resp);
        return resp;
    }

    public static class Param {

        String key;
        Object value;

        public Param() {

        }

        public Param(String key, Object value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return " key:" + key + " value:" + value.toString();
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public Object getValue() {
            return value;
        }

        public void setValue(Object value) {
            this.value = value;
        }
    }

    public static class HeaderParam {
        String key;
        String value;

        public HeaderParam(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }
}
