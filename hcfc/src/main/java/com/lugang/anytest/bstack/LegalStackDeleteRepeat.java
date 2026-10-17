package com.lugang.anytest.bstack;

import java.util.Stack;

/**
 * 删除重复的数据
 *
 * @author wenhai.lu
 * Create at 2025-04-30 22:26
 */
public class LegalStackDeleteRepeat {
    public static void main(String[] args) {
        String a = "abbaca";
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < a.length(); i++) {
            char thisChar = a.charAt(i);
            if (stack.isEmpty()) {
                stack.push(thisChar);
                continue;
            }
            if (stack.peek() == thisChar) {
                while (!stack.isEmpty() && stack.peek() == thisChar) {
                    stack.pop();
                }
                continue;
            }
            stack.push(thisChar);
        }
        String s = "";
        while (!stack.isEmpty()) {
            s = stack.pop() + s;
        }
        System.out.println(s);
    }
}
