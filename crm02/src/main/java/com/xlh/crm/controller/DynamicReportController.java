package com.xlh.crm.controller;


import com.alibaba.fastjson.JSON;
import com.xlh.crm.domain.QxbCorpInfo;
import com.xlh.crm.dto.RespRestfulDto;
import com.xlh.crm.dto.dynamicReport.DynamicReport;
import com.xlh.crm.dto.mysql.FiDynamicReportStruct;
import com.xlh.crm.service.impl.DynamicReportServceImpl;
import com.xlh.crm.service.impl.SessionServiceImpl;
import com.xlh.crm.utils.RespCommon;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/dynamicReport")
public class DynamicReportController {
    @Autowired
    private DynamicReportServceImpl dynamicReportServce;
    @Autowired
    private SessionServiceImpl sessionService;
    @RequestMapping(value = "reportCreate",method = RequestMethod.GET)
    public ModelAndView reportCreateGet(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("dynamicReport/reprotCreate");
        modelAndView.addObject("user", sessionService.getUser());
        return modelAndView;
    }
    @RequestMapping(value = "reportDetailAjax",method = RequestMethod.GET)
    public RespRestfulDto reportDetailAjax(@RequestParam(value = "id",defaultValue = "0")int id){
        try {
            DynamicReport dynamicReport=dynamicReportServce.findReportStruct(id);
            return RespCommon.success(dynamicReport);
        } catch (Exception e) {
            return RespCommon.fail(e);
        }
    }
    @RequestMapping(value = "reportData",method = RequestMethod.GET)
    public ModelAndView reportDataGet(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("dynamicReport/reportData");
        modelAndView.addObject("user", sessionService.getUser());
        return modelAndView;
    }
    @RequestMapping(value = "reportCreate",method = RequestMethod.POST)
    public RespRestfulDto reportCreatePost(@RequestBody DynamicReport dynamicReport, HttpServletResponse response){
        try {
            FiDynamicReportStruct fiDynamicReportStruct=dynamicReportServce.saveDynamicReportTable(dynamicReport);
            return RespCommon.success(fiDynamicReportStruct);
        } catch (Exception e) {
            return RespCommon.fail(e);
        }
    }

    @RequestMapping(value = "list",method = RequestMethod.GET)
    public ModelAndView reportList() throws Exception {
        List<FiDynamicReportStruct> list= dynamicReportServce.reportStructList();
        ModelAndView modelAndView=new ModelAndView("dynamicReport/list");
        modelAndView.addObject("list",list);
        modelAndView.addObject("user", sessionService.getUser());
        return modelAndView;
    }
}
