package com.darian.jedis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisConnectionUtils {
    private static JedisPool pool = null;

    static {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        // 限流机制
        jedisPoolConfig.setMaxTotal(100);
        pool = new JedisPool(jedisPoolConfig, "", 6379);
    }

    public static Jedis getJedis(){
        return pool.getResource();
    }
}
