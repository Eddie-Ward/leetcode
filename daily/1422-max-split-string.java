package daily;

class Solution {
    public int maxScore(String s) {
        int visitedZeros = 0;
        int visitedOnes = 0;
        int maxScore = Integer.MIN_VALUE;

        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '0') {
                visitedZeros++;
            } else {
                visitedOnes++;
            }
            if (i != s.length() - 1) {
                maxScore = Math.max(maxScore, visitedZeros - visitedOnes);
            }
        }

        return maxScore + visitedOnes;
    }
}
