package com.nx.vip.wait;

import com.nx.util.MyLog;
import org.junit.jupiter.api.Test;
import org.openjdk.jol.info.ClassLayout;

import java.util.concurrent.TimeUnit;

/**
 * wait方法
 *   Object类方法, 要求调用对象必须被synchronized加锁, 否则直接抛出异常
 *   一旦执行Wait方法, 锁必然会膨胀为重量锁
 *   wait和sleep方法的区别在于wait会释放锁, sleep不会
 *   wait与while语句配合使用
 *
 * @author SUN Katus
 * @version 1.0, 2021-08-21
 */
public class WaitTest {
    private boolean hasFemale = false;
    private boolean hasMoney = false;

    /**
     * 要求调用对象必须被synchronized加锁, 否则直接抛出异常
     */
    @Test
    void basic() {
        Object lock = new Object();
        try {
            lock.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    void fat() {
        Object lock = new Object();
        Thread t1 = new Thread(() -> {
            synchronized (lock) {
                String info = ClassLayout.parseInstance(lock).toPrintable(lock);
                System.out.println(info);
            }
            try {
                lock.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t1");
        t1.start();
    }

    @Test
    void coding() throws InterruptedException {
        Object lock = new Object();
        Thread jack = new Thread(() -> {
            synchronized (lock) {
                while (!hasFemale) {
                    MyLog.info("没有对象");
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                MyLog.info("加班");
            }
        }, "jack");
        Thread rose = new Thread(() -> {
            synchronized (lock) {
                while (!hasMoney) {
                    MyLog.info("没有钱");
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                MyLog.info("加班");
            }
        }, "rose");
        jack.start();
        rose.start();
        TimeUnit.SECONDS.sleep(3);
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                synchronized (lock) {
                    MyLog.info("加班");
                }
            }, "t" + i).start();
        }
        new Thread(() -> {
            synchronized (lock) {
                hasFemale = true;
                hasMoney = true;
                MyLog.info("人和钱都到位了");
                // notify随机唤醒
                lock.notify();
                // notifyAll全部唤醒, 有可能会唤醒不需要唤醒的线程, 无法实现精确唤醒条件满足的线程
                lock.notifyAll();
            }
        }, "boss").start();
    }
}
