package com.nx.vip.array;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author SUN Katus
 * @version 1.0, 2021-07-29
 */
public class CovariantArrays {
    /**
     * 协变
     * Java中数组是协变的, 可以向子类型的数组赋予基类型的数组引用
     */
    @Test
    void test1() {
        Fruit[] fruit = new Apple[10];
        fruit[0] = new Apple();
        fruit[1] = new Jonathan();
        try {
            fruit[2] = new Fruit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            fruit[3] = new Orange();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class Fruit {}
    static class Apple extends Fruit {}
    static class Jonathan extends Apple {}
    static class Orange extends Fruit {}

    /**
     * 不变
     * Java泛型是不变的
     */
    @Test
    void test2() {
        // 编译错误
        // List<Fruit> fruits = new ArrayList<Apple>();

        // Java泛型实现协变
        List<? extends Fruit> fruits = new ArrayList<Apple>();
        /*
         * 原因在于，List<? extends Fruit>也可以合法的指向一个List<Orange>,
         * 显然往里面放Apple、Fruit、Object都是非法的.
         * 编译器不知道List<? extends Fruit>所持有的具体类型是什么,
         * 所以一旦执行这种类型的向上转型, 你就将丢失掉向其中传递任何对象的能力.
         */
        /* fruits.add(new Apple());  // 编译错误
         * fruits.add(new Fruit());  // 编译错误
         * fruits.add(new Object());  // 编译错误
         */
    }

    /**
     * 逆变
     */
    static void test3(List<? super Apple> apples) {
        apples.add(new Apple());
        apples.add(new Jonathan());
        // apples.add(new Fruit());  // 编译错误
    }
}
