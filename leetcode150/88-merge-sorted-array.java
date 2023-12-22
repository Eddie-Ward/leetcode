package leetcode150;

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int backInsertIndex = m + n - 1; // Start at last index of nums1 array for insertion
        int indexOne = m - 1;
        int indexTwo = n - 1;

        while (indexTwo >= 0) {
            if (indexOne >= 0 && nums1[indexOne] > nums2[indexTwo]) {
                // place larger number from nums1 to end
                nums1[backInsertIndex--] = nums1[indexOne--];
            } else {
                // place larger number from nums2 to end
                // or there are no large numbers from num1 left, which they are already sorted
                nums1[backInsertIndex--] = nums2[indexTwo--];
            }
        }
    }
}
