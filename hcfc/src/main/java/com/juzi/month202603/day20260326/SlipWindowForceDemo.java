package com.juzi.month202603.day20260326;

import java.util.Arrays;

/**
 * 滑动窗口取最大值,暴力解法
 *
 * @author wenhai.lu
 * Create at 2026-03-26 下午 1:54
 */
public class SlipWindowForceDemo {
    public static void main(String[] args) {
        int[] a = {1, 3, -1, -3, 5, 3, 1, 2};
        int k = 3;
        int[] maxIndex = new int[a.length - k + 1];
        int index = 0;
        for (int i = k - 1; i < a.length; i++) {
            maxIndex[index++] = getMaxInt(a, i - k + 1, i);
        }
        System.out.println(Arrays.toString(maxIndex));

    }

    private static int getMaxInt(int[] a, int left, int right) {
        int max = Integer.MIN_VALUE;
        for (int i = left; i <= right; i++) {
            max = Math.max(a[i], max);
        }
        return max;
    }
}
