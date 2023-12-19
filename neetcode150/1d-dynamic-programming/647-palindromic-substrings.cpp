#include <string>

using std::string;

/*
    Iterative Solution
    Use a main for loop to iterate over the string with an index as center of palindrome
    Expand outwards with helper function to count palindromic substrings
    Use center and center + 1 for odd and even palidnromes
*/

class Solution {
   public:
    int countSubstrings(string s) {
        int count = 0;
        for (int center = 0; center < s.size(); ++center) {
            checkPalindrome(s, center, center, count);
            checkPalindrome(s, center, center + 1, count);
        }
        return count;
    }

    int checkPalindrome(const string& s, int left, int right, int& count) {
        while (left >= 0 && right < s.size() && s.at(left) == s.at(right)) {
            count++;
            left--;
            right++;
        }
    }
};