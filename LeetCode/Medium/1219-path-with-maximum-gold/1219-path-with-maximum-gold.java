class Solution {
    public int getMaximumGold(int[][] grid) {

        int max = 0;

        int width = grid[0].length;
        int height = grid.length;

        for (int i = 0; i < height; ++i) {
            for (int j = 0; j < width; ++j) {
                if (grid[i][j] != 0) {
                    max = Math.max(max, this.findPath(grid, i, j, width, height, 0, new boolean[height][width]));
                }
            }
        }

        return max;
    }

    private int findPath(int[][] grid, int i, int j, int width, int height, int stack, boolean[][] history) {

        history[i][j] = true;

        int pathStack = 0;

        // 위
        if (-1 < i-1 && !history[i-1][j] && grid[i-1][j] > 0) pathStack = Math.max(
            pathStack,
            this.findPath(grid, i-1, j, width, height, stack, history)
        );

        // 오
        if (j+1 < width && !history[i][j+1] && grid[i][j+1] > 0) pathStack = Math.max(
            pathStack,
            this.findPath(grid, i, j+1, width, height, stack, history)
        );

        // 아
        if (i+1 < height && !history[i+1][j] && grid[i+1][j] > 0) pathStack = Math.max(
            pathStack,
            this.findPath(grid, i+1, j, width, height, stack, history)
        );

        // 왼
        if (-1 < j-1 && !history[i][j-1] && grid[i][j-1] > 0) pathStack = Math.max(
            pathStack,
            this.findPath(grid, i, j-1, width, height, stack, history)
        );

        history[i][j] = false;

        return grid[i][j] + pathStack;
    }
}