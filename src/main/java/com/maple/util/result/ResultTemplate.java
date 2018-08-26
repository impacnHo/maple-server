package com.maple.util.result;

/**
 * 响应结果生成工具
 */
public class ResultTemplate {
    private static final String SUCCESS = "success";

    //成功
    public static Result getSuccessResult() {
        return new Result()
                .setCode(ResultCode.SUCCESS)
                .setMessage(SUCCESS);
    }

    //成功，附带额外数据
    public static Result getSuccessResult(Object data) {
        return new Result()
                .setCode(ResultCode.SUCCESS)
                .setMessage(SUCCESS)
                .setData(data);
    }

    //成功，自定义消息及数据
    public static Result getSuccessResult(String message, Object data) {
        return new Result()
                .setCode(ResultCode.SUCCESS)
                .setMessage(message)
                .setData(data);
    }

    //失败，附带消息
    public static Result getFailResult(String message) {
        return new Result()
                .setCode(ResultCode.FAIL)
                .setMessage(message);
    }

    //失败，自定义消息及数据
    public static Result getFailResult(String message, Object data) {
        return new Result()
                .setCode(ResultCode.FAIL)
                .setMessage(message)
                .setData(data);
    }

    //自定义创建
    public static Result getFreeResult(ResultCode code, String message, Object data) {
        return new Result()
                .setCode(code)
                .setMessage(message)
                .setData(data);
    }
}
