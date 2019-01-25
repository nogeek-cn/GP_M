package com.darian;

import com.darian.jedis.JedisConnectionUtils;
import redis.clients.jedis.Jedis;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        String lua = "if redis.call(\"get\",KEYS[1])==ARGV[1] " +
                "then return redis.call(\"del\",KEYS[1]) " +
                "else return 0 end";

        System.out.println(JedisConnectionUtils.getJedis().evalsha(lua));
        System.out.println("Hello World!");
    }
}
