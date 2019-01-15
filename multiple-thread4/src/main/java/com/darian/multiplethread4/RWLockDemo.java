package com.darian.multiplethread4;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import static java.lang.System.*;

public class RWLockDemo {
    // 排他锁
    // 共享锁，在同一时刻可以有多个线程获得锁
    // 读锁， 写锁
    static Map<String, Integer> cacheMap = new HashMap<>();
    // 重入读写锁
    static ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    static Lock read = readWriteLock.readLock();    // 读锁
    static Lock write = readWriteLock.writeLock();  // 写锁


    // 缓存的更新和读取的时候
    public static final Integer get(String key) {
        read.lock(); // 读取的时候加上读锁
        out.println("开始读取数据");
        try {
            return cacheMap.get(key);
        } finally {
            read.unlock();
        }
    }

    public static final Integer set(String key, Integer value) {
        write.lock();  // 每一次写数据，都需要先加上写锁
        out.println("开始写数据");
        try {
            return cacheMap.put(key, value);
        } finally {
            write.unlock();
        }
    }

    public static final Integer incr(String key) {
        write.lock();  // 每一次写数据，都需要先加上写锁
        out.println("开始写数据");
        try {
            // 要发生数据改变的操作，全部放到这里

            Integer value = cacheMap.get(key);
            return cacheMap.put(key, value + 1);
        } finally {
            write.unlock();
        }
    }

    public static void main(String[] args) {
    }

    /***
     * 第一种方式
     */
    public static void add1000first() {
        RWLockDemo.cacheMap.put("1", 1);
        ExecutorService executorService = Executors.newFixedThreadPool(1000);
        CompletionService completionService = new ExecutorCompletionService(executorService);
        for (int i = 0; i < 1000; i++) {
            completionService.submit(() -> {
                RWLockDemo.incr("1");
            }, null);
        }
        int count = 0;
        while (count < 1000) { // 等待任务完成全部
            if (completionService.poll() != null) {
                count++;
            }
        }
        System.out.println("[first]新缓增加 1000 次以后: 结果为：" + RWLockDemo.cacheMap.get("1"));
    }


}
