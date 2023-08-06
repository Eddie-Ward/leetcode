/*
    2D Bottom-Up Solution

    Let dp[i][j] = the solution for making a playlist of j songs out of i total songs
    Target = dp[n][goal]

    The recursive formula is:
    f(n, goal, k) = f(n - 1, goal - 1, k) * n + f(n, goal - 1, k) * (n - k)

    It is the sum of all of two kinds of playlists:
        1. Playlists with goal - 1 songs at n - 1 songs, in which case the last choice can be any of the n songs
        2. Playlists with goal - 1 songs already at n songs, in which case there are (n - k) choices given k songs cannot repeat

    For the seeding,
        1. If n = goal, there are just n! choices, first song has n choices, second has n - 1, ...etc.
        2. If n = k + 1, there are still n! choices, since you would pick a permutation of n! choices and keep repeating until goal is reached
            For example if n = 3 and k = 2, and you had a playlist of 3, 1, 2, the next choice has to be 3, then 1, then 2... etc.
*/

class Solution {
   public:
    int numMusicPlaylists(int n, int goal, int k) {
        long dp[n + 1][goal + 1];
        long mod = 1e9 + 7;

        for (int i = k + 1; i <= n; ++i) {
            for (int j = i; j <= goal; ++j) {
                if (i == j || i == k + 1) {
                    dp[i][j] = factorial(i);
                } else {
                    dp[i][j] = (dp[i - 1][j - 1] * i + dp[i][j - 1] * (i - k)) % mod;
                }
            }
        }
        return (int)dp[n][goal];
    }

    long factorial(int n) {
        return n != 0 ? factorial(n - 1) * n % (long)(1e9 + 7) : 1;
    }
};