package com.darian.multiplethread3.waitnotify;

public class ThreadWait extends Thread {
    private Object lock;

    public ThreadWait(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock) {
            System.out.println("开始执行 ThreadWait ");
            try {
                lock.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("执行结束 ThreadWait ");
        }
    }
}
