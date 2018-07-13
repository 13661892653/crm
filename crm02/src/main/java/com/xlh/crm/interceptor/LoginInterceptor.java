package com.xlh.crm.interceptor;

import com.xlh.crm.domain.MemberBaseInfo;
import com.xlh.crm.dto.UserInfoDTO;
import com.xlh.crm.service.impl.SessionServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

;

/**
 * Created by ycp on 2017/3/18.
 */
public class LoginInterceptor implements HandlerInterceptor {
    private static Logger logger= LoggerFactory.getLogger(LoginInterceptor.class);


    public LoginInterceptor() {
    }

    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        String scheme = httpServletRequest.getScheme();
        String serverName = httpServletRequest.getServerName();
        int port = httpServletRequest.getServerPort();
        String path = httpServletRequest.getContextPath();
        String url=httpServletRequest.getRequestURL().toString();
        String basePath = scheme + "://" + serverName + ":" + port + path;
        logger.info("request url={}",url);
        httpServletRequest.setAttribute("basePath", basePath);
        if (httpServletRequest.getServletPath().indexOf("/login") != -1||httpServletRequest.getServletPath().indexOf("/error") != -1) {
            return true;
        }else if(httpServletRequest.getServletPath().indexOf("/applyMember") != -1){
            return true;
        }else{
            UserInfoDTO userInfo1=(UserInfoDTO)httpServletRequest.getSession().getAttribute("userInfo");
            if(userInfo1==null){
                httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/login");
                return false;
            }
            return true;
        }
    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
    }


}