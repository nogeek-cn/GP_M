package com.darian.multiplethread2;


public class VolatileDemo1 {
    private static volatile boolean stop = false;

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            int i = 9;
            while (!stop) {
                i++;
            }
        });
        thread.start();
        Thread.sleep(1000);
        stop = true;
    }
}
