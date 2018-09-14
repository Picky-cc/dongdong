package com.dongdong.service.impl;

import com.dongdong.builder.PersonBuilder;
import com.dongdong.consts.ResponseCode;
import com.dongdong.entity.dao.Person;
import com.dongdong.entity.dto.PersonDTO;
import com.dongdong.entity.vo.PersonVO;
import com.dongdong.exception.BizException;
import com.dongdong.mapper.PersonMapper;
import com.dongdong.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.Objects;
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
        if (StringUtils.isEmpty(personVO.getPersonName()) || StringUtils.isEmpty(personVO.getIdCardNo())) {
            throw new BizException(ResponseCode.PARAMETER_ERROR.getCode(), ResponseCode.PARAMETER_ERROR.getMessage());
        }
        Person person = personBuilder.buildPersonByPersonVO(personVO);
        // 通过姓名身份证校验新增人员是否已经存在
        Person oldPerson = personMapper.selectByIdCard(person);
        if (Objects.isNull(oldPerson)) {
            person.setPersonUuid(UUID.randomUUID().toString());
            person.setGmtCreate(person.getGmtModified());
            personMapper.insert(person);
        } else {
            throw new BizException(ResponseCode.PERSON_EXIST.getCode(), ResponseCode.PERSON_EXIST.getMessage());
        }
    }

    @Override
    public PersonDTO getPersonDTO(PersonVO personVO) throws BizException {
        if (StringUtils.isEmpty(personVO.getPersonUuid())) {
            throw new BizException(ResponseCode.PERSON_UUID_IS_NULL.getCode(),
                    ResponseCode.PERSON_UUID_IS_NULL.getMessage());
        }
        Person person = personMapper.selectByUuid(personVO);
        return Objects.isNull(person) ? null : personBuilder.buildDTOByPerson(person);
    }
}
