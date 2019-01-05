package com.darian.pub2018.chapter3;

import java.util.concurrent.*;

/**
 * <br>
 * <br>Darian
 **/
public class CallableDemo implements Callable<String> {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        CallableDemo callableDemo = new CallableDemo();

        Future<String> future = executorService.submit(callableDemo);
        //
        // 业务
        //
        System.out.println(future.get());//这里去阻塞
        executorService.shutdown();
    }

    @Override
    public String call() throws Exception {
        // 这里执行耗时较长的异步的操作
        return "string" + 1;
    }
}
