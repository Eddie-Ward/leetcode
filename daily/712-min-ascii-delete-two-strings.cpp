#include <array>
#include <string>

using std::string, std::array, std::min;

/*
    Bottom-Up DP Solution

    Use a 2D array in which dp[i][j] = cost to equal s1.substring(0, i) and s2.substring(0, j)
    Note that i and j are not included. This is for the base case dp[0][0] which is two empty strings.
    Also note that the dp array must then be dp[n + 1][m + 1] to get the final answer at dp[n][m]

    For the base cases:
        dp[0][0] = 0
        dp[i][0] = dp[i - 1][0] and dp[0][j] = dp[j - 1][0]
        This is because the cost to equal any substring with an empty string is just to delete all the chars
    For the recursive case:
        If the chars at i - 1 and j - 1 are equal:
            dp[i][j] = dp[i - 1][j - 1] becuase it costs nothing extra to equal the substrings
        Else:
            dp[i][j] = min(dp[i - 1][j] + s1[i - 1], dp[i][j - 1] + s2[j - 1])
            Choose the cheaper cost between deleting the first char and equaling those two substrings or the second
*/

class Solution {
   public:
    int minimumDeleteSum(string s1, string s2) {
        int n = s1.size(), m = s2.size();
        int dp[n][m];

        dp[0][0] = 0;  // Empty substrings

        // Any substring to an empty string
        for (int i = 1; i <= n; ++i) {
            dp[i][0] = dp[i - 1][0] + s1.at(i - 1);
        }
        for (int j = 1; j <= m; ++j) {
            dp[0][j] = dp[0][j - 1] + s2.at(j - 1);
        }

        for (int row = 1; row <= n; ++row) {
            for (int col = 1; col <= m; ++col) {
                if (s1.at(row - 1) == s2.at(col - 1)) {
                    dp[row][col] = dp[row - 1][col - 1];
                } else {
                    dp[row][col] = min(dp[row - 1][col] + s1.at(row - 1), dp[row][col - 1] + s2.at(col - 1));
                }
            }
        }

        return dp[n][m];
    }
};