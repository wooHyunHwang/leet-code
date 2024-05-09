class Solution {
    public int deleteGreatestValue(int[][] grid) {
        for (int[] arr : grid) {
            Arrays.sort(arr);
        }
        int sum = 0;
        for (int j = grid[0].length-1; j > -1; --j) {
            int max = 0;
            for (int i = 0; i < grid.length; ++i) {
                if (max < grid[i][j]) max = grid[i][j];
            }
            sum += max;
        }
        return sum;
    }
}