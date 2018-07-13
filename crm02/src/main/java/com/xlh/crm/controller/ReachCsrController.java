package com.xlh.crm.controller;

import com.alibaba.fastjson.JSON;
import com.xlh.crm.domain.QxbCorpInfo;
import com.xlh.crm.dto.EnterpriseBankListRespDTO;
import com.xlh.crm.dto.RespRestfulDto;
import com.xlh.crm.dto.UserInfoDTO;
import com.xlh.crm.dto.mysql.CrmReachcsr;
import com.xlh.crm.service.CrmModService;
import com.xlh.crm.service.impl.ReachCsrService;
import com.xlh.crm.service.impl.SessionServiceImpl;
import com.xlh.crm.utils.RespCommon;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

@RestController
@RequestMapping("/reachcsr")
public class ReachCsrController {
    private static final Logger logger = LoggerFactory.getLogger(ReachCsrController.class.getName());
    @Autowired
    private ReachCsrService reachCsrService;
    @Autowired
    private SessionServiceImpl sessionService;
    @Autowired
    private CrmModService crmModService;

    @RequestMapping(value = "/govdetail",method = RequestMethod.GET)
    public ModelAndView govdetail(@RequestParam(value = "rchNo",required = false)String rchNo){
        ModelAndView modelAndView=new ModelAndView();
        CrmReachcsr crmReachcsr;
        if(rchNo!=null&&!"".equals(rchNo)){
            crmReachcsr=reachCsrService.findReachByRchNo(rchNo);
        }else{
            crmReachcsr=new CrmReachcsr();
        }
        modelAndView.addObject("crmReachcsr",crmReachcsr);
        modelAndView.setViewName("reachcsr/govdetail");
        modelAndView.addObject("user", sessionService.getUser());
        return modelAndView;
    }

    @RequestMapping(value = "/govdetail",method = RequestMethod.POST)
    public void govdetailPost(@ModelAttribute CrmReachcsr crmReachcsr, HttpServletResponse httpServletResponse) throws IOException {
        UserInfoDTO userInfoDTO=sessionService.getUser();
        crmReachcsr.setRchEmp(userInfoDTO.getUserName());
        crmReachcsr.setCompany(userInfoDTO.getCompany());
        crmReachcsr=reachCsrService.saveReachcsr(crmReachcsr);
       httpServletResponse.sendRedirect("/reachcsr/govdetail?rchNo="+crmReachcsr.getRchNo());
    }



    @RequestMapping(value = "/notcorpdetail",method = RequestMethod.GET)
    public ModelAndView notcorpdetail(@RequestParam(value = "rchNo",required = false)String rchNo){
        ModelAndView modelAndView=new ModelAndView();
        CrmReachcsr crmReachcsr;
        if(rchNo!=null&&!"".equals(rchNo)){
            crmReachcsr=reachCsrService.findReachByRchNo(rchNo);
        }else{
            crmReachcsr=new CrmReachcsr();
        }
        modelAndView.addObject("crmReachcsr",crmReachcsr);
        modelAndView.setViewName("reachcsr/notcorpdetail");
        modelAndView.addObject("user", sessionService.getUser());
        return modelAndView;
    }
    @RequestMapping(value = "/notcorpdetail",method = RequestMethod.POST)
    public void notcorpdetailPost(@ModelAttribute CrmReachcsr crmReachcsr, HttpServletResponse httpServletResponse) throws IOException {
        UserInfoDTO userInfoDTO=sessionService.getUser();
        crmReachcsr.setRchEmp(userInfoDTO.getUserName());
        crmReachcsr.setCompany(userInfoDTO.getCompany());
        crmReachcsr=reachCsrService.saveReachcsr(crmReachcsr);
        httpServletResponse.sendRedirect("/reachcsr/notcorpdetail?rchNo="+crmReachcsr.getRchNo());
    }

    @RequestMapping(value = "/corpdetail",method = RequestMethod.GET)
    public ModelAndView corpdetail(@RequestParam(value = "rchNo",required = false)String rchNo,
                                   @RequestParam(value = "msg",defaultValue = "")String msg){
        ModelAndView modelAndView=new ModelAndView();
        CrmReachcsr crmReachcsr;
        if(rchNo!=null&&!"".equals(rchNo)){
            crmReachcsr=reachCsrService.findReachByRchNo(rchNo);
        }else{
            crmReachcsr=new CrmReachcsr();
        }
        modelAndView.addObject("crmReachcsr",crmReachcsr);
        modelAndView.addObject("msg",msg);
        modelAndView.setViewName("reachcsr/corpdetail");
        modelAndView.addObject("user", sessionService.getUser());
        return modelAndView;
    }
    @RequestMapping(value = "/corpdetail",method = RequestMethod.POST)
    public void corpdetailPost(@ModelAttribute CrmReachcsr crmReachcsr, HttpServletResponse httpServletResponse) throws IOException {
        if(!reachCsrService.checkUpdateId(crmReachcsr)){
            httpServletResponse.sendRedirect("/reachcsr/corpdetail?rchNo="+crmReachcsr.getRchNo()+"&msg="+ URLEncoder.encode("updateId 错误","UTF-8"));
            return;
        }
        UserInfoDTO userInfoDTO=sessionService.getUser();
        crmReachcsr.setRchEmp(userInfoDTO.getUserName());
        crmReachcsr.setCompany(userInfoDTO.getCompany());
        crmReachcsr=reachCsrService.saveReachcsr(crmReachcsr);
        httpServletResponse.sendRedirect("/reachcsr/corpdetail?rchNo="+crmReachcsr.getRchNo());
    }
    @RequestMapping(value = "/qxbCheckName")
    public RespRestfulDto qxbCheckName(@RequestParam(value = "key") String key) {
        logger.info("qxbCheckName start key={}", key);
        try {
            QxbCorpInfo qxbCorpInfo = crmModService.getEntInitDataApi(key);
            logger.info("qxbCheckName qxbCorpInfo={}", JSON.toJSONString(qxbCorpInfo));
            return RespCommon.success(qxbCorpInfo);
        } catch (Exception e) {
            logger.info("qxbCheckName Exception={}", e.getMessage());
            return RespCommon.fail(e);
        }
    }
}
