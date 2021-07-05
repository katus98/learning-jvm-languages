package com.katus.thread;

/**
 * 线程安全之同步代码块
 * @author SUN Katus
 * @version 1.0, 2020-08-10
 */
class TicketSaleWindow implements Runnable {
    private int ticket;
    private final Object lock = new Object();

    public TicketSaleWindow(int number) {
        ticket = number;
    }

    @Override
    public void run() {
        while (true) {
            // 同步代码块 接受同步监视器（锁）任何类的对象 要求多线程的锁是同一个对象
            synchronized (lock) {   // synchronized (this) 最简单的写法   // synchronized (TicketSaleWindow.class)
                if (ticket > 0) {
                    System.out.println(Thread.currentThread().getName() + ":" + ticket--);
                } else {
                    break;
                }
            }
        }
    }
}

public class TicketSale {
    public static void main(String[] args) {
        TicketSaleWindow window = new TicketSaleWindow(250);
        Thread t1 = new Thread(window), t2 = new Thread(window), t3 = new Thread(window);
        t1.start();
        t2.start();
        t3.start();
    }
}
