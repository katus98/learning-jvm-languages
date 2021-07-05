package com.katus.compare;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author SUN Katus
 * @version 1.0, 2020-08-12
 */
public class CompareTest {
    @Test
    public void test1() {
        Good[] goods = new Good[4];
        goods[0] = new Good("DELL", 54.3);
        goods[1] = new Good("HUAWEI", 65.4);
        goods[2] = new Good("MI", 19.8);
        goods[3] = new Good("Apple", 156.4);

        Arrays.sort(goods);

        System.out.println(Arrays.toString(goods));
    }

    @Test
    public void test2() {
        String[] arr = new String[]{"AA", "XX", "DD", "LL", "YY", "QQ", "VV"};
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return -o1.compareTo(o2);
            }
        });
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void test3() {
        Good[] goods = new Good[4];
        goods[0] = new Good("DELL", 54.3);
        goods[1] = new Good("HUAWEI", 65.4);
        goods[2] = new Good("MI", 19.8);
        goods[3] = new Good("Apple", 156.4);

        Arrays.sort(goods, new Comparator<Good>() {
            @Override
            public int compare(Good o1, Good o2) {
                if (o1.getName().equals(o2.getName())) {
                    return -Double.compare(o1.getPrice(), o2.getPrice());
                } else {
                    return o1.getName().compareTo(o2.getName());
                }
            }
        });

        System.out.println(Arrays.toString(goods));
    }
}
