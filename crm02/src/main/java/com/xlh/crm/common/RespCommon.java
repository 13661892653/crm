package com.xlh.crm.common;

import com.xlh.crm.dto.JsonRespDto;

public class RespCommon {

    public static JsonRespDto success(Object object){
        JsonRespDto jsonRespDto=new JsonRespDto();
        jsonRespDto.setCode("200");
        jsonRespDto.setMsg("success");
        jsonRespDto.setData(object);
        return jsonRespDto;
    }
    public static JsonRespDto fail(Exception e){
        JsonRespDto jsonRespDto=new JsonRespDto();
        jsonRespDto.setCode("500");
        jsonRespDto.setMsg(e.getMessage());
        return jsonRespDto;
    }
}
