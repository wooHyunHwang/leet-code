class Solution {
    int[] entranceArr = null;
    public int nearestExit(char[][] maze, int[] entrance) {

        entranceArr = entrance;

        // System.out.println("zzzzzzzzzzzzzzzz");

        int tryCount = 0;

        Queue<List<int[]>> tryList = new LinkedList<>();
        List<int[]> first = this.getExitMaze(maze);
        if(!first.isEmpty()) tryList.add(first);

        while(!tryList.isEmpty()) {

            // System.out.println("======= " + tryCount);

            List<int[]> current = tryList.poll();
            List<int[]> temp = new ArrayList<>();

            for(int i = 0; i < current.size(); ++i) {

                if(current.get(i)[0] == current.get(i)[2] &&
                 current.get(i)[1] == current.get(i)[3]) continue;

                int x = current.get(i)[0];
                int y = current.get(i)[1];

                // System.out.println("위치 : " + x + " / " + y);

                // case 1
                int check1 = this.checkPath(maze, x + 1, y);
                switch(check1) {
                    case 2: {
                        // find exit
                        return tryCount + 1;
                    }
                    case 1: {
                        int[] next = new int[4];
                        next[0] = x + 1;
                        next[1] = y;
                        next[2] = x;
                        next[3] = y;
                        temp.add(next);

                        maze[x+1][y] = '+';

                        break;
                    }
                }

                // case 2
                int check2 = this.checkPath(maze, x, y + 1);
                switch(check2) {
                    case 2: {
                        // find exit
                        return tryCount + 1;
                    }
                    case 1: {
                        int[] next = new int[4];
                        next[0] = x;
                        next[1] = y + 1;
                        next[2] = x;
                        next[3] = y;
                        temp.add(next);

                        maze[x][y+1] = '+';

                        break;
                    }
                }

                // case 3
                int check3 = this.checkPath(maze, x - 1, y);
                switch(check3) {
                    case 2: {
                        // find exit
                        return tryCount + 1;
                    }
                    case 1: {
                        int[] next = new int[4];
                        next[0] = x - 1;
                        next[1] = y;
                        next[2] = x;
                        next[3] = y;
                        temp.add(next);

                        maze[x-1][y] = '+';

                        break;
                    }
                }

                // case 4
                int check4 = this.checkPath(maze, x, y - 1);
                switch(check4) {
                    case 2: {
                        // find exit
                        return tryCount + 1;
                    }
                    case 1: {
                        int[] next = new int[4];
                        next[0] = x;
                        next[1] = y - 1;
                        next[2] = x;
                        next[3] = y;
                        temp.add(next);

                        maze[x][y-1] = '+';

                        break;
                    }
                }


            }

            if(!temp.isEmpty()) tryList.add(temp);
            tryCount++;
        }
        // System.out.println("404");

        return -1;
    }

    /**
     * 2: 길의 끝
     * 1: 길 있음
     * 0: 벽
     */
    private int checkPath(char[][] maze, int x, int y) {
        if(x == -1 || y == -1 || x >= maze.length || y >= maze[0].length) return 0;
        else if (this.entranceArr[0] == x && this.entranceArr[1] == y) return 2;
        else if(maze[x][y] == '.') return 1;
        else return 0;
    }

    private List<int[]> getExitMaze(char[][] maze) {

        List<int[]> ret = new ArrayList<>();

        for(int i = 0; i < maze.length; ++i) {
            if(maze[i][0] == '.') this.createStartArr(ret, i, 0);
            if(maze[i][maze[0].length - 1] == '.') this.createStartArr(ret, i, maze[0].length - 1);
        }

        for(int i = 1; i < maze[0].length - 1; ++i) {
            if(maze[0][i] == '.') this.createStartArr(ret, 0, i);
            if(maze[maze.length - 1][i] == '.') this.createStartArr(ret, maze.length - 1, i);
        }
        return ret;
    }

    private void createStartArr(List<int[]> ret, int i, int j) {
        if(this.entranceArr[0] == i && this.entranceArr[1] == j) return;
        int[] startArr = new int[4];
        startArr[0] = i;
        startArr[1] = j;
        startArr[2] = Integer.MAX_VALUE;
        startArr[3] = Integer.MAX_VALUE;
        ret.add(startArr);
    }
}