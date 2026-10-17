package com.juzi.month202604.day20260429;

import java.util.Arrays;

/**
 * 最长升序子序列
 *
 * @author wenhai.lu
 * Create at 2026-04-29 上午 10:07
 */
public class MaxDesArrayLength {
    public static void main(String[] args) {
        int[] a = {10, 9, 2, 5, 3, 7, 101, 18};
        // 定义数组
        int[] dp = new int[a.length];
        // 初始化
        Arrays.fill(dp, 1);
        // 遍历
        for (int i = 1; i < a.length; i++) {
            // 递推公式
            for (int j = i - 1; j >= 0; j--) {
                if (a[i] > a[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < dp.length; i++) {
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }
}
