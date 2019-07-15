package com.myexample.demo.config;

import com.p6spy.engine.spy.appender.MessageFormattingStrategy;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class P6SpyLogger implements MessageFormattingStrategy {



    @Override
    public String formatMessage(int connectionId, String now, long elapsed, String category, String prepared, String sql, String url) {
        return !"".equals(sql.trim()) ? (now + " | took " + elapsed + "ms | " +  category + " | connection " + connectionId + "\n " + sql.replaceAll("\r|\n|\t","") + ";") : "";
    }
}
