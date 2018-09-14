package com.dongdong.consts;

public enum ResponseCode {

    SUCCESS("0000", "处理成功"),

    REQUEST_METHOD_ERROR("1001", "Http请求方法错误"),

    PARAMETER_ERROR("1002", "参数格式错误"),

    PERSON_EXIST("1003", "新增失败,该人员已存在"),

    PERSON_UUID_IS_NULL("1004", "用户编码不能为空"),

    CAN_NOT_FIND("1005", "查询结果不存在"),

    DEPARTMENT_EXIST("1006", "新增失败,该部门已存在"),

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
