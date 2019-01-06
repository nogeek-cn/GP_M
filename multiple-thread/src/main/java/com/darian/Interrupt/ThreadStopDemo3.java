package com.darian.Interrupt;

public class ThreadStopDemo3 {
    // 这种和 interrupted 方式是一样的。
    private static volatile boolean stop = true;

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            int i = 0;
            while (!stop) {
                i++;
            }
        });
        thread.start();
        System.out.println("begin start thread");
        Thread.sleep(1000);
        stop = true;
    }
}
