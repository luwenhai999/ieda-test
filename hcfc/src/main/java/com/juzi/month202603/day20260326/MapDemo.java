package com.juzi.month202603.day20260326;

import java.util.*;

/**
 * 测试map的一些方法
 *
 * @author wenhai.lu
 * Create at 2026-03-26 下午 2:14
 */
public class MapDemo {
    public static void main(String[] args) {
        int[] a = {1, 1, 1, 2, 2, 3};
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : a) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((first, second) -> second.getValue() - first.getValue());

        int k = 2;
        for (int i = 0; i < k; i++) {
            System.out.println(list.get(i).getKey());
        }


        System.out.println(map);

    }
}
