package com.dongdong.consts;

public enum ResponseCode {

    SUCCESS("0000", "处理成功"),

    REQUEST_METHOD_ERROR("1001", "Http请求方法错误"),

    PARAMETER_ERROR("1002", "参数格式错误"),

    CAN_NOT_FIND("1006", "查询结果不存在"),

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
