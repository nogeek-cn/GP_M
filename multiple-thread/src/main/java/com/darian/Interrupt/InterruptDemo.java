package com.darian.Interrupt;


import java.util.concurrent.TimeUnit;

public class InterruptDemo {
    private static int i;
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            // 我去判断是否中断这个线程
            while (!Thread.currentThread().isInterrupted()) {
                i++;
            }
            System.out.println(i);
        }, "interruptDemo");
        thread.start();
        TimeUnit.SECONDS.sleep(1);
        // 通过线程的 interrupt  设置标识为 true
        System.out.println(thread.isInterrupted());
        thread.interrupt();
        System.out.println(thread.isInterrupted());
    }
}
