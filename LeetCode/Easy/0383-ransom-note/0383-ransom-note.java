class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] dictionary = new int[26];

        // char a == 97
        for (int i = 0; i < magazine.length(); ++i) {
            dictionary[magazine.charAt(i) - 'a']++;
        }

        for (int i = 0; i < ransomNote.length(); ++i) {
            dictionary[ransomNote.charAt(i) - 'a']--;
            if (dictionary[ransomNote.charAt(i) - 'a'] < 0) return false;
        }

        return true;
    }
}