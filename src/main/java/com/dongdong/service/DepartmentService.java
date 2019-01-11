package com.dongdong.service;

import com.dongdong.entity.dto.DepartmentDTO;
import com.dongdong.entity.vo.DepartmentVO;
import com.dongdong.exception.BizException;

public interface DepartmentService {

    void createDepartment(DepartmentVO departmentVO) throws BizException;

    DepartmentDTO getDepartmentDTO(DepartmentVO departmentVO) throws BizException;

    void updateDepartment(DepartmentVO departmentVO) throws BizException;
}
