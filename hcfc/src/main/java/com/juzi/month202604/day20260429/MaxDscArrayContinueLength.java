package com.juzi.month202604.day20260429;

import java.util.Arrays;

/**
 * 最长递增连续
 *
 * @author wenhai.lu
 * Create at 2026-04-29 上午 10:19
 */
public class MaxDscArrayContinueLength {
    public static void main(String[] args) {
        int[] a = {1, 9, 5, 4, 7};
        // 定义数组
        int[] dp = new int[a.length];
        // 初始化
        Arrays.fill(dp, 1);
        // 遍历
        for (int i = 1; i < a.length; i++) {
            if (a[i] > a[i - 1]) {
                dp[i] = dp[i - 1] + 1;
            }
        }
        // 递推公式
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < dp.length; i++) {
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }
}
