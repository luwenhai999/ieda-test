package com.lugang.anytest.aDynamic;

/**
 * 回文子串的数量
 * 1. 定义dp[i][j]数组,表示[i,j]是否是回文串
 * 2. 定义推公式,如果i和j差距在0和1则直接是回文串;如果超过,则需要看dp[i+1][j-1]的数据
 * 3. 初始化
 * 4. 遍历方式
 *
 * @author wenhai.lu
 * Create at 2025-05-31 22:05
 */
public class LegalDynamicBackStrNum {
    public static void main(String[] args) {
        String str = "bbbab";
        boolean[][] dp = new boolean[str.length()][str.length()];
        int num = 0;
        int maxLength = 0;
        for (int i = str.length() - 1; i >= 0; i--) {
            for (int j = i; j < str.length(); j++) {
                if (j - i <= 1 && str.charAt(i) == str.charAt(j)) {
                    dp[i][j] = true;
                    num++;
                } else {
                    if (str.charAt(i) == str.charAt(j) && dp[i + 1][j - 1]) {
                        dp[i][j] = true;
                        num++;
                        maxLength = Math.max(maxLength, j - i + 1);
                    }
                }
            }
        }
        System.out.println(num);
        System.out.println(maxLength);
    }
}
