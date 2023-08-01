#include <vector>

using std::vector, std::max;

/*
    1D Bottom-Up Approach
    For every house at index i, the two valid choices are
        Choosing to rob the house at index i and skipping the prev (nums[i] + dp[i - 2])
        Choosing not to rob the house and robbing the prev (dp[i - 1])
    Target: dp[n - 1]
*/

class Solution {
   public:
    int rob(vector<int>& nums) {
        int n = nums.size();

        if (n == 1) {
            return nums[0];
        }

        int dp[n];

        // Seeding the two initial values
        dp[0] = nums[0], dp[1] = max(nums[0], nums[1]);

        for (int i = 2; i < nums.size(); ++i) {
            dp[i] = max(dp[i - 1], nums[i] + dp[i - 2]);
        }

        return dp[n - 1];
    }
};