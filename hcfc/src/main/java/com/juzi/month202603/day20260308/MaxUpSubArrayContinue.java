package com.juzi.month202603.day20260308;

import java.util.Arrays;

/**
 * 最长连续递增子序列
 *
 * @author wenhai.lu
 * Create at 2026-03-08 下午 8:37
 */
public class MaxUpSubArrayContinue {
    public static void main(String[] args) {
        int[] a = {1, 3, 5, 4, 7};
        int[] dp = new int[a.length];
        Arrays.fill(dp, 1);
        for (int i = 1; i < a.length; i++) {
            if (a[i] > a[i - 1]) {
                dp[i] = dp[i - 1] + 1;
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < dp.length; i++) {
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }
}
