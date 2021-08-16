package com.nx.vip.lock;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.concurrent.TimeUnit;

/**
 * 自己模拟的锁
 * 其实就是一个标识；如果这个标识改变成了某个状态我们就理解为获取锁（正常放回）
 * 拿不到锁其实就是陷入阻塞（死循环） 让这个方法不返回
 *
 * @author SUN Katus
 * @version 1.0, 2021-08-16
 */
public class CustomLock {
    private volatile int status = 0;
    private static Unsafe UNSAFE = null;
    private static long STATUS_OFFSET;

    static {
        Field field;
        try {
            field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            UNSAFE = (Unsafe) field.get(null);
            STATUS_OFFSET = UNSAFE.objectFieldOffset(CustomLock.class.getDeclaredField("status"));
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public void lock() throws InterruptedException {
        while (!compareAndSet(0, 1)) {//cas 原子操作
            TimeUnit.SECONDS.sleep(5);
        }
    }

    public void unlock() {
        this.status = 0;
    }

    private boolean compareAndSet(int oldVal, int newVal) {
        return UNSAFE.compareAndSwapInt(this, STATUS_OFFSET, oldVal, newVal);
    }
}
