package com.dongdong.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonVO {

    private String personName;

    private String idCardNo;

    @Pattern(regexp = "^0$|^1$|^3$|^$", message = "角色分类格式错误")
    private String sex;

    @Pattern(regexp = "^(1|2)(0|9)[0-9]{1}[0-9]{1}-[0-9]{2}-[0-9]{2}$|^$", message = "生日日期格式格式错误")
    private String birthDay;

    private String address;

    private String departmentUuid;

    @Pattern(regexp = "^[0-9]*$|^[0-9]+.[0-9]*$|^$", message = "薪资格式填写错误")
    private String salary;

    @Pattern(regexp = "^(1[0-9]{2})[0-9]{8}$|^$", message = "手机号格式错误")
    private String phoneNo;

    @Pattern(regexp = "^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$|^$", message = "电子邮箱格式错误")
    private String email;

    private String remark;
}
