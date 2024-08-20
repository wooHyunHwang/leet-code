class Solution {
    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < words.length; ++i) {
            if (words[i].indexOf(x) != -1) ans.add(i);
            /*
            for (char c : words[i].toCharArray()) {
                if (c == x) {
                    ans.add(i);
                    break;
                } 
            }
            */
        }
        return ans;
    }
}