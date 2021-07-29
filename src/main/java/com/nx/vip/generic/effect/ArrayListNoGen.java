package com.nx.vip.generic.effect;

import java.io.File;

/**
 * 泛型的作用-1: 在编译阶段对类型进行约束
 *
 * @author SUN Katus
 * @version 1.0, 2021-07-28
 */
public class ArrayListNoGen {
    private Object[] elements = {};
    private int size = 0;

    public Object get(int i) {
        if (size > i) {
            return elements[i];
        }
        throw new IndexOutOfBoundsException();
    }

    public void add(Object o) {
        size++;
        Object[] array = new Object[size];
        System.arraycopy(elements, 0, array, 0, elements.length);
        array[size - 1] = o;
        elements = array;
    }

    public static void main(String[] args) {
        ArrayListNoGen list = new ArrayListNoGen();

        list.add(1);
        list.add("abc");
        list.add(new File("/"));

        String fileStr = (String) list.get(2);
    }
}
