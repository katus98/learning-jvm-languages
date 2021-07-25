package com.nx.vip.rbt;

import java.util.Comparator;
import java.util.HashMap;
import java.util.TreeMap;

/**
 * java中实现对象的比较
 * 1、implements Comparable
 * 2、Comparator
 */
public class TreeMapTest {

    public static void main(String[] args) {
        TreeMap<String, String> treeMap = new TreeMap<>();
        treeMap.put("hello", "world");
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("key", "value");

        new TreeMap<String, String>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return 0;
            }
        });
    }

    public static class Node implements Comparable<String> {
        @Override
        public int compareTo(String o) {
            return 0;
        }
    }
}
