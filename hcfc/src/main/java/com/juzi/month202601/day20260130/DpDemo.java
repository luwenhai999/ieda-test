package com.juzi.month202601.day20260130;

import java.util.Arrays;

/**
 * 动态规划,计算最长升序串
 *
 * @author wenhai.lu
 * Create at 2026-01-30 22:51
 */
public class DpDemo {

    public static void main(String[] args) {
        int[] a = {10, 9, 2, 5, 3, 7, 101, 18};
        int[] dp = new int[a.length];
        Arrays.fill(dp, 1);
        int max = 0;
        for (int i = 1; i < a.length; i++) {
            for (int j = 0; j < i; j++) {
                if (a[j] <= a[i]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                    max = Math.max(dp[i], max);
                }
            }
        }
        System.out.println(max);
    }

    public static void main1(String[] args) {
        int[] a = {10, 9, 2, 5, 3, 7, 101, 18};
        // 1.定义数组,标识以i为结尾的值
        int[] dp = new int[a.length];

        // 3.初始化,都是1,就是数据本身
        Arrays.fill(dp, 1);

        // 4.从1开始,因为dp[0]=1已经定了, 然后遍历的时候j从0开始,找到比它小的,然后计算dp[i'
        for (int i = 1; i < a.length; i++) {
            for (int j = 0; j < i; j++) {
                if (a[j] < a[i]) {
                    // 2. 递推公式: dp[i]= 只要比j的数据大,就是dp[j]+1 与 dp[i]的最大值
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int max = 0;
        for (int i = 0; i < dp.length; i++) {
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }
}
