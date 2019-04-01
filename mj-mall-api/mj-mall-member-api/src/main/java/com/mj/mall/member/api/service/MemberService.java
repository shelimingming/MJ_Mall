package com.mj.mall.member.api.service;

import com.mj.mall.common.base.ResponseBase;
import com.mj.mall.member.api.entity.UserEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@RequestMapping("/member")
public interface MemberService {

    @RequestMapping("/findUserById")
    ResponseBase findUserById(Integer userId);

    @RequestMapping("/register")
    ResponseBase register(@RequestBody UserEntity user);

}
