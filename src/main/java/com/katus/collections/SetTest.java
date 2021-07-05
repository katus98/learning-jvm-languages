package com.katus.collections;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * Set - Collection 子接口
 * 其中没有定义新的方法 无序性不代表随机性 不可重复性依照equals方法 (但是先判断哈希值是否一样, 一样的话调用equals方法)
 * * HashSet 主要实现类 线程不安全 可以存储null
 * * 初始为16容量数组 每个位置挂链表 数组利用率超过75%则扩容一倍
 * * 根据哈希值和算法确定数组索引 同一个位置上用equals方法确定是否相同
 * * 放到Set中的元素 其hashCode() equals()方法必须重写 而且必须保持一致
 * * * LinkedHashSet HashSet子类 遍历顺序与添加元素的顺序一致
 * * * 在HashSet的基础上 每个元素增加了一对引用 分别指向添加的前后元素 遍历时依照引用的前后顺序输出
 * * * 对于频繁的遍历操作 LinkedHashSet效率较高
 * * TreeSet 内含元素必须是同一个类new的 底层采用红黑树
 * * 可以按照对象的指定属性进行排序
 * * 自然排序中 判断是否相同是元素调用compareTo方法 只要结果是0 则判断为相同 (不是equals方法)
 * * 定制排序中 判断是否相同是元素调用compare方法 只要结果是0 则判断为相同 (不是equals方法)
 * @author SUN Katus
 * @version 1.0, 2020-08-15
 */
public class SetTest {
    @Test
    public void test1() {
        Set set = new HashSet<>();
        set.add("943");
        set.add("456");
        set.add("789");

        for (Object o : set) {
            System.out.println(o);
        }
    }

    @Test
    public void test2() {
        // TreeSet 中的元素必须是相同的类 不能添加不同类的对象
        TreeSet<Integer> set = new TreeSet<>();
        set.add(15);
        set.add(49);
        set.add(71);
        set.add(-42);
        set.add(-74);
        set.add(22);

        for (Integer o : set) {
            System.out.println(o);
        }

        // 自然排序
        System.out.println("*****自然排序*****");
        Set<User> set1 = new TreeSet<>();
        set1.add(new User("Tom", 41));
        set1.add(new User("Sam", 34));
        set1.add(new User("Amy", 17));
        set1.add(new User("Lucy", 24));
        set1.add(new User("Lisa", 63));
        set1.add(new User("Lucy", 49));

        for (User user : set1) {
            System.out.println(user);
        }

        // 定制排序
        System.out.println("*****定制排序*****");
        Set<User> set2 = new TreeSet<>(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                int com = o1.compareTo(o2);
                if (com == 0) {
                    return Integer.compare(o1.getAge(), o2.getAge());
                } else {
                    return com;
                }
            }
        });

        set2.addAll(set1);
        set2.add(new User("Lucy", 49));

        for (User user : set2) {
            System.out.println(user);
        }
    }
}
