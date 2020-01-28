package com.mj.mall.sso.api.response;

import com.mj.mall.member.api.entity.TbMember;

/**
 * 登陆返回值
 */
public class LoginResponse {
    private String token;
    private TbMember member;

    public LoginResponse() {
    }

    public LoginResponse(String token, TbMember member) {
        this.token = token;
        this.member = member;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public TbMember getMember() {
        return member;
    }

    public void setMember(TbMember member) {
        this.member = member;
    }

    @Override
    public String toString() {
        return "LoginResponse{" +
                "token='" + token + '\'' +
                ", member=" + member +
                '}';
    }
}
