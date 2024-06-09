package com.hzx.AAAproject;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
public class RedisConnectionTest {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Test
    public void testRedisConnection() {
        String testKey = "testKey";
        String testValue = "testValue1234";

        // 写入 Redis
        redisTemplate.opsForValue().set(testKey, testValue);

        // 从 Redis 读取
        String valueFromRedis = (String) redisTemplate.opsForValue().get(testKey);


        System.out.println("Redis connection is working: " + valueFromRedis);
    }
}