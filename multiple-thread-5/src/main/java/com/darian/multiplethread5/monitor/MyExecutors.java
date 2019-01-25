package com.darian.multiplethread5.monitor;


import java.util.Map;
import java.util.concurrent.*;

public class MyExecutors {

    public static ExecutorService newFixedThreadPool(int nThreads) {
        return new MyThreadPoolExecutor(nThreads, nThreads,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>());
    }


    public static ExecutorService newFixedThreadPool(int nThreads, ThreadFactory threadFactory) {
        return new MyThreadPoolExecutor(nThreads, nThreads,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(),
                threadFactory);
    }


    public static ExecutorService newSingleThreadExecutor() {
        return new MyThreadPoolExecutor(1, 1,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>());
    }


    public static ExecutorService newCachedThreadPool() {
        return new MyThreadPoolExecutor(0, Integer.MAX_VALUE,
                60L, TimeUnit.SECONDS,
                new SynchronousQueue<Runnable>());
    }


}
