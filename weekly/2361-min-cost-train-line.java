package weekly;

/*
 * Iterative DP Solution
 * 
 * The problem is essentially asking to build a 1D dp array
 * The two variables for each iteration are:
 *  1. The cost to get to the regular station
 *  2. The cost to get to the express station
 * Ans[i] is the minimum of the two, but these should still be tracked
 * because the answer for the next station does not necessarily mean you leave at this station
 * 
 * O(n) time and O(1) extra space
 * 
 */

class Solution {
    public long[] minimumCosts(int[] regular, int[] express, int expressCost) {
        long[] ans = new long[regular.length];

        long regPrev = 0, expPrev = expressCost;

        for (int i = 0; i < regular.length; ++i) {
            long regCost = regPrev + regular[i]; // Cost to get to take regular route
            long expCost = expPrev + express[i]; // Cost to get to take express route

            long regCurr = Math.min(regCost, expCost); // Cost to get to regular station (using either routes, switching
                                                       // is free)
            long expCurr = Math.min(regCost + expressCost, expCost); // Cost to get to express station (switching is not
                                                                     // free)

            ans[i] = Math.min(regCurr, expCurr); // Min cost is the answer

            regPrev = regCurr; // Keep track of costs for both stations next iteration
            expPrev = expCurr;
        }

        return ans;
    }
}