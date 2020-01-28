package com.mj.mall.sso.api.service;

import com.mj.mall.common.base.ResponseBase;
import com.mj.mall.sso.api.request.LoginReqest;
import com.mj.mall.sso.api.response.LoginResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;

@RequestMapping("/sso")
public interface SSOService {
    /**
     * 登陆
     * @param loginReqest
     * @param httpServletResponse
     * @return
     */
    @PostMapping("/login")
    public ResponseBase<LoginResponse> login(@RequestBody LoginReqest loginReqest, HttpServletResponse httpServletResponse);
}
