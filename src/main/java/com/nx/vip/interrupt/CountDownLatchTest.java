package com.nx.vip.interrupt;

import com.nx.util.MyLog;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * join()需要等待线程死亡; CountDownLatch仅仅判断计数器, 可以自由定制count的位置
 *
 * @author SUN Katus
 * @version 1.0, 2021-08-28
 */
public class CountDownLatchTest {
    @Test
    void test() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(3);
        Thread t1 = new Thread(() -> {
            MyLog.info("t1");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            latch.countDown();
        }, "t1");
        Thread t2 = new Thread(() -> {
            MyLog.info("t2");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            latch.countDown();
        }, "t2");
        Thread t3 = new Thread(() -> {
            MyLog.info("t3");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            latch.countDown();
        }, "t3");
        t1.start();
        t2.start();
        t3.start();
        // 使当前线程阻塞指导内部计数器为0
        latch.await();
        System.out.println(t1.isAlive());
        MyLog.info("latch over");
    }

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(5);
        Random random = new Random();
        String[] array = new String[5];
        for (int i = 0; i < 5; i++) {
            int finalI = i;
            Thread thread = new Thread(() -> {
                for (int j = 0; j <= 100; j++) {
                    try {
                        TimeUnit.MILLISECONDS.sleep(random.nextInt(100));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    String str = "[t" + finalI + "]-{" +  j + "%}";
                    array[finalI] = str;
                    System.out.print("\r" + Arrays.toString(array));
                }
                latch.countDown();
            }, "t" + i);
            thread.start();
        }
        latch.await();
        System.out.println("\nAll finished!");
    }
}
