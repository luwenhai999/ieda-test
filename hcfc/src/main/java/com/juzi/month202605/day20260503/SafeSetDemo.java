package com.juzi.month202605.day20260503;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author wenhai.lu
 * Create at 2026-05-03 下午 1:29
 */
public class SafeSetDemo {
    public static void main(String[] args) {
        // hashSet不是按照插入顺序
        Set<String> set = new HashSet<>();
        set.add("1");
        set.add("3");
        set.add("2");
        for (String s : set) {
            System.out.print(s);
        }
        System.out.println();

        // copyOnWriteArraySet是按照插入有序
        set = new CopyOnWriteArraySet<>();
        set.add("1");
        set.add("3");
        set.add("2");
        for (String s : set) {
            System.out.print(s);
        }

    }
}
