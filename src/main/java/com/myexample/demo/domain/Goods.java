package com.myexample.demo.domain;

import lombok.Data;
import org.joda.money.Money;

@Data
public class Goods {

    private String id;

    private String productName;

    private Money productPrice;
}
