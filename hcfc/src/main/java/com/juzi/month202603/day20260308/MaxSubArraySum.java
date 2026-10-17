package com.juzi.month202603.day20260308;

/**
 * 最大子序列和
 *
 * @author wenhai.lu
 * Create at 2026-03-08 下午 9:39
 */
public class MaxSubArraySum {
    public static void main(String[] args) {
        int[] a = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] dp = new int[a.length];
        dp[0] = a[0];
        for (int i = 1; i < a.length; i++) {
            dp[i] = Math.max(dp[i - 1] + a[i], a[i]);
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < a.length; i++) {
            max = Math.max(dp[i], max);
        }
        System.out.println(max);
    }
}
