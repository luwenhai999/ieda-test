package com.lugang.demo;

/**
 * 最长公共子序列
 * 1. 定义dp[i][j]数组,标识str1以i-1为结尾,str2以j-1为结尾的的最长公共子序列
 * 2. 定义递推公式,如果两者相等,则是dp[i-1][j-1]+1;否则局势dp[i][j-1]和dp[i-1[j]的最大值
 * 3. 初始化,这种减一的情况,不需要赋值,因为零无意义,零所在的位置就是0
 * 4. 遍历方式,从1开始,到length,包含
 *
 * @author wenhai.lu
 * Create at 2025-06-01 22:37
 */
public class LegalCMaxPublicMaxDemo {

    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "ace";
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        int max = 0;
        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        System.out.println(max);
    }
}
