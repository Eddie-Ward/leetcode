package daily;

import java.util.Arrays;

/**
 * Top-down DP
 */
class Solution {

    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        Arrays.fill(dp, -1);
        return combinationSumHelper(nums, target, dp);
    }

    private int combinationSumHelper(int[] nums, int target, int[] dp) {

        if (target <= 0) {
            return 0;
        }

        if (dp[target] == -1) {

            int numWays = 0;

            for (int num : nums) {
                numWays += combinationSumHelper(nums, target - num, dp);
            }

            dp[target] = numWays;
        }

        return dp[target];
    }
}

/**
 * Bottom-Up DP
 */
class Solution2 {

    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        Arrays.fill(dp, -1);
        dp[0] = 1;

        for (int sum = 1; sum <= target; ++sum) {
            int numWays = 0;
            for (int num : nums) {
                if (sum - num > 0) {
                    numWays += dp[sum - num];
                }
            }
            dp[sum] = numWays;
        }

        return dp[target];
    }
}
