#include <limits.h>

#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

class Solution {
   public:
    int distributeCookies(vector<int>& cookies, int k) {
        int ans = INT_MAX;
        vector<int> temp(k, 0);
        backtrack(0, cookies, k, temp, ans);
        return ans;
    }

    void backtrack(int start, const vector<int>& cookies, int k, vector<int>& temp, int& ans) {
        if (start == cookies.size()) {
            int maxCookies = *max_element(temp.begin(), temp.end());
            ans = min(ans, maxCookies);
            return;
        }

        for (int i = 0; i < k; i++) {
            temp[i] += cookies[start];
            backtrack(start + 1, cookies, k, temp, ans);
            temp[i] -= cookies[start];
        }
    }
};