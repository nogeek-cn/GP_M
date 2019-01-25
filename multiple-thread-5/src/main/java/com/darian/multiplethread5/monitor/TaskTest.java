package com.darian.multiplethread5.monitor;

import java.util.concurrent.ExecutorService;

public class TaskTest extends Thread {
    static ExecutorService executorService = MyExecutors.newCachedThreadPool();

    @Override
    public void run() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("TaskTest: run" + Thread.currentThread().getName());
    }

}
