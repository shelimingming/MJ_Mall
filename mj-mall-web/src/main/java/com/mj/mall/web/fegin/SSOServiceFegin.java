package com.mj.mall.web.fegin;

import com.mj.mall.common.base.ResponseBase;
import com.mj.mall.sso.api.request.LoginReqest;
import com.mj.mall.sso.api.response.LoginResponse;
import com.mj.mall.sso.api.service.SSOService;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;


@Component
@FeignClient("sso")
@RequestMapping("/sso")
public interface SSOServiceFegin{
    /**
     * 登陆
     * @param loginReqest
     * @return
     */
    @PostMapping("/login")
    public ResponseBase<LoginResponse> login(@RequestBody LoginReqest loginReqest);

}
