#include <numeric>
#include <queue>
#include <vector>

using namespace std;

/*
    Heap Solution
    Suppose the largest battery is x.
    If x > sum/n (the theoretical average time), then battery x can stay in one computer for the entire time.
    Take battery x and one computer aside, repeat the process for n - 1.
    Compute sum is O(m), Build heap is O(m), Popping heap will take logm repeated maximum n times.
    Runtime: O(nlogm)
*/
class Solution {
   public:
    long long maxRunTime(int n, vector<int>& batteries) {
        long long sum = accumulate(batteries.begin(), batteries.end(), 0L);
        priority_queue<int> pq(batteries.begin(), batteries.end());
        while (pq.top() > sum / n) {
            sum -= pq.top();
            pq.pop();
            --n;
        }
        return sum / n;
    }
};

/*
    Binary Search Solution
    Theoretical max answer (proposedTime) is sum / n
    Binary search to find actual max charging time, helper function determines if proposedTime is possible
    Runtime: O(mlog(k/n)) where m is length of batteries array, and k is the sum of the array
*/
class Solution2 {
   public:
    long long maxRunTime(int n, vector<int>& batteries) {
        long long left = 0;
        long long right = accumulate(batteries.begin(), batteries.end(), 0LL) / n;
        long long answer = 0;
        while (left <= right) {
            long long mid = left + (right - left) / 2;
            if (isPossible(n, batteries, mid)) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return answer;
    }

   private:
    bool isPossible(int n, const vector<int>& batteries, long long proposedTime) {
        long long totalTime = proposedTime * n;
        long long actualTime = 0;
        for (int curBattery : batteries) {
            actualTime += min(proposedTime, (long long)curBattery);
        }
        return actualTime >= totalTime;
    }
};