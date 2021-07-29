package com.nx.vip.reflection.basic;

import java.lang.reflect.Constructor;

/**
 * 可以通过反射破坏设计模式
 *
 * @author SUN Katus
 * @version 1.0, 2021-07-28
 */
public class SingleMain {

    /**
     * 可以通过反射突破单例模式的限制, 从而使单例对象不再单例
     */
    public static void main(String[] args) throws Exception {
        SingleDemo instance = SingleDemo.getInstance();
        SingleDemo instance1 = SingleDemo.getInstance();
        System.out.println(instance == instance1);  // true

        // 通过反射获取
        Class<? extends SingleDemo> clazz = instance.getClass();
        Constructor<? extends SingleDemo> constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true); // 破坏访问限制
        SingleDemo instance2 = constructor.newInstance(); // private
        System.out.println(instance == instance2); // false

        // 执行会报错, 因为没有设置私有构造函数可访问, 实际上是constructor.newInstance()
        SingleDemo instance3 = clazz.newInstance();
    }
}
