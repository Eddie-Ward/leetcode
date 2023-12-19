#include <vector>

using std::vector;

/*
    DP Solution with Binary Search and Patience Sorting / Solitaire

    Greedy algorithm with solitaire logic
    Using a sebsequence array:
        If the current value is larger than the last value, append to the sequence
        Else
            Look for the smallest value larger than current value and replace it with current value
            This can be done with binary search (bisect_left) for log(n) time
    Return the length of array
*/

class Solution {
   public:
    int lengthOfLIS(vector<int>& nums) {
        vector<int> sub;
        for (int x : nums) {
            if (sub.empty() || sub[sub.size() - 1] < x) {
                sub.push_back(x);
            } else {
                int left = 0, right = sub.size() - 1;

                // Bisect_left variation of binary search
                while (left < right) {
                    int mid = left + (right - left) / 2;
                    if (sub[mid] < x) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }

                sub[left] = x;
            }
        }
        return sub.size();
    }
};