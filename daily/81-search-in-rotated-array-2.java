package daily;

/*
 * "Binary" search solution
 * 
 * Similar to #33: Search in Rotated Array
 * 
 * Only thing is that there is a new case to consider that makes runtime O(n)
 * 
 */

class Solution {
    public boolean search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (target == nums[mid]) {
                return true;
            }

            // New case to consider, it is impossible to determine which side is rotated if
            // all the values are equal
            // In this case, increment both and check again.
            if (nums[left] == nums[mid] && nums[mid] == nums[right]) {
                left++;
                right--;
            } else if (nums[left] <= nums[mid]) {
                // (left, mid) is non-rotated
                // If target is in bounds of (left, mid) narrow the search down
                // It is left <= target because there is no check for if left == target earlier
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                // (mid, right) is non-rotated
                if (target <= nums[right] && target > nums[mid]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return false;
    }
}