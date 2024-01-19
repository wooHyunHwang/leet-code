class Solution {
    public int minFallingPathSum(int[][] matrix) {

        int[][] dp = new int[matrix.length][matrix[0].length];
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < matrix[0].length; ++i) {
            dp[0][i] = matrix[0][i];

            if (matrix.length == 1) {
                ans = Math.min(ans, matrix[0][i]);
            }
        }

        for (int i = 1; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[i].length; ++j) {
                int min = dp[i-1][j];
                if (j > 0) min = Math.min(min, dp[i-1][j-1]);
                if (j < matrix[i].length - 1) min = Math.min(min, dp[i-1][j+1]);
                dp[i][j] = matrix[i][j] + min;

                if (i == matrix.length-1 && ans > dp[i][j]) {
                    ans = dp[i][j];
                }
                
            }
        }

        return ans;
    }
}