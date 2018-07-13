package com.xlh.crm.controller;


import com.xlh.crm.common.CurrentTime;
import com.xlh.crm.data.OperationLogCode;
import com.xlh.crm.dto.EmbedDTO;
import com.xlh.crm.dto.MemberInfoDTO;
import com.xlh.crm.dto.OperationLogDTO;
import com.xlh.crm.dto.UserInfoDTO;
import com.xlh.crm.mapper.CrmMapper;
import com.xlh.crm.service.EmbedService;
import com.xlh.crm.service.MemberLoginService;
import com.xlh.crm.service.impl.SessionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;


/**
 * Created by heyuan on 2017/3/13.
 */
@Controller
public class LoginController {
    @Autowired
    private MemberLoginService memberLoginService;

    @Autowired
    private SessionServiceImpl sessionService;
    @Autowired
    EmbedService embedService;

    @Autowired
    CrmMapper crmMapper;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(String memberPhone, String memberPwd, HttpServletResponse response) throws Exception {
        ModelAndView model = new ModelAndView("login");
        //获取登录名和密码
        MemberInfoDTO memberLoginDTO = new MemberInfoDTO();
        memberLoginDTO.setMemberPhone(memberPhone);
        memberLoginDTO.setMemberPwd(memberPwd);
        //验证登录
        String msg = memberLoginService.checkLogin(memberLoginDTO.getMemberPhone(), memberLoginDTO.getMemberPwd());
        if ("登录成功".equals(msg)) {

            response.sendRedirect("/data/keyindex");
            EmbedDTO dto = new EmbedDTO();
            dto.setPage("http://localhost:8080/login");
            dto.setContentId("1001");
            dto.setContent("login_success");
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            dto.setDate(sdf.format(new Date()));
            UserInfoDTO udto = sessionService.getUser();
            if(null != udto){
                dto.setMemberId(udto.getMemberId());
                dto.setUserName(udto.getUserName());
            }

            //记录登录日志
            OperationLogDTO operationLogDTO = new OperationLogDTO(); //操作日志信息
            operationLogDTO.setOperator(sessionService.getUser().getUserName());  //操作人
            operationLogDTO.setOperationTime(CurrentTime.getCurrentTime()); //设置操作事件
            operationLogDTO.setEventType(OperationLogCode.OPERATION_LOGIN); //设置操作事件
            operationLogDTO.setModule(OperationLogCode.MODULE_CRM_LOGIN); //设置业务模块
            operationLogDTO.setOperationDesc("login_phone:".concat(memberLoginDTO.getMemberPhone())); //设置操作内容
            int optFlag = crmMapper.insertOperationLog(operationLogDTO);  //日志入库

            embedService.writeLog(dto);
            return null;
        }else {
            model.addObject("msg", msg);
            return model;
        }
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView loginGet() throws Exception {
        ModelAndView model = new ModelAndView("login");
        return model;
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ModelAndView logOut() throws Exception {
        ModelAndView model = new ModelAndView("login");
        UserInfoDTO dto = sessionService.getUser();
        if(dto == null){
            return model;
        }
        sessionService.removeUser();
        return model;
    }


}