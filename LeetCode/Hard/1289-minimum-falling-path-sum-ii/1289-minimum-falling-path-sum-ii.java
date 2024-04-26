class Solution {

    public int minFallingPathSum(int[][] grid) {

        if (grid[0].length > 1) {

            int[][] dp = new int[grid.length][grid[0].length];

            int[] afterDepthRankTemp = new int[2];
            int afterDepth0RankIdx = 0;
            afterDepthRankTemp[0] = Integer.MAX_VALUE;

            for (int i = 0; i < grid[grid.length-1].length; ++i) {
                dp[grid.length-1][i] = grid[grid.length-1][i];
                if (afterDepthRankTemp[0] > dp[grid.length-1][i]) {
                    afterDepthRankTemp[1] = afterDepthRankTemp[0];
                    afterDepthRankTemp[0] = dp[grid.length-1][i];
                    afterDepth0RankIdx = i;
                }
                else if (afterDepthRankTemp[1] > dp[grid.length-1][i]) {
                    afterDepthRankTemp[1] = dp[grid.length-1][i];
                }
            }

            for (int x = grid.length - 2; x > -1; --x) {

                // System.out.println("다음 뎁스 최소 " + afterDepthRankTemp[0] + " :::::: " + afterDepthRankTemp[1]);

                int afterX = x+1;
                int[] nextAfterDepthRankTemp = new int[2];
                int nextAfterDepth0RankIdx = 0;
                nextAfterDepthRankTemp[0] = Integer.MAX_VALUE;
                
                for (int y = 0; y < grid[x].length; ++y) {
                    if (y == afterDepth0RankIdx) {
                        dp[x][y] = grid[x][y] + afterDepthRankTemp[1];
                    } else {
                        dp[x][y] = grid[x][y] + afterDepthRankTemp[0];
                    }

                    // System.out.println("       y ::: " + dp[x][y]);

                    if (nextAfterDepthRankTemp[0] > dp[x][y]) {
                        nextAfterDepthRankTemp[1] = nextAfterDepthRankTemp[0];
                        nextAfterDepthRankTemp[0] = dp[x][y];
                        nextAfterDepth0RankIdx = y;
                    }
                    else if (nextAfterDepthRankTemp[1] > dp[x][y]) {
                        nextAfterDepthRankTemp[1] = dp[x][y];
                    }
                }

                afterDepthRankTemp = nextAfterDepthRankTemp;
                afterDepth0RankIdx = nextAfterDepth0RankIdx;
            }

            // System.out.println("마지막 뎁스 최소 " + afterDepthRankTemp[0]);

            return afterDepthRankTemp[0];
        }
        else {
            int sum = 0;
            for (int[] arr : grid) {
                for (int n : arr) {
                    sum += n;
                }
            }
            return sum;
        }
    }

    /* Brute force
    public int minFallingPathSum(int[][] grid) {

        return this.recursive(grid, 0, Integer.MAX_VALUE, 0);
    }

    private int recursive(int[][] grid, int x, int beforeY, int pathValue) {

        if (x >= grid.length) return pathValue;

        int min = Integer.MAX_VALUE;
        for (int y = 0; y < grid[x].length; ++y) {
            if (beforeY == y) continue;
            // System.out.println(pathValue+" + "+grid[x][y]);
            min = Math.min(min, this.recursive(grid, x+1, y, pathValue+grid[x][y]));
        }

        return min;
    }
    */
}