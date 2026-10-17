package com.juzi.month202603.day20260329;

/**
 * 斐波那契
 *
 * @author wenhai.lu
 * Create at 2026-03-29 下午 1:59
 */
public class FeiBoNaQieDemo {
    public static void main(String[] args) {
        int n = 6;
        // 定义数组,第i+1个的值
        int[] dp = new int[n];
        // 初始化
        dp[0] = 1;
        dp[1] = 1;
        // 遍历
        for (int i = 2; i < n; i++) {
            // 递推条件
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        System.out.println(dp[n - 1]);
    }
}
