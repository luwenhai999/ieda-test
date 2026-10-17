package com.lugang.anytest.aOneDirectStack;

import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * 滑动窗口算法
 * 1. 队列存放数据,存放的是下表
 * 2. 队列中的数据一定要是i和i-k-1这个闭区间的
 * 3. 在这个区间内,如果存入的数据比较小,则直接存入,这个小数据可能是后面的大数据
 * 4. 如果存入的数据比较大,则前面的数据没有存在的必要,因为最大值肯定先它
 *
 * @author wenhai.lu
 * Create at 2025-05-28 22:19
 */
public class LegalQueueWindowDemo {
    public static void main(String[] args) {
        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] resultArr = new int[arr.length - 2];
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < arr.length; i++) {
            // i=2时,2-3+1=0
            // 保障滑动的范围,是在k之内
            while (!queue.isEmpty() && queue.peek() < i - k + 1) {
                queue.poll();
            }
            // 保证了队列内事头大尾小,如果出现一个元素超过对胃的元素,则将对尾的元素poll出来,知道队列中没有比它小的元素
            while (!queue.isEmpty() && arr[i] > arr[queue.peekLast()]) {
                queue.pollLast();
            }
            // 将这个元素推入
            queue.offer(i);
            // 当i到达k-1时,博士已经有k个元素了,此时可以记录一个完整的k长度
            if (i >= k - 1) {
                resultArr[i - k + 1] = arr[queue.peek()];
            }
        }
        System.out.println(Arrays.toString(resultArr));
    }
}
