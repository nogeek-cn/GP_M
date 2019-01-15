package com.darian.multiplethread4.Condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConnditionDemo {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        ConditionWait conditionWait = new ConditionWait(lock, condition);
        conditionWait.start();
        ConditionNotify conditionNotify = new ConditionNotify(lock, condition);
        conditionNotify.start();
    }
}
