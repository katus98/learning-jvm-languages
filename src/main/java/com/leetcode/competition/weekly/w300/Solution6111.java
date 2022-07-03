package com.leetcode.competition.weekly.w300;

import java.util.Arrays;

/**
 * 螺旋矩阵 IV
 *
 * @author SUN Katus
 * @version 1.0, 2022-07-03
 */
public class Solution6111 {
    private int m, n;
    private final static int[][] DIRS = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int[][] spiralMatrix(int m, int n, ListNode head) {
        this.m = m;
        this.n = n;
        int[][] mat = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(mat[i], -1);
        }
        ListNode cur = head;
        int dirIndex = 0, i = 0, j = -1;
        while (cur != null) {
            int num = cur.val;
            int[] dir = DIRS[dirIndex];
            int ni = i + dir[0];
            int nj = j + dir[1];
            while (!valid(ni, nj) || mat[ni][nj] != -1) {
                dirIndex = (dirIndex + 1) % 4;
                dir = DIRS[dirIndex];
                ni = i + dir[0];
                nj = j + dir[1];
            }
            mat[ni][nj] = num;
            i = ni;
            j = nj;
            cur = cur.next;
        }
        return mat;
    }

    private boolean valid(int i, int j) {
        return i >= 0 && j >= 0 && i < m && j < n;
    }

    public static void main(String[] args) {
        // [3,0,2,6,8,1,7,9,4,2,5,5,0]
        ListNode head = new ListNode(3);
        head.next = new ListNode(0);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(6);
        head.next.next.next.next = new ListNode(8);
        head.next.next.next.next.next = new ListNode(1);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(9);
        head.next.next.next.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next.next.next.next.next.next.next = new ListNode(0);
        Solution6111 solution6111 = new Solution6111();
        System.out.println(Arrays.deepToString(solution6111.spiralMatrix(3, 5, head)));
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
