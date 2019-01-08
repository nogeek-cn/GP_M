package com.darian.multiplethread3;

public class Demo {
    static volatile int a = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread();
        thread.start();
        thread.join();
    }
}
