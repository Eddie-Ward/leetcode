#include <limits.h>

#include <vector>

using namespace std;

class Solution {
   public:
    int maxProfit(vector<int>& prices) {
        int minPrice = INT_MIN;
        int profit = 0;

        for (const int& price : prices) {
            minPrice = min(minPrice, price);
            profit = max(profit, price - minPrice);
        }

        return profit;
    }
};