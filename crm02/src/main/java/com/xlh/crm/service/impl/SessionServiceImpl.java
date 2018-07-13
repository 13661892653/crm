package com.xlh.crm.service.impl;

import com.xlh.crm.dto.UserInfoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class SessionServiceImpl {
    @Autowired
    private HttpSession httpSession;
    public UserInfoDTO getUser(){
        UserInfoDTO userInfoDTO= (UserInfoDTO)httpSession.getAttribute("userInfo");
        return userInfoDTO;
    }

    public void setUser(UserInfoDTO user){
        httpSession.setAttribute("userInfo",user);
    }

    public void removeUser(){
        httpSession.removeAttribute("userInfo");
    }
}
