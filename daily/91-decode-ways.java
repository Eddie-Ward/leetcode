package daily;

class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) != '0' ? 1 : 0;

        for (int length = 2; length <= n; ++length) {
            int ones = s.charAt(length - 1) - '0';
            int tens = s.charAt(length - 2) - '0';
            int num = tens * 10 + ones;
            if (ones >= 1) {
                dp[length] += dp[length - 1];
            }
            if (10 <= num && num <= 26) {
                dp[length] += dp[length - 2];
            }
        }

        return dp[n];
    }
}