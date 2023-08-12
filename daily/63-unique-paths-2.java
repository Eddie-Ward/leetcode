package daily;

/*
 * 2D DP Solution
 */

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int numRows = obstacleGrid.length;
        int numCols = obstacleGrid[0].length;
        int[][] dp = new int[numRows + 1][numCols + 1];

        dp[0][1] = 1; // Seed so that when dp[1][1] (the start) is processed, it will be 1

        for (int row = 1; row <= numRows; ++row) {
            for (int col = 1; col <= numCols; ++col) {
                if (obstacleGrid[row][col] == 1) {
                    dp[row][col] = 0;
                } else {
                    dp[row][col] = dp[row - 1][col] + dp[row][col - 1];
                }
            }
        }
        return dp[numRows][numCols];
    }
}