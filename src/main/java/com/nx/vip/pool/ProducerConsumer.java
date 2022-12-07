package com.nx.vip.pool;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;

/**
 * 管程实现的生产者消费者模型
 *
 * @author SUN Katus
 * @version 1.0, 2022-07-29
 */
@Slf4j
public class ProducerConsumer {
    @Slf4j
    public static class Producer extends Thread {
        private final Monitor monitor;
        private final Random random;

        public Producer(String name, Monitor monitor) {
            super(name);
            this.monitor = monitor;
            this.random = new Random();
        }

        private int produceItem() {
            int item = random.nextInt(100);
            log.info("{}", item);
            return item;
        }

        @Override
        public void run() {
            int item;
            // 生产者循环
            while (true) {
                item = produceItem();
                monitor.insert(item);
            }
        }
    }

    @Slf4j
    public static class Consumer extends Thread {
        private final Monitor monitor;

        public Consumer(String name, Monitor monitor) {
            super(name);
            this.monitor = monitor;
        }

        private void consumeItem(int item) {
            log.info("{}", item);
        }

        @Override
        public void run() {
            int item;
            while (true) {
                item = monitor.remove();
                consumeItem(item);
            }
        }
    }

    @Slf4j
    public static class Monitor {
        private static final int N = 100;
        // 缓冲区是循环使用的
        private final int[] buffer = new int[N];
        private int count = 0, lo = 0, hi = 0;

        private synchronized void insert(int val) {
            if (count == N) {
                // 如果缓冲区是满的，则进入休眠
                goToSleep();
            }
            // 向缓冲区插入内容
            buffer[hi] = val;
            // 找到下一个槽的为止
            hi = (hi + 1) % N;
            // 缓冲区中的数目自增 1
            count = count + 1;
            if (count == 1) {
                // 如果消费者睡眠，则唤醒
                notify();
            }
        }

        private synchronized int remove() {
            int val;
            if (count == 0) {
                // 缓冲区是空的，进入休眠
                goToSleep();
            }
            // 从缓冲区取出数据
            val = buffer[lo];
            // 设置待取出数据项的槽
            lo = (lo + 1) % N;
            // 缓冲区中的数据项数目减 1
            count = count - 1;
            if (count == N - 1) {
                // 如果生产者睡眠，唤醒它
                notify();
            }
            return val;
        }

        private void goToSleep() {
            try {
                wait();
            } catch (InterruptedException e) {
                log.error("Inter", e);
            }
        }
    }

    public static void main(String[] args) {
        Monitor monitor = new Monitor();
        new Producer("producer", monitor).start();
        new Consumer("consumer", monitor).start();
    }
}
