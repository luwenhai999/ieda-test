package com.lugang.anytest.aGraph;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

/**
 * 图论,孤岛总面积
 *
 * @author wenhai.lu
 * Create at 2025-05-24 22:31
 */
public class LegalLoanIslandTotalArea {
    private static int[][] directArr = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    private static boolean loan = true;

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
        for (int j = 0; j < col; j++) {
            if (graph[0][j] == 1) {
                dfs(graph, 0, j);
            }
            if (graph[row - 1][j] == 1) {
                dfs(graph, row - 1, j);
            }
        }
        for (int i = 0; i < row; i++) {
            if (graph[i][0] == 1) {
                dfs(graph, i, 0);
            }
            if (graph[i][col - 1] == 1) {
                dfs(graph, i, col - 1);
            }
        }

        int total = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (graph[i][j] == 1) {
                    total += bfs(graph, i, j);
                }
            }
        }
        System.out.println(total);
    }

    /**
     * 光搜
     * 1. 需要注意首节点,放入后需要表示,并且面积加一
     * 2. 遍历节点
     * 3. 节点拿出一个坐标,遍历四方向,需要符合x边界y边界是陆地,然后放入节点,标识,面积加一
     *
     * @param graph
     * @param x
     * @param y
     * @return
     */
    private static int bfs(int[][] graph, int x, int y) {
        Queue<int[]> queue = new ArrayDeque<>();
        int area = 1;
        graph[x][y] = 0;
        queue.offer(new int[]{x, y});
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int currentX = poll[0];
            int currentY = poll[1];
            for (int[] thisDirectAr : directArr) {
                int nextX = currentX + thisDirectAr[0];
                int nextY = currentY + thisDirectAr[1];
                if (nextX >= 0 && nextX < graph.length
                        && nextY >= 0 && nextY < graph[0].length
                        && graph[nextX][nextY] == 1) {
                    area += 1;
                    graph[nextX][nextY] = 0;
                    queue.offer(new int[]{nextX, nextY});
                }
            }
        }
        return area;
    }

    /**
     * 深搜
     * 1. 每个节点进来都是一样的,因为这个事递归的方法
     * 2. 判断终止条件,终止的肯定不是面积上的一点
     * 3. 接下来就是面积上的一点了,需要是否是边上的,如果是的话loan表示改为false
     * 4. 该节点表示调整,面积设置为1
     * 5. 遍历四个方向即可,并将返回值累加到area中
     *
     * @param graph
     * @param x
     * @param y
     * @return
     */
    private static int dfs(int[][] graph, int x, int y) {
        // 终止条件
        if (x < 0 || x >= graph.length
                || y < 0 || y >= graph[0].length
                || graph[x][y] == 0) {
            return 0;
        }
        // 边的判断
        if (x == 0 || x == graph.length - 1
                || y == 0 || y == graph[0].length - 1) {
            loan = false;
        }
        // 表示,并且累加
        graph[x][y] = 0;
        int area = 1;
        // 遍历四个方向
        for (int[] thisDirectAr : directArr) {
            area += dfs(graph, x + thisDirectAr[0], y + thisDirectAr[1]);
        }
        return area;
    }
}
