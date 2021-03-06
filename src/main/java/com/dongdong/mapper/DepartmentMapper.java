package com.dongdong.mapper;

import com.dongdong.entity.dao.Department;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DepartmentMapper {
    int insert(Department record);

    int insertSelective(Department record);

    Department selectByPrimaryKey(Long id);

    int updateByDepartmentUuid(Department record);

    int updateByPrimaryKey(Department record);

    Department selectByUuid(String departmentUuid);

    Department selectByName(Department department);
}