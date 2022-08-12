package com.nx.vip.pool;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Semaphore;

/**
 * 用信号量解决读者-写者问题
 *
 * @author SUN Katus
 * @version 1.0, 2022-08-12
 */
@Slf4j
public class ReaderWriter {
    private static final int BOUND = 20;
    /**
     * 保证记录读进程数量的操作互斥(保证对readCount的操作是原子化的, 当然也可以使用原子类)
     */
    private final Semaphore mutex;
    /**
     * 保证写进程和其他进程之间的互斥关系
     */
    private final Semaphore rw;
    /**
     * 保证写进程不会饿死
     */
    private final Semaphore w;
    /**
     * 读进程正在读的数量
     */
    private int readCount;

    public ReaderWriter() {
        this.mutex = new Semaphore(1);
        this.rw = new Semaphore(1);
        this.w = new Semaphore(1);
        this.readCount = 0;
    }

    public class Reader implements Runnable {
        @Override
        public void run() {
            int i = 0;
            while (true) {
                try {
                    Thread.sleep(50);
                    w.acquire();
                    mutex.acquire();
                    if (readCount == 0) {
                        rw.acquire();
                    }
                    readCount++;
                    mutex.release();
                    w.release();
                    log.info("Reading {} ...", i);
                    i = (i + 1) % BOUND;
                    mutex.acquire();
                    if (readCount == 1) {
                        rw.release();
                    }
                    readCount--;
                    mutex.release();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public class Writer implements Runnable {
        @Override
        public void run() {
            int i = 0;
            while (true) {
                try {
                    Thread.sleep(100);
                    w.acquire();
                    rw.acquire();
                    log.info("Writing {} ...", i);
                    i = (i + 1) % BOUND;
                    rw.release();
                    w.release();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public static void main(String[] args) {
        ReaderWriter readerWriter = new ReaderWriter();
        new Thread(readerWriter.new Reader(), "Reader").start();
        new Thread(readerWriter.new Writer(), "Writer").start();
    }
}
