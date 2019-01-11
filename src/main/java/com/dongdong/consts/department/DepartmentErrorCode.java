package com.dongdong.consts.department;

public enum DepartmentErrorCode {

    DEPARTMENT_UUID_IS_NULL("D1001", "部门编码不能为空"),

    DEPARTMENT_UPDATE_ERROR("D1002", "部门信息更新失败"),

    DEPARTMENT_EXIST("D1003", "新增失败,该部门已存在"),

    CAN_NOT_FIND_DEPARTMENT("D1004", "未能查询到部门信息"),;

    private String code;
    private String message;

    DepartmentErrorCode(String code, String message){
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
