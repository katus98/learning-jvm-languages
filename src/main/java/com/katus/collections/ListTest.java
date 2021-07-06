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
    void test1() {
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

    /**
     * ArrayList 数组列表
     * ArrayList 是最常用的 List 实现类, 内部是通过数组实现的, 它允许对元素进行快速随机访问。数组的
     * 缺点是每个元素之间不能有间隔, 当数组大小不满足时需要增加存储能力, 就要将已经有数组的数据复
     * 制到新的存储空间中。当从 ArrayList 的中间位置插入或者删除元素时, 需要对数组进行复制、移动、
     * 代价比较高。因此, 它适合随机查找和遍历, 不适合插入和删除.
     * @since 1.2
     */
    @Test
    void testArrayList() {
        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList("123", "456", "789"));
        arrayList.add("Last!");
        String[] array = arrayList.toArray(new String[0]);
        for (String s : array) {
            System.out.println(s);
        }
        // 缩减数组大小, 节省内存
        arrayList.trimToSize();
        // 保证数组至少有一定的大小 (可以提前调用以提高效率)
        arrayList.ensureCapacity(100);
        ListIterator<String> listIterator = arrayList.listIterator();
        while (listIterator.hasNext()) {
            System.out.println(listIterator.next());
        }
        while (listIterator.hasPrevious()) {
            System.out.println(listIterator.previous());
        }
    }

    /**
     * Vector 向量
     * Vector 与 ArrayList 一样, 也是通过数组实现的, 不同的是它支持线程的同步, 即某一时刻只有一个线
     * 程能够写 Vector, 避免多线程同时写而引起的不一致性, 但实现同步需要很高的花费, 因此, 访问它比
     * 访问 ArrayList 慢.
     * 实际线程安全是通过同步方法实现的, 因此效率低下, 需要注意并不是所有的方法都是线程安全的.
     * @since 1.0
     */
    @Test
    void testVector() {
        Vector<String> vector = new Vector<>(Arrays.asList("123", "456", "789"));
        // 以下两方法作用相同
        vector.add("Last!");
        vector.addElement("Real Last!");
        // 以下两方法作用相同
        vector.set(0, "????");
        vector.setElementAt("????", 0);
        // 非同步
        vector.add(4, "hhh");
        // 非同步
        vector.remove("hhh");
        // 同步
        vector.remove(0);
        System.out.println(vector.firstElement());
        System.out.println(vector.lastElement());
        // 以下两方法作用相同
        System.out.println(vector.elementAt(0));
        System.out.println(vector.get(0));
    }

    /**
     * LinkedList 链表列表
     * LinkedList 是用链表结构存储数据的, 很适合数据的动态插入和删除, 随机访问和遍历速度比较慢。另
     * 外, 他还提供了 List 接口中没有定义的方法, 专门用于操作表头和表尾元素, 可以当作堆栈/队列和
     * 双向队列使用.
     */
    @Test
    void testLinkedList() {
        LinkedList<String> linkedList = new LinkedList<>(Arrays.asList("123", "456", "789"));
        // 以下两方法作用相同
        System.out.println(linkedList.getFirst());
        System.out.println(linkedList.element());
        System.out.println(linkedList.getLast());
    }
}
