package com.xlh.crm.data;

import com.alibaba.fastjson.JSONObject;

/**
 * Created by wwz on 2016/12/1.
 */
public class QXBAPIResponseDTO {

    private Integer status;
    private String message;
    private JSONObject data;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public JSONObject getData() {
        return data;
    }

    public void setData(JSONObject data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "QXBAPIResponseDTO{" +
                "status='" + status + '\'' +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
