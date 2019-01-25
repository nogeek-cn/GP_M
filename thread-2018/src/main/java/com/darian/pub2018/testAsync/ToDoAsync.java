package com.darian.pub2018.testAsync;

/**
 * <br>
 * <br>Darian
 **/
public class ToDoAsync {
    public static void main(String[] args) {
        for (int i = 0; i < 90; i++) {
            DoAsync doAsync = new DoAsync();
            System.out.printf("[Thread: %s ]", Thread.currentThread());
            doAsync.doAsync();
        }
    }

}
