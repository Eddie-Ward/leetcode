package daily;

class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] >= nums[left]) {
                // (left, mid) is non-rotated part
                if (nums[mid] >= target && nums[left] <= target) {
                    right = mid - 1; // If target is in range, just search this part
                } else {
                    left = mid + 1;
                }
            } else {
                // (mid, right) is non-rotated part
                if (nums[mid] <= target && nums[right] >= target) {
                    left = mid + 1; // If target is in range, just search this part
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}