package com.leetcode.main.interval1601.q1603;

/**
 * 设计停车系统
 *
 * @author SUN Katus
 * @version 1.0, 2022-07-28
 */
public class ParkingSystem {
    private final int[] maxSizes;
    private final int[] sizes;

    public ParkingSystem(int big, int medium, int small) {
        this.maxSizes = new int[3];
        this.sizes = new int[3];
        maxSizes[0] = big;
        maxSizes[1] = medium;
        maxSizes[2] = small;
    }

    public boolean addCar(int carType) {
        if (maxSizes[carType - 1] > sizes[carType - 1]) {
            sizes[carType - 1]++;
            return true;
        }
        return false;
    }
}
