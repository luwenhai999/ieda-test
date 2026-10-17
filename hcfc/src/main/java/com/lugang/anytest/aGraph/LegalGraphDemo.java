package com.lugang.anytest.aGraph;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author wenhai.lu
 * Create at 2025-05-23 22:56
 */
public class LegalGraphDemo {
    private static int[][] way = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

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

        int num = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (graph[i][j] == 1) {
                    num++;
                    bfs(graph, i, j);
                }
            }
        }
        System.out.println(num);

    }

    private static void bfs(int[][] graph, int x, int y) {
        //首节点放入,然后值1
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{x, y});
        graph[x][y] = 0;
        // 遍历队列
        while (!queue.isEmpty()) {
            // 下表不越界,且是陆地的都放入,然后值1
            int[] poll = queue.poll();
            int currentX = poll[0];
            int currentY = poll[1];
            for (int[] thisIndexAr : way) {
                int nextX = currentX + thisIndexAr[0];
                int nextY = currentY + thisIndexAr[1];
                if (nextX >= 0 && nextX < graph.length &&
                        nextY >= 0 && nextY < graph[0].length
                        && graph[nextX][nextY] == 1) {
                    queue.offer(new int[]{nextX, nextY});
                    graph[nextX][nextY] = 0;
                }
            }
        }

    }
}
