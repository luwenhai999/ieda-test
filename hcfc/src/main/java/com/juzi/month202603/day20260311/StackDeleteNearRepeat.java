package com.juzi.month202603.day20260311;

import java.util.Stack;

/**
 * 删除相邻相同的元素
 *
 * @author wenhai.lu
 * Create at 2026-03-11 下午 5:26
 */
public class StackDeleteNearRepeat {
    public static void main(String[] args) {
        String a = "abbaca";
        Stack<Character> stack = new Stack<>();
        char[] array = a.toCharArray();
        for (char c : array) {
            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
                continue;
            }
            stack.push(c);
        }
        String str = "";
        while (!stack.isEmpty()) {
            str = stack.pop() + str;
        }
        System.out.println(str);
    }
}
