package com.juzi.month202603.day20260313;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 最长无重复子串长度
 *
 * @author wenhai.lu
 * Create at 2026-03-13 下午 9:38
 */
public class MaxNoRepeatLength {
    public static void main(String[] args) {
        String a = "ababcdeabc";
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < a.length(); i++) {
            // 如果出现重复的,则left会持续向后递增,出现相同的值,则取值段从该值后面一个开始
            if (map.containsKey(a.charAt(i))) {
                left = map.get(a.charAt(i)) + 1;
            }
            map.put(a.charAt(i), i);
            max = Math.max(i - left + 1, max);
        }
        System.out.println(max);
    }

    private static void useSet(String a) {
        Set<Character> set = new HashSet<>();
        int left = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < a.length(); i++) {
            // 如果set里面包含了当前字符,则需要将set从签到后一直删除,直到当前这个相同的值被干掉
            if (set.contains(a.charAt(i))) {
                set.remove(left++);
            }
            set.add(a.charAt(i));
            max = Math.max(max, set.size());
        }
        System.out.println(max);
    }
}
