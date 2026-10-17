package com.juzi.month202605.day20260504;

import java.util.*;

/**
 * 获取top k个高频元素（使用小顶堆优化）
 *
 * @author wenhai.lu
 * Create at 2026-05-04 下午 2:34
 */
public class DemoTopKNum {
    public static void main(String[] args) {
        int[] a = {1, 1, 1, 2, 2, 3, 5, 5, 5, 5, 5, 5, 2, 2};
        int target = 2;
        
        // 1. 统计每个数出现的频率
        Map<Integer, Integer> numToCountMap = new HashMap<>();
        for (int num : a) {
            numToCountMap.put(num, numToCountMap.getOrDefault(num, 0) + 1);
        }

        // 2. 使用小顶堆，堆中元素按频率排序
        // 注意：JDK 的 PriorityQueue 默认是小顶堆
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = 
            new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));

        // 3. 遍历所有元素，维护大小为 target 的小顶堆
        for (Map.Entry<Integer, Integer> entry : numToCountMap.entrySet()) {
            if (minHeap.size() < target) {
                minHeap.offer(entry);
            } else if (entry.getValue() > minHeap.peek().getValue()) {
                // 当前元素频率大于堆顶频率，替换堆顶
                minHeap.poll();
                minHeap.offer(entry);
            }
        }

        // 4. 堆中元素即为频率最高的 target 个（顺序已按频率排列）
        int[] result = new int[target];
        for (int i = target - 1; i >= 0; i--) {
            result[i] = Objects.requireNonNull(minHeap.poll()).getKey();
        }
        System.out.println(Arrays.toString(result));
    }
}
