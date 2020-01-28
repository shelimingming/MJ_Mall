package com.mj.mall.web.request;

public class RegisterRequest {
    /**
     * 会员姓名
     */
    private String memberName;

    /**
     * 登录密码
     */
    private String password;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 短信验证码
     */
    private String messageCode;

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

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getMessageCode() {
        return messageCode;
    }

    public void setMessageCode(String messageCode) {
        this.messageCode = messageCode;
    }
}
