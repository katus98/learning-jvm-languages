package com.nx.vip.sync;

import org.junit.jupiter.api.Test;
import org.openjdk.jol.info.ClassLayout;

/**
 * @author SUN Katus
 * @version 1.0, 2021-08-21
 */
public class SyncTest {
    private static final SimpleSync LOCK = new SimpleSync();

    @Test
    void noLockTest() {
        String info = ClassLayout.parseInstance(LOCK).toPrintable(LOCK);
        System.out.println(info);
    }

    @Test
    void biasedLockTest() {
        // JVM: -XX:BiasedLockingStartupDelay=0 关闭偏向延迟
        synchronized (LOCK) {
            String info = ClassLayout.parseInstance(LOCK).toPrintable(LOCK);
            System.out.println(info);
        }
    }

    @Test
    void thinLockTest() {
        int hashCode = LOCK.hashCode();
        System.out.println(Integer.toHexString(hashCode));
        // JVM: -XX:BiasedLockingStartupDelay=0 关闭偏向延迟
        synchronized (LOCK) {
            String info = ClassLayout.parseInstance(LOCK).toPrintable(LOCK);
            System.out.println(info);
        }
    }

    @Test
    void fatLockTest() {
        // JVM: -XX:BiasedLockingStartupDelay=0 关闭偏向延迟
        Thread t1 = new Thread(() -> {
            synchronized (LOCK) {
                String info = ClassLayout.parseInstance(LOCK).toPrintable(LOCK);
                System.out.println(info);
            }
        }, "t1");
        Thread t2 = new Thread(() -> {
            synchronized (LOCK) {
                String info = ClassLayout.parseInstance(LOCK).toPrintable(LOCK);
                System.out.println(info);
            }
        }, "t2");
        t1.start();
        t2.start();
        synchronized (LOCK) {
            String info = ClassLayout.parseInstance(LOCK).toPrintable(LOCK);
            System.out.println(info);
        }
    }
}
