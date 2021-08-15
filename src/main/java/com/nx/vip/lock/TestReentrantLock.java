package com.nx.vip.lock;

import com.nx.util.MyLog;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock范例
 *
 * @author SUN Katus
 * @version 1.0, 2021-08-15
 */
public class TestReentrantLock {
    private static Lock lock = new ReentrantLock(true);

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            lock.lock();
            MyLog.info("t1");
            MyLog.info("t1");
            MyLog.info("t1");
            MyLog.info("t1");
            MyLog.info("t1");
            MyLog.info("t1");
            MyLog.info("t1");
            MyLog.info("t1");
            // 实际解锁的代码应该在finally代码块内
            lock.unlock();
        }, "t1");
        Thread t2 = new Thread(() -> {
            lock.lock();
            MyLog.info("t2");
            MyLog.info("t2");
            MyLog.info("t2");
            MyLog.info("t2");
            MyLog.info("t2");
            MyLog.info("t2");
            MyLog.info("t2");
            MyLog.info("t2");
            lock.unlock();
        }, "t2");
        t1.start();
        t2.start();
    }
}
