package com.mj.mall.test.expect;

import java.util.Arrays;

public class ExpectJsonObject {
    private Object result;
    private String[] ignore;

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public String[] getIgnore() {
        return ignore;
    }

    public void setIgnore(String[] ignore) {
        this.ignore = ignore;
    }

    @Override
    public String toString() {
        return "ExpectJsonObject{" +
                "result=" + result +
                ", ignore=" + Arrays.toString(ignore) +
                '}';
    }
}
