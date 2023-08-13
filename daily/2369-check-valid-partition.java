package daily;

import java.util.Arrays;

class Solution {
    public boolean validPartition(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);

        return solve(nums, 0, dp);

    }

    private boolean solve(int[] nums, int index, int[] dp) {
        if (index == nums.length) {
            return true;
        }

        if (dp[index] != -1) {
            return dp[index] == 1 ? true : false;
        }

        if (index + 1 < nums.length && nums[index] == nums[index + 1]) {
            if (solve(nums, index + 2, dp)) {
                return true;
            }
            if (nums[index] == nums[index + 2]) {
                if (solve(nums, index + 3, dp)) {
                    return true;
                }
            }
        }

        if (index + 2 < nums.length && nums[index] == nums[index + 1] - 1 && nums[index + 1] == nums[index + 2] - 1) {
            if (solve(nums, index + 3, dp)) {
                return true;
            }
        }

        dp[index] = 0;
        return false;
    }
}