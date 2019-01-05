package com.darian.redisson;


import com.darian.jedis.JedisConnectionUtils;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;

import java.util.Set;

public class PipelineDemo {

    public static void main(String[] args) {
        Jedis jedis = JedisConnectionUtils.getJedis();
        Pipeline pipelined = jedis.pipelined();
        pipelined.set("darian4", "darian1");
        pipelined.set("darian5", "darian2");
        pipelined.set("darian6", "darian3");
        pipelined.sync();

    }
}
