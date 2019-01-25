package com.darian;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisSentinelPool;

import java.util.HashSet;
import java.util.Set;

public class JedisClientDemo {

    public static void main(String[] args) {


//        HostAndPort hostAndPort = new HostAndPort();
        // 哨兵集群的地址，在哨兵上配置了 Master 的名称，还有 Master 的 IP 和 端口号，
        // 哨兵可以通过 Master 然后监控到整个集群的信息，同时哨兵里边对于 Master 的信息是可以共享的
//        JedisSentinelPool jedisSentinelPool = new JedisSentinelPool();
        //        线程池
        JedisPool jedisPool = null;
        jedisPool.getResource().set("darian", "hello world");
        Set<HostAndPort> hostAndPortSet = new HashSet<>();
        hostAndPortSet.add(new HostAndPort("192.168.40.128", 6379));
        hostAndPortSet.add(new HostAndPort("192.168.40.128", 6379));
        JedisCluster jedisCluster = new JedisCluster(hostAndPortSet);
        jedisCluster.set("", "");

    }
}
