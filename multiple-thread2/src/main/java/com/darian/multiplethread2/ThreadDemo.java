package com.darian.multiplethread2;

public class ThreadDemo {
    private static volatile ThreadDemo instance = null;

    public static ThreadDemo getInstance() {
        if (instance==null){
            instance = new ThreadDemo();
        }
        return instance;
    }

    public static void main(String[] args) {
        ThreadDemo.getInstance();
    }
}
