package com.juzi.month202603.day20260315;

/**
 * 最大子序列之和
 *
 * @author wenhai.lu
 * Create at 2026-03-15 下午 9:46
 */
public class MaxSubArraySum {
    public static void main(String[] args) {
        int[] a = {0, 2, -1, 0, 5};
        // 定义dp数组;以i结尾的最大值
        // 初始化;dp[0]=a[0]
        // 递推公式;i的位置为当前值,于前面的dp[i-1]+a[i]的比较大致
        // 遍历
        int[] dp = new int[a.length];
        dp[0] = a[0];
        for (int i = 1; i < a.length; i++) {
            dp[i] = Math.max(dp[i - 1] + a[i], a[i]);
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < dp.length; i++) {
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }
}
