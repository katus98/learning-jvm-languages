package com.katus.collections;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

/**
 * @author SUN Katus
 * @version 1.0, 2020-08-15
 */
public class IteratorTest {
    @Test
    public void test1() {
        Collection coll = new ArrayList<>();
        coll.add(123);
        coll.add("456");
        coll.add(new Date());

        Iterator it = coll.iterator();   // 每次调用都会返回一个新的迭代器
        while (it.hasNext()) {
            Object obj = it.next();
            if (obj.equals("456")) {
                // 只允许在每次调用next方法之后调用一次
                it.remove();   // 删除集合中的元素
            }
        }

        System.out.println(coll);

        for (Object obj : coll) {
            System.out.println(obj);
        }
    }
}
