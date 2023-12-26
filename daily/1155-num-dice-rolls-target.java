package daily;

import java.util.HashMap;

class Solution {
    private int MOD = (int) Math.pow(10, 9) + 7;
    private HashMap<String, Integer> memo = new HashMap<>();

    public int numRollsToTarget(int n, int k, int target) {
        return dp(n, k, target);
    }

    private int dp(int n, int k, int target) {
        if (n == 0) {
            return target == 0 ? 1 : 0;
        }

        String hash = n + "##" + target;

        if (memo.containsKey(hash)) {
            return memo.get(hash);
        }

        int ans = 0;

        for (int i = 1; i <= Math.min(target, k); ++i) {
            ans = (ans + dp(n - 1, k, target - i)) % MOD;
        }

        memo.put(hash, ans);
        return ans;
    }
}
