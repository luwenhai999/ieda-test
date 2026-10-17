package com.lugang.demo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @author wenhai.lu
 * Create at 2025-06-01 22:46
 */
public class LegalDGraphDemo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int sideNum = scanner.nextInt();
        List<int[]> sideList = new ArrayList<>();
        for (int i = 0; i < sideNum; i++) {
            int first = scanner.nextInt();
            int second = scanner.nextInt();
            sideList.add(new int[]{first, second});
        }
        List<LinkedList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new LinkedList<>());
        }
        for (int i = 0; i < sideList.size(); i++) {
            int[] side = sideList.get(i);
            int start = side[0];
            int end = side[1];
            graph.get(start).offer(end);
        }

        boolean[] visited = new boolean[n + 1];
        visited[1] = true;
        bfs(graph, 1, visited);
        for (int i = 1; i < visited.length; i++) {
            if (!visited[i]) {
                System.out.println(-1);
                return;
            }
        }
        System.out.println(1);
    }

    private static void bfs(List<LinkedList<Integer>> graph, int start, boolean[] visited) {
        LinkedList<Integer> integers = graph.get(start);
        if (integers == null || integers.size() == 0) {
            return;
        }
        for (Integer thisStart : integers) {
            if (visited[thisStart]) {
                continue;
            }
            visited[thisStart] = true;
            bfs(graph, thisStart, visited);
        }
    }
}
