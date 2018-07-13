package com.xlh.crm.data;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.alibaba.fastjson.JSONObject;
import com.xlh.crm.utils.HttpClientManager;

/**
 * Created by wwz on 2016/12/9.
 */
public class QxbApiResponseDTOTransverter {

    private static final Logger LOGGER = LogManager.getLogger(QxbApiResponseDTOTransverter.class.getName());

    public static QXBAPIResponseDTO transferJsonToQxbApiResponseDTO(String url, HttpClientManager.Param[] params) {
        try {
            String bodyStr = HttpClientManager.postAsString(url, params);
            JSONObject jsonObject = JSONObject.parseObject(bodyStr);
            if (jsonObject == null || jsonObject.get("status") == null) {
//                throw new CreditPlatformException(ReturnCode.API_RESPONSE_EXCEPTION, ReturnCode.MSG_API_RESPONSE_EXCEPTION);
            	return null;
            }
            Integer status = Integer.valueOf(String.valueOf(jsonObject.get("status")));
            String message = String.valueOf(jsonObject.get("message"));
            String data = jsonObject.get("data").toString();
            if (status != 200) {
                StringBuffer stringBuffer = new StringBuffer();
                for (HttpClientManager.Param param : params) {
                    stringBuffer.append(param.toString());
                }
                LOGGER.error("message:" + message + " status:" + status + " url:" + url + " params:" + stringBuffer.toString());
                return null;
            }
            QXBAPIResponseDTO responseDTO = new QXBAPIResponseDTO();
            responseDTO.setData(JSONObject.parseObject(data));
            responseDTO.setMessage(message);
            responseDTO.setStatus(status);
            return responseDTO;
        } catch (IOException e) {
            LOGGER.error(e.getMessage() + " url:" + url, e);
//            throw new CreditPlatformException(ReturnCode.API_RESPONSE_EXCEPTION, ReturnCode.MSG_API_RESPONSE_EXCEPTION);
            return null;
        }
    }


    public static QXBAPIResponseDTO toCorpMonitorResponse(String url, HttpClientManager.Param[] params) {
        try {
//        	String data = "";
//        	Integer status = 0;
//        	String message = "";
//        	if (url.equals("xxxxx")) {
////        		if (url.equals(QXBAPIRequestURL.GET_DETAIL_AND_CONTRACT_BY_ID)) {
//        		data = TestString.CorpDetailById;
//        	} else {
//        	}
            QXBAPIResponseDTO responseDTO = new QXBAPIResponseDTO();
        	String bodyStr = HttpClientManager.postAsString(url, params);
        	JSONObject jsonObject = JSONObject.parseObject(bodyStr);
        	if (jsonObject == null || jsonObject.get("status") == null) {
//                throw new CreditPlatformException(ReturnCode.API_RESPONSE_EXCEPTION, ReturnCode.MSG_API_RESPONSE_EXCEPTION);
        		return null;
        	}
        	Integer status = Integer.valueOf(String.valueOf(jsonObject.get("status")));
        	String message = String.valueOf(jsonObject.get("message"));
        	String data = jsonObject.get("data").toString();
            responseDTO.setData(JSONObject.parseObject(data));
            responseDTO.setMessage(message);
            responseDTO.setStatus(status);
        	if (status != 200) {
        		if(status == 201){
//                    throw new CreditPlatformException(ReturnCode.API_NO_DATA,ReturnCode.MSG_API_NO_DATA);
        		}
        		StringBuffer stringBuffer = new StringBuffer();
        		for (HttpClientManager.Param param : params) {
        			stringBuffer.append(param.toString());
        		}
        		LOGGER.error("message:" + message + " status:" + status + " url:" + url + " params:" + stringBuffer.toString());
//                throw new CreditPlatformException(ReturnCode.API_RESPONSE_EXCEPTION,ReturnCode.MSG_API_RESPONSE_EXCEPTION);
        		return responseDTO;
        	}
            return responseDTO;
        } catch (IOException e) {
            LOGGER.error(e.getMessage() + " url:" + url, e);
//            throw new CreditPlatformException(ReturnCode.API_RESPONSE_EXCEPTION, ReturnCode.MSG_API_RESPONSE_EXCEPTION);
            return null;
        }
    }

}
