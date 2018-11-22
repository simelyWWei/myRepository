package com.myexample.demo.mapper;

import com.myexample.demo.domain.Person;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PersonMapper {

    public List<Person> getpersontest();

    public int addPerson(Person sysPerson);

}
