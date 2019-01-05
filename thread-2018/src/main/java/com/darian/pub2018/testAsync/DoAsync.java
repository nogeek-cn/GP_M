package com.darian.pub2018.testAsync;

import org.springframework.scheduling.annotation.Async;

/**
 * <br>
 * <br>Darian
 **/
public class DoAsync {

    @Async
    public void doAsync(){
        System.out.printf("[Thread: %s ]",Thread.currentThread());
        System.out.println();
    }
}
