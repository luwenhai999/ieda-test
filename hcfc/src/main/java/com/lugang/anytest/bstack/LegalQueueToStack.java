package com.lugang.anytest.bstack;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 使用队列模拟栈
 *
 * @author wenhai.lu
 * Create at 2025-04-30 21:31
 */
public class LegalQueueToStack {
    private static Queue<String> queue = new ArrayDeque<>();

    private static void push(String str) {
        queue.offer(str);
    }

    private static String pop() {
        int size = queue.size();
        for (int i = 0; i < size - 1; i++) {
            queue.offer(queue.poll());
        }
        return queue.poll();
    }

    public static void main(String[] args) {
        push("1");
        push("2");
        push("3");
        System.out.println(pop());
        push("4");
        System.out.println(pop());
        push("5");
        System.out.println(pop());
    }
}
