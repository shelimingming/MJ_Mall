package com.mj.mall.common.base;

public class ResponseBase {
    // 响应code
    private Integer code;
    // 消息内容
    private String msg;
    // 返回data
    private Object data;

    public ResponseBase() {
    }

    public ResponseBase(Integer code, String msg, Object data) {
        super();
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}
