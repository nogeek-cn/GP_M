package com.darian.safe;

/***
 *
 */
public class AutomicDemo {
    private static int count = 0;

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 1000; i++) {
            new Thread(AutomicDemo::inc).start();
        }
        Thread.sleep(4000);
        System.out.println("y运行结果：" + count);
        // y运行结果：952
    }

    public static void inc() {
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        count++;
    }
}
