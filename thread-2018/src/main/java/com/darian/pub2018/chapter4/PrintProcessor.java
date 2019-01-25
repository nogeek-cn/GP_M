package com.darian.pub2018.chapter4;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * <br>
 * <br>Darian
 **/
public class PrintProcessor extends Thread implements RequestProcessor {

    LinkedBlockingQueue<Request> linkedBlockingQueue = new LinkedBlockingQueue<Request>();

    private final RequestProcessor requestProcessor;

    public PrintProcessor(RequestProcessor requestProcessor) {
        this.requestProcessor = requestProcessor;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Request request = linkedBlockingQueue.take();
                System.out.println(Thread.currentThread() + "---Print Data：" + request + "-----");
                requestProcessor.processorRequest(request);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void processorRequest(Request request) {
        linkedBlockingQueue.add(request);
    }
}
