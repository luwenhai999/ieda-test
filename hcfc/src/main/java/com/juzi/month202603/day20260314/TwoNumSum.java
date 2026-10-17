package com.juzi.month202603.day20260314;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 *
 * @author wenhai.lu
 * Create at 2026-03-14 下午 9:31
 */
public class TwoNumSum {
    public static void main(String[] args) {
        int[] a = {2, 7, 11, 15};
        int taget = 18;
        //key为另一个加数,value为该加数的index
        Map<Integer, Integer> numToIndexMap = new HashMap<>();
        int[] arr = new int[2];
        for (int i = 0; i < a.length; i++) {
            // 计算另一个加数的值
            int partner = taget - a[i];
            // 判断另一个加数是否存在,如果存在则能作为伴侣
            Integer integer = numToIndexMap.get(partner);
            if (integer != null) {
                arr[0] = integer;
                arr[1] = i;
                break;
            }
            numToIndexMap.put(a[i], i);
        }
        System.out.println(Arrays.toString(arr));
    }
}
