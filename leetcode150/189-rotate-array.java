package leetcode150;

/**
 * Divide array into two parts:
 * 1. First part up to last k elements [0, nums.length - k - 1]
 * 2. Last k elements [nums.length - k - 1, nums.length - 1]
 * 
 * Reverse both subarrays separately
 * Reverse entire array again.
 */

class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length - k - 1);
        reverse(nums, nums.length - k, nums.length - 1);
        reverse(nums, 0, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }
}
