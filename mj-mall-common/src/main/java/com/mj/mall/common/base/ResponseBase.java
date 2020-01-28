package com.mj.mall.common.base;

import com.mj.mall.common.constant.Constants;

public class ResponseBase<T> {
    private boolean isSuccess;
    // 响应code
    private String code;
    // 消息内容
    private String msg;
    // 返回data
    private T data;

    public ResponseBase() {
        this.isSuccess = true;
        this.code = Constants.HTTP_RES_CODE_SUCCESS;
        this.msg = Constants.HTTP_RES_CODE_SUCCESS_VALUE;
    }

    public ResponseBase(String code, String msg, T data) {
        this.isSuccess = false;
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public void setError(String code, String msg) {
        setError(code, msg, null);
    }

    public void setError(String code, String msg, T data) {
        this.isSuccess = false;
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
