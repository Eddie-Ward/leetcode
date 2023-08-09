package daily;

import java.util.Arrays;

/*
 * Binary Search / Greedy Solution
 * 
 * By sorting the array first, say [a, b, c, d],
 * pair(a, b) or pair(b, c) will be minimum difference
 * 
 * Then binary search the minimum difference possible
 * 
 */

class Solution {
    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums); // Sort array first for greedy

        int n = nums.length;
        int left = 0, right = nums[n - 1] - nums[0];
        while (left < right) {
            int mid = left + (right - left) / 2; // Mid is target difference that is possible
            int numPairs = 0;
            for (int i = 1; i < n && numPairs < p; ++i) {
                // If the pair diff is less than mid, this pair can be taken
                if (nums[i] - nums[i - 1] <= mid) {
                    numPairs++;
                    i++; // Increment i since this current index is taken
                }
            }
            // Narrow the search window
            if (numPairs >= p) {
                right = mid; // If numPairs is greater than target, this is a possible solution
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}