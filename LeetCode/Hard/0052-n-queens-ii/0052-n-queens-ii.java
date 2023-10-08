class Solution {
    boolean[][] realVisited = null;
    int max = 0;
    int ans = 0;
    public int totalNQueens(int n) {
        if (n == 1) return 1;
        
        this.realVisited = new boolean[n][n];
        this.max = n;
        this.ans = 0;

        this.dfs(new boolean[this.max], new HashSet<>(), new HashSet<>(), 0, 0, 0);

        return this.ans;
    }

    private void dfs(boolean[] vertical, Set<Integer> diagonal, Set<Integer> diagonal2, int i, int j, int queen) {

        if (queen == this.max) {
            this.ans++;
            return;
        }
        if (j == this.max) return;

        if (!vertical[j] && !diagonal.contains(i-j) && !diagonal2.contains(i+j)) {
            boolean[] copyVertical = new boolean[this.max];
            System.arraycopy(vertical, 0, copyVertical, 0, this.max);

            copyVertical[j] = true;
            diagonal.add(i-j);
            diagonal2.add(i+j);

            this.dfs(copyVertical, diagonal, diagonal2, i + 1, 0, queen + 1);

            diagonal.remove(i-j);
            diagonal2.remove(i+j);
        }
        if (j < max - 1) {
            this.dfs(vertical, diagonal, diagonal2, i, j + 1, queen);
        }
    }

}