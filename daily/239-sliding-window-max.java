package daily;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        if (nums == null || k <= 0) {
            return new int[0];
        }

        int n = nums.length;

        int[] ans = new int[n - k + 1];
        int ansIndex = 0;

        // Use a deque to store indices of potential max elemetns
        Deque<Integer> q = new ArrayDeque<>();

        for (int i = 0; i < nums.length; i++) {

            // remove numbers out of range k
            while (!q.isEmpty() && q.peek() < i - k + 1) {
                q.poll();
            }

            // remove smaller numbers in deque that are less than nums[i] because they
            // cannot be a max candidate
            while (!q.isEmpty() && nums[q.peekLast()] < nums[i]) {
                q.pollLast();
            }

            // add index of current element
            q.offer(i);

            // if the window is sliding, start adding max
            if (i >= k - 1) {
                ans[ansIndex++] = nums[q.peek()];
            }

        }
        return ans;
    }
}
