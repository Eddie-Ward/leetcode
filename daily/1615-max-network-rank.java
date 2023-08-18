package daily;

/**
 * Count Graph Degrees Solution
 * 
 * Store the degrees of each node in an array and take the max degrees.
 * The complex part is determining if the max degree nodes are potentially
 * connected. Additionally, another consideration is whether there are two-max
 * degree nodes, or there is a max-degree and 2nd-max-degree node.
 * 
 */

class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        int[] deg = new int[n];

        for (int[] cities : roads) {
            deg[cities[0]]++;
            deg[cities[1]]++;
        }

        int first = 0, second = 0;

        for (int degree : deg) {
            if (first < degree) {
                second = first;
                first = degree;
            } else if (second < degree && degree < first) {
                second = degree;
            }
        }

        int firstCount = 0, secondCount = 0;

        for (int degree : deg) {
            if (degree == first) {
                firstCount++;
            }
            if (degree == second) {
                secondCount++;
            }
        }

        if (firstCount > 1) {
            int edgeCount = 0;

            for (int[] road : roads) {
                if (deg[road[0]] == first && deg[road[1]] == first) {
                    edgeCount++; // Count the number of edges between all max-degree nodes
                }
            }

            int maxEdges = firstCount * (firstCount - 1) / 2; // Theoretical max number of edges if all max-degree nodes
                                                              // are connected to each other. In this case subtract one,
                                                              // otherwise it is possible to select two max-degree nodes
                                                              // that are not connected

            return 2 * first - (maxEdges == edgeCount ? 1 : 0);

        } else {
            int edgeCount = 0;

            for (int[] road : roads) {
                if (deg[road[0]] == first && deg[road[1]] == second) {
                    edgeCount++;
                }
                if (deg[road[1]] == first && deg[road[0]] == second) {
                    edgeCount++;
                }
            }

            return first - second - (secondCount == edgeCount ? 1 : 0); // If there is a max and 2nd max that is not
                                                                        // connected, the count of 2nd max nodes will
                                                                        // not equal to count of edges connecting first
                                                                        // max and second max. In this case, do not
                                                                        // subtract one as the two max nodes won't be
                                                                        // connected
        }
    }
}
