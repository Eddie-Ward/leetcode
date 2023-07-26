#include <string>
#include <unordered_set>

using namespace std;

/*
    Sliding Window Solution

    Outer while loop iterates until right pointer reaches end of string
    While the right char is in substring, increment left and update set (ex: "dvdf")
    Max_Length updates every iteration of outer
*/

class Solution {
   public:
    int lengthOfLongestSubstring(string s) {
        unordered_set<char> chars;
        int left = 0, right = 0;
        int maxLength = 0;
        while (right < s.size()) {
            while (chars.count(s.at(right)) != 0) {
                chars.erase(s.at(left));
                left++;
            }
            chars.insert(s.at(right));
            maxLength = max(maxLength, right - left + 1);
            right++;
        }
        return maxLength;
    }
};