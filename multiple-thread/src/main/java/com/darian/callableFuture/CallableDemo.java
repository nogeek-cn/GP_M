package com.darian.callableFuture;

import java.util.concurrent.*;

/***
 * 当你想要异步的线程执行你的某一个逻辑，那么在这个运行结束以后
 * 我想要拿到子线程运行的结果
 */
public class CallableDemo implements Callable<String> {
    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        CallableDemo callableDemo = new CallableDemo();

        Future<String> future = executorService.submit(callableDemo);
        /***
         * 这里可以写其它的业务
         * 去写其它东西
         */
        String returnValue = future.get(); // 这个地方再阻塞
        System.out.println(returnValue);
        executorService.shutdown();
    }

    @Override
    public String call() throws Exception {
        return "darain" + 1;
    }
}
