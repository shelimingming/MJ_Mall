package com.mj.mall.member.service.impl;

import com.mj.mall.common.base.BaseController;
import com.mj.mall.common.base.ResponseBase;
import com.mj.mall.member.api.service.TestService;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class TestServiceImpl extends BaseController implements TestService {
    @Override
    public Map<String, Object> testRest() {
        Map<String, Object> result = new HashMap<>();
        result.put("errorCode", "200");
        result.put("errorMsg", "success");
        return result;
    }

    @Override
    public ResponseBase testResponse() {
        return setResultSuccess("测试BaseController");
    }

    @Override
    public ResponseBase setRedis(String key, String value) {
        baseRedisService.setString(key, value);
        return setResultSuccess();
    }

    @Override
    public ResponseBase getRedis(String key) {
        String value = baseRedisService.getString(key);
        return setResultSuccess(value);
    }

}
