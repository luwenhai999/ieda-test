package com.juzi.month202603.day20260326;

import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * @author wenhai.lu
 * Create at 2026-03-26 下午 9:43
 */
public class SlipWindowLinkedListDemo {
    public static void main(String[] args) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        int[] a = {1, 3, -1, -3, 5, 3, 2, 1};
        int k = 3;
        int[] temp = new int[a.length - k + 1];
        int index = 0;
        for (int i = 0; i < k - 1; i++) {
            while (!deque.isEmpty() && a[deque.peekLast()] < a[i]) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }
        for (int i = k - 1; i < a.length; i++) {
            // offer,如果左边有比他小的,则[尾出],最后再[尾入]该元素
            while (!deque.isEmpty() && a[deque.peekLast()] < a[i]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            // pop,此时最有测的元素是最大的,如果该最大元素的位置[首窥]已经超出k之外,则[首出]
            if (!deque.isEmpty() && i - deque.peekFirst() >= k) {
                deque.pollFirst();
            }
            // 获取值[首窥]
            temp[index++] = a[deque.peekFirst()];
        }
        System.out.println(Arrays.toString(temp));
    }
}
