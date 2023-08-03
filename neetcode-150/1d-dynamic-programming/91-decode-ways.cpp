#include <string>
#include <unordered_map>
#include <vector>

using std::string, std::vector, std::unordered_map;

/*
    Bottom-Up DP Solution
    Start from the back
    If the current digit is 0, then dp[i] = 0 as there are no ways to decode
    If the current digit is not 0, then dp[i] = dp[i + 1] as it can be added as a single digit
    If the current digit is 1 or 2, then the character can also attach to the previous (next in order) digit,
    so dp [i] += dp[i + 2] as well
*/

class Solution {
   public:
    int numDecodings(string s) {
        int n = s.size();
        vector<int> dp(n + 1, 0);
        dp[n] = 1;
        for (int i = n - 1; i >= 0; --i) {
            if (s.at(i) != '0') {
                dp[i] += dp[i + 1];
            }
            if (i + 1 < n && (s.at(i) == '1' || s.at(i) == '2' && s.at(i + 1) <= '6')) {
                dp[i] += dp[i + 2];
            }
        }
        return dp[0];
    }
};

/*
    Top-down DP Solution
*/

class Solution2 {
   public:
    int numDecodings(string s) {
        unordered_map<int, int> memo;
        memo[s.size()] = 1;
    }

    int backtrack(const string& s, int index, unordered_map<int, int>& memo) {
        if (index == s.size()) {
            return 0;
        }
        if (memo.count(index) == 0) {
            if (s.at(index) != '0') {
                memo[index] += backtrack(s, index + 1, memo);
            }
            if (index + 1 < s.size() && (s.at(index) == '1' || (s.at(index) == '2' && s.at(index + 1) <= 6))) {
                memo[index] += backtrack(s, index + 2, memo);
            }
        }
        return memo[index];
    }
};
