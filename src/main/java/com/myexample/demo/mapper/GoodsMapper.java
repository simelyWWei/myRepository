package com.myexample.demo.mapper;

import com.myexample.demo.domain.Goods;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GoodsMapper {

    int addGoods(Goods goods);

    Goods getGoodsById(String goodsId);

    List<Goods> getGoodsList();

}
