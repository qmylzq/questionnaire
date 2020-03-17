package com.zqq.questionnaire.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
//import redis.clients.jedis.JedisPoolConfig;

import java.util.ArrayList;
import java.util.List;

/**
 * @ author: 曲梦瑶
 * @ date: 2020/3/9-22 : 32
 */
@Configuration
@EnableCaching
public class RedisConfiguration extends CachingConfigurerSupport {
    
    @Value("${spring.redis.host}")
    private String redisHost;
    
    @Value("${spring.redis.port}")
    private Integer redisPort;

//    @Bean
//    public JedisConnectionFactory jedisConnectionFactory() {
//        RedisStandaloneConfiguration configuration =
//                new RedisStandaloneConfiguration(redisHost, redisPort);
//        return new JedisConnectionFactory(configuration);
//    }
//
//    @Bean(name = "redisTemplate")
//    public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory factory) {
//        /*
//         * Redis 序列化器.
//         *
//         * RedisTemplate 默认的系列化类是 JdkSerializationRedisSerializer,用JdkSerializationRedisSerializer序列化的话,
//         * 被序列化的对象必须实现Serializable接口。在存储内容时，除了属性的内容外还存了其它内容在里面，总长度长，且不容易阅读。
//         *
//         * Jackson2JsonRedisSerializer 和 GenericJackson2JsonRedisSerializer，两者都能系列化成 json，
//         * 但是后者会在 json 中加入 @class 属性，类的全路径包名，方便反系列化。前者如果存放了 List 则在反系列化的时候如果没指定
//         * TypeReference 则会报错 java.util.LinkedHashMap cannot be cast to
//         */
//        RedisSerializer genericJackson2JsonRedisSerializer = new GenericJackson2JsonRedisSerializer();
//        RedisSerializer stringRedisSerializer = new StringRedisSerializer();
//
//        // 定义RedisTemplate，并设置连接工程
//        RedisTemplate<Object, Object> redisTemplate = new RedisTemplate<>();
//
//        // key 的序列化采用 StringRedisSerializer
//        redisTemplate.setKeySerializer(stringRedisSerializer);
//        redisTemplate.setHashKeySerializer(stringRedisSerializer);
//        // value 值的序列化采用 GenericJackson2JsonRedisSerializer
//        redisTemplate.setValueSerializer(genericJackson2JsonRedisSerializer);
//        redisTemplate.setHashValueSerializer(genericJackson2JsonRedisSerializer);
//        // 设置连接工厂
//        redisTemplate.setConnectionFactory(factory);
//
//        return redisTemplate;
//    }
//
//    @Bean
//    public CacheManager initRedisCacheManager(@Qualifier("") RedisConnectionFactory factory) {
//        RedisCacheManager.RedisCacheManagerBuilder builder = RedisCacheManager
//                .RedisCacheManagerBuilder.fromConnectionFactory(factory);
//        return builder.build();
//    }
    
}
