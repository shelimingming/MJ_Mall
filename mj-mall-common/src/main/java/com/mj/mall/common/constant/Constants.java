package com.mj.mall.common.constant;

public class Constants {


    // 响应请求成功
    public static String HTTP_RES_CODE_200_VALUE = "success";
    // 系统错误
    public static String HTTP_RES_CODE_500_VALUE = "fial";
    // 响应请求成功code
    public static Integer HTTP_RES_CODE_200 = 200;
    // 系统错误
    public static Integer HTTP_RES_CODE_500 = 500;

    public static Long TOKEN_MEMBER_TIME = Long.parseLong(12 * 60 * 60 * 1000 + "");

    public static final String COOKIE_MEMBER_TOKEN = "COOKIE_MEMBER_TOKEN_";
    public static final int COOKIE_TOKEN_MEMBER_TIME = 12 * 60 * 60 * 1000;

    //发送邮件队列的名称
    public static final String EMAIL_QUEUE_NAME = "email_queue";

    //会员登录的令牌
    public static final String MEMBER_LOGIN_TOKEN = "MEMBER_LOGIN_TOKEN_";

}
