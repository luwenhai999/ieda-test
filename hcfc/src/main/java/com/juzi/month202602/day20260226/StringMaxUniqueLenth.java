package com.juzi.month202602.day20260226;

import java.util.HashSet;
import java.util.Set;

/**
 * @author wenhai.lu
 * Create at 2026-02-26 下午 9:27
 */
public class StringMaxUniqueLenth {
    public static void main(String[] args) {
        String a = "aaaa";
        int maxLength = 0;
        Set<Character> set = new HashSet<>();
        int left = 0;
        for (int i = 0; i < a.length(); i++) {
            if (set.contains(a.charAt(i))) {
                set.remove(a.charAt(left++));
            }
            set.add(a.charAt(i));
            maxLength = Math.max(maxLength, set.size());
        }
        System.out.println(maxLength);
    }
}
