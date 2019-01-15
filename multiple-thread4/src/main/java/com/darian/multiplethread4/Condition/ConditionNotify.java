package com.darian.multiplethread4.Condition;

import lombok.RequiredArgsConstructor;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

@RequiredArgsConstructor
public class ConditionNotify extends Thread {
    private final Lock lock;
    private final Condition condition;

    @Override
    public void run() {
        lock.lock();
        try {
            System.out.println("【" + Thread.currentThread().getName() + "】开始执行 condition.signal()");
            condition.signal();  // signal 和 signalAll
            System.out.println("【" + Thread.currentThread().getName() + "】执行结束 condition.signal()");
        } finally {
            lock.unlock();
        }
    }
}
