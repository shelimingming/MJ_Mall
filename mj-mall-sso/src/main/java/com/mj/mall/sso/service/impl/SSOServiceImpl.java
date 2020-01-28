package com.mj.mall.sso.service.impl;

import com.mj.mall.fegin.MemberServiceFegin;
import com.mj.mall.member.api.constant.MemberErrorCodeEnum;
import com.mj.mall.sso.annotation.CheckToken;
import com.mj.mall.common.base.ResponseBase;
import com.mj.mall.member.api.entity.TbMember;
import com.mj.mall.sso.api.request.LoginReqest;
import com.mj.mall.sso.api.response.LoginResponse;
import com.mj.mall.sso.api.service.SSOService;
import com.mj.mall.sso.util.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@RestController
public class SSOServiceImpl implements SSOService {
    @Autowired
    private MemberServiceFegin memberService;

    //查看个人信息
    @CheckToken
    @GetMapping("/getMessage")
    public String getMessage() {
        return "你已通过验证";
    }

    /**
     * 登陆
     *
     * @param loginReqest
     * @param httpServletResponse
     * @return
     */
    @Override
    public ResponseBase<LoginResponse> login(@RequestBody LoginReqest loginReqest, HttpServletResponse httpServletResponse) {
        ResponseBase<LoginResponse> response = new ResponseBase<LoginResponse>();

        ResponseBase<TbMember> findMemberByNameResponse = memberService.findMemberByName(loginReqest.getMemberName());
        TbMember tbMember = findMemberByNameResponse.getData();
        if (tbMember == null) {
            //用户不存在
            response.setSuccess(false);
            response.setCode(MemberErrorCodeEnum.MEMBER_NOT_EXIST.getErrorCode());
            response.setMsg(MemberErrorCodeEnum.MEMBER_NOT_EXIST.getErrorMsg());
            return response;
        } else {
            if (!tbMember.getPassword().equals(loginReqest.getPassword())) {
                //用户名密码错误
                response.setSuccess(false);
                response.setCode(MemberErrorCodeEnum.PASSWORD_WORNG.getErrorCode());
                response.setMsg(MemberErrorCodeEnum.PASSWORD_WORNG.getErrorMsg());
                return response;
            } else {
                String token = JwtUtils.createJWT(6000000, tbMember);

                //将token保存到cookie中
                Cookie cookie = new Cookie("token", token);
                cookie.setMaxAge(3600);
                httpServletResponse.addCookie(cookie);

                LoginResponse loginResponse = new LoginResponse();
                loginResponse.setMember(tbMember);
                loginResponse.setToken(token);
                response.setData(loginResponse);

                return response;
            }
        }
    }
}
