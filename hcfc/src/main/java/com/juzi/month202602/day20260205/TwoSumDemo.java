package com.juzi.month202602.day20260205;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 *
 * @author wenhai.lu
 * Create at 2026-02-05 21:07
 */
public class TwoSumDemo {
    public static void main(String[] args) {
        int[] a = {2, 7, 11, 15};
        int target = 9;
        int[] res = new int[2];
        Map<Integer, Integer> anotherNumToIndexMap = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            int antherNum = target - a[i];
            if (anotherNumToIndexMap.containsKey(antherNum)) {
                Integer anotherIndex = anotherNumToIndexMap.get(antherNum);
                res[0] = i;
                res[1] = anotherIndex;
            } else {
                anotherNumToIndexMap.put(a[i], i);
            }
        }
        System.out.println(Arrays.toString(res));
    }
}
