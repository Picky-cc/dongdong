package com.dongdong.builder;

import com.dongdong.consts.GlobalConst;
import com.dongdong.entity.dao.Person;
import com.dongdong.entity.dto.PersonDTO;
import com.dongdong.entity.enumeration.SexEnum;
import com.dongdong.entity.vo.PersonVO;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@Component("personBuilder")
public class PersonBuilder {

    public Person buildPersonByPersonVO(PersonVO personVO) {
        Person person = new Person();
        person.setPersonName(personVO.getPersonName());
        person.setIdCardNo(personVO.getIdCardNo());
        SexEnum sex = Objects.isNull(SexEnum.getMap().get(personVO.getSex())) ? null :
                SexEnum.getMap().get(personVO.getSex());
        person.setSex(sex);
        if (!Objects.isNull(personVO.getBirthDay())) {
            DateTimeFormatter formatter = DateTimeFormat.forPattern(GlobalConst.DATE_FORMAT_DAY);
            Date birthDay = DateTime.parse(personVO.getBirthDay(), formatter).toDate();
            person.setBirthDay(birthDay);
        }
        person.setAddress(personVO.getAddress());
        person.setDepartmentUuid(personVO.getDepartmentUuid());
        person.setSalary(Objects.isNull(personVO.getSalary()) ? null : new BigDecimal(personVO.getSalary()));
        person.setPhoneNo(personVO.getPhoneNo());
        person.setEmail(personVO.getEmail());
        person.setRemark(personVO.getRemark());
        return person;
    }

    public PersonDTO buildDTOByPerson(Person person) {
        PersonDTO personDTO = new PersonDTO();
        personDTO.setPersonUuid(person.getPersonUuid());
        personDTO.setPersonName(person.getPersonName());
        personDTO.setIdCardNo(person.getIdCardNo());
        personDTO.setSex(Objects.isNull(person.getSex()) ? StringUtils.EMPTY : person.getSex().getValue());
        personDTO.setBirthDay(new DateTime(person.getBirthDay()).toString(GlobalConst.DATE_FORMAT_DAY));
        personDTO.setAddress(person.getAddress());
        personDTO.setDepartmentUuid(person.getDepartmentUuid());
        personDTO.setDepartmentName(Objects.isNull(person.getDepartment()) ? null :
                person.getDepartment().getDepartmentName());
        personDTO.setSalary(person.getSalary().toString());
        personDTO.setPhoneNo(person.getPhoneNo());
        personDTO.setEmail(person.getEmail());
        personDTO.setRemark(person.getRemark());
        personDTO.setGmtCreate(new DateTime(person.getGmtCreate()).toString(GlobalConst.DATE_FORMAT_DAY));
        personDTO.setGmtModified(new DateTime(person.getGmtModified()).toString(GlobalConst.DATE_FORMAT_DAY));
        return personDTO;
    }
}
