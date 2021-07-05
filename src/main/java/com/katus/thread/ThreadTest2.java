package com.katus.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 创建多线程的方式 3: 实现Callable接口 (Java5 新特性)
 * @author SUN Katus
 * @version 1.0, 2020-08-10
 */
// 创建Callable接口的实现类
class NumThread implements Callable {
    // 重写call方法 内部为线程的操作
    @Override
    public Object call() throws Exception {   // 优势：可以抛出异常 可以有返回值 支持泛型
        int sum = 0;
        for (int i = 0; i <= 100; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
                sum += i;
            }
        }
        return sum;
    }
}

public class ThreadTest2 {
    public static void main(String[] args) {
        // 创建Callable实现类的对象
        NumThread numThread = new NumThread();
        // 通过Callable实现类对象构建FutureTask类的对象
        FutureTask futureTask = new FutureTask(numThread);
        // 通过FutureTask类对象构建Thread类的对象 即构建线程
        new Thread(futureTask).start();
        try {
            // 下方法的返回值即为Callable实现类中call方法的返回值
            Object sum = futureTask.get();
            System.out.println("sum = " + sum);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
