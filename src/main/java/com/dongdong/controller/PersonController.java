package com.dongdong.controller;

import com.alibaba.fastjson.JSONObject;
import com.dongdong.consts.ResponseCode;
import com.dongdong.consts.Result;
import com.dongdong.entity.dto.PersonDTO;
import com.dongdong.entity.vo.PersonVO;
import com.dongdong.exception.BizException;
import com.dongdong.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Objects;

@Slf4j
@RestController
public class PersonController {

    private static final String CREATE_PERSON = "PersonController#createPerson";
    private static final String GET_PERSON = "PersonController#getPersonInfo";

    @Autowired
    private PersonService personService;

    /**
     * 新增人员接口
     * @param personVO
     * @return
     * @throws BizException
     */
    @PostMapping("/api/person/create")
    public Result<String> createPerson(@RequestBody @Valid PersonVO personVO) throws BizException {
        log.info("{} 接口调用开始,入参为:{}", CREATE_PERSON, JSONObject.toJSONString(personVO));
        Result<String> result = new Result<>();
        personService.createPerson(personVO);
        result.setCode(ResponseCode.SUCCESS.getCode());
        result.setMessage(ResponseCode.SUCCESS.getMessage());
        result.setTimeStamp(Long.toString(System.currentTimeMillis()));
        log.info("{} 接口调用成功.", CREATE_PERSON);
        return result;
    }

    /**
     * 查询人员信息接口
     * @param personVO
     * @return
     * @throws BizException
     */
    @PostMapping("/api/person/getPerson")
    public Result<PersonDTO> getPersonInfo(@RequestBody PersonVO personVO) throws BizException{
        log.info("{} 接口调用开始,入参为:{}", GET_PERSON, JSONObject.toJSON(personVO));
        Result<PersonDTO> result = new Result<>();
        PersonDTO personDTO = personService.getPersonDTO(personVO);
        if (Objects.isNull(personDTO)){
            result.setCode(ResponseCode.CAN_NOT_FIND.getCode());
            result.setMessage(ResponseCode.CAN_NOT_FIND.getMessage());
        } else {
            result.setData(personDTO);
            result.setCode(ResponseCode.SUCCESS.getCode());
            result.setMessage(ResponseCode.SUCCESS.getMessage());
        }
        result.setTimeStamp(Long.toString(System.currentTimeMillis()));
        log.info("{} 接口调用成功, 查询结果:{}", GET_PERSON, JSONObject.toJSON(result));
        return result;
    }

}
