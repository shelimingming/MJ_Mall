package com.mj.mall.member.api.service;

import com.mj.mall.common.base.ResponseBase;
import com.mj.mall.member.api.entity.UserEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/member")
public interface MemberService {

    //根据id查询用户
    @RequestMapping("/findUserById")
    ResponseBase findUserById(Integer userId);

    //用户注册
    @RequestMapping("/register")
    ResponseBase register(@RequestBody UserEntity user);

    // 用户登录
    @RequestMapping("/login")
    ResponseBase login(@RequestBody UserEntity user);

    // 使用token进行登录
    @RequestMapping("/findByTokenUser")
    ResponseBase findByTokenUser(@RequestParam("token") String token);
}
