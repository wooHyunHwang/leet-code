class Solution {
    int m = 0;
    int n = 0;
    public boolean exist(char[][] board, String word) {

        m = board.length;
        n = board[0].length;

        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[i].length; ++j) {
                if (this.dfs(board, word, 0, i, j, new boolean[this.m][this.n])) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int wordIdx,
                        int i, int j, boolean[][] visited
    ) {
        // Out of Index
        if (i < 0 || j < 0 || i >= m || j >= n) return false;
        if (visited[i][j]) return false;

        if (board[i][j] == word.charAt(wordIdx)) {

            if (wordIdx == word.length() - 1) return true;

            visited[i][j] = true;

            if (this.dfs(board, word, wordIdx + 1, i + 1, j, visited)) return true;
            if (this.dfs(board, word, wordIdx + 1, i, j + 1, visited)) return true;
            if (this.dfs(board, word, wordIdx + 1, i - 1, j, visited)) return true;
            if (this.dfs(board, word, wordIdx + 1, i, j - 1, visited)) return true;

        }
        visited[i][j] = false;
        return false;
    }
}