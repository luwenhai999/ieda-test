package com.lugang.anytest.bstack;

import java.util.Stack;

/**
 * @author wenhai.lu
 * Create at 2025-04-30 20:16
 */
public class LegalStackToQueue {
    /**
     * 入队队列
     * 1. 入队时首先将out的全部放进去里
     * 2. 然后将元素放入
     */
    private static Stack<String> in = new Stack<>();
    /**
     * 出队队列
     * 1. 出队时首先将in的队列全部放入
     * 2. 然后弹出pop
     */
    private static Stack<String> out = new Stack<>();

    public static void put(String str) {
        in.push(str);
    }

    public static String pop() {
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }
        return out.pop();
    }

    public static void main(String[] args) {
        put("1");
        put("2");
        put("3");
        System.out.println(pop());//1
        put("4");
        System.out.println(pop());//2
        System.out.println(pop());//3
        System.out.println(pop());//4
    }
}
