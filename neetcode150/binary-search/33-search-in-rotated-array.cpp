#include <vector>

using std::vector;

/*
    Binary Search Solution
    Similar to #153 with a rotated array
    Compare the middle with left and right elements to see if a subarray is rotated

*/

class Solution {
   public:
    int search(vector<int>& nums, int target) {
        int left = 0, right = nums.size() - 1;
        while (left <= right) {
            int middle = left + (right - left) / 2;

            if (nums[middle] == target) {
                return middle;
            }

            // If middle is greather than left, the left subarray is not rotated
            // Else, the left subarray contains the rotated part
            if (nums[middle] >= nums[left]) {
                // In the case that the left subarray is not rotated,
                // If the target is in the range of (left, middle), search the left portion
                // Otherwise, the target is in the rotated part, which will be to the right since this part is not rotated
                if (target >= nums[left] && target <= nums[middle]) {
                    right = middle - 1;
                } else {
                    left = middle + 1;
                }
            } else {
                // In the case that the left subarray is the rotated part,
                // If the target is in the range of (middle, right), search the right portion
                // Otherwise, the target is in the rotated part, which will be to the left since this part is rotated
                if (target <= nums[right] && target >= nums[middle]) {
                    left = middle + 1;
                } else {
                    right = middle - 1;
                }
            }
        }
        return -1;
    }
};