package com.nx.vip.generic.genuse;

/**
 * @author SUN Katus
 * @version 1.0, 2021-07-28
 */
public class GenericMethod<K, V> {
    /**
     * 实体方法使用类上定义的泛型
     */
    public K method01(K k, V v) {
        return null;
    }

    /**
     * 方法上定义泛型
     */
    public <T> T method02() {
        return null;
    }

    /**
     * 静态方法不能使用类上定义的泛型
     * 类上定义的泛型，需要new的时候才知道具体的泛型类别
     */
    public static <E> E method03() {
        return null;
    }
}
