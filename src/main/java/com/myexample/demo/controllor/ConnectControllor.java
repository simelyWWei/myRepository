package com.myexample.demo.controllor;
import com.alibaba.fastjson.JSONObject;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Slf4j
@Api("商品测试")
@RestController
@RequestMapping(value = "/wingpay")
public class ConnectControllor {

    @Resource
    private RestTemplate restTemplate;

    @RequestMapping(value = "/test",method = RequestMethod.POST)
    public String getConnection(){
        // 针对body体中的
        String url = "http://127.0.0.1:8086/myspring/goods/saveGoods";
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("productName","测试restTemplate");
        jsonObject.put("productPrice","2.15");
        ResponseEntity<JSONObject> jsonObjectResponseEntity = restTemplate.postForEntity(url, jsonObject, JSONObject.class);
        String result = jsonObjectResponseEntity.getBody().toString();

        //针对form表单
        /*MultiValueMap<String,Object> itemMap = new LinkedMultiValueMap<>();
        itemMap.add("productName","测试restTemplate");
        itemMap.add("productPrice","2.15");
        ResponseEntity<JSONObject> obkect = restTemplate.postForEntity(url,itemMap,JSONObject.class);
        String result = obkect.getBody().toString();*/

        return "result";
    }
}
