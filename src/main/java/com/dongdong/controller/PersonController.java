package com.dongdong.controller;

import com.alibaba.fastjson.JSONObject;
import com.dongdong.consts.ResponseCode;
import com.dongdong.consts.Result;
import com.dongdong.entity.vo.PersonVO;
import com.dongdong.exception.BizException;
import com.dongdong.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RestController
public class PersonController {

    private static final String CREATE_PERSON = "PersonController#createPerson";

    @Autowired
    private PersonService personService;

    @PostMapping("/api/person/create")
    public Result<String> createPerson(@RequestBody @Valid PersonVO personVO) throws BizException {
        log.info("{} 接口调用开始,入参为:{}", CREATE_PERSON, JSONObject.toJSONString(personVO));
        Result<String> result = new Result<>();
        result.setCode(ResponseCode.SUCCESS.getCode());
        result.setMessage(ResponseCode.SUCCESS.getMessage());
        result.setTimeStamp(Long.toString(System.currentTimeMillis()));
        personService.createPerson(personVO);
        log.info("{} 接口调用成功.", CREATE_PERSON);
        return result;
    }
}
