class Solution {
    char[][] dictionary = {
        {},
        {},
        {'a', 'b', 'c'},
        {'d', 'e', 'f'},
        {'g', 'h', 'i'},
        {'j', 'k', 'l'},
        {'m', 'n', 'o'},
        {'p', 'q', 'r', 's'},
        {'t', 'u', 'v'},
        {'w', 'x', 'y', 'z'},
    };
    public List<String> letterCombinations(String digits) {

        List<String> ans = new ArrayList<>();

        if(digits == null || digits.equals("")) return ans;
        
        char[] sArr = digits.toCharArray();

        char[] first = dictionary[this.charToInt(sArr[0])];

        for(int i = 0; i < first.length; ++i) {
            char[] keyword = new char[sArr.length];
            keyword[0] = first[i];

            this.dfs(ans, sArr, keyword, 1);

        }

        return ans;
    }

    private void dfs(List<String> ans, char[] sArr, char[] keyword, int depth) {
        if(depth >= sArr.length) {
            ans.add(new String(keyword));
            return;
        }

        char[] next = dictionary[this.charToInt(sArr[depth])];

        for(int i = 0; i < next.length; ++i) {
            char[] nextKeyword = new char[sArr.length];
            System.arraycopy(keyword, 0, nextKeyword, 0, depth);

            nextKeyword[depth] = next[i];

            this.dfs(ans, sArr, nextKeyword, depth + 1);
        }
    }

    private int charToInt(char c) {
        return c - '0';
    }
}