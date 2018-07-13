package com.xlh.crm.service.impl;

import com.xlh.crm.domain.MemberBaseInfo;
import com.xlh.crm.dto.MemberInfoDTO;
import com.xlh.crm.dto.UserInfoDTO;
import com.xlh.crm.mapper.MemberLoginExtMapper;
import com.xlh.crm.service.MemberLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Created by heyuan on 2017/3/10.
 * 会员操作实体类
 * 用集合实现
 */
@Service
public class MemberLoginServiceImpl implements MemberLoginService {
    @Autowired
    private MemberLoginExtMapper memberLoginExtMapper;

    @Autowired
    private SessionServiceImpl sessionService;

    @Override
    //根据登录域用户获取用户信息
    public MemberBaseInfo getLoginInfo(String domainUserName) {

        MemberBaseInfo memberBaseInfo = memberLoginExtMapper.selectByDomainUserName(domainUserName);
        return memberBaseInfo;
    }

    @Override
    //验证登录
    public String checkLogin(String memberPhone, String memberPwd) {

        MemberBaseInfo memberBaseInfo = memberLoginExtMapper.selectByMemberPhone(memberPhone);
        MemberInfoDTO memberInfoDTO= new MemberInfoDTO();
        if(memberBaseInfo != null){
            memberInfoDTO.setMemberPhone(memberBaseInfo.getMemberPhone());
            memberInfoDTO.setMemberPwd(memberBaseInfo.getMemberPwd());
            memberInfoDTO.setAuditStatus(memberBaseInfo.getAuditStatus());
        }
        String message = "";
        //用户名不为空
        if (null != memberInfoDTO.getMemberPhone()) {
              if (memberInfoDTO.getAuditStatus() !=0) {
                  //用户名存在
                 /*  if (memberPhone.equals(memberLoginDto.getMemberPhone())) {*/
                       //密码不为空
                       if ( !memberPwd.equals("")) {
                           //密码正确 登录成功
                           if (memberPwd.equals(memberInfoDTO.getMemberPwd())) {
                               message = "登录成功";

                               UserInfoDTO userInfo = new UserInfoDTO(memberBaseInfo);
                               userInfo.setSession("");
                               sessionService.setUser(userInfo);
                           } else {
                               message = "用户名或密码不正确";
                           }
                           //密码为空
                       } else {
                           message = "密码不能为空";
                       }

               } else {
                   message = "用户审核没有通过";
               }
           }else {
               message = "用户不存在或已失效";
           }
        return message;
    }
}
