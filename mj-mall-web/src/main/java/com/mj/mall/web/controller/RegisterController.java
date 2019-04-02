package com.mj.mall.web.controller;

import javax.servlet.http.HttpServletRequest;

import com.mj.mall.common.base.ResponseBase;
import com.mj.mall.common.constant.Constants;
import com.mj.mall.member.api.entity.UserEntity;
import com.mj.mall.web.fegin.MemberServiceFegin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class RegisterController {
    @Autowired
    private MemberServiceFegin memberServiceFegin;
    private static final String REGISTER = "register";
    private static final String LOGIN = "login";

    // 跳转注册页面
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registerGet() {
        return REGISTER;
    }

    // 注册业务具体实现
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerPost(UserEntity userEntity, HttpServletRequest reqest) {
        // 1. 验证参数
        // 2. 调用会员注册接口
        ResponseBase regUser = memberServiceFegin.register(userEntity);
        // 3. 如果失败，跳转到失败页面
        if (!regUser.getCode().equals(Constants.HTTP_RES_CODE_200)) {
            reqest.setAttribute("error", "註冊失敗");
            return REGISTER;
        }
        // 4. 如果成功,跳转到成功页面
        return LOGIN;
    }
}
