package com.dongdong.service;

import com.dongdong.entity.dto.PersonDTO;
import com.dongdong.entity.vo.PersonVO;
import com.dongdong.exception.BizException;

public interface PersonService {
    /**
     * 创建Person
     * @param personVO
     * @throws BizException
     */
    void createPerson(PersonVO personVO) throws BizException;

    /**
     * 获取单个人员信息
     * @param personVO
     * @return
     * @throws BizException
     */
    PersonDTO getPersonDTO(PersonVO personVO) throws BizException;

    /**
     * 更新单个人员信息
     * 使用乐观锁
     * @param personVO
     * @throws BizException
     */
    void updatePerson(PersonVO personVO) throws BizException;
}
