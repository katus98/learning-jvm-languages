package com.nx.vip.generic.type;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * 当一个可变泛型参数执行一个无泛型参数时, heap pollution (堆污染)
 * 无泛型约束的类型会在第一次参数绑定时绑定与参数泛型约束相同的泛型约束
 * Java 数组泛型不安全
 * 带泛型的处理，首选集合
 *
 * @author SUN Katus
 * @version 1.0, 2021-07-28
 */
public class Pollution {

    public static void main(String[] args) {
        Set set = new TreeSet();
        varMethod(set);
        set.add("abc");
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            System.out.println(next);
        }
    }

    private static void varMethod(Set<Integer> set) {
        set.add(100);
        System.out.println(set.size());
    }
}
