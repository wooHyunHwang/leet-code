class Solution {

    public int coinChange(int[] coins, int amount) {

        int[] dp = new int[amount + 1];

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;


        for (int i = 1; i <= amount; ++i) {
            for(int j = 0; j < coins.length; ++j) {

                if (
                    // 카운트 가능한 코인이고
                    i - coins[j] >= 0 &&
                    // 이전에 카운트한 숫자가 초기값이 아니라면
                    dp[i - coins[j]] != Integer.MAX_VALUE
                ) {
                    // 더 작은 숫자로 구성이 가능한경우
                    dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);
                }

            }
        }

        return dp[amount] != Integer.MAX_VALUE ? dp[amount] : -1;

    }


    int[] his = null;
    public int coinChange2(int[] coins, int amount) {

        Arrays.sort(coins);
        his = new int[amount + 1];
        Arrays.fill(his, -2);

        return this.dfs(coins, amount, 0);
    }

    private int dfs(int[] coins, int amount, int count) {
        
        if (amount < 0) return -1;
        else if (amount == 0) return count;
        else if (his[amount] != -2) return his[amount];

        int ans = -1;
        for (int i = coins.length - 1; i >= 0; --i) {
            
            int ret = this.dfs(coins, amount - coins[i], count + 1);

            if (ret != -1) {
                if (ans != -1) ans = Math.min(ans, ret);
                else ans = ret;
            }
        }
        his[amount] = ans;
        return ans;
    }
}
