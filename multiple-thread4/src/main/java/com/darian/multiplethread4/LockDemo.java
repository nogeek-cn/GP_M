package com.darian.multiplethread4;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockDemo {
    static Lock lock = new ReentrantLock();// 有公平重入锁和非公平重入锁

    private static int count = 0;

    public static void incr(){
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock.lock(); // 获得锁
        count ++;
        lock.unlock();
    }
}
