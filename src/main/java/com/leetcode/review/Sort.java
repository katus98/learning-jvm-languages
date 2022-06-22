package com.leetcode.review;

/**
 * 排序算法
 *
 * @author SUN Katus
 * @version 1.0, 2022-06-17
 */
public interface Sort {
    /**
     * 快速排序
     * * 随机选择start到end之间的一个元素作为分界, 先移动到最后
     * * 然后快慢指针处理小的在前大的在后
     * * 然后将分界元素放回到分界点, 分两段递归即可
     *
     * @see com.leetcode.main.interval901.q912.QuickSort
     */
    void quickSort(int[] nums, int start, int end);

    /**
     * 归并排序
     * * 将长数组分隔为两段, 每段都进行递归排序
     * * 将递归排序完成的两段按序合并
     *
     * @see com.leetcode.main.interval901.q912.MergeSort
     */
    void mergeSort(int[] nums, int left, int right, int[] temp);

    /**
     * 堆排序
     * * 维护一个最大堆, 方法原型为将i位置元素沉底
     * * 每次将堆顶移动到最后, 堆容量-1, 然后将堆顶元素沉底
     *
     * @see com.leetcode.main.interval901.q912.HeapSort
     */
    void sort(int[] nums, int i, int len);
}
