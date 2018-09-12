package com.dongdong.builder;

import com.dongdong.consts.GlobalConst;
import com.dongdong.entity.dao.Person;
import com.dongdong.entity.enumeration.SexEnum;
import com.dongdong.entity.vo.PersonVO;
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
        DateTimeFormatter formatter = DateTimeFormat.forPattern(GlobalConst.DATE_FORMAT_DAY);
        Date birthDay = DateTime.parse(personVO.getBirthDay(), formatter).toDate();
        person.setBirthDay(birthDay);
        person.setAddress(personVO.getAddress());
        person.setDepartmentUuid(personVO.getDepartmentUuid());
        person.setSalary(new BigDecimal(personVO.getSalary()));
        person.setPhoneNo(personVO.getPhoneNo());
        person.setEmail(personVO.getEmail());
        person.setRemark(personVO.getRemark());
        person.setGmtModified(new Date());
        return person;
    }
}
