package com.myexample.demo.domain;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.myexample.demo.utils.MoneyJsonDeserializer;
import com.myexample.demo.utils.MoneyJsonSerializer;
import lombok.Data;
import org.joda.money.Money;

import java.io.Serializable;

@Data
public class Goods implements Serializable {

    private String id;

    private String productName;

    @JsonSerialize(using = MoneyJsonSerializer.class)
    private Money productPrice;
}
