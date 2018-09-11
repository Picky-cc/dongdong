package com.dongdong.controller;

import com.dongdong.consts.ResponseCode;
import com.dongdong.consts.Result;
import com.dongdong.entity.dao.UserTest;
import com.dongdong.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestTestController {

    @Autowired
    private UserService userService;

    @GetMapping("/rest")
    public Result<List<UserTest>> rest(){
        Result<List<UserTest>> result = new Result<List<UserTest>>();
        result.setCode(ResponseCode.SUCCESS.getCode());
        result.setMessage(ResponseCode.SUCCESS.getMessage());
        result.setData(userService.getAllUsers());
        result.setTimeStamp(Long.toString(System.currentTimeMillis()));
        return result;
    }
}
