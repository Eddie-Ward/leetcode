package daily;

class Solution {
    public int minDifficulty(int[] jobDifficulty, int d) {
        int numJobs = jobDifficulty.length;

        if (d > numJobs) {
            return -1;
        }

        Integer[][] cache = new Integer[d - 1][numJobs];

        return dp(jobDifficulty, d - 1, 0, cache);
    }

    private int dp(int[] jobDifficulty, int d, int index, Integer[][] cache) {
        if (d == 0) {
            int max = jobDifficulty[index];
            for (int i = index; i < jobDifficulty.length; ++i) {
                max = Math.max(max, jobDifficulty[i]);
            }
            return max;
        }

        int day = d - 1;

        if (cache[day][index] != null) {
            return cache[day][index];
        }

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = index; i < jobDifficulty.length - d; ++i) {
            max = Math.max(max, jobDifficulty[i]);
            min = Math.min(min, max + dp(jobDifficulty, d - 1, i + 1, cache));
        }

        cache[day][index] = min;
        return min;
    }
}
