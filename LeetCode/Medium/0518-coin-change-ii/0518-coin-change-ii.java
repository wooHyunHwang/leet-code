class Solution {
    public int change(int amount, int[] coins) {
        int[][] history = new int[2][amount + 1];

        history[0][0] = 1;
        history[1][0] = 1;

        for(int i = coins.length - 1; i >= 0; --i) {
            // 세로
            for(int j = 1; j <= amount; ++j) {
                // 가로
                // System.out.println(j - coins[i]);
                history[0][j] = history[1][j] + (j - coins[i] >= 0 ? history[0][j - coins[i]] : 0);
            }
            history[1] = history[0];
        }

        return history[0][amount];
    }

    int ans = 0;
    public int change2(int amount, int[] coins) {
        if(amount == 0) return 1;
        ans = 0;

        for(int i = 0; i < coins.length; ++i) {
            // System.out.println(coins[i]);
            this.dfs(amount, coins, i, coins[i]);
        }

        return ans;
    }

    // brute force
    public void dfs(int amount, int[] coins, int lastIdx, int sum) {

        if(amount < sum) {
            // System.out.println("xxx 못찾음");
            return;
        }
        else if (amount == sum) {
            // System.out.println("===찾음");
            ans++;
            return;
        }

        for (int i = lastIdx; i >= 0; --i) {
            // System.out.println(coins[i]);
            this.dfs(amount, coins, i, sum + coins[i]);
        }
        

    }
}