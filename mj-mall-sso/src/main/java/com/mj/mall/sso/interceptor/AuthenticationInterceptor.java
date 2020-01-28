package com.mj.mall.sso.interceptor;

import com.auth0.jwt.JWT;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.mj.mall.fegin.MemberServiceFegin;
import com.mj.mall.sso.annotation.CheckToken;
import com.mj.mall.member.api.entity.TbMember;
import com.mj.mall.sso.util.JwtUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;


/**
 * jimisun
 */
public class AuthenticationInterceptor implements HandlerInterceptor {

    @Autowired
    private MemberServiceFegin memberService;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object object) throws Exception {

        // 先从请求头中取出 token
        String token = httpServletRequest.getHeader("token");
        if(StringUtils.isEmpty(token)) {
            //如果header中没有取到，从cookie中取
            Cookie[] cookies = httpServletRequest.getCookies();
            if(cookies!=null) {
                for (Cookie cookie : cookies) {
                    if ("token".equals(cookie.getName())) {
                        token = cookie.getValue();
                    }
                }
            }
        }

        // 如果不是映射到方法直接通过
        if (!(object instanceof HandlerMethod)) {
            return true;
        }

        HandlerMethod handlerMethod = (HandlerMethod) object;
        Method method = handlerMethod.getMethod();

        //检查有没有需要用户权限的注解
        if (method.isAnnotationPresent(CheckToken.class)) {
            CheckToken checkToken = method.getAnnotation(CheckToken.class);
            if (checkToken.required()) {
                // 执行认证
                if (token == null) {
                    throw new RuntimeException("无token，请重新登录");
                }
                // 获取 token 中的 user id
                Long userId;
                try {
                    userId = JWT.decode(token).getClaim("id").asLong();
                } catch (JWTDecodeException j) {
                    throw new RuntimeException("访问异常！");
                }
                TbMember tbMember = memberService.findMemberById(userId).getData();
                if (tbMember == null) {
                    throw new RuntimeException("用户不存在，请重新登录");
                }
                Boolean verify = JwtUtils.isVerify(token, tbMember);
                if (!verify) {
                    throw new RuntimeException("非法访问！");
                }
                return true;
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }


}