package com.mj.mall.web.controller;

import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mj.mall.common.base.ResponseBase;
import com.mj.mall.common.constant.Constants;
import com.mj.mall.common.utils.CookieUtil;
import com.mj.mall.member.api.entity.UserEntity;
import com.mj.mall.web.fegin.MemberServiceFegin;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class LoginController {
	@Autowired
	private MemberServiceFegin memberServiceFegin;
	private static final String LOGIN = "login";
	private static final String INDEX = "redirect:/";
	private static final String qqrelation = "qqrelation";
	// 跳转登录页面
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginGet() {
		return LOGIN;
	}

	// 登录请求具体提交实现
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginPost(UserEntity userEntity, HttpServletRequest request, HttpServletResponse response) {
		// 1.验证参数
		// 2.调用登录接口，获取token信息
		ResponseBase loginBase = memberServiceFegin.login(userEntity);
		if (!loginBase.getCode().equals(Constants.HTTP_RES_CODE_200)) {
			request.setAttribute("error", "账号或者密码错误!");
			return LOGIN;
		}

		LinkedHashMap loginData = (LinkedHashMap) loginBase.getData();
		String memberToken = (String) loginData.get("memberToken");
		if (StringUtils.isEmpty(memberToken)) {
			request.setAttribute("error", "会话已经失效!");
			return LOGIN;
		}
		// 3.将token信息存放在cookie里面
		setCookie(memberToken, response);
		return INDEX;
	}
	public void setCookie(String memberToken, HttpServletResponse response){
		CookieUtil.addCookie(response, Constants.COOKIE_MEMBER_TOKEN, memberToken, Constants.COOKIE_TOKEN_MEMBER_TIME);
	}


}
