package com.lugang.anytest.aGraph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 水流方向
 * 1. 逆向工程
 *
 * @author wenhai.lu
 * Create at 2025-05-25 19:00
 */
public class LegalGraphFlowDirectConvert {
    private static int[][] directArr = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int row = scanner.nextInt();
        int col = scanner.nextInt();
        int[][] graph = new int[row][col];
        int[][] visitedFirst = new int[row][col];
        int[][] visitedSecond = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                graph[i][j] = scanner.nextInt();
            }
        }

        // 上边a[0][0]-a[0][col]
        for (int j = 0; j < col; j++) {
            dfs(graph, visitedFirst, 0, j, Integer.MIN_VALUE);
        }
        // 左边a[0][0]-a[row][0]
        for (int i = 0; i < row; i++) {
            dfs(graph, visitedFirst, i, 0, Integer.MIN_VALUE);
        }
        // 右边a[0][col]-a[row][col]
        for (int i = 0; i < row; i++) {
            dfs(graph, visitedSecond, i, col - 1, Integer.MIN_VALUE);
        }
        // 下边a[row][0]-a[row][col]
        for (int j = 0; j < col; j++) {
            dfs(graph, visitedSecond, row - 1, j, Integer.MIN_VALUE);
        }
        List<int[]> result = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (visitedFirst[i][j] == 1 && visitedSecond[i][j] == 1) {
                    result.add(new int[]{i, j});
                }
            }
        }

        for (int[] re : result) {
            System.out.println(Arrays.toString(re));
        }
    }

    /**
     * 深搜,每个节点都是相同的
     * 1. 终止条件,边界,访问标识,大小
     * 2. 单层运算,标记
     * 3. 四个方向处理,超过的才会放
     *
     * @param graph
     * @param x
     * @param y
     */
    private static void dfs(int[][] graph, int[][] visited, int x, int y, int lastValue) {
        if (x < 0 || x >= graph.length
                || y < 0 || y >= graph[0].length
                || visited[x][y] == 1
                || graph[x][y] < lastValue) {
            return;
        }
        visited[x][y] = 1;
        int currentValue = graph[x][y];
        for (int[] thisDirect : directArr) {
            dfs(graph, visited, x + thisDirect[0], y + thisDirect[1], currentValue);
        }
    }
}
