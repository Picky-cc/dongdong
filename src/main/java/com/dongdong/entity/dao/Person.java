package com.dongdong.entity.dao;

import com.dongdong.entity.enumeration.SexEnum;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * @author zhaodexu
 */
@Data
public class Person {
    private Long id;

    private String personUuid;

    private String personName;

    private String idCardNo;

    private SexEnum sex;

    private Date birthDay;

    private String address;

    private String departmentUuid;

    private BigDecimal salary;

    private String phoneNo;

    private String email;

    private String remark;

    private Date gmtCreate;

    private Date gmtModified;

    private String version;

    private Department department;
}