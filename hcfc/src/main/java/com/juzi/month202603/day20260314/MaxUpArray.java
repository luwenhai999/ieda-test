package com.juzi.month202603.day20260314;

import java.util.Arrays;

/**
 * 最长升序子序列
 * 1. 定义数组dp[i],表示以i为结尾的递升长度
 * 2. 初始化,默认就是1,它本身
 * 3. 递推公式,i需要跟它前边的比对,如果超过掐年的值,则用前面的值+1
 * 4. 遍历,i从1开始
 *
 * @author wenhai.lu
 * Create at 2026-03-14 下午 9:43
 */
public class MaxUpArray {
    public static void main(String[] args) {
        int[] a = {10, 9, 2, 5, 3, 7, 101, 18};
        int[] dp = new int[a.length];
        Arrays.fill(dp, 1);
        int max = Integer.MIN_VALUE;
        int last = 0;
        for (int i = 1; i < a.length; i++) {
            for (int j = 0; j < i; j++) {
                if (a[i] > a[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
                if (max < dp[i]) {
                    max = dp[i];
                    last = i;
                }
            }
        }
        System.out.println(max);
        System.out.println(last);
    }
}
