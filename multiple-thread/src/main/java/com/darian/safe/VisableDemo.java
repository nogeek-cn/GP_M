package com.darian.safe;


import java.util.concurrent.TimeUnit;

/***
 * 可见性问题
 */
public class VisableDemo {
    // 加上 volatile 之后，才可以停止。
    private volatile static boolean stop = false;

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            int i = 0;
            while (!stop) {
                i++;
            }
        });
        thread.start();
        TimeUnit.SECONDS.sleep(1);
        stop = true;
    }
}
