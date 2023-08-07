#include <vector>

using std::vector;

/*
    Binary Search Solution
    Given the restrictions, the 2D matrix is simply just a sorted list
    For using binary search on the whole list,
        1. Right bound = numRows * numCols - 1
        2. The val to check is at matrix[mid / numCols][mid % numCols]
        Note that numCols is the only one that matters
*/

class Solution {
   public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        int numRows = matrix.size(), numCols = matrix[0].size();
        int left = 0, right = numRows * numCols - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int val = matrix[mid / numCols][mid % numCols];
            if (val == target) {
                return true;
            }
            if (val < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
};