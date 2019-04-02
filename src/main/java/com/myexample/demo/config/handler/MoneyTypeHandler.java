package com.myexample.demo.config.handler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 这个类是MyBatis为我们提供来应对Java和jdbc字段类型不匹配的情况。
 * 也就是说你model声明的字段和数据库不匹配时需要在这个环节处理
 * 在我们启用了我们自定义的这个TypeHandler之后，数据的读写都会被这个类所过滤。
 * 写入通过setNonNullParameter方法过滤，读通过getNullableResult方法过滤，
 * parseMoney方法读作用是读取金额从分转成元。
 *
 *
 * @author 魏巍
 * @since 2019/4/2 17:06
 */
public class MoneyTypeHandler extends BaseTypeHandler<Money> {
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, Money parameter, JdbcType jdbcType) throws SQLException {
        System.out.println("setNonNullParameter======"+ps+"--"+i+"--"+parameter+"--"+jdbcType);
        ps.setLong(i, parameter.getAmountMinorLong());
    }

    @Override
    public Money getNullableResult(ResultSet rs, String columnName) throws SQLException {
        System.out.println("getNullableResult======"+rs.toString()+"--"+columnName);
        return parseMoney(rs.getLong(columnName));
    }

    @Override
    public Money getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return parseMoney(rs.getLong(columnIndex));
    }

    @Override
    public Money getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return parseMoney(cs.getLong(columnIndex));
    }

    private Money parseMoney(Long value) {
        System.out.println("value===="+value);
        return Money.of(CurrencyUnit.of("CNY"), value / 100.0);
    }
}
