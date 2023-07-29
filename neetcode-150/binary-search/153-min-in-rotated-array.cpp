#include <vector>

using std::vector;

/*
    Binary Search Solution
    Left and right will converge on the min element
    If the middle element is greater than the right element:
        The pivot is to the right because the subarray wrapped around
    If the middle element is less than the right element:
        The pivot is either at the middle or to the left because the subarray is not wrapped
*/

class Solution {
   public:
    int findMin(vector<int>& nums) {
        int left = 0, right = nums.size() - 1;
        while (left < right) {
            int middle = left + (right - left) / 2;
            if (nums[middle] > nums[right]) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }
        return nums[left];
    }
};