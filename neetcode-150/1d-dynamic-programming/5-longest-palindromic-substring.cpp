#include <string>
#include <vector>

using std::string, std::vector;

/*
    2D Bottom-Up Solution
    Let dp[i][j] represent if the substring from i to j is a palindrome
    While building the array, store the maxLength (j - i + 1) and startIndex (i) of the longest palindrome
    Iterate until the target of dp[0][n - 1]
*/

class Solution {
   public:
    string longestPalindrome(string s) {
        int n = s.size();
        vector<vector<bool>> dp(n, vector<bool>(n, false));
        int maxLength = 1, startIndex = 0;

        // Seed main diagonal, the substring of one char is a palindrome
        // This is also why maxLength starts at 1
        for (int i = 0; i < n; ++i) {
            dp[i][i] = true;
        }

        // Seed diagonal + 1, if the substring of two chars is the same char,
        // it is a palindrome. Update maxLength and startIndex if such a substring exists
        for (int row = 0; row < n - 1; ++row) {
            if (s.at(row) == s.at(row + 1)) {
                dp[row][row + 1] == true;
                maxLength = 2;
                startIndex = row;
            }
        }

        // Dist is distance from main diagonal, starts at 2 because dist = 1 has been seeded
        // Target: dp[0][n - 1]
        for (int dist = 2; dist < n; ++dist) {
            for (int row = 0; row < n - dist; ++row) {
                int col = row + dist;
                if (s.at(row) == s.at(col)) {
                    // If s[i] == s[j], look at if s[i + 1:j - 1] is a palindrome
                    dp[row][col] = dp[row + 1][col - 1];
                    if (dp[row][col] && row - col + 1 > maxLength) {
                        maxLength = row - col + 1;
                        startIndex = row;
                    }
                }
            }
        }

        return s.substr(startIndex, maxLength);
    }
};