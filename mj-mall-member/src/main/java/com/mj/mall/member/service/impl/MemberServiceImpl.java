package com.mj.mall.member.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.mj.mall.common.base.BaseController;
import com.mj.mall.common.base.ResponseBase;
import com.mj.mall.common.constant.Constants;
import com.mj.mall.common.utils.MD5Util;
import com.mj.mall.member.api.entity.UserEntity;
import com.mj.mall.member.api.service.MemberService;
import com.mj.mall.member.mapper.UserMapper;
import com.mj.mall.member.mq.MailboxProducer;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class MemberServiceImpl extends BaseController implements MemberService {


    private static final String REGISTER_TITLE = "欢迎注册MJ Mall会员";
    private static final String REGISTER_TEXT = "欢迎注册MJ Mall会员，买你想买";

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private MailboxProducer mailboxProducer;

    @Override
    public ResponseBase findUserById(Integer userId) {
        UserEntity userEntity = userMapper.findByID(userId);
        if (userEntity == null) {
            return setResultError("为查找到该用户信息");
        }
        return setResultSuccess(userEntity);

    }

    @Override
    public ResponseBase register(@RequestBody UserEntity user) {
        //对密码进行加密
        decodePassword(user);
        //设置用户的创建和修改时间
        setCreateAndUpdateTime(user);

        Integer result = userMapper.insertUser(user);


        if (result <= 0) {
            return setResultError("注册失败");
        }

        //通过消息队列发送邮件给用户
        sendEmail(user);
        return setResultSuccess();
    }


    //对密码进行加密
    private void decodePassword(UserEntity user) {
        String passWord = user.getPassword();
        String newPassWord = MD5Util.MD5(passWord);
        user.setPassword(newPassWord);
    }

    //设置用户的创建和修改时间
    private void setCreateAndUpdateTime(UserEntity user) {
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
    }

    //通过消息队列发送邮件给用户
    private void sendEmail(UserEntity user) {
        String email = user.getEmail();
        String message = buildMessage(email);

        ActiveMQQueue activeMQQueue = new ActiveMQQueue(Constants.EMAIL_QUEUE_NAME);
        mailboxProducer.sendMsg(activeMQQueue, message);
    }

    private String buildMessage(String mail) {
        /**
         * {
         *     "header": {
         *         "interfaceType": "接口类型"
         *     },
         *     "content": {}
         * }
         */
        JSONObject root = new JSONObject();
        JSONObject header = new JSONObject();
        header.put("interfaceType", "sms_mail");
        JSONObject content = new JSONObject();
        content.put("mail", mail);
        content.put("title", REGISTER_TITLE);
        content.put("text", REGISTER_TEXT);
        root.put("header", header);
        root.put("content", content);
        return root.toJSONString();
    }

}
