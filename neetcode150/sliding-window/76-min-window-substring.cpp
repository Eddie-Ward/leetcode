#include <iostream>
#include <string>
#include <unordered_map>

using std::string;

/*
    Sliding Window solution

    Use two hashmaps to keep track of substirng counter and current window counter
    Also keep track of a count of distinct letters in the substring and current window
    This will avoid needing to compare the two hashmaps every time the window moves
*/

class Solution {
   public:
    string minWindow(string s, string t) {
        if (t.size() > s.size()) {
            return "";
        }

        std::unordered_map<char, int> subCounter;
        std::unordered_map<char, int> curCounter;

        for (const char& ch : t) {
            subCounter[ch]++;
        }

        int numLetters = subCounter.size();
        int curNumLetters = 0;

        int minLeft = 0, minRight = s.size() - 1;
        bool found = false;

        for (int right = 0, left = 0; right < s.size(); ++right) {
            char chRight = s.at(right);

            curCounter[chRight]++;  // Update current window's counter
            if (subCounter.count(chRight) != 0 && curCounter[chRight] == subCounter[chRight]) {
                curNumLetters++;  // Update current window's letter count if both counters match now
            }

            while (curNumLetters == numLetters) {
                found = true;  // Flag to track at least one valid substring exists
                char chLeft = s.at(left);

                curCounter[chLeft]--;  // Update current window's counter by removing left character
                if (subCounter.count(chLeft) != 0 && curCounter[chLeft] < subCounter[chLeft]) {
                    curNumLetters--;  // Update current window's letter count if there is now missing characters

                    if (minRight - minLeft > right - left) {
                        minRight = right;  // Update minimum window indices if current window is smaller
                        minLeft = left;
                    }
                }
                left++;
            }
        }

        return found ? s.substr(minLeft, minRight - minLeft + 1) : "";
    }
};