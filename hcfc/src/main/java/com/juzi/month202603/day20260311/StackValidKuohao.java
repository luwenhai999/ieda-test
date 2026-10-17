package com.juzi.month202603.day20260311;

import java.util.Stack;

/**
 * 判断有效的括号
 *
 * @author wenhai.lu
 * Create at 2026-03-11 下午 4:41
 */
public class StackValidKuohao {
    public static void main(String[] args) {
        String a = "([)]{}";
        Stack<Character> stack = new Stack<>();
        char[] chars = a.toCharArray();
        boolean flag = true;
        for (char aChar : chars) {
            if (aChar == '(') {
                stack.push(')');
            } else if (aChar == '[') {
                stack.push(']');
            } else if (aChar == '{') {
                stack.push('}');
            } else if (!stack.isEmpty() && aChar == stack.peek()) {
                stack.pop();
            } else {
                // 如果无法匹配,则肯定不是有效的
                flag = false;
                break;
            }
        }
        if (!flag) {
            System.out.println(flag);
        } else {
            // 如果全都死左括号系列,无法走到直接判定false的地方,需要判定stack内部
            System.out.println(stack.isEmpty());
        }
    }

    public static void main1(String[] args) {
        String a = "()[]{}}}";
        Stack<Character> stack = new Stack<>();
        char[] chars = a.toCharArray();
        for (char aChar : chars) {
            if (aChar == '(' || aChar == '[' || aChar == '{') {
                stack.push(aChar);
            }
            if (aChar == ')') {
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                } else {
                    System.out.println(false);
                    break;
                }
            }
            if (aChar == ']') {
                if (!stack.isEmpty() && stack.peek() == '[') {
                    stack.pop();
                } else {
                    System.out.println(false);
                    break;
                }
            }
            if (aChar == '}') {
                if (!stack.isEmpty() && stack.peek() == '{') {
                    stack.pop();
                } else {
                    System.out.println(false);
                    break;
                }
            }
        }
        System.out.println(stack.isEmpty());
    }
}
