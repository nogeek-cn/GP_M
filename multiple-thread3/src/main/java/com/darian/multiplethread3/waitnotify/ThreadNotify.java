package com.darian.multiplethread3.waitnotify;

public class ThreadNotify extends Thread {
    private Object lock;

    public ThreadNotify(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock) {
            System.out.println("开始执行 ThreadNotify ");
            lock.notify();
            System.out.println("执行结束 ThreadNotify ");
        }
    }
}