package com.mj.mall.message.mq;

import com.mj.mall.common.constant.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class ConsumerDistribute {
    private static final Logger log = LoggerFactory.getLogger(ConsumerDistribute.class);


    // 监听消息
    @JmsListener(destination = Constants.EMAIL_QUEUE_NAME)
    public void distribute(String json) {
        log.info("#####消息服务平台接受消息内容:{}#####", json);


    }
}
