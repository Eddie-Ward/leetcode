#include <vector>

using std::vector;

/*
    Backtracking Solution
*/

class Solution {
   public:
    vector<vector<int>> permute(vector<int>& nums) {
        vector<vector<int>> ans;
        vector<int> build;  // Empty build array for each permutation
        backtrack(ans, nums, build);
        return ans;
    }

    void backtrack(vector<vector<int>>& ans, vector<int>& leftovers, vector<int>& build) {
        // Base Case: If there is nothing left to insert, just append the permutation to answer
        if (leftovers.size() == 0) {
            ans.push_back(build);
            return;
        }

        int n = leftovers.size();

        // Recursive case: At each iteration, there is a choice to include the index or to skip it
        // After calling backtrack, undo the insertion by re-inserting into leftovers and removing from build
        for (int i = 0; i < n; ++i) {
            build.push_back(leftovers[i]);
            leftovers.erase(leftovers.begin() + i);

            backtrack(ans, leftovers, build);

            leftovers.insert(leftovers.begin() + i, build.back());
            build.pop_back();
        }
    }
};