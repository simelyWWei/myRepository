package com.myexample.demo.controllor;

import com.myexample.demo.mapper.PersonMapper;
import com.myexample.demo.service.PersonService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

@Api(description = "HelloTestDemo")
@RestController
@RequestMapping(value = "/hello")
public class HelloControllor {

    @Autowired
    private PersonService syspersonservice;

    @Autowired
    private PersonMapper syspersonmapper;

    @ApiOperation(value = "hello测试",notes = "返回hello")
    @ApiResponses({ @ApiResponse(code = 404, message = "页面找不到"),
            @ApiResponse(code = 500, message = "请求异常"),})
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String test(){
        return "hello!";
    }


    @ApiOperation(value = "hello2测试",notes = "返回hello")
    @RequestMapping(value = "/hello22/{name}",method = RequestMethod.GET)
    public String test22(@PathVariable("name") String name){
        return "hello!"+name;
    }

    @ApiIgnore
    @ApiOperation(value = "hello2测试yepsnpan12e3we",notes = "返回hello")
    @RequestMapping(value = "/hello12",method = RequestMethod.GET)
    public String test12(){
        return "hello!";
    }

    @ApiOperation(value = "参数测试1",notes = "传一个参数返回该值")
    @RequestMapping(value = "/hello2",method = RequestMethod.GET)
    public String test2(
            @ApiParam(required=false,name="str",value="输入参数")
            @RequestParam(name="str",required=false)String str) {
        return "参数是:"+str;
    }

    /*@ApiOperation(value = "参数测试2",notes = "传一个参数返回该值")
    @RequestMapping(value = "/hello2",method = RequestMethod.GET)
    @ApiImplicitParams({ @ApiImplicitParam(paramType = "query", dataType = "String", name = "str", value = "参数str", required = true) })
    public String test22(String str) {
        return "参数是:"+str;
    }*/


    @ApiOperation(value = "参数测试3",notes = "传一个参数返回该值")
    @RequestMapping(value = "/hello3",method = RequestMethod.GET)
    public String test3(
            @ApiParam(required=false,name="list",value="输入列表")
            @RequestParam(name="list",required=false)List<String> list) {
            StringBuffer sb = new StringBuffer();
            for (String str:list){
                sb.append(str).append(",");
            }
            int len = sb.length();
        return "参数是:"+sb.toString().substring(0,len-1);
    }
}
