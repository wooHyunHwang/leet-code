class neighborSum {
    private int[] adjacent = null;
    private int[] diagonal = null;
    public neighborSum(int[][] grid) {
        this.adjacent = new int[grid.length * grid.length];
        this.diagonal = new int[grid.length * grid.length];

        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[i].length; ++j) {
                if (i > 0) this.adjacent[grid[i][j]] += grid[i-1][j];
                if (j > 0) this.adjacent[grid[i][j]] += grid[i][j-1];
                if (i < grid.length-1) this.adjacent[grid[i][j]] += grid[i+1][j];
                if (j < grid[i].length-1) this.adjacent[grid[i][j]] += grid[i][j+1];

                if (i > 0 && j > 0) this.diagonal[grid[i][j]] += grid[i-1][j-1];
                if (i > 0 && j < grid[i].length-1) this.diagonal[grid[i][j]] += grid[i-1][j+1];
                if (i < grid.length-1 && j > 0) this.diagonal[grid[i][j]] += grid[i+1][j-1];
                if (i < grid.length-1 && j < grid[i].length-1) this.diagonal[grid[i][j]] += grid[i+1][j+1];
            }
        }
    }
    
    public int adjacentSum(int value) {
        return adjacent[value];
    }
    
    public int diagonalSum(int value) {
        return diagonal[value];
    }
}

/**
 * Your neighborSum object will be instantiated and called as such:
 * neighborSum obj = new neighborSum(grid);
 * int param_1 = obj.adjacentSum(value);
 * int param_2 = obj.diagonalSum(value);
 */