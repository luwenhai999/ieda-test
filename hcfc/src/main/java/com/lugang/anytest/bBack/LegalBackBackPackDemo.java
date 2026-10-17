package com.lugang.anytest.bBack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author wenhai.lu
 * Create at 2025-05-04 22:46
 */
public class LegalBackBackPackDemo {
    public static void main(String[] args) {
        int[] weightArr = {1, 3, 4};
        int[] valueArr = {15, 20, 30};
        int target = 4;
        List<List<Integer>> indexResultList = new ArrayList<>();
        Stack<Integer> indexPath = new Stack<>();
        test(indexResultList, indexPath, weightArr, target, 0, 0);
        int max = 0;
        for (List<Integer> integers : indexResultList) {
            int thisMax = 0;
            for (Integer integer : integers) {
                thisMax += valueArr[integer];
            }
            max = Math.max(max, thisMax);
        }
        System.out.println(max);
    }

    private static void test(List<List<Integer>> indexResultList, Stack<Integer> indexPath, int[] weightArr, int target, int weightTotal, int startIndex) {
        if (weightTotal > target) {
            Integer pop = indexPath.pop();
            indexResultList.add(new ArrayList<>(indexPath));
            indexPath.push(pop);
            return;
        }
        if (weightTotal == target) {
            indexResultList.add(new ArrayList<>(indexPath));
            return;
        }
        for (int index = startIndex; index < weightArr.length; index++) {
            indexPath.push(index);
            test(indexResultList, indexPath, weightArr, target, weightTotal + weightArr[index], index + 1);
            indexPath.pop();
        }

    }
}
