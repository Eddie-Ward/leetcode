package leetcode150;

class Solution {
    public int removeElement(int[] nums, int val) {
        int insertIndex = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != val) {
                nums[insertIndex++] = nums[i];
            }
        }
        return insertIndex;
    }
}
