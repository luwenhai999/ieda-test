package com.lugang.demo;

import java.util.*;

/**
 * 所有可达路径
 *
 * @author wenhai.lu
 * Create at 2025-06-01 23:16
 */
public class LegalEveryPathToTarget {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int sideNum = scanner.nextInt();
        // 存放原始数据的数组
        int[][] arr = new int[sideNum][2];
        for (int i = 0; i < sideNum; i++) {
            int first = scanner.nextInt();
            int second = scanner.nextInt();
            arr[i][0] = first;
            arr[i][1] = second;
        }

        // 转换陈邻接表结构
        List<LinkedList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new LinkedList<>());
        }
        for (int[] thisArr : arr) {
            int start = thisArr[0];
            int end = thisArr[1];
            graph.get(start).offer(end);
        }

        List<List<Integer>> resultList = new ArrayList<>();
        Stack<Integer> path = new Stack<>();
        boolean[] visited = new boolean[n + 1];
        visited[1] = true;
        path.push(1);
        dfs(graph, resultList, path, visited, 1, 5);
        System.out.println(resultList);
    }

    private static void dfs(List<LinkedList<Integer>> graph, List<List<Integer>> resultList, Stack<Integer> path, boolean[] visited, int current, int target) {
        if (current == target) {
            resultList.add(new ArrayList<>(path));
            return;
        }
        LinkedList<Integer> integers = graph.get(current);
        if (integers == null || integers.isEmpty()) {
            return;
        }
        for (Integer thisNode : integers) {
            if (visited[thisNode]) {
                continue;
            }
            visited[thisNode] = true;
            path.push(thisNode);
            dfs(graph, resultList, path, visited, thisNode, target);
            path.pop();
            visited[thisNode] = false;
        }

    }
}
