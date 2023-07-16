class Solution {
    public int orangesRotting(int[][] grid) {
        int fresh = 0;
        Queue<List<int[]>> newZombie = new LinkedList<>();

        List<int[]> firstQueue = new ArrayList<>();

        for(int i = 0; i < grid.length; ++i) {
            for(int j = 0; j < grid[i].length; ++j) {
                if(grid[i][j] == 2) firstQueue.add(new int[] {i, j});
                else if (grid[i][j] == 1) fresh++;
            }
        }
        
        if(!firstQueue.isEmpty()) newZombie.add(firstQueue);
        else if(fresh > 0) return -1;
        else return 0;

        int turn = -1;

        while(!newZombie.isEmpty()) {
            
            List<int[]> zombie = newZombie.poll();
            List<int[]> nextZombie = new ArrayList<>();

            // Bite !!
            for(int i = 0; i < zombie.size(); ++i) {
                int x = zombie.get(i)[0];
                int y = zombie.get(i)[1];

                // x + 1
                if(this.checkBiteAble(grid, x+1, y)) {
                    grid[x+1][y] = 2;
                    fresh--;
                    nextZombie.add(new int[] {x+1, y});
                }

                // y + 1
                if(this.checkBiteAble(grid, x, y+1)) {
                    grid[x][y+1] = 2;
                    fresh--;
                    nextZombie.add(new int[] {x, y+1});
                }

                // x - 1
                if(this.checkBiteAble(grid, x-1, y)) {
                    grid[x-1][y] = 2;
                    fresh--;
                    nextZombie.add(new int[] {x-1, y});
                }

                // y - 1
                if(this.checkBiteAble(grid, x, y-1)) {
                    grid[x][y-1] = 2;
                    fresh--;
                    nextZombie.add(new int[] {x, y-1});
                }


            }

            if(!nextZombie.isEmpty()) newZombie.add(nextZombie);

            turn++;
        }

        return fresh == 0 ? turn : -1;
    }

    private boolean checkBiteAble(int[][] grid, int x, int y) {
        if(x < 0 || y < 0 || x >= grid.length || y >= grid[0].length) return false;
        else if (grid[x][y] == 1) return true;
        else return false;
    }
}