package com.mirror.redis;

import jakarta.annotation.PostConstruct;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RedisConnectionTest {

    @Autowired
    private RedissonClient redissonClient;

    @PostConstruct
    public void testConnection() {
        try {
            redissonClient.getKeys().count(); // 测试连接
            System.out.println("Redis connection successful");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Redis connection failed");
        }
    }
}
