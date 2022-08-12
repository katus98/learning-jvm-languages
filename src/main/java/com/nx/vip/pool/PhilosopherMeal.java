package com.nx.vip.pool;

import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 * 用信号量解决哲学家进餐问题 (预防死锁)
 * * 策略1 总计N个哲学家, 最多只允许N-1个哲学家同时吃饭
 * * 策略2 要求偶数编号哲学家和奇数编号哲学家拿筷子的顺序相反 (本实现)
 * * 策略3 将哲学家拿筷子的过程互斥
 *
 * @author SUN Katus
 * @version 1.0, 2022-08-12
 */
@Slf4j
public class PhilosopherMeal {
    private static final int CAPACITY = 5;
    private final Semaphore[] chopsticks;
    private final Random random;

    public PhilosopherMeal() {
        this.chopsticks = new Semaphore[CAPACITY];
        for (int i = 0; i < CAPACITY; i++) {
            chopsticks[i] = new Semaphore(1);
        }
        this.random = new Random();
    }

    @ToString
    public class Philosopher implements Runnable {
        private final int id;

        public Philosopher(int id) {
            this.id = id;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(100);
                    boolean meal = random.nextBoolean();
                    if (meal) {
                        int rightId = (id + 1) % CAPACITY;
                        if (id % 2 == 0) {
                            chopsticks[id].acquire();
                            chopsticks[rightId].acquire();
                        } else {
                            chopsticks[rightId].acquire();
                            chopsticks[id].acquire();
                        }
                        log.info("{} is eating...", this);
                        chopsticks[id].release();
                        chopsticks[rightId].release();
                    } else {
                        log.info("{} is thinking...", this);
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public static void main(String[] args) {
        PhilosopherMeal philosopherMeal = new PhilosopherMeal();
        for (int i = 0; i < CAPACITY; i++) {
            new Thread(philosopherMeal.new Philosopher(i), "Philosopher-" + i).start();
        }
    }
}
