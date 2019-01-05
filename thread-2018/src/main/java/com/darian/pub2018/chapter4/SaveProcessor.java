package com.darian.pub2018.chapter4;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * <br>
 * <br>Darian
 **/
public class SaveProcessor extends Thread implements RequestProcessor {

    LinkedBlockingQueue<Request> linkedBlockingQueue = new LinkedBlockingQueue<Request>();

    @Override
    public void run() {
        while (true) {
            try {
                Request request = linkedBlockingQueue.take();
                System.out.println(Thread.currentThread() + "---save Data：" + request + "======");
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
