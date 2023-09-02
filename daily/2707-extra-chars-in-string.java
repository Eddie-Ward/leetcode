package daily;

import java.util.Arrays;

class Solution {
    int dp[];

    public int minExtraChar(String s, String[] dictionary) {
        dp = new int[s.length()];
        Arrays.fill(dp, -1);
        return minExtraChar(s, dictionary, 0);
    }

    private int minExtraChar(String s, String[] dictionary, int index) {
        if (index == s.length()) {
            return 0;
        }

        if (dp[index] == -1) {
            dp[index] = 1 + minExtraChar(s, dictionary, index + 1);

            for (String word : dictionary) {
                if (index + word.length() <= s.length()
                        && s.substring(index + word.length(), word.length()).equals(word)) {
                    dp[index] = Math.min(dp[index], minExtraChar(s, dictionary, index + word.length()));
                }
            }
        }

        return dp[index];

    }
}