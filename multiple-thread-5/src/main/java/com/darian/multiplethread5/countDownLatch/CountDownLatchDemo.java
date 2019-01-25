package com.darian.multiplethread5.countDownLatch;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(4);
        new Thread(() -> countDownLatch.countDown()   /*递减*/).start();
        new Thread(() -> countDownLatch.countDown()).start();
        new Thread(() -> countDownLatch.countDown()).start();
        new Thread(() -> countDownLatch.countDown()).start();

        countDownLatch.await();
        System.out.println("执行完毕");
    }
}
