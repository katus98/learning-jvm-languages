package com.katus.collections;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author SUN Katus
 * @version 1.0, 2021-07-19
 */
public class ThreadListTest {
    private static List<Integer> list = new ArrayList<>();

    /**
     * add()方法线程不安全: 确保数组容量->赋值
     * 多线程可能会导致元素覆盖的问题
     */
    @Test
    void testThreadList() {
        ExecutorService executorService = Executors.newFixedThreadPool(1000);
        for (int i = 0; i < 1000; i++) {
            executorService.submit(new IncreaseTask());
        }
        executorService.shutdown();
        while (!executorService.isTerminated()) {
            try {
                Thread.sleep(1000 * 10);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.println("All task finished!");
        System.out.println("预计存储大小为: "+ 1000 * 100);
        System.out.println("list size is: " + list.size());
    }

    /**
     * 由于add()方法机制, 导致多线程会出发数组越界异常
     * !!!存疑, 上下两种多线程情况有什么区别!!!
     */
    @Test
    void testThreadList2() {
        new IncreaseTask().start();
        new IncreaseTask().start();
    }

    private static class IncreaseTask extends Thread {

        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                list.add(i);
            }
        }
    }
}
