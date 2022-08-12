package com.nx.vip.pool;

import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.Semaphore;

/**
 * 通过信号量解决吸烟者问题(单生产者生产多种产品, 多种消费者消费不同的产品)
 *
 * @author SUN Katus
 * @version 1.0, 2022-08-12
 */
@Slf4j
public class ProviderSmoker {
    private static final int CAPACITY = 5, BOUND = 20;
    private final Buffer buffer;
    private final Semaphore mutex, a, b, c, empty;

    public ProviderSmoker() {
        this.buffer = new Buffer();
        this.mutex = new Semaphore(1);
        this.a = new Semaphore(0);
        this.b = new Semaphore(0);
        this.c = new Semaphore(0);
        this.empty = new Semaphore(CAPACITY);
    }

    public class Provider implements Runnable {
        private final Random random;

        public Provider() {
            this.random = new Random();
        }

        @Override
        public void run() {
            int i = 0;
            while (true) {
                try {
                    Thread.sleep(50);
                    int r = random.nextInt(3);
                    Product product;
                    switch (r) {
                        case 0:
                            product = new ProductA(i);
                            break;
                        case 1:
                            product = new ProductB(i);
                            break;
                        default:
                            product = new ProductC(i);
                    }
                    i = (i + 1) % BOUND;
                    empty.acquire();
                    mutex.acquire();
                    buffer.write(product);
                    log.info("Provide a product: {}", product);
                    mutex.release();
                    switch (r) {
                        case 0:
                            a.release();
                            break;
                        case 1:
                            b.release();
                            break;
                        default:
                            c.release();
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public class SmokerA implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(100);
                    a.acquire();
                    mutex.acquire();
                    Product product = buffer.readByType("A");
                    log.info("Smoke a product: {}", product);
                    mutex.release();
                    empty.release();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public class SmokerB implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(100);
                    b.acquire();
                    mutex.acquire();
                    Product product = buffer.readByType("B");
                    log.info("Smoke a product: {}", product);
                    mutex.release();
                    empty.release();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public class SmokerC implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(100);
                    c.acquire();
                    mutex.acquire();
                    Product product = buffer.readByType("C");
                    log.info("Smoke a product: {}", product);
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

    @ToString
    public static class ProductC extends Product {
        private final int id;

        public ProductC(int id) {
            this.id = id;
        }

        @Override
        public String getName() {
            return "C";
        }
    }

    public static void main(String[] args) {
        ProviderSmoker providerSmoker = new ProviderSmoker();
        new Thread(providerSmoker.new Provider(), "Provider").start();
        new Thread(providerSmoker.new SmokerA(), "SmokerA").start();
        new Thread(providerSmoker.new SmokerB(), "SmokerB").start();
        new Thread(providerSmoker.new SmokerC(), "SmokerC").start();
    }
}
