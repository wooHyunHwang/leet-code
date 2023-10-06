class Solution {

    class Trie {
        public Trie[] trie;
        public String data;
        public boolean endOfWord;
        Trie() {
            this.trie = new Trie[26];
            this.data = null;
            this.endOfWord = false;
        }

        public void addWord(String s, char[] word, int index) {

            if (index >= word.length) {
                this.data = s;
                this.endOfWord = true;
                return;
            }

            Trie next = null;

            if (trie[word[index] - 'a'] != null) next = trie[word[index] - 'a'];
            else {
                next = new Trie();
                trie[word[index] - 'a'] = next;
            }

            next.addWord(s, word, index + 1);
        }
    }

    private List<String> ans = null;
    private int width = 0;
    private int height = 0;
    public List<String> findWords(char[][] board, String[] words) {
        // Trie 생성
        Trie dictionary = new Trie();

        // 초기화
        ans = new ArrayList<>();
        width = board.length;
        height = board[0].length;

        // 단어 사전 추가
        for (String s : words) dictionary.addWord(s, s.toCharArray(), 0);

        // board 반복돌면서 있는 단어 추가
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[i].length; ++j) {
                // System.out.println(" ====== ");
                this.dfs(board, i, j, dictionary);

            }
        }

        return ans;
    }

    private void dfs(char[][] board, int i, int j, Trie dictionary) {
        if (i < 0 || j < 0 || i >= width || j >= height) return;
        if (board[i][j] == '!') return;
        
        int index = board[i][j] - 'a';

        if (dictionary.trie[index] != null) {

            if (dictionary.trie[index].endOfWord) {
                dictionary.trie[index].endOfWord = false;
                ans.add(dictionary.trie[index].data);
            }

            // System.out.println("- " + board[i][j]);
            char temp = board[i][j];
            board[i][j] = '!';

            this.dfs(board, i+1, j, dictionary.trie[index]);
            this.dfs(board, i-1, j, dictionary.trie[index]);
            this.dfs(board, i, j+1, dictionary.trie[index]);
            this.dfs(board, i, j-1, dictionary.trie[index]);

            board[i][j] = temp;
        }
    }
}