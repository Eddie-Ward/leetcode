#include <cmath>
#include <vector>

using namespace std;

/*
    Binary Search Solution

    Maximum speed is 10^7 which is given by the problem, set as right bound
    For each train until the last one, ceiling function is used since you will wait until the next hour
    Last train does not need ceiling function
*/
class Solution {
   public:
    int minSpeedOnTime(vector<int>& dist, double hour) {
        int n = dist.size();
        if (n - 1 >= hour) {
            return -1;
        }
        int left = 1;
        int right = 10000000;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            double hoursNeeded = 0;
            for (int i = 0; i < n - 1; ++i) {
                hoursNeeded += ceil(dist[i] / (middle * 1.00));
            }
            hoursNeeded += dist[n - 1] / (middle * 1.00);
            if (hoursNeeded > hour) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return left;
    }
};