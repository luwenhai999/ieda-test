package com.juzi.month202603.day20260329;

/**
 * 爬楼梯的方法数
 *
 * @author wenhai.lu
 * Create at 2026-03-29 下午 2:27
 */
public class TotalSetpNum {
    public static void main(String[] args) {
        int n = 3;
        // 定义递推数组
        int[] dp = new int[n];
        // 定义递推条件 n-1 + n-2
        // 定义初始化
        dp[0] = 1;
        dp[1] = 2;
        // 遍历顺序
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        System.out.println(dp[n - 1]);
    }
}
