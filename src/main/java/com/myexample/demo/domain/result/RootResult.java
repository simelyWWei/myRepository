package com.myexample.demo.domain.result;

import com.myexample.demo.domain.ResponseResultCodeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.joda.time.DateTime;

@ApiModel(value = "响应结果")
@Setter
@Getter
public class RootResult<T> {

    /**
     * 返回标记 如果该标记为200则表明返回结果正确 否则都是错误消息
     */
    @ApiModelProperty(value = "响应结果状态码")
    private int code;

    /**
     * 返回消息 一般用于返回错误描述或者操作提示
     */
    @ApiModelProperty(value = "响应结果信息说明")
    private String msg;

    /**
     * 返回消息 返回时间
     */
    @ApiModelProperty(value = "响应返回时间")
    private String time;

    /**
     * 返回标记 对象
     */
    @ApiModelProperty(value = "响应结果集")
    private T data;

    private RootResult(int code, String msg) {
        this.code = code;
        this.msg = msg;
        DateTime now = DateTime.now();
        this.setTime(now.toString("yyyy-MM-dd HH:mm:ss"));
    }

    private RootResult(ResponseResultCodeEnum enumObj) {
        this.setCode(enumObj.getCode());
        this.setMsg(enumObj.getMsg());

        DateTime now = DateTime.now();
        this.setTime(now.toString("yyyy-MM-dd HH:mm:ss"));
    }

    public static <T> RootResult<T> success() {
        return new RootResult<>(ResponseResultCodeEnum.SUCCESS);
    }

    public static <T> RootResult<T> success(T data) {
        RootResult<T> rootResult = success();
        rootResult.setData(data);
        return rootResult;
    }


    public static RootResult error(int code, String msg) {
        return new RootResult(code, msg);
    }

    public static <T> RootResult<T> error(ResponseResultCodeEnum enumObj) {
        return new RootResult<>(enumObj.getCode(), enumObj.getMsg());
    }

    private void setErrorInfo(int code, String msg) {
        this.setCode(code);
        this.setMsg(msg);
    }

    public void setErrorInfo(ResponseResultCodeEnum enumObj) {
        this.setErrorInfo(enumObj.getCode(), enumObj.getMsg());
    }
}
