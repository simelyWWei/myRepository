package com.myexample.demo.controllor;

import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api(description = "模拟服务器输出类")
@RestController
@RequestMapping("/response")
public class ResponseSimulateControllor {

    @ApiOperation(value = "三要素返回1",notes = "模拟三要素返回")
    @RequestMapping(value = "/identification",method = RequestMethod.POST)
    public JSONObject simulateResponse(@ApiParam(required = true,name = "sendTelNo",value = "手机号") String sendTelNo,
                                       @ApiParam(required = true,name = "certCode",value = "证件号") String certCode,
                                       @ApiParam(required = true,name = "userName",value = "姓名") String userName){
        String simulatText = "{\"status\":\"1\",\"code\":\"00\",\"errorDesc\":\"查询成功\",\"checkResult\":\"04\"}";
        JSONObject object = JSONObject.parseObject(simulatText);
        return object;
    }
}
