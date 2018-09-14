package com.dongdong.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonDTO {

    private String personUuid;

    private String personName;

    private String idCardNo;

    private String sex;

    private String birthDay;

    private String address;

    private String departmentUuid;

    private String departmentName;

    private String salary;

    private String phoneNo;

    private String email;

    private String remark;

    private String gmtCreate;

    private String gmtModified;
}
