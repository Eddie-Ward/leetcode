package daily;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Bucket sorting solution
 */
class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer, List<Integer>> groupBucket = new HashMap<>();
        List<List<Integer>> ans = new ArrayList<>();

        for (int id = 0; id < groupSizes.length; ++id) {
            int groupSize = groupSizes[id];
            groupBucket.computeIfAbsent(groupSize, x -> new ArrayList<>()).add(id);
            List<Integer> curBucket = groupBucket.get(groupSize);

            if (curBucket.size() == groupSize) {
                ans.add(curBucket);
                groupBucket.remove(groupSize);
            }
        }

        return ans;

    }
}