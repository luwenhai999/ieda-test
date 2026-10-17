package com.juzi.month202603.day20260308;

import java.util.Arrays;

/**
 * 最长上升子序列
 *
 * @author wenhai.lu
 * Create at 2026-03-08 下午 8:24
 */
public class MaxUpSubArray {
    public static void main(String[] args) {
        int[] a = {10, 9, 2, 5, 3, 7, 101, 18};
        // 定义数组
        int[] dp = new int[a.length];
        // 初始化
        Arrays.fill(dp, 1);
        // 递推条件,如果i>i-1,则为dp[i]+1;否则为dp[i-1]或dp[i]的最大值
        for (int i = 1; i < a.length; i++) {
            for (int j = 0; j < i; j++) {
                if (a[i] > a[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        // 遍历
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < dp.length; i++) {
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }
}
