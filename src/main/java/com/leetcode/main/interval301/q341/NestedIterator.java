package com.leetcode.main.interval301.q341;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * 扁平化嵌套列表迭代器
 *
 * @author SUN Katus
 * @version 1.0, 2022-09-10
 */
public class NestedIterator implements Iterator<Integer> {
    private final LinkedList<Integer> list;
    private final List<NestedInteger> nestedList;
    private int index;

    public NestedIterator(List<NestedInteger> nestedList) {
        this.list = new LinkedList<>();
        this.index = 0;
        this.nestedList = nestedList;
    }

    @Override
    public boolean hasNext() {
        if (!list.isEmpty()) return true;
        while (list.isEmpty() && index < nestedList.size()) {
            NestedInteger nestedInteger = nestedList.get(index);
            flatList(nestedInteger);
            index++;
        }
        return !list.isEmpty();
    }

    @Override
    public Integer next() {
        if (!list.isEmpty()) {
            return list.removeFirst();
        }
        return null;
    }

    private void flatList(NestedInteger nestedInteger) {
        if (nestedInteger.isInteger()) {
            list.addLast(nestedInteger.getInteger());
        } else {
            for (NestedInteger integer : nestedInteger.getList()) {
                flatList(integer);
            }
        }
    }

    public interface NestedInteger {

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return empty list if this NestedInteger holds a single integer
        List<NestedInteger> getList();
    }

    public static class MyInteger implements NestedInteger {
        private int val;
        private List<NestedInteger> list;
        private final boolean isInt;

        public MyInteger(int val) {
            this.val = val;
            this.isInt = true;
        }

        public MyInteger(List<NestedInteger> list) {
            this.list = list;
            this.isInt = false;
        }

        @Override
        public boolean isInteger() {
            return isInt;
        }

        @Override
        public Integer getInteger() {
            return val;
        }

        @Override
        public List<NestedInteger> getList() {
            return list;
        }
    }

    public static void main(String[] args) {
        List<NestedInteger> l1 = new ArrayList<>();
        List<NestedInteger> lst = new ArrayList<>();
        l1.add(new MyInteger(1));
        l1.add(new MyInteger(1));
        lst.add(new MyInteger(l1));
        lst.add(new MyInteger(2));
        lst.add(new MyInteger(l1));
        NestedIterator iterator = new NestedIterator(lst);
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
