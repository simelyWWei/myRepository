package com.myexample.demo.config;

import com.myexample.demo.domain.Goods;
import io.lettuce.core.ReadFrom;
import org.springframework.boot.autoconfigure.data.redis.LettuceClientConfigurationBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
public class RedisTemplateConfig {
    @Bean
    public RedisTemplate<String, Goods> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, Goods> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);
        return template;
    }

    /**
     * 回调函数，设置LettuceClient
     * 默认先读master
     */
    @Bean
    public LettuceClientConfigurationBuilderCustomizer customizer() {
        return builder -> builder.readFrom(ReadFrom.MASTER_PREFERRED);
    }

//     RedisStandaloneConfiguration、
//    RedisSentinelConfiguration
//    RedisClusterConfiguration
//    RedisProperties
}
