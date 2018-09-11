package com.dongdong.consts;

public enum ResponseCode {

    SUCCESS("0000", "处理成功"),

    REQUEST_METHOD_ERROR("1001", "Http请求方法错误"),

    SYSTEM_ERROR("9999", "系统未知异常,请联系系统管理员");

    private String code;
    private String message;

    ResponseCode(String code, String message){
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
