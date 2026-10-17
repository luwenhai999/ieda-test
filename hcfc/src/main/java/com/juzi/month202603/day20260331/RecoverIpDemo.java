package com.juzi.month202603.day20260331;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 复原ip
 *
 * @author wenhai.lu
 * Create at 2026-03-31 下午 10:07
 */
public class RecoverIpDemo {
    private static List<String> result = new ArrayList<>();
    private static Stack<String> path = new Stack<>();

    public static void main(String[] args) {
        String a = "0000";
        // 终止条件: startIndex=a.length
        // 回溯,先判断是否合法(非零开始,且大小小于等于255)
        backTrace(a, 1, 0);
        System.out.println(result);
    }

    private static void backTrace(String a, int level, int startIndex) {
        if (path.size() > 4) {
            return;
        }
        if (startIndex >= a.length()) {
            ArrayList<String> strings = new ArrayList<>(path);
            StringBuilder sb = new StringBuilder();
            for (String string : strings) {
                sb.append(string).append(".");
            }
            sb.deleteCharAt(sb.length() - 1);
            result.add(sb.toString());
            return;
        }
        for (int i = startIndex; i < a.length(); i++) {
            String cur = a.substring(startIndex, i + 1);
            if (cur.length() > 3 || !check(cur)) {
                continue;
            }
            path.push(cur);
            backTrace(a, level + 1, i + 1);
            path.pop();
        }
    }

    private static boolean check(String str) {
        try {
            if (str.length() > 1 && str.startsWith("0")) {
                return false;
            }
            Integer integer = Integer.valueOf(str);
            if (integer > 255) {
                return false;
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
