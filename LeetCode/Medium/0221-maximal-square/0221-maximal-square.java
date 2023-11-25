class Solution {
    public int maximalSquare(char[][] matrix) {
        
        int max = 0;
        int[][] dp = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; ++i) {
            if (matrix[i][0] == '1') {
                max = 1;
                dp[i][0] = 1;
            }
        }

        for (int i = 1; i < matrix[0].length; ++i) {
            if (matrix[0][i] == '1') {
                max = 1;
                dp[0][i] = 1;
            }
        }

        for (int i = 1; i < matrix.length; ++i) {
            for (int j = 1; j < matrix[i].length; ++j) {
                if (matrix[i][j] == '1') {

                    // -1 좌표들의 최소값 + 1을 dp[i][j] 에 기록
                    dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
                    if (dp[i][j] > max) max = dp[i][j];
                }
            }
        }

        return max * max;
    }

}

// 1 0 1 0 0
// 1 0 1 1 1
// 1 1 1 4 4
// 1 0 0 1 0

// 1 0 1 0 0
// 1 0 1 1 1 1
// 1 1 1 2 2 2
// 1 0 1 2 3 3
//     1 2 3 4


// 1 0 1 1 1
// 1 1 1 2 2
// 1 2 2 2 3
// 1 0 1 1 0