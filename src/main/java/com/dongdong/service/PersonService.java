package com.dongdong.service;

import com.dongdong.entity.dto.PersonDTO;
import com.dongdong.entity.vo.PersonVO;
import com.dongdong.exception.BizException;

public interface PersonService {

    void createPerson(PersonVO personVO) throws BizException;

    PersonDTO getPersonDTO(PersonVO personVO) throws BizException;
}
