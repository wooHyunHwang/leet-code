class Solution {
    private final int MODULO = 1000000007;
    public int numRollsToTarget(int n, int k, int target) {

        if (target < n || n * k < target)  return 0;

        int min = Math.min(k, target);
        int[][] dp = new int[n+1][target+1];

        for (int i = 1; i <= min; ++i) dp[1][i] = 1;

        for (int i = 2; i <= n; ++i) {
            for (int j = 1; j <= target; ++j) {
                int tMin = Math.min(k, j-1);
                for (int t = 1; t <= tMin; ++t) {
                    // System.out.println("["+i+"]["+j+"] = " + dp[i][j] + " + " + dp[i-1][j-t]);
                    dp[i][j] = (dp[i][j] + dp[i-1][j-t]) % MODULO;
                }
            }
        }

        return dp[n][target];
    }

    int ans = 0;

    public int numRollsToTarget2(int n, int k, int target) {

        if (n > target) return 0;

        this.ans = 0;

        this.recursion(0, 0, n, k, target);

        return this.ans;
    }

    private void recursion(int tryCount, int sum, int n, int k, int target) {

        if (sum > target) return;
        if (tryCount == n) {
            if (sum == target) this.ans++;
            return;
        }

        tryCount++;
        
        for (int i = 1; i <= k; ++i) {
            this.recursion(tryCount, sum + i, n, k, target);
        }
    }
}

// 1 2  3  4 5 6
//       6
//       6
// 1 5 10 10 5 1

// 1 2  3  4 5 6
//       3
//       6
// 0 1  7 10 5 1