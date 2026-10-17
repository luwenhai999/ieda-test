package com.juzi.month202603.day20260325;

import java.util.ArrayDeque;

/**
 * 滑动窗口去最大值
 *
 * @author wenhai.lu
 * Create at 2026-03-25 下午 10:28
 */
public class SlipDemo {
    public static void main(String[] args) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.push(1);
        deque.push(2);
        deque.push(3);
        deque.offer(4);
        Integer peek = deque.peek();
        System.out.println(peek);//3
        Integer peekLast = deque.peekLast();
        System.out.println(peekLast);//1

    }
}
