class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] dictionary = new int[26];

        // char a == 97
        for (char d : magazine.toCharArray()) {
            dictionary[d - 'a']++;
        }

        for (char d : ransomNote.toCharArray()) {
            dictionary[d - 'a']--;
            if (dictionary[d - 'a'] < 0) return false;
        }

        return true;
    }
}