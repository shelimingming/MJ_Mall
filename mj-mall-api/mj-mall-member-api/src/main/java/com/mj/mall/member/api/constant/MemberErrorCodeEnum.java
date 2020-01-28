package com.mj.mall.member.api.constant;

/**
 * 用户相关错误码
 * 01_开头
 */
public enum MemberErrorCodeEnum{
    MEMBER_NOT_EXIST("01_0001","用户不存在"),
    PASSWORD_WORNG("01_0002","密码错误"),
    REGISTER_ERROR("01_0003","注册失败"),
    ;
    private String errorCode;
    private String errorMsg;

    MemberErrorCodeEnum(String errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    @Override
    public String toString() {
        return "ErrorCodeEnum{" +
                "errorCode='" + errorCode + '\'' +
                ", errorMsg='" + errorMsg + '\'' +
                '}';
    }
}
