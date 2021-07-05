package com.katus.thread;

/**
 * 线程安全之同步方法 本质上就是把同步代码块变成了整个方法
 * @author SUN Katus
 * @version 1.0, 2020-08-10
 */
class TicketSaleWindow2 implements Runnable {
    private int ticket;

    public TicketSaleWindow2(int number) {
        ticket = number;
    }

    @Override
    public void run() {
        do {
            show();
        } while (ticket > 0);
    }

    /*要注意同步方法在继承Thread类的方式下要改写成静态方法才能获得线程安全!!! 同步监视器为TicketSaleWindow2.class*/
    private synchronized void show() {   // 非静态同步方法的默认监视器是this
        if (ticket > 0) {
            System.out.println(Thread.currentThread().getName() + ":" + ticket--);
        }
    }
}

public class TicketSale2 {
    public static void main(String[] args) {
        TicketSaleWindow2 window = new TicketSaleWindow2(250);
        Thread t1 = new Thread(window), t2 = new Thread(window), t3 = new Thread(window);
        t1.start();
        t2.start();
        t3.start();
    }
}
