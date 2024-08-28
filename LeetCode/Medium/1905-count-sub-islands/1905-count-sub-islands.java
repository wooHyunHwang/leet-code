class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {

        boolean[][] checkedIsland = new boolean[grid1.length][grid1[0].length];

        int count = 0;

        for (int i = 0; i < grid1.length; ++i) {
            for (int j = 0; j < grid1[0].length; ++j) {
                if (checkedIsland[i][j]) continue;

                // System.out.println("DFS====");
                if (grid2[i][j] == 1 && this.dfs(checkedIsland, grid1, grid2, i, j)) {
                    // System.out.println("찾음====");
                    count++;
                }
            }
        }

        return count;
    }

    private boolean dfs(boolean[][] checkedIsland,
                        int[][] grid1, int[][] grid2,
                        int i, int j) {
        // System.out.println("i : " + i + " ===== j : " + j);
        if (checkedIsland[i][j]) {
            // System.out.println("방문했었음.");
            return true;
        }
        // System.out.println(i + " : " + j);
        boolean check = true;
        checkedIsland[i][j] = true;
        if (grid2[i][j] == 1) {
            
            if (grid1[i][j] == 0) {
                // 포함된 섬이 아님
                check = false;
            }

            // 연결된 지역 검증하러
            // 상단
            // System.out.print("상단 === ");
            if (i > 0 && !this.dfs(
                checkedIsland,
                grid1, grid2,
                i-1, j
            )) {
                check = false;
            }

            // 하단
            // System.out.print("하단 === ");
            if (i < grid1.length-1 && !this.dfs(
                checkedIsland,
                grid1, grid2,
                i+1, j
            )) {
                check = false;
            }

            // 좌측
            // System.out.print("좌측 === ");
            if (j > 0 && !this.dfs(
                checkedIsland,
                grid1, grid2,
                i, j-1
            )) {
                check = false;
            }

            // 우측
            // System.out.print("우측 === " + "(" + j + " - " + grid1[0].length + " : " +  (j < grid1[0].length-1) + ")");
            if (j < grid1[0].length-1 && !this.dfs(
                checkedIsland,
                grid1, grid2,
                i, j+1
            )) {
                check = false;
            }
        }
        return check;
    }
}