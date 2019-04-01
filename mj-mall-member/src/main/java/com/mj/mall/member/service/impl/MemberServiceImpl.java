package com.mj.mall.member.service.impl;

import com.mj.mall.common.base.BaseController;
import com.mj.mall.common.base.ResponseBase;
import com.mj.mall.common.utils.MD5Util;
import com.mj.mall.member.api.entity.UserEntity;
import com.mj.mall.member.api.service.MemberService;
import com.mj.mall.member.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberServiceImpl extends BaseController implements MemberService {

    @Autowired
    private UserMapper userMapper;



    @Override
    public ResponseBase findUserById(Integer userId) {
        UserEntity userEntity = userMapper.findByID(userId);
        if(userEntity==null){
            return setResultError("为查找到该用户信息");
        }
        return setResultSuccess(userEntity);

    }

    @Override
    public ResponseBase register(@RequestBody UserEntity user) {
        //对密码进行加密
        decodePassword(user);

        Integer result = userMapper.insertUser(user);

        if(result <= 0) {
            return setResultError("注册失败");
        }
        return setResultSuccess();
    }

    private void decodePassword(UserEntity user) {
        String passWord=user.getPassword();
        String newPassWord= MD5Util.MD5(passWord);
        user.setPassword(newPassWord);
    }

}
