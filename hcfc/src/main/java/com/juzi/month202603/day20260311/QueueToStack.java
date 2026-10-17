package com.juzi.month202603.day20260311;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 用队列实现栈,先进后出
 *
 * @author wenhai.lu
 * Create at 2026-03-11 下午 3:26
 */
public class QueueToStack {
    public static void main(String[] args) {
        myStatckTwoQueue queue = new myStatckTwoQueue();
        queue.pushOrOffer(1);
        queue.pushOrOffer(2);
        queue.pushOrOffer(3);
        while (!queue.isEmpty()) {
            System.out.println(queue.popOrPoll());
        }
    }
}

class myStatckTwoQueue {
    private Queue<Integer> queue = new ArrayDeque<>();

    public void pushOrOffer(Integer a) {
        Queue<Integer> temp = new ArrayDeque<>();
        temp.offer(a);
        while (!queue.isEmpty()) {
            temp.offer(queue.poll());
        }
        queue = temp;
    }

    public Integer popOrPoll() {
        return queue.poll();
    }

    public Boolean isEmpty() {
        return queue.isEmpty();
    }
}

class MyStackSingleQueue {
    private Queue<Integer> queueIn = new ArrayDeque<>();

    public void pushOrOffer(Integer a) {
        queueIn.offer(a);
        int size = queueIn.size();
        while (size > 1) {
            queueIn.offer(queueIn.poll());
            size--;
        }
    }

    public Integer popOrPoll() {
        return queueIn.poll();
    }

    public Boolean isEmpty() {
        return queueIn.isEmpty();
    }
}