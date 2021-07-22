package com.nx.vip.array;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author SUN Katus
 * @version 1.0, 2021-07-21
 */
public class ArrayListC {
    /**
     * JDK8中存在的BUG
     * toArray()方法在使用通过Arrays.asList()构造的集合时返回的类型不是Object[].class
     */
    @Test
    void testToArray() {
        Integer[] array = {1, 2};
        List<Integer> integerList = Arrays.asList(array);
        Object[] objectArray = integerList.toArray();
        System.out.println(objectArray.getClass() == Object[].class);   // false

        List<Integer> list = new ArrayList<>();
        System.out.println(list.toArray().getClass() == Object[].class);   // true
    }
}
