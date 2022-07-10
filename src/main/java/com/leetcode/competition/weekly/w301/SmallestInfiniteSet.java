package com.leetcode.competition.weekly.w301;

import java.util.TreeSet;

/**
 * 无限集中的最小数字 (6113)
 *
 * @author SUN Katus
 * @version 1.0, 2022-07-10
 */
public class SmallestInfiniteSet {
    private int minEdge;
    private final TreeSet<Integer> addSet;

    public SmallestInfiniteSet() {
        this.minEdge = 1;
        this.addSet = new TreeSet<>();
    }

    public int popSmallest() {
        if (addSet.isEmpty()) {
            return minEdge++;
        } else {
            int min = addSet.first();
            addSet.remove(min);
            return min;
        }
    }

    public void addBack(int num) {
        if (num < minEdge) {
            if (!addSet.contains(num)) {
                if (num == minEdge - 1) {
                    minEdge--;
                } else {
                    addSet.add(num);
                }
            }
        }
    }

    public static void main(String[] args) {
        SmallestInfiniteSet smallestInfiniteSet = new SmallestInfiniteSet();
        smallestInfiniteSet.addBack(16);
        System.out.println(smallestInfiniteSet.popSmallest());
        System.out.println(smallestInfiniteSet.popSmallest());
        System.out.println(smallestInfiniteSet.popSmallest());
        System.out.println(smallestInfiniteSet.popSmallest());
        smallestInfiniteSet.addBack(3);
        smallestInfiniteSet.addBack(2);
        System.out.println(smallestInfiniteSet.popSmallest());
        System.out.println(smallestInfiniteSet.popSmallest());
        System.out.println(smallestInfiniteSet.popSmallest());
    }
}
