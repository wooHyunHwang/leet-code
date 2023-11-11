class Solution {
    public int fib(int n) {

        if (n < 2) return n;
        
        int[] dp = new int [n+1];

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;

        int i = 1;
        int j = 2;
        int k = 3;

        while(k <= n) {
            dp[k++] = dp[i++] + dp[j++];
        }

        return dp[n];
    }
}