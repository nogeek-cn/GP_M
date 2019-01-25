package com.darian.multiplethread5.monitor;


import java.util.concurrent.ExecutorService;

public class Demo {
    public static void main(String[] args) {
        TaskTest taskTest = new TaskTest();

        ExecutorService executorService = taskTest.executorService;
        for (int i = 0; i < 3000; i++) {
            executorService.execute(new TaskTest());
        }
        executorService.shutdown();
    }

}
