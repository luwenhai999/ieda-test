package com.lugang.anytest.bstack;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 有效的括号
 *
 * @author wenhai.lu
 * Create at 2025-04-30 22:01
 */
public class LegalStackBracket {
    public static void main(String[] args) {
        String a = "((()))[]";
        System.out.println(check(a));
    }

    private static boolean check(String a) {
        List<Character> leftBracketList = Arrays.asList('(', '[', '{');
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < a.length(); i++) {
            char c = a.charAt(i);
            if (leftBracketList.contains(c)) {
                stack.push(c);
                continue;
            }
            // 对应左边少了,右边多了的情况
            if (stack.isEmpty()) {
                return false;
            }
            Character pop = stack.pop();
            if (c == ')' && pop == '(') {
                continue;
            }
            if (c == '}' && pop == '{') {
                continue;
            }
            if (c == ']' && pop == '[') {
                continue;
            }
            // 对应中间匹配不上的,可能是错乱
            return false;
        }
        if (stack.isEmpty()) {
            return true;
        }
        // 对应左边多了的情况
        return false;
    }
}
