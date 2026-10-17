package com.lugang.anytest.bstack;

import java.util.*;

/**
 * 出现频率最高的前k各数据
 *
 * @author wenhai.lu
 * Create at 2025-05-02 16:42
 */
public class LegalTopKRateDemo {
    public static void main(String[] args) {
        int[] arr = {2, 2, 2, 1, 1, 4, 5, 5, 5, 5, 5, 3, 2, 7, 1};
        int k = 2;
        PriorityQueue<Map.Entry<Integer, Integer>> priorityQueue = new PriorityQueue<>((a, b) -> {
            return a.getValue() - b.getValue();
        });
        Map<Integer, Integer> map = new HashMap<>();

        for (int thisNum : arr) {
            Integer integer = map.get(thisNum);
            if (integer == null) {
                integer = 0;
            }
            integer++;
            map.put(thisNum, integer);
        }
        int num = 0;
        for (Map.Entry<Integer, Integer> thisEntry : map.entrySet()) {
            num++;
            if (num <= k) {
                priorityQueue.offer(thisEntry);
                continue;
            }
            priorityQueue.offer(thisEntry);
            Map.Entry<Integer, Integer> currMin = priorityQueue.poll();
        }
        List<Integer> resultList = new ArrayList<>();
        while (!priorityQueue.isEmpty()) {
            Map.Entry<Integer, Integer> poll = priorityQueue.poll();
            resultList.add(poll.getKey());
        }
        System.out.println(resultList);
    }
}
