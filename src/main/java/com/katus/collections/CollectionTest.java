package com.katus.collections;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author SUN Katus
 * @version 1.0, 2020-08-15
 */
public class CollectionTest {
    @Test
    public void test1() {
        Collection coll = new ArrayList<>();

        coll.add("123");
        coll.add("ABC");
        coll.add(123);
        coll.add(new Date());

        System.out.println(coll.size());

        Collection coll2 = new ArrayList<>();
        coll2.add("456");
        coll2.add(759);
        coll.addAll(coll2);

        coll2.clear();

        System.out.println(coll2.isEmpty());
    }

    @Test
    public void test2() {
        Collection coll = new ArrayList<>();
        coll.add("123");
        coll.add(123);

        coll.contains("123");   // 判断依照equals方法

        Collection coll2 = Arrays.asList(123, 456);
        coll.containsAll(coll2);
    }

    @Test
    public void test3() {
        Collection coll = new ArrayList<>();
        coll.add("123");
        coll.add("456");
        coll.add("789");
        coll.add("456");

        System.out.println(coll);
        // 返回true删除成功 否则删除失败
        // 只会删除的第一个匹配元素
        coll.remove("456");
        System.out.println(coll);

        Collection coll1 = Arrays.asList("123", "789");
        coll.removeAll(coll1);
        System.out.println(coll);
    }

    @Test
    public void test4() {
        Collection coll = new ArrayList<>();
        coll.add(123);
        coll.add(456);
        coll.add(789);
        coll.add(234);
        coll.add(567);
        coll.add(234);
        Collection coll1 = Arrays.asList(234, 567, 951);
        coll.retainAll(coll1);   // 保留共有部分 并改变coll
        System.out.println(coll);

        System.out.println(coll.equals(coll1));   // 完全相同返回true

        Object[] objs = coll.toArray();
        for (Object obj : objs) {
            System.out.println(obj);
        }

        List list = Arrays.asList(234, 567, 951);
        System.out.println(list);
    }
}
