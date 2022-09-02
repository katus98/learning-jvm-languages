package com.leetcode.exam.autumn.formal.oppo;

/**
 * @author SUN Katus
 * @version 1.0, 2022-09-02
 */
public class Task3 {
    public long tourismRoutePlanning(int scenicSpot) {
        if (scenicSpot == 1) return 1;
        if (scenicSpot == 2) return 2;
        return tourismRoutePlanning(scenicSpot - 1) + tourismRoutePlanning(scenicSpot - 2);
    }
}
