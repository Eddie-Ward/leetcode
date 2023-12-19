#include <bits/stdc++.h>

#include <algorithm>
#include <functional>
#include <iostream>
#include <string>
#include <unordered_map>
#include <unordered_set>
#include <vector>

using namespace std;
using Triplet = std::tuple<int, int, int>;

class Solution {
   public:
    vector<vector<int>> threeSum(vector<int>& nums) {
        int n = nums.size();

        unordered_set<Triplet, hashFunction> triplets;
        sort(nums.begin(), nums.end());

        for (int i = 0; i < n - 2; ++i) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int target = 0 - nums[i];
            int left = i + 1;
            int right = nums.size() - 1;
            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum == target) {
                    triplets.insert({nums[i], nums[left], nums[right]});
                    left++;
                    right--;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        vector<vector<int>> answers;

        for (auto& triplet : triplets) {
            answers.push_back({get<0>(triplet), get<1>(triplet), get<2>(triplet)});
        }

        return answers;
    }

   private:
    struct hashFunction {
        // Overload header must have const input and const function
        std::size_t operator()(const Triplet& triplet) const {
            string hashString = to_string(get<0>(triplet)) + "##" + to_string(get<1>(triplet)) + "##" + to_string(get<2>(triplet));
            std::hash<std::string> stringHasher;
            return stringHasher(hashString);
        }
    };
};
