package com.mj.mall.member.service.impl;

import com.mj.mall.common.base.BaseController;
import com.mj.mall.common.base.ResponseBase;
import com.mj.mall.member.api.service.MemberService;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class MemberServiceImpl extends BaseController implements MemberService {

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
