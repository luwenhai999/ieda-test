package com.juzi.month202602.day20260204;

import java.util.Arrays;

/**
 * @author wenhai.lu
 * Create at 2026-02-04 23:58
 */
public class MaxOrderArray {
    public static void main(String[] args) {
        int[] a = {2,2,2,2,2};
        int[] dp = new int[a.length];
        Arrays.fill(dp, 1);
        for (int i = 1; i < a.length; i++) {
            if (a[i] > a[i - 1]) {
                dp[i] = dp[i - 1] + 1;
            }
        }
        int max = 0;
        for (int i = 0; i < dp.length; i++) {
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }
}
