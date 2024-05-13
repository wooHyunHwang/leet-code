class Solution {
    public int matrixScore(int[][] grid) {

        int vertical = grid.length;
        int horizon = grid[0].length;
        int halfVertical = vertical / 2;

        for (int i = 0; i < vertical; ++i) {
            if (grid[i][0] == 0) {
                for (int j = 0; j < horizon; ++j) {
                    if (grid[i][j] > 0) grid[i][j] = 0;
                    else grid[i][j] = 1;
                }
            }
        }

        int ans = 0;

        for (int j = 0; j < horizon; ++j) {
            int count = 0;
            int sum = 0;
            for (int i = 0; i < vertical; ++i) {
                if (grid[i][j] == 1) count++;
            }

            // System.out.println(j + " : j  = " + count + " : " + halfVertical);

            if (count <= halfVertical) {
                for (int i = 0; i < vertical; ++i) {
                    if (grid[i][j] > 0) grid[i][j] = 0;
                    else grid[i][j] = 1;
                }
            }
        }

        for (int i = 0; i < vertical; ++i) {
            int sum = 0;
            for (int j = 0; j < horizon; ++j) {
                sum = sum * 2 + grid[i][j];
            }
            ans += sum;
        }

        return ans;
    }
}
