package daily;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();

        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        List<List<Integer>> ans = new ArrayList<>();
        int maxFreq = Collections.max(freq.values());

        for (int i = 0; i < maxFreq; ++i) {
            List<Integer> row = new ArrayList<>();
            for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
                int num = entry.getKey();
                int count = entry.getValue();
                if (count != 0) {
                    row.add(num);
                    freq.put(num, count - 1);
                }
            }
            ans.add(row);
        }

        return ans;
    }
}