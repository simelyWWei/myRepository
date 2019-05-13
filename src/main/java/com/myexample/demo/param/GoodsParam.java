package com.myexample.demo.param;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.myexample.demo.utils.MoneyJsonDeserializer;
import com.myexample.demo.utils.MoneyJsonSerializer;
import lombok.Data;
import org.joda.money.Money;

import java.io.Serializable;

@Data
public class GoodsParam implements Serializable {

    private String productName;

    @JsonDeserialize(using = MoneyJsonDeserializer.class)
    @JsonSerialize(using = MoneyJsonSerializer.class)
    private Money productPrice;
}
