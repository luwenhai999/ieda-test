package com.lugang.demo;

/**
 * 完全背包问题
 * 1. 定义dp[i][j]数组,存放[0,i]的物品,在重量j时的最大value
 * 2. 递推公式,重量为j时,i包含和不包含;包含时就是dp[i][j-w[i]]+value[i];不包含时就是dp[i-1][j]
 * 这个里面可以偶无限个
 * 3. 初始化,i-1,所以i=0的情况需要初始
 * 4. 遍历方式,i从1开始,j要从i的大小位置开始
 *
 * @author wenhai.lu
 * Create at 2025-06-01 22:05
 */
public class LegalAPackageDemo {
    public static void main(String[] args) {
        int[] value = {15, 20, 30};
        int[] weight = {1, 3, 4};
        int target = 4;
        int[][] dp = new int[weight.length][target + 1];
        // 初始化时,需要注意这个是可以放置多个的
        for (int j = weight[0]; j <= target; j++) {
            dp[0][j] = dp[0][j - weight[0]] + value[0];
        }
        //
        for (int i = 1; i < weight.length; i++) {
            for (int j = 0; j <= target; j++) {
                if (j >= weight[i]) {
                    dp[i][j] = Math.max(dp[i][j - weight[i]] + value[i], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        System.out.println(dp[dp.length - 1][dp[0].length - 1]);
    }
}
