class Solution {

    public static class Dictionary {

        public boolean[] word = new boolean[26];
        public SecondDictionary[] secondWord = new SecondDictionary[26];
        
        public Dictionary() {
            for (int i = 0; i < 26; ++i) {
                secondWord[i] = new SecondDictionary();
            }
        };

        public void setChar(char one, char two) {
            word[one - 'a'] = true;
            secondWord[one - 'a'].word[two - 'a'] = true;
        }

        public boolean checkChar(char one, char two) {
            return word[one - 'a'] && secondWord[one - 'a'].word[two - 'a'];
        }
    }

    public static class SecondDictionary {
        public boolean[] word = new boolean[26];

        public SecondDictionary() {};
    }

    private Dictionary dictionary = new Dictionary();

    public int maximumNumberOfStringPairs(String[] words) {
        int ans = 0;

        for (String s : words) {
            if (this.dictionary.checkChar(s.charAt(0), s.charAt(1))) ans++;
            this.dictionary.setChar(s.charAt(1), s.charAt(0));
        }

        return ans;
    }
}