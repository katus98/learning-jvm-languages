package com.nx.vip.generic.genuse;

import java.util.List;

/**
 * 泛型必须先定义在使用
 * <任意大写字母>
 * 1、类
 * 2、方法
 * 3、接口
 *
 * @author SUN Katus
 * @version 1.0, 2021-07-28
 */
public class GenericUse<K> {

    public K fun2() {
        return null;
    }

    public <T> T fun1(T te, List<String> list) {
        return te;
    }
}
