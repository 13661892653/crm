package com.xlh.crm.controller;


import com.xlh.crm.dto.PageReqDTO;
import com.xlh.crm.dto.PageResp.ActivityListResp;
import com.xlh.crm.dto.mysql.CrmActive;
import com.xlh.crm.service.impl.ActivityServiceImpl;
import com.xlh.crm.service.impl.SessionServiceImpl;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

@Controller
@RequestMapping("/activity")
public class ActivityController {

    @Autowired
    private SessionServiceImpl sessionService;

    @Autowired
    private ActivityServiceImpl activityService;
    @RequestMapping("/list")
    public ModelAndView list(@ModelAttribute  PageReqDTO req){
        ModelAndView modelAndView = new ModelAndView("marketing_act");
        ActivityListResp result = null;
        req.setUserName(sessionService.getUser().getUserName()); //设置用户名
        req.setCompany(sessionService.getUser().getCompany()); //设置用户所在公司
        req.setMemberType(sessionService.getUser().getMemberType()); //设置用户类型
        result = activityService.actManageList(req);
        modelAndView.addObject("result", result);
        modelAndView.addObject("req", req);
        modelAndView.addObject("user", sessionService.getUser());
        return modelAndView;
    }
    @RequestMapping("/listExcel")
    public void listExcel(@ModelAttribute  PageReqDTO req,HttpServletResponse response) throws IOException {
        response.setHeader("Content-disposition", "activity.xls");
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-disposition", "attachment;filename=activity.xls");
        response.setHeader("Pragma", "No-cache");
        HSSFWorkbook wb =activityService.listExcel(req);
        OutputStream ouputStream = response.getOutputStream();
        wb.write(ouputStream);
        ouputStream.flush();
        ouputStream.close();
    }

    @RequestMapping(value = "/detail",method = RequestMethod.GET)
    public ModelAndView detail(@RequestParam(value = "recId" ,required = false,defaultValue = "0") int recId){
        ModelAndView modelAndView = new ModelAndView("act_add");
        CrmActive crmActive=activityService.actDetail(recId);
        if(crmActive==null){
            crmActive=new CrmActive();
        }
        modelAndView.addObject("crmActive",crmActive);
        modelAndView.addObject("user", sessionService.getUser());
        return modelAndView;
    }
    @RequestMapping(value = "/detail",method = RequestMethod.POST)
    public void detailSave(@RequestParam(value = "recId" ,required = false,defaultValue = "0") int recId, @ModelAttribute CrmActive crmActive, HttpServletResponse response) throws IOException {
        activityService.save(crmActive);
        response.sendRedirect("/activity/list");
    }
}
