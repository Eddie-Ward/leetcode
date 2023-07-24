#include <algorithm>
#include <iostream>
#include <string>
#include <unordered_map>
#include <unordered_set>
#include <vector>

using namespace std;

class Solution {
   public:
    vector<vector<int>> threeSum(vector<int>& nums) {
        int n = nums.size();

        unordered_set<string> triplets;
        sort(nums.begin(), nums.end());

        for (int i = 0; i < n - 2; ++i) {
            int target = 0 - nums[i];
            unordered_set<int> complement;
            for (int j = i; j < n; ++j) {
                if (complement.find(target - nums[j]) != complement.end()) {
                    string triplet = format("{}##{}##{}", nums[i], target - nums[j], nums[j]);
                    if (triplets.find(triplet) == triplets.end()) {
                        triplets.insert(triplet);
                    }
                    break;
                }
                complement.insert(nums[j]);
            }
        }

        vector<vector<int>> answers;

        for (const string& : triplets) {
                }
    }
};