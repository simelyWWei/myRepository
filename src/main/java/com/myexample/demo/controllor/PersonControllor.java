package com.myexample.demo.controllor;

import com.myexample.demo.domain.Person;
import com.myexample.demo.service.personService;
import com.myexample.demo.util.DateTime;
import com.myexample.demo.util.Uuid8Util;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(description = "人员信息操作")
@RestController
@RequestMapping(value = "/person")
public class PersonControllor {
    @Autowired
    private personService syspersonservice;

    @ApiOperation(value = "获取人员列表",notes = "获得全部的人员列表")
    @RequestMapping(value = "/get",method = RequestMethod.GET)
    public List<Person> getPersons(){
        /*Person sysPerson = new Person();
        sysPerson.setId("000000");
        sysPerson.setUsername("test");
        sysPerson.setIdnum("140212199302100011");
        sysPerson.setDeptnum("0001");
        ArrayList<Person> list = (ArrayList<Person>) syspersonmapper.getpersontest();
        if (list.get(0)!=null){
            return list.get(0);
        }else {
            return sysPerson;
        }*/
        return syspersonservice.getpersontest();
    }

    @ApiOperation(value = "添加人员信息",notes = "添加人员信息")
    @RequestMapping(value = "/addperson",method = RequestMethod.POST)
    public String addPerson(
           @RequestBody @ApiParam(name="sysperson",value="用户信息",required=true)Person sysPerson
    ){
        String id = Uuid8Util.get32UUID();
        sysPerson.setId(id);
        int count = 0;
        try {
            count = syspersonservice.addPerson(sysPerson);
        }catch (Exception e){
            e.printStackTrace();
        }

        if (count > 0){
            return id;
        }else {
            return "failed";
        }
    }

    @ApiOperation(value = "添加人员信息",notes = "添加人员信息")
    @ApiResponses({ @ApiResponse(code = 404, message = "页面找不到"),
            @ApiResponse(code = 500, message = "请求异常"),})
    @RequestMapping(value = "/addperson2",method = RequestMethod.POST)
    public String addPerson2(
            Person sysPerson
    ){
        String id = Uuid8Util.get32UUID();
        sysPerson.setId(id);
        sysPerson.setLogging_time(DateTime.currentTime());
        int count = 0;
        try {
            count = syspersonservice.addPerson(sysPerson);
        }catch (Exception e){
            e.printStackTrace();
        }

        if (count > 0){
            return id;
        }else {
            return "failed";
        }
    }
}
