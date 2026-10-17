package com.lugang.anytest.aGraph;

import java.util.*;

/**
 * 水流方向
 * 1. 遍历所有节点,如果有第一解除和第二接触,则返回true
 * 2.
 *
 * @author wenhai.lu
 * Create at 2025-05-25 17:41
 */
public class LegalGraphFlowDirect {
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
        List<int[]> resultList = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (bfs(graph, i, j)) {
                    resultList.add(new int[]{i, j});
                }
            }
        }
        for (int[] result : resultList) {
            System.out.println(Arrays.toString(result));
        }

    }

    /**
     * 广搜
     * 1. 首节点处理,入队列,标记,判断
     * 2. 遍历队列
     * 3. 当前节点的四方向各个节点,边长限制,访问限制,大小限制
     * 4. 符合条件的,入队列,标记,判断
     *
     * @param graph
     * @param x
     * @param y
     * @return
     */
    private static boolean bfs(int[][] graph, int x, int y) {
        Queue<int[]> queue = new ArrayDeque<>();
        boolean first = false;
        boolean second = false;
        int[][] visited = new int[graph.length][graph[0].length];
        queue.offer(new int[]{x, y});
        visited[x][y] = 1;
        if (x == 0 || y == 0) {
            first = true;
        }
        if (x == graph.length - 1
                || y == graph[0].length - 1) {
            second = true;
        }
        if (first && second) {
            return true;
        }
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int currentX = poll[0];
            int currentY = poll[1];
            int currentValue = graph[currentX][currentY];
            // 该节点的四个方向
            for (int[] thisDirect : directArr) {
                int nextX = currentX + thisDirect[0];
                int nextY = currentY + thisDirect[1];
                if (nextX < 0 || nextX >= graph.length
                        || nextY < 0 || nextY >= graph[0].length
                        || visited[nextX][nextY] == 1
                        || graph[nextX][nextY] > currentValue) {
                    continue;
                }
                queue.offer(new int[]{nextX, nextY});
                visited[nextX][nextY] = 1;
                if (nextX == 0 || nextY == 0) {
                    first = true;
                }
                if (nextX == graph.length - 1
                        || nextY == graph[0].length - 1) {
                    second = true;
                }
                if (first && second) {
                    return true;
                }
            }

        }

        return false;
    }
}
