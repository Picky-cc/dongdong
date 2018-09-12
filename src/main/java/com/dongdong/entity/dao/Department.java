package com.dongdong.entity.dao;

import java.util.Date;
import lombok.Data;

@Data
public class Department {
    private Long id;

    private String departmentUuid;

    private String departmentName;

    private String departmentCode;

    private String personUuid;

    private String departmentIntroduce;

    private Date gmtCreate;

    private Date gmtModified;
}