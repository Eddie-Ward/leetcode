import java.util.Set;
import java.util.HashSet;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> uniques = new HashSet<Integer>();
        for (int num : nums) {
            if (!uniques.add(num)) {
                return true;
            }
        }
        return false;
    }
}