package com.darian.ThreadStatus;

import java.util.concurrent.TimeUnit;

public class ThreadStatusDemo {
    public static void main(String[] args) {
        new Thread(() -> {
            // TIME_WAITING
            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "timewaiting").start();

        new Thread(() -> {
            // WAITING，线程在 ThreadStatus 类锁上通过 wait 进行等待
            while (true) {   // 我们在一个循环里边获得一个锁
                synchronized (ThreadStatusDemo.class) {
                    try {
                        // 然后调用 wait()  方法，是因为它调用 wait 方法之前必须要获得锁
                        ThreadStatusDemo.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "waiting").start();

        // 线程在 ThreadStatus 枷锁后，不会释放锁
        new Thread(new blockDemo(), "blockDemo-0").start();
        new Thread(new blockDemo(), "blockDemo-1").start();
    }

    static class blockDemo extends Thread {
        @Override
        public void run() {
            synchronized (blockDemo.class) {
                while (true) {
                    try { // 100 秒，一直让它阻塞
                        TimeUnit.SECONDS.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
