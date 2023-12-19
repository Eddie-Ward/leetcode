#include <string>
#include <vector>

using std::string, std::vector;

/*
    1D Bottom-Up DP Solution

    Let dp[i] = whether the substring from 0 to i can be made of words in the dictionary
    Target is dp[n] where n = s.size()

    Iterate over the string, from index i, go backwards to see if any substring from 0 to j is true
    If so, look at the substring from j to i and check if that can be created from the dictionary
    Label dp[i] to be true if so.

    Final time is O(n^2)
*/

class Solution {
   public:
    bool wordBreak(string s, vector<string>& wordDict) {
        int n = s.size();

        if (wordDict.size() == 0) {
            return false;
        }

        vector<bool> dp(n + 1, false);
        dp[0] = true;

        // i: Main pointer from 0 to s.size() inclusive because the goal is dp[n]
        // j: Pointer that looks back at previous character from i back to 0
        for (int i = 1; i <= n; ++i) {
            for (int j = i - 1; j >= 0; --j) {
                if (dp[j]) {
                    string subWord = s.substr(j, i - j);

                    // Check if subWord can be made from the dictionary
                    for (const string& word : wordDict) {
                        if (word == subWord) {
                            dp[i] = true;
                            break;
                        }
                    }
                }
            }
        }
        return dp[n];
    }
};