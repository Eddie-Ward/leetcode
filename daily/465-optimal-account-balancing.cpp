#include <limits.h>

#include <unordered_map>
#include <vector>

using std::vector, std::unordered_map, std::min;

class Solution {
   public:
    int minTransfers(vector<vector<int>>& transactions) {
        unordered_map<int, long> bal;
        vector<long> debts;
        for (const auto& record : transactions) {
            bal[record[0]] -= record[2];
            bal[record[1]] += record[2];
        }
        for (const auto& person : bal) {
            if (person.second != 0) {
                debts.push_back(person.second);
            }
        }

        return dfs(0, debts);
    }

    int dfs(int start, vector<long>& debts) {
        while (start < debts.size() && debts[start] == 0) {
            start++;
        }

        int res = INT_MAX;

        for (long i = start + 1; i < debts.size(); ++i) {
            if (debts[i] * debts[start] < 0) {
                debts[i] += debts[start];
                res = min(res, 1 + dfs(start + 1, debts));
                debts[i] -= debts[start];
            }
        }

        return res < INT_MAX ? res : 0;
    }
};