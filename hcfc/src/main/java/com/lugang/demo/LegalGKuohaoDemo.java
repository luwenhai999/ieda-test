package com.lugang.demo;

import java.util.Stack;

/**
 * 括号深度
 *
 * @author wenhai.lu
 * Create at 2025-06-02 12:21
 */
public class LegalGKuohaoDemo {
    public static void main(String[] args) {
        String str = "([]{()}))";
        Stack<Character> stack = new Stack<>();
        int num = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
                num = Math.max(num, stack.size());
                continue;
            }
            if (stack.isEmpty()) {
                System.out.println(-1);
                return;
            }
            Character lastChar = stack.pop();
            if (c == ')' && lastChar == '(') {
                continue;
            }
            if (c == ']' && lastChar == '[') {
                continue;
            }
            if (c == '}' && lastChar == '{') {
                continue;
            }
            System.out.println(-1);
            return;
        }
        if (!stack.isEmpty()) {
            System.out.println(-1);
            return;
        }
        System.out.println(num);
    }
}
