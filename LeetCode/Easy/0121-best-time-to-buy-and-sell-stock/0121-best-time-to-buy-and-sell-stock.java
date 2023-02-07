class Solution {
    public int maxProfit(int[] prices) {

        int max = 0;
        int min = 100_000;

        for(int i = 0; i < prices.length; ++i) {

            min = Math.min(min, prices[i]);

            max = Math.max(max, prices[i] - min);
        }

        return max;


        // 조건 추가로 Time Limit 통과
        /*

        int max = 0;
        int min = 100_000;
        int minIdx = 0;

        for(int i = 0; i < prices.length - 1; ++i) {

            int tmp = Math.min(min, prices[i]);
            if(tmp != min) {
                min = tmp;
                minIdx = i;
            }
        }

        
        for(int i = 0; i < prices.length - 1; ++i) {

            if(minIdx < i) {
                break;
            }
            
            for(int j = i + 1; j < prices.length; ++j) {
                if(prices[i] < prices[j]) {
                    max = Math.max(max, prices[j] - prices[i]);
                }
            }
        }
        return max;
        */
    }
}