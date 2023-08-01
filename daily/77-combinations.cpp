#include <vector>

using std::vector;

/*
    Backtracking Solution
    Take the combination of k - 1 from the prev step and append values from start to n inclusive
    Recursively continue until comb.size() == k
    On the way back, pop what was appended for the next iteration of the for loop
*/

class Solution {
   public:
    vector<vector<int>> combine(int n, int k) {
        vector<vector<int>> ans;
        vector<int> comb;
        backtrack(ans, comb, 0, n, k);
        return ans;
    }

   private:
    void backtrack(vector<vector<int>>& ans, vector<int>& comb, int start, int n, int k) {
        // Base Case: if the combination is already generated, push it to ans
        if (comb.size() == k) {
            ans.push_back(comb);
            return;
        }
        for (int i = start; i <= n; ++i) {
            comb.push_back(i);                  // Push the current value of the for loop
            backtrack(ans, comb, i + 1, n, k);  // Continue generation the next iterations of this combination
            comb.pop_back();                    // Remove the added value of the last iteration for the next iteration of for loop
        }
    }
};