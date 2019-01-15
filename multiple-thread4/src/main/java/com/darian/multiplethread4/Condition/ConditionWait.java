package com.darian.multiplethread4.Condition;

import lombok.RequiredArgsConstructor;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

@RequiredArgsConstructor
public class ConditionWait extends Thread {
    private final Lock lock;
    private final Condition condition;

    @Override
    public void run() {
        lock.lock();
        try {
            System.out.println("【" + Thread.currentThread().getName() + "】开始执行 condition.await()");
            condition.await();  //
            System.out.println("【" + Thread.currentThread().getName() + "】执行结束 condition.await()");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
