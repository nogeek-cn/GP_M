package com.darian.pub2018.chapter4;


public class OwenDemo {

    private SaveProcessor saveProcessor;

    public OwenDemo() {
        saveProcessor = new SaveProcessor();
        saveProcessor.start();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            Request request = new Request();
            request.setName("darianTest" + i);
            new OwenDemo().doTest(request);
        }
    }

    public void doTest(Request request) {
        saveProcessor.processorRequest(request);
    }

}
