package com.katus.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 创建多线程的方式 4: 使用线程池 (Java5 新特性)
 * @author SUN Katus
 * @version 1.0, 2020-08-10
 */
class NumberThread implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}

class NumberThread1 implements Callable {
    @Override
    public Object call() throws Exception {
        for (int i = 0; i <= 100; i++) {
            if (i % 2 != 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
        return null;
    }
}

public class ThreadTest3 {
    public static void main(String[] args) {
        // 提供指定线程数量的线程池
        ExecutorService service = Executors.newFixedThreadPool(10);   // ExecutorService 是返回对象实现的接口

        System.out.println(service.getClass());   // 验证实际返回的对象的类

        // 可选设置线程池的属性
        ThreadPoolExecutor executor = (ThreadPoolExecutor) service;   // ThreadPoolExecutor 才是实际返回的对象
        executor.setCorePoolSize(15);
        executor.setMaximumPoolSize(12);
        // executor.setKeepAliveTime(...);

        NumberThread numberThread = new NumberThread();
        service.execute(numberThread);   // 接受Runnable实现类

        NumberThread1 numberThread1 = new NumberThread1();
        service.submit(numberThread1);   // 接受Callable/Runnable实现类

        // 关闭线程池
        service.shutdown();
    }
}
