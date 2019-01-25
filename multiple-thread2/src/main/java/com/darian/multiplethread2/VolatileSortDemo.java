package com.darian.multiplethread2;

import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class VolatileSortDemo {
    private static int x = 0, y = 0;
    private static int a = 0, b = 0;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2); // 创建线程池
        CompletionService completionService = new ExecutorCompletionService(executorService);
        completionService.submit(() -> {
            a = 1;
            x = b;
        }, null);
        completionService.submit(() -> {
            b = 1;
            y = a;
        }, null);

        int count = 0;
        while (count < 2) {
            if (completionService.poll() != null) {
                count++;
            }
        }
        executorService.shutdown();
        System.out.println("[x=" + x + "]\t[y=" + y + "]");
    }
}
