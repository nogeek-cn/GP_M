package com.darian.multiplethread4;

import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class TestperformanceDemo {
    static Integer demoInteger = 0;
    // 重入读写锁
    static ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    static Lock read = readWriteLock.readLock();    // 读锁
    static Lock write = readWriteLock.writeLock();  // 写锁


    public static void main(String[] args) {
        int countSum = 10000;
        add1000ReadWrite(countSum);
        add1000synchronized(countSum);
        // [readWrite] 9999次读操作{每次读操作 睡眠 1 ms}，1次 " +1" 操作以后， 结果为：1[耗时]:665
        // [synchronized]  9999次读操作{每次读操作 睡眠 1 ms}，1次 " +1" 操作以后， 结果为：1[耗时]:19007
    }

    /***
     * 第二种方式
     */
    public static void add1000ReadWrite(int countSum) {
        demoInteger = 0;
        ExecutorService executorService = Executors.newFixedThreadPool(countSum);
        long start = System.currentTimeMillis();
        CompletionService completionService = new ExecutorCompletionService(executorService);
        for (int i = 0; i < countSum; i++) {
            int finalI = i;
            completionService.submit(() -> {
                if (finalI == 0) {
                    write.lock();
                    try {
                        demoInteger++;
                    } finally {
                        write.unlock();
                    }
                } else {
                    read.lock();
                    try {
                        Integer value = demoInteger;
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        read.unlock();
                    }
                }

            }, null);
        }
        int count = 0;
        while (count < countSum) { // 等待任务完成全部
            if (completionService.poll() != null) {
                count++;
            }
        }
        long end = System.currentTimeMillis();

        System.out.println("[readWrite] " + (countSum - 1) + "次读操作{每次读操作 睡眠 1 ms}，"
                + 1 + "次 \" +1\" 操作以后， 结果为：" + demoInteger
                + "[耗时]:" + (end - start));
    }


    /***
     * synchronized
     */
    public static void add1000synchronized(int countSum) {
        demoInteger = 0;
        ExecutorService executorService = Executors.newFixedThreadPool(countSum);
        long start = System.currentTimeMillis();
        CompletionService completionService = new ExecutorCompletionService(executorService);
        for (int i = 0; i < countSum; i++) {
            int finalI = i;
            completionService.submit(() -> {
                synchronized (RWLockDemo.class) {
                    if (finalI == 0) {
                        demoInteger++;
                    } else {
                        try {
                            Thread.sleep(1);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        Integer value = demoInteger;
                    }
                }
            }, null);
        }
        int count = 0;
        while (count < countSum) { // 等待任务完成全部
            if (completionService.poll() != null) {
                count++;
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("[synchronized]  " + (countSum - 1) + "次读操作{每次读操作 睡眠 1 ms}，"
                + 1 + "次 \" +1\" 操作以后， 结果为：" + demoInteger
                + "[耗时]:" + (end - start));
    }
}
