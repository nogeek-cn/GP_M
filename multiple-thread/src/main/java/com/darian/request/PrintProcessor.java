package com.darian.request;

import lombok.RequiredArgsConstructor;


import java.util.concurrent.LinkedBlockingQueue;

import static java.lang.System.*;


@RequiredArgsConstructor
public class PrintProcessor extends Thread implements RequestProcessor {
    LinkedBlockingQueue<Request> linkedBlockingQueue = new LinkedBlockingQueue<>();
    private final RequestProcessor nextProcess;

    @Override
    public void processorRequest(Request requset) {
        linkedBlockingQueue.add(requset);
    }

    @Override
    public void run() {
        while (true){
            try {
                Request requset = linkedBlockingQueue.take();
                out.println("print Data:" + requset);
                nextProcess.processorRequest(requset);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
