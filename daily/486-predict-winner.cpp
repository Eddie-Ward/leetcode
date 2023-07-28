#include <string>
#include <unordered_map>
#include <vector>

using namespace std;

/*
    2D DP Solution

    Suppose the game is at a state in which the window is from i to j.
    If the player chooses nums[i], the next round is from i + 1 to j and vice versa.
    The player should choose the max between nums[i] - game(i + 1, j) and nums[j] - game(i, j - 1),
    where a game() function represents the total score of the current-turn player.
    Using a 2D array, this is the equivalent of dp[i][j] = max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1])
    The base case is when nums is size 1, in which case, the player simply chooses the only value left.
    In the 2D array, the initial values are seeded along the main diagonal at dp[i][i] from 0 to nums.size()
    To check if player one wins, check if the top-right most value is positive.
*/

class Solution {
   public:
    bool PredictTheWinner(vector<int>& nums) {
        int n = nums.size();
        int dp[n][n];
        for (int i = 0; i < n; ++i) {
            dp[i][i] = nums[i];
        }
        for (int len = 1; len < n; ++len) {
            for (int row = 0; row < n - len; ++row) {
                int col = row + len;
                dp[row][col] = max(nums[row] - dp[row + 1][col], nums[col] - dp[row][col - 1]);
            }
        }
        return dp[0][n - 1] >= 0;
    }
};

/*
    Top-down memoization
    Not as efficient as bottom-up approach
*/
class Solution2 {
   public:
    bool PredictTheWinner(vector<int>& nums) {
        return maxScore(nums, 0, nums.size() - 1) >= 0;
    }
    int maxScore(const vector<int>& nums, int left, int right) {
        string stateHash = to_string(left) + "##" + to_string(right);
        if (memo.count(stateHash) == 0) {
            if (left == right) {
                memo[stateHash] = nums[left];
            } else {
                memo[stateHash] = max(nums[left] - maxScore(nums, left + 1, right), nums[right] - maxScore(nums, left, right - 1));
            }
        }
        return memo[stateHash];
    }

   private:
    unordered_map<string, int> memo;
};