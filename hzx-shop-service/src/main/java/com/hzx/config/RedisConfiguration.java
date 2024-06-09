package com.hzx.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
@Slf4j
public class RedisConfiguration {

    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        log.info("开始创建redis模板对象...");

        //1.创建 redisTemplate
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        //2.设置连接工厂，设置Redis的连接工厂对象
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        //3.设置序列化工具

        //设置Redis key的序列化器
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        GenericJackson2JsonRedisSerializer jsonRedisSerializer = new GenericJackson2JsonRedisSerializer();
        //key 和 hashkey 采用 String 序列化
        redisTemplate.setKeySerializer(RedisSerializer.string());
        redisTemplate.setKeySerializer(RedisSerializer.string());
        //value 和 hashvalue 采用 json 序列化
        redisTemplate.setValueSerializer(jsonRedisSerializer);
        redisTemplate.setHashValueSerializer(jsonRedisSerializer);


        log.info("完成创建redis模板对象：{}", redisTemplate);
        return redisTemplate;
    }
}
