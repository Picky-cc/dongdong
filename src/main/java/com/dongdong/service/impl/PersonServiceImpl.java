package com.dongdong.service.impl;

import com.dongdong.annotation.DataSourceSelector;
import com.dongdong.builder.PersonBuilder;
import com.dongdong.config.DynamicDateSourceEnum;
import com.dongdong.consts.ResponseCode;
import com.dongdong.consts.person.PersonErrorCode;
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
            personMapper.insert(person);
        } else {
            throw new BizException(PersonErrorCode.PERSON_EXIST.getCode(), PersonErrorCode.PERSON_EXIST.getMessage());
        }
    }

    @Override
    @DataSourceSelector(DynamicDateSourceEnum.MASTER)
    public PersonDTO getPersonDTO(PersonVO personVO) throws BizException {
        if (StringUtils.isEmpty(personVO.getPersonUuid())) {
            throw new BizException(PersonErrorCode.PERSON_UUID_IS_NULL.getCode(),
                    PersonErrorCode.PERSON_UUID_IS_NULL.getMessage());
        }
        Person person = personMapper.selectByUuid(personVO.getPersonUuid());
        return Objects.isNull(person) ? null : personBuilder.buildDTOByPerson(person);
    }

    @Override
    @DataSourceSelector(DynamicDateSourceEnum.SLAVE)
    public PersonDTO getPersonDTOFromSlave(PersonVO personVO) throws BizException {
        if (StringUtils.isEmpty(personVO.getPersonUuid())) {
            throw new BizException(PersonErrorCode.PERSON_UUID_IS_NULL.getCode(),
                    PersonErrorCode.PERSON_UUID_IS_NULL.getMessage());
        }
        Person person = personMapper.selectByUuid(personVO.getPersonUuid());
        return Objects.isNull(person) ? null : personBuilder.buildDTOByPerson(person);
    }

    @Override
    public void updatePerson(PersonVO personVO) throws BizException {
        if (StringUtils.isEmpty(personVO.getPersonUuid())) {
            throw new BizException(PersonErrorCode.PERSON_UUID_IS_NULL.getCode(),
                    PersonErrorCode.PERSON_UUID_IS_NULL.getMessage());
        }
        Person person = personBuilder.buildPersonByPersonVO(personVO);
        // 校验要更新的证件号是否已经存在
        Person oldPerson = personMapper.selectByIdCard(person);
        if (!Objects.isNull(oldPerson)) {
            throw new BizException(PersonErrorCode.PERSON_EXIST.getCode(), PersonErrorCode.PERSON_EXIST.getMessage());
        }
        // 数据库乐观锁
        Person originPerson = personMapper.selectByUuid(personVO.getPersonUuid());
        person.setPersonUuid(personVO.getPersonUuid());
        person.setVersion(originPerson.getVersion());
        int result = personMapper.updateByPersonUuid(person);
        if (result != 1) {
            throw new BizException(PersonErrorCode.PERSON_UPDATE_ERROR.getCode(),
                    PersonErrorCode.PERSON_UPDATE_ERROR.getMessage());
        }
    }
}
