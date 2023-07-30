#include <string>

using std::string, std::min;

/*
    DP Bottom-Up Solution
    Use a 2D array where dp[i][j] represents the min ways to print the substring from i to j
    Seed diagonals since there is only 1 way to print a substring of size 1
    Build array and return dp[0][n - 1]
*/

class Solution {
   public:
    int strangePrinter(string s) {
        int n = s.size();

        if (n == 0) {
            return 0;
        }

        int dp[n][n];

        // Seeding initial values of dp array
        for (int i = 0; i < n; ++i) {
            dp[i][i] = 1;  // A substring of size 1 has only 1 way to print

            // If the next char over is the same, still 1 way to print, else 2 ways minimum
            if (i + 1 < n) {
                dp[i][i + 1] = s.at(i) == s.at(i + 1) ? 1 : 2;
            }
        }

        for (int len = 2; len < n; ++len) {
            for (int start = 0; start + len < n; ++start) {
                dp[start][start + len] = len + 1;  // Max way to print substring is len + 1, print each char one time

                // Within a substring, we can divide it to some middle k index
                // If s[k] == s[end], then we can print the entire substring 1 fewer time
                // Iterate over each index in the substring to get the minimum way to print this substring
                for (int k = 0; k < len; ++k) {
                    int temp = dp[start][start + k] + dp[start + k + 1][start + len];
                    if (s.at(start + k) == s.at(start + len)) {
                        temp -= 1;
                    }
                    dp[start][start + len] = min(dp[start][start + len], temp);
                }
            }
        }

        return dp[0][n - 1];
    }
};