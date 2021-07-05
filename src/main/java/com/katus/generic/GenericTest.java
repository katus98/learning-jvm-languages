package com.katus.generic;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author SUN Katus
 * @version 1.0, 2020-08-17
 */
public class GenericTest {
    @Test
    public void test1() {
        // 默认泛型为Object
        Order order = new Order<>();
        order.setOrderT(123);
        order.setOrderT("ABC");
        System.out.println(order);

        // 指定类型
        Order<String> order1 = new Order<>("AA", 12, "OrderAA");
        System.out.println(order1);

        SubOrder<Integer> subOrder = new SubOrder<>("BB", 11, 59, "nothing");
        System.out.println(subOrder);
    }

    // 方法中出现泛型结构 与类本身是否是泛型类无关
    // 泛型方法可以是静态的 也可以不是
    protected static <E> List<E> copyFromArrayToList(E[] arr) {
        return new ArrayList<>(Arrays.asList(arr));
    }

    @Test
    public void test2() {
        Integer[] arr = new Integer[]{1, 2, 3, 4};
        List<Integer> list = copyFromArrayToList(arr);
        System.out.println(list);
    }

    @Test
    public void test3() {
        List<String> list1 = null;
        List<Object> list2 = null;
        // 泛型的子父类关系不代表泛型类对象的子父类关系
        // list2 = list1;

        LinkedHashSet<String> set1 = null;
        HashSet<String> set2 = null;
        set2 = set1;
    }

    @Test
    public void test4() {
        // 通配符 ?
        List<String> list1 = new ArrayList<>();
        List<Object> list2 = new ArrayList<>();

        List<?> list = null;

        print(list1);
        print(list2);

        list1.add("AA");
        list1.add("BB");
        list1.add("CC");

        list = list1;
        // 使用通配符的声明无法添加数据 除了添加null之外
        list.add(null);   // 允许
        // list.add(...);   // 不允许

        // 但是允许读取 通过Object操作
        Object o = list.get(0);
        System.out.println(o);
    }

    protected void print(List<?> list) {
        for (Object obj : list) {
            System.out.println(obj);
        }
    }

    @Test
    public void test5() {
        // 允许Order<String>及其子类
        List<? extends Order<String>> list1 = null;
        // 允许Order<String>及其父类
        List<? super Order<String>> list2 = null;

        List<SubOrder<String>> list3 = new ArrayList<>();
        List<Order<String>> list4 = new ArrayList<>();
        List<Object> list5 = new ArrayList<>();

        list1 = list3;
        list1 = list4;
        // list1 = list5;

        // list2 = list3;
        list2 = list4;
        list2 = list5;

        Order<String> order = list1.get(0);
        Object object = list2.get(0);

        list1.add(null);
        // list1.add(new Order<>());
        list2.add(new Order<>());
        list2.add(new SubOrder<>());
    }
}
