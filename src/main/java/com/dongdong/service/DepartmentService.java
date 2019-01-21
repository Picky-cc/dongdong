package com.dongdong.service;

import com.dongdong.entity.dto.DepartmentDTO;
import com.dongdong.entity.vo.DepartmentVO;
import com.dongdong.exception.BizException;

public interface DepartmentService {
    /**
     * 创建Department
     * @param departmentVO
     * @throws BizException
     */
    void createDepartment(DepartmentVO departmentVO) throws BizException;

    /**
     * 获取单个部门信息
     * @param departmentVO
     * @return
     * @throws BizException
     */
    DepartmentDTO getDepartmentDTO(DepartmentVO departmentVO) throws BizException;

    /**
     * 更新单个部门信息
     * 使用乐观锁
     * @param departmentVO
     * @throws BizException
     */
    void updateDepartment(DepartmentVO departmentVO) throws BizException;
}
