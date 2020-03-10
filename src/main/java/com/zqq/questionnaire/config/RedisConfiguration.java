package com.zqq.questionnaire.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @ author: 曲梦瑶
 * @ date: 2020/3/9-22 : 32
 */
@Configuration
@EnableCaching
public class RedisConfiguration {
    @Bean
    public CacheManager cacheManager(RedisConnectionFactory factory){
        RedisCacheManager rcm = RedisCacheManager.builder(factory).build();
        return rcm;
    }
}
