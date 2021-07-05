package com.katus.maps;

import com.katus.collections.User;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeMap;

/**
 * @author SUN Katus
 * @version 1.0, 2020-08-16
 */
public class TreeMapTest {
    @Test
    public void test() {
        User u1 = new User("Tom", 23),
                u2 = new User("Lucy", 21),
                u3 = new User("Kitty", 20),
                u4 = new User("Sam", 19);

        System.out.println("******自然排序******");

        TreeMap<User, Integer> treeMap = new TreeMap<>();
        treeMap.put(u1, 98);
        treeMap.put(u2, 89);
        treeMap.put(u3, 76);
        treeMap.put(u4, 100);

        Set<User> userSet = treeMap.keySet();
        for (User user : userSet) {
            System.out.println(user + "----->" + treeMap.get(user));
        }

        System.out.println("******定制排序******");

        TreeMap<User, Integer> treeMap1 = new TreeMap<>(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return Integer.compare(o1.getAge(), o2.getAge());
            }
        });
        treeMap1.put(u1, 98);
        treeMap1.put(u2, 89);
        treeMap1.put(u3, 76);
        treeMap1.put(u4, 100);

        Set<User> userSet1 = treeMap1.keySet();
        for (User user : userSet1) {
            System.out.println(user + "----->" + treeMap1.get(user));
        }
    }
}
