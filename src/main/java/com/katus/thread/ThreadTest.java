package com.katus.thread;

/**
 * 创建多线程的方式 1: 创建Thread子类
 * @author SUN Katus
 * @version 1.0, 2020-08-09
 */
class MyThread extends Thread {   // 因为要求继承Thread类 导致本类不能是其他类的子类
    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {   // 此线程执行的操作
        try {
            sleep(1000);   // 本线程阻塞???ms
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 50; i++) {
            if (i % 2 == 0) {
                System.out.println(this.getName() + ":" + i);
            }
//            if (i % 20 == 0) {
//                Thread.yield();   // 释放当前线程CPU的执行权, 但是有可能又被CPU分配到了
//            }
        }
    }
}

public class ThreadTest {
    public static void main(String[] args) {
        Thread.currentThread().setName("Thread-main");
        Thread.currentThread().setPriority(Thread.MIN_PRIORITY);   // 设置最低优先级
        // 创建线程对象
        MyThread t1 = new MyThread("Thread-1st");
        t1.setPriority(Thread.MAX_PRIORITY);   // 设置最高优先级
        // 开始执行线程, 主线程继续
        // t1.setName("Thread-1st");
        t1.start();   // 启动当前线程并调用当前线程的run()
        // t1.run();   // 错误的启动线程的方法
        // t1.start();   // 不能让已经start的线程再次start
        for (int i = 0; i < 50; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
            if (i == 30) {
                try {
                    t1.join();   // 调用后本线程阻塞, t1线程执行至结束, 本线程取消阻塞
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(t1.isAlive());   // 判断线程是否存活 如果执行完毕即不存活
    }
}
