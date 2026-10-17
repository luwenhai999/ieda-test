package com.juzi.month202603.day20260320;

import java.util.LinkedList;

/**
 * @author wenhai.lu
 * Create at 2026-03-20 下午 7:52
 */
public class HashDemo {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
    }

    private static void ab(Integer a) {
        Object b = null;
        System.out.println(a == b);
    }

    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= Integer.MAX_VALUE) ? Integer.MAX_VALUE : n + 1;
    }
}
