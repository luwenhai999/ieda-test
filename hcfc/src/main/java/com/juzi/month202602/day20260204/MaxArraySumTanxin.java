package com.juzi.month202602.day20260204;

/**
 * 子序列最大和,贪心算法
 *
 * @author wenhai.lu
 * Create at 2026-02-04 11:36
 */
public class MaxArraySumTanxin {
    public static void main(String[] args) {
        int[] a = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int max = Integer.MIN_VALUE;
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            count += a[i];
            max = Math.max(max, count);
            if (count < 0) {
                count = 0;
            }
        }
        System.out.println(max);
    }
}
