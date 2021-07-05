package com.katus.collections;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * Collections 是一个工具类 可以操作 Collection Map
 * @author SUN Katus
 * @version 1.0, 2020-08-16
 */
public class CollectionsTest {
    @Test
    public void test1() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(123);
        list.add(123);
        list.add(123);
        list.add(123);
        list.add(12);
        list.add(23);
        list.add(57);
        list.add(49);
        System.out.println(list);

        // 反转
        Collections.reverse(list);
        System.out.println(list);

        // 随机排列
        Collections.shuffle(list);
        System.out.println(list);

        // 自然排序
        Collections.sort(list);
        System.out.println(list);

        // 定制排序
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o2, o1);
            }
        });
        System.out.println(list);

        // 交换指定索引位置的元素
        Collections.swap(list, 1, 2);
        System.out.println(list);

        // 输出某个元素的数量
        System.out.println(Collections.frequency(list, 123));

        // 最大最小
        System.out.println(Collections.max(list));
        System.out.println(Collections.min(list));

        List<Integer> dest = Arrays.asList(new Integer[list.size()]);
        Collections.copy(dest, list);
        System.out.println(dest);

        Collections.replaceAll(dest, 123, 1234);
        System.out.println(dest);

        // 返回线程安全的容器
        // Collections.synchronizedXxx
        List<Integer> list1 = Collections.synchronizedList(list);
    }
}
