package com.katus.collections;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * List - Collection 子接口
 * 实现类
 * * ArrayList 线程不安全 底层Object数组
 * * * 空参构造器构造数组长度为10 如果不够则扩充一半的容量 (Java7)
 * * * 空参构造器构造{} add方法调用时才会扩容10 如果不够则扩充一半的容量 (Java8)
 * * * 构造器承接一个int参数 初始化list长度
 * * LinkedList 底层双向链表 擅长频繁的插入删除操作
 * * * Node 包含上一项 本项 下一项
 * * * 含有首项 和 末项
 * * Vector (已弃用) 线程安全 底层Object数组
 * * * 空参构造器构造数组长度为10 如果不够则扩容一倍的容量
 * @author SUN Katus
 * @version 1.0, 2020-08-15
 */
public class ListTest {
    @Test
    public void test1() {
        List list = new ArrayList<>();
        list.add(123);
        list.add(456);
        list.add("BB");
        list.add(new Date());
        list.add(456);
        System.out.println(list);

        list.add(1, "DD");
        System.out.println(list);

        Collection coll = Arrays.asList(234, 567);
        list.addAll(1, coll);
        System.out.println(list);

        System.out.println(list.get(1));

        System.out.println(list.indexOf(456));   // 返回第一个匹配元素的索引
        System.out.println(list.indexOf(123456));   // 找不到返回-1
        System.out.println(list.lastIndexOf(456));

        list.remove(0);   // 删除索引为0的元素并将其返回
        list.remove(new Integer(456));   // 删除整数时切记手动装箱 只会删除第一个匹配值
        System.out.println(list);

        list.set(0, "Are you ok?");
        System.out.println(list);

        System.out.println(list.subList(1, 3));   // 包括首项 不包括末项
        System.out.println(list);   // 不会对原有list进行改变
    }
}
