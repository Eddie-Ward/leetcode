#include <limits.h>

#include <algorithm>
#include <vector>

using namespace std;

class Solution {
   public:
    int maximumRequests(int n, vector<vector<int>>& requests) {
        vector<int> bal(n, 0);
        int ans = backtrack(requests, bal, 0);
        return ans;
    }

    int backtrack(const vector<vector<int>>& requests, vector<int>& bal, int index) {
        if (index == requests.size()) {
            if (all_of(bal.begin(), bal.end(), [](int i) { return i == 0; })) {
                return 0;
            } else {
                return INT_MIN;
            }
        } else {
            --bal[requests[index][0]];
            ++bal[requests[index][1]];
            int total = 1 + backtrack(requests, bal, index + 1);
            ++bal[requests[index][0]];
            --bal[requests[index][1]];
            return max(total, backtrack(requests, bal, index + 1));
        }
    }
};