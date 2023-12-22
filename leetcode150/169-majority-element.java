package leetcode150;

import java.util.HashMap;

class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        int n = nums.length;
        int majority = n / 2;
        for (int num : nums) {
            int count = freq.getOrDefault(num, 0) + 1;
            if (count > majority) {
                return num;
            }
            freq.put(num, count);
        }
        return -1;
    }
}
