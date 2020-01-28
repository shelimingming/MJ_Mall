package com.mj.mall.web.controller;

import com.mj.mall.common.base.ResponseBase;
import com.mj.mall.member.api.entity.TbMember;
import com.mj.mall.web.fegin.MemberServiceFegin;
import com.mj.mall.web.request.RegisterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;


@Controller
public class RegisterController {
    @Autowired
    private MemberServiceFegin memberServiceFegin;
    private static final String REGISTER = "register";
    private static final String LOGIN = "login";

    // 跳转注册页面
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registerGet() {
        return "register";
    }

    // 注册业务具体实现
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerPost(RegisterRequest registerRequest, HttpServletRequest httpServletRequest) {
        // 1. 验证参数
        // 2. 调用会员注册接口
        TbMember tbMember = new TbMember();
        tbMember.setMemberName(registerRequest.getMemberName());
        tbMember.setMobile(registerRequest.getMobile());
        tbMember.setPassword(registerRequest.getPassword());
        ResponseBase<Object> registerResponse = memberServiceFegin.register(tbMember);
        // 3. 如果失败，跳转到失败页面
        if (!registerResponse.isSuccess()) {
            httpServletRequest.setAttribute("error", "註冊失敗");
            return REGISTER;
        }
        // 4. 如果成功,跳转到成功页面
        return LOGIN;
    }
}
