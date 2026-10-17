package com.juzi.month202603.day20260308;

/**
 * 佩奇博纳
 *
 * @author wenhai.lu
 * Create at 2026-03-08 下午 9:49
 */
public class FeiQiBoNaTest {
    public static void main(String[] args) {
        // 定义数组
        int k = 4;
        int[] dp = new int[k + 1];
        // 初始条件
        dp[0] = 0;
        dp[1] = 1;
        // 递推公式i=(i-1)+(i-2),i的最小值为2
        // 遍历方式
        for (int i = 2; i <= k; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        System.out.println(dp[k]);
    }
}
