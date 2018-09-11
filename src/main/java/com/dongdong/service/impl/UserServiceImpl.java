package com.dongdong.service.impl;

import com.dongdong.entity.dao.UserTest;
import com.dongdong.mapper.UserTestMapper;
import com.dongdong.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserTestMapper userTestMapper;

    @Override
    public List<UserTest> getAllUsers() {
        return userTestMapper.selectAllUsers();
    }
}
