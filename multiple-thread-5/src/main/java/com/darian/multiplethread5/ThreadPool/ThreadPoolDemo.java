package com.darian.multiplethread5.ThreadPool;

import lombok.RequiredArgsConstructor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.lang.System.*;

@RequiredArgsConstructor
public class ThreadPoolDemo extends Thread {
    private final int i ;
    static ExecutorService executorService
            = Executors.newFixedThreadPool(3);

    @Override
    public void run() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        out.println("[" + Thread.currentThread().getName() + "]:" + i);
    }

    public static void main(String[] args) {
        for (int i = 0; i <= 100; i++) {
            executorService.execute(new ThreadPoolDemo(i));
        }
        executorService.shutdown();
    }
}
