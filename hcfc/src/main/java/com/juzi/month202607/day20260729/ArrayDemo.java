package com.juzi.month202607.day20260729;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Juzi
 * @date 2026/7/1 10:11 下午
 */
public class ArrayDemo {

    public static void main(String[] args) {

    }

    /**
     * 两数之和
     */
    private static void twoNumSum() {
        int[] a = {2, 7, 11, 15};
        int taget = 18;
        Map<Integer, Integer> numToIndexMap = new HashMap<>();
        int[] indexList = new int[2];
        for (int i = 0; i < a.length; i++) {
            int anotherNum = taget - a[i];
            Integer anotherIndex = numToIndexMap.get(anotherNum);
            if (anotherIndex != null) {
                indexList[0] = anotherIndex;
                indexList[1] = i;
                System.out.println(Arrays.toString(indexList));
                continue;
            }
            numToIndexMap.put(a[i], i);
        }
    }


    /**
     * 删除有序数组中重复的数据,快慢指针方式
     */
    private static void delTheRepeatArray() {
        int[] a = {1, 1, 2, 3, 3, 3, 4, 5, 5};
        int slow = 1;
        for (int fast = 1; fast < a.length; fast++) {
            if (a[fast - 1] == a[fast]) {
                continue;
            }
            a[slow++] = a[fast];
        }
        System.out.println(slow);
        System.out.println(Arrays.toString(a));
    }
}
