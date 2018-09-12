package com.dongdong.service.impl;

import com.dongdong.builder.PersonBuilder;
import com.dongdong.consts.ResponseCode;
import com.dongdong.entity.dao.Person;
import com.dongdong.entity.vo.PersonVO;
import com.dongdong.exception.BizException;
import com.dongdong.mapper.PersonMapper;
import com.dongdong.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.UUID;

@Transactional
@Service
@Slf4j
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonMapper personMapper;

    @Autowired
    private PersonBuilder personBuilder;

    @Override
    public void createPerson(PersonVO personVO) throws BizException {
        if (StringUtils.isEmpty(personVO.getPersonName()) || StringUtils.isEmpty(personVO.getIdCardNo())){
            throw new BizException(ResponseCode.PARAMETER_ERROR.getCode(), ResponseCode.PARAMETER_ERROR.getMessage());
        }
        Person person = personBuilder.buildPersonByPersonVO(personVO);
        person.setPersonUuid(UUID.randomUUID().toString());
        person.setGmtCreate(person.getGmtModified());
        personMapper.insert(person);
    }
}
