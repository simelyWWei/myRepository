package com.myexample.demo.controllor;

import com.myexample.demo.domain.Goods;
import com.myexample.demo.param.GoodsAddParam;
import com.myexample.demo.param.GoodsParam;
import com.myexample.demo.service.GoodsService;
import com.myexample.demo.util.RootResult;
import com.myexample.demo.util.Uuid8Util;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

@Slf4j
@Api("商品测试")
@RestController
@RequestMapping(value = "/goods")
public class GoodsControllor {

    @Autowired
    private GoodsService goodsService;

    @ApiOperation(value = "添加", notes = "添加商品")
    @RequestMapping(value = "/addgoods", method = RequestMethod.GET)
    public int insertGoods() {
        Goods goods = new Goods();
        goods.setId(Uuid8Util.get32UUID());
        goods.setProductName("测试");
        goods.setProductPrice(Money.of(CurrencyUnit.of("CNY"), 1.5));
        int count = 0;
        try {
            count = goodsService.addGoods(goods);
        } catch (Exception e) {
            e.printStackTrace();
        }
        BigDecimal amount = goods.getProductPrice().getAmount();
        System.out.println(amount);
        return count;
    }

    @ApiOperation(value = "添加商品json", notes = "添加商品json")
    @RequestMapping(value = "/saveGoods", method = RequestMethod.POST)
    public RootResult<String> saveGoods(@RequestBody GoodsAddParam addParam) {
        RootResult<String> rootResult = new RootResult<>();
        Goods goods = new Goods();
        String id = "";
        try {
            id = Uuid8Util.get32UUID();
            goods.setId(id);
            goods.setProductName(addParam.getProductName());
            goods.setProductPrice(addParam.getProductPrice());
//            goods.setProductPrice(Money.of(CurrencyUnit.of("CNY"),Double.parseDouble(addParam.getProductPrice())));
            goodsService.addGoods(goods);
        } catch (Exception e) {
            e.printStackTrace();
            id = "0-0";
        }
        rootResult.setData(id);
        return rootResult;
    }

    @ApiOperation(value = "查询商品", notes = "根据id查询商品")
    @RequestMapping(value = "/getById", method = RequestMethod.GET)
    public RootResult<Goods> getGoodsById(
            @ApiParam(value = "商品id", name = "goodsId", required = true)
            @RequestParam(name = "goodsId", required = true) String goodsId) {
        RootResult<Goods> rootResult = new RootResult<>();
        rootResult.setData(goodsService.getGoodsById(goodsId));
        return rootResult;
    }

    @ApiOperation(value = "查询商品", notes = "根据商品名称查询商品")
    @RequestMapping(value = "/getByName", method = RequestMethod.GET)
    public RootResult<Goods> getGoodsByName(
            @ApiParam(value = "商品名称", name = "goodsName", required = true)
            @RequestParam(name = "goodsName") String goodsName) {
        RootResult<Goods> rootResult = new RootResult<>();
        rootResult.setData(goodsService.findGoodsFromRedis(goodsName));
        return rootResult;
    }

    @ApiOperation(value = "查询商品", notes = "根据id查询商品")
    @RequestMapping(value = "/testTotoPrice", method = RequestMethod.GET)
    public Goods testTotoPrice() {
        List<Goods> goodsList = goodsService.getGoodsList();
        Money money = Money.of(CurrencyUnit.of("CNY"), 0.0);
        for (Goods e : goodsList) {
            money = money.plus(e.getProductPrice());
        }
        // 做累加测试，并生成一条数据插入
        Goods goods = new Goods();
        String id = Uuid8Util.get32UUID();
        goods.setId(id);
        goods.setProductName("finalPrice");
        goods.setProductPrice(money);
        int count = goodsService.addGoods(goods);
        log.info("==========================插入了" + count + "条数据");
        // 取出最后总价
        Goods goodsById = goodsService.getGoodsById(id);
        BigDecimal amount = goodsById.getProductPrice().getAmount();
        log.info("==========================总价为：" + amount);
        log.info("==========================单位为：" + goodsById.getProductPrice().getCurrencyUnit().getCode());
        return goodsById;
    }
}
