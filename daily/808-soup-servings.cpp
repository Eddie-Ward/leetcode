class Solution {
   public:
    double memo[200][200];
    double soupServings(int n) {
        if (n > 4800) {
            return 1.0;
        }
        return serveSoup((n + 24) / 25, (n + 24) / 25);
    }
    double serveSoup(int a, int b) {
        if (a <= 0 && b <= 0) {
            return 0.5;
        }
        if (a <= 0) {
            return 1;
        }
        if (b <= 0) {
            return 0;
        }
        if (memo[a][b] > 0) {
            return memo[a][b];
        }
        memo[a][b] = 0.25 * (serveSoup(a - 4, b) + serveSoup(a - 3, b - 1) + serveSoup(a - 2, b - 2) + serveSoup(a - 1, b - 3));
        return memo[a][b];
    }
};