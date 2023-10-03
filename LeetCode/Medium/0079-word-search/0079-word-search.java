class Solution {
    int m = 0;
    int n = 0;
    public boolean exist(char[][] board, String word) {

        m = board.length;
        n = board[0].length;

        char[] wordChar = word.toCharArray();

        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[i].length; ++j) {
                if (this.dfs(board, wordChar, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, char[] wordChar, int wordIdx,
                        int i, int j
    ) {
        // Out of Index
        if (i < 0 || j < 0 || i >= m || j >= n) return false;
        if (board[i][j] == '!') return false;

        char temp = board[i][j];
        if (board[i][j] == wordChar[wordIdx]) {

            if (wordIdx == wordChar.length - 1) return true;

            board[i][j] = '!';

            if (this.dfs(board, wordChar, wordIdx + 1, i + 1, j)) return true;
            if (this.dfs(board, wordChar, wordIdx + 1, i, j + 1)) return true;
            if (this.dfs(board, wordChar, wordIdx + 1, i - 1, j)) return true;
            if (this.dfs(board, wordChar, wordIdx + 1, i, j - 1)) return true;

        }
        board[i][j] = temp;
        return false;
    }
}