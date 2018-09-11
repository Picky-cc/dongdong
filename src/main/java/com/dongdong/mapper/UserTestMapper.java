package com.dongdong.mapper;

import com.dongdong.entity.dao.UserTest;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserTestMapper {
    int insert(UserTest record);

    int insertSelective(UserTest record);

    UserTest selectByPrimaryKey(Long id);

    List<UserTest> selectAllUsers();
}