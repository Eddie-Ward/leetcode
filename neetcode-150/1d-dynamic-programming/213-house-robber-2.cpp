#include <vector>

using std::vector, std::max;

/*
    1D Bottom-Up Approach
    Similar to House Robber I,
    For every house at index i, the two valid choices are
        Choosing to rob the house at index i and skipping the prev (nums[i] + dp[i - 2])
        Choosing not to rob the house and robbing the prev (dp[i - 1])
    The added twist is that the houses are in a circle.
    Use 2 1D arrays where one is from nums[0 : n - 2] and the other is from nums[1 : n - 1] inclusive
        Effectively, solve the problem not including the last house and solve it again not including the first house
        Take the maximum of the two solutions
*/

class Solution {
   public:
    int rob(vector<int>& nums) {
        int n = nums.size();

        if (n == 1) {
            return nums[0];
        }

        if (n == 2) {
            return max(nums[0], nums[1]);
        }

        int dpOne[n - 1], dpTwo[n - 1];

        dpOne[0] = nums[0], dpOne[1] = max(nums[0], nums[1]);
        dpTwo[0] = nums[1], dpTwo[1] = max(nums[1], nums[2]);

        for (int i = 2; i < n - 1; ++i) {
            dpOne[i] = max(dpOne[i - 1], nums[i] + dpOne[i - 2]);
            dpTwo[i] = max(dpTwo[i - 1], nums[i + 1] + dpTwo[i - 2]);
        }

        return max(dpOne[n - 2], dpTwo[n - 2]);
    }
};