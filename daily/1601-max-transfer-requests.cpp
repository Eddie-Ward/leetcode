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
            if (all_of(bal.begin(), bal.end(), [](int i) { i == 0; })) {
                return 0;
            } else {
                return INT_MIN;
            }
        }
    }
};