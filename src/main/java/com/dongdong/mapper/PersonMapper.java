package com.dongdong.mapper;

import com.dongdong.entity.dao.Person;
import com.dongdong.entity.vo.PersonVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PersonMapper {
    int insert(Person record);

    int insertSelective(Person record);

    Person selectByPrimaryKey(Long id);

    int updateByPersonUuid(Person record);

    int updateByPrimaryKey(Person record);

    Person selectByIdCard(Person person);

    Person selectByUuid(PersonVO personVO);
}