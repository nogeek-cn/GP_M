package com.darian;


/**
 * Hello world!
 */
public class MyThread extends Thread {
    public static void main(String[] args) {
        new MyThread().start();
        new MyThread().start();
    }

    @Override
    public void run() {
        System.out.println("[" + Thread.currentThread().getName() + "]" + "MyThrea run().....");
    }
}
