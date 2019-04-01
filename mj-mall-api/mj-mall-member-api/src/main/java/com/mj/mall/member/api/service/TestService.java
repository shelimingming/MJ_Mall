package com.mj.mall.member.api.service;

import com.mj.mall.common.base.ResponseBase;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@RequestMapping("/test")
public interface TestService {


    @RequestMapping("/testRest")
    Map<String, Object> testRest();


    @RequestMapping("/testResponse")
    ResponseBase testResponse();
}
