package daily;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        if (numRows == 1) {
            List<List<Integer>> ans = new ArrayList<>();
            List<Integer> firstRow = new ArrayList<>();
            firstRow.add(1);
            ans.add(firstRow);
            return ans;
        }

        List<List<Integer>> prevRows = generate(numRows - 1);
        List<Integer> prevList = prevRows.get(prevRows.size() - 1);
        List<Integer> newRow = new ArrayList<>();
        newRow.add(1);

        for (int i = 0; i < prevList.size() - 1; ++i) {
            newRow.add(prevList.get(i) + prevList.get(i + 1));
        }

        newRow.add(1);

        prevRows.add(newRow);

        return prevRows;
    }
}
