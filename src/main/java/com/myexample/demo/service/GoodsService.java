package com.myexample.demo.service;

import com.myexample.demo.domain.Goods;
import com.myexample.demo.mapper.GoodsMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Slf4j
@Service
public class GoodsService {

    private static final String CACHE = "myspring-good";
    private static HashOperations<String,String,Goods> hashOperations;

    @Resource
    private GoodsMapper mapper;

    @Resource
    private RedisTemplate<String,Goods> redisTemplate;

    @Value("${redis-use}")
    private boolean useRedis;

    @PostConstruct
    void init(){
        List<Goods> goodsList = getGoodsList();
        if(useRedis) {
            hashOperations = redisTemplate.opsForHash();
            goodsList.stream().forEach(e -> {
                hashOperations.put(CACHE, e.getProductName(), e);
                redisTemplate.expire(CACHE, 3, TimeUnit.MINUTES);
            });
        }
    }

    public int addGoods(Goods goods) {
        return mapper.addGoods(goods);
    }

    public Goods getGoodsById(String goodsId) {
        return mapper.getGoodsById(goodsId);
    }

    public List<Goods> getGoodsList() {
        return mapper.getGoodsList();
    }

    public Goods findGoodsFromRedis(String goodName){
        if(hashOperations == null){
            log.error("no redis hashOperations has bean init");
            return null;
        }
        if(redisTemplate.hasKey(CACHE) && hashOperations.hasKey(CACHE,goodName)){
            Goods goods = hashOperations.get(CACHE, goodName);
            return goods;
        }else {
            log.error("has no key");
            return null;
        }
    }
}
