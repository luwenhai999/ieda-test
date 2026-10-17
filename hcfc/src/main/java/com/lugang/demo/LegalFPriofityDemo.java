package com.lugang.demo;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 优先级队列
 *
 * @author wenhai.lu
 * Create at 2025-06-02 11:51
 */
public class LegalFPriofityDemo {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String firstLine = in.nextLine();
        String[] str1Arr = firstLine.split(" ");
        int n = Integer.parseInt(str1Arr[0]);
        int[] arr1 = new int[n];
        for (int i = 1; i < str1Arr.length; i++) {
            arr1[i - 1] = Integer.parseInt(str1Arr[i]);
        }

        String secondLine = in.nextLine();
        String[] str2Arr = secondLine.split(" ");
        int m = Integer.parseInt(str2Arr[0]);
        int[] arr2 = new int[m];
        for (int i = 1; i < str2Arr.length; i++) {
            arr2[i - 1] = Integer.parseInt(str2Arr[i]);
        }

        int k = in.nextInt();

        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> (arr1[a[0]] + arr2[a[1]]) - (arr1[b[0]] + arr2[b[1]]));

        // 将数组1的数据全部放入
        for (int i = 0; i < arr1.length; i++) {
            priorityQueue.offer(new int[]{i, 0});
        }

        int min = 0;
        while (k > 0 && !priorityQueue.isEmpty()) {
            int[] poll = priorityQueue.poll();
            int arr1Index = poll[0];
            int arr2Index = poll[1];
            min += (arr1[arr1Index] + arr2[arr2Index]);
            if (arr2Index + 1 < m) {
                priorityQueue.add(new int[]{arr1Index, arr2Index + 1});
            }
            k--;
        }
        System.out.println(min);
    }
}
