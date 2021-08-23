package com.nx.vip.wait;

import com.nx.util.MyLog;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * aqs框架下的wait机制
 *
 * @author SUN Katus
 * @version 1.0, 2021-08-21
 */
public class AwaitTest {
    private boolean hasFemale = false;
    private boolean hasMoney = false;
    private final ReentrantLock lock = new ReentrantLock();
    private final Condition fCondition = lock.newCondition();
    private final Condition mCondition = lock.newCondition();

    @Test
    void awaitTest() throws InterruptedException {
        Thread jack = new Thread(() -> {
            lock.lock();
            while (!hasFemale) {
                MyLog.info("没有对象");
                try {
                    fCondition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            MyLog.info("加班");
            lock.unlock();
        }, "jack");
        Thread rose = new Thread(() -> {
            lock.lock();
            while (!hasMoney) {
                MyLog.info("没有钱");
                try {
                    mCondition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            MyLog.info("加班");
            lock.unlock();
        }, "rose");
        jack.start();
        rose.start();
        TimeUnit.SECONDS.sleep(3);
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                lock.lock();
                MyLog.info("加班");
                lock.unlock();
            }, "t" + i).start();
        }
        new Thread(() -> {
            lock.lock();
            hasFemale = true;
            hasMoney = true;
            MyLog.info("找来了");
            // ReentrantLock可以实现精确唤醒
            mCondition.signalAll();
            fCondition.signalAll();
            lock.unlock();
        }, "boss").start();
    }
}
