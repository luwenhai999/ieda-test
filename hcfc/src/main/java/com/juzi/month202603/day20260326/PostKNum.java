package com.juzi.month202603.day20260326;

import java.util.*;

/**
 * 前k个高频元素
 *
 * @author wenhai.lu
 * Create at 2026-03-26 下午 10:45
 */
public class PostKNum {
    public static void main(String[] args) {
        int[] a = {1, 1, 1, 2, 2, 3, 5, 5, 5, 5, 5, 5, 5};
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : a) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        // 最大堆队列,会对入队的数据按需排序
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((first, second) -> second.getValue() - first.getValue());
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries) {
            queue.add(entry);
        }
        int k = 2;
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = queue.poll().getKey();
        }
        System.out.println(Arrays.toString(result));
        System.out.println(queue);
    }
}
