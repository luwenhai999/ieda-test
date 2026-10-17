package com.juzi.month202601.day20260130;

import java.util.Arrays;

/**
 * 最长连续递增字符串的长度
 */
public class DpDemo1 {
    public static void main2(String[] args) {
        int[] a = {1, 3, 5, 4, 7};
        int[] dp = new int[a.length];
        Arrays.fill(dp, 1);
        for (int i = 1; i < a.length; i++) {
            if (a[i] > a[i - 1]) {
                dp[i] = dp[i - 1] + 1;
            }
        }
        int max = 0;
        for (int i : dp) {
            max = Math.max(i, max);
        }
        System.out.println(max);
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 5, 4, 7};
        // 1.定义数组,标识以i为结尾的值
        int[] dp = new int[a.length];

        // 3.初始化,都是1,就是数据本身
        Arrays.fill(dp, 1);

        // 4.从1开始,因为dp[0]=1已经定了, 然后遍历的时候j从0开始,找到比它小的,然后计算dp[i'
        for (int i = 1; i < a.length; i++) {
            if (a[i - 1] < a[i]) {
                // 2. 递推公式: dp[i]= 只要比j的数据大,就是dp[j]+1 与 dp[i]的最大值
                dp[i] = Math.max(dp[i], dp[i - 1] + 1);
            }
        }

        int max = 0;
        for (int i = 0; i < dp.length; i++) {
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }
}
