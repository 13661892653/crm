package com.xlh.crm.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.xlh.crm.common.CurrentTime;
import com.xlh.crm.data.OperationLogCode;
import com.xlh.crm.data.QXBAPIResponseDTO;
import com.xlh.crm.domain.QxbCorpInfo;
import com.xlh.crm.dto.EnterpriseBankListRespDTO;
import com.xlh.crm.dto.OperationLogDTO;
import com.xlh.crm.dto.PageReqDTO;
import com.xlh.crm.dto.RespRestfulDto;
import com.xlh.crm.dto.mysql.FiFileList;
import com.xlh.crm.mapper.CrmMapper;
import com.xlh.crm.service.CrmModService;
import com.xlh.crm.service.FinanceInputService;
import com.xlh.crm.service.impl.CrmModServiceImpl;
import com.xlh.crm.service.impl.DynamicReportServceImpl;
import com.xlh.crm.service.impl.TaskServiceImpl;
import com.xlh.crm.task.AsyncFirstScore;
import com.xlh.crm.utils.RespCommon;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class ApiController {
    private static final Logger logger = LoggerFactory.getLogger(ApiController.class.getName());
    @Autowired
    private CrmModService crmModService;
    @Autowired
    CrmMapper crmMapper;
    @Value("${api.md5.secretKey}")
    private String secretKey;
    @Autowired
    private AsyncFirstScore asyncFirstScore;
    @Autowired
    private FinanceInputService financeInputService;


    @RequestMapping(value = "qxbCheckName")
    public RespRestfulDto qxbCheckName(@RequestParam(value = "key") String key, @RequestParam(value = "sign") String sign) {
        logger.info("qxbCheckName start key={} sign={}", key, sign);
        try {
            if (sign == null || sign.length() != 32 || key == null || "".equals(key)) {
                throw new Exception("验签失败");
            }
            if (!DigestUtils.md5Hex(key + secretKey).equals(sign)) {
                throw new Exception("验签失败");
            }
            QxbCorpInfo qxbCorpInfo = crmModService.getEntInitDataApi(key);
            logger.info("qxbCheckName qxbCorpInfo={}", JSON.toJSONString(qxbCorpInfo));
            return RespCommon.success(qxbCorpInfo);
        } catch (Exception e) {
            logger.info("qxbCheckName Exception={}", e.getMessage());
            return RespCommon.fail(e);
        }
    }

    /**
     * 请求录入数据
     * @param sign
     * @param jsonArray
     * @return
     */
    @RequestMapping(value = "dynamicReportReq")
    public RespRestfulDto dynamicReportReq(@RequestParam(value = "sign") String sign,@RequestBody JSONArray jsonArray){
        logger.info("dynamicReportReq start jsonArray={}", JSON.toJSONString(jsonArray));
        try {
            if(jsonArray.size()<1){
                throw new Exception("请求列表为空");
            }
            JSONObject jsonObject=jsonArray.getJSONObject(0);
            String enterpriseName=jsonObject.getString("enterpriseName");
            if (sign == null || sign.length() != 32 || enterpriseName == null || "".equals(enterpriseName)) {
                throw new Exception("验签失败");
            }
            if (!DigestUtils.md5Hex(enterpriseName + secretKey).equals(sign)) {
                throw new Exception("验签失败");
            }
            boolean res=financeInputService.dynamicReportDataApiReq(jsonArray);
            logger.info("dynamicReportReq res={}", res);
            return RespCommon.success(res);
        }catch (Exception e){
            logger.info("dynamicReportReq Exception={}", e.getMessage());
            return RespCommon.fail(e);
        }
    }

    @RequestMapping(value = "gqscoreRefresh")
    public String test() {
        asyncFirstScore.startUp();
        return "started";
    }

    @Autowired
    private TaskServiceImpl taskService;
    @RequestMapping("test")
    public RespRestfulDto test2() throws IllegalAccessException {
        taskService.financeTableSync();
//        taskService.ttttt();
        return RespCommon.success(1);
    }

}
