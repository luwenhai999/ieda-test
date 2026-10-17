package com.lugang.anytest.bstack;

import java.util.Stack;

/**
 * @author wenhai.lu
 * Create at 2025-04-30 22:51
 */
public class LegalStackPostDemo {
    public static void main(String[] args) {
        String[] strArr = {"10", "6", "9", "3", "+", "-11", " * ", "/", " * ", "17", "+", "5", "+"};
        Stack<Integer> stack = new Stack<>();
        for (String str : strArr) {
            str = str.trim();
            if ("+".equals(str)) {
                Integer second = stack.pop();
                Integer first = stack.pop();
                stack.push(first + second);
                continue;
            }
            if ("-".equals(str)) {
                Integer second = stack.pop();
                Integer first = stack.pop();
                stack.push(first - second);
                continue;
            }
            if ("*".equals(str)) {
                Integer second = stack.pop();
                Integer first = stack.pop();
                stack.push(first * second);
                continue;
            }
            if ("/".equals(str)) {
                Integer second = stack.pop();
                Integer first = stack.pop();
                stack.push(first / second);
                continue;
            }
            stack.push(Integer.parseInt(str));
        }
        System.out.println(stack.pop());
    }
}
