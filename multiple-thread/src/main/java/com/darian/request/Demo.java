package com.darian.request;

/***
 * 我们去处理的时候，用异步线程去处理。
 * 当我们把一个请求丢过来的时候，不是直接去处理，而是通过异步线程去处理。
 * zookeeper 就是类似的处理，一方面，你可以通过你的处理把职责划分开，
 * 一方面你可以通过异步线程的处理去提升你程序的性能
 * 合理的利用你 CPU 的资源
 */
public class Demo {
    private final PrintProcessor printProcessor;

    public Demo() {
        SaveProcessor saveProcessor = new SaveProcessor();
        saveProcessor.start();
        printProcessor = new PrintProcessor(saveProcessor);
        printProcessor.start();
    }

    public static void main(String[] args) {
        Request requset = new Request();
        requset.setName("darian");
        new Demo().doTest(requset);
    }

    public void doTest(Request request) {
        printProcessor.processorRequest(request);
    }
}
