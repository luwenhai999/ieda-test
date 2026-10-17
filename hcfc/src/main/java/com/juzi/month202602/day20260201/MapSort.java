package com.juzi.month202602.day20260201;

import java.util.*;

/**
 * 针对map的排序
 *
 * @author wenhai.lu
 * Create at 2026-02-01 21:42
 */
public class MapSort {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("second", 2);
        map.put("third", 3);
        map.put("first", 1);
        map.put("fourth", 4);
        List<Map.Entry<String, Integer>> entries = new ArrayList<>(map.entrySet());
        Collections.sort(entries, Comparator.comparingInt(Map.Entry::getValue));
        System.out.println(entries);
    }
}
