package com.myexample.demo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Map;

@Slf4j
@Service
public class RedisTestService {

    @Resource
    private JedisPool jedisPool;

    @PostConstruct
    void init(){
        log.info(">>RedisTestService init....");
        try(Jedis jedis = jedisPool.getResource()){
            jedis.hset("test_key",
                    "k1",
                    "120");
            jedis.hset("test_key",
                    "k2",
                    "131");
            Map<String, String> test_key = jedis.hgetAll("test_key");
            log.info(">>test_key: {}",test_key);

            log.info(">>k1 is {}",jedis.hget("test_key","k1"));

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
