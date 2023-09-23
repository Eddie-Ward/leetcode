package daily;

import java.util.Arrays;
import java.util.HashMap;

class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b) -> Integer.compare(a.length(), b.length()));
        HashMap<String, Integer> map = new HashMap<>();
        int ans = 0;
        for (String word : words) {
            int longest = 0;
            for (int i = 0; i < word.length(); ++i) {
                StringBuilder sub = new StringBuilder(word);
                sub.deleteCharAt(i);
                longest = Math.max(longest, map.getOrDefault(sub.toString(), 0) + 1);
            }
            map.put(word, longest);
            ans = Math.max(ans, longest);
        }
        return ans;
    }
}