package com.nx.vip.interrupt;

import com.nx.util.MyLog;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * interrupt()不会打断正在运行中的线程
 * Thread.interrupted()返回当前线程是否被打断, 同时清除打断状态
 * isInterrupted()返回调用对象是否被打断, 但是不会清除打断状态
 *
 * @author SUN Katus
 * @version 1.0, 2021-08-28
 */
public class InterruptTest {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                MyLog.info("" + i);
            }
            MyLog.info("" + Thread.interrupted());
            // 第二次执行必然会将打断标记清除, 所以无论如何都是false
            MyLog.info("" + Thread.interrupted());
        }, "t1");
        t1.start();
        t1.interrupt();
        MyLog.info("t1: " + t1.isInterrupted());
        MyLog.info("t1: " + t1.isInterrupted());
        MyLog.info("" + Thread.interrupted());
    }

    @Test
    void test5() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            MyLog.info("t1 start");
            try {
                TimeUnit.SECONDS.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 另一种非异常的逻辑写法
            while (!Thread.interrupted()) {
                // todo
            }
            MyLog.info("out of sleep");
        }, "t1");
        t1.start();
        MyLog.info("main start");
        TimeUnit.SECONDS.sleep(5);
        // 打断会让t1线程抛出InterruptedException从而离开循环耗时的业务逻辑
        t1.interrupt();
    }

    @Test
    void testLock() throws InterruptedException {
        Lock lock = new ReentrantLock();
        lock.lock();
        Thread t1 = new Thread(() -> {
            MyLog.info("尝试获取锁 理应获取不到");
            try {
                // 如果被打断则加锁终止
                lock.lockInterruptibly();
                MyLog.info("加锁成功");
            } catch (InterruptedException e) {
                MyLog.info("被cancel了");
                e.printStackTrace();
            }
            lock.unlock();
        }, "t1");
        t1.start();
        TimeUnit.SECONDS.sleep(10);
        MyLog.info("t1 拿不到锁");
        t1.interrupt();
    }
}
