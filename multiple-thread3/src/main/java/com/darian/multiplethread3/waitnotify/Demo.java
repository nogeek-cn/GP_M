package com.darian.multiplethread3.waitnotify;

public class Demo {
    public static void main(String[] args) {
        // 我将锁传进去，就可以实现对象同用一把锁。
        // 还可以控制锁的范围
        Object lock = new Object();
        ThreadWait threadWait = new ThreadWait(lock);
        ThreadNotify threadNotify = new ThreadNotify(lock);
        threadWait.start();
        threadNotify.start();
    }
}
