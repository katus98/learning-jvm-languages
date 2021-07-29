package com.nx.vip.generic.effect;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

/**
 * 没有泛型约束, 获取类型时没有任何限制, 相应的子类方法需要强制类型转换才能使用
 *
 * @author SUN Katus
 * @version 1.0, 2021-07-28
 */
public class ArrayListDemo {

    @Test
    void hasGen() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(125);
        list.add(126);
        System.out.println("------------");
        System.out.println(list.get(0).compareTo(list.get(1)));
    }

    @Test
    void noGen() {
        ArrayList list = new ArrayList<>();
        list.add(125);
        list.add(126);
        System.out.println("------------");
        System.out.println(((Integer) list.get(0)).compareTo((Integer) list.get(1)));
    }
}
