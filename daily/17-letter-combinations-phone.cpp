#include <string>
#include <vector>

using std::vector, std::string;

/*
    Backtracking Solution
*/

class Solution {
   public:
    vector<string> letterCombinations(string digits) {
        vector<string> ans;
        if (digits.size() == 0) {
            return ans;
        }
        string curString;
        generate(digits, 0, curString, ans);
        return ans;
    }

    void generate(const string& digits, int index, string& curString, vector<string>& ans) {
        if (index == digits.size()) {
            ans.push_back(curString);
            return;
        }
        int curDigit = (int)digits.at(index) - (int)'0';
        for (char& ch : phoneMap[curDigit - 2]) {
            curString.push_back(ch);
            generate(digits, index + 1, curString, ans);
            curString.pop_back();
        }
    }

   private:
    vector<vector<char>> phoneMap = {
        {'a', 'b', 'c'},
        {'d', 'e', 'f'},
        {'g', 'h', 'i'},
        {'j', 'k', 'l'},
        {'m', 'n', 'o'},
        {'p', 'q', 'r', 's'},
        {'t', 'u', 'v'},
        {'w', 'x', 'y', 'z'}};
};