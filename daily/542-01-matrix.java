package daily;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * BFS Solution
 * 
 * Insert all (row, col) coords that are equal to 0 into a queue
 * Label all other coords as -1 to denote as unexplored
 * Using BFS, process all coords until matrix is fully explored
 * BFS guarantees that distances will be from closest to farthest
 */

class Solution {

    private int[] DIR = { 0, 1, 0, -1, 0 };

    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] ans = mat.clone();

        Queue<int[]> queue = new ArrayDeque<>();

        for (int row = 0; row < n; ++row) {
            for (int col = 0; col < m; ++col) {
                if (ans[row][col] == 0) {
                    queue.add(new int[] { row, col });
                } else {
                    ans[row][col] = -1;
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] coords = queue.poll();
            int row = coords[0], col = coords[1];

            for (int i = 0; i < 4; ++i) {
                int nextRow = row + DIR[i], nextCol = col + DIR[i + 1];
                if (nextRow < 0 || nextRow == n || nextCol < 0 || nextCol == m || ans[nextRow][nextCol] != -1) {
                    continue; // Checking bounds and also if coord has been explored
                }
                ans[nextRow][nextCol] = ans[row][col] + 1;
                queue.add(new int[] { nextRow, nextCol });
            }
        }

        return ans;

    }
}