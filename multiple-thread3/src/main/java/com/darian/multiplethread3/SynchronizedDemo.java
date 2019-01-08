package com.darian.multiplethread3;


import static java.lang.System.out;

public class SynchronizedDemo {
    private static int count = 0;

    Object lock = new Object();
    public void demo3(){
        synchronized(lock){

        }
    }

    public void demo(){
        // 全局锁，多个对象是同一把锁
        synchronized (SynchronizedDemo.class){

        }
    }

    public void demo1(){
        // 每个实例是不同的锁
        synchronized (this){

        }
    }

    public synchronized static void incr() {
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        count++;
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 1000; i++) {
            new Thread(() -> SynchronizedDemo.incr()).start();
        }
        Thread.sleep(4000);
        out.println("result: " + SynchronizedDemo.count);
    }
}
