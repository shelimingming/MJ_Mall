package com.mj.mall.member.api.service;

import com.mj.mall.common.base.ResponseBase;
import com.mj.mall.member.api.entity.TbMember;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/member")
public interface MemberService {

    //根据id查询用户
    @RequestMapping("/findUserById")
    ResponseBase<TbMember> findMemberById(@RequestParam("memberId") Long memberId);

    //根据用户名查询用户
    @RequestMapping("/findUserByName")
    ResponseBase<TbMember> findMemberByName(@RequestParam("memberName") String memberName);

    //用户注册
    @RequestMapping("/register")
    ResponseBase<Object> register(@RequestBody TbMember member);

    // 使用token进行登录
    @RequestMapping("/findByTokenUser")
    ResponseBase findByTokenUser(@RequestParam("token") String token);
}
