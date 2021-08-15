package com.nx.vip.lock;

import com.nx.util.MyLog;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * @author SUN Katus
 * @version 1.0, 2021-08-15
 */
public class TestLock {

    public static void main(String[] args) throws InterruptedException {
        MyLog.info("1");
        Thread t1 = new Thread(() -> {
            MyLog.info("2");
            // 让当前线程阻塞
            LockSupport.park();
            MyLog.info("3");
        }, "t1");
        // 让CPU允许调度t1, 但是本身是随机的
        t1.start();
        TimeUnit.SECONDS.sleep(2);
        MyLog.info("4");
        LockSupport.unpark(t1);
    }
}
