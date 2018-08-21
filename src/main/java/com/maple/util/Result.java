package com.maple.util;

import javafx.beans.binding.ObjectExpression;

/**
 * 统一API响应结果封装
 */
public class Result {
    private int code;
    private Object message;
    private Object data;

    public Result() {}

    public int getCode() {
        return code;
    }

    public Result setCode(ResultCode resultCode) {
        this.code = resultCode.getCode();
        return this;
    }

    public Object getMessage() {
        return message;
    }

    public Result setMessage(Object message) {
        this.message = message;
        return this;
    }

    public Object getData() {
        return data;
    }

    public Result setData(Object data) {
        this.data = data;
        return this;
    }

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}