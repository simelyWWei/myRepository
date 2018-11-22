package com.myexample.demo.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel(value = "人员表", description = "记录人员信息")
public class Person {
    @ApiModelProperty(value="personID")
    private String id;
    @ApiModelProperty(value="姓名",required = true)
    private String username;
    @ApiModelProperty(value="证件号码")
    private String idnum;
    @ApiModelProperty(value="部门编号",required = true)
    private String deptnum;
    @ApiModelProperty(value="记录时间")
    private Date logging_time;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getIdnum() {
        return idnum;
    }

    public void setIdnum(String idnum) {
        this.idnum = idnum;
    }

    public String getDeptnum() {
        return deptnum;
    }

    public void setDeptnum(String deptnum) {
        this.deptnum = deptnum;
    }

    public Date getLogging_time() {
        return logging_time;
    }

    public void setLogging_time(Date logging_time) {
        this.logging_time = logging_time;
    }

    public Person(){

    }
}
