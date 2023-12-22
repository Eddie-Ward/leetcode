package leetcode150;

class Solution {
    public int removeDuplicates(int[] nums) {
        int insertIndex = 1;
        int prevNum = nums[0];
        int numOccurs = 1;
        for (int curIndex = 1; curIndex < nums.length; curIndex++) {
            int curNum = nums[curIndex];
            if (curNum == prevNum) {
                numOccurs++;
            } else {
                prevNum = curNum;
                numOccurs = 1;
            }
            if (numOccurs <= 2) {
                nums[insertIndex++] = curNum;
            }
        }
        return insertIndex;
    }
}
