package com.nx.vip.pool;

import com.nx.util.MyLog;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 线程池会创建持有线程: 核心为线程池不会轻易创建新的线程
 * 如果工作中的线程数 < 核心线程数, 直接启动核心线程去运行
 * 如果工作中的线程数 >= 核心线程数, 放入队列
 * 如果队列满了, 判断是否达到最大线程数, 启动新的线程运行
 * 核心线程并不一定总是那些线程, 仅仅是保留相应的数量
 *
 *
 * @author SUN Katus
 * @version 1.0, 2021-09-02
 */
public class ThreadPool {
    AtomicInteger integer = new AtomicInteger(0);

    @Test
    void test() {
        /*
         * 1 核心线程数CTC: 通常不会死亡
         * 2 最大线程数 = 核心线程数 + 空闲线程数
         * 3 空闲线程的存活时间
         * 4 空闲线程的存活时间单位
         * 5 队列 有界/无界
         * 6 线程工厂
         * 7 超过队列和最大线程数量时的策略
         */
        ArrayBlockingQueue<Runnable> queue = new ArrayBlockingQueue<>(1);
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                1,
                2,
                3,
                TimeUnit.SECONDS,
                queue,
                r -> new Thread(r, "t" + integer.incrementAndGet()));
        for (int i = 0; i < 4; i++) {
            executor.execute(new MyTask("task-" + i));
        }
        executor.shutdown();
    }

    public static class MyTask implements Runnable {
        private final String name;

        public MyTask(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            MyLog.info(name);
        }
    }
}
