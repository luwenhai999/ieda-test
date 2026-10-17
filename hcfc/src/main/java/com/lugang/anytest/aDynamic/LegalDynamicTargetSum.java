package com.lugang.anytest.aDynamic;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 目标和
 * 1. 动态规划
 * 2. 回溯算法
 *
 * @author wenhai.lu
 * Create at 2025-05-05 21:20
 */
public class LegalDynamicTargetSum {


    public static void main(String[] args) {
        int target = 4;
        // 1. 定义dp数组,dp[j]表示容量为j包,从0-i物品中选取,填满他的方法种数
        int[] dp = new int[target + 1];
        // 2. 递推公式 dp[j]=dp[j]+dp[j-num[i]];
        // 不包含它,上一个层就能达标的数量是dp[j]
        // 包含他,此时容量为[j-num[i]],上一层的数量为dp[j-num[i]];
    }

    /**
     * 回溯算法
     */
    private static void backTraceFunction() {
        int[] arr = {1, 1, 1, 1, 1};
        int target = 4;
        List<List<Integer>> resultList = new ArrayList<>();
        Stack<Integer> path = new Stack<>();
        backTrace(resultList, path, arr, target, 0, 0);
        System.out.println(resultList.size());
        System.out.println(resultList);
    }

    private static void backTrace(List<List<Integer>> resultList, Stack<Integer> path, int[] arr,
                                  int target, int sum, int startIndex) {
        if (sum > target) {
            return;
        }
        if (sum == target) {
            resultList.add(new ArrayList<>(path));
        }
        for (int i = startIndex; i < arr.length; i++) {
            path.push(i);
            backTrace(resultList, path, arr, target, sum + arr[i], i + 1);
            path.pop();
        }
    }
}
