package com.dongdong.service.impl;

import com.dongdong.builder.DepartmentBuilder;
import com.dongdong.consts.ResponseCode;
import com.dongdong.entity.dao.Department;
import com.dongdong.entity.vo.DepartmentVO;
import com.dongdong.exception.BizException;
import com.dongdong.mapper.DepartmentMapper;
import com.dongdong.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.UUID;

@Slf4j
@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    @Autowired
    private DepartmentBuilder departmentBuilder;

    @Override
    public void createDepartment(DepartmentVO departmentVO) throws BizException {
        Department department = departmentBuilder.buildeDepartmentByVO(departmentVO);
        Department oldDepartment = departmentMapper.selectByName(department);
        if (Objects.isNull(oldDepartment)) {
            department.setDepartmentUuid(UUID.randomUUID().toString());
            department.setGmtCreate(department.getGmtModified());
            departmentMapper.insert(department);
        } else {
            throw new BizException(ResponseCode.DEPARTMENT_EXIST.getCode(), ResponseCode.DEPARTMENT_EXIST.getMessage());
        }
    }
}
