class Solution {
    
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int maxDown = obstacleGrid.length - 1;
        int maxRight = obstacleGrid[0].length - 1;
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];

        // bfsRecursive(obstacleGrid, 0, 0, 1);

        for (int i = 0; i <= maxDown; ++i) {
            if (obstacleGrid[i][0] == 0) dp[i][0] = 1;
            else break;
        }
        for (int i = 0; i <= maxRight; ++i) {
            if (obstacleGrid[0][i] == 0) dp[0][i] = 1;
            else break;
        }

        for (int i = 1; i <= maxDown; ++i) {
            for (int j = 1; j <= maxRight; ++j) {
                
                if (obstacleGrid[i][j] == 1) continue;

                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }




        return dp[maxDown][maxRight];
    }
}