package com.mj.mall.common.utils;

import com.mj.mall.common.constant.Constants;

import java.util.UUID;

public class TokenUtils {
    public static String getLoginToken() {
        return Constants.MEMBER_LOGIN_TOKEN + UUID.randomUUID();
    }

}
