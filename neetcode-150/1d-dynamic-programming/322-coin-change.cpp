#include <limits.h>

#include <vector>

using std::vector, std::size_t, std::min;

class Solution {
   public:
    int coinChange(vector<int>& coins, int amount) {
        vector<int> dp(amount + 1, INT_MAX);

        dp[0] = 0;

        for (int i = 1; i <= amount; ++i) {
            int ways = INT_MAX;
            for (const int& coin : coins) {
                if (i - coin >= 0) {
                    int prev = dp[i - coin];
                    if (prev < INT_MAX) {
                        ways = min(ways, 1 + dp[i - coin]);
                    }
                }
            }
            dp[i] = ways;
        }

        return dp[amount] < INT_MAX ? dp[amount] : -1;
    }
};