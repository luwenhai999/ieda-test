package com.juzi.month202603.day20260307;

/**
 * 最大子序列和
 *
 * @author wenhai.lu
 * Create at 2026-03-07 下午 9:50
 */
public class MaxSubArraySum {
    public static void main(String[] args) {
        int[] a = {-5, -3, -1};
        int[] dp = new int[a.length];
        dp[0] = a[0];
        for (int i = 1; i < a.length; i++) {
            // i的值为i-1的值+i的值,与i本身的比较
            dp[i] = Math.max(dp[i - 1] + a[i], a[i]);
        }
        int max = Integer.MIN_VALUE;
        for (int i : dp) {
            max = Math.max(max, i);
        }
        System.out.println(max);
    }
}
