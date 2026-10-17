package com.lugang.anytest.aGraph;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

/**
 * 沉没孤岛
 *
 * @author wenhai.lu
 * Create at 2025-05-24 23:26
 */
public class LegalGraphSinkLoanIsland {
    private static int[][] directArr = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int row = scanner.nextInt();
        int col = scanner.nextInt();
        int[][] graph = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                graph[i][j] = scanner.nextInt();
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (graph[i][j] == 1) {
                    boolean bfs = bfs(graph, i, j);
                    if (bfs) {
                        dfs(graph, i, j);
                    }
                }
            }
        }
        for (int[] arr : graph) {
            System.out.println(Arrays.toString(arr));
        }
    }

    /**
     * 深搜,不需要注意首节点
     * 1. 终止条件
     * 2. 符合的节点,调整
     * 3. 各个方向,直接调用递归方法即可
     *
     * @param graph
     * @param x
     * @param y
     */
    private static void dfs(int[][] graph, int x, int y) {
        if (!(x >= 0 && x < graph.length
                && y >= 0 && y < graph[0].length
                && graph[x][y] == 1)) {
            return;
        }
        graph[x][y] = 0;
        for (int[] thisDirect : directArr) {
            dfs(graph, x + thisDirect[0], y + thisDirect[1]);
        }
    }

    /**
     * 光搜,需要注意首个节点
     * 1. 首节点判断是否是边界,如果是边界直接返回false
     * 2. 首节点访问表示,首节点放入对垒
     * 3. 遍历队列
     * 4. 取出节点,四个方向,判断节点坐标是否合规切实陆地,如果是,判断是否边界,如果是边界直接返回false
     * 5. 是陆地的节点,访问表示,放入队列
     *
     * @param graph
     * @param x
     * @param y
     * @return 孤岛的话返回true
     */
    private static boolean bfs(int[][] graph, int x, int y) {
        boolean flag = true;
        int[][] visited = new int[graph.length][graph[0].length];
        Queue<int[]> queue = new ArrayDeque<>();
        if (x == 0 || x == graph.length - 1
                || y == 0 || y == graph[0].length - 1) {
            return false;
        }
        queue.offer(new int[]{x, y});
        visited[x][y] = 1;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int currentX = poll[0];
            int currentY = poll[1];
            for (int[] thisDirect : directArr) {
                int nextX = currentX + thisDirect[0];
                int nextY = currentY + thisDirect[1];
                if (nextX >= 0 && nextX < graph.length
                        && nextY >= 0 && nextY < graph[0].length
                        && graph[nextX][nextY] == 1
                        && visited[nextX][nextY] == 0) {
                    // 如果这块还属于陆地,则判断该节点是否靠边,如果靠边,则返回false
                    // 节点继续放入队列,并且标识,确保不会重复入队列
                    if (nextX == 0 || nextX == graph.length - 1
                            || nextY == 0 || nextY == graph[0].length - 1) {
                        return false;
                    }
                    queue.offer(new int[]{nextX, nextY});
                    visited[nextX][nextY] = 1;
                }
            }
        }
        return true;
    }
}
