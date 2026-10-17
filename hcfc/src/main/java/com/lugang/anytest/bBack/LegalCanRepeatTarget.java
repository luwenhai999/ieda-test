package com.lugang.anytest.bBack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 组合求和,数字有重复,但是结果集不能重复
 *
 * @author wenhai.lu
 * Create at 2025-05-02 19:08
 */
public class LegalCanRepeatTarget {
    public static void main(String[] args) {
        int[] arr = {10, 1, 2, 7, 6, 1, 5};
        Arrays.sort(arr);
        int target = 8;
        List<List<Integer>> resultList = new ArrayList<>();
        Stack<Integer> path = new Stack<>();
        boolean[] indexFlag = new boolean[arr.length];
        myBack(resultList, path, arr, target, 0, 0, indexFlag);
        System.out.println(resultList);
    }

    private static void myBack(List<List<Integer>> resultList, Stack<Integer> path, int[] arr, int target, int sum, int startIndex, boolean[] indexFlag) {
        if (sum > target) {
            return;
        }
        if (sum == target) {
            resultList.add(new ArrayList<>(path));
        }
        for (int i = startIndex; i < arr.length; i++) {
            int thisNum = arr[i];
            // 针对 1,1,1
            if (i > 0 && thisNum == arr[i - 1] && !indexFlag[i - 1]) {
                continue;
            }
            path.push(thisNum);
            indexFlag[i] = true;
            myBack(resultList, path, arr, target, sum + thisNum, i + 1, indexFlag);
            path.pop();
            indexFlag[i] = false;
        }
    }
}
