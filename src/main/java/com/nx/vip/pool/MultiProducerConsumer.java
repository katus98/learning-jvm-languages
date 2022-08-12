package com.nx.vip.pool;

import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Semaphore;

/**
 * 通过信号量机制实现的多类别生产者-消费者模型
 *
 * @author SUN Katus
 * @version 1.0, 2022-08-12
 */
@Slf4j
public class MultiProducerConsumer {
    private static final int CAPACITY = 5, BOUND = 20;
    private final Buffer buffer;
    private final Semaphore mutex, a, b, empty;

    public MultiProducerConsumer() {
        this.buffer = new Buffer();
        this.mutex = new Semaphore(1);
        this.a = new Semaphore(0);
        this.b = new Semaphore(0);
        this.empty = new Semaphore(CAPACITY);
    }

    public class ProducerA implements Runnable {
        @Override
        public void run() {
            int i = 0;
            while (true) {
                try {
                    Thread.sleep(100);
                    Product product = new ProductA(i);
                    i = (i + 1) % BOUND;
                    empty.acquire();
                    mutex.acquire();
                    buffer.write(product);
                    log.info("Produced a product: {}", product);
                    mutex.release();
                    a.release();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public class ProducerB implements Runnable {
        @Override
        public void run() {
            int i = 0;
            while (true) {
                try {
                    Thread.sleep(100);
                    Product product = new ProductB(i);
                    i = (i + 1) % BOUND;
                    empty.acquire();
                    mutex.acquire();
                    buffer.write(product);
                    log.info("Produced a product: {}", product);
                    mutex.release();
                    b.release();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public class ConsumerA implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(100);
                    a.acquire();
                    mutex.acquire();
                    Product product = buffer.readByType("A");
                    log.info("Consumed a product: {}", product);
                    mutex.release();
                    empty.release();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public class ConsumerB implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(100);
                    b.acquire();
                    mutex.acquire();
                    Product product = buffer.readByType("B");
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
        private final Set<Product> set;

        public Buffer() {
            this.set = new HashSet<>();
        }

        public void write(Product product) {
            set.add(product);
        }

        public Product readByType(String productName) {
            for (Product product : set) {
                if (productName.equals(product.getName())) {
                    set.remove(product);
                    return product;
                }
            }
            return null;
        }
    }

    public static abstract class Product {
        public abstract String getName();
    }

    @ToString
    public static class ProductA extends Product {
        private final int id;

        public ProductA(int id) {
            this.id = id;
        }

        @Override
        public String getName() {
            return "A";
        }
    }

    @ToString
    public static class ProductB extends Product {
        private final int id;

        public ProductB(int id) {
            this.id = id;
        }

        @Override
        public String getName() {
            return "B";
        }
    }

    public static void main(String[] args) {
        MultiProducerConsumer multiProducerConsumer = new MultiProducerConsumer();
        new Thread(multiProducerConsumer.new ProducerA(), "ProducerA").start();
        new Thread(multiProducerConsumer.new ProducerB(), "ProducerB").start();
        new Thread(multiProducerConsumer.new ConsumerA(), "ConsumerA").start();
        new Thread(multiProducerConsumer.new ConsumerB(), "ConsumerB").start();
    }
}
