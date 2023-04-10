class Solution {
    public int islandPerimeter(int[][] grid) {
        int ans = 0;

        for(int i = 0; i < grid.length; ++i) {
            for(int j = 0; j < grid[i].length; ++j) {
                if(grid[i][j] == 1) {
                    // 4 방면 체크
                    // 좌
                    if (i == 0) {
                        ans++;
                    } else if (grid[i - 1][j] == 0) {
                        ans++;
                    }

                    // 우
                    if (i == grid.length - 1) {
                        ans++;
                    } else if (grid[i + 1][j] == 0) {
                        ans++;
                    }

                    // 위
                    if (j == 0) {
                        ans++;
                    } else if (grid[i][j - 1] == 0) {
                        ans++;
                    }

                    // 아래
                    if (j == grid[i].length - 1) {
                        ans++;
                    } else if (grid[i][j + 1] == 0) {
                        ans++;
                    }
                }
            }
        }

        return ans;
    }
}