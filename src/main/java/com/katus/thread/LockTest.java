package com.katus.thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 线程安全之Lock锁 (Java5新特性)
 * @author SUN Katus
 * @version 1.0, 2020-08-10
 */
class TicketSaleWindow3 implements Runnable {
    private int ticket;
    private final ReentrantLock lock = new ReentrantLock();

    public TicketSaleWindow3(int number) {
        ticket = number;
    }

    @Override
    public void run() {
        while (true) {
            try {
                lock.lock();
                if (ticket > 0) {
                    System.out.println(Thread.currentThread().getName() + ":" + ticket--);
                } else {
                    break;
                }
            } finally {
                lock.unlock();
            }
        }
    }
}

public class LockTest {
}
