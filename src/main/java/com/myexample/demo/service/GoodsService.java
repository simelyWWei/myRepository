package com.myexample.demo.service;

import com.myexample.demo.domain.Goods;
import com.myexample.demo.mapper.GoodsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class GoodsService {

    @Resource
    private GoodsMapper mapper;

    public int addGoods(Goods goods) {
        return mapper.addGoods(goods);
    }

    public Goods getGoodsById(String goodsId) {
        return mapper.getGoodsById(goodsId);
    }

    public List<Goods> getGoodsList() {
        return mapper.getGoodsList();
    }
}
