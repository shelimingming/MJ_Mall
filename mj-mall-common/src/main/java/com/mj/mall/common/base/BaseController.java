package com.mj.mall.common.base;

import com.mj.mall.common.constant.Constants;
import com.mj.mall.common.redis.BaseRedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BaseController {
    @Autowired
    protected BaseRedisService baseRedisService;

    // 返回成功 ,data值为null
    public ResponseBase setResultSuccess() {
        return setResult(Constants.HTTP_RES_CODE_SUCCESS, Constants.HTTP_RES_CODE_SUCCESS_VALUE, null);
    }

    // 返回成功 ,data可传
    public ResponseBase setResultSuccess(Object data) {
        return setResult(Constants.HTTP_RES_CODE_SUCCESS, Constants.HTTP_RES_CODE_SUCCESS_VALUE, data);
    }

    // 自定义返回结果
    public ResponseBase setResult(String code, String msg, Object data) {
        ResponseBase responseBase = new ResponseBase();
        responseBase.setCode(code);
        responseBase.setMsg(msg);
        if (data != null)
            responseBase.setData(data);
        return responseBase;
    }

}
