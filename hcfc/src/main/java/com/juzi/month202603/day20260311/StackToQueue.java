package com.juzi.month202603.day20260311;

import java.util.Stack;

/**
 * 用栈实现队列
 *
 * @author wenhai.lu
 * Create at 2026-03-11 下午 1:52
 */
public class StackToQueue {
    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        while (!queue.isEmpty()) {
            System.out.println(queue.popOrPoll());
        }
    }
}

class MyQueue {
    private Stack<Integer> stackIn = new Stack<>();
    private Stack<Integer> stackOut = new Stack<>();

    public void push(Integer a) {
        stackIn.push(a);
    }

    public Integer popOrPoll() {
        transfer();
        return stackOut.pop();
    }

    public Integer peek() {
        transfer();
        return stackOut.peek();
    }

    public boolean isEmpty() {
        return stackOut.isEmpty() && stackIn.isEmpty();
    }

    private void transfer() {
        if (!stackOut.isEmpty()) {
            return;
        }
        while (!stackIn.isEmpty()) {
            // 此举相当于是对顺序进行了倒序
            stackOut.push(stackIn.pop());
        }
    }

}
