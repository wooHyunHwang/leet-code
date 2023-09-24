class Solution {
    public int numIslands(char[][] grid) {
        int island = 0;
        int[][] map = new int[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[i].length; ++j) {

                

                if (grid[i][j] == '1') {

                    if (map[i][j] > 0) continue;

                    island++;
                    this.createIsland(grid, map, island, i, j);
                }
            }
        }
        

        return island;
    }

    private void createIsland(char[][] grid, int[][] map, int islandNo, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) return;
        if (map[i][j] > 0) return;
        if (grid[i][j] == '1') {
            // System.out.println(i + " - " + j + " : " + islandNo);
            map[i][j] = islandNo;

            this.createIsland(grid, map, islandNo, i-1, j);
            this.createIsland(grid, map, islandNo, i, j-1);
            this.createIsland(grid, map, islandNo, i+1, j);
            this.createIsland(grid, map, islandNo, i, j+1);
        }
    }
}