package com.darian.multiplethread2;

public class VolatileDemo {
    public static void main(String[] args) {
        // as-if-serial
        int a = 2;
        int b = 3;
        int c = a + b;
    }
}
