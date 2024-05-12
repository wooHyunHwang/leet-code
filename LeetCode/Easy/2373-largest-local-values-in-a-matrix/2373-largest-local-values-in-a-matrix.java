class Solution {
    public int[][] largestLocal(int[][] grid) {
        int[][] ans = new int[grid.length-2][grid[0].length-2];
        int[][] temp = new int[grid.length][grid[0].length];

        // 세로 3개 처리
        for (int i = 1; i < grid.length-1; ++i) {
            for (int j = 0; j < grid[i].length; ++j) {
                temp[i][j] = Math.max(Math.max(grid[i+1][j], grid[i][j]), grid[i-1][j]);
            }
        }

        for (int i = 0; i < ans.length; ++i) {
            for (int j = 0; j < ans.length; ++j) {
                int iIdx = i+1;
                ans[i][j] = Math.max(Math.max(temp[iIdx][j], temp[iIdx][j+1]), temp[iIdx][j+2]);
            }
        }



        return ans;
    }
}

// 9 9 8 6
// 9 9 8 6
// 8 6 6 6
// 8 2 6 4

// 9 9
// 8 6