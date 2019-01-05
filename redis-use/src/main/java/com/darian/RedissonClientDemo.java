package com.darian;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

public class RedissonClientDemo {
    public static void main(String[] args) {
        Config config = new Config();
        config.useSingleServer()
                .setAddress("redis://39.105.143.0:6379");
        RedissonClient redissonClient = Redisson.create(config);
        redissonClient.getLock("darian_lock"); // 分布式锁


    }
}
