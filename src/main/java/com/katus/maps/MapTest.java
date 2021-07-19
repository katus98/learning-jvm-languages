package com.katus.maps;

import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Map 双列数据 k-v 对数据
 * key - 相当于一个Set 无序 不可重复 所在类需要重写equals方法和hashCode方法
 * value - 相当于一个Collection 无序 可以重复 所在类需要重写equals方法
 * * HashMap 主要实现类 线程不安全 高效 允许存储null的key或者value
 * * 底层 数组+链表 (Java7) / 数组+链表+红黑树 (Java8)
 * * 底层实现与HashMap类似 比较是否相同的仅仅是key 而且如果相同value值会覆盖 75%占用且即将填入的位置非空扩容一倍
 * * Java7 初始Entry数组长度为16
 * * Java8 底层数组为Node 首次put时才会初始化长度为16的数组 75%占用会扩容
 * *       当某位置上链表长度超过8 且数组长度超过64 整个体系采用红黑树存储
 * * * LinkedHashMap 可以按照填入的顺序进行遍历
 * * * 在原有HashMap基础上增加了一对前后引用 适用于频繁遍历的场景
 * * TreeMap 按照元素key进行排序遍历 底层采用红黑树
 * * Hashtable 古老实现类 线程安全 低效 不能存储null
 * * * Properties 用来处理配置文件 其key和value都是String类型
 * @author SUN Katus
 * @version 1.0, 2020-08-15
 */
public class MapTest {

    @Test
    void test1() {
        Map map = new HashMap<>();
        // 添加新的元素
        map.put("AA", 12);
        map.put("BB", 13);
        map.put("CC", 56);
        // 修改已有的元素
        map.put("AA", 98);
        System.out.println(map);

        Map map1 = new HashMap<>();
        map1.put("DD", 49);
        map1.put("EE", 76);
        // 将map1加入map
        map.putAll(map1);
        System.out.println(map);

        // 按照key移除指定元素 返回value
        System.out.println(map.remove("DD"));
        System.out.println(map);

        // 清除所有元素
        map.clear();
        System.out.println(map.size());
    }

    @Test
    void test2() {
        Map map = new HashMap<>();
        map.put("AA", 46);
        map.put("BB", 74);
        map.put("CC", 27);

        // 获取指定key元素的value 如果没有返回null
        System.out.println(map.get("BB"));

        System.out.println(map.containsKey("AA"));
        System.out.println(map.containsKey("AB"));
        System.out.println(map.containsValue(123));
        System.out.println(map.containsValue(74));

        System.out.println(map.size());

        map.clear();

        System.out.println(map.isEmpty());
    }

    @Test
    void test3() {
        Map map = new HashMap<>();
        map.put("AA", 74);
        map.put("BB", 84);
        map.put("CC", 61);

        Set keySet = map.keySet();
        for (Object key : keySet) {
            System.out.println(key + ": " + map.get(key));
        }

        Collection values = map.values();
        for (Object value : values) {
            System.out.println(value);
        }

        Set entrySet = map.entrySet();
        for (Object obj : entrySet) {
            Map.Entry entry = (Map.Entry) obj;
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    /**
     * put()方法流程
     * 判断哈希表是否为空表 -> 扩容
     * 根据key计算下标
     * 如果table[index]==null -> 添加到首位
     * 如果key==table[index].key -> 替换首节点的旧值
     * 如果table[index]是个树节点 -> 添加到红黑树
     * 遍历table[index]链表, 如果存在key -> 替换旧值; 如果不存在 -> 插入到链表尾部
     * 如果链表长度>=8且哈希表长度>=64 -> 链表转换为红黑树; 否则 -> 扩容链表
     * 如果元素数量>=阈值 -> 扩容链表
     */
    @Test
    void testPut() {
        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(0, "katus");
        hashMap.forEach((key, value) -> System.out.println(key));
    }
}
