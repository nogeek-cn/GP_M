package com.darian.request;


import lombok.RequiredArgsConstructor;

import java.util.concurrent.LinkedBlockingQueue;

@RequiredArgsConstructor
public class SaveProcessor extends Thread implements RequestProcessor {

    LinkedBlockingQueue<Request> linkedBlockingQueue = new LinkedBlockingQueue<>();

    @Override
    public void processorRequest(Request requset) {
        linkedBlockingQueue.add(requset);
    }

    @Override
    public void run() {
        while (true){
            try {
                Request requset = linkedBlockingQueue.take();
                System.out.println("print data:" + requset);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
