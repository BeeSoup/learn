package com.zhangyu.ali.server.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public final class ResponseData<T> implements Serializable {

    private Integer code;
    private String message;
    private T data;

    public ResponseData() {
        this.code = Status.SUCCESS.code;
        this.message = Status.SUCCESS.getReason();
    }

    public ResponseData(Integer code, String message) {
        this(code, message, null);
    }

    private ResponseData(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public ResponseData(T data) {
        this();
        this.data = data;
    }

    public static ResponseData ok() {
        ResponseData<Object> responseData = new ResponseData();
        responseData.setCode(Status.SUCCESS.getCode());
        responseData.setMessage(Status.SUCCESS.getReason());
        return responseData;
    }

    public static ResponseData ok(Object data) {
        ResponseData<Object> responseData = new ResponseData();
        responseData.setCode(Status.SUCCESS.getCode());
        responseData.setMessage(Status.SUCCESS.getReason());
        responseData.setData(data);
        return responseData;
    }

    public static ResponseData ok(String message, Object... data) {
        return new ResponseData(Status.SUCCESS.getCode(), message, data);
    }

    public static ResponseData ok(Integer code, String message, Object data) {
        return new ResponseData(code, message, data);
    }

    public static ResponseData error() {
        return new ResponseData(Status.INTERNAL_SERVER_ERROR.getCode(), Status.INTERNAL_SERVER_ERROR.getReason());
    }

    @Deprecated
    public static ResponseData error(Status status) {
        ResponseData responseMessage = new ResponseData();
        responseMessage.setCode(Status.INTERNAL_SERVER_ERROR.getCode());
        responseMessage.setMessage(Status.INTERNAL_SERVER_ERROR.getReason());
        return responseMessage;
    }

    public static ResponseData error(Integer code, String message) {
        return new ResponseData(code, message);
    }

    public static ResponseData fail() {
        return new ResponseData(Status.INTERNAL_SERVER_ERROR.getCode(), Status.INTERNAL_SERVER_ERROR.getReason());
    }

    @Deprecated
    public static ResponseData fail(Status status) {
        ResponseData responseMessage = new ResponseData();
        responseMessage.setCode(Status.INTERNAL_SERVER_ERROR.getCode());
        responseMessage.setMessage(Status.INTERNAL_SERVER_ERROR.getReason());
        return responseMessage;
    }


    public static ResponseData fail(Integer code, String reason) {
        return new ResponseData(code, reason);
    }

    public static enum Status {
        SUCCESS(200, "成功"),
        BAD_REQUEST(404, "请求无效"),
        INTERNAL_SERVER_ERROR(500, "服务器错误"),
        ARGUMENT_VANISH(501, "缺少参数"),
        ARGUMENT_TYPE_MISMATCH(502, "类型错误"),
        ARGUMENT_CONSTRAINT_VIOLATION(503, "参数校验错误");

        private final Integer code;
        private final String reason;

        private Status(Integer code, String reason) {
            this.code = code;
            this.reason = reason;
        }

        public Integer getCode() {
            return this.code;
        }

        public String getReason() {
            return this.reason;
        }
    }
}
