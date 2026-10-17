package com.juzi.month202603.day20260329;

/**
 * @author wenhai.lu
 * Create at 2026-03-29 下午 2:39
 */
public class MinStepCount {
    public static void main(String[] args) {
        int[] a = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        int[] dp = new int[a.length + 1];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.min(dp[i - 1] + a[i - 1], dp[i - 2] + a[i - 2]);
        }
        System.out.println(dp[dp.length - 1]);
    }
}
