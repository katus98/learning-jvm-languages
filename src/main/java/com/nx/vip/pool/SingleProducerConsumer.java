package com.nx.vip.pool;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 * 通过信号量机制实现的单生产者-消费者模型
 *
 * @author SUN Katus
 * @version 1.0, 2022-08-12
 */
@Slf4j
public class SingleProducerConsumer {
    private static final int CAPACITY = 5, BOUND = 20;
    private final Random random;
    private final Buffer buffer;
    private final Semaphore mutex, full, empty;

    public SingleProducerConsumer() {
        this.random = new Random();
        this.buffer = new Buffer();
        this.mutex = new Semaphore(1);
        this.full = new Semaphore(0);
        this.empty = new Semaphore(CAPACITY);
    }

    public class Producer implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
                    int product = random.nextInt(BOUND);
                    Thread.sleep(100);
                    // 互斥操作必须在同步操作之后, 否则会死锁 (保证只有满足了同步关系才允许访问临界资源)
                    empty.acquire();
                    mutex.acquire();
                    buffer.write(product);
                    log.info("Produced a product: {}", product);
                    mutex.release();
                    full.release();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public class Consumer implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(100);
                    full.acquire();
                    mutex.acquire();
                    int product = buffer.read();
                    log.info("Consumed a product: {}", product);
                    mutex.release();
                    empty.release();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public static class Buffer {
        private final int[] buffer;
        private int index;

        public Buffer() {
            this.buffer = new int[CAPACITY];
            this.index = 0;
        }

        public boolean isFull() {
            return index == CAPACITY;
        }

        public boolean isEmpty() {
            return index == 0;
        }

        public void write(int product) {
            buffer[index++] = product;
        }

        public int read() {
            return buffer[--index];
        }
    }

    public static void main(String[] args) {
        SingleProducerConsumer singleProducerConsumer = new SingleProducerConsumer();
        new Thread(singleProducerConsumer.new Consumer(), "Consumer").start();
        new Thread(singleProducerConsumer.new Producer(), "Producer").start();
    }
}
