#include <string>
#include <vector>

using namespace std;

/*
    Sliding Window

    Array of 26 can store frequencies since only letters in string
    Right - Left + 1 = Length of Substring
    Number of chars that can change is length - mostFrequent
*/

class Solution {
   public:
    int characterReplacement(string s, int k) {
        int left = 0, right = 0;
        int count[26] = {0};
        int mostFreq = 0;
        int ans = 0;
        while (right < s.size()) {
            mostFreq = max(mostFreq, ++count[s.at(right) - 'A']);
            while (right - left + 1 - mostFreq > k) {
                --count[s.at(left) - 'A'];
                left++;
            }
            ans = max(ans, right - left + 1);
            right++;
        }
        return ans;
    }
};