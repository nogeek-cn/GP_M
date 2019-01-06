package com.darian.multiplethread2;

public class VolatileIncrDemo {
    volatile int i = 0;

    public void incr() {
        i++;
    }

    public static void main(String[] args) {
        new VolatileIncrDemo().incr();
    }
}
