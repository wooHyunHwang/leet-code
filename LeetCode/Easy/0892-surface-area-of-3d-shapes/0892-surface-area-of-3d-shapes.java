class Solution {
    public int surfaceArea(int[][] grid) {
        int sum = 0;
        int lastI = grid.length - 1;
        int lastJ = grid[0].length - 1;

        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[i].length; ++j) {
                
                if (grid[i][j] == 0) continue;

                // 면적 전부 넣고
                sum += 2 + 4 * grid[i][j];

                // 각각 소거
                // 위
                if (i > 0) sum -= grid[i-1][j] < grid[i][j] ? grid[i-1][j] : grid[i][j];

                // 오
                if (j < lastJ) sum -= grid[i][j+1] < grid[i][j] ? grid[i][j+1] : grid[i][j];

                // 아
                if (i < lastI) sum -= grid[i+1][j] < grid[i][j] ? grid[i+1][j] : grid[i][j];

                // 왼
                if (j > 0) sum -= grid[i][j-1] < grid[i][j] ? grid[i][j-1] : grid[i][j];
            }
        }

        return sum;
    }
    public int surfaceArea2(int[][] grid) {
        int sum = 0;

        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[i].length; ++j) {
                
                // 숫자가 1보다 크면 위 아래 면적이 각각 1
                if (grid[i][j] > 0) sum += 2;

                // 위
                if (i != 0 && grid[i-1][j] > 0) {
                    int above = grid[i][j] - grid[i-1][j];
                    if (above > 0) sum += above;
                } else {
                    sum += grid[i][j];
                }

                // 오
                if (j != grid[i].length - 1 && grid[i][j+1] > 0) {
                    int right = grid[i][j] - grid[i][j+1];
                    if (right > 0) sum += right;
                }
                else {
                    sum += grid[i][j];
                }

                // 아
                if (i != grid.length - 1 && grid[i+1][j] > 0) {
                    int bottom = grid[i][j] - grid[i+1][j];
                    if (bottom > 0) sum += bottom;
                } else {
                    sum += grid[i][j];
                }

                // 왼
                if (j != 0 && grid[i][j-1] > 0) {
                    int left = grid[i][j] - grid[i][j-1];
                    if (left > 0) sum += left;
                }
                else {
                    sum += grid[i][j];
                }

            }
        }

        return sum;
    }
}
// 8 + 8 + 12 + 4 - 2     14  18  32