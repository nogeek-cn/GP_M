package com.darian.multiplethread5.semaphore;

import lombok.AllArgsConstructor;


import java.util.concurrent.Semaphore;

public class SemaphoreDemo {
    public static void main(String[] args) {
        // 支持公平锁和非公平锁
        Semaphore semaphore = new Semaphore(5);

        for (int i = 0; i < 10; i++) {
            new DoAnyThing(i, semaphore).start();
        }
    }

    @AllArgsConstructor
    public static class DoAnyThing extends Thread {
        private int num;
        private Semaphore semaphore;

        @Override
        public void run() {
            try {
                semaphore.acquire(); // 获取一个令牌
                System.out.println("第" + num + "个线程进入");
                Thread.sleep(2000);
                semaphore.release();  // 释放令牌
                System.out.println("第" + num + "个 释放令牌");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
