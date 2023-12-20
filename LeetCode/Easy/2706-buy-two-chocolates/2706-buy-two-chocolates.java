class Solution {
    public int buyChoco(int[] prices, int money) {

        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < prices.length; ++i) {
            for (int j = i+1; j < prices.length; ++j) {
                ans = Math.min(ans, prices[i] + prices[j]);
            }
        }

        int calc = money - ans;

        return calc >= 0 ? calc : money;
    }

    public int buyChoco2(int[] prices, int money) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int p : prices) {
            pq.add(p);
        }

        int calc = money - pq.poll() - pq.poll();



        return calc <= money && calc >= 0 ? calc : money;
    }
}