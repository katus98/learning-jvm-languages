package com.katus.thread;

/**
 * 创建多线程的方式 2: 实现Runnable接口
 * @author SUN Katus
 * @version 1.0, 2020-08-10
 */
class MThread implements Runnable {
    // 实现Runnable接口中的run方法
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }
    }
}

public class ThreadTest1 {
    public static void main(String[] args) {
        MThread mThread = new MThread();   // 创建实现类对象
        Thread t1 = new Thread(mThread);   // 构造线程
        t1.start();   // 启动线程

        // 再次启动一个线程
        Thread t2 = new Thread(mThread);
        t2.start();
    }
}
