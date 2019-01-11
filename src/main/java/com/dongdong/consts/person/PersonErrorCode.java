package com.dongdong.consts.person;

public enum PersonErrorCode {

    PERSON_EXIST("P1001", "处理失败,该人员已存在"),

    PERSON_UUID_IS_NULL("P1002", "用户编码不能为空"),

    PERSON_UPDATE_ERROR("P1003", "用户信息更新失败"),

    CAN_NOT_FIND_PERSON("1006", "未能查询到人员信息"),;

    private String code;
    private String message;

    PersonErrorCode(String code, String message){
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
