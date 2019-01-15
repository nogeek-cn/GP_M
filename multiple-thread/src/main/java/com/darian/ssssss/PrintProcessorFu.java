package com.darian.ssssss;

import java.util.concurrent.LinkedBlockingQueue;

import static java.lang.System.out;

public class PrintProcessorFu extends Thread implements Sout {
    LinkedBlockingQueue<Integer> integerLinkedBlockingQueue = new LinkedBlockingQueue<>();
    private Sout nextPrintProcessor;

    public void setNextPrintProcessor(Sout nextPrintProcessor) {
        this.nextPrintProcessor = nextPrintProcessor;
    }

    @Override
    public void print(Integer integer) {
        integerLinkedBlockingQueue.add(integer);
    }

    @Override
    public void run() {
        while (true) {
            try {
                Integer integer = integerLinkedBlockingQueue.take();
                out.println("[" + Thread.currentThread().getName() + "] " + "print Data:" + integer);
                nextPrintProcessor.print((-integer) + 1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
