package com.dongdong.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentDTO {

    private String departmentUuid;

    private String departmentName;

    private String departmentCode;

    private String personUuid;

    private String personName;

    private String phoneNo;

    private String email;

    private String departmentIntroduce;

    private String gmtCreate;

    private String gmtModified;
}
