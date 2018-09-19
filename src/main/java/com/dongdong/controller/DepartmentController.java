package com.dongdong.controller;

import com.alibaba.fastjson.JSONObject;
import com.dongdong.consts.ResponseCode;
import com.dongdong.consts.Result;
import com.dongdong.entity.dto.DepartmentDTO;
import com.dongdong.entity.vo.DepartmentVO;
import com.dongdong.exception.BizException;
import com.dongdong.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Objects;

@Slf4j
@RestController
public class DepartmentController {

    private static final String CREATE_DEPARTMENT = "DepartmentController#createDepartment";
    private static final String GET_DEPARTMENT_INFO = "DepartmentController#getDepartmentInfo";

    @Autowired
    private DepartmentService departmentService;

    /**
     * 新增部门接口
     * @param departmentVO
     * @return
     * @throws BizException
     */
    @PostMapping("/api/department/create")
    public Result<String> createDepartment(@RequestBody @Valid DepartmentVO departmentVO) throws BizException {
        log.info("{} 接口调用开始, 请求参数:{}", CREATE_DEPARTMENT, JSONObject.toJSONString(departmentVO));
        departmentService.createDepartment(departmentVO);
        log.info("{} 接口调用成功.");
        return new Result<>(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getMessage(),
                Long.toString(System.currentTimeMillis()), null);
    }

    /**
     * 部门详情查询接口
     * @param departmentVO
     * @return
     * @throws BizException
     */
    @PostMapping("/api/department/getDepartment")
    public Result<DepartmentDTO> getDepartmentInfo(@RequestBody DepartmentVO departmentVO) throws BizException{
        log.info("{} 接口调用开始, 请求参数:{}", GET_DEPARTMENT_INFO, JSONObject.toJSONString(departmentVO));
        Result<DepartmentDTO> result = new Result<>();
        result.setTimeStamp(Long.toString(System.currentTimeMillis()));
        DepartmentDTO departmentDTO = departmentService.getDepartmentDTO(departmentVO);
        if (Objects.isNull(departmentDTO)){
            result.setCode(ResponseCode.CAN_NOT_FIND.getCode());
            result.setMessage(ResponseCode.CAN_NOT_FIND.getMessage());
        } else {
            result.setCode(ResponseCode.SUCCESS.getCode());
            result.setMessage(ResponseCode.SUCCESS.getMessage());
            result.setData(departmentDTO);
        }
        return result;
    }
}
