package com.nx.vip.generic.effect;

import org.junit.jupiter.api.Test;

/**
 * 泛型的作用
 *   保证了类型安全
 *   避免了强转
 *   提高代码重复使用率
 *
 * @author SUN Katus
 * @version 1.0, 2021-07-28
 */
public class Reuse<T extends Comparable<T>> {

    public int compareTo(T t1, T t2) {
        return t1.compareTo(t2);
    }

    @Test
    public void test() {
        Reuse<Integer> reuse = new Reuse<>();
        System.out.println(reuse.compareTo(123, 234) == 0);

        Reuse<String> stringReuse = new Reuse<>();
        stringReuse.compareTo("!23", "234");
    }
}
