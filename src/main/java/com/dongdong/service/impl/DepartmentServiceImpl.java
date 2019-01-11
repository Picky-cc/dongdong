package com.dongdong.service.impl;

import com.dongdong.builder.DepartmentBuilder;
import com.dongdong.consts.department.DepartmentErrorCode;
import com.dongdong.entity.dao.Department;
import com.dongdong.entity.dto.DepartmentDTO;
import com.dongdong.entity.vo.DepartmentVO;
import com.dongdong.exception.BizException;
import com.dongdong.mapper.DepartmentMapper;
import com.dongdong.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

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
        Department department = departmentBuilder.buildDepartmentByVO(departmentVO);
        Department oldDepartment = departmentMapper.selectByName(department);
        if (Objects.isNull(oldDepartment)) {
            department.setDepartmentUuid(UUID.randomUUID().toString());
            departmentMapper.insert(department);
        } else {
            throw new BizException(DepartmentErrorCode.DEPARTMENT_EXIST.getCode(),
                    DepartmentErrorCode.DEPARTMENT_EXIST.getMessage());
        }
    }

    @Override
    public DepartmentDTO getDepartmentDTO(DepartmentVO departmentVO) throws BizException {
        if (StringUtils.isEmpty(departmentVO.getDepartmentUuid())) {
            throw new BizException(DepartmentErrorCode.DEPARTMENT_UUID_IS_NULL.getCode(),
                    DepartmentErrorCode.DEPARTMENT_UUID_IS_NULL.getMessage());
        }
        Department department = departmentMapper.selectByUuid(departmentVO.getDepartmentUuid());
        return Objects.isNull(department) ? null : departmentBuilder.buildDepartmentDTO(department);
    }

    @Override
    public void updateDepartment(DepartmentVO departmentVO) throws BizException {
        if (StringUtils.isEmpty(departmentVO.getDepartmentUuid())) {
            throw new BizException(DepartmentErrorCode.DEPARTMENT_UUID_IS_NULL.getCode(),
                    DepartmentErrorCode.DEPARTMENT_UUID_IS_NULL.getMessage());
        }
        Department originDepartment = departmentMapper.selectByUuid(departmentVO.getDepartmentUuid());
        Department department = departmentBuilder.buildDepartmentByVO(departmentVO);
        department.setDepartmentUuid(departmentVO.getDepartmentUuid());
        department.setVersion(originDepartment.getVersion());
        int result = departmentMapper.updateByDepartmentUuid(department);
        if (result != 1) {
            throw new BizException(DepartmentErrorCode.DEPARTMENT_UPDATE_ERROR.getCode(),
                    DepartmentErrorCode.DEPARTMENT_UPDATE_ERROR.getMessage());
        }
    }
}
