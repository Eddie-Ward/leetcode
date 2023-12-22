package leetcode150;

class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int lowestPrice = prices[0];
        for (int price : prices) {
            if (price < lowestPrice) {
                lowestPrice = price;
            }
            maxProfit = Math.max(maxProfit, price - lowestPrice);
        }
        return maxProfit;
    }
}
