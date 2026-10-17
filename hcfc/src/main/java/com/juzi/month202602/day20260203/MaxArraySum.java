package com.juzi.month202602.day20260203;

import java.util.Arrays;

/**
 * @author wenhai.lu
 * Create at 2026-02-04 0:22
 */
public class MaxArraySum {
    public static void main(String[] args) {
        int[] a = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        // 使用动态规划
        // 定义输出dp[],i位置为结尾的最大值
        int[] dp = new int[a.length];
        // 初始值,都是零
        Arrays.fill(dp, 0);
        dp[0] = a[0];
        // 赋值逻辑,如果i-为负数,则不加,为正数,则加
        for (int i = 1; i < a.length; i++) {
            if (dp[i - 1] < 0) {
                dp[i] = a[i];
            } else {
                dp[i] = a[i] + dp[i - 1];
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < dp.length; i++) {
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
        // 遍历方式,从0开始
    }

    private static void useForce() {
        // 最大子序列和
        int[] a = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < a.length; i++) {
            int num = 0;
            for (int j = i; j < a.length; j++) {
                int temp = i;
                int thisNum = 0;
                while (temp <= j) {
                    thisNum += a[temp++];
                }
                max = Math.max(max, thisNum);
            }
        }
        System.out.println(max);
    }
}
