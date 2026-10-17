package com.juzi.month202603.day20260331;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 分割回文串
 *
 * @author wenhai.lu
 * Create at 2026-03-31 下午 2:40
 */
public class SplitStrDemo {
    static List<List<String>> result = new ArrayList<>();
    static Stack<String> path = new Stack<>();

    public static void main(String[] args) {
        String a = "aa";
        backTrace(a, 0);
        System.out.println(result);
    }

    private static void backTrace(String a, int startIndex) {
        if (startIndex >= a.length()) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < a.length(); i++) {
            String str = a.substring(startIndex, i + 1);
            if (check(str)) {
                path.add(str);
                backTrace(a, i + 1);
                path.pop();
            }
        }
    }

    private static boolean check(String str) {
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
