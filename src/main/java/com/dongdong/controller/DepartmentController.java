package com.dongdong.controller;

import com.alibaba.fastjson.JSONObject;
import com.dongdong.consts.ResponseCode;
import com.dongdong.consts.Result;
import com.dongdong.entity.vo.DepartmentVO;
import com.dongdong.exception.BizException;
import com.dongdong.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RestController
public class DepartmentController {

    private static final String CREATE_DEPARTMENT = "DepartmentController#createDepartment";

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/api/department/create")
    public Result<String> createDepartment(@RequestBody @Valid DepartmentVO departmentVO) throws BizException {
        log.info("{} 接口调用开始, 请求参数:{}", CREATE_DEPARTMENT, JSONObject.toJSONString(departmentVO));
        departmentService.createDepartment(departmentVO);
        log.info("{} 接口调用成功.");
        return new Result<>(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getMessage(),
                Long.toString(System.currentTimeMillis()), null);
    }
}
