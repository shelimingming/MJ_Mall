package com.mj.mall.common;

public class MJException extends RuntimeException {
    private String errorCode;
    private String errorMsg;

    private MJException(){
        super();
    }

    private MJException(String code,String msg) {
        this.errorCode = code;
        this.errorMsg = msg;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    @Override
    public String toString() {
        return "MJException{" +
                "errorCode='" + errorCode + '\'' +
                ", errorMsg='" + errorMsg + '\'' +
                '}';
    }
}
