class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        int[] row = new int[grid.length];
        int[] col = new int[grid[0].length];

        for(int i = 0; i < grid.length; ++i) {
            for(int j = 0; j < grid[i].length; ++j) {
                row[i] += grid[i][j];
            }
            row[i] = row[i] + row[i] - grid.length;
        }

        for(int j = 0; j < grid[0].length; ++j) {
            for(int i = 0; i < grid.length; ++i) {
                col[j] += grid[i][j];
            }
            col[j] = col[j] + col[j] - grid[0].length;
        }

        for(int i = 0; i < grid.length; ++i) {
            for(int j = 0; j < grid[i].length; ++j) {
                grid[i][j] = row[i] + col[j];
            }
        }

        return grid;
    }
    public int[][] onesMinusZeros2(int[][] grid) {
        int[] onesRow = new int[grid.length];
        int[] onesCol = new int[grid[0].length];
        int[] zerosRow = new int[grid.length];
        int[] zerosCol = new int[grid[0].length];

        for(int i = 0; i < grid.length; ++i) {
            for(int j = 0; j < grid[i].length; ++j) {
                if (grid[i][j] == 1) {
                    onesRow[i]++;
                    onesCol[j]++;
                } else {
                    zerosRow[i]++;
                    zerosCol[j]++;
                }
            }
        }

        for(int i = 0; i < grid.length; ++i) {
            for(int j = 0; j < grid[i].length; ++j) {
                grid[i][j] = onesRow[i] + onesCol[j] - zerosRow[i] - zerosCol[j];
            }
        }

        return grid;
    }
}