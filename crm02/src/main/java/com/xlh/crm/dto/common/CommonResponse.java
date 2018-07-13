package com.xlh.crm.dto.common;

import java.io.Serializable;

/**
 * Created by ycp on 2017/3/14.
 */
public class CommonResponse implements Serializable {
    public static final CommonResponse DEFAULT_ERROR_RESPONSE;
    public static final CommonResponse DEFAULT_OK_RESPONSE;
    public static final CommonResponse POST_EMPTY_ERROR;
    public static final CommonResponse PARSE_ERROR;
    public static final CommonResponse TOKEN_ERROR;
    public static final CommonResponse LINK_OVERDUE;

    public CommonResponse() {
    }

    public CommonResponse(int code, String message) {
        this.code = Integer.valueOf(code);
        this.message = message;
    }

    static {
        DEFAULT_ERROR_RESPONSE = new CommonResponse(CommonResponseCode.SYSTEM_ERROR, "内部异常");
        DEFAULT_OK_RESPONSE = new CommonResponse(CommonResponseCode.OK, "OK");
        POST_EMPTY_ERROR = new CommonResponse(CommonResponseCode.SYSTEM_ERROR, "POST请求参数不能为空");
        PARSE_ERROR = new CommonResponse(CommonResponseCode.PARAMETER_ERROR, "参数解析失败");
        TOKEN_ERROR = new CommonResponse(CommonResponseCode.PARAMETER_ERROR, "Token信息不合法");
        LINK_OVERDUE = new CommonResponse(CommonResponseCode.LINK_OVERDUE, "连接失效");
    }

    private Integer code;
    private String message;
    private Object data;

    public Integer getCode() {
        return this.code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }



    public CommonResponse(Integer code, String message) {
        this(code.intValue(), message);
    }

    public Object getData() {
        return this.data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static CommonResponse generateOKCommonResponse() {
        return new CommonResponse(Integer.valueOf(0), "OK");
    }
}
