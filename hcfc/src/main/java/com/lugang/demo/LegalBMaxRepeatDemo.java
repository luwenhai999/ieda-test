package com.lugang.demo;

/**
 * 最长重复子数组
 * 1. 定义dp[i][j]标识,num1以i-1结尾,num2以j-1为结尾的最长个数
 * 2. 递推公式,如果i和j相同,则是dp[i-1][j-1]+1,否则不计算
 * 3. 初始化,无需初始化
 * 4. 遍历,从1开始,但是要到n
 *
 * @author wenhai.lu
 * Create at 2025-06-01 22:28
 */
public class LegalBMaxRepeatDemo {
    public static void main(String[] args) {
        int[] num1 = {1, 2, 3, 2, 1};
        int[] num2 = {3, 2, 4, 1, 4, 7};
        int[][] dp = new int[num1.length + 1][num2.length + 1];
        int max = 0;
        for (int i = 1; i <= num1.length; i++) {
            for (int j = 1; j <= num2.length; j++) {
                if (num1[i - 1] == num2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        System.out.println(max);

    }
}
