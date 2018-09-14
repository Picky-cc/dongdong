package com.dongdong.service;

import com.dongdong.entity.vo.DepartmentVO;
import com.dongdong.exception.BizException;

public interface DepartmentService {

    void createDepartment(DepartmentVO departmentVO) throws BizException;
}
