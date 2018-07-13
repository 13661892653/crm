package com.xlh.crm.service;

import com.xlh.crm.domain.MemberBaseInfo;

/**
 * Created by heyuan on 2017/3/10.
 */
public interface MemberLoginService {
/*
* 这是登录功能
* memberName 是会员登录名称
* memberPwd   会员登录密码
* @return   返回MemberBaseInfo*/

  public abstract String checkLogin(String memberPhone, String memberPwd);

  public abstract MemberBaseInfo getLoginInfo(String memberPhone);

}
