package com.juzi.month202603.day20260323;

import java.util.*;

/**
 * 1. 验证map的有序请
 * 2. 验证set的有序请(验证,set不是按照输入的顺序来的,是无序的)
 *
 * @author wenhai.lu
 * Create at 2026-03-23 下午 10:36
 */
public class TestMap {
    public static void main(String[] args) {
        List<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(3);
        a.add(2);
        a.add(4);
        a.remove(1);
        for (Integer integer : a) {
            System.out.println(integer);
        }
        for (int i = 0; i < a.size(); i++) {
            System.out.println(a.get(i));
        }
        Iterator<Integer> iterator = a.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    private static void testMap() {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 1);
        map.put(31, 31);
        map.put(5, 5);
        map.put(21, 21);
        map.put(4, 4);
        map.put(6, 6);
        // 第一种方式,使用keySet
        Set<Integer> integers = map.keySet();
        for (Integer integer : integers) {
            System.out.print(map.get(integer));
            System.out.print(",");
        }
        System.out.println();
        // 第二种方式,使用entrySet
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries) {
            System.out.print(entry.getValue());
            System.out.print(",");
        }
        testSet();
    }

    private static void testSet() {
        Set<Integer> a = new HashSet<>();
        a.add(1);
        a.add(31);
        a.add(5);
        a.add(21);
        a.add(4);
        a.add(6);
        // 曾倩for
        for (Integer integer : a) {
            System.out.println(integer);
        }
        Iterator<Integer> iterator = a.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
