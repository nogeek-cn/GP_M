package com.darian.pub2018.chapter4;


import com.sun.org.apache.regexp.internal.RE;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.System.out;
import static java.lang.System.setProperties;

/**
 * <br>
 * <br>Darian
 **/
public class Demo {


    PrintProcessor printProcessor;

    public Demo() {
        SaveProcessor saveProcessor = new SaveProcessor();
        saveProcessor.start();
        printProcessor = new PrintProcessor(saveProcessor);
        printProcessor.start();
    }

    public static void main(String[] args) {

        Request request1 = new Request();
//        request1.setName("darian");
        System.exit(1);
        for (int i = 0; i < 20000; i++) {
            Request request = new Request();
            request.setName("darian" + i);
            new Demo().doTest(request);
        }

    }

    public void doTest(Request request) {
        printProcessor.processorRequest(request);
    }
}
