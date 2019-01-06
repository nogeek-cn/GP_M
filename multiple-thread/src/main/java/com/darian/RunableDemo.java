package com.darian;


public class RunableDemo implements Runnable {
    public static void main(String[] args) {
        new Thread(new RunableDemo()).start();
        new Thread(new RunableDemo()).start();
    }

    @Override
    public void run() {
        System.out.println("[" + Thread.currentThread().getName() + "]" + "runable My run().....");
    }

    private void falsewrite() {
        new RunableDemo().run();
        new RunableDemo().run();
    }
}
