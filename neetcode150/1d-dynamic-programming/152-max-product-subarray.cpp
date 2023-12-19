#include <vector>

using std::vector, std::swap, std::max, std::min;

/*
    1D Bottom-Up Solution

    At every iteration, keep track of the max and min the product can be
    If a negative number is encountered, swap the max and min (multiply by negative)
    At every iteration, the decision is to retain the product or to start over at the current element
    Update the answer every iteration if a new max is encountered
*/

class Solution {
   public:
    int maxProduct(vector<int>& nums) {
        int ans = nums[0];

        int ansMin = ans, ansMax = ans;

        for (int i = 1; i < nums.size(); ++i) {
            if (nums[i] < 0) {
                swap(ansMin, ansMax);
            }
            ansMax = max(nums[i], ansMax * nums[i]);
            ansMin = min(nums[i], ansMin * nums[i]);

            ans = max(ans, ansMax);
        }

        return ans;
    }
};