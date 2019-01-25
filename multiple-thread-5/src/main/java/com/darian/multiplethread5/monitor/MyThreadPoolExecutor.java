package com.darian.multiplethread5.monitor;


import java.util.Date;
import java.util.concurrent.*;

import static java.lang.System.*;

public class MyThreadPoolExecutor extends ThreadPoolExecutor {

    // beforeExecutor 、 AfterExecutor 、 shutDown
    // 重写父类的方法，然后，在方法内进行数据的上报。

    private static ConcurrentMap<String, Date> startTime = new ConcurrentHashMap<>();

    public MyThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    public MyThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory);
    }

    public MyThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, RejectedExecutionHandler handler) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, handler);
    }

    public MyThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory, RejectedExecutionHandler handler) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory, handler);
    }


    @Override
    public void shutdown() {
        // 此处是 Demo, 此处去过滤
        out.println("已经执行的任务数量：\t" + this.getCompletedTaskCount());
        out.println("当前的活动线程数：\t" + this.getActiveCount());
        out.println("当前排队的线程数：\t" + this.getQueue().size());

        super.shutdown();
    }


    @Override
    protected void beforeExecute(Thread t, Runnable r) {
        startTime.putIfAbsent(String.valueOf(r.hashCode()), new Date());
        super.beforeExecute(t, r);
    }

    @Override
    protected void afterExecute(Runnable r, Throwable t) {
        Date statData = startTime.remove(String.valueOf(r.hashCode()));
        Date endDate = new Date();
        long costTime = endDate.getTime() - statData.getTime();
        out.println("任务耗时时间：(ms)\t" + costTime);
        out.println("最大允许的线程数：\t" + this.getMaximumPoolSize());
        out.println("线程的空闲时间(ms)：\t" + this.getKeepAliveTime(TimeUnit.MILLISECONDS));
        out.println("任务总数：\t" + this.getTaskCount());
        super.afterExecute(r, t);
    }
}
