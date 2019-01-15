package com.darian.ssssss;



public class Demoprint {
    private final PrintProcessorZheng printProcessorZheng;

    public Demoprint() {
        PrintProcessorFu printProcessorFu = new PrintProcessorFu();
        printProcessorFu.start();
        printProcessorZheng = new PrintProcessorZheng(printProcessorFu);
        printProcessorFu.setNextPrintProcessor(printProcessorZheng);
        printProcessorZheng.start();
    }

    public static void main(String[] args) {
        Demoprint demo = new Demoprint();
            demo.doTest(1);
    }

    public void doTest(Integer integer) {
       printProcessorZheng.print(integer);
    }
}
