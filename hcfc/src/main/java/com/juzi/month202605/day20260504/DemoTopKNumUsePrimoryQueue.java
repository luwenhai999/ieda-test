package com.juzi.month202605.day20260504;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author wenhai.lu
 * Create at 2026-05-04 下午 3:11
 */
public class DemoTopKNumUsePrimoryQueue {
    public static void main(String[] args) {
        int[] a = {1, 1, 1, 2, 2, 3, 5, 5, 5, 5, 5, 5, 2, 2};
        int target = 2;
        Map<Integer, Integer> numToCountMap = new HashMap<>();
        for (int i : a) {
            numToCountMap.put(i, numToCountMap.getOrDefault(i, 0) + 1);
        }
        // 使用小顶堆，维护大小为K的堆，堆顶是频率最小的元素
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((first, second) -> first[1] - second[1]);
        Set<Map.Entry<Integer, Integer>> entries = numToCountMap.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries) {
            priorityQueue.add(new int[]{entry.getKey(), entry.getValue()});
            // 当堆大小超过K时，弹出堆顶（频率最小的元素）
            if (priorityQueue.size() > target) {
                priorityQueue.poll();
            }
        }
        // 输出结果（按频率从低到高）
        while (!priorityQueue.isEmpty()) {
            int i = priorityQueue.poll()[0];
            System.out.println(i);
        }
    }
}
