package com.juzi.month202604.day20260428;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 *
 * @author wenhai.lu
 * Create at 2026-04-28 下午 10:40
 */
public class TwoNumSum {
    public static void main(String[] args) {
        int[] a = {2, 7, 11, 15};
        int taget = 9;
        int[] result = new int[2];
        Map<Integer, Integer> targetNumToThisIndexMap = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            if (targetNumToThisIndexMap.containsKey(a[i])) {
                result[0] = targetNumToThisIndexMap.get(a[i]);
                result[1] = i;
                System.out.println(Arrays.toString(result));
                break;
            }
            targetNumToThisIndexMap.put(taget - a[i], i);
        }

    }
}
