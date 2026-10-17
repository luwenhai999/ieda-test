package com.juzi.month202604.day20260411;

/**
 * 动态规划,计算台阶
 *
 * @author wenhai.lu
 * Create at 2026-04-11 下午 3:07
 */
public class DynamicStep {
    public static void main(String[] args) {
        // 定义数组,dp[n]
        int n = 60;// 764848393
        int[] dp = new int[n + 1];
        // 初始化
        dp[1] = 1;
        dp[2] = 2;
        // 递推公式
        // 遍历
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        System.out.println(dp[n]);
    }

    // 764848393
    public static int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
