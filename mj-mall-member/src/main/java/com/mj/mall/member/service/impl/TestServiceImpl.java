package com.mj.mall.member.service.impl;

import com.mj.mall.common.base.BaseController;
import com.mj.mall.common.base.ResponseBase;
import com.mj.mall.member.api.service.TestService;

import java.util.HashMap;
import java.util.Map;

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
}
