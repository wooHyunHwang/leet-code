class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; ++i) {
            // System.out.print(i + "   =  ");
            for (int j = 1; j*j <= i; ++j) {
                // System.out.print("[" + dp[i] + ", " + (dp[i - j * j] + 1) + "]   ");
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
            // System.out.println();
        }

        return dp[n];
    }
}
// 1 - 1
// 2 3 1 - 4
// 2 3 4 2 1 - 9
// 2 3 3 2 3 4 1 2 - 16