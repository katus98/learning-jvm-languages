package com.nx.vip.generic.effect;

/**
 * 泛型的作用
 * 1、泛型可以保证类型安全
 * 2、避免强制转换的硬编码
 * 3、调到代码的重用性
 * <p>
 * 作业：模拟ArrayList的底层实现
 *
 * @author SUN Katus
 * @version 1.0, 2021-07-28
 */
public class ArrayListHasGen<E> {
    private Object[] elements = {};
    private int size = 0;

    public E get(int i) {
        if (size > i) {
            return (E) elements[i];
        }
        throw new IndexOutOfBoundsException();
    }

    public void add(E e) {
        size++;
        java.lang.Object[] array = new Object[size];
        System.arraycopy(elements, 0, array, 0, elements.length);
        array[size - 1] = e;
        elements = array;
    }

    public static void main(String[] args) {
        ArrayListHasGen<String> list = new ArrayListHasGen<>();
//        list.add(new Integer(1));
    }
}
