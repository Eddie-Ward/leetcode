package daily;

import java.util.PriorityQueue;

class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length, m = heights[0].length;
        int[][] dist = new int[n][m];

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }

        dist[0][0] = 0;

        PriorityQueue<int[]> cost = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        cost.add(new int[] { 0, 0, 0 });

        int[][] directions = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

        while (!cost.isEmpty()) {
            int[] top = cost.poll();

            int curCost = top[0], x = top[1], y = top[2];

            if (curCost > dist[x][y]) {
                continue;
            }

            if (x == n - 1 && y == m - 1) {
                return curCost;
            }

            for (int[] curDir : directions) {
                int newX = x + curDir[0], newY = y + curDir[1];
                if (newX >= 0 && newX < n && newY >= 0 && newY < m) {
                    int newCost = Math.max(curCost, Math.abs(heights[newX][newY] - heights[x][y]));
                    if (newCost < dist[newX][newY]) {
                        dist[newX][newY] = newCost;
                        cost.add(new int[] { newCost, newX, newY });
                    }
                }
            }
        }

        return -1;

    }
}