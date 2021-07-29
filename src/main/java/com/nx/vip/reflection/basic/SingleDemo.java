package com.nx.vip.reflection.basic;

/**
 * 单例对象
 *
 * @author SUN Katus
 * @version 1.0, 2021-07-28
 */
public class SingleDemo {

    private static SingleDemo instance;

    private SingleDemo() {
        if (instance != null) {
            throw new RuntimeException("这是一个单例, 不允许重复创建");
        }
    }

    public static SingleDemo getInstance() {
        if (instance == null) {
            instance = new SingleDemo();
        }
        return instance;
    }
}
