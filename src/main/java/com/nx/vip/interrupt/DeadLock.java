package com.nx.vip.interrupt;

import com.nx.util.MyLog;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author SUN Katus
 * @version 1.0, 2021-08-28
 */
public class DeadLock {
    public static void main(String[] args) {
        Lock x = new ReentrantLock();
        Lock y = new ReentrantLock();
        Thread t1 = new Thread(() -> {
            x.lock();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            y.lock();
            MyLog.info("y lock");
            y.unlock();
            x.unlock();
        }, "t1");
        Thread t2 = new Thread(() -> {
            y.lock();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            x.lock();
            MyLog.info("x lock");
            x.unlock();
            y.unlock();
        }, "t2");
        t1.start();
        t2.start();
    }
}
