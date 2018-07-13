package com.xlh.crm.utils;


import com.xlh.crm.dto.RespRestfulDto;

public class RespCommon {
    public static RespRestfulDto success(Object object){
        RespRestfulDto respRestfulDto =new RespRestfulDto();
        respRestfulDto.setCode("200");
        respRestfulDto.setMsg("success");
        respRestfulDto.setData(object);
        return respRestfulDto;
    }


    public static RespRestfulDto fail(Exception e){
        RespRestfulDto respRestfulDto =new RespRestfulDto();
        respRestfulDto.setCode("500");
        respRestfulDto.setMsg(e.getMessage());
        respRestfulDto.setData(null);
        return respRestfulDto;
    }
}
