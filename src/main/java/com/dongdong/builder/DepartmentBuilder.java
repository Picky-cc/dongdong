package com.dongdong.builder;

import com.dongdong.entity.dao.Department;
import com.dongdong.entity.vo.DepartmentVO;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component("departmentBuilder")
public class DepartmentBuilder {

    public Department buildeDepartmentByVO(DepartmentVO departmentVO){
        Department department = new Department();
        department.setDepartmentName(departmentVO.getDepartmentName());
        department.setDepartmentCode(departmentVO.getDepartmentCode());
        department.setDepartmentIntroduce(departmentVO.getDepartmentIntroduce());
        department.setPersonUuid(departmentVO.getPersonUuid());
        department.setGmtModified(new Date());
        return department;
    }
}
