package daily;

import java.util.HashMap;
import java.util.PriorityQueue;

class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        boolean[] visited = new boolean[n];

        // heapDict = {node, distance}
        HashMap<Integer, Integer> heapDict = new HashMap<>();
        heapDict.put(0, 0);

        // minHeap = {distance, node}
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        minHeap.add(new int[] { 0, 0 });

        int mst_weight = 0;

        while (!minHeap.isEmpty()) {
            int[] curPair = minHeap.poll();
            int edgeCost = curPair[0];
            int curNode = curPair[1];

            if (visited[curNode] || heapDict.getOrDefault(curNode, Integer.MAX_VALUE) < edgeCost) {
                continue;
            }

            visited[curNode] = true;
            mst_weight += edgeCost;

            for (int neighbor = 0; neighbor < n; neighbor++) {
                if (!visited[neighbor]) {
                    int dist = getDistance(points[curNode], points[neighbor]);
                    if (dist < heapDict.getOrDefault(neighbor, Integer.MAX_VALUE)) {
                        heapDict.put(neighbor, dist);
                        minHeap.add(new int[] { dist, neighbor });
                    }
                }
            }
        }

        return mst_weight;
    }

    private int getDistance(int[] pointOne, int[] pointTwo) {
        return Math.abs(pointTwo[0] - pointOne[0]) + Math.abs(pointTwo[1] - pointOne[1]);
    }
}
