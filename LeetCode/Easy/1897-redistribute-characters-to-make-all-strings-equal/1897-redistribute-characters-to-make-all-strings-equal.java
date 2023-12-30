class Solution {
    public boolean makeEqual(String[] words) {

        int[] his = new int[26];

        for (String s : words) {
            for (char c : s.toCharArray()) {
                his[c - 'a']++;
            }
        }

        for (int count : his) {
            if (count % words.length != 0) return false;
        }
        return true;
    }
}