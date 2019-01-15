package com.darian.ssssss;

import com.darian.request.PrintProcessor;
import com.darian.request.Request;
import lombok.RequiredArgsConstructor;

import java.util.concurrent.LinkedBlockingQueue;


import static java.lang.System.in;
import static java.lang.System.out;


@RequiredArgsConstructor
public class PrintProcessorZheng extends Thread implements Sout {
    LinkedBlockingQueue<Integer> integerLinkedBlockingQueue = new LinkedBlockingQueue<>();
    private final Sout nextSout;

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
                nextSout.print(-integer);
                if (integer == 100) {
                    break;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
