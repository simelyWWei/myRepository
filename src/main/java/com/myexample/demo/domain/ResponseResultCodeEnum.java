package com.myexample.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 请求响应码及msg
 * 主要都是描述错误信息的
 * 不要用200，RootResult默认200为成功
 * @date 2018/11/19 17:47
 * @author 王昊然
 */
@AllArgsConstructor
@Getter
public enum ResponseResultCodeEnum {

    /*通用成功*/
    SUCCESS(200, "ok"),

    /*通用参数错误*/
    ERROR_PARAM(901, "参数错误"),
    /*通用参数错误 截至时间小于起始时间*/
    ERROR_PARAM_DATETIME_ORDER_ERROR(909, "截至时间应大于起始时间!"),
    /*通用参数错误 时间间隔过大*/
    ERROR_PARAM_DATETIME_EXCESSIVE(910, "时间间隔过大!"),

    /*通用系统异常*/
    ERROR(1000, "系统出现异常"),
    /*请求参数异常*/
    REQUEST_PARAMS_ERROR(1001, "参数异常"),

    /*添加应用系统异常*/
    ADD_TENANT_ERROR(5001, "添加应用系统出现异常"),
    /*更新应用系统异常*/
    UPDATE_TENANT_ERROR(5002, "更新应用系统出现异常"),
	
	/*不允许删除分类下面的子分类*/
    DELETE_CATEGORY_HASSUB_ERROR(5201, "分类下面存在子分类"),
    /*分类不存在*/
    CATEGORY_NOT_FIND_ERROR(5202, "不存在该分类"),

    /*账号密码错误*/
    ACCOUNT_OR_PASSWORD_ERROR(5403, "账号密码错误"),
    /*密码错误*/
    PASSWORD_VALIDATE_ERROR(5404, "密码错误"),
	/*用户不存在*/
    PERSON_NOT_FIND_ERROR(5405, "用户不存在"),


    //---------------------------- 后台管理相关--------------------
    ADMIN_CREATE_GRADE_CODE_ERROR(6001, "创建等级编码失败，最大5级"),
    ADMIN_DELETE_DEPT_ERROR(6002, "删除部门失败.存在子部门"),
    ADMIN_INSERT_USER_ERROR(6003, "新增失败，登录名重复"),
    ADMIN_INSERT_USER_PWD_ERROR(6004, "密码保存出错"),
    ADMIN_DELETE_DEPT_HASUSER_ERROR(6005, "删除部门失败.部门下存在用户"),

    ;
	
    /**
     * 结果编码
     */
    private int code;
    /**
     * 结果消息
     */
    private String msg;

}
