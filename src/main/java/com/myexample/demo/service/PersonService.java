package com.myexample.demo.service;

import com.myexample.demo.domain.Person;
import com.myexample.demo.mapper.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("syspersonser")
public class PersonService {

    @Resource
    private PersonMapper mapper;

    public List<Person> getpersontest(){
        return mapper.getpersontest();
    }

    public int addPerson(Person sysPerson) {
        return mapper.addPerson(sysPerson);
    }

}
