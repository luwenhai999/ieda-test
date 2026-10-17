package com.lugang.anytest.aDynamic;

import java.util.Scanner;

/**
 * 最长回文子串长度
 * 1. 定义dp[i][j]数组,标识[i,j]之间的最长回文串
 * 2. 递推公式,i和j相等的前提下,如果i和j挨着,则是j-i+1;否则就是dp[i+1][j-1]+2
 * 3. 初始化,都是零
 * 4. 遍历方式
 *
 * @author wenhai.lu
 * Create at 2025-05-31 23:10
 */
public class LegalDynamicBackMaxLengthNum {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int[][] dp = new int[str.length()][str.length()];
        int maxLength = 0;
        for (int i = str.length() - 1; i >= 0; i--) {
            for (int j = i; j < str.length(); j++) {
                if (str.charAt(i) == str.charAt(j)) {
                    if (j - i <= 1) {
                        dp[i][j] = j - i + 1;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1] + 2;
                    }
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
                maxLength = Math.max(maxLength, dp[i][j]);
            }
        }
        System.out.println(maxLength);
    }
}
