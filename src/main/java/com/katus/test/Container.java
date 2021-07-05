package com.katus.test;

import java.util.*;

public class Container {
    public static void main(String[] args) {
        List<Apple> list1 = new ArrayList<>();
        List<Apple> list2 = new LinkedList<>();
        Set<Apple> set1 = new HashSet<>();
        Set<Apple> set2 = new TreeSet<>(Comparator.comparing(Apple::getName));
        Set<Apple> set3 = new LinkedHashSet<>();
        Map<String, Apple> map1 = new HashMap<>();
        Map<String, Apple> map2 = new TreeMap<>();
        Map<String, Apple> map3 = new LinkedHashMap<>();
        ArrayList<Apple> list = new ArrayList<>();
        list.add(new Apple("first"));
        System.out.println(list.get(0).getName());
    }
}

class Apple {
    private final String name;
    public Apple(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
}
