class Solution {
    public int[] finalPrices(int[] prices) {
        int[] answer = new int[prices.length];

        for (int i = 0; i < prices.length; ++i) {
            answer[i] = this.findDiscountPrice(prices, i+1, prices[i]);
        }

        return answer;
    }

    private int findDiscountPrice(int[] prices, int j, int price) {

        for (; j < prices.length; ++j) {
            if (prices[j] <= price) {
                return price - prices[j];
            }
        }
        return price;
    }

    public int[] finalPrices2(int[] prices) {
        int[] answer = new int[prices.length];

        for (int i = 0; i < prices.length; ++i) {
            int find = prices[i];
            for (int j = i+1; j < prices.length; ++j) {
                if (prices[i] >= prices[j]) {
                    find = prices[i] - prices[j];
                    break;
                }
            }
            answer[i] = find;
        }

        return answer;
    }
}