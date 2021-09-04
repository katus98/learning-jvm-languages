package com.nx.vip.interrupt;

import com.nx.util.MyLog;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 超时加锁
 * @author SUN Katus
 * @version 1.0, 2021-08-28
 */
public class TryLockTest {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        lock.lock();
        new Thread(() -> {
            MyLog.info("开始尝试加锁");
            try {
                if (!lock.tryLock(2, TimeUnit.SECONDS)) {
                    MyLog.info("加锁失败");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t1").start();
    }
}
