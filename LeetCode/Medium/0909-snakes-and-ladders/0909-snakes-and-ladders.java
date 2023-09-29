class Solution {
    private int max = 0;
    private Set<Integer> visit = new HashSet<>();
    public int snakesAndLadders(int[][] board) {
        
        this.max = board.length * board.length;
        this.visit = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        // 1회차 입력
        int check = 0;
        visit.add(1);
        for (int i = 1; i <= 6; ++i) {
            int next = moveTo(board, 1, i);
            if (next == max) return 1;
            else if (next == -1) continue;
            queue.add(next);
        }

        int count = 1;
        while(!queue.isEmpty()) {
            count++;
            Queue<Integer> nextQueue = new LinkedList<>();

            while(!queue.isEmpty()) {
                int curr = queue.poll();
                for (int i = 1; i <= 6; ++i) {
                    int next = moveTo(board, curr, i);
                    if (next == max) return count;
                    else if (next == -1) continue;
                    nextQueue.add(next);
                }
            }


            queue = nextQueue;
        }

        return -1;
    }

    private int moveTo(int[][] board, int start, int moveCount) {


        int ord = start + moveCount;

        if (visit.contains(ord)) return -1;
        else if (ord == this.max) return this.max;

        visit.add(ord);

        int c = this.calcColOrd(board.length, ord);
        int r = this.calcRowOrd(board.length, ord, c);

        if (board[c][r] == -1) return ord;
        else return board[c][r];
    }

    private int calcColOrd(int len, int index) {
        return len - (index - 1) / len - 1;
    }

    private int calcRowOrd(int len, int index, int col) {
        return (len - col) % 2 == 1 ? (index - 1) % len : len - (index - 1) % len - 1;
    }
}