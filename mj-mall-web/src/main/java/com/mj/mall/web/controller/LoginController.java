package com.mj.mall.web.controller;

import com.mj.mall.common.base.ResponseBase;
import com.mj.mall.sso.api.request.LoginReqest;
import com.mj.mall.sso.api.response.LoginResponse;
import com.mj.mall.web.fegin.MemberServiceFegin;
import com.mj.mall.web.fegin.SSOServiceFegin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;


@Controller
public class LoginController {
    @Autowired
    private MemberServiceFegin memberServiceFegin;

    @Autowired
    private SSOServiceFegin ssoService;

    private static final String LOGIN = "login";
    private static final String INDEX = "redirect:/";

    // 跳转登录页面
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginGet() {
        return LOGIN;
    }

    // 登录请求具体提交实现
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginPost(String memberName, String password, HttpServletResponse httpServletResponse) {
        LoginReqest loginReqest = new LoginReqest();
        loginReqest.setMemberName(memberName);
        loginReqest.setPassword(password);

        ResponseBase<LoginResponse> loginResponse = ssoService.login(loginReqest);

        if (loginResponse.isSuccess()) {
            return INDEX;
        }

        return LOGIN;
    }


}
