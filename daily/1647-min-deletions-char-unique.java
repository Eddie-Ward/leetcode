package daily;

import java.util.HashMap;
import java.util.HashSet;

class Solution {
    public int minDeletions(String s) {
        HashMap<Character, Integer> charCount = new HashMap<>();
        HashSet<Integer> freqCount = new HashSet<>();
        int deletions = 0;

        for (char c : s.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        for (int freq : charCount.values()) {
            while (freq > 0 && freqCount.contains(freq)) {
                freq--;
                deletions++;
            }
            freqCount.add(freq);
        }

        return deletions;
    }
}
