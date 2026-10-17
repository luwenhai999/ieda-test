package com.lugang.anytest.bBack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 组合求和
 *
 * @author wenhai.lu
 * Create at 2025-05-02 17:52
 */
public class LegalNoRepeatTarget {
    public static void main(String[] args) {
        int[] arr = {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> resultList = new ArrayList<>();
        Stack<Integer> thisList = new Stack<>();
        myBack(arr, thisList, resultList, 0, target, 0);
        System.out.println(resultList);
    }

    /**
     * 回溯三部曲
     * 1. 入参和返回值
     * 2. 确定终止条件
     * 3. 单层搜索的逻辑
     *
     * @param arr
     * @param thisList
     * @param resultList
     * @param sum
     * @param target
     * @param startIndex
     */
    private static void myBack(int[] arr, Stack<Integer> thisList, List<List<Integer>> resultList, int sum, int target, int startIndex) {
        if (sum == target) {
            resultList.add(new ArrayList<>(thisList));
        }
        for (int i = startIndex; i < arr.length; i++) {
            if (sum + arr[i] > target) {
                continue;
            }
            thisList.push(arr[i]);
            myBack(arr, thisList, resultList, sum + arr[i], target, i);
            thisList.pop();
        }
    }
}
