package com.nx.vip.interrupt;

import com.nx.util.MyLog;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author SUN Katus
 * @version 1.0, 2021-08-28
 */
public class ReadWriteLockTest {
    /**
     * (没有阻塞之前)读读并发, 如果被写锁阻塞, 后续的读锁无法与写锁前面的读锁并发
     * 并发仅限于连续的读锁可以一起并发
     */
    @Test
    void test() {
        ReadWriteLock rwLock = new ReentrantReadWriteLock();
        Lock readLock = rwLock.readLock();
        Lock writeLock = rwLock.writeLock();
        Thread t1 = new Thread(() -> {
            readLock.lock();
            MyLog.info("t1获取到读锁");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                readLock.unlock();
            }
        }, "t1");
        Thread t2 = new Thread(() -> {
            readLock.lock();
            MyLog.info("t2获取到读锁");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                readLock.unlock();
            }
        }, "t2");
        t1.start();
        t2.start();
    }

    /**
     * 读写互斥
     */
    @Test
    void rw() throws InterruptedException {
        ReadWriteLock rwLock = new ReentrantReadWriteLock();
        Lock readLock = rwLock.readLock();
        Lock writeLock = rwLock.writeLock();
        Thread t1 = new Thread(() -> {
            readLock.lock();
            MyLog.info("t1获取到读锁");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                readLock.unlock();
            }
        }, "t1");
        Thread t2 = new Thread(() -> {
            writeLock.lock();
            MyLog.info("t2获取到读锁");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                writeLock.unlock();
            }
        }, "t2");
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }

    /**
     * 支持w->r重入; 但是反之不允许, 因为会导致无法终止其他正在持有读锁的线程
     */
    @Test
    void r() {
        ReadWriteLock rwLock = new ReentrantReadWriteLock();
        Lock readLock = rwLock.readLock();
        Lock writeLock = rwLock.writeLock();
        writeLock.lock();
        readLock.lock();
        readLock.unlock();
        writeLock.unlock();
    }
}
