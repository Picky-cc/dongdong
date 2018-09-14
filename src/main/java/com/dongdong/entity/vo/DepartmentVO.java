package com.dongdong.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentVO {

    private String departmentUuid;

    @NotNull(message = "部门名字不能为空")
    private String departmentName;

    @NotNull(message = "部门代码不能为空")
    private String departmentCode;

    private String personUuid;

    private String departmentIntroduce;
}
