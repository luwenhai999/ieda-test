package com.juzi.month202604.day20260407;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 可用的ip
 *
 * @author wenhai.lu
 * Create at 2026-04-07 下午 9:27
 */
public class ReliableIpDemo {
    private static List<String> result = new ArrayList<>();
    private static Stack<String> path = new Stack<>();

    public static void main(String[] args) {
        String a = "25525511135";
        backTrac(a, 0);
        System.out.println(result);
    }

    private static void backTrac(String a, int startIndex) {
        if (path.size() > 4) {
            return;
        }
        if (path.size() == 4 && startIndex >= a.length()) {
            List<String> list = new ArrayList<>(path);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < list.size() - 1; i++) {
                sb.append(list.get(i)).append(".");
            }
            sb.append(list.get(list.size() - 1));
            result.add(sb.toString());
            return;
        }
        for (int i = startIndex; i < a.length(); i++) {
            String substring = a.substring(startIndex, i + 1);
            if (!valid(substring)) {
                break;
            }
            path.add(substring);
            backTrac(a, i + 1);
            path.pop();
        }
    }

    private static boolean valid(String str) {
        if (str.length() > 3) {
            return false;
        }
        if (str.length() > 1 && str.startsWith("0")) {
            return false;
        }
        Integer integer = Integer.valueOf(str);
        if (integer > 255) {
            return false;
        }
        return true;
    }

}
