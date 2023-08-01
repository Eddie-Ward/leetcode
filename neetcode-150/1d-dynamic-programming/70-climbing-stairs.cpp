/*
    1D Bottom-Up Approach
    For every nth stair, the ways to reach it are dp[n - 1] + dp[n - 2]
    Seeding initial values:
        1 way to climb 1 stair (+1)
        2 ways to climb 2 stairs (+1 +1, +2)
    Target: dp[n]
*/

class Solution {
   public:
    int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int dp[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; ++i) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
};