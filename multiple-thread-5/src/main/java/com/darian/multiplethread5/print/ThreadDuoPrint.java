package com.darian.multiplethread5.print;

import com.darian.multiplethread5.ThreadPool.ThreadPoolDemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadDuoPrint {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 100; i++) {
            int finalI = i;
            executorService.execute(() ->
                    new ThreadDuoPrint().print(finalI)
            );
            executorService.execute(() ->
                    new ThreadDuoPrint().print(-finalI)
            );
        }

    }

    public void print(int integer) {
        System.out.println("【" + Thread.currentThread().getName() + "】: " + integer);
    }
}
