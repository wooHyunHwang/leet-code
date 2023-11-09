class Solution {

    public int coinChange(int[] coins, int amount) {

        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for(int coin : coins) {
            for (int i = coin; i <= amount; ++i) {
                dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
            }
        }

        return dp[amount] != amount + 1 ? dp[amount] : -1;

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
