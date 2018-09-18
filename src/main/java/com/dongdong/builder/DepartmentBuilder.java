package com.dongdong.builder;

import com.dongdong.consts.GlobalConst;
import com.dongdong.entity.dao.Department;
import com.dongdong.entity.dao.Person;
import com.dongdong.entity.dto.DepartmentDTO;
import com.dongdong.entity.vo.DepartmentVO;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Objects;

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

    public DepartmentDTO buildeDepartmentDTO(Department department){
        DepartmentDTO departmentDTO = new DepartmentDTO();
        departmentDTO.setDepartmentUuid(department.getDepartmentUuid());
        departmentDTO.setDepartmentName(department.getDepartmentName());
        departmentDTO.setDepartmentCode(department.getDepartmentCode());
        departmentDTO.setPersonUuid(department.getPersonUuid());
        Person person = department.getPerson();
        departmentDTO.setPersonName(Objects.isNull(person) ? StringUtils.EMPTY : person.getPersonName());
        departmentDTO.setPhoneNo(Objects.isNull(person) ? StringUtils.EMPTY : person.getPhoneNo());
        departmentDTO.setEmail(Objects.isNull(person) ? StringUtils.EMPTY : person.getEmail());
        departmentDTO.setDepartmentIntroduce(department.getDepartmentIntroduce());
        departmentDTO.setGmtCreate(new DateTime(department.getGmtCreate()).toString(GlobalConst.DATE_FORMAT_DAY));
        departmentDTO.setGmtModified(new DateTime(department.getGmtModified()).toString(GlobalConst.DATE_FORMAT_DAY));
        return departmentDTO;
    }
}
