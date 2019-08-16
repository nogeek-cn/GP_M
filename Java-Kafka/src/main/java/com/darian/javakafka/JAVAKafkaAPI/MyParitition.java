package com.darian.javakafka.JAVAKafkaAPI;

import org.apache.kafka.clients.producer.Partitioner;
import org.apache.kafka.common.Cluster;
import org.apache.kafka.common.PartitionInfo;

import java.util.List;
import java.util.Map;
import java.util.Random;

/***
 * 自定义分区策略
 */
public class MyParitition implements Partitioner {

    private final Random random = new Random();

    /***
     * 重写发送的策略
     */
    @Override
    public int partition(String topic, Object key, byte[] keyBytes, Object value, byte[] valueBytes, Cluster cluster) {
        // 根据消息拿到具体的分区列表
        List<PartitionInfo> partitionInfos = cluster.partitionsForTopic(topic);
        int partitionNum = 0;
        if (key == null) {
            partitionNum = random.nextInt(partitionInfos.size()); // 随机的分区
        } else {
            partitionNum = Math.abs(key.hashCode() % partitionInfos.size()); // Hash 取模运算
        }
        System.err.println("[key]:\t" + key + "[partitionNum]:\t" + partitionNum + "[value]:\t" + value);
        return partitionNum;
    }

    @Override
    public void close() {
    }

    @Override
    public void configure(Map<String, ?> map) {
    }
}
