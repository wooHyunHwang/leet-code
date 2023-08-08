class Solution {
    public int maxProfit(int[] prices) {
        int sum = 0;
        for (int i = 0; i < prices.length - 1; ++i) {
            int div = prices[i+1] - prices[i];
            if(div > 0) sum += div;
        }
        return sum;
    }
}