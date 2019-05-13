package com.myexample.demo.service;

import org.joda.money.CurrencyUnit;
import org.joda.money.Money;

public class MoneyTest {
    public static void main(String[] args) {
        Money cny1 = Money.of(CurrencyUnit.of("CNY"), 30.12);
        Money cny2 = Money.of(CurrencyUnit.of("CNY"), 20.00);
        int i = cny2.compareTo(cny1);
        double v = cny1.getAmount().doubleValue();
        System.out.println(v);
        System.out.println(i);
    }
}
