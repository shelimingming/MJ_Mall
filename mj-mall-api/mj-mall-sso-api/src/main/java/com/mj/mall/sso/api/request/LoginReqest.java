package com.mj.mall.sso.api.request;

/**
 * 登陆入参
 */
public class LoginReqest {
    private String memberName;
    private String password;

    public LoginReqest() {
    }

    public LoginReqest(String memberName, String password) {
        this.memberName = memberName;
        this.password = password;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginReqest{" +
                "memberName='" + memberName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
