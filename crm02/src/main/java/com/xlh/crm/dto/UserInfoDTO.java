package com.xlh.crm.dto;

import com.xlh.crm.domain.MemberBaseInfo;
import com.xlh.crm.utils.BeanUtil;

import java.io.Serializable;

/**
 * Created by ycp on 2017/3/21.
 */
public class UserInfoDTO extends MemberBaseInfo{
    private String session;

    private MemberBaseInfo info;

    public UserInfoDTO(MemberBaseInfo baseInfo){
        BeanUtil.copyBeanProperties(baseInfo, this);
        this.info = baseInfo;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public MemberBaseInfo getInfo() {
        return info;
    }

    public void setInfo(MemberBaseInfo info) {
        this.info = info;
    }


}
