package com.lugang.anytest.aDynamic;

/**
 * 背包问题,完全背包
 * 1. 二维数组
 * 2. 一维数组
 *
 * @author wenhai.lu
 * Create at 2025-05-04 23:00
 */
public class LegalDynamicBackPack {
    public static void main(String[] args) {
        oneDFunction();
    }

    /**
     * 一维数组实现
     */
    private static void oneDFunction() {
        int[] weightArr = {1, 2, 4};
        int[] valueArr = {15, 50, 30};
        int bagWeight = 4;
        // 1. 定义dp数组,dp[j],表示任取0-j个元素的最大值,这个是需要有个外层的遍历的
        int[] dp = new int[bagWeight + 1];
        // 3. 初始值
        // 4. 遍历方式
        for (int i = 0; i < weightArr.length; i++) {
            for (int j = weightArr[i]; j <= bagWeight; j++) {
                // 2. 递推公式
                // 如果不包含当前i物品,则是上一层的dp[j]
                // 如果包含当前i武平,则是本层dp[i][j-weight[i]](因为包含,同时容量肯定是j-weight[i],则此时i肯定大于等号i-1,可选项多)
                //
                dp[j] = Math.max(dp[j], dp[j - weightArr[i]] + valueArr[i]);
            }
        }
        System.out.println(dp[dp.length - 1]);
    }

    /**
     * 二维数组实现
     */
    private static void towDFunction() {
        // 1. 确定db数组的含义,i表示0-i任取,j表示包的容量,dp[i][j]表示容量为j的包中,任取0-i物品的最大值
        int[] weightArr = {1, 3, 4};
        int[] valueArr = {15, 20, 30};
        int bagWeight = 4;
        int[][] dp = new int[weightArr.length][bagWeight + 1];
        // 3. 初始值定义
        for (int j = 0; j <= bagWeight; j++) {
            if (j < weightArr[0]) {
                dp[0][j] = 0;
                continue;
            }
            dp[0][j] = dp[0][j - weightArr[0]] + valueArr[0];
        }
        // 4. 遍历方式
        for (int i = 1; i < weightArr.length; i++) {
            // 2. 递推公式
            for (int j = 0; j <= bagWeight; j++) {
                if (j < weightArr[i]) {
                    dp[i][j] = dp[i - 1][j];
                    continue;
                }
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - weightArr[i]] + valueArr[i]);
            }
        }
        // 5. 打印
        System.out.println(dp[dp.length - 1][dp[0].length - 1]);
    }
}
